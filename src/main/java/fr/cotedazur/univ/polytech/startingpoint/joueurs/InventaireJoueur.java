package fr.cotedazur.univ.polytech.startingpoint.joueurs;

import fr.cotedazur.univ.polytech.startingpoint.objectifs.Objectif;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;

import java.util.ArrayList;
import java.util.List;

public class InventaireJoueur {
    private int score;
    private List<Objectif> objectifs;
    // NOUVEAU : Stockage des bambous mangés
    private List<Couleur> bambous;

    public InventaireJoueur() {
        this.score = 0;
        this.objectifs = new ArrayList<>();
        this.bambous = new ArrayList<>();
    }

    // --- Gestion des Objectifs ---
    public void ajouterObjectif(Objectif objectif) {
        this.objectifs.add(objectif);
    }

    public List<Objectif> getObjectifs() {
        return new ArrayList<>(objectifs);
    }

    // --- Gestion du Score ---
    public void ajouterPoints(int points) {
        this.score += points;
    }

    public int getScore() {
        return score;
    }

    // --- Gestion des Bambous (NOUVEAU) ---
    public void ajouterBambou(Couleur couleur) {
        bambous.add(couleur);
    }

    /**
     * Tente de retirer un bambou d'une couleur spécifique.
     * @return true si le bambou a été trouvé et retiré, false sinon.
     */
    public boolean retirerBambou(Couleur couleur) {
        return bambous.remove(couleur);
    }

    public int getNombreBambous() {
        return bambous.size();
    }

    public List<Couleur> getBambous() {
        return new ArrayList<>(bambous);
    }

    @Override
    public String toString() {
        return "Score: " + score + ", Bambous: " + bambous;
    }
}