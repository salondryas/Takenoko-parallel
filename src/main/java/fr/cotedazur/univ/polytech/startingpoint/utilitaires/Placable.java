package fr.cotedazur.univ.polytech.startingpoint.utilitaires;

public abstract class Placable {
    protected Position position;

    public Placable(Position position) {
        this.position=position;
    }

    public Placable(){}

    @Override
    public String toString() {
        return position.toString();
    }

    public Position getPosition(){
        return position;
    }
}
