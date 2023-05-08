package main.java.dao;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe criada para auxílio na manipulação de arquivos
 *
 * @author Gabriel Sousa Sampaio, Gabriel Baptista
 */

public class FileHandling {

    /**
     *
     * Método criado para escrita da lista de objetos no arquivo
     * @param objectList Lista de objetos para ser salva no arquivo
     * @param fileName Nome/caminho do arquivo
     * @author Gabriel Sousa Sampaio, Gabriel Baptista
     */

    public static <G> void saveInFile(List<G> objectList, String fileName){

        try{

            FileOutputStream fos = new FileOutputStream(fileName);

            //Limpa o arquivo
            fos.write(new byte[0]);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(objectList);
            oos.close();

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    /**
     *
     * Método criado para a leitura da lista de objetos no arquivo
     * @param fileName Nome/caminho do arquivo
     * @return Lista de objetos presente no arquivo
     * @author Gabriel Sousa Sampaio, Gabriel Baptista
     */

    public static <G> ArrayList<G> readFile(String fileName){

        ArrayList<G> objectList = new ArrayList<G>();

        File directory = new File("src\\filesSaves");

        try{
            Class.forName("src\\filesSaves");
        } catch(ClassNotFoundException e){
            directory.mkdirs();
        }

        try{

            if(!(new File(fileName)).exists()){
                saveInFile(objectList, fileName);
            }

            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            objectList = (ArrayList<G>) ois.readObject();
            ois.close();


            return objectList;

        } catch (IOException | ClassNotFoundException e) {

            throw new RuntimeException(e);
        }

    }
}
