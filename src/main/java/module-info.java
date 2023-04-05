module hi.verkefni.takeaway {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.verkefni.takeaway to javafx.fxml;
    exports hi.verkefni.takeaway;
}
