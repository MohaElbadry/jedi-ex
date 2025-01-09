package ma.enset.exam_mohammed_elbadry.metier;

import ma.enset.exam_mohammed_elbadry.dao.beans.Chercheur;
import ma.enset.exam_mohammed_elbadry.dao.beans.Publication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppTest {
    public static void main(String[] args) {
        ILaboratoireService laboratoireService = new LaboratoireServiceImpl();

        // Add a new Chercheur
        Chercheur chercheur = new Chercheur("John", "Doe", "john.doe@example.com", "Computer Science");
        laboratoireService.addChercheur(chercheur);
        System.out.println("Chercheur added: " + chercheur.getNom());

        // Update the Chercheur
        chercheur.setNom("Jane");
        laboratoireService.updateChercheur(chercheur);
        System.out.println("Chercheur updated: " + chercheur.getNom());

        // List all Chercheurs
        System.out.println("List of Chercheurs:");
        laboratoireService.listChercheurs().forEach(c -> System.out.println(c.getId() + " - " + c.getNom() + " " + c.getPrenom()));

        // Add a new Publication
        Date datePublication;
        try {
            datePublication = new SimpleDateFormat("yyyy-MM-dd").parse("2023-10-01");
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format.");
        }
        Publication publication = new Publication("Research Paper", datePublication, "Article", "10.1000/xyz123", chercheur);
        laboratoireService.addPublication(publication);
        System.out.println("Publication added: " + publication.getTitre());

        // Update the Publication
        publication.setTitre("Updated Research Paper");
        laboratoireService.updatePublication(publication);
        System.out.println("Publication updated: " + publication.getTitre());

        // List all Publications
        System.out.println("List of Publications:");
        laboratoireService.listPublicationsByType("Article").forEach(p -> System.out.println(p.getId() + " - " + p.getTitre()));
    }
}