package gnb.inventorysystem.model;

import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.Comparator;

interface getId {
    public int getId();
}

public class Inventory {
    private ObservableList<Part> allParts;
    private ObservableList<Product> allProducts;

    private java.lang.Object foundObject(ObservableList<?> list, int id, FunctionalInterface getId) {
        ObservableList<?> sortedList = list.sorted();

        java.lang.Object foundObject;
        int mid = 0;
        int low = 0;
        int high = sortedList.size() - 1;

        while (high >= low) {
            mid = (high + low) / 2;
            foundObject = sortedList.get(mid);
            if (foundObject.getId > key) {
                low = mid + 1;
            } else if (foundObject.getId < key) {
                high = mid - 1;
            }
            else {
                return foundObject;
            }
        }
    }

    private Part sortedListBinarySearch(SortedList<Part> sortedList, int key) {
        Part foundPart;
        int mid = 0;
        int low = 0;
        int high = sortedList.size() - 1;

        while (high >= low) {
            mid = (high + low) / 2;
            foundPart = sortedList.get(mid);
            if (foundPart.getId() > key) {
                low = mid + 1;
            } else if (foundPart.getId() < key) {
                high = mid - 1;
            }
            else {
                return foundPart;
            }
        }

        return -1;
    }

    public void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    public Part lookupPart(int partId) {
        Comparator<Part> comparator = Comparator.comparingInt(Part::getId);
        SortedList<Part> sortedParts = allParts.sorted(comparator);

    }
}
