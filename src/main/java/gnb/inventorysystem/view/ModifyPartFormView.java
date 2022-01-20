package gnb.inventorysystem.view;

import gnb.inventorysystem.App;
import gnb.inventorysystem.model.InHouse;
import gnb.inventorysystem.model.Outsourced;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.viewmodel.CommonViewModel;
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
    private final CommonViewModel cmv = CommonViewModel.getInstance();

    private void preLoadPart() {
        Part part = cmv.partToBeModified;
        if (part instanceof InHouse) {
            modifyPartRadioInHouse.setSelected(true);
            modifyPartFieldId.setText(Integer.toString(part.getId()));
            modifyPartFieldName.setText(part.getName());
            modifyPartFieldInventory.setText(Integer.toString(part.getStock()));
            modifyPartFieldPrice.setText(Double.toString(part.getPrice()));
            modifyPartFieldMax.setText(Integer.toString(part.getMax()));
            modifyPartFieldMin.setText(Integer.toString(part.getMin()));
            modifyPartFieldToggle.setText(Integer.toString(((InHouse) part).getMachineId()));
        } else {
            modifyPartRadioOutsourced.setSelected(true);
            modifyLabelToggle.setText("Company Name");
            modifyPartFieldId.setText(Integer.toString(part.getId()));
            modifyPartFieldName.setText(part.getName());
            modifyPartFieldInventory.setText(Integer.toString(part.getStock()));
            modifyPartFieldPrice.setText(Double.toString(part.getPrice()));
            modifyPartFieldMax.setText(Integer.toString(part.getMax()));
            modifyPartFieldMin.setText(Integer.toString(part.getMin()));
            modifyPartFieldToggle.setText(((Outsourced) part).getCompanyName());
        }
    }

    private void returnToMainScene() throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Main-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inventory App 1.0");
        stage.show();
    }

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

    /* BEGIN <--- Buttons FXML section ---> */
    @FXML
    private Button modifyPartButtonSave;

    @FXML void saveModify(ActionEvent e) throws IOException{
        int id = Integer.parseInt(modifyPartFieldId.getText());
        String name = modifyPartFieldName.getText();
        int inv = Integer.parseInt(modifyPartFieldInventory.getText());
        Double price = Double.parseDouble(modifyPartFieldPrice.getText());
        int max = Integer.parseInt(modifyPartFieldMax.getText());
        int min = Integer.parseInt(modifyPartFieldMin.getText());

        if (modifyPartRadioInHouse.isSelected()) {
            int machineId = Integer.parseInt(modifyPartFieldToggle.getText());
            InHouse modifiedPart = new InHouse(id, name, price, inv, min, max, machineId);
            viewModel.addPart(modifiedPart);
        } else {
            String companyName = modifyLabelToggle.getText();
            Outsourced modifiedPart = new Outsourced(id, name, price, inv, min, max, companyName);
            viewModel.addPart(modifiedPart);
        }

        viewModel.removePart(cmv.partToBeModified);
        returnToMainScene();
    }

    @FXML
    private Button modifyPartButtonCancel;

    @FXML
    private void cancelModify(ActionEvent e) throws IOException {
        returnToMainScene();
    }
    /* BEGIN <--- Buttons FXML section ---> */

    private final ModifyPartFormViewModel viewModel = new ModifyPartFormViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        preLoadPart();
    }
}
