package rw.ac.rca.jsps;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSourceFactory {
    public final DataSource daso;
    private static final Logger LOGGER = Logger.getLogger(DataSourceFactory.class.getName());

    public DataSourceFactory() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        String rootPath =
                Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("database.properties")).getPath();
        InputStream input = null;
        try{
            input = new FileInputStream(rootPath);
            Properties properties = new Properties();
            properties.load(input);
            mysqlDataSource.setDatabaseName(properties.getProperty("database"));
            mysqlDataSource.setServerName(properties.getProperty("serverName"));
            mysqlDataSource.setPort(Integer.parseInt(properties.getProperty("port")));
            mysqlDataSource.setUser(properties.getProperty("user"));
            mysqlDataSource.setPassword(properties.getProperty("password"));

        }

        //exception occurs when file database.properties not found
        catch (FileNotFoundException fe) {
            //just log the exceptions for simplicity
            LOGGER.log(Level.SEVERE, "File database.properties not found", fe);
        }
        catch (IOException ioe) {
            LOGGER.log(Level.SEVERE, "IO Error", ioe);
        }
        finally {
            if(input != null){
                try{
                    input.close();
                } catch (IOException ioe) {
                    LOGGER.log(Level.SEVERE, "Failed to close streams", ioe);
                }
            }
        }
        this.daso = mysqlDataSource;
    }
    public static Connection getConnection() throws SQLException{
        return (Connection) Helper.INSTANCE.daso.getConnection();
    }
    private static class Helper{
        private static final DataSourceFactory INSTANCE = new DataSourceFactory();
    }
}