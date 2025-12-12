package fr.cotedazur.univ.polytech.startingpoint;

import fr.cotedazur.univ.polytech.startingpoint.actions.Action;
import fr.cotedazur.univ.polytech.startingpoint.joueurs.Bot;
import fr.cotedazur.univ.polytech.startingpoint.objectifs.ObjectifPoseur; // Import du nouvel objectif
import fr.cotedazur.univ.polytech.startingpoint.plateau.PiocheParcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Plateau;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private List<Bot> joueurs;
    private Plateau plateau;
    private PiocheParcelle pioche;

    public Partie() {
        this.plateau = new Plateau();
        this.pioche = new PiocheParcelle();
        this.joueurs = new ArrayList<>();

        // Création des bots
        Bot bot1 = new Bot("Bot 1");
        Bot bot2 = new Bot("Bot 2");
        joueurs.add(bot1);
        joueurs.add(bot2);

        // DISTRIBUTION DES OBJECTIFS (Pour tester l'Issue #17)
        // Bot 1 doit poser 3 tuiles VERTES pour gagner 10 points
        bot1.getInventaire().ajouterObjectif(new ObjectifPoseur(10, Couleur.VERT, 3));
        // Bot 2 doit poser 3 tuiles ROSES
        bot2.getInventaire().ajouterObjectif(new ObjectifPoseur(10, Couleur.ROSE, 3));
    }

    public void jouer() {
        int tour = 1;
        while (pioche.getSize() > 0) {
            System.out.println("\n--- Tour " + tour + " ---");

            for (Bot bot : joueurs) {
                // 1. Le bot décide de son action (Command Pattern - Issue #15)
                Action action = bot.jouer(plateau, pioche);

                if (action != null) {
                    // 2. La partie exécute l'action
                    action.appliquer(plateau);
                    System.out.println(bot.getNom() + " " + action.toString());

                    // 3. Validation des objectifs (Issue #18)
                    bot.verifierObjectifs(plateau);
                }
            }
            tour++;
        }
        afficherResultats();
    }

    private void afficherResultats() {
        System.out.println("\n--- Fin de partie ---");
        for (Bot bot : joueurs) {
            System.out.println(bot.getNom() + " Score : " + bot.getScore());
        }
    }
}
//
//// Bot 1 : Doit poser 8 tuiles VERTES (Très dur, il risque de rater)
//bot1.getInventaire().ajouterObjectif(new ObjectifPoseur(50, Couleur.VERT, 8));
//
//// Bot 2 : A deux petits objectifs
//        bot2.getInventaire().ajouterObjectif(new ObjectifPoseur(5, Couleur.ROSE, 2));
//        bot2.getInventaire().ajouterObjectif(new ObjectifPoseur(5, Couleur.JAUNE, 2));