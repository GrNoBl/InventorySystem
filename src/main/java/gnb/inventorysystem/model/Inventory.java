package gnb.inventorysystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.Comparator;

public class Inventory {
    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();

    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();

    // Generates a unique part id in ascending order.
    public static int generatePartId(ObservableList<Part> Parts) {
        Comparator<Part> comparator = Comparator.comparingInt(Part::getId);
        SortedList<Part> sortedParts = Parts.sorted(comparator);

        // If parts list is empty, return generated id as 1.
        if (sortedParts.size() == 0) {
            return 1;
        }

        // Check if there is an id 1, return 1 if not.
        if (sortedParts.get(0).getId() != 1) {
            return 1;
        }

        // Find the first id gap between two parts by looking at the difference between side by side parts, return the next integer within the gap.
        for (int i = 1; i < sortedParts.size(); i++) {
            if ((sortedParts.get(i).getId() - sortedParts.get(i-1).getId()) > 1) {
                return sortedParts.get(i - 1).getId() + 1;
            }
        }

        // By now list is not empty nor has any gaps. Returning the next id in order.
        return sortedParts.size() + 1;
    }

    // Generates a unique product id in ascending order.
    public static int generateProductId(ObservableList<Product> Products) {
        Comparator<Product> comparator = Comparator.comparingInt(Product::getId);
        SortedList<Product> sortedProducts = Products.sorted(comparator);

        // If parts list is empty, return generated id as 1.
        if (sortedProducts.size() == 0) {
            return 1;
        }

        // Check if there is an id 1, return 1 if not.
        if (sortedProducts.get(0).getId() != 1) {
            return 1;
        }

        // Find the first id gap between two products by looking at the difference between side by side products, return the next integer within the gap.
        for (int i = 1; i < sortedProducts.size(); i++) {
            if ((sortedProducts.get(i).getId() - sortedProducts.get(i-1).getId()) > 1) {
                return sortedProducts.get(i - 1).getId() + 1;
            }
        }

        // By now list is not empty nor has any gaps. Returning the next id in order.
        return sortedProducts.size() + 1;
    }

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
            if (thisPart.getName().contains(name)) {
                foundParts.add(thisPart);
            }
        }
        return foundParts;
    }

    public static Product lookupProduct(int productId) {
        Comparator<Product> comparator = Comparator.comparingInt(Product::getId);
        SortedList<Product> sortedProducts = allProducts.sorted(comparator);

        Product foundProductId;
        int mid;
        int low = 0;
        int high = sortedProducts.size() - 1;

        while (high >= low) {
            mid = (high + low) / 2;
            foundProductId = sortedProducts.get(mid);
            if (foundProductId.getId() < productId) {
                low = mid + 1;
            }
            else if (foundProductId.getId() > productId) {
                high = mid - 1;
            }
            else {
                return foundProductId;
            }
        }

        return null;
    }

    public static ObservableList<Product> lookupProduct(String name) {
        ObservableList<Product> foundProducts = FXCollections.observableArrayList();
        for (Product thisProduct: allProducts) {
            if (thisProduct.getName().contains(name)) {
                foundProducts.add(thisProduct);
            }
        }
        return foundProducts;
    }

    public static void deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
    }

    public static void deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
