package gnb.inventorysystem.view;

import gnb.inventorysystem.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class ViewUtility {
    private ViewUtility(){}

    public static void returnToMainMenu() throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Main-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inventory App 1.0");
        stage.show();
    }
}
