package dao.installation;

import model.Installation;

import java.util.ArrayList;
import java.util.List;

public class InstallationListImpl implements InstallationDAO{

    private List<Installation> installationList;
    private int nextId;

    public InstallationListImpl() {
        this.installationList = new ArrayList<Installation>();
        this.nextId = 0;
    }

    @Override
    public Installation create(Installation installation) {
        installation.setId(nextId);
        this.nextId++;
        this.installationList.add(installation);
        return installation;
    }

    @Override
    public List<Installation> FindMany() {
        return this.installationList;
    }

    @Override
    public Installation FindById(int id) {
        for(Installation i: this.installationList){
            if(i.getId() == id){
                return i;
            }
        }

        return null;
    }

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
}
