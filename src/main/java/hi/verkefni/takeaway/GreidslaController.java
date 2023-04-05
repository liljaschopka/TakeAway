package hi.verkefni.takeaway;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vinnsla.Karfa;

import java.util.concurrent.ThreadLocalRandom;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  : Controller klasi fyrir greidsla-view.fxml
 *
 *
 *
 *
 *****************************************************************************/
public class GreidslaController {

    @FXML
    private Label fxVerd;
    @FXML
    private Label fxHeimilisfang;
    @FXML
    private Label fxTimi;
    @FXML
    private Button fxStadfesta;
    @FXML
    private Button fxTilBaka;

    private Karfa karfa;
    /**
     * PontunController hlutur svo hægt sé að ná í upplýsingar úr þeim klasa
     */
    private PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);

    /**
     * Handler fyrir til baka hnappinn. Skiptir yfir í pöntunargluggann.
     *
     * @param ActionEvent
     */
    @FXML
    public void fxTilBakaHandler(ActionEvent ActionEvent) {
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * Handler fyrir staðfesta hnappinn. Hann hreinsar körfuna í vinnslunni og ListView körfuna.
     * Skiptir svo yfir í pöntunargluggann sem hefur verið upphafsstilltur.
     *
     * @param ActionEvent
     */
    @FXML
    public void fxStadfestaHandler(ActionEvent ActionEvent) {
        karfa = pontunController.getKarfa();
        karfa.hreinsaKorfu();
        pontunController.getFxKarfa().getItems().clear();
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * Initialize aðferð sem setur afhendingartímann (slembinn) og heimilisfangið og verðið sem eru
     * samkvæmt upplýsingum fengnum frá PontunController
     */
    public void initialize() {
        fxTimi.setText(randomTimi());
        fxHeimilisfang.textProperty().bind(pontunController.getVidskiptavinur().heimilisfangProperty());
        fxVerd.setText(String.valueOf(pontunController.getHeildarverd()));
    }

    /**
     * Aðferð sem býr til slembitíma
     *
     * @return
     */
    private String randomTimi() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        String[] timar = {"20 mínútur", "15 mínútur", "10 mínútur", "30 mínútur", "40 mínútur"};
        return timar[randomNum];
    }
}
