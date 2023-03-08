package rw.ac.rca.jsps.dao;

import rw.ac.rca.jsps.DataSourceFactory;
import rw.ac.rca.jsps.User;
import sun.jvm.hotspot.code.Stub;

import javax.persistence.Id;
import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    private UserDAOImpl(){

    }
    private static class Helper{
        private static final UserDAOImpl INSTANCE = new UserDAOImpl();
    }
    public static UserDAOImpl getInstance(){
        return Helper.INSTANCE;
    }
    @Override
    public Optional<User> find(String Id) throws SQLException {
       String sqlQuery = "SELECT Id, Firstname, Lastname, Email, Password FROM user WHERE Id = ?";
       String id = "";
       String fname = "", lname = "", email = "", password = "";
        Connection connection = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, Id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            id = resultSet.getString("Id");
            fname = resultSet.getString("Firstname");
            lname = resultSet.getString("Lastname");
            email = resultSet.getString("Email");
            password = resultSet.getString("Password");

        }
        return Optional.of(new User(id, fname, lname, email, password ));
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        String sqlQuery = "SELECT Id, Firstname, Lastname, Email, Passwoord from user";
        Connection connection = DataSourceFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        if(resultSet.next()){
            String id = resultSet.getString("Id");
            String fname = resultSet.getString("Firstname");
            String lname = resultSet.getString("Lastname");
            String email = resultSet.getString("Email");
            String password = resultSet.getString("Password");

            User user = new User(id, fname, lname, email, password);
            users.add(user);

        }

        return users;
    }

    @Override
    public boolean save(User user) throws SQLException {
        String sqlQuery = "INSERT INTO user (Firstname, Lastname, Email, Password) values  (?,?,?,?)";
        boolean inserted = false;
        Connection connection = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1,user.getFname());
        preparedStatement.setString(2,user.getLname());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        inserted = preparedStatement.executeUpdate() > 0;
        return inserted;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sqlQuery = "UPDATE user SET Fname = ?, Lname = ?, Email = ? WHERE Id = ?";
        boolean updated;
        Connection connection = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1,user.getFname());
        preparedStatement.setString(2, user.getLname());
        preparedStatement.setString(3, user.getEmail());
        updated = preparedStatement.executeUpdate() > 0;

        return updated;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sqlQuery = "DELETE FROM stuff WHERE Id = ?";
        boolean deleted = false;
        Connection connection = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, user.getId());
        deleted = preparedStatement.executeUpdate() > 0;
        return deleted;
    }
}
