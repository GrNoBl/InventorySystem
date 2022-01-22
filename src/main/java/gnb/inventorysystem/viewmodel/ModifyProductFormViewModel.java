package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.model.Product;
import gnb.inventorysystem.view.ViewUtility;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.stream.Stream;

/**
 * Static functionality class for the "Modify Product" controller.
 * Handles the user input validation.
 * Connects underlying model functionality to the view's components.
 */
public final class ModifyProductFormViewModel {
    private ModifyProductFormViewModel() {}

    /**
     * Providing view components, scrapes these to build a valid product & saves it to the inventory.
     * Most parameters are FXML components.
     * @param cVM, needs the singleton class that holds the previously selected product inorder to remove it from inventory.
     * @return true if product was successfully added to inventory, false if validation failed and alert was raised.
     */
    public static boolean modifyProduct(TextField id,
                                     TextField name,
                                     TextField price,
                                     TextField inv,
                                     TextField max,
                                     TextField min,
                                     CommonViewModel cVM,
                                     TableView<Part> partsTable) {
        int productId = Integer.parseInt(id.getText());
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
        ObservableList<Part> productParts = partsTable.getItems();

        if (productMax < productMin) {
            ViewUtility.displayAlert("min greater than max");
            return false;
        }

        if ((productInv < productMin) || (productInv > productMax)) {
            ViewUtility.displayAlert("inv out of range");
            return false;
        }

        Product newProduct = new Product(productId, productName, productPrice, productInv, productMin, productMax);
        for (Part part : productParts) {
            newProduct.addAssociatedPart(part);
        }

        Inventory.addProduct(newProduct);
        Inventory.deleteProduct(cVM.getProductToBeModified());
        return true;
    }

    /**
     * Pre-populates forms fields with contents of the previous select product's contents.
     * Most parameters are FXML components.
     * @param cVM, needs the singleton class that holds the previously selected product inorder to populate the text fields.
     */
    public static void preLoadProduct(TextField id,
                                      TextField name,
                                      TextField price,
                                      TextField inv,
                                      TextField max,
                                      TextField min,
                                      CommonViewModel cVM,
                                      ObservableList<Part> partsList,
                                      TableView<Part> partsTable) {
        Product product = cVM.getProductToBeModified();
        partsList.addAll(product.getAllAssociatedParts());
        partsTable.setItems(partsList);
        id.setText(Integer.toString(product.getId()));
        name.setText(product.getName());
        inv.setText(Integer.toString(product.getStock()));
        price.setText(Double.toString(product.getPrice()));
        max.setText(Integer.toString(product.getMax()));
        min.setText(Integer.toString(product.getMin()));
    }
}
