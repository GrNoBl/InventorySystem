package gnb.inventorysystem.viewmodel;

import gnb.inventorysystem.model.Part;
import gnb.inventorysystem.model.Product;

// A shareable view model as a singleton to pass state data between views.
public class CommonViewModel {
    private static CommonViewModel single_instance = null;

    public Part partToBeModified;
    public Product productToBeModified;

    private CommonViewModel(){}

    public static CommonViewModel getInstance()
    {
        if (single_instance == null)
            single_instance = new CommonViewModel();

        return single_instance;
    }
}
