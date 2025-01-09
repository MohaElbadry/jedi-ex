package ma.enset.exam_mohammed_elbadry.metier;

import ma.enset.exam_mohammed_elbadry.dao.beans.Chercheur;
import ma.enset.exam_mohammed_elbadry.dao.beans.Publication;

import java.util.List;

public interface ILaboratoireService {


    // Chercheur
    void addChercheur(Chercheur chercheur);

    void updateChercheur(Chercheur chercheur);

    void deleteChercheur(int id);

    List<Chercheur> listChercheurs();

    List<Chercheur> searchChercheurBySpecialiteOrNom(String keyword);

    //Publication
    void addPublication(Publication publication);

    void updatePublication(Publication publication);

    void deletePublication(int id);

    List<Publication> listPublicationsByType(String type);

    List<Publication> searchPublicationByTitleOrDoi(String keyword);

    List<Publication> listPublicationsByChercheur(int chercheurId);


}
