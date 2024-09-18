module com.cs3035.cs3035group {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;


    opens com.cs3035.cs3035group to javafx.fxml;
    exports com.cs3035.cs3035group;
}