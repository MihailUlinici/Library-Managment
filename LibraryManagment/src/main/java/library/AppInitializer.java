package library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppInitializer.class.getResource("LogIn-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 470, 395);
        stage.setTitle("Authentication!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}