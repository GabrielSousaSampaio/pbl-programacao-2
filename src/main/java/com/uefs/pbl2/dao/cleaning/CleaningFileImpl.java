package com.uefs.pbl2.dao.cleaning;

import com.uefs.pbl2.dao.FileHandling;
import com.uefs.pbl2.model.services.Cleaning;

import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "CleaningDAO" para manipulação dos serviços de
 * limpeza oferecidos e armazenados no sistema através de arquivos.
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */
public class CleaningFileImpl implements CleaningDAO {

    private List<Cleaning> cleaningList;
    private int nextId;


    //Constructor
    /**
     * Método cronstrutor que lê ou cria o arquivo e atualiza o id
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
     * Método criado para a adição de um serviço de limpeza no arquivo
     * @param cleaning O componente que deseja inserir no arquivo
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
     * Método criado para adquirir todos os serviços de limpeza cadastrados no arquivo
     * @return A lista com todos os serviços de limpeza cadastrados no arquivo
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
     * Método criado para atuallizar os dados de um serviço de limpeza previamente cadastrado no arquivo
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
     * Método criado para deletar um serviço de limpeza cadastrado no arquivo
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
     * Método criado para limpar completamente a lista de serviços de limpeza cadastrados no arquivo
     */
    @Override
    public void clearList(){

        this.cleaningList.clear();
        FileHandling.saveInFile(this.cleaningList,"src\\filesSaves\\cleaning.dat");
    }
}
