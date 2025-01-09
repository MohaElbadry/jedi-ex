package ma.enset.exam_mohammed_elbadry.dao;

import ma.enset.exam_mohammed_elbadry.dao.beans.Chercheur;

import java.util.List;

public interface ChercheurDao extends Dao<Chercheur> {
    @Override
    public List<Chercheur> findAll();

    @Override
    public Chercheur findById(int id);

    @Override
    public void save(Chercheur chercheur);

    @Override
    public void update(Chercheur chercheur);

    @Override
    public void delete(int id);
}
