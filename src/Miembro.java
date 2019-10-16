import java.util.ArrayList;

public class Miembro{
    private int idmiembro;
    private String nombre;
    private int num_motos;
    private float importe;
    private ArrayList<Motocicletas> motos_en_posesion = new ArrayList<Motocicletas>();
    

    public Miembro(){
        
    }
    
    public Miembro(String nom, int motos, int cont){
    nombre = nom;
    num_motos = motos;
    idmiembro = cont;
    }
    
    public void calcularImporte(){
        for(int i = 0; i < num_motos; i++)
            importe += motos_en_posesion.get(i).getCoste();
    }
    
    public int getIdMiembro(){
        return idmiembro;
    }
    
    public void setMiembro(int num){
        idmiembro = num;
    }
    
    public void anadirMoto(Motocicletas moto){
       motos_en_posesion.add(moto); 
    }
    
    public void quitarMoto(int num_m){
        motos_en_posesion.remove(num_m);
    }
    
    public int numMoto (){
        return motos_en_posesion.size();
    }
    
    public float getCoste(){
        return importe;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    
    
    
}