package fr.cotedazur.univ.polytech.startingpoint.plateau;

import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PiocheParcelle{
    public static final int NOMBRE_PARCELLES_INITIAL = 27; //il y a 27 cartes parcelles dans la pioche si one compte le marais comme la parcelle centrale donc pas dans la pioche{
    private List<Parcelle> piocheDeParcelle = new ArrayList<>(NOMBRE_PARCELLES_INITIAL);

    public PiocheParcelle() {
        remplirPioche();
        melangePioche();
    }

    public int getSize() {
        return piocheDeParcelle.size();
    }

    //pour remplir la pioche créée vide précédemment, on ajoute 9 parcelles de chaque couleur pour un total de 27 parcelles
    public void remplirPioche(){
        for (int i = 0; i < 9; i++) {
            piocheDeParcelle.add(new Parcelle(Couleur.ROSE));
        }
        for (int i = 0; i < 9; i++) {
            piocheDeParcelle.add(new Parcelle(Couleur.VERT));
        }
        for (int i = 0; i < 9; i++) {
            piocheDeParcelle.add(new Parcelle(Couleur.JAUNE));
        }
    }

    public void melangePioche(){
        Collections.shuffle(piocheDeParcelle);
    }

    public Parcelle piocherParcelle(){
        // Vérification si la pioche n'est pas vide
        if (this.piocheDeParcelle.isEmpty()) {
            System.out.println("La pioche de parcelles est vide !");
            return null; // ou lance une exception
        }

        // Retirer et retourner la première parcelle
        Parcelle elementPioche = this.piocheDeParcelle.remove(0);
        return elementPioche;
    }

    public String toString() {
        return piocheDeParcelle.toString();
    }
}
