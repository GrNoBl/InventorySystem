package gnb.inventorysystem.model;

import javafx.collections.ObservableList;

public class Product implements Comparable<Product> {
    private ObservableList<Part> associatedParts;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    @Override
    public int compareTo(Product otherProducts) {
        int thisId = this.id;
        int otherId = otherProducts.id;

        return Integer.compare(thisId, otherId);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void addAssociatedPart(Part part) {
        this.associatedParts.add(part);
    }

    public boolean deleteAssociatedPart(Part part) {
        return this.associatedParts.remove(part);
    }

    public ObservableList<Part> getAllAssociatedParts() {
        return this.associatedParts;
    }
}
