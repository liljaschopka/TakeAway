package hi.verkefni.takeaway;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import vinnsla.Matsedill;

import java.io.IOException;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  : Klasi sem býr til MatsedillView hlut út frá ListView
 *
 *
 *
 *
 *****************************************************************************/
public class MatsedillView extends ListView {

    private Matsedill sedill = new Matsedill();

    /**
     * Aðferð sem les inn matsedill-view.fxml og setur rót viðmótstrésins og controllerinn sem þennan klasa.
     */
    public MatsedillView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        fxmlLoader.setRoot(this);   // rótin á viðmótstrénu sett hér
        fxmlLoader.setController(this); // controllerinn settur hér en ekki í .fxml skránni
        try {
            fxmlLoader.load();          // viðmótstréð lesið inn (þ.e. .fxml skráin)
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Aðferð sem setur veitingar á matseðilinn og líka á MatsedillView
     */
    public void setjaMatsedil() {
        sedill.setjaGogn();
        System.out.println("gögn sett");
        setItems(sedill.getVeitingar());
    }
}
