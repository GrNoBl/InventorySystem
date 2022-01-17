package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.App;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.model.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainFormView implements Initializable {
    @FXML
    private TextField mainFormPartsSearch;

    @FXML
    private TextField mainFormProductsSearch;

    @FXML
    private Button mainFormPartsAdd;

    @FXML
    private Button mainFormPartsModify;

    @FXML
    private Button mainFormPartsRemove;

    @FXML
    private Button mainFormProductAdd;

    @FXML
    private Button mainFormProductModify;

    @FXML
    private Button mainFormProductRemove;

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

        mainFormPartsAdd.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){
                Stage stage = (Stage) mainFormPartsAdd.getScene().getWindow();
                try {
                    Parent parent = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("view/Add-Part-Form.fxml")));
                    stage.getScene().setRoot(parent);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        mainFormPartsModify.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){
                Stage stage = (Stage) mainFormPartsModify.getScene().getWindow();
                try {
                    Parent parent = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("view/Modify-Part-Form.fxml")));
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        mainFormProductAdd.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){
                Stage stage = (Stage) mainFormProductAdd.getScene().getWindow();
                try {
                    Parent parent = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("view/Add-Product-Form.fxml")));
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        mainFormProductModify.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t){
                Stage stage = (Stage) mainFormProductModify.getScene().getWindow();
                try {
                    Parent parent = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("view/Modify-Product-Form.fxml")));
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
