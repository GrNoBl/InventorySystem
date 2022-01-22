package gnb.inventorysystem.view;

import gnb.inventorysystem.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * A static class to provide utility to controllers such as returning to main form & common alerts.
 */
public final class ViewUtility {
    private ViewUtility(){}

    public static void returnToMainMenu() throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Main-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inventory App 1.0");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * A utility method to display a specific alert.
     * @param type, given specific string describing situation, proper alert with be raised.
     * @return returns the alert dialog so that user interaction can be retrieved.
     */
    public static Optional<ButtonType> displayAlert(String type) {
        Alert warning = new Alert(Alert.AlertType.WARNING);
        Alert error = new Alert(Alert.AlertType.ERROR);
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);

        switch (type) {
            case "confirmation part delete" -> {
                confirmation.setTitle("Delete part?");
                confirmation.setHeaderText("You are attempting to delete the highlighted part, proceed?");
                return confirmation.showAndWait();
            }
            case "confirmation product delete" -> {
                confirmation.setTitle("Delete product?");
                confirmation.setHeaderText("You are attempting to delete the highlighted product, proceed?");
                return confirmation.showAndWait();
            }
            case "missing part" -> {
                warning.setTitle("Warning!");
                warning.setHeaderText("Part not found");
                return warning.showAndWait();
            }
            case "missing product" -> {
                warning.setTitle("Warning!");
                warning.setHeaderText("Product not found");
                return warning.showAndWait();
            }
            case "product has parts" -> {
                error.setTitle("Error");
                error.setHeaderText("Parts associated");
                error.setContentText("All parts must be removed from product before deletion.");
                return error.showAndWait();
            }

            case "input missing" -> {
                error.setTitle("Error");
                error.setHeaderText("Missing values");
                error.setContentText("All fields must be filled out.");
                return error.showAndWait();
            }

            case "numeric input expected" -> {
                error.setTitle("Error");
                error.setHeaderText("Non numeric data found");
                error.setContentText("Inventory, Price, Max, Min, Machine Id all must have numeric values.");
                return error.showAndWait();
            }

            case "min greater than max" -> {
                error.setTitle("Error");
                error.setHeaderText("Min max invalid");
                error.setContentText("Max must be greater or equal to min.");
                return error.showAndWait();
            }

            case "inv out of range" -> {
                error.setTitle("Error");
                error.setHeaderText("Inventory out of range");
                error.setContentText("Inventory must be between min and max values.");
                return error.showAndWait();
            }
        }

        error.setHeaderText("Improper error passed");
        return error.showAndWait();
    }
}
