package ma.enset.exam_mohammed_elbadry.dao.beans;
public class Chercheur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String specialite;

    // Getters and Setters

    public Chercheur(String nom, String prenom, String email, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
    }

    public Chercheur() {
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialite() {
        return specialite;
    }
}