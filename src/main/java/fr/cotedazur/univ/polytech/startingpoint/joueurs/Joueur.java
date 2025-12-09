package fr.cotedazur.univ.polytech.startingpoint.joueurs;

import fr.cotedazur.univ.polytech.startingpoint.plateau.Parcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.PiocheParcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Plateau;

public class Joueur {
    private int score;
    private String name;
    private InventaireJoueur inventaire;

    public Joueur(String name) {
        this.name = name;
        this.score = 0;
        this.inventaire = new InventaireJoueur();
    }

    // TODO: pouvoir choisir entre trois parcelles
    public void piocherCarte(PiocheParcelle piocheParcelle){
        inventaire.addParcelle(piocheParcelle.piocherParcelle());
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

}
