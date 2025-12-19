package fr.cotedazur.univ.polytech.startingpoint;

import fr.cotedazur.univ.polytech.startingpoint.actions.Action;
import fr.cotedazur.univ.polytech.startingpoint.joueurs.Bot;
import fr.cotedazur.univ.polytech.startingpoint.objectifs.ObjectifPoseur;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private GameState gameState; // On remplace plateau, pioche, joueurs par GameState

    public Partie() {
        // 1. Création des joueurs
        List<Bot> bots = new ArrayList<>();
        Bot bot1 = new Bot("Bot 1");
        Bot bot2 = new Bot("Bot 2");
        bots.add(bot1);
        bots.add(bot2);

        // Setup objectifs pour la démo
        bot1.getInventaire().ajouterObjectif(new ObjectifPoseur(10, Couleur.VERT, 3));
        bot2.getInventaire().ajouterObjectif(new ObjectifPoseur(10, Couleur.ROSE, 3));

        // 2. Initialisation du GameState avec les joueurs
        this.gameState = new GameState(bots);
    }

    public void jouer() {
        int tour = 1;
        // On accède à la pioche via le GameState
        while (gameState.getPioche().getSize() > 0) {
            System.out.println("\n--- Tour " + tour + " ---");

            for (Bot bot : gameState.getJoueurs()) {
                // 1. Le bot décide en regardant le GameState
                Action action = bot.jouer(gameState);

                if (action != null) {
                    // 2. On applique l'action en passant le Contexte + le Joueur
                    action.appliquer(gameState, bot);
                    System.out.println(bot.getNom() + " " + action.toString());

                    // 3. Validation objectifs (bot a toujours besoin du plateau pour vérifier)
                    bot.verifierObjectifs(gameState.getPlateau());
                }
            }
            tour++;
        }
        afficherResultats();
    }

    private void afficherResultats() {
        System.out.println("\n--- Fin de partie ---");
        for (Bot bot : gameState.getJoueurs()) {
            System.out.println(bot.getNom() + " Score : " + bot.getScore());
        }
    }
}