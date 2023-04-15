package dao.cleaning;

import model.Cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningListImpl implements CleaningDAO{

    private List<Cleaning> cleaningList;

    private int nextId;


    public CleaningListImpl() {
        this.cleaningList = new ArrayList<Cleaning>();
        this.nextId = 0;

    }

    @Override
    public Cleaning create(Cleaning cleaning) {
        cleaning.setId(nextId);
        this.nextId++;

        this.cleaningList.add(cleaning);

        return cleaning;
    }

    @Override
    public List<Cleaning> FindMany() {
        return this.cleaningList;
    }

    @Override
    public Cleaning FindById(int id) {

        for(Cleaning c: this.cleaningList){
            if(c.getId() == id){
                return c;
            }
        }

        return null;
    }

    @Override
    public void update(Cleaning cleaning) {

        int indexOF;

        for(Cleaning c: this.cleaningList){
            if(c.getId() == cleaning.getId()){
                indexOF = this.cleaningList.indexOf(c);
                this.cleaningList.set(indexOF, cleaning);
                return;
            }
        }

    }

    @Override
    public void delete(int id) {
        int indexRemove;
        for(Cleaning c: this.cleaningList){
            if(c.getId() == id){
                indexRemove = this.cleaningList.indexOf(c);
                this.cleaningList.remove(indexRemove);
                return;
            }
        }

    }
}
