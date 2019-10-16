import java.util.ArrayList;




public class Cesion{

    private int darmoto, recibemoto, moto, idcesion;
    private Fecha fcesion = new Fecha();
    

    public Cesion (){      
}
    
    public Cesion(int _idcesion, int prestador, int recibe, Fecha fecha, int m){
        idcesion = _idcesion;
        darmoto = prestador;
        recibemoto = recibe;
        fcesion = fecha;
        moto = m;
    }
    
    public Fecha getFecha() {
        return fcesion;
    }
    public  int getMotocicleta() {
        return moto;
        
         }
    public int getMiembroRecibe() {
        return recibemoto;
    }
    public int getMiembroDar() {
        return darmoto;
    }
    
    public int getCadenaId(){
        return idcesion;
    }
}