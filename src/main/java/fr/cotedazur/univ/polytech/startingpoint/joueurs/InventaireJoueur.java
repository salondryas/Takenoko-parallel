package fr.cotedazur.univ.polytech.startingpoint.joueurs;

import fr.cotedazur.univ.polytech.startingpoint.plateau.Parcelle;

import java.util.ArrayList;
import java.util.List;

public class InventaireJoueur {
    private List<Parcelle> parcelles;
    //private List<Amenagement> amenagements;

    InventaireJoueur() {
        this.parcelles = new ArrayList<>();
    }

    public void addParcelle(Parcelle parcelle) {
        this.parcelles.add(parcelle);
    }
    public void removeParcelle(Parcelle parcelle) {
        this.parcelles.remove(parcelle);
    }


}
