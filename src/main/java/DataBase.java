import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;

class DataBase {
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        driverManagerDataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        driverManagerDataSource.setUsername("user");
        driverManagerDataSource.setPassword("user");
        return driverManagerDataSource;
    }
    Statement get() throws SQLException {
        return dataSource().getConnection().createStatement();
    }
}
