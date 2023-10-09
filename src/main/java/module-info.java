module com.example.amindesmond_comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.sql.rowset;

    opens com.example.amindesmond_comp228lab4 to javafx.fxml;
    exports com.example.amindesmond_comp228lab4;
}