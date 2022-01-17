module gnb.inventorysystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens gnb.inventorysystem to javafx.fxml;
    exports gnb.inventorysystem;
    opens gnb.inventorysystem.model to javafx.fxml;
    exports gnb.inventorysystem.model;
    opens gnb.inventorysystem.viewmodel to javafx.fxml;
    exports gnb.inventorysystem.viewmodel;
}