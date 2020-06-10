package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animation.EnterShake;
import sample.animation.Shake;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button authSigInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize() {
        loginSignUpButton.setOnAction(event -> {//создаем действие для кнопки

       /*     EnterShake userLoginAnimEnter = new EnterShake(loginSignUpButton);
           userLoginAnimEnter.playAnim();*/

loginSignUpButton.getScene().getWindow().hide();//прячем начальное окно регестрации
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/singUp.fxml"));//метод позволяет указать место расположения нужного нам файла
            try {
                loader.load(); // здесь мы загружаем наш файл для дальнейшего отображения
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot(); // переменной рут мы присваеваем файл
            Stage stage= new Stage();
            stage.setScene(new Scene(root));//указываем окно которое нам нужно загрузить
          //  stage.showAndWait();
            stage.show();

        });
        authSigInButton.setOnAction(event -> {//создаем действие для кнопки
            String loginText = login_field.getText().trim();//трим удаляет лишние пробелы
            String loginPassword = password_field.getText().trim();
            if(!loginText.equals("")&&!loginPassword.equals(""))
                loginUser(loginText,loginPassword);
            else{
            Shake userLoginAnim =new Shake(authSigInButton);
            userLoginAnim.playAnim();}//позволяет трести кнопку входа если у наст не введен пароль


           /* authSigInButton.getScene().getWindow().hide();//прячем начальное окно регестрации
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/app.fxml"));//метод позволяет указать место расположения нужного нам файла
            try {
                loader.load(); // здесь мы загружаем наш файл для дальнейшего отображения
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot(); // переменной рут мы присваеваем файл
            Stage stage= new Stage();
            stage.setScene(new Scene(root));//указываем окно которое нам нужно загрузить
            stage.showAndWait();*/
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler=new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);//loginText то что мы вводим в поле пароля при авторизации
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        try{
            while (result.next()) {
                counter++;
            }
    } catch (SQLException e){
        e.printStackTrace();
    }
        if (counter>=1){
       authSigInButton.getScene().getWindow().hide();//прячем начальное окно регестрации
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/app.fxml"));//метод позволяет указать место расположения нужного нам файла
        try {
            loader.load(); // здесь мы загружаем наш файл для дальнейшего отображения
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot(); // переменной рут мы присваеваем файл
        Stage stage= new Stage();
        stage.setScene(new Scene(root));//указываем окно которое нам нужно загрузить

        //stage.showAndWait();
            stage.show();
        }
            else{
            Shake userLoginAnim =new Shake(authSigInButton);
        userLoginAnim.playAnim();}

    }
}


