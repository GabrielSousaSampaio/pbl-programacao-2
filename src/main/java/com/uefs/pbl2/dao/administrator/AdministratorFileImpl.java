package com.uefs.pbl2.dao.administrator;

import com.uefs.pbl2.dao.FileHandling;
import com.uefs.pbl2.model.users.Administrator;

import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "AdministratorDAO" para a manipulação dos administradores
 * armazenados no sistema através de arquivos.
 *
 * @author Gabriel Sousa Sampaio, Gabriel Baptista
 */
public class AdministratorFileImpl implements AdministratorDAO{

    private List<Administrator> administratorList;
    private int nextId;

    //Constructor
    /**
     * Método cronstrutor que lê ou cria o arquivo e atualiza o id
     *
     */
    public AdministratorFileImpl() {
        this.administratorList = FileHandling.readFile("src\\filesSaves\\administrator.dat");

        if(administratorList.size() == 0) {
            this.nextId = 1;
        }else{

            this.nextId = (administratorList.get(administratorList.size() - 1).getId()) + 1;
        }
    }

    //Methods

    /**
     * Método criado para a adição de um administrador no arquivo
     * @param administrator O administrador que deseja inserir no arquivo
     * @return O administrador enviado
     */
    @Override
    public Administrator create(Administrator administrator) {
        administrator.setId(nextId);
        this.nextId++;
        this.administratorList.add(administrator);

        FileHandling.saveInFile(this.administratorList,"src\\filesSaves\\administrator.dat");
        return administrator;
    }

    /**
     * Método criado para adquirir todos os administradores cadastrados no arquivo
     * @return A lista com todos os administradores cadastrados no arquivo
     */
    @Override
    public List<Administrator> FindMany() {
        return this.administratorList;
    }

    /**
     * Método criado para econtrar um administrador pelo seu id
     * @param id O id do administrador
     * @return O administrador procurado ou nulo (caso ele não esteja cadastrado)
     */
    @Override
    public Administrator FindById(int id) {

        for(Administrator a: this.administratorList){
            if(a.getId() == id){
                return a;
            }
        }
        return null;

    }

    /**
     * Método criado para atuallizar os dados de um administrador previamente cadastrado no arquivo
     * @param administrator O administrador que deseja atuaizar os dados
     */
    @Override
    public void update(Administrator administrator) {

        int indexOF;
        for(Administrator a: this.administratorList){
            if(a.getId() == administrator.getId()){
                indexOF = this.administratorList.indexOf(a);
                this.administratorList.set(indexOF, administrator);
                FileHandling.saveInFile(this.administratorList,"src\\filesSaves\\administrator.dat");
                return;
            }
        }

    }

    /**
     * Método criado para deletar um administrador cadastrado no arquivo
     * @param id O id do administrador cadastrado no arquivo
     */
    @Override
    public void delete(int id) {

        int indexRemove;
        for(Administrator a: this.administratorList){
            if(a.getId() == id){
                indexRemove = this.administratorList.indexOf(a);
                this.administratorList.remove(indexRemove);
                FileHandling.saveInFile(this.administratorList,"src\\filesSaves\\administrator.dat");
                return;
            }
        }

    }

    /**
     * Método criado para limpar completamente a lista de administradores cadastrados no arquivo
     */
    @Override
    public void clearList() {

        this.administratorList.clear();
        FileHandling.saveInFile(this.administratorList,"src\\filesSaves\\administrator.dat");

    }
}
