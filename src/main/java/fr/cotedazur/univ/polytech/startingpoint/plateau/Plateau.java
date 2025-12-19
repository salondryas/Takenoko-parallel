package fr.cotedazur.univ.polytech.startingpoint.plateau;

import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Couleur;
import fr.cotedazur.univ.polytech.startingpoint.utilitaires.Position;

import java.util.*;

public class Plateau {
    // Utilisation de constantes pour éviter de recréer ces objets
    public static final Position POSITION_ORIGINE = new Position(0, 0, 0); // J'assume que Position a 3 coord (cubic)
    public static final Parcelle PARCELLE_ORIGINE = new Parcelle(POSITION_ORIGINE, Couleur.AUCUNE);

    private final Map<Position, Parcelle> parcelles;

    public Plateau() {
        parcelles = new HashMap<>();
        // On pose l'étang au démarrage
        parcelles.put(POSITION_ORIGINE, PARCELLE_ORIGINE);
    }

    public void placerParcelle(Parcelle parcelle, Position position) {
        parcelles.put(position, parcelle);
    }

    public Parcelle getParcelle(Position position) {
        return parcelles.get(position);
    }

    public boolean isPositionDisponible(Position position) {
        return (!parcelles.containsKey(position));
    }

    public List<Position> getEmplacementsDisponibles() {
        List<Position> disponibles = new ArrayList<>();
        Set<Position> candidats = new HashSet<>();

        // 1. On récupère tous les voisins vides autour des tuiles existantes
        for (Position posOccupee : parcelles.keySet()) {
            for (PositionsVoisinesOrigine direction : PositionsVoisinesOrigine.values()) {
                Position voisin = posOccupee.add(direction.getPositionVoisine());
                if (!parcelles.containsKey(voisin)) {
                    candidats.add(voisin);
                }
            }
        }

        // 2. On filtre : on ne garde que ceux qui respectent la règle
        for (Position candidat : candidats) {
            if (respecteReglePose(candidat)) {
                disponibles.add(candidat);
            }
        }

        return disponibles;
    }

    /**
     * Vérifie la règle en UNE SEULE boucle optimisée :
     * - Si le voisin est l'étang -> VALIDE (Return true direct)
     * - Sinon on compte les voisins occupés -> Si >= 2 -> VALIDE
     */
    private boolean respecteReglePose(Position position) {
        int nbVoisinsOccupes = 0;

        for (PositionsVoisinesOrigine direction : PositionsVoisinesOrigine.values()) {
            Position voisin = position.add(direction.getPositionVoisine());

            // Optimisation : Si le voisin EST l'étang, la position est valide immédiatement
            if (voisin.equals(POSITION_ORIGINE)) {
                return true;
            }

            if (parcelles.containsKey(voisin)) {
                nbVoisinsOccupes++;
            }
        }

        return nbVoisinsOccupes >= 2;
    }

    public Map<Position, Parcelle> getParcellesMap() {
        return new HashMap<>(parcelles);
    }
}