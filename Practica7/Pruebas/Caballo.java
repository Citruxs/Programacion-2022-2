//Andres Limon Cruz, Facultad de ciencias
public class Caballo extends Pieza {
    public Caballo(int x, int y, boolean color){
        super(x,y,color);
    }

    public boolean mover(int x, int y, Pieza[][] tablero){
        int movx = Math.abs(super.posicionX-x);
        int movy = Math.abs(super.posicionY-y);
        if(movx !=2){
            if(movx != 1 ){
            return false;
            }
            else if(movy ==1){
                return false;
            }
        }
        else if(movx ==2 && movy !=1){
            return false;
        }
        if(tablero[x][y] != null && tablero[x][y].color != super.color){
            tablero[x][y] = this;
        }
        super.posicionY = y;
        super.posicionX =x;
        return true;
    }

    public String toString(){
        String s = "Caballo ";
        if(this.color){
            s+= "Blanco\n";
        }
        else{
            s+= "Negro\n";
        }
        s += super.posicionX + "," + super.posicionY;
        return s;
    }
}
