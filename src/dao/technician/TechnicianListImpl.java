package dao.technician;

import model.Technician;
import java.util.ArrayList;
import java.util.List;

public class TechnicianListImpl implements TechnicianDAO{

    private List<Technician> TechnicianList;

    private int nextID;

    public TechnicianListImpl() {
        this.TechnicianList = new ArrayList<Technician>();
        this.nextID = 0;

    }

    @Override
    public Technician create(Technician technician) {

        technician.setId(nextID);
        this.nextID++;

        this.TechnicianList.add(technician);

        return technician;
    }


    @Override
    public List<Technician> FindMany() {
        return this.TechnicianList;
    }

    @Override
    public Technician FindById(int id) {

        for(Technician t: this.TechnicianList){
            if(t.getId() == id){
                return t;
            }
        }

        return null;
    }

    @Override
    public void update(Technician technician) {

        int indexOF;

        for(Technician t: this.TechnicianList){
            if(t.getId() == technician.getId()){
                indexOF = this.TechnicianList.indexOf(t);
                this.TechnicianList.set(indexOF, technician);
                return;
            }
        }

    }


    @Override
    public void delete(int id) {

        int indexRemove;
        for(Technician t: this.TechnicianList){
            if(t.getId() == id){
                indexRemove = this.TechnicianList.indexOf(t);
                this.TechnicianList.remove(indexRemove);
                return;
            }
        }

    }

}
