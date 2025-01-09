// File: src/main/java/ma/enset/exam_mohammed_elbadry/metier/AppConsole.java
package ma.enset.exam_mohammed_elbadry.metier;

import ma.enset.exam_mohammed_elbadry.dao.beans.Chercheur;
import ma.enset.exam_mohammed_elbadry.dao.beans.Publication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuTest {
    private static ILaboratoireService laboratoireService = new LaboratoireServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Chercheur");
            System.out.println("2. Update Chercheur");
            System.out.println("3. Delete Chercheur");
            System.out.println("4. List Chercheurs");
            System.out.println("5. Search Chercheur by Specialite or Nom");
            System.out.println("6. Add Publication");
            System.out.println("7. Update Publication");
            System.out.println("8. Delete Publication");
            System.out.println("9. List Publications by Type");
            System.out.println("10. Search Publication by Title or DOI");
            System.out.println("11. List Publications by Chercheur");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addChercheur();
                    break;
                case 2:
                    updateChercheur();
                    break;
                case 3:
                    deleteChercheur();
                    break;
                case 4:
                    listChercheurs();
                    break;
                case 5:
                    searchChercheur();
                    break;
                case 6:
                    addPublication();
                    break;
                case 7:
                    updatePublication();
                    break;
                case 8:
                    deletePublication();
                    break;
                case 9:
                    listPublicationsByType();
                    break;
                case 10:
                    searchPublication();
                    break;
                case 11:
                    listPublicationsByChercheur();
                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addChercheur() {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Specialite: ");
        String specialite = scanner.nextLine();
        Chercheur chercheur = new Chercheur(nom, prenom, email, specialite);
        laboratoireService.addChercheur(chercheur);
        System.out.println("Chercheur added successfully.");
    }

    private static void updateChercheur() {
        System.out.print("Chercheur ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Chercheur chercheur = laboratoireService.listChercheurs().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        if (chercheur == null) {
            System.out.println("Chercheur not found.");
            return;
        }
        System.out.print("Nom: ");
        chercheur.setNom(scanner.nextLine());
        System.out.print("Prenom: ");
        chercheur.setPrenom(scanner.nextLine());
        System.out.print("Email: ");
        chercheur.setEmail(scanner.nextLine());
        System.out.print("Specialite: ");
        chercheur.setSpecialite(scanner.nextLine());
        laboratoireService.updateChercheur(chercheur);
        System.out.println("Chercheur updated successfully.");
    }

    private static void deleteChercheur() {
        System.out.print("Chercheur ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        laboratoireService.deleteChercheur(id);
        System.out.println("Chercheur deleted successfully.");
    }

    private static void listChercheurs() {
        List<Chercheur> chercheurs = laboratoireService.listChercheurs();
        chercheurs.forEach(c -> System.out.println(c.getId() + " - " + c.getNom() + " " + c.getPrenom() + " (" + c.getSpecialite() + ")"));
    }

    private static void searchChercheur() {
        System.out.print("Keyword: ");
        String keyword = scanner.nextLine();
        List<Chercheur> chercheurs = laboratoireService.searchChercheurBySpecialiteOrNom(keyword);
        chercheurs.forEach(c -> System.out.println(c.getId() + " - " + c.getNom() + " " + c.getPrenom() + " (" + c.getSpecialite() + ")"));
    }

    private static void addPublication() {
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Date de Publication (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        Date datePublication;
        try {
            datePublication = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("DOI: ");
        String doi = scanner.nextLine();
        System.out.print("Auteur Principal ID: ");
        int auteurPrincipalId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Chercheur auteurPrincipal = laboratoireService.listChercheurs().stream()
                .filter(c -> c.getId() == auteurPrincipalId)
                .findFirst()
                .orElse(null);
        if (auteurPrincipal == null) {
            System.out.println("Chercheur not found.");
            return;
        }
        Publication publication = new Publication(titre, datePublication, type, doi, auteurPrincipal);
        laboratoireService.addPublication(publication);
        System.out.println("Publication added successfully.");
    }

    private static void updatePublication() {
        System.out.print("Publication ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Publication publication = laboratoireService.listPublicationsByType("").stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (publication == null) {
            System.out.println("Publication not found.");
            return;
        }
        System.out.print("Titre: ");
        publication.setTitre(scanner.nextLine());
        System.out.print("Date de Publication (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        try {
            publication.setDatePublication(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr));
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }
        System.out.print("Type: ");
        publication.setType(scanner.nextLine());
        System.out.print("DOI: ");
        publication.setDoi(scanner.nextLine());
        System.out.print("Auteur Principal ID: ");
        int auteurPrincipalId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Chercheur auteurPrincipal = laboratoireService.listChercheurs().stream()
                .filter(c -> c.getId() == auteurPrincipalId)
                .findFirst()
                .orElse(null);
        if (auteurPrincipal == null) {
            System.out.println("Chercheur not found.");
            return;
        }
        publication.setAuteurPrincipal(auteurPrincipal);
        laboratoireService.updatePublication(publication);
        System.out.println("Publication updated successfully.");
    }

    private static void deletePublication() {
        System.out.print("Publication ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        laboratoireService.deletePublication(id);
        System.out.println("Publication deleted successfully.");
    }

    private static void listPublicationsByType() {
        System.out.print("Type: ");
        String type = scanner.nextLine();
        List<Publication> publications = laboratoireService.listPublicationsByType(type);
        publications.forEach(p -> System.out.println(p.getId() + " - " + p.getTitre() + " (" + p.getType() + ")"));
    }

    private static void searchPublication() {
        System.out.print("Keyword: ");
        String keyword = scanner.nextLine();
        List<Publication> publications = laboratoireService.searchPublicationByTitleOrDoi(keyword);
        publications.forEach(p -> System.out.println(p.getId() + " - " + p.getTitre() + " (" + p.getType() + ")"));
    }

    private static void listPublicationsByChercheur() {
        System.out.print("Chercheur ID: ");
        int chercheurId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        List<Publication> publications = laboratoireService.listPublicationsByChercheur(chercheurId);
        publications.forEach(p -> System.out.println(p.getId() + " - " + p.getTitre() + " (" + p.getType() + ")"));
    }
}