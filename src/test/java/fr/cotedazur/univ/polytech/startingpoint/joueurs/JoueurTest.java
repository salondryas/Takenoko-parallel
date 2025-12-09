package fr.cotedazur.univ.polytech.startingpoint.joueurs;

import fr.cotedazur.univ.polytech.startingpoint.plateau.PiocheParcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Plateau;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static fr.cotedazur.univ.polytech.startingpoint.plateau.PiocheParcelle.NOMBRE_PARCELLES_INITIAL;
import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {
    PiocheParcelle piocheParcelle;
    Joueur j1;

    @BeforeEach
    void init() {
        piocheParcelle = new PiocheParcelle();
        j1 = new Joueur("Nathan");
    }

    @Test
    void testJoueurPiocheParcelles() {
        // Voir si le nombre de cartes dans la pioche est cohérent
        assertEquals(NOMBRE_PARCELLES_INITIAL, piocheParcelle.getSize());
        j1.piocherCarte(piocheParcelle);
        assertEquals(NOMBRE_PARCELLES_INITIAL-1, piocheParcelle.getSize());

        // On tire jusqu'à ne plus rien avoir dans la pioche
        for (int i = 0; i<NOMBRE_PARCELLES_INITIAL-1; i++) {
            j1.piocherCarte(piocheParcelle);
        }

        // La pioche est vide !
        j1.piocherCarte(piocheParcelle);
    }
}