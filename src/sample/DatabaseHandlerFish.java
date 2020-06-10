package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandlerFish extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" +dbHost+":"
                +dbPort + "/" + dbName+ "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void signUpUser(User user){// метод записывает пользователя в базу данных
        String insert = "INSERT INTO" + Const.USER_TABLE1 + "("+ Const.NAME_FISH  + ")" +
                "VALUES(?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getNameFish());

            prSt.executeUpdate();//метод который закидывает в базу данных
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 /* public ResultSet getUser(){//возращает массив с данными какого либо пользователя или нескольких
       ResultSet resSet;

        String select = "SELECT COUNT(*) FROM intofish";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
           // prSt.setString(1, user.getUserName());
           // prSt.setString(2, user.getPassword());

            resSet =  prSt.executeQuery(); // все что получаем из БД присваваем пермнной resSet
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }*/
}
