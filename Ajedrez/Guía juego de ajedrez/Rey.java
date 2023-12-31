public class Rey extends Pieza {

    @Override
    boolean[][] posicionesPosibles() {
        boolean [][] posicionesPosibles = new boolean [8][8];
        int x = this.getPosicion().getX();
        int y = this.getPosicion().getY();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (i == x || i == x+1 || i == x-1){
                    if(j == y || j == y+1 || j == y-1)
                        posicionesPosibles[i][j] = true;
                }                   
            }
        }
        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }
    
    @Override
     boolean movimientoPosible(Posicion posicionNueva, Tablero tablero){
           int x1 = getPosicion().getX();
           int y1 = getPosicion().getY();
           int x2 = posicionNueva.getX();
           int y2 = posicionNueva.getY();
         
           
       if(!posicionesPosibles()[x2][y2]){
           return false;
       }
       if (piezasDelMismoEquipo(tablero)[x2][y2]){
           return false;
       }
        return true;
    }
    
}
