public class Escaque {
    private boolean color;
    private Pieza pieza;
    
    public Escaque(){
        pieza = new NoPieza();
    }
    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    
    
    
}
