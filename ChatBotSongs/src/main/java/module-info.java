module com.mycompany.chatbotsongs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.chatbotsongs to javafx.fxml;
    exports com.mycompany.chatbotsongs;
}
