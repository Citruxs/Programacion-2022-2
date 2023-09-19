//Andres Limon Cruz, Facultad de ciencias
public class Peon extends Pieza {
    public Peon(int x, int y, boolean color){
        super(x,y,color);
    }

    public boolean mover(int x, int y, Pieza[][] tablero){
        //Las blancas estan en la parte inferior del tablero y las negras en la parte superior
        int movx = Math.abs(super.posicionX -x);
        if(color == true){
            if(super.posicionX == x){
                if(super.posicionY - y != 1){
                    return false;
                }
            }

            else if(super.posicionX != x){
                if(super.posicionY == 1 && movx == 1){
                    if(tablero[x][y] == null){
                        return false;
                    }
                }
                else if(movx != 1){
                    return false;
                }
            }
            else{
                return false;
            }
            if(tablero[x][y] != null && tablero[x][y].color != super.color){
                tablero[x][y] = this;
            }
            super.posicionY = y;
            super.posicionX =x;
            return true;  
        }
        else if(color == false){
            if(super.posicionX == x){
                if(super.posicionY - y != -1){
                    return false;
                }
            }

            else if(super.posicionX != x){
                if(super.posicionY -y == -1 && movx ==1){
                    if(tablero[x][y] == null){
                        return false;
                    }
                }
                else if (movx != 1){
                    return false;
                }
            }
            else if(super.posicionX != x && super.posicionY ==y){
                return false;
            }
            else{
                return false;
            }
            if(tablero[x][y] != null && tablero[x][y].color != super.color){
                tablero[x][y] = this;
            }
            super.posicionY = y;
            super.posicionX =x;
            return true;  
        }

        return false;
    }
    public String toString(){
        String s = "Peon ";
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
