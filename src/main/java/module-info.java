module org.main.ex {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.main.ex to javafx.fxml;
    exports org.main.ex;
}