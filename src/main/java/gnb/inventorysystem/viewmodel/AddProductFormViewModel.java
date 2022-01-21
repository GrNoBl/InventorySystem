package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.model.Product;
import gnb.inventorysystem.view.ViewUtility;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.stream.Stream;

public final class AddProductFormViewModel {
    private AddProductFormViewModel() {}

    public static boolean addProduct(TextField name, TextField price, TextField inv, TextField max, TextField min, TableView<Part> parts) {
        int newID = Inventory.generateProductId(Inventory.getAllProducts());
        if (Stream.of(name, price, inv, max, min).anyMatch(textField -> textField.getText().isEmpty())) {
            ViewUtility.displayAlert("input missing");
            return false;
        }

        if (Stream.of(price, inv, max, min).anyMatch(textField -> !textField.getText().matches("\\d+(\\.\\d+)?"))) {
            ViewUtility.displayAlert("numeric input expected");
            return false;
        }

        String productName = name.getText();
        double productPrice = Double.parseDouble(price.getText());
        int productInv = Integer.parseInt(inv.getText());
        int productMax = Integer.parseInt(max.getText());
        int productMin = Integer.parseInt(min.getText());
        ObservableList<Part> productParts = parts.getItems();

        if (productMax < productMin) {
            ViewUtility.displayAlert("min greater than max");
            return false;
        }

        if ((productInv < productMin) || (productInv > productMax)) {
            ViewUtility.displayAlert("inv out of range");
            return false;
        }

        Product newProduct = new Product(newID, productName, productPrice, productInv, productMin, productMax);
        for (Part part : productParts) {
            newProduct.addAssociatedPart(part);
        }

        Inventory.addProduct(newProduct);
        return true;
    }

}
