package fr.cotedazur.univ.polytech.startingpoint.plateau;

import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Placable;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Position;

public class Parcelle extends Placable {
    private Couleur couleur;

    //constructeur pour la pioche des parcelles
    public Parcelle(Couleur couleur){
        super();
        this.couleur = couleur;
    }

    //constructeur pour l'utilisation des parcelles dans le jeu
    public Parcelle(Position position, Couleur couleur) {
        super(position);
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        if (position==null) return couleur.toString();
        return couleur + " : " + super.toString();
    }
}
