package gnb.inventorysystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.Comparator;

public class Inventory {
    private static ObservableList<Part> allParts;
    private static ObservableList<Product> allProducts;

    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

public static Part lookupPart(int partId) {
    Comparator<Part> comparator = Comparator.comparingInt(Part::getId);
    SortedList<Part> sortedParts = allParts.sorted(comparator);

    Part foundPartId;
    int mid;
    int low = 0;
    int high = sortedParts.size() - 1;

    while (high >= low) {
        mid = (high + low) / 2;
        foundPartId = sortedParts.get(mid);
        if (foundPartId.getId() < partId) {
            low = mid + 1;
        }
        else if (foundPartId.getId() > partId) {
            high = mid - 1;
        }
        else {
            return foundPartId;
        }
    }

    return null;
}

public static ObservableList<Part> lookupPart(String name) {
    ObservableList<Part> foundParts = FXCollections.observableArrayList();
    for (Part thisPart: allParts) {
        if (thisPart.getName() == name) {
            foundParts.add(thisPart);
        }
    }
    return foundParts;
}
 // IN THE MIDDLE OF FIXING
public static Product lookupProduct(int productId) {
    Comparator<Product> comparator = Comparator.comparingInt(Product::getId);
    SortedList<Product> sortedProducts = allParts.sorted(comparator);

    Part foundPartId;
    int mid;
    int low = 0;
    int high = sortedParts.size() - 1;

    while (high >= low) {
        mid = (high + low) / 2;
        foundPartId = sortedParts.get(mid);
        if (foundPartId.getId() < partId) {
            low = mid + 1;
        }
        else if (foundPartId.getId() > partId) {
            high = mid - 1;
        }
        else {
            return foundPartId;
        }
    }

    return null;
}

public static ObservableList<Part> lookupPart(String name) {
    ObservableList<Part> foundParts = FXCollections.observableArrayList();
    for (Part thisPart: allParts) {
        if (thisPart.getName() == name) {
            foundParts.add(thisPart);
        }
    }
    return foundParts;
}

}
