package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animation.Shake;

public class SignUpController<node, signUpButton1> {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpCountry;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private Button signUpButton1;

    @FXML
    void initialize() {
       // DatabaseHandler dbHandler =new DatabaseHandler();
signUpButton.setOnAction(event ->{

    signUpNewUser();




});




       signUpButton1.setOnAction(event -> {//создаем действие для кнопки



          signUpButton1.getScene().getWindow().hide();//прячем начальное окно регестрации
          // signUpButton1.getScene().getWindow().;
                FXMLLoader loader= new FXMLLoader();
                loader.setLocation(getClass().getResource("sample.fxml"));//метод позволяет указать место расположения нужного нам файла
                try {
                    loader.load(); // здесь мы загружаем наш файл для дальнейшего отображения
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot(); // переменной рут мы присваеваем файл
                Stage stage= new Stage();
                stage.setScene(new Scene(root));//указываем окно которое нам нужно загрузить
               // stage.showAndWait();
           stage.show();



            });



    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler =new DatabaseHandler();
        String firstName = signUpName.getText();
        String lastName =signUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = signUpCountry.getText();
        String gender = "";
        if(signUpCheckBoxMale.isSelected())
        gender = "Мужской";
        else
            gender ="Женский";

        User user = new User(firstName, lastName, userName, password,location,gender  );
        if(firstName.equals("")&&lastName.equals("")&&userName.equals("")&&password.equals("")){
        Shake userLoginAnim =new Shake(signUpButton);
        userLoginAnim.playAnim();}
        else
        dbHandler.signUpUser(user);
    }
}
