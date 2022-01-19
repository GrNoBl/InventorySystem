package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.App;
import gnb.inventorysystem.model.Part;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormView implements Initializable {
    @FXML
    private TextField mainFormPartsSearch;

    @FXML
    private TextField mainFormProductsSearch;

    /* START <--- Buttons FXML section ---> */
    @FXML
    private Button mainFormPartsAdd;

    @FXML
    private void partsAdd(ActionEvent event) throws IOException {
            Stage stage = App.getAppStage();
            Parent root = FXMLLoader.load(App.class.getResource("Add-Part-Form.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private Button mainFormPartsModify;

    @FXML
    private void partsModify(ActionEvent event) throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Modify-Part-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button mainFormPartsRemove;

    @FXML
    private void partsRemove(ActionEvent event) throws IOException {
        System.out.println("Implement partsRemove button action!");
    }

    @FXML
    private Button mainFormProductAdd;

    @FXML
    private void productsAdd(ActionEvent event) throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Add-Product-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button mainFormProductModify;

    @FXML
    private void productModify(ActionEvent event) throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Modify-Product-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button mainFormProductRemove;

    @FXML
    private void productsRemove(ActionEvent event) throws IOException {
        System.out.println("Implement productsRemove button action!");
    }
    /* End <--- Buttons FXML section ---> */

    @FXML
    private TableView<Part> mainFormPartsTable;

    @FXML
    private TableColumn<Part, Integer> mainFormPartsTableColumnId;

    @FXML
    private TableColumn<Part, String> mainFormPartsTableColumnName;

    @FXML
    private TableColumn<Part, Integer> mainFormPartsTableColumnInventory;

    @FXML
    private TableColumn<Part, Double> mainFormPartsTableColumnPrice;

    @FXML
    private TableView<Product> mainFormProductsTable;

    @FXML
    private TableColumn<Product, Integer> mainFormProductTableColumnId;

    @FXML
    private TableColumn<Product, String> mainFormProductTableColumnName;

    @FXML
    private TableColumn<Product, Integer> mainFormProductTableColumnInventory;

    @FXML
    private TableColumn<Product, Double> mainFormProductTableColumnPrice;

    private final MainFormViewModel viewModel = new MainFormViewModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainFormPartsTableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        mainFormPartsTableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        mainFormPartsTableColumnInventory.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        mainFormPartsTableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        mainFormPartsTable.getItems().addAll(viewModel.allParts);

        mainFormProductTableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        mainFormProductTableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        mainFormProductTableColumnInventory.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        mainFormProductTableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        mainFormProductsTable.getItems().addAll(viewModel.allProducts);

    }

}
