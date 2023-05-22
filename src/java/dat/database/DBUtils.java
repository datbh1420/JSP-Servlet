package dat.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils implements Serializable{
    public static Connection makeConnection(){
        
        try{
            
            Context ctx = new InitialContext();
              Context envCtx = (Context) ctx.lookup("java:comp/env");
              DataSource ds = (DataSource) envCtx.lookup("SE1740SP23");
              Connection con = ds.getConnection();
              return con;
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url="jdbc:sqlserver://localhost:1433;databaseName=SE1740SP23";
//            Connection con = DriverManager.getConnection(url,"sa","12345");
//            return con;
        } catch(NamingException ex){
            ex.printStackTrace();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
        
    }
}


