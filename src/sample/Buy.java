package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.animation.EnterShake;
import sample.animation.Shake;
import javafx.scene.control.Label;



public class Buy {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ButtonBuy;

    @FXML
    private ImageView imageButtonHome1881;

    @FXML
    private Button authSigInButton136;

    @FXML
    void initialize() {
        authSigInButton136.setOnAction(event -> {

        Fish fish = new Fish();
        if(fish.caughtFish().equals("Karas")){
           // FXMLLoader loader= new FXMLLoader();


                authSigInButton136.getScene().getWindow().hide();//прячем начальное окно регестрации
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/CaughtFish.fxml"));//метод позволяет указать место расположения нужного нам файла
                try {
                    loader.load(); // здесь мы загружаем наш файл для дальнейшего отображения
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot(); // переменной рут мы присваеваем файл
                Stage stage= new Stage();
                stage.setScene(new Scene(root));//указываем окно которое нам нужно загрузить
            stage.show();
              //  stage.showAndWait();

        }

        else {
       authSigInButton136.getScene().getWindow().hide();//прячем начальное окно регестрации
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/CaughtFish1.fxml"));//метод позволяет указать место расположения нужного нам файла
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

        }
        });
    }
}