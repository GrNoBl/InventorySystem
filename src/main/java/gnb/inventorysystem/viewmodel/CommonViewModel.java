package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 * A public class to hold controller state between controllers.
 * Also provides functionality needed in multiple controllers for interacting with lower level model.
 * Uses the singleton pattern of being able to only be initialized a single time, only re-referencing it, if instantiating from another class.
 */
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

    /**
     * Given user input parses data to convert it to int for part ID searching or passing it along as a string for name searching.
     * @param text, scraped user input.
     * @return returns a list of parts found in the inventory.
     */
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

    /**
     * Given user input parses data to convert it to int for product ID searching or passing it along as a string for name searching.
     * @param text, scraped user input.
     * @return returns a list of products found in the inventory.
     * RUNTIME ERROR (NumberFormatException) found when trying to Integer.parse user input. Added regex to only pass valid numerical strings to this function.
     */
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

