package gnb.inventorysystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.Comparator;

/**
 * Defines an inventory of all parts and products available.
 */
public class Inventory {
    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();

    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * Generates a unique partId contiguously starting from 1.
     * @param parts, inventory of parts.
     * @return The next valid ID.
     */
    public static int generatePartId(ObservableList<Part> parts) {
        Comparator<Part> comparator = Comparator.comparingInt(Part::getId);
        SortedList<Part> sortedParts = parts.sorted(comparator);

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

    /**
     * Generates a unique productId contiguously starting from 1.
     * @param products, inventory of parts.
     * @return The next valid ID.
     */
    public static int generateProductId(ObservableList<Product> products) {
        Comparator<Product> comparator = Comparator.comparingInt(Product::getId);
        SortedList<Product> sortedProducts = products.sorted(comparator);

        if (sortedProducts.size() == 0) {
            return 1;
        }

        if (sortedProducts.get(0).getId() != 1) {
            return 1;
        }

        for (int i = 1; i < sortedProducts.size(); i++) {
            if ((sortedProducts.get(i).getId() - sortedProducts.get(i-1).getId()) > 1) {
                return sortedProducts.get(i - 1).getId() + 1;
            }
        }

        return sortedProducts.size() + 1;
    }

    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     * Finds a part in the inventory. Sorts the parts inventory and uses a binary tree search to find the correct part.
     * @param partId, for given partId.
     * @return part that has id of partId.
     */
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

    /**
     * Finds part in part inventory. Linearly searches for matches based on part name.
     * @param name, partial or full name to search part for.
     * @return a list of 0 or more parts that contain input name in their part name.
     */
    public static ObservableList<Part> lookupPart(String name) {
        ObservableList<Part> foundParts = FXCollections.observableArrayList();
        for (Part thisPart: allParts) {
            if (thisPart.getName().contains(name)) {
                foundParts.add(thisPart);
            }
        }
        return foundParts;
    }

    /**
     * Finds a product in the inventory. Sorts the product inventory and uses a binary tree search to find the correct product.
     * @param productId, for given productId.
     * @return product that has id of productId.
     */
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
    /**
     * Finds product in product inventory. Linearly searches for matches based on product name.
     * @param name, partial or full name to search product for.
     * @return a list of 0 or more products that contain input name in their product name.
     */
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
