package gnb.inventorysystem.viewmodel;

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

public class ModifyProductFormView implements Initializable {
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

    /* BEGIN    <--- Button FXML section ---> */
    @FXML
    private Button modifyProductButtonAdd;

    @FXML
    private void productAdd(ActionEvent e) {
        System.out.println("Implement productAdd button action!");
    }

    @FXML
    private Button modifyProductButtonRemove;

    @FXML
    private void productRemove(ActionEvent e) {
        System.out.println("Implement productRemove button action!");
    }
    @FXML
    private Button modifyProductButtonSave;

    @FXML
    private void productSave(ActionEvent e) {
        System.out.println("Implement productSave button action!");
    }

    @FXML
    private Button modifyProductButtonCancel;

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
    private TableView<Product> modifyProductTableAdd;

    @FXML
    private TableColumn<Product, Integer> modifyProductTableAddColumnId;

    @FXML
    private TableColumn<Product, String> modifyProductTableAddColumnName;

    @FXML
    private TableColumn<Product, Integer> modifyProductTableAddColumnInventory;

    @FXML
    private TableColumn<Product, Double> modifyProductTableAddColumnPrice;

    @FXML
    private TableView<Product> modifyProductTableRemove;

    @FXML
    private TableColumn<Product, Integer> modifyProductTableRemoveColumnId;

    @FXML
    private TableColumn<Product, String> modifyProductTableRemoveColumnName;

    @FXML
    private TableColumn<Product, Integer> modifyProductTableRemoveColumnInventory;

    @FXML
    private TableColumn<Product, Double> modifyProductTableRemoveColumnPrice;
    /* End      <--- Table FXML Section ---> */

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

}
