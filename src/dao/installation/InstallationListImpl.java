package dao.installation;

import model.Installation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "InstallationDAO" para manipulação dos serviços de
 * instalação oferecidos e armazenados no sistema através de listas.
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class InstallationListImpl implements InstallationDAO{

    private List<Installation> installationList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que inicializa o array para armazenar os serviços de instalação e inicia o id com o valor 0
     *
     */
    public InstallationListImpl() {
        this.installationList = new ArrayList<Installation>();
        this.nextId = 0;
    }

    //Methods

    /**
     * Método criado para a adição de um serviço de instalação na lista do sistema
     * @param installation O serviço de instalação que deseja inserir na lista do sistema
     * @return O serviço de instalaçãoa enviado
     */
    @Override
    public Installation create(Installation installation) {
        installation.setId(nextId);
        this.nextId++;
        this.installationList.add(installation);
        return installation;
    }

    /**
     * Método criado para adquirir todos os serviços de instalação cadastrados na lista do sistema
     * @return A lista com todos os serviços de instalação cadastrados
     */
    @Override
    public List<Installation> FindMany() {
        return this.installationList;
    }

    /**
     * Método criado para econtrar um serviço de instalação pelo seu id
     * @param id O id do serviço de instalação
     * @return O serviço de instalação procurado ou nulo (caso ele não esteja cadastrado)
     */
    @Override
    public Installation FindById(int id) {
        for(Installation i: this.installationList){
            if(i.getId() == id){
                return i;
            }
        }

        return null;
    }

    /**
     * Método criado para atuallizar os dados de um serviço de instalação previamente cadastrado
     * @param installation O serviço de instalação que deseja atuaizar os dados
     */
    @Override
    public void update(Installation installation) {
        int indexOF;
        for(Installation i: this.installationList){
            if(i.getId() == installation.getId()){
                indexOF = this.installationList.indexOf(i);
                this.installationList.set(indexOF, installation);
                return;
            }
        }
    }

    /**
     * Método criado para deletar um serviço de instalação da lista do sistema
     * @param id O id do serviço de instalação
     */
    @Override
    public void delete(int id) {
        int indexRemove;
        for(Installation i: this.installationList){
            if(i.getId() == id){
                indexRemove = this.installationList.indexOf(i);
                this.installationList.remove(indexRemove);
                return;
            }
        }
    }
    /**
     * Método criado para limpar completamente a lista de serviços de instalação
     */
    @Override
    public void clearList(){

        this.installationList.clear();
    }
}
