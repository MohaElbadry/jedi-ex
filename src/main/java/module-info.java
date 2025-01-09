module org.main.ex {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens org.main.ex to javafx.fxml;
    exports org.main.ex;
}