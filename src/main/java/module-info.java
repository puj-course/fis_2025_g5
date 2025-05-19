module g5.ROPA {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires twilio;

    opens g5.ROPA to javafx.fxml;
    exports g5.ROPA;
}
