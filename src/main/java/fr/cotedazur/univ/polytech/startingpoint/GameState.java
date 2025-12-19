package fr.cotedazur.univ.polytech.startingpoint;

import fr.cotedazur.univ.polytech.startingpoint.joueurs.Bot;
import fr.cotedazur.univ.polytech.startingpoint.plateau.PiocheParcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Plateau;

import java.util.List;

/**
 * Cette classe représente l'état complet du jeu à un instant T.
 * Elle sert de "Contexte" pour les Actions et les Bots.
 */
public class GameState {
    private final Plateau plateau;
    private final PiocheParcelle pioche;
    private final List<Bot> joueurs;

    public GameState(List<Bot> joueurs) {
        this.joueurs = joueurs;
        this.plateau = new Plateau();
        this.pioche = new PiocheParcelle();
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public PiocheParcelle getPioche() {
        return pioche;
    }

    public List<Bot> getJoueurs() {
        return joueurs;
    }
}