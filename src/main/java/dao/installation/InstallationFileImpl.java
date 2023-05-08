package main.java.dao.installation;

import main.java.dao.FileHandling;
import main.java.model.services.Installation;

import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "InstallationDAO" para manipulação dos serviços de
 * instalação oferecidos e armazenados no sistema através de arquivos.
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */
public class InstallationFileImpl implements InstallationDAO{

    private List<Installation> installationList;
    private int nextId;

    //Constructor

    /**
     * Método cronstrutor que lê ou cria o arquivo e atualiza o id
     *
     */
    public InstallationFileImpl() {
        this.installationList= FileHandling.readFile("src\\filesSaves\\installation.dat");

        if(installationList.size() == 0) {
            this.nextId = 1;
        }else{

            this.nextId = (installationList.get(installationList.size() - 1).getId()) + 1;
        }
    }

    //Methods

    /**
     * Método criado para a adição de um serviço de instalação no arquivo
     * @param installation O serviço de instalação que deseja inserir no arquivo
     * @return O serviço de instalaçãoa enviado
     */
    @Override
    public Installation create(Installation installation) {
        installation.setId(nextId);
        this.nextId++;
        this.installationList.add(installation);

        FileHandling.saveInFile(this.installationList,"src\\filesSaves\\installation.dat");
        return installation;
    }

    /**
     * Método criado para adquirir todos os serviços de instalação cadastrados no arquivo
     * @return A lista com todos os serviços de instalação cadastrados no arquivo
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
     * Método criado para atuallizar os dados de um serviço de instalação previamente cadastrado no arquivo
     * @param installation O serviço de instalação que deseja atuaizar os dados
     */
    @Override
    public void update(Installation installation) {
        int indexOF;
        for(Installation i: this.installationList){
            if(i.getId() == installation.getId()){
                indexOF = this.installationList.indexOf(i);
                this.installationList.set(indexOF, installation);
                FileHandling.saveInFile(this.installationList,"src\\filesSaves\\installation.dat");
                return;
            }
        }
    }

    /**
     * Método criado para deletar um serviço de instalação cadastrado no arquivo
     * @param id O id do serviço de instalação
     */
    @Override
    public void delete(int id) {
        int indexRemove;
        for(Installation i: this.installationList){
            if(i.getId() == id){
                indexRemove = this.installationList.indexOf(i);
                this.installationList.remove(indexRemove);
                FileHandling.saveInFile(this.installationList,"src\\filesSaves\\installation.dat");
                return;
            }
        }
    }
    /**
     * Método criado para limpar completamente a lista de serviços de instalação cadastrados no arquivo
     */
    @Override
    public void clearList(){

        this.installationList.clear();
        FileHandling.saveInFile(this.installationList,"src\\filesSaves\\installation.dat");
    }
}
