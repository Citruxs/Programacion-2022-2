public class Parametros {
    public static void main(String[] args){
        String[] impar = {("Este"),("es"),("un"),("Texto"),("de"),("Prueba"),("para"),("este"),("examen")};
        String[] par = {("Este"),("es"),("un"),("Texto"),("de"),("Prueba"),("para"),("este"),("examen")};
        for(int i = 0; i < impar.length; i++){
            if(i % 2 == 0){
                System.out.println("Tu palabra " + impar[i] + " es posicion impar");
            }
        }
        for(int i = 0; i < par.length; i++){
            if(i % 2 == 0){
                System.out.println("Tu palabra " + par[i] + " es posicion par");
            }
        }
    }
}
