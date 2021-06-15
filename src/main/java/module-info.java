module com.alextcy.redisguitool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.bootstrapicons;
    requires com.google.gson;
    
    exports com.alextcy.redisguitool;
    
    opens com.alextcy.redisguitool.Controller to javafx.fxml;
    opens com.alextcy.redisguitool.ViewModel to javafx.fxml;
    opens com.alextcy.redisguitool.Model to com.google.gson;
}
