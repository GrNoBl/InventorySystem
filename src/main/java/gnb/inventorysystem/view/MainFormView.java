package gnb.inventorysystem.view;

import gnb.inventorysystem.App;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.model.Product;
import gnb.inventorysystem.viewmodel.CommonViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainFormView implements Initializable {
    private final CommonViewModel cVM = CommonViewModel.getInstance();

    @FXML
    private TextField mainFormPartsSearch;
    @FXML
    private TextField mainFormProductsSearch;
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

    private Optional<ButtonType> displayAlert(String type) {
        Alert warning = new Alert(Alert.AlertType.WARNING);
        Alert error = new Alert(Alert.AlertType.ERROR);
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);

        switch (type) {
            case "confirmation part delete" -> {
                confirmation.setTitle("Delete part?");
                confirmation.setHeaderText("You are attempting to delete the highlighted part, proceed?");
                return confirmation.showAndWait();
            }
            case "missing part" -> {
                warning.setTitle("Warning!");
                warning.setHeaderText("Part not found");
                return warning.showAndWait();
            }
            case "missing product" -> {
                warning.setTitle("Warning!");
                warning.setHeaderText("Product not found");
                return warning.showAndWait();
            }
            case "part not selected" -> {
                warning.setTitle("Warning!");
                warning.setHeaderText("Part not selected");
                return warning.showAndWait();
            }
            case "product not selected" -> {
                warning.setTitle("Warning!");
                warning.setHeaderText("Product not selected");
                return warning.showAndWait();
            }
            case "product has parts" -> {
                error.setTitle("Error");
                error.setHeaderText("Parts Associated");
                error.setContentText("All parts must be removed from product before deletion.");
                return error.showAndWait();
            }
        }

        error.setHeaderText("Improper error passed");
        return error.showAndWait();
    }

    @FXML
    private void partsSearch(KeyEvent k) {
        if (k.getCode().equals(KeyCode.ENTER)) {
            cVM.searchPart(mainFormPartsSearch.getText(), mainFormPartsTable);
        }
    }

    @FXML
    private void productSearch(KeyEvent k) {
        if (k.getCode().equals(KeyCode.ENTER)) {
            cVM.searchProduct(mainFormProductsSearch.getText(), mainFormProductsTable);
        }
    }

    @FXML
    private void partsAdd(ActionEvent event) throws IOException {
            Stage stage = App.getAppStage();
            Parent root = FXMLLoader.load(App.class.getResource("Add-Part-Form.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Add Part");
            stage.show();
    }

    @FXML
    private void partsModify(ActionEvent event) throws IOException {
        cVM.setPartToBeModified(mainFormPartsTable.getSelectionModel().getSelectedItem());

        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Modify-Part-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Modify Part");
        stage.show();
    }

    @FXML
    private void partsRemove(ActionEvent event) {
        Part highlightedPart = mainFormPartsTable.getSelectionModel().getSelectedItem();

        if (highlightedPart == null) {
            displayAlert("part not selected");
        } else {
            Optional<ButtonType> choice = displayAlert("confirmation part delete");
            if (choice.isPresent() && choice.get() == ButtonType.OK) {
                cVM.removePart(highlightedPart);
                mainFormPartsTable.refresh();
            }
        }
    }

    @FXML
    private void productsAdd(ActionEvent event) throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Add-Product-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Product");
        stage.show();
    }

    @FXML
    private void productModify(ActionEvent event) throws IOException {
        Stage stage = App.getAppStage();
        Parent root = FXMLLoader.load(App.class.getResource("Modify-Product-Form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Modify Product");
        stage.show();
    }

    @FXML
    private void productsRemove(ActionEvent event) throws IOException {
        System.out.println("Implement productsRemove button action!");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainFormPartsTable.setItems(cVM.getAllParts());
        mainFormPartsTableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        mainFormPartsTableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        mainFormPartsTableColumnInventory.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        mainFormPartsTableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        mainFormProductsTable.setItems(cVM.getAllProducts());
        mainFormProductTableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        mainFormProductTableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        mainFormProductTableColumnInventory.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        mainFormProductTableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

    }

}