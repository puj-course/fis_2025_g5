module g5.ROPA {
    requires javafx.controls;
    requires javafx.fxml;

    opens g5.ROPA to javafx.fxml;
    exports g5.ROPA;
}
