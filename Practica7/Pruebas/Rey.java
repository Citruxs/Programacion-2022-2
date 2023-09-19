//Andres Limon Cruz, Facultad de ciencias
public class Rey extends Pieza{
    public Rey(int x, int y, boolean color){
        super(x,y,color);
    }
    
    public boolean mover(int x, int y, Pieza[][] tablero){
        //Movimiento vertical
        int movx = Math.abs(super.posicionX-x);
        int movy = Math.abs(super.posicionY-y);
        if(x == super.posicionX){
            if(super.posicionY != y){
                if(movy != 1){
                    return false;
                }
            }
            if(tablero[x][y] != null && tablero[x][y].color != super.color){
                tablero[x][y] = this;
            }
            super.posicionY = y;
            return true;          
        }

        else if(y == super.posicionY){
            if(super.posicionX != x){
                if (movx !=1){
                    return false;
                }

            }
            if(tablero[x][y] != null && tablero[x][y].color != super.color){
                tablero[x][y] = this;
            }
            super.posicionY = y;
            return true;
        }

        else if(super.posicionX != x && super.posicionY !=y){
            if(movx != 1 && movy != 1){
                return false;
            }
            if(tablero[x][y] != null && tablero[x][y].color != super.color){
                tablero[x][y] = this;
            }
            super.posicionY = y;
            return true;
        }

        else{
            return false;
        }
    }

    public String toString(){
        String s = "Rey ";
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
