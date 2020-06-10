package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageButtonHome11;

    @FXML
    private Button authSigInButton;

    @FXML
    void initialize() {
        authSigInButton.setOnAction(event -> {
            authSigInButton.getScene().getWindow().hide();//прячем начальное окно регестрации
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/BuyFishingRod.fxml"));//метод позволяет указать место расположения нужного нам файла
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
}
