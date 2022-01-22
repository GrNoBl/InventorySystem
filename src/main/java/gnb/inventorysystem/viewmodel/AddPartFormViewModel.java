package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.model.InHouse;
import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Outsourced;
import gnb.inventorysystem.view.ViewUtility;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.stream.Stream;

/**
 * Static functionality class for the "Add Part" controller.
 * Handles the user input validation.
 * Connects underlying model functionality to the view's components.
 */
public final class AddPartFormViewModel {
    private AddPartFormViewModel() {}

    /**
     * Providing view components, scrapes these to build a valid part & saves it to the inventory.
     * All parameters are FXML components.
     * @return true if part was successfully added to inventory, false if validation failed and alert was raised.
     */
    public static boolean addPart(TextField name, TextField price, TextField inv, TextField max, TextField min, TextField toggle, RadioButton inHouse) {
        int newId = Inventory.generatePartId(Inventory.getAllParts());
        if (Stream.of(name, price, inv, max, min, toggle).anyMatch(textField -> textField.getText().isEmpty())) {
            ViewUtility.displayAlert("input missing");
            return false;
        }

        if (Stream.of(price, inv, max, min).anyMatch(textField -> !textField.getText().matches("\\d+(\\.\\d+)?"))) {
            ViewUtility.displayAlert("numeric input expected");
            return false;
        }

        String partName = name.getText();
        double partPrice = Double.parseDouble(price.getText());
        int partInv = Integer.parseInt(inv.getText());
        int partMax = Integer.parseInt(max.getText());
        int partMin = Integer.parseInt(min.getText());

        if (partMax < partMin) {
            ViewUtility.displayAlert("min greater than max");
            return false;
        }

        if ((partInv < partMin) || (partInv > partMax)) {
            ViewUtility.displayAlert("inv out of range");
            return false;
        }

        if (inHouse.isSelected()) {
            if (!toggle.getText().matches("[0-9]+")) {
                ViewUtility.displayAlert("numeric input expected");
                return false;
            }

            int partMachineId = Integer.parseInt(toggle.getText());
            InHouse newInHousePart = new InHouse(newId, partName, partPrice, partInv, partMax, partMin, partMachineId);
            Inventory.addPart(newInHousePart);
        } else {
            String partCompanyName = toggle.getText();
            Outsourced newOutsourcedPart = new Outsourced(newId, partName, partPrice, partInv, partMax, partMin, partCompanyName);
            Inventory.addPart(newOutsourcedPart);
        }
        return true;
    }
}
