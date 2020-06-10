package sample;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.Collection;

public class DatabaseHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" +dbHost+":"
                +dbPort + "/" + dbName+ "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void signUpUser(User user){// метод записывает пользователя в базу данных
        String insert = "INSERT INTOfishermen" + /*Const.USER_TABLE +*/ "("+ Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME +
                "," + Const.USERS_PASSWORD + "," + Const.USERS_LOCATION + "," + Const.USERS_GANDER + ")" +
                "VALUES(?,?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4,user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGender());

            prSt.executeUpdate();//метод который закидывает в базу данных
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){//возращает массив с данными какого либо пользователя или нескольких
        ResultSet resSet = null;
        /*String select = "SELECT  * FROM " + Const.USER_TABLE + "WHERE" +
                Const.USERS_USERNAME + "=?  AND" + Const.USERS_PASSWORD + "=?";*/
        String select = "SELECT  * FROM intofishermen WHERE username =? AND password =? ";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());

            resSet =  prSt.executeQuery(); // все что получаем из БД присваваем пермнной resSet
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

// вывод всех пойманых рыб
    public   Collection getTable()throws SQLException{
    String connectionString = "jdbc:mysql://" +dbHost+":"
            +dbPort + "/" + dbName+ "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query ="select * from fishing.intofish";
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
       // Collection col = new ArrayList();
        ObservableList col = FXCollections.observableArrayList();
        while (resultSet.next()){
            String name;
            name= resultSet.getString("namefish");
            col.add(name);
           // System.out.println(col.);
        }

        return col;
    }

//уделение рыб из таблицы после завершения ловли

    public   void delete()throws SQLException{
        String connectionString = "jdbc:mysql://" +dbHost+":"
                +dbPort + "/" + dbName+ "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query ="DELETE  FROM fishing.intofish ";
        Statement statement = dbConnection.createStatement();
     statement.executeUpdate(query);


    }

}
