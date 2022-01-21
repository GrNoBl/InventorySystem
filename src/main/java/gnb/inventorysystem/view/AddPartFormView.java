package gnb.inventorysystem.view;

import gnb.inventorysystem.viewmodel.AddPartFormViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPartFormView implements Initializable {
    @FXML
    private Label addPartLabelToggle;
    @FXML
    private RadioButton addPartRadioInHouse;
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
    private TextField addPartFieldToggle;

    @FXML
    private void toggleMachineId(ActionEvent e) {
        addPartLabelToggle.setText("Machine Id");
    }

    @FXML
    private void toggleCompanyName(ActionEvent e) {
        addPartLabelToggle.setText("Company Name");
    }

    @FXML
    private void saveAdd(ActionEvent e) throws IOException{
        boolean success = AddPartFormViewModel.addPart(addPartFieldName,
                addPartFieldPrice,
                addPartFieldInventory,
                addPartFieldMax,
                addPartFieldMin,
                addPartFieldToggle,
                addPartRadioInHouse);

        if (success) {
            ViewUtility.returnToMainMenu();
        }
    }

    @FXML
    private void cancelAdd(ActionEvent e) throws IOException {
        ViewUtility.returnToMainMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
