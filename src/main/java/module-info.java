module org.main.ex {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.main.ex to javafx.fxml;
    exports org.main.ex;
}