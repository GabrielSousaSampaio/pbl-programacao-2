package main.java.dao.technician;

import main.java.dao.FileHandling;
import main.java.model.users.Technician;

import java.util.List;

public class TechnicianFileImpl implements TechnicianDAO{
    private List<Technician> technicianList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que inicializa o array para armazenar os técnicos e inicia o id com o valor 1
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
     * Método criado para a adição de um técnico na lista do sistema
     * @param technician O técnico que deseja inserir na lista do sistema
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
     * Método criado para adquirir todos os técnicos cadastrados na lista do sistema
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
     * Método criado para atuallizar os dados de um técnico previamente cadastrado
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
     * Método criado para deletar um técnico da lista do sistema
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
     * Método criado para limpar completamente a lista de técnicos
     */
    @Override
    public void clearList(){

        this.technicianList.clear();
        FileHandling.saveInFile(this.technicianList,"src\\filesSaves\\technician.dat");
    }
}

