package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  : Klasi fyrir körfuna
 *
 *
 *
 *
 *****************************************************************************/
public class Karfa extends Matsedill {
    /**
     * Heildarverð körfunnar
     */
    private IntegerProperty heildarverd = new SimpleIntegerProperty();
    /**
     * Karfan
     */
    private static ObservableList<Veitingar> karfa = FXCollections.observableArrayList();

    public int getHeildarverd() {
        return heildarverd.get();
    }

    public ObservableList<Veitingar> getKarfa() {
        return karfa;
    }

    public IntegerProperty heildarverdProperty() {
        return heildarverd;
    }

    public void setHeildarverd(int heildarverd) {
        this.heildarverd.set(heildarverd);
    }

    /**
     * Aðferð sem eyðir öllum stökum í körfunni og setur heildarverðið sem 0.
     */
    public void hreinsaKorfu() {
        karfa.clear();
        setHeildarverd(reiknaHeildarverd(karfa));
    }

    /**
     * Aðferð sem ítrar í gegnum körfulistann og reiknar heildarverð
     *
     * @param karfa karfa
     * @return heildarverð körfunnar
     */
    public static int reiknaHeildarverd(ObservableList<Veitingar> karfa) {
        int verd = 0;
        for (int i = 0; i < karfa.size(); i++) {
            verd += karfa.get(i).getVerd();
        }
        return verd;
    }

    /**
     * Prófanafall fyrir aðferðir í klasanum.
     *
     * @param args
     */
    public static void main(String[] args) {
        Veitingar v1 = new Veitingar("súpa", 200);
        Veitingar v2 = new Veitingar("brauð", 100);
        karfa.add(v1);
        karfa.add(v2);
        int v = reiknaHeildarverd(karfa);
        System.out.println(karfa.toString());
        System.out.println(v);
        karfa.remove(1);
        System.out.println(reiknaHeildarverd(karfa));


    }

}
