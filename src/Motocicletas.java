
import java.util.ArrayList;




public class Motocicletas{
    private int propietario, cc, idmoto, coste, otros_gastos;
    private String matricula, marca, modelo;
    
    
    public Motocicletas(){
        
    }
    
    public Motocicletas (int num, int duenyo, int c_c, String mat, String mark, String model, int precio, int og){
        
        idmoto = num;
        propietario = duenyo;
        cc = c_c;
        matricula = mat;
        marca = mark;
        modelo = model;
        coste = precio;
        otros_gastos = og;
}
    
    public void IncrementarGastos(int mas){
        otros_gastos += mas;
    }
    
    public int getCoste(){
        return coste;
    }
    
    public int getOtrosGastos(){
        return otros_gastos;
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