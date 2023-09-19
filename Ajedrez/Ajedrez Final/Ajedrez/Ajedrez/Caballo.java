public class Caballo extends Pieza {
    public Caballo(int x, int y, boolean color){
        super(x, y, color);
    }

    @Override
    public boolean mover(int x, int y, Pieza[][] tablero){
        int movx = Math.abs(this.x - x);
        int movy = Math.abs(this.y - y);
        int movf = movx*movx + movy*movy;
        if(movf == 5){
            return super.movimientoL(x, y, tablero);
        }
        return false;
    }

    public String toString(){
		String s = super.toString();
		s = "Caballo: " + s;
		return s;
	}
    
}