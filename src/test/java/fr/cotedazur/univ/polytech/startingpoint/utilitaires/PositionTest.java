package fr.cotedazur.univ.polytech.startingpoint.utilitaires;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    Position origine;
    Position position1;
    Position position2;

    @BeforeEach
    void init(){
        origine = new Position(0,0);
        position1 = new Position(1,-1,0);
        position2 = new Position(3,-2,-1);
    }

    @Test
    void testToString(){
        assertEquals("(0, 0, 0)", origine.toString(), "Le toString de l'origine est incorrect");
    }
    @Test
    void testPositionInvalide(){
        InvalidCoordinatesException exception = assertThrows(InvalidCoordinatesException.class, () -> {
            new Position(3,-2,1);
        }, "Il faut recevoir un message d'erreur quand la position est invalide" );
        assertEquals("Coordonnées invalides : q+r+s doit être égal à 0 ; [q = 3, r = -2, s = 1]", exception.getMessage());
    }

    @Test
    void testDistance() {
        assertEquals(1,position1.distance(origine), "La distance entre la position d'origine et (1,-1,0) doit être 1");
        assertEquals(3,position2.distance(origine), "La distance entre la position d'origine et (3,-2,-1) doit être 3");
    }
}