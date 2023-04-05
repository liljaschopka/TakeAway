package hi.verkefni.takeaway;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.Vidskiptavinur;

import java.io.IOException;
import java.util.Optional;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  : Dialog sem er notaður þegar það er ekki viðskiptavinur í kerfinu
 *
 *
 *
 *
 *****************************************************************************/
public class VidskiptavinurDialog extends Dialog<Vidskiptavinur> {

    @FXML
    private TextField fxNafn;
    @FXML
    private TextField fxHeimilisfang;
    @FXML
    private ButtonType fxILagi;
    @FXML
    private ButtonType fxHaettaVid;

    private Vidskiptavinur vidskiptavinur;

    /**
     * Smiður fyrir VidskiptavinurDialog. Inniheldur bindingu milli viðmóts og vinnslu og setur einnig ResultConverter
     *
     * @param v Viðskiptavinur
     */
    public VidskiptavinurDialog(Vidskiptavinur v) {
        vidskiptavinur = v;
        setDialogPane(lesaVidskiptavinurDialog());
        iLagiRegla();

        fxNafn.textProperty().bindBidirectional(v.nafnProperty());
        fxHeimilisfang.textProperty().bindBidirectional((v.heimilisfangProperty()));

        setResultConverter(b -> {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return v;
            } else {
                return null;
            }
        });
    }

    /**
     * Útlitið búið til
     *
     * @return hlutur af DialogPane
     */
    private DialogPane lesaVidskiptavinurDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vidskiptavinur-view.fxml"));
        try {
            fxmlLoader.setController(this);
            DialogPane dialogPane = fxmlLoader.load();
            return dialogPane;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Regla búin til um hvenær Í lagi hnappurinn á að vera óvirkur/virkur
     */
    private void iLagiRegla() {
        // fletta upp í lagi hnappnum út frá hnappategund
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty()
                .bind(fxNafn.textProperty().isEmpty()
                        .or(fxHeimilisfang.textProperty().isEmpty()));
    }


    /**
     * Birtir dialog d og skilar nafni viðskiptavins úr dialog
     *
     * @return skilar nafni viðskiptavins nema ef hætt við þá skilar hann null
     */
    public Vidskiptavinur getVidskiptavinur() { //óþarfi?
        // Dialog birtur og svarið fengið
        Optional<Vidskiptavinur> utkoma = showAndWait();
        return utkoma.orElse(null);
    }

    public String getHeimilisfang() {
        return vidskiptavinur.getHeimilisfang();
    }


}
