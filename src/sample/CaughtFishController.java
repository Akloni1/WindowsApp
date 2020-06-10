package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.animation.Shake;

public class CaughtFishController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView karasImaige;

    @FXML
    private Button ButtonPull;

    @FXML
    private Button CloseFishing;

    @FXML
    void initialize() {
        ButtonPull.setOnAction(event -> {
            signUpNewUser();


            ButtonPull.getScene().getWindow().hide();//прячем начальное окно регестрации
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/BuyFishingRod.fxml"));//метод позволяет указать место расположения нужного нам файла
            try {
                loader.load(); // здесь мы загружаем наш файл для дальнейшего отображения
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot(); // переменной рут мы присваеваем файл
            Stage stage = new Stage();
            stage.setScene(new Scene(root));//указываем окно которое нам нужно загрузить
            //  stage.showAndWait();
            stage.show();
        });


        CloseFishing.setOnAction(event -> {
            signUpNewUser();
           // DatabaseHandlerFish dbHandler = new DatabaseHandlerFish();
           // ResultSet result = dbHandler.getUser();
            CloseFishing.getScene().getWindow().hide();//прячем начальное окно регестрации


DatabaseHandler table= new DatabaseHandler();
            Collection col = null;
            try {
                col = table.getTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Вы поймали следующий список рыб:");
            for(Object o : col) {
                System.out.println(o);
            }


            try {
                table.delete();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    private void signUpNewUser() {
        DatabaseHandlerFish dbHandlerFish = new DatabaseHandlerFish();
        String fishName = "Карась";


        User user = new User(fishName);

        dbHandlerFish.signUpUser(user);
    }


   /* private void nameFish(String nameFish1, String nameFish2) {
        DatabaseHandlerFish dbHandler = new DatabaseHandlerFish();
        User user = new User();
        user.setUserName(nameFish1);//loginText то что мы вводим в поле пароля при авторизации
        user.setPassword(nameFish2);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        try {
            while (result.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }*/

}

