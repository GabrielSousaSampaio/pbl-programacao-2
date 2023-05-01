package main.java.dao.recepcionist;

import main.java.dao.FileHandling;
import main.java.model.users.Recepcionist;

import java.util.ArrayList;
import java.util.List;

public class RecepcionistFileImpl implements RecepcionistDAO{
    private List<Recepcionist> recepcionistList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que inicializa o array para armazenar os recepcionistas e inicia o id com o valor 1
     *
     */
    public RecepcionistFileImpl() {

        this.recepcionistList = FileHandling.readFile("src\\filesSaves\\recepcionist.dat");

        if(recepcionistList.size() == 0) {
            this.nextId = 1;
        }else{

            this.nextId = (recepcionistList.get(recepcionistList.size() - 1).getId()) + 1;
        }

    }

    //Methods

    /**
     * Método criado para a adição de um recepcionista na lista do sistema
     * @param recepcionist O recepcionista que deseja inserir na lista do sistema
     * @return O recepcionista enviado
     */
    @Override
    public Recepcionist create(Recepcionist recepcionist) {

        recepcionist.setId(nextId);
        this.nextId++;
        this.recepcionistList.add(recepcionist);
        FileHandling.saveInFile(this.recepcionistList,"src\\filesSaves\\recepcionist.dat");
        return recepcionist;

    }

    /**
     * Método criado para adquirir todos os recepcionistas cadastrados na lista do sistema
     * @return A lista com todos os recepcionistas cadastrados
     */
    @Override
    public List<Recepcionist> FindMany() {
        return this.recepcionistList;
    }

    /**
     * Método criado para econtrar um recepcionista pelo seu id
     * @param id O id do recepcionista
     * @return O recepcionista procurado ou nulo (caso ele não esteja cadastrado)
     */
    @Override
    public Recepcionist FindById(int id) {

        for(Recepcionist r: this.recepcionistList){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }

    /**
     * Método criado para atuallizar os dados de um recepcionista previamente cadastrado
     * @param recepcionist O recepcionista que deseja atuaizar os dados
     */
    @Override
    public void update(Recepcionist recepcionist) {

        int indexOF;
        for(Recepcionist r: this.recepcionistList){
            if(r.getId() == recepcionist.getId()){
                indexOF = this.recepcionistList.indexOf(r);
                this.recepcionistList.set(indexOF, recepcionist);
                FileHandling.saveInFile(this.recepcionistList,"src\\filesSaves\\recepcionist.dat");
                return;
            }
        }

    }

    /**
     * Método criado para deletar um recepcionista da lista do sistema
     * @param id O id do recepcionista
     */
    @Override
    public void delete(int id) {

        int indexRemove;
        for(Recepcionist r: this.recepcionistList){
            if(r.getId() == id){
                indexRemove = this.recepcionistList.indexOf(r);
                this.recepcionistList.remove(indexRemove);
                FileHandling.saveInFile(this.recepcionistList,"src\\filesSaves\\recepcionist.dat");
                return;
            }
        }

    }

    /**
     * Método criado para limpar completamente a lista de recepcionistas
     */
    @Override
    public void clearList() {

        this.recepcionistList.clear();
        FileHandling.saveInFile(this.recepcionistList,"src\\filesSaves\\recepcionist.dat");

    }
}
