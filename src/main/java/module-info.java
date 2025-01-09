module org.main.ex {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens ma.enset.exam_mohammed_elbadry.presentation.views to javafx.graphics, javafx.fxml;
    opens ma.enset.exam_mohammed_elbadry.presentation.controllers to javafx.fxml;
    exports ma.enset.exam_mohammed_elbadry.presentation.views;
}