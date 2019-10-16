
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuACAMA
{
    
    private String nombre, matricula, marca, modelo;
    private int num_motos, cc, cont = 0, cont2 = 6, cont3 = 0, propietario, motocedida, nombre1, nombre2, opcion = -1;
    private Miembro miembro = new Miembro();
    private float coste;
    Fecha fecha = new Fecha();
    ArrayList<Motocicletas> todaslasmotos = new ArrayList<Motocicletas>();
    ArrayList<Cesion> cesiones = new ArrayList<Cesion>();
    ArrayList<Miembro> miembros = new ArrayList<Miembro>();
    Cesion cesion_aux = new Cesion();
    Motocicletas moto_aux = new Motocicletas();
    
    
    /**
     * Constructor principal
     */
    public MenuACAMA() throws IOException 
    {
       
        /**
         * Motocicletas de la asociacion
         */
        todaslasmotos.add(new Motocicletas(1, 0, 125, " ", "Vespa", "Primavera", 2500));
        todaslasmotos.add(new Motocicletas(2, 0, 125, " ", "Vespa", "Primavera", 2500));
        todaslasmotos.add(new Motocicletas(3, 0, 70, " ", "Motobeanae", "Poney AG2", 2300));
        todaslasmotos.add(new Motocicletas(4, 0, 200, " ", "Bultaco", "Primavera", 3800));
        todaslasmotos.add(new Motocicletas(5, 0, 75, " ", "Guzzi", "Cardelino 73", 1200));
        todaslasmotos.add(new Motocicletas(6, 0, 49, " ", "Ducati", "mini", 4000));
          
        Scanner option = new Scanner(System.in);
        Scanner cadena = new Scanner(System.in);
        
        /**
        * Bucle while que funciona como menu
        */
        while (opcion != -2)
        {
            
            System.out.println("\n1. Registrar un nuevo miembro");
            System.out.println("2. Registrar una nueva motocicleta");
            System.out.println("3. Registrar una cesión");
            System.out.println("4. Listar en pantalla los miembros con motos en posesión");
            System.out.println("5. Listar todas las motos");
            System.out.println("6. Mostrar las cesiones realizadas");
            System.out.println("7. Salir del programa");
            
            opcion = option.nextInt();
            
            switch(opcion){
                case 1:  //Registrar un nuevo miembro
                    cont++;
                    System.out.println("Dame el nombre del usuario a darse de alta: ");
                    nombre = cadena.nextLine();
                    
                    System.out.println("Cuantas motos tiene?");
                    num_motos = option.nextInt();
                    
                    miembro = new Miembro (nombre, num_motos, cont);

                    for (int i = 0; i < num_motos; i++)
                    {
                        System.out.println("Dame la matricula de la moto" +Integer.toString(i+1)+ ": ");
                        matricula = cadena.nextLine();
                        System.out.println("Dame los centimetros cubicos de la moto: ");
                        cc = option.nextInt();
                        System.out.println("Dame la marca de la moto: ");
                        marca = cadena.nextLine();
                        System.out.println("Dame el modelo de moto: ");
                        modelo = cadena.nextLine();
                        System.out.println("Dame el coste de la moto: ");
                        coste = option.nextFloat();
                        cont2++; //Añadimos una motocicleta al contador
                        
                        miembro.anadirMoto(new Motocicletas(cont2, cont, cc, marca, marca, modelo, coste));
                        todaslasmotos.add(new Motocicletas(cont2, cont, cc, marca, marca, modelo, coste));   
                    } 
                    
                    miembro.calcularImporte();
                    miembros.add(miembro);
                break;
                    
                case 2: //Registrar una nueva motocicleta 
                    
                        System.out.println("Dame la matricula de la moto a ingresar: ");
                        matricula = cadena.nextLine();
                        System.out.println("Dame los centimetros cubicos de la moto: ");
                        cc = option.nextInt();
                        System.out.println("Dame la marca de la moto: ");
                        marca = cadena.nextLine();
                        System.out.println("Dame el modelo de moto: ");
                        modelo = cadena.nextLine();
                        System.out.println("Dame el coste de la moto: ");
                        coste = option.nextFloat();
                        System.out.println("Quien va a ser el primer propietario?(Dame su codigo): ");
                        propietario = option.nextInt();
                        
                        if ((miembros.get(propietario - 1).getCoste() + coste) >= 6000.0)
                        System.out.println("NO se puede anadir la Motocicleta porque el propietario supera el limite de 6000€ permitido ");    
                        else{
                            cont2++;
                            todaslasmotos.add(new Motocicletas(cont2, propietario, cc, marca, marca, modelo, coste)); 
                            
                        }
                        
                    break;
                    
                case 3: //Registrar una cesión 
                    
                    System.out.println("Dame el id del usuario que va a ceder su motocicleta: ");
                    nombre1 = option.nextInt();
                    System.out.println("Dame el id del usuario que va a recibir cedida la motocicleta: ");
                    nombre2 = option.nextInt();
                    System.out.println("Dame el id de la motocicleta que va a ser cedida: ");
                    motocedida = option.nextInt();
                    System.out.println("Que dia se realiza la cesion?:");
                    fecha.setDia(option.nextInt());
                    System.out.println("Que mes se realiza la cesion?:");
                    fecha.setMes(option.nextInt());
                    System.out.println("Que anyo se realiza la cesion?:");
                    fecha.setAño(option.nextInt());
                    if ((miembros.get(nombre2 - 1).getCoste() + todaslasmotos.get(motocedida).getCoste()) >= 6000.0)
                    System.out.println("NO se puede anadir la Motocicleta porque el propietario supera el limite de 6000€ permitido ");    
                    else
                    {
                    cont3++;
                    cesiones.add(new Cesion(cont3 ,nombre1, nombre2, fecha, motocedida));
                    }
                             
                break;
                
                case 4: //Listar en pantalla los miembros con motos en posesión 
                    for(int i = 0; i < miembros.size();i++)
                    {
                        if(miembros.get(i).numMoto() > 0)
                        {
                            String Cadena_idmiembro = String.format("%03d", miembros.get(i).getIdMiembro());
                            System.out.println(Cadena_idmiembro + "\t" + miembros.get(i).getNombre());
                            System.out.println("\n");
                        }     
                    }
                    
                break;
                
                case 5: //Listar todas las motos  
                    for (int i = 0; i < todaslasmotos.size(); i++)
                    {
                       moto_aux = todaslasmotos.get(i);
                       String Cadena_idmoto = String.format("%03d", moto_aux.getNumMotocicleta());
                       System.out.println(Cadena_idmoto);
                       System.out.println(moto_aux.getMatricula()+ "\t" + moto_aux.getMarca() + "\t" + moto_aux.getModelo() + "\t" + moto_aux.getCC() + "CC" + "\t"+ moto_aux.getDueño());
                       System.out.println(moto_aux.getCoste());
                       System.out.println("\n"); 
                    }
                    
                break;
                
                case 6: // Mostrar las cesiones realizadas 
                    for (int i = 0; i < cesiones.size(); i++)
                    {
                       cesion_aux = cesiones.get(i);
                       String Cadena_idcesion = String.format("%03d", cesion_aux.getMiembroRecibe());
                       String Cadena_idcesion2 = String.format("%03d", cesion_aux.getMiembroDar());
                       
                       System.out.println(Cadena_idcesion + " " + miembros.get(cesion_aux.getMiembroRecibe() - 1).getNombre() + " recibe la moto: " + cesion_aux.getMotocicleta() + " del usuario con id:  " + Cadena_idcesion2 +" " + miembros.get(cesion_aux.getMiembroDar() - 1).getNombre());
                       System.out.println("Realizada en la fecha: " + cesion_aux.getFecha().getDia()+ "/" + cesion_aux.getFecha().getMes()+ "/" + cesion_aux.getFecha().getAño());
                       System.out.println("\n");
                    }
                
                break;    
                    
                case 7: //Salir del programa
                    
                    String ubi = "C:\\Users\\danie\\Documents\\NetBeansProjects\\Practica1IS¡\\administradorACAMA.txt"; //Ruta variable, donde se ubicará el archivo generado para la asociacion
                    File archivo = new File(ubi);
                    BufferedWriter bw;
                    
                    if(!archivo.exists())
                    archivo.createNewFile();
                    
                    for (int i = 0; i < miembros.size(); i++){
                        if(miembros.get(i).numMoto() > 0)
                        {
                            bw = new BufferedWriter(new FileWriter(archivo));
                            String Cadena_idmiembro = String.format("%03d", miembros.get(i).getIdMiembro());
                            bw.write(Cadena_idmiembro + "\t" + miembros.get(i).getNombre());
                            bw.write("\n");
                            bw.close();
                        } 
                    }
                    
                    for (int i = 0; i < cesiones.size(); i++)
                    {
                       bw = new BufferedWriter(new FileWriter(archivo));
                       String Cadena_idcesion = String.format("%03d", cesion_aux.getMiembroRecibe());
                       String Cadena_idcesion2 = String.format("%03d", cesion_aux.getMiembroDar());
                       
                       bw.write(Cadena_idcesion + " " + miembros.get(cesion_aux.getMiembroRecibe() - 1).getNombre() + " recibe la moto: " + cesion_aux.getMotocicleta() + " del usuario con id:  " + Cadena_idcesion2 +" " + miembros.get(cesion_aux.getMiembroDar() - 1).getNombre());
                       bw.write("Realizada en la fecha: " + cesion_aux.getFecha().getDia()+ "/" + cesion_aux.getFecha().getMes()+ "/" + cesion_aux.getFecha().getAño());
                       
                       bw.write("\n");
                       bw.close();
                    }

                    System.exit(0); //El programa deja de funcionar
            
            break;
            
            default:
                System.err.println("Caracter no reconocido, vuelva a intentarlo por favor");
            break;
            }
        }
    }                                      
}