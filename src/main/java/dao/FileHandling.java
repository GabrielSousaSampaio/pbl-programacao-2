package main.java.dao;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {

    public static <G> void saveInFile(List<G> objectList, String fileName){

        try{

            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(new byte[0]);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(objectList);
            oos.close();

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public static <G> ArrayList<G> readFile(String fileName){

        ArrayList<G> objectList = new ArrayList<G>();

        try{

            if(!(new File(fileName)).exists()){
                saveInFile(objectList, fileName);
            }

            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            objectList = (ArrayList<G>)ois.readObject();
            ois.close();

            return objectList;

        } catch (IOException | ClassNotFoundException e) {

            throw new RuntimeException(e);
        }

    }
}
