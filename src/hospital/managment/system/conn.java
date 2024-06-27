package hospital.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class conn {
    Connection connection;
    Statement statement;
    public conn(){
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managment_system","root","qwerty123");
            statement = connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
