public class Torre extends Pieza{
    public Torre(int x, int y, boolean color){
        super(x, y, color);
    }

    @Override
    public boolean mover(int x, int y, Pieza[][] tablero){
        if (this.x == x) {
            if (this.y < y) {
                return super.delantera(x, y, tablero);					
            }else{
                return super.trasera(x, y, tablero);
            }				
        }
        if (this.y == y) {
            if (this.x < x) {
                return super.derecha(x, y, tablero);					
            }else{
                return super.izquierda(x, y, tablero);
            }
        }else{
            return false;
        }
    }
	public String toString(){
		String s = super.toString();
		s = "Torre: " + s;
		return s;
	}
}
