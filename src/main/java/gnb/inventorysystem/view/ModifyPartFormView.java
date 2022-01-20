package gnb.inventorysystem.view;

import gnb.inventorysystem.model.InHouse;
import gnb.inventorysystem.model.Outsourced;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.viewmodel.CommonViewModel;
import gnb.inventorysystem.viewmodel.ModifyPartFormViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartFormView implements Initializable {
    private final CommonViewModel cVM = CommonViewModel.getInstance();

    @FXML
    private Label modifyLabelToggle;
    @FXML
    private RadioButton modifyPartRadioInHouse;
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

    @FXML
    private void toggleMachineId(ActionEvent e) {
        modifyLabelToggle.setText("Machine Id");
    }

    @FXML
    private void toggleCompanyName(ActionEvent e) {
        modifyLabelToggle.setText("Company Name");
    }

    @FXML void saveModify(ActionEvent e) throws IOException{
        ModifyPartFormViewModel.modifyPart(modifyPartFieldId,
                modifyPartFieldName,
                modifyPartFieldPrice,
                modifyPartFieldInventory,
                modifyPartFieldMax,
                modifyPartFieldMin,
                modifyPartFieldToggle,
                modifyPartRadioInHouse,
                cVM);
        ViewUtility.returnToMainMenu();;
    }

    @FXML
    private void cancelModify(ActionEvent e) throws IOException {
        ViewUtility.returnToMainMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ModifyPartFormViewModel.preLoadPart(modifyPartFieldId,
                modifyPartFieldName,
                modifyPartFieldPrice,
                modifyPartFieldInventory,
                modifyPartFieldMax,
                modifyPartFieldMin,
                modifyPartFieldToggle,
                modifyPartRadioInHouse,
                modifyPartRadioOutsourced,
                modifyLabelToggle,
                cVM);
    }
}
