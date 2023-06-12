package com.uefs.pbl2.dao.recepcionist;

import com.uefs.pbl2.dao.FileHandling;
import com.uefs.pbl2.model.users.Recepcionist;

import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "RecepcionistDAO" para a manipulação dos recepcionistas
 * armazenados no sistema através de arquivos.
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */
public class RecepcionistFileImpl implements RecepcionistDAO {
    private List<Recepcionist> recepcionistList;
    private int nextId;

    //Constructor


    /**
     * Método cronstrutor que lê ou cria o arquivo e atualiza o id
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
     * Método criado para a adição de um recepcionista no arquivo
     * @param recepcionist O recepcionista que deseja inserir no arquivo
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
     * Método criado para adquirir todos os recepcionistas cadastrados no arquivo
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
     * Método criado para atuallizar os dados de um recepcionista previamente cadastrado no arquivo
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
     * Método criado para deletar um recepcionista cadastrado no arquivo
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
     * Método criado para limpar completamente a lista de recepcionistas cadastrados no arquivo
     */
    @Override
    public void clearList() {

        this.recepcionistList.clear();
        FileHandling.saveInFile(this.recepcionistList,"src\\filesSaves\\recepcionist.dat");

    }
}
