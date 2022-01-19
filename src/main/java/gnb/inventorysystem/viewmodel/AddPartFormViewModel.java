package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.model.InHouse;
import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Outsourced;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AddPartFormViewModel {
    public AddPartFormViewModel() {

    }

    public void addPart(TextField name, TextField price, TextField inv, TextField max, TextField min, TextField toggle, RadioButton inHouse) {
        int newId = Inventory.generatePartId(Inventory.getAllParts());
        String partName = name.getText();
        double partPrice = Double.parseDouble(price.getText());
        int partInv = Integer.parseInt(inv.getText());
        int partMax = Integer.parseInt(max.getText());
        int partMin = Integer.parseInt(min.getText());

        if (inHouse.isSelected()) {
            int partMachineId = Integer.parseInt(toggle.getText());
            InHouse newInHousePart = new InHouse(newId, partName, partPrice, partInv, partMax, partMin, partMachineId);
            Inventory.addPart(newInHousePart);
        } else {
            String partCompanyName = toggle.getText();
            Outsourced newOutsourcedPart = new Outsourced(newId, partName, partPrice, partInv, partMax, partMin, partCompanyName);
            Inventory.addPart(newOutsourcedPart);
        }
    }
}
