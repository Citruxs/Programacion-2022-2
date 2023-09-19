//Andres Limon Cruz, Facultad de ciencias
public class Torre extends Pieza{

    public Torre(int x, int y, boolean color){
        super(x,y,color);
    }
    public boolean mover(int x, int y, Pieza[][] tablero){
        //Movimiento vertical
        if(x == super.posicionX){
            if(super.posicionY < y){
                for(int i = super.posicionY + 1; i < y; i++ ){
                        if(tablero[super.posicionX][i] != null){
                            return false;
                        }
                    }
            } else{
                for(int i = y; i < this.posicionY + 1; i++){
                    if(tablero[super.posicionX][i] != null){
                        return false;
                    }
                }
            }
            if(tablero[x][y] != null && tablero[x][y].color != super.color){
                tablero[x][y] = this;
            }
            super.posicionX = x;
            super.posicionY = y;
            return true;
        }
        //Movimiento horizontal
        if(y == super.posicionY){
            if(super.posicionX < x){
                for(int i = super.posicionX + 1; i < x; i++ ){
                        if(tablero[i][super.posicionY] != null){
                            return false;
                        }
                    }
            } else{
                for(int i = x; i < this.posicionX + 1; i++){
                    if(tablero[i][super.posicionY] != null){
                        return false;
                    }
                }
            }
            if(tablero[x][y] != null && tablero[x][y].color != super.color){
                tablero[x][y] = this;
            }
            super.posicionX =x;
            super.posicionY = y;
            return true;
        }

        return false;
    }
    public String toString(){
        String s = "Torre ";
        if(this.color){
            s+= "Blanca\n";
        }
        else{
            s+= "Negra\n";
        }
        s += super.posicionX + "," + super.posicionY;
        return s;
    }
}
