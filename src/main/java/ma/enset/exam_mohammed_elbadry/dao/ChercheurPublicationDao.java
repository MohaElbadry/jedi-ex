// File: src/main/java/ma/enset/exam_mohammed_elbadry/dao/ChercheurPublicationDao.java
package ma.enset.exam_mohammed_elbadry.dao;

import ma.enset.exam_mohammed_elbadry.dao.beans.ChercheurPublication;

import java.util.List;

public interface ChercheurPublicationDao extends Dao<ChercheurPublication> {
    @Override
    List<ChercheurPublication> findAll();

    @Override
    ChercheurPublication findById(int id);

    @Override
    void save(ChercheurPublication chercheurPublication);

    @Override
    void update(ChercheurPublication chercheurPublication);

    @Override
    void delete(int id);
}