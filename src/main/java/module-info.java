module gnb.inventorysystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens gnb.inventorysystem to javafx.fxml;
    exports gnb.inventorysystem;
}