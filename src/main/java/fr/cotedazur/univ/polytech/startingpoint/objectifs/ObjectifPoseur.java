package fr.cotedazur.univ.polytech.startingpoint.objectifs;

import fr.cotedazur.univ.polytech.startingpoint.GameState;
import fr.cotedazur.univ.polytech.startingpoint.joueurs.Bot;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;
// ... autres imports

public class ObjectifPoseur extends Objectif {
    // ... vos attributs existants (nombre, couleur...)

    public ObjectifPoseur(int nombre, Couleur couleur) { // Suppression des points dans le constructeur
        // ... initialisation
    }

    @Override
    public int getPoints() {
        return 2; // Score fixe pour ce Milestone
    }

    @Override
    public boolean valider(GameState gameState, Bot bot) {
        // Votre logique existante, en utilisant gameState.getPlateau()
        // ...
        return false; // placeholder
    }
}