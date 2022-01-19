package gnb.inventorysystem.view;

import gnb.inventorysystem.App;
import gnb.inventorysystem.viewmodel.ModifyPartFormViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartFormView implements Initializable {
    @FXML
    private Label modifyLabelToggle;

    @FXML
    private void toggleMachineId(ActionEvent e) {
        modifyLabelToggle.setText("Machine Id");
    }

    @FXML
    private void toggleCompanyName(ActionEvent e) {
        modifyLabelToggle.setText("Company Name");
    }

    @FXML
    private RadioButton modifyRadioInHouse;

    @FXML
    private RadioButton modifyPartRadioOutsourced;

    @FXML
    private TextField modifyPartFieldId;

    @FXML
    private TextField modifyPartFieldName;

    @FXML
    private TextField modifyPartFieldInventory;

    @FXML
    private TextField modifyPartFieldPrice;

    @FXML
    private TextField modifyPartFieldMax;

    @FXML
    private TextField modifyPartFieldMin;

    @FXML
    private TextField modifyPartFieldToggle;

    /* BEGIN <--- Buttons FXML section ---> */
    @FXML
    private Button modifyPartButtonSave;

    @FXML void saveModify(ActionEvent e) {
        System.out.println("Implement saveModify button action!");
    }

    @FXML
    private Button modifyPartButtonCancel;

    @FXML
    private void cancelModify(ActionEvent e) throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Main-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inventory App 1.0");
        stage.show();
    }
    /* BEGIN <--- Buttons FXML section ---> */

    private final ModifyPartFormViewModel viewModel = new ModifyPartFormViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
