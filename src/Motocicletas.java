
import java.util.ArrayList;




public class Motocicletas{
    private int propietario, cc, idmoto;
    private String matricula, marca, modelo;
    private float coste;
    
    
    public Motocicletas(){
        
    }
    
    public Motocicletas (int num, int duenyo, int c_c, String mat, String mark, String model, float precio){
        
        idmoto = num;
        propietario = duenyo;
        cc = c_c;
        matricula = mat;
        marca = mark;
        modelo = model;
        coste = precio;
}
    
    public float getCoste(){
        return coste;
    }
    
    public int getNumMotocicleta(){
        return idmoto;
    }
    public int getDueño(){
        return propietario;
    }
    
    public int getCC(){
        return cc;
    }
    
    public String getMatricula(){
        return matricula;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public String getMarca(){
        return marca;
    }
    
}