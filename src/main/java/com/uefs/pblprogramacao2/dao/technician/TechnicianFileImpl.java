package com.uefs.pblprogramacao2.dao.technician;

import com.uefs.pblprogramacao2.dao.FileHandling;
import com.uefs.pblprogramacao2.model.users.Technician;

import java.util.List;


/**
 *
 * Classe criada a partir da implementação da interface "TechnicianDAO" para a manipulação dos técnicos
 * armazenados no sistema através de arquivos.
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */
public class TechnicianFileImpl implements TechnicianDAO{
    private List<Technician> technicianList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que lê ou cria o arquivo e atualiza o id
     *
     */
    public TechnicianFileImpl() {
        this.technicianList = FileHandling.readFile("src\\filesSaves\\technician.dat");

        if(technicianList.size() == 0) {
            this.nextId = 1;
        }else{

            this.nextId = (technicianList.get(technicianList.size() - 1).getId()) + 1;
        }
    }

    //Methods

    /**
     * Método criado para a adição de um técnico no arquivo
     * @param technician O técnico que deseja inserir no arquivo
     * @return O técnico enviado
     */
    @Override
    public Technician create(Technician technician) {
        technician.setId(nextId);
        this.nextId++;
        this.technicianList.add(technician);

        FileHandling.saveInFile(this.technicianList,"src\\filesSaves\\technician.dat");
        return technician;
    }

    /**
     * Método criado para adquirir todos os técnicos cadastrados no arquivo
     * @return A lista com todos os técnicos cadastrados
     */
    @Override
    public List<Technician> FindMany() {
        return this.technicianList;
    }

    /**
     * Método criado para econtrar um técnico pelo seu id
     * @param id O id do técnico
     * @return O técnico procurado ou nulo (caso ele não esteja cadastrado)
     */
    @Override
    public Technician FindById(int id) {
        for(Technician t: this.technicianList){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    /**
     * Método criado para atuallizar os dados de um técnico previamente cadastrado no arquivo
     * @param technician O técnico que deseja atuaizar os dados
     */
    @Override
    public void update(Technician technician) {
        int indexOF;
        for(Technician t: this.technicianList){
            if(t.getId() == technician.getId()){
                indexOF = this.technicianList.indexOf(t);
                this.technicianList.set(indexOF, technician);
                FileHandling.saveInFile(this.technicianList,"src\\filesSaves\\technician.dat");
                return;
            }
        }
    }

    /**
     * Método criado para deletar um técnico cadastrados no arquivo
     * @param id O id do técnico
     */
    @Override
    public void delete(int id) {
        int indexRemove;
        for(Technician t: this.technicianList){
            if(t.getId() == id){
                indexRemove = this.technicianList.indexOf(t);
                this.technicianList.remove(indexRemove);
                FileHandling.saveInFile(this.technicianList,"src\\filesSaves\\technician.dat");
                return;
            }
        }
    }

    /**
     * Método criado para limpar completamente a lista de tecnicos cadastrados no arquivo
     */
    @Override
    public void clearList(){

        this.technicianList.clear();
        FileHandling.saveInFile(this.technicianList,"src\\filesSaves\\technician.dat");
    }
}

