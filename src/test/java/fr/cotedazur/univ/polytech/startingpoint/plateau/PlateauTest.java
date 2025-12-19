package fr.cotedazur.univ.polytech.startingpoint.plateau;

import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {
    Position positionProche, positionProche2, positionLoin;
    List<Position> positionsAdjacentesOrigine,positionsAdjacentesProches;
    Parcelle parcelleRose;

    Plateau plateau;

    @BeforeEach
    void init() {
        plateau = new Plateau();

        positionProche = new Position(1,-1,0);
        parcelleRose = new Parcelle (Couleur.ROSE);
        positionsAdjacentesOrigine= List.of(
                new Position(0,-1),
                new Position(1,-1),
                new Position(-1,0),
                new Position(1,0),
                new Position(-1,1),
                new Position(0,1)
        );

        positionProche2 = new Position(1, 0, -1);
        positionsAdjacentesProches = List.of(
                new Position(1,-2),
                new Position(2,-2),
                new Position(0, -1),
                new Position(2,-1),
                new Position(1,0),
                new Position(-1,0),
                new Position(-1,1),
                new Position(0,1)
        );

        positionLoin = new Position(5, -5, 0);

        plateau = new Plateau();
    }

    @Test
    public void testParcellesVoisinesDisponibles(){
        // Positions voisines à l'origine
        assertEquals(positionsAdjacentesOrigine,plateau.getEmplacementsDisponibles(), "Pour la position voisine à l'origine, la liste des positions adjacentes disponibles ne concorde pas");
        // Position isolée
        assertEquals(6,plateau.getEmplacementsDisponibles().size(), "Pour la position isolée, la taille de la liste des positions adjacentes disponibles ne concorde pas");

        // On rajoute une parcelle au plateau pour un nouveau test avec deux tuiles adjacentes
        plateau.placerParcelle(parcelleRose, positionProche);

        // On refait le test avec une case en plus sur le plateau (et donc une case en moins de disponible)
        assertEquals(positionsAdjacentesProches, plateau.getEmplacementsDisponibles());
    }
    @Test
    void testRegleDesDeuxVoisins() {
        Plateau p = new Plateau();
        // L'étang est en 0,0,0 par défaut (virtuellement)

        // 1. On pose une tuile adjacente à l'étang (1, -1, 0) -> DOIT MARCHER
        Position pos1 = new Position(1, -1, 0);
        assertTrue(p.getEmplacementsDisponibles().contains(pos1), "Doit pouvoir poser près de l'étang");
        p.placerParcelle(new Parcelle(Couleur.VERT), pos1);

        // 2. On essaie de poser une tuile qui continue la ligne (2, -2, 0)
        // Elle toucherait pos1, mais pas l'étang. Elle n'aurait qu'un seul voisin.
        // -> DOIT ÊTRE INTERDIT
        Position posLoin = new Position(2, -2, 0);
        assertFalse(p.getEmplacementsDisponibles().contains(posLoin), "Interdit de poser avec 1 seul voisin si loin de l'étang");

        // 3. On pose une deuxième tuile près de l'étang (0, -1, 1)
        Position pos2 = new Position(0, -1, 1);
        p.placerParcelle(new Parcelle(Couleur.ROSE), pos2);

        // 4. Maintenant, la position (1, -2, 1) touche pos1 ET pos2.
        // -> DOIT MARCHER (2 voisins)
        Position posCoin = new Position(1, -2, 1);
        assertTrue(p.getEmplacementsDisponibles().contains(posCoin), "Doit pouvoir poser si 2 voisins");
    }
}