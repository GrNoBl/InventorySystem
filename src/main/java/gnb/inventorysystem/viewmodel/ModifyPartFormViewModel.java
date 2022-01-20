package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.model.InHouse;
import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Outsourced;
import gnb.inventorysystem.model.Part;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public final class ModifyPartFormViewModel {
    private ModifyPartFormViewModel(){
    }

    public static void modifyPart(TextField id,
                                  TextField name,
                                  TextField price,
                                  TextField inv,
                                  TextField max,
                                  TextField min,
                                  TextField toggle,
                                  RadioButton inHouse,
                                  CommonViewModel cVM) {
        int partId = Integer.parseInt(id.getText());
        String partName = name.getText();
        double partPrice = Double.parseDouble(price.getText());
        int partInv = Integer.parseInt(inv.getText());
        int partMax = Integer.parseInt(max.getText());
        int partMin = Integer.parseInt(min.getText());

        if (inHouse.isSelected()) {
            int partMachineId = Integer.parseInt(toggle.getText());
            InHouse newInHousePart = new InHouse(partId,
                    partName,
                    partPrice,
                    partInv,
                    partMax,
                    partMin,
                    partMachineId);
            Inventory.addPart(newInHousePart);
        } else {
            String partCompanyName = toggle.getText();
            Outsourced newOutsourcedPart = new Outsourced(partId,
                    partName,
                    partPrice,
                    partInv,
                    partMax,
                    partMin,
                    partCompanyName);
            Inventory.addPart(newOutsourcedPart);
        }

        cVM.removePart(cVM.getPartToBeModified());
    }

    public static void preLoadPart(TextField id,
                                   TextField name,
                                   TextField price,
                                   TextField inv,
                                   TextField max,
                                   TextField min,
                                   TextField toggle,
                                   RadioButton inHouse,
                                   RadioButton outSourced,
                                   Label toggleLabel,
                                   CommonViewModel cVM) {
        Part part = cVM.getPartToBeModified();
        if (part instanceof InHouse) {
            inHouse.setSelected(true);
            id.setText(Integer.toString(part.getId()));
            name.setText(part.getName());
            inv.setText(Integer.toString(part.getStock()));
            price.setText(Double.toString(part.getPrice()));
            max.setText(Integer.toString(part.getMax()));
            min.setText(Integer.toString(part.getMin()));
            toggle.setText(Integer.toString(((InHouse) part).getMachineId()));
        } else {
            outSourced.setSelected(true);
            toggleLabel.setText("Company Name");
            id.setText(Integer.toString(part.getId()));
            name.setText(part.getName());
            inv.setText(Integer.toString(part.getStock()));
            price.setText(Double.toString(part.getPrice()));
            max.setText(Integer.toString(part.getMax()));
            min.setText(Integer.toString(part.getMin()));
            toggle.setText(((Outsourced) part).getCompanyName());
        }
    }
}
