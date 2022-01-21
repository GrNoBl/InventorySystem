package gnb.inventorysystem.view;

import gnb.inventorysystem.App;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.model.Product;
import gnb.inventorysystem.viewmodel.CommonViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductFormView implements Initializable {
    private final CommonViewModel cVM = CommonViewModel.getInstance();
    private final ObservableList<Part> partsToBeAdded = FXCollections.observableArrayList();

    @FXML
    private TextField modifyProductFieldId;
    @FXML
    private TextField modifyProductFieldName;
    @FXML
    private TextField modifyProductFieldInventory;
    @FXML
    private TextField modifyProductFieldPrice;
    @FXML
    private TextField modifyProductFieldMax;
    @FXML
    private TextField modifyProductFieldMin;
    @FXML
    private TextField modifyProductFieldSearch;
    @FXML
    private Button modifyProductButtonAdd;
    @FXML
    private Button modifyProductButtonRemove;
    @FXML
    private Button modifyProductButtonSave;
    @FXML
    private Button modifyProductButtonCancel;
    @FXML
    private TableView<Part> modifyProductTableAdd;
    @FXML
    private TableColumn<Part, Integer> modifyProductTableAddColumnId;
    @FXML
    private TableColumn<Part, String> modifyProductTableAddColumnName;
    @FXML
    private TableColumn<Part, Integer> modifyProductTableAddColumnInventory;
    @FXML
    private TableColumn<Part, Double> modifyProductTableAddColumnPrice;
    @FXML
    private TableView<Part> modifyProductTableRemove;
    @FXML
    private TableColumn<Part, Integer> modifyProductTableRemoveColumnId;
    @FXML
    private TableColumn<Part, String> modifyProductTableRemoveColumnName;
    @FXML
    private TableColumn<Part, Integer> modifyProductTableRemoveColumnInventory;
    @FXML
    private TableColumn<Part, Double> modifyProductTableRemoveColumnPrice;

    @FXML
    private void productAdd(ActionEvent e) {
        System.out.println("Implement productAdd button action!");
    }

    @FXML
    private void productRemove(ActionEvent e) {
        System.out.println("Implement productRemove button action!");
    }

    @FXML
    private void productSave(ActionEvent e) throws IOException {
        ViewUtility.returnToMainMenu();
    }
    @FXML
    private void productCancel(ActionEvent e) throws IOException {
        ViewUtility.returnToMainMenu();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Setup product to be modified table contents here.

        modifyProductTableRemove.setItems(partsToBeAdded);
        modifyProductTableRemoveColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        modifyProductTableRemoveColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        modifyProductTableRemoveColumnInventory.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        modifyProductTableRemoveColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }
}
