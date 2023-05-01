package main.java.dao.cleaning;

import main.java.dao.FileHandling;
import main.java.model.services.Cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningFileImpl implements CleaningDAO{

    private List<Cleaning> cleaningList;
    private int nextId;


    //Constructor
    /**
     * Método cronstrutor que inicializa o array para armazenar os serviços de limpeza e inicia o id com o valor 1
     *
     */
    public CleaningFileImpl() {
        this.cleaningList = FileHandling.readFile("src\\filesSaves\\cleaning.dat");

        if(cleaningList.size() == 0) {
            this.nextId = 1;
        }else{

            this.nextId = (cleaningList.get(cleaningList.size() - 1).getId()) + 1;
        }
    }

    //Methods

    /**
     * Método criado para a adição de um serviço de limpeza na lista do sistema
     * @param cleaning O componente que deseja inserir na lista do sistema
     * @return O serviço de limpeza enviado
     */
    @Override
    public Cleaning create(Cleaning cleaning) {
        cleaning.setId(nextId);
        this.nextId++;
        this.cleaningList.add(cleaning);

        FileHandling.saveInFile(this.cleaningList,"src\\filesSaves\\cleaning.dat");
        return cleaning;
    }

    /**
     * Método criado para adquirir todos os serviços de limpeza cadastrados na lista do sistema
     * @return A lista com todos os serviços de limpeza cadastrados
     */
    @Override
    public List<Cleaning> FindMany() {
        return this.cleaningList;
    }

    /**
     * Método criado para econtrar um serviço de limpeza pelo seu id
     * @param id O id do serviço de limpeza
     * @return O serviço de limpeza procurado ou nulo (caso ele não esteja cadastrado)
     */
    @Override
    public Cleaning FindById(int id) {
        for(Cleaning c: this.cleaningList){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    /**
     * Método criado para atuallizar os dados de um serviço de limpeza previamente cadastrado
     * @param cleaning O serviço de limpeza que deseja atuaizar os dados
     */
    @Override
    public void update(Cleaning cleaning) {
        int indexOF;
        for(Cleaning c: this.cleaningList){
            if(c.getId() == cleaning.getId()){
                indexOF = this.cleaningList.indexOf(c);
                this.cleaningList.set(indexOF, cleaning);
                FileHandling.saveInFile(this.cleaningList,"src\\filesSaves\\cleaning.dat");
                return;
            }
        }
    }

    /**
     * Método criado para deletar um serviço de limpeza da lista do sistema
     * @param id O id do serviço de limpeza
     */
    @Override
    public void delete(int id) {
        int indexRemove;
        for(Cleaning c: this.cleaningList){
            if(c.getId() == id){
                indexRemove = this.cleaningList.indexOf(c);
                this.cleaningList.remove(indexRemove);
                FileHandling.saveInFile(this.cleaningList,"src\\filesSaves\\cleaning.dat");
                return;
            }
        }
    }

    /**
     * Método criado para limpar completamente a lista de serviços de limpeza
     */
    @Override
    public void clearList(){

        this.cleaningList.clear();
        FileHandling.saveInFile(this.cleaningList,"src\\filesSaves\\cleaning.dat");
    }
}
