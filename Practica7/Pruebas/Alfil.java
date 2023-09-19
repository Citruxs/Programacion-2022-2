//Andres Limon Cruz, Facultad de ciencias
public class Alfil extends Pieza{
    
    public Alfil(int x, int y, boolean color){
        super(x,y,color);
    }
    
    public boolean mover(int x, int y, Pieza[][] tablero){
        int movx = Math.abs(super.posicionX-x);
        int movy = Math.abs(super.posicionY-y);
        if(movx==0){
            return false;
        }
        else if(movx == movy){
            if(super.posicionY < y){
                for(int i = super.posicionX + 1; i < x; i++){
                    for(int j = super.posicionY+1; j<y;j++){
                        if(tablero[i][j] != null){
                            return false;
                        }
                    }
                }
            }
            else{
                for(int i = x; i < this.posicionX; i++){
                    for(int j = y; j<this.posicionY;j++){
                        if(tablero[i][j] != null){
                            return false;
                        }
                    }
                }
            }
            if(tablero[x][y] != null && tablero[x][y].color != super.color){
                tablero[x][y] = this;
            }
            super.posicionY = y;
            return true;
        }
        return false;
    }

    public String toString(){
        String s = "Alfil ";
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
