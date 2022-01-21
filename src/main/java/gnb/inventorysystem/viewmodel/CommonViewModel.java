package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

// A shareable view model as a singleton to pass state data between views.
public class CommonViewModel {
    // Constraining the class to a singleton model (can only be initialized once).
    private CommonViewModel(){}
    private static CommonViewModel single_instance = null;
    public static CommonViewModel getInstance()
    {
        if (single_instance == null)
            single_instance = new CommonViewModel();

        return single_instance;
    }
    // end singleton model constraints

    // Holds a part or product for use between controllers
    private Part partToBeModified;
    private Product productToBeModified;

    public Part getPartToBeModified() {
        return partToBeModified;
    }

    public Product getProductToBeModified() {
        return productToBeModified;
    }

    public void setPartToBeModified(Part part) {
        this.partToBeModified = part;
    }

    public void setProductToBeModified(Product product) {
        this.productToBeModified = product;
    }

    public ObservableList<Part> getAllParts() {
        return Inventory.getAllParts();
    }

    public ObservableList<Product> getAllProducts() {
        return Inventory.getAllProducts();
    }

    // Search function parses user input to determine valid input for an id search or name search.
    public ObservableList<Part> searchPart(String text) {
        if (!text.matches("[0-9]+")) {
            return Inventory.lookupPart(text);
        } else {
            int parsedInt = Integer.parseInt(text);
            ObservableList<Part> foundParts = FXCollections.observableArrayList();
            Part foundPart = Inventory.lookupPart(parsedInt);
            if (foundPart == null) {
                return foundParts;
            }
            foundParts.add(foundPart);
            return foundParts;
        }
    }

    // Search function parses user input to determine valid input for an id search or name search.
    public void searchProduct(String text, TableView<Product> updateTable) {
        if (!text.matches("[0-9]+")) {
            System.out.println("Name searching");
            ObservableList<Product> foundProducts = Inventory.lookupProduct(text);
            updateTable.getItems().setAll(foundProducts);
        } else {
            int parsedInt = Integer.parseInt(text);
            System.out.println("Id searching");
            ObservableList<Product> foundProduct = FXCollections.observableArrayList();
            foundProduct.add(Inventory.lookupProduct(parsedInt));
            updateTable.getItems().setAll(foundProduct);
        }
    }

    public void removePart(Part highlightedPart) {
        Inventory.deletePart(highlightedPart);
    }

    public boolean removeProduct(Product highlightedProduct) {
        if (highlightedProduct.getAllAssociatedParts().isEmpty()) {
            Inventory.deleteProduct(highlightedProduct);
        } else {
            return false;
        }

        return true;
    }
}

