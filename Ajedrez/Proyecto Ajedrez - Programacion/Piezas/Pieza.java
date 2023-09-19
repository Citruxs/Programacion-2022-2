public abstract class Pieza {
    protected int posicionX;
    protected int posicionY;
    protected boolean color;
    
    public Pieza(int x, int y, boolean color){
        this.posicionX = x;
        this.posicionY = y;
        this.color = color;
    }

    public abstract boolean mover(int x, int y, Pieza[][] tablero);
}
