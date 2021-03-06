package gnb.inventorysystem;

import gnb.inventorysystem.model.InHouse;
import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Outsourced;
import gnb.inventorysystem.model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * @author Griffin Blinco
 * Starts the application with a stage and starts the first scene.
 * Also preloads parts and products used for UI testing.
 * FUTURE ENHANCEMENT: Would benefit for database backend to provide saving application state.
 */
public class App extends Application {
    private static Stage appStage;

    @Override
    public void start(Stage stage) throws IOException {
        appStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Main-Form.fxml"));
        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.setTitle("Inventory App 1.0");
        appStage.setResizable(false);
        appStage.show();
    }

    public static Stage getAppStage() {
        return appStage;
    }

    public static void main(String[] args) {
        InHouse tvScreen = new InHouse(3,"TV Screen", 300.00, 5, 1, 20,
                101);
        InHouse tvShell = new InHouse(4,"TV Shell", 100.00, 5, 1, 20,
                101);
        InHouse powerCord = new InHouse(5,"Power Cord", 2.99, 5, 1, 20,
                101);
        Outsourced remote = new Outsourced(7, "Remote Control",29.99, 50, 30,
                100, "Panasonic");
        Inventory.addPart(tvScreen);
        Inventory.addPart(tvShell);
        Inventory.addPart(powerCord);
        Inventory.addPart(remote);

        //Add sample product
        Product television = new Product(1, "LCD Television", 499.99, 20, 20,
                100);
        television.addAssociatedPart(tvScreen);
        television.addAssociatedPart(tvShell);
        television.addAssociatedPart(powerCord);
        television.addAssociatedPart(remote);
        Inventory.addProduct(television);

        launch();
    }
}