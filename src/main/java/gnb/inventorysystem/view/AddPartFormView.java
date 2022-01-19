package gnb.inventorysystem.view;

import gnb.inventorysystem.App;
import gnb.inventorysystem.viewmodel.AddPartFormViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPartFormView implements Initializable {
    @FXML
    private RadioButton addPartRadioInHouse;

    @FXML
    private RadioButton addPartRadioOutsourced;

    @FXML
    private TextField addPartFieldId;

    @FXML
    private TextField addPartFieldName;

    @FXML
    private TextField addPartFieldInventory;

    @FXML
    private TextField addPartFieldPrice;

    @FXML
    private TextField addPartFieldMax;

    @FXML
    private TextField addPartFieldMin;

    @FXML
    private TextField addPartFieldMachineId;

    @FXML
    private TextField addPartFieldCompanyName;

    /* BEGIN <--- Buttons FXML section ---> */
    @FXML
    private Button addPartButtonSave;

    @FXML void saveAdd(ActionEvent e) {
        System.out.println("Implement saveAdd button action!");
    }

    @FXML
    private Button addPartButtonCancel;

    @FXML
    private void cancelAdd(ActionEvent e) throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Main-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inventory App 1.0");
        stage.show();
    }
    /* BEGIN <--- Buttons FXML section ---> */

    private final AddPartFormViewModel viewModel = new AddPartFormViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
