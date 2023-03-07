package rw.ac.rca.jsps;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.util.logging.Logger;

public class DataSourceFactory {
    public final DataSource daso;
    private static final Logger LOGGER = Logger.getLogger(DataSourceFactory.class.getName());

    public DataSourceFactory(DataSource daso) {
        this.daso = daso;
    }
}
