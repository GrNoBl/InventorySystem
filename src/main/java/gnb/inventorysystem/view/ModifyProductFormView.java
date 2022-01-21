package gnb.inventorysystem.view;

import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.viewmodel.CommonViewModel;
import gnb.inventorysystem.viewmodel.ModifyProductFormViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductFormView implements Initializable {
    private final CommonViewModel cVM = CommonViewModel.getInstance();
    private final ObservableList<Part> partsAvailable = FXCollections.observableArrayList();
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
    private void partsSearch(KeyEvent k) {
        if (k.getCode().equals(KeyCode.ENTER)) {
            ObservableList<Part> foundParts = cVM.searchPart(modifyProductFieldSearch.getText());
            modifyProductTableAdd.setItems(foundParts);
        }
    }

    @FXML
    private void partAdd(ActionEvent e) {
        if (modifyProductTableAdd.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        Part selection = modifyProductTableAdd.getSelectionModel().getSelectedItem();
        partsToBeAdded.add(selection);
    }

    @FXML
    private void partRemove(ActionEvent e) {
        if (modifyProductTableRemove.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        Part selection = modifyProductTableRemove.getSelectionModel().getSelectedItem();
        partsToBeAdded.remove(selection);    }

    @FXML
    private void productSave(ActionEvent e) throws IOException {
        boolean success = ModifyProductFormViewModel.modifyProduct(modifyProductFieldId,
                modifyProductFieldName,
                modifyProductFieldPrice,
                modifyProductFieldInventory,
                modifyProductFieldMax,
                modifyProductFieldMin,
                cVM,
                modifyProductTableRemove);

        if (success) {
            ViewUtility.returnToMainMenu();
        }
    }

    @FXML
    private void productCancel(ActionEvent e) throws IOException {
        ViewUtility.returnToMainMenu();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partsAvailable.addAll(cVM.getAllParts());
        modifyProductTableAdd.setItems(partsAvailable);
        modifyProductTableAddColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        modifyProductTableAddColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        modifyProductTableAddColumnInventory.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        modifyProductTableAddColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        ModifyProductFormViewModel.preLoadProduct(modifyProductFieldId,
                modifyProductFieldName,
                modifyProductFieldPrice,
                modifyProductFieldInventory,
                modifyProductFieldMax,
                modifyProductFieldMin,
                cVM,
                partsToBeAdded,
                modifyProductTableRemove);
        modifyProductTableRemoveColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        modifyProductTableRemoveColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        modifyProductTableRemoveColumnInventory.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        modifyProductTableRemoveColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }
}
