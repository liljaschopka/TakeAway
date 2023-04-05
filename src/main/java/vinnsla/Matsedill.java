package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/******************************************************************************
 *  Nafn    : Lilja Kolbrún Schopka
 *  T-póstur: lks17@hi.is
 *
 *  Lýsing  : Klasi sem býr til veitingar fyrir matseðilinn
 *
 *
 *
 *
 *****************************************************************************/
public class Matsedill {
    /**
     * Matseðillinn
     */
    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    /**
     * Aðferð sem býr til veitingar og bætir þeim við matseðilinn
     */
    public void setjaGogn() {
        veitingar.add(new Veitingar("Eldfjallarúlla", 1990));
        veitingar.add(new Veitingar("Surf and turf", 2090));
        veitingar.add(new Veitingar("Dreamy kalífornía", 2490));
        veitingar.add(new Veitingar("Spider roll", 1690));
        veitingar.add(new Veitingar("Poke skál", 2490));
        veitingar.add(new Veitingar("Red dragon", 1990));
        veitingar.add(new Veitingar("Tempura maki", 1690));
    }

    public ObservableList<Veitingar> getVeitingar() {
        return veitingar;
    }


}
