package hi.verkefni.takeaway;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  : Klasi sem býr til einfaldan LoginDialog
 *
 *
 *
 *
 *****************************************************************************/
public class LoginDialog {

    public LoginDialog() {
        TextInputDialog d = new TextInputDialog();

        // Settur titill og haus
        d.setTitle("Innskráning");
        d.setHeaderText("Velkomin/n/ð aftur");
        // Texti við textfield:
        d.setContentText("Lykilorð:");

        // Birtum dialog-innm bíðum og fáum útkomuna
        // utkoma er af tagi sem inniheldur String
        Optional<String> utkoma = d.showAndWait();
        if (utkoma.isPresent()) {
            System.out.println("lykilorðið er " + utkoma.get());
        } else {
            System.out.println("ekkert svar");
        }
        d.close();
    }
}
