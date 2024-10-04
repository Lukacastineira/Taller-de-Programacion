/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParcialEscueladeCanto;

/**
 *
 * @author Luka
 */
public class ConcursodeCanto {
    private int cantCategorias;
    private int cantCancionesMax;
    private Cancion [][] canciones;

    public ConcursodeCanto(int unasCantCategorias, int unasCantCancionesMax) {
        this.setCantCategorias(unasCantCategorias);
        this.setCantCancionesMax(unasCantCancionesMax);
        this.setCanciones(new Cancion[this.getCantCategorias()][this.getCantCancionesMax()]);
        for (int i=0; i<this.getCantCategorias();i++){
            for (int j=0; j<this.getCantCancionesMax();j++){
                this.agregarCancion(i, j, new Cancion());
            }
        }
    }

    public int getCantCategorias() {
        return this.cantCategorias;
    }

    public void setCantCategorias(int cantCategorias) {
        this.cantCategorias = cantCategorias;
    }

    public int getCantCancionesMax() {
        return this.cantCancionesMax;
    }

    public void setCantCancionesMax(int cantCancionesMax) {
        this.cantCancionesMax = cantCancionesMax;
    }

    public Cancion[][] getCanciones() {
        return this.canciones;
    }

    
    public void setCanciones(Cancion[][] canciones) {
        this.canciones = canciones;
    }
    
    public void agregarCancion (int i, int j, Cancion can){
        this.getCanciones()[i][j]= can;
    }
    
   public void InterpretarCancion (int ident, Estudiante est, int puntaje){
       int i=0; int j; boolean encontre=false;
       while ((i<this.getCantCategorias())&& (!encontre)){
           j=0;
           while ((j<this.getCantCategorias())&& (!encontre)){
              if ( this.getCanciones()[i][j].getIdent()==ident){
                  encontre =true;
                  if (this.getCanciones()[i][j].getPuntajeProfes()<puntaje){
                      this.getCanciones()[i][j].setPuntajeProfes(puntaje);
                      this.getCanciones()[i][j].setMejorInterpretacion(est);
                  }
              }
              j++;
           }
           i++;
       }
       
   }
   
   public Estudiante getEstudianteGanador (int ident){
       int i=0; int j; boolean encontre=false; Estudiante ganador=null;
       while ((i<this.getCantCategorias())&& (!encontre)){
           j=0;
           while ((j<this.getCantCancionesMax())&& (!encontre) ){
               if (this.getCanciones()[i][j].getIdent()==ident){
                   ganador = this.getCanciones()[i][j].getEstudiante();
                   encontre=true;
               }
               j++;
           }
           i++;
       }
       return ganador;
   } 
   
   public Cancion getCancionCategoria (int categoria){
       int gandor=0; Cancion canGanadora = null;
       for (int j=0; j<this.getCantCancionesMax();j++){
             if (gandor < this.getCanciones()[categoria][j].getPuntajeProfes()){
                 canGanadora = this.getCanciones()[categoria][j];
             }
       }
       return canGanadora;
   }
   
   
   
}
