/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import domain.Identification;
import domain.Student;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
//import javax.swing.JOptionPane;

/**
 * 
 * @author Pablo Rojas Martínez
 */
public class StudentFile {
 private RandomAccessFile randomAccessFile;
    private int cantidadRegistros;
    private int tamRegistro;
    private String path;

    public StudentFile() throws IOException {

        this.path = "archivoEstudiante";
        File file = new File(this.path);
        start(file);

    } // default

    private void start(File file) throws IOException {
        this.path = file.getPath();
        this.tamRegistro = 140;

        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName() + " archivo inválido");
        } else {
            this.randomAccessFile = new RandomAccessFile(file, "rw");
            this.cantidadRegistros = (int) Math.ceil((double) this.randomAccessFile.length()
                    / (double) this.tamRegistro);
        }

    } // start

    private boolean insertarProducto(int posicion, Student pelicula) throws IOException {

        if (posicion >= 0 && posicion <= cantidadRegistros) {
            if (pelicula.size() > this.tamRegistro) {
                return false;
            } else {
                pelicula.setId(this.crearCarnet(pelicula));

                this.randomAccessFile.seek(posicion * this.tamRegistro);
                this.randomAccessFile.writeUTF(pelicula.getName());
                this.randomAccessFile.writeUTF(pelicula.getLastName());
                this.randomAccessFile.writeUTF(pelicula.getId().getCareer());
                this.randomAccessFile.writeInt(pelicula.getId().getYear());
                this.randomAccessFile.writeInt(pelicula.getId().getNumber());
                this.randomAccessFile.writeUTF(pelicula.getId().getChain());
                return true;
            } // if(persona.size()>this.tamRegistro)
        } // if

        return false;
    } // insertarPersona

    public boolean insertarProducto(Student producto) throws IOException {

        return insertarProducto(this.cantidadRegistros, producto);

    } // insertarPersona

    public Student obtenerProducto(int posicion) throws IOException {
        Identification carn = new Identification();
        if (posicion >= 0 && posicion <= cantidadRegistros) {
            this.randomAccessFile.seek(posicion * tamRegistro);

            Student pelicula = new Student();
            pelicula.setLastName(this.randomAccessFile.readUTF());
            pelicula.setName(this.randomAccessFile.readUTF());
            carn.setCareer(this.randomAccessFile.readUTF());
            carn.setYear(this.randomAccessFile.readInt());
            carn.setNumber(this.randomAccessFile.readInt());
            carn.setChain(this.randomAccessFile.readUTF());
            pelicula.setId(carn);
            return pelicula;

        } // if

        return null;
    } // obtenerPersona
    

    public String primeraLetra(Student estudiante) {
        if (estudiante.getId().getCareer().equalsIgnoreCase("Computing")) {
            return "C";

        } else if (estudiante.getId().getCareer().equalsIgnoreCase("Agronomy")) {
            return "A";
        } else {
            return "E";
        }

    }

    public int retornaNumerAno(Student estudiante) {
        if (estudiante.getId().getYear() == 2010) {
            return 0;
        } else if (estudiante.getId().getYear() == 2011) {
            return 1;
        } else if (estudiante.getId().getYear() == 2012) {
            return 2;
        } else if (estudiante.getId().getYear() == 2013) {
            return 3;
        } else if (estudiante.getId().getYear() == 2014) {
            return 4;
        } else if (estudiante.getId().getYear() == 2015) {
            return 5;
        } else if (estudiante.getId().getYear() == 2016) {
            return 6;
        } else if (estudiante.getId().getYear() == 2017) {
            return 7;
        } else if (estudiante.getId().getYear() == 2018) {
            return 8;
        }
        return 9;

    }
    public int ultimonumero(String primerletra) throws IOException{
    int ultimoNumero = 0;
        for(int i=cantidadRegistros-1;i>=0;i--){
            Student ultimaPosicion = obtenerProducto(i);
//            JOptionPane.showMessageDialog(null,ultimaPosicion);
       if(primerletra.equals(ultimaPosicion.getId().getCareer())){
        ultimoNumero=ultimaPosicion.getId().getNumber()+1;
        break;
       }else{
       ultimoNumero=000;
       
       }
        
        }
        return ultimoNumero;
    }

    public String numero(int numero){
    String num2 = null;
    if(numero<1){
    
    num2="000";
    }
        
    else if(numero<10){
        num2="00"+numero;
        
    }else if(numero<100){
   num2= "0"+numero;
    }else{
    num2+=numero;
    }
    return num2;
    }
    
    
    public Identification crearCarnet(Student estudiante) throws IOException {
        Identification carnet = null;
        int numUltimo;
          String primeraLetr = null ;
        Student ultimaPosicion = obtenerProducto(cantidadRegistros - 1);
        int cont = 0;
        for (int i = 0; i < cantidadRegistros; i++) {
            cont++;
        }
     
           // cantidadRegistros += 1;
      
            //numUltimo = (ultimaPosicion.getId().getNumber()) + 001;
            //cantidadRegistros += 1;
    
         numUltimo=ultimonumero(estudiante.getId().getCareer());
String numer=numero(numUltimo);
//cantidadRegistros+=1;
   

            primeraLetr  = primeraLetra(estudiante);
        int num = (retornaNumerAno(estudiante));
        String todoCarnet = primeraLetr + num + numer;
        carnet = new Identification(estudiante.getId().getCareer(), estudiante.getId().getYear(), numUltimo, todoCarnet);
        return carnet;
    }

    public List<Student> buscarPorNombreTodos() throws IOException {
        List<Student> productoList = new ArrayList<Student>();
        for (int i = 0; i < this.cantidadRegistros; i++) {
            Student productoActual = obtenerProducto(i);
            if (productoActual != null) {
                // if (nombre.equals(productoActual.getTitulo())) {
                //System.out.println("");
                productoList.add(productoActual);
                //} // if nombre.equals.
            }//if prodctoActual != null
        }//for
        return productoList;
    }//buscarPorNombreTodos
    
    

    
    
        public boolean buscarCarnet(String carnet) throws IOException{
        //boolean result = false;  
        for (int i = 0; i < this.cantidadRegistros; i++) {
            Student productoActual = obtenerProducto(i);
            if (productoActual != null) {
               if(productoActual.getId().getChain().equals(carnet)){
                  
               //result=true;
//               }else{
//               //result=false;
//               }
                
   return true;
 
                //} // if nombre.equals.
            }//if prodctoActual != null
              
        }//for
     //   return result;
       
    }
     return false;
    }
        
        
        public Student obtenerEstudiante(String carnet) throws IOException{
            Student student = null;
        for (int i = 0; i < this.cantidadRegistros; i++) {
            Student productoActual = obtenerProducto(i);
            if (productoActual != null) {
               if(productoActual.getId().getChain().equals(carnet)){
                  
               //result=true;
//               }else{
//               //result=false;
//               }
               student=productoActual;
  
               }
            
            }}

        return student;
        }
        
}
