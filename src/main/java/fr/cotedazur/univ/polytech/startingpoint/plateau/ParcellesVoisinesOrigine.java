package fr.cotedazur.univ.polytech.startingpoint.plateau;

import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Position;

public enum ParcellesVoisinesOrigine {
    UN(new Position(1,-1,0)),
    DEUX(new Position(-1,1,0)),
    TROIS(new Position(0,-1,1)),
    QUATRE(new Position(0,1,-1)),
    CINQ(new Position(1,0,-1)),
    SIX(new Position(-1,0,1)),
    ;
    private Position positionVoisine;

    ParcellesVoisinesOrigine(Position positionVoisine) {
        this.positionVoisine=positionVoisine;
    }

    public Position getPositionVoisine() {
        return positionVoisine;
    }
}
