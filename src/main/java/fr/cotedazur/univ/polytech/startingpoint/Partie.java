package fr.cotedazur.univ.polytech.startingpoint;

import fr.cotedazur.univ.polytech.startingpoint.joueurs.Joueur;
import fr.cotedazur.univ.polytech.startingpoint.plateau.PiocheParcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private List<Joueur> joueurs;
    private Plateau plateau;
    private PiocheParcelle piocheParcelle;

    Partie(List<Joueur> joueurs) {
        this.joueurs = new ArrayList<>();
        this.joueurs.addAll(joueurs);
        plateau = new Plateau();
        piocheParcelle = new PiocheParcelle();
    }


}
