module streaming.streaming {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.logging;
    requires java.sql;
    requires javafx.media;

    opens streaming.streaming to javafx.fxml;
    exports streaming.streaming;
    exports streaming.streaming.controllers;
    opens streaming.streaming.controllers to javafx.fxml;
}