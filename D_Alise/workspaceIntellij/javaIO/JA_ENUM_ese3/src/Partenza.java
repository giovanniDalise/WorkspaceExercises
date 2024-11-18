public enum Partenza {
    A(Coordinate.A),
    B(Coordinate.B),
    C(Coordinate.C),
    D(Coordinate.D),
    E(Coordinate.E);

    private final Coordinate coordinate;

    Partenza(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
