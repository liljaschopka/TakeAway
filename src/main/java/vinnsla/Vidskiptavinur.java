package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  : Klasi fyrir viðskiptavin hlut
 *
 *
 *
 *
 *****************************************************************************/
public class Vidskiptavinur {

    private StringProperty nafn = new SimpleStringProperty();
    private StringProperty heimilisfang = new SimpleStringProperty();

    /**
     * Smiður sem býr til nýjan viðskiptavin
     *
     * @param name    nafn viðskiptavins
     * @param address heimilisfang
     */
    public Vidskiptavinur(String name, String address) {
        nafn.set(name);
        heimilisfang.set(address);
    }

    public String getNafn() {
        return nafn.get();
    }

    public StringProperty nafnProperty() {
        return nafn;
    }

    public String getHeimilisfang() {
        return heimilisfang.get();
    }

    public StringProperty heimilisfangProperty() {
        return heimilisfang;
    }


}
