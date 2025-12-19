package fr.cotedazur.univ.polytech.startingpoint.objectifs;

import fr.cotedazur.univ.polytech.startingpoint.GameState;
import fr.cotedazur.univ.polytech.startingpoint.joueurs.Bot;

public abstract class Objectif {
    // Plus d'attribut "points" ici, chaque sous-classe gère ses points.

    public Objectif() {
    }

    /**
     * Retourne le nombre de points que vaut cet objectif.
     */
    public abstract int getPoints();

    /**
     * Vérifie si l'objectif est rempli.
     * @param gameState L'état complet du jeu (Plateau, Pioche, etc.)
     * @param bot Le bot qui tente de valider l'objectif (pour son inventaire)
     * @return true si l'objectif est validé
     */
    public abstract boolean valider(GameState gameState, Bot bot);
}