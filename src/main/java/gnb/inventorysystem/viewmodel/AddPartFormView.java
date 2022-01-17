package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import java.util.Objects;
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

    @FXML
    private Button addPartButtonSave;

    @FXML
    private Button addPartButtonCancel;

    private final AddPartFormViewModel viewModel = new AddPartFormViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addPartButtonCancel.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){
                Stage stage = (Stage) addPartButtonCancel.getScene().getWindow();
                try {
                    Parent parent = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("view/Main-Form.fxml")));
                    stage.getScene().setRoot(parent);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
