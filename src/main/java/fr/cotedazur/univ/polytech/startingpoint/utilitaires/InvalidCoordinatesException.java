package fr.cotedazur.univ.polytech.startingpoint.utilitaires;

public class InvalidCoordinatesException extends RuntimeException {
    private final int q;
    private final int r;
    private final int s;

    public InvalidCoordinatesException(String message, int q, int r, int s) {
        super(message);
        this.q=q;
        this.r=r;
        this.s=s;
    }

    public int getQ() {
        return q;
    }
    public int getR() {
        return r;
    }
    public int getS() {
        return s;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "[q = "+q+", r = "+r+", s = "+s+"]";
    }
}
