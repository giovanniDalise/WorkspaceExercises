public enum Coordinate {
    A(0, 0),
    B(3, 4),
    C(7, 2),
    D(1, 5),
    E(6, 1);

    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
