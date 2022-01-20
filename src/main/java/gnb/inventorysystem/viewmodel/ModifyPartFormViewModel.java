package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.model.Inventory;
import gnb.inventorysystem.model.Part;

public class ModifyPartFormViewModel {
    public ModifyPartFormViewModel(){
    }

    public void addPart(Part part) {
        Inventory.addPart(part);
    }

    public void removePart(Part part) {
        Inventory.deletePart(part);
    }
}
