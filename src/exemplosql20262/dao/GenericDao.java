/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplosql20262.dao;

/**
 *
 * @author lecol
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

    private Connection c;

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        String hostName = "localhost";
        String dbName = "exemplobd120262";
        String user = "leandro";
        String senha = "12345678";
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        c = DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;", hostName, dbName, user, senha));

        return c;
    }

}
