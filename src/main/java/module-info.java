module com.mycompany.m226_sorting {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.m226_sorting to javafx.fxml;
    exports com.mycompany.m226_sorting;
}
