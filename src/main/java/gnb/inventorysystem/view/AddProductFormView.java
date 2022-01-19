package gnb.inventorysystem.view;

import gnb.inventorysystem.App;
import gnb.inventorysystem.model.Product;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductFormView  implements Initializable {
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

    /* BEGIN    <--- Button FXML section ---> */
    @FXML
    private Button addProductButtonAdd;

    @FXML
    private void productAdd(ActionEvent e) {
        System.out.println("Implement productAdd button action!");
    }

    @FXML
    private Button addProductButtonRemove;

    @FXML
    private void productRemove(ActionEvent e) {
        System.out.println("Implement productRemove button action!");
    }
    @FXML
    private Button addProductButtonSave;

    @FXML
    private void productSave(ActionEvent e) {
        System.out.println("Implement productSave button action!");
    }

    @FXML
    private Button addProductButtonCancel;

    @FXML
    private void productCancel(ActionEvent e) throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Main-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inventory App 1.0");
        stage.show();
    }
    /* END      <--- Button FXML section ---> */

    /* BEGIN    <--- Table FXML Section ---> */
    @FXML
    private TableView<Product> addProductTableAdd;

    @FXML
    private TableColumn<Product, Integer> addProductTableAddColumnId;

    @FXML
    private TableColumn<Product, String> addProductTableAddColumnName;

    @FXML
    private TableColumn<Product, Integer> addProductTableAddColumnInventory;

    @FXML
    private TableColumn<Product, Double> addProductTableAddColumnPrice;

    @FXML
    private TableView<Product> addProductTableRemove;

    @FXML
    private TableColumn<Product, Integer> addProductTableRemoveColumnId;

    @FXML
    private TableColumn<Product, String> addProductTableRemoveColumnName;

    @FXML
    private TableColumn<Product, Integer> addProductTableRemoveColumnInventory;

    @FXML
    private TableColumn<Product, Double> addProductTableRemoveColumnPrice;
    /* End      <--- Table FXML Section ---> */

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
