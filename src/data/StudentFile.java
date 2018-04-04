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

    //Attributes
    private RandomAccessFile randomAccessFile;
    private int RegSize;
    private int tamRegistro;
    private String path;

    public StudentFile() throws IOException {
        this.path = "./StudentFile.dat";
        File file = new File(this.path);
        start(file);
    } //constructor

    //Este método crea el archivo del objeto Student
    private void start(File file) throws IOException {
        this.path = file.getPath();
        this.tamRegistro = 140;
        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName() + " Invalid File");
        } else {
            this.randomAccessFile = new RandomAccessFile(file, "rw");
            this.RegSize = (int) Math.ceil((double) this.randomAccessFile.length()
                    / (double) this.tamRegistro);
        }
    } // start

    //Este método de tipo boolean inserta un objeto Student en una posición del archivo
    private boolean insertStudent(int position, Student student) throws IOException {
        if (position >= 0 && position <= RegSize) {
            if (student.size() > this.tamRegistro) {
                return false;
            } else {
                student.setId(this.createId(student));
                this.randomAccessFile.seek(position * this.tamRegistro);
                this.randomAccessFile.writeUTF(student.getName());
                this.randomAccessFile.writeUTF(student.getLastName());
                this.randomAccessFile.writeUTF(student.getId().getCareer());
                this.randomAccessFile.writeInt(student.getId().getYear());
                this.randomAccessFile.writeInt(student.getId().getNumber());
                this.randomAccessFile.writeUTF(student.getId().getChain());
                return true;
            } // if
        } // if
        return false;
    } // insertStudent

    //Este método retorna el método insertStudent
    public boolean insertStudent(Student producto) throws IOException {
        return StudentFile.this.insertStudent(this.RegSize, producto);
    } // insertStudent

    //Este método devuelve un estudiante que se busca en una posición específica.
    public Student getStudent(int position) throws IOException {
        Identification id = new Identification();
        if (position >= 0 && position <= RegSize) {
            this.randomAccessFile.seek(position * tamRegistro);
            Student student = new Student();
            student.setLastName(this.randomAccessFile.readUTF());
            student.setName(this.randomAccessFile.readUTF());
            id.setCareer(this.randomAccessFile.readUTF());
            id.setYear(this.randomAccessFile.readInt());
            id.setNumber(this.randomAccessFile.readInt());
            id.setChain(this.randomAccessFile.readUTF());
            student.setId(id);
            return student;
        } // if
        return null;
    } // getStudent

    //Este métpdp retorna una letra específica dependiendo del tipo de carrera que se elija
    public String firstLetter(Student estudiante) {
        if (estudiante.getId().getCareer().equalsIgnoreCase("Computing")) {
            return "C";
        } else if (estudiante.getId().getCareer().equalsIgnoreCase("Agronomy")) {
            return "A";
        }
        else {
            return "E";
        }
    }//firstLetter

    //Este método retorna un número dependiendo del año que haya sido seleccionado.
    public int returnYearNumber(Student estudiante) {
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
    }// returnYearNumber

    //Este método busca en el archivo el último carnet ingresado y le suma 1.
    public int id1(String firstLetter) throws IOException {
        int lastNumber = 0;
        for (int i = RegSize - 1; i >= 0; i--) {
            Student student = StudentFile.this.getStudent(i);
            if (firstLetter.equals(student.getId().getCareer())) {
                lastNumber = student.getId().getNumber() + 1;
                break;
            } else {
                lastNumber = 000;
            }
        }
        return lastNumber;
    }//id1

    //Este método asigna la cantidad de ceros al contador del carnet del estudiante
    public String id2(int number) {
        String num2 = null;
        if (number < 1) {
            num2 = "000";
        } else if (number < 10) {
            num2 = "00" + number;
        } else if (number < 100) {
            num2 = "0" + number;
        } else {
            num2 += number;
        }
        return num2;
    }//id2

    //Este método sirve para unificar todos los componentes de la identificacion 
    public Identification createId(Student student) throws IOException {
        Identification id = null;
        int lastNumber;
        String firtsLetter = null;
        Student lastPosition = StudentFile.this.getStudent(RegSize - 1);
        int count = 0;
        for (int i = 0; i < RegSize; i++) {
            count++;
        }
        lastNumber = id1(student.getId().getCareer());
        String numer = id2(lastNumber);
        firtsLetter = firstLetter(student);
        int num = (returnYearNumber(student));
        String todoCarnet = firtsLetter + num + numer;
        id = new Identification(student.getId().getCareer(), student.getId().getYear(), lastNumber, todoCarnet);
        return id;
    }//createId

    //Este método retorna una lista con todos los objetos Student
    public List<Student> searchStudent() throws IOException {
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < this.RegSize; i++) {
            Student student = StudentFile.this.getStudent(i);
            if (student != null) {
                studentList.add(student);
            }//if 
        }//for
        return studentList;
    }//searchStudent

    //Este métdo sirve para buscar el estudiante mediante su carnet
    public boolean searchById(String id) throws IOException {
        //boolean result = false;  
        for (int i = 0; i < this.RegSize; i++) {
            Student currentStudent = StudentFile.this.getStudent(i);
            if (currentStudent != null) {
                if (currentStudent.getId().getChain().equals(id)) {
                    return true;
                }//if 
            }//for
        }
        return false;
    }//searchById

    //Este método sirve para  retornar un estudiante con un id específico.
    public Student getStudent(String carnet) throws IOException {
        Student student = null;
        for (int i = 0; i < this.RegSize; i++) {
            Student currentStudent = StudentFile.this.getStudent(i);
            if (currentStudent != null) {
                if (currentStudent.getId().getChain().equals(carnet)) {
                    student = currentStudent;
                }
            }
        }
        return student;
    }//getStudent

}
