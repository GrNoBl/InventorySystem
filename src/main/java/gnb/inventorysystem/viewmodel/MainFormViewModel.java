package gnb.inventorysystem.viewmodel;


import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.model.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainFormViewModel {
    public final ObservableList<Part> allParts = FXCollections.observableArrayList();
    public final ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public MainFormViewModel() {
        allParts.setAll(Inventory.getAllParts());
        allProducts.setAll(Inventory.getAllProducts());
    }
}
