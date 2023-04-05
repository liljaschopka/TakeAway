package hi.verkefni.takeaway;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import vinnsla.Karfa;
import vinnsla.Veitingar;
import vinnsla.Vidskiptavinur;

import java.util.Optional;

/**
 * Controller klasi fyrir pontun-view.fxml
 */
public class PontunController {

    @FXML
    private Label fxVerd;
    @FXML
    private Label fxVidskiptavinur;
    @FXML
    private ListView<Veitingar> fxKarfa;
    @FXML
    private MatsedillView fxMatsedill;
    private Vidskiptavinur vidskiptavinur;
    private int heildarverd;
    public Karfa karfa = new Karfa();

    /**
     * Handler fyrir bæta við körfu hnappinn. Bætir valdri vöru úr MatsedillView við ListView körfuna og
     * einnig við körfuna í vinnslunni. Reiknar svo heildarverðið.
     *
     * @param ActionEvent
     */
    @FXML
    public void fxSetjaKorfuHandler(ActionEvent ActionEvent) {
        fxMatsedill.getSelectionModel().getSelectedItems().forEach((selected) ->
                fxKarfa.getItems().add((Veitingar) selected));

        karfa.getKarfa().add((Veitingar) fxMatsedill.getSelectionModel().getSelectedItem());
        fxMatsedill.getSelectionModel().clearSelection();
        heildarverd = Karfa.reiknaHeildarverd(karfa.getKarfa());
        karfa.setHeildarverd(heildarverd);
        System.out.println(karfa.getHeildarverd());
    }

    /**
     * Handler fyrir eyða úr körfu hnappinn. Eyðir valdri veitingu úr körfunni í vinnslunni og úr ListView körfunni.
     * Reiknar svo heildarverðið.
     *
     * @param ActionEvent
     */
    @FXML
    public void fxTakaUrKorfuHandler(ActionEvent ActionEvent) {
        if (fxKarfa.getSelectionModel().getSelectedItem() == null) {
            fxKarfa.getSelectionModel().clearSelection();
        } else {
            Veitingar selected = fxKarfa.getSelectionModel().getSelectedItem();
            karfa.getKarfa().remove(selected);
            heildarverd = Karfa.reiknaHeildarverd(karfa.getKarfa());
            karfa.setHeildarverd(heildarverd);
            fxKarfa.getItems().remove(selected);
        }
    }

    /**
     * Handler fyrir innskráning hnappinn. Ef enginn viðskiptavinur er skráður þá opnast VidskiptavinurDialog
     * en annars opnast LoginDialog
     *
     * @param ActionEvent
     */
    @FXML
    public void fxNyrVidskiptavinurHandler(ActionEvent ActionEvent) {
        if (vidskiptavinur == null) {
            nyrVidskiptavinur();
        } else {
            nyrLoginDialog();
        }

    }

    /**
     * Handler fyrir greiða hnappinn sem skiptir yfir í greiðslugluggann
     *
     * @param ActionEvent
     */
    @FXML
    public void fxGreidaHandler(ActionEvent ActionEvent) {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }

    public void initialize() {
        //birta matseðilinn
        fxMatsedill.setjaMatsedil();
        //binda heildarverð við viðmótið
        fxVerd.textProperty().bind(karfa.heildarverdProperty().asString());
        fxVidskiptavinur.setText("Enginn notandi innskráður");

    }

    /**
     * Aðferð sem býr til nýjan VidskiptavinurDialog og birtir nafn viðskiptavins í
     * pöntun glugganum
     */
    private void nyrVidskiptavinur() {
        vidskiptavinur = new Vidskiptavinur("", "");
        VidskiptavinurDialog d = new VidskiptavinurDialog(vidskiptavinur);
        Optional<Vidskiptavinur> o = d.showAndWait();
        o.ifPresent(value -> fxVidskiptavinur.setText(value.getNafn()));
    }

    /**
     * Aðferð sem býr til nýjan LoginDialog
     */
    private void nyrLoginDialog() {
        new LoginDialog();
    }

    public Vidskiptavinur getVidskiptavinur() {
        return vidskiptavinur;
    }

    public ListView<Veitingar> getFxKarfa() {
        return fxKarfa;
    }

    public int getHeildarverd() {
        return heildarverd;
    }

    public Karfa getKarfa() {
        return karfa;
    }

}
