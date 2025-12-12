package fr.cotedazur.univ.polytech.startingpoint;

public class GameEngine {

    public static void main(String[] args) {
        // 1. On crée une instance de la partie (le constructeur initialise tout : bots, plateau...)
        Partie partie = new Partie();

        // 2. On lance le jeu
        partie.jouer();
    }
}