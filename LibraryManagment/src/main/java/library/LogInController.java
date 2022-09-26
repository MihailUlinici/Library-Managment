package library;

import exceptions.InvalidCredentialException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    @FXML
    private Stage stage;


    @FXML
    private TextField userNameInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Label notification;

    final static private String userName="USER";
    final static private String password="user";

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void logIn(ActionEvent event){
        try {
            if ((userNameInput.getText().equals(userName)) && (passwordInput.getText().equals(password))) {
                Parent root = FXMLLoader.load(getClass().getResource("Library-View.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{
                throw new InvalidCredentialException("Please enter valid password and userName");
            }
        } catch (InvalidCredentialException ex) {
            notification.setText(ex.getMessage());
        } catch(IOException io){
            System.out.println(io.getMessage());
        }
    }
}
