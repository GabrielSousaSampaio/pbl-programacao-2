package dao;

import java.util.List;

public interface CRUD<G> {

    public G create(G object);

    public List<G> FindMany();

    public G FindById(int id);

    public void update(G object);

    public void delete(int id);


}
