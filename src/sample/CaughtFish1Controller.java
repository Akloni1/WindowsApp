package sample;


        import java.io.IOException;
        import java.net.URL;
        import java.sql.SQLException;
        import java.util.Collection;
        import java.util.ResourceBundle;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.image.ImageView;
        import javafx.stage.Stage;

public class CaughtFish1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView karasImaige;

    @FXML
    private Button ButtonPull1;

    @FXML
    private Button CloseFishing1;

    @FXML
    void initialize() {
        ButtonPull1.setOnAction(event -> {
            signUpNewUser();


            ButtonPull1.getScene().getWindow().hide();//прячем начальное окно регестрации
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
            //  stage.showAndWait();
            stage.show();
        });

        CloseFishing1.setOnAction(event -> {
            signUpNewUser();
            CloseFishing1.getScene().getWindow().hide();//прячем начальное окно регестрации


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




         /*   FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/TableFish.fxml"));//метод позволяет указать место расположения нужного нам файла
            try {
                loader.load(); // здесь мы загружаем наш файл для дальнейшего отображения
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot(); // переменной рут мы присваеваем файл
            Stage stage= new Stage();
            stage.setScene(new Scene(root));//указываем окно которое нам нужно загрузить

            // stage.showAndWait();
            stage.show();*/






            try {
                table.delete();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        });

    }

    private void signUpNewUser() {
        DatabaseHandlerFish dbHandlerFish =new DatabaseHandlerFish();
        String fishName = "Ротан";


        User user = new User(fishName);

        dbHandlerFish.signUpUser(user);
    }
}
