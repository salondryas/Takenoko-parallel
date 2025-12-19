package fr.cotedazur.univ.polytech.startingpoint.objectifs;

import fr.cotedazur.univ.polytech.startingpoint.GameState;
import fr.cotedazur.univ.polytech.startingpoint.joueurs.Bot;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;

import java.util.List;

public class ObjectifPanda extends Objectif {
    private final Couleur couleur;
    private final int nombreRequis;

    public ObjectifPanda(Couleur couleur, int nombreRequis) {
        this.couleur = couleur;
        this.nombreRequis = nombreRequis;
    }

    @Override
    public int getPoints() {
        return 3; // Score fixe pour ce Milestone
    }

    @Override
    public boolean valider(GameState gameState, Bot bot) {
        // 1. Compter les bambous de la bonne couleur dans l'inventaire
        int compteur = 0;
        List<Couleur> bambousDuBot = bot.getInventaire().getBambous(); // Assurez-vous d'avoir ce getter

        for (Couleur c : bambousDuBot) {
            if (c == this.couleur) {
                compteur++;
            }
        }

        // 2. Si on en a assez, on valide ET on consomme
        if (compteur >= nombreRequis) {
            // On retire les bambous utilisés
            for (int i = 0; i < nombreRequis; i++) {
                bot.getInventaire().retirerBambou(this.couleur);
            }
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Objectif Panda : Manger " + nombreRequis + " bambous " + couleur;
    }
}