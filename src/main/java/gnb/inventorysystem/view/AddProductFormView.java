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

public class AddProductFormView  implements Initializable {
    private final CommonViewModel cVM = CommonViewModel.getInstance();
    private ObservableList<Part> partsToBeAdded = FXCollections.observableArrayList();

    @FXML
    private TextField addProductFieldId;
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
    private Button addProductButtonAdd;
    @FXML
    private Button addProductButtonRemove;
    @FXML
    private Button addProductButtonSave;
    @FXML
    private Button addProductButtonCancel;
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
    private void productAdd(ActionEvent e) {
    }

    @FXML
    private void productRemove(ActionEvent e) {
        System.out.println("Implement productRemove button action!");
    }

    @FXML
    private void productSave(ActionEvent e) throws IOException{
        ViewUtility.returnToMainMenu();
    }
    @FXML
    private void productCancel(ActionEvent e) throws IOException {
        ViewUtility.returnToMainMenu();;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addProductTableAdd.setItems(cVM.getAllParts());
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
