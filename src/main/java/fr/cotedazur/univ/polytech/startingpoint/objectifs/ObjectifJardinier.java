package fr.cotedazur.univ.polytech.startingpoint.objectifs;

import fr.cotedazur.univ.polytech.startingpoint.GameState;
import fr.cotedazur.univ.polytech.startingpoint.joueurs.Bot;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Parcelle;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Position;

import java.util.Map;

public class ObjectifJardinier extends Objectif {
    private final Couleur couleur;
    private final int tailleRequise;

    public ObjectifJardinier(Couleur couleur, int tailleRequise) {
        this.couleur = couleur;
        this.tailleRequise = tailleRequise;
    }

    @Override
    public int getPoints() {
        return 4; // Score fixe pour ce Milestone
    }

    @Override
    public boolean valider(GameState gameState, Bot bot) {
        // On parcourt toutes les parcelles du plateau
        Map<Position, Parcelle> parcelles = gameState.getPlateau().getParcellesMap();

        for (Parcelle p : parcelles.values()) {
            // Si une parcelle a la bonne couleur et la bonne taille de bambou (ou plus)
            if (p.getCouleur() == this.couleur && p.getNbBambou() >= tailleRequise) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Objectif Jardinier : Bambou " + couleur + " de taille " + tailleRequise;
    }
}