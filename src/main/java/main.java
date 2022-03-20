import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String args[]) throws SQLException {
        Statement statement = new DataBase().get();
        statement.execute("DROP TABLE IF EXISTS TEST; CREATE TABLE TEST(ID INT PRIMARY KEY, FIRST_NAME VARCHAR(255), AGE INT); INSERT INTO TEST VALUES(1, 'Name1', 20); INSERT INTO TEST VALUES(2, 'Name2', 21);");
        ResultSet rs = statement.executeQuery("SELECT * FROM TEST");
        rs.next();
        System.out.println(rs.getString(2) + " " + rs.getInt(3));
        rs = statement.executeQuery("SELECT FIRST_NAME FROM TEST");
        rs.next();
        System.out.println(rs.getString(1));
        rs.next();
        System.out.println(rs.getString(1));
        statement.execute("INSERT INTO TEST VALUES(3, 'Jss', 33);");
        rs = statement.executeQuery("SELECT * FROM TEST");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " "+rs.getString(2) + " " + rs.getInt(3));
        }
    }
}