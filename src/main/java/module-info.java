module com.mycompany.playingcards24_fxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.playingcards24_fxml to javafx.fxml;
    exports com.mycompany.playingcards24_fxml;
}
