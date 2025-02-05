// File: src/main/java/ma/enset/exam_mohammed_elbadry/service/LaboratoireServiceImpl.java
package ma.enset.exam_mohammed_elbadry.metier;

import ma.enset.exam_mohammed_elbadry.dao.*;
import ma.enset.exam_mohammed_elbadry.dao.beans.Chercheur;
import ma.enset.exam_mohammed_elbadry.dao.beans.ChercheurPublication;
import ma.enset.exam_mohammed_elbadry.dao.beans.Publication;
import ma.enset.exam_mohammed_elbadry.metier.ILaboratoireService;

import java.util.List;
import java.util.stream.Collectors;

public class LaboratoireServiceImpl implements ILaboratoireService {
    private ChercheurDao chercheurDao = new ChercheurDaoImpl();
    private PublicationDao publicationDao = new PublicationDaoImpl();
    private ChercheurPublicationDao chercheurPublicationDao = new ChercheurPublicationDaoImpl();

    @Override
    public void addChercheur(Chercheur chercheur) {
        chercheurDao.save(chercheur);
    }

    @Override
    public void updateChercheur(Chercheur chercheur) {
        chercheurDao.update(chercheur);
    }

    @Override
    public void deleteChercheur(int id) {
        chercheurDao.delete(id);
    }

    @Override
    public List<Chercheur> listChercheurs() {
        return chercheurDao.findAll();
    }

    @Override
    public List<Chercheur> searchChercheurBySpecialiteOrNom(String keyword) {
        return chercheurDao.findAll().stream()
                .filter(c -> c.getNom().contains(keyword) || c.getSpecialite().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public void addPublication(Publication publication) {
        publicationDao.save(publication);
    }

    @Override
    public void updatePublication(Publication publication) {
        publicationDao.update(publication);
    }

    @Override
    public void deletePublication(int id) {
        publicationDao.delete(id);
    }

    @Override
    public List<Publication> listPublications() {
        return publicationDao.findAll();
    }

    @Override
    public List<Publication> listPublicationsByType(String type) {
        return publicationDao.findAll().stream()
                .filter(p -> p.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Publication> searchPublicationByTitleOrDoi(String keyword) {
        return publicationDao.findAll().stream()
                .filter(p -> p.getTitre().contains(keyword) || p.getDoi().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<Publication> listPublicationsByChercheur(int chercheurId) {
        return List.of();
    }


    @Override
    public void addChercheurPublication(ChercheurPublication chercheurPublication) {
        chercheurPublicationDao.save(chercheurPublication);
    }

    @Override
    public List<ChercheurPublication> listChercheurPublications() {
        return chercheurPublicationDao.findAll();
    }
}