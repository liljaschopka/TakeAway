package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  : Klasi fyrir Veitingarhlut
 *
 *
 *
 *
 *****************************************************************************/
public class Veitingar {

    private IntegerProperty verd = new SimpleIntegerProperty();
    private StringProperty tegund = new SimpleStringProperty();

    /**
     * Smiður sem býr til nýjan veitingarhlut
     *
     * @param tegund heiti veitingar
     * @param verd   verð veitingar
     */
    public Veitingar(String tegund, int verd) {
        setTegund(tegund);
        setVerd(verd);
    }

    /**
     * toString aðferð fyrir veitingarhlut.
     *
     * @return
     */
    public String toString() {
        return tegundProperty().getValue() + ", " + verdProperty().getValue();
    }

    public StringProperty tegundProperty() {
        return tegund;
    }

    public int getVerd() {
        return verd.get();
    }

    public IntegerProperty verdProperty() {
        return verd;
    }

    public void setTegund(String tegund) {
        this.tegund.set(tegund);
    }

    public void setVerd(int verd) {
        this.verd.set(verd);
    }

}
