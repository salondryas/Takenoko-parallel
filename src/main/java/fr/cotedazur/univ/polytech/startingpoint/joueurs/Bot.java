package fr.cotedazur.univ.polytech.startingpoint.joueurs;

import fr.cotedazur.univ.polytech.startingpoint.MoteurObjectifs;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Parcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.PiocheParcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Plateau;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Position;

import java.util.List;
import java.util.Random;

public class Bot {
    private String nom;
    private int score;
    private Random random;
    private MoteurObjectifs moteurObjectifs;

    public Bot(String nom) {
        this.nom = nom;
        this.score = 0;
        this.random = new Random();
        this.moteurObjectifs = new MoteurObjectifs();
    }

    public void jouer(Plateau plateau, PiocheParcelle pioche) {
        // 1. Piocher une parcelle
        Parcelle parcellePiochee = pioche.piocherParcelle();

        // Si la pioche est vide (retourne null ou exception selon ton code), on arrête
        if (parcellePiochee == null) {
            System.out.println(nom + " ne peut plus piocher. Tour passé.");
            return;
        }

        // 2. Chercher les emplacements disponibles
        List<Position> coupsPossibles = plateau.getEmplacementsDisponibles();

        if (coupsPossibles.isEmpty()) {
            System.out.println(nom + " ne peut poser nulle part.");
            return;
        }

        // 3. Choisir une position au hasard (IA basique)
        Position positionChoisie = coupsPossibles.get(random.nextInt(coupsPossibles.size()));

        // 4. Poser la parcelle sur le plateau
        parcellePiochee.placer(plateau);

        // 5. Calculer le score (Règle Milestone 1 : adjacence couleur)
        int pointsGagnes = moteurObjectifs.calculerPointsPose(plateau, positionChoisie, parcellePiochee.getCouleur());
        this.score += pointsGagnes;

        // Log pour suivre la partie
        System.out.println(nom + " pose " + parcellePiochee + " en " + positionChoisie +
                " et gagne " + pointsGagnes + " points. (Score Total: " + score + ")");
    }

    public int getScore() {
        return score;
    }

    public String getNom() {
        return nom;
    }
}