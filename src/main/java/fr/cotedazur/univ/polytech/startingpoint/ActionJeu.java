package fr.cotedazur.univ.polytech.startingpoint;

import fr.cotedazur.univ.polytech.startingpoint.plateau.Parcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.PiocheParcelle;
import fr.cotedazur.univ.polytech.startingpoint.plateau.Plateau;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Position;

import java.util.List;

public class ActionJeu {
    //classe pour définir les 5 actions du jeu comme poser une parcelle, déplacer le panda, le jardinier, piocher une carte objectif ...etc

    public void poserParcelleAleatoirement(PiocheParcelle pioche, Plateau plateau) {
        Parcelle parcellePiochee = pioche.piocherParcelle(); //pioche
        List<Position> emplacementsDispo = plateau.getEmplacementsDisponibles();//regarde les disponibles
        Position positionChoisie = emplacementsDispo.get(0);//en prend 1 (la première par exemple)
        plateau.placerParcelle(parcellePiochee, positionChoisie); //la pose

    }
}
