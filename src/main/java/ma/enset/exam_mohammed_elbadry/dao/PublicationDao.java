package ma.enset.exam_mohammed_elbadry.dao;

import ma.enset.exam_mohammed_elbadry.dao.beans.Publication;

import java.util.List;

public interface PublicationDao extends Dao<Publication> {
    @Override
    public List<Publication> findAll();

    @Override
    public Publication findById(int id);

    @Override
    public void save(Publication publication);

    @Override
    public void update(Publication publication);

    @Override
    public void delete(int id);

}
