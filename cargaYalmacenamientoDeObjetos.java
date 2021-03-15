/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasdemetodosyestructuras;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class cargaYalmacenamientoDeObjetos {
    public static void main(String [] arg) throws FileNotFoundException, IOException{
//  cargarDatos();
//  borrarTodo();
    lecYesc();
    }
    //Metodo para almacenar informacion de una columna en un string separado por el caracter '+'
    public static String recolectarDatosUsuario(Usuario arr[]){
    String dato="";
        for (Usuario arr1 : arr) {
            dato = dato + arr1.getUsuario() + "+";
        }
        return dato;
    }
        public static String recolectarDatosMail(Usuario arr[]){
    String dato="";
        for (Usuario arr1 : arr) {
            dato = dato + arr1.getMail().toString() + "+";
        }
        return dato;
    }
        public static String recolectarDatosContra(Usuario arr[]){
    String dato="";
        for (Usuario arr1 : arr) {
            dato = dato + arr1.getContrasena().toString() + "+";
        }
        return dato;
    }
    //Metodo de borrado de datos
        public static void borrarTodo() throws FileNotFoundException, IOException{
            DataOutputStream aGuardarMail = new DataOutputStream(new FileOutputStream ("C:\\Users\\Walter\\Desktop\\Tom\\Otros\\Informatica\\Proyectos\\GUP\\dataBase\\pruebaObjetoM.txt"));
            aGuardarMail.flush();
        }
    
    //Metodo de carga
    public static void cargarDatos() throws FileNotFoundException, IOException{
    String cadena="";
        DataInputStream aLeer = new DataInputStream( new FileInputStream("C:\\Users\\Walter\\Desktop\\Tom\\Otros\\Informatica\\Proyectos\\GUP\\dataBase\\pruebaObjeto.txt"));
    while(aLeer.available()>0){
        cadena = cadena+aLeer.readUTF();
    }
    separarDatos(cadena);
    }
    
    //Metodo para separar el string en arreglos
    public static void separarDatos(String cadena) throws FileNotFoundException{
    int totalSep = contarCantDatos(cadena);
    String arrPal [] = new String [totalSep];
    separador(arrPal,0,cadena);
        for (String arrPal1 : arrPal) {
            System.out.println(arrPal1);
        }
  
    }
    
    //Metodo que te separa las palabras
    private static void separador(String arrPal[],int i,String cadena){
        cadena = cadena+"+";
    String pal="";
        for (int j = 0; j < cadena.length(); j++) {
            if (cadena.charAt(j)=='+') {
                arrPal[i]=pal;
                pal="";
                i=i+1;
            }else{
            pal=pal+cadena.charAt(j);
            }
        }
}
    
    //Metodo para contar cantidad de datos
    public static int contarCantDatos(String cadena){
    int cont=0,i=0,total=cadena.length();
    while(i<total){
        if (cadena.charAt(i)=='+') {
            cont=cont+1;
            i = i+1;
        }
        else{
        i = i+1;
        }
    }
    //Se le suma uno por que cuando encuentra el ultimo caracter + existe una palabra mas;
    return cont+1;
    }
    
    public static void lecYesc() throws FileNotFoundException, IOException{
      Usuario arr [] = new Usuario [3];
    arr[0]= new Usuario("tom","bascal@gmail.com","holahola");
    arr[1]= new Usuario("tomas","tom.bascal@gmail.com","queonda");
    arr[2]= new Usuario("tomato","tomato.bascal@gmail.com","ho244423a");

    DataOutputStream aGuardarUsu = new DataOutputStream(new FileOutputStream ("C:\\Users\\Walter\\Desktop\\Tom\\Otros\\Informatica\\Proyectos\\GUP\\dataBase\\pruebaObjetoU.txt"));
    DataOutputStream aGuardarMail = new DataOutputStream(new FileOutputStream ("C:\\Users\\Walter\\Desktop\\Tom\\Otros\\Informatica\\Proyectos\\GUP\\dataBase\\pruebaObjetoM.txt"));
    DataOutputStream aGuardarContra = new DataOutputStream(new FileOutputStream ("C:\\Users\\Walter\\Desktop\\Tom\\Otros\\Informatica\\Proyectos\\GUP\\dataBase\\pruebaObjetoC.txt"));
    
    
    aGuardarUsu.writeUTF(recolectarDatosUsuario(arr));
    aGuardarMail.writeUTF(recolectarDatosMail(arr));
    aGuardarContra.writeUTF(recolectarDatosContra(arr));



    aGuardarUsu.close();
    aGuardarMail.close();
    aGuardarContra.close();
        
    DataInputStream aLeerU = new DataInputStream (new FileInputStream("C:\\Users\\Walter\\Desktop\\Tom\\Otros\\Informatica\\Proyectos\\GUP\\dataBase\\pruebaObjetoU.txt"));
    DataInputStream aLeerM = new DataInputStream (new FileInputStream("C:\\Users\\Walter\\Desktop\\Tom\\Otros\\Informatica\\Proyectos\\GUP\\dataBase\\pruebaObjetoM.txt"));
    DataInputStream aLeerC = new DataInputStream (new FileInputStream("C:\\Users\\Walter\\Desktop\\Tom\\Otros\\Informatica\\Proyectos\\GUP\\dataBase\\pruebaObjetoC.txt"));

    while(aLeerM.available()>0){
        System.out.println(aLeerU.readUTF()+"");
        System.out.println(aLeerM.readUTF()+"");
        System.out.println(aLeerC.readUTF()+"");

    }

    aLeerU.close();
    aLeerM.close();
    aLeerC.close();

    }
}
