package gnb.inventorysystem.view;

import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.viewmodel.AddProductFormViewModel;
import gnb.inventorysystem.viewmodel.CommonViewModel;
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

/**
 * The controller for interacting with the "Add Product" form.
 * Allows for adding or removing parts from a new product.
 * Implements saving product or canceling.
 */
public class AddProductFormView  implements Initializable {
    private final CommonViewModel cVM = CommonViewModel.getInstance();
    private final ObservableList<Part> partsAvailable = FXCollections.observableArrayList();
    private final ObservableList<Part> partsToBeAdded = FXCollections.observableArrayList();

    @FXML
    private TextField addProductFieldName;
    @FXML
    private TextField addProductFieldInventory;
    @FXML
    private TextField addProductFieldPrice;
    @FXML
    private TextField addProductFieldMax;
    @FXML
    private TextField addProductFieldMin;
    @FXML
    private TextField addProductFieldSearch;
    @FXML
    private TableView<Part> addProductTableAdd;
    @FXML
    private TableColumn<Part, Integer> addProductTableAddColumnId;
    @FXML
    private TableColumn<Part, String> addProductTableAddColumnName;
    @FXML
    private TableColumn<Part, Integer> addProductTableAddColumnInventory;
    @FXML
    private TableColumn<Part, Double> addProductTableAddColumnPrice;
    @FXML
    private TableView<Part> addProductTableRemove;
    @FXML
    private TableColumn<Part, Integer> addProductTableRemoveColumnId;
    @FXML
    private TableColumn<Part, String> addProductTableRemoveColumnName;
    @FXML
    private TableColumn<Part, Integer> addProductTableRemoveColumnInventory;
    @FXML
    private TableColumn<Part, Double> addProductTableRemoveColumnPrice;

    @FXML
    private void partsSearch(KeyEvent k) {
        if (k.getCode().equals(KeyCode.ENTER)) {
            ObservableList<Part> foundParts = cVM.searchPart(addProductFieldSearch.getText());
            addProductTableAdd.setItems(foundParts);
        }
    }

    @FXML
    private void partAdd(ActionEvent e) {
        if (addProductTableAdd.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        Part selection = addProductTableAdd.getSelectionModel().getSelectedItem();
        partsToBeAdded.add(selection);
    }

    @FXML
    private void partRemove(ActionEvent e) {
        if (addProductTableRemove.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        Part selection = addProductTableRemove.getSelectionModel().getSelectedItem();
        partsToBeAdded.remove(selection);
    }

    @FXML
    private void productSave(ActionEvent e) throws IOException{
        boolean success = AddProductFormViewModel.addProduct(addProductFieldName,
                addProductFieldPrice,
                addProductFieldInventory,
                addProductFieldMax,
                addProductFieldMin,
                addProductTableRemove);

        if (success) {
            ViewUtility.returnToMainMenu();
        }
    }
    @FXML
    private void productCancel(ActionEvent e) throws IOException {
        ViewUtility.returnToMainMenu();
    }

    /**
     * When initialized, associates first table with available parts and second table with new product parts.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partsAvailable.addAll(cVM.getAllParts());
        addProductTableAdd.setItems(partsAvailable);
        addProductTableAddColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        addProductTableAddColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        addProductTableAddColumnInventory.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        addProductTableAddColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        addProductTableRemove.setItems(partsToBeAdded);
        addProductTableRemoveColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        addProductTableRemoveColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        addProductTableRemoveColumnInventory.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        addProductTableRemoveColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }
}
