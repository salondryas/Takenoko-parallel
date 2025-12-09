package fr.cotedazur.univ.polytech.startingpoint;

import fr.cotedazur.univ.polytech.startingpoint.joueurs.Bot;
import fr.cotedazur.univ.polytech.startingpoint.plateau.PiocheParcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Plateau;

public class GameEngine {

    public static void main(String[] args) {
        System.out.println("--- DÉBUT DE LA PARTIE (TAKENOKO - GAME ENGINE) ---");

        // 1. Initialisation
        Plateau plateau = new Plateau();
        PiocheParcelle pioche = new PiocheParcelle();

        Bot bot1 = new Bot("Bot Cante");
        Bot bot2 = new Bot("Bot Candid");

        // 2. Boucle de jeu
        int tour = 1;
        while (pioche.getSize() > 0) {
            System.out.println("\n--- Tour " + tour + " ---");

            if (pioche.getSize() > 0) bot1.jouer(plateau, pioche);
            if (pioche.getSize() > 0) bot2.jouer(plateau, pioche);

            tour++;
        }

        // 3. Résultats
        System.out.println("\n================ FIN ================");
        System.out.println(bot1.getNom() + " : " + bot1.getScore());
        System.out.println(bot2.getNom() + " : " + bot2.getScore());

        if (bot1.getScore() > bot2.getScore()) System.out.println("🏆 " + bot1.getNom() + " gagne !");
        else if (bot2.getScore() > bot1.getScore()) System.out.println("🏆 " + bot2.getNom() + " gagne !");
        else System.out.println("🤝 Égalité !");
    }
}