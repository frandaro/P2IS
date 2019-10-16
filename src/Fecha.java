/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
    

public class Fecha {

    private int dia;
    private int mes;
    private int anyo;

    public Fecha() {
    }

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    //Setters y Getters
    
    public void setDia(int d) {
        dia = d;
    }
    public void setMes(int m) {
        mes = m;
    }
    public void setAño(int a) {
        anyo = a;
    }
    public int getDia() {
        return dia;
        
         }
    public int getMes() {
        return mes;
    }
    public int getAño() {
        return anyo;
    }
}
