package ma.enset.exam_mohammed_elbadry.dao.beans;

import java.util.Date;

public class Publication {
    private int id;
    private String titre;
    private Date datePublication;
    private String type;
    private String doi;
    private Chercheur auteurPrincipal;

    public Publication(String titre, Date datePublication, String type, String doi, Chercheur auteurPrincipal) {
        this.titre = titre;
        this.datePublication = datePublication;
        this.type = type;
        this.doi = doi;
        this.auteurPrincipal = auteurPrincipal;
    }

    public Publication() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public Chercheur getAuteurPrincipal() {
        return auteurPrincipal;
    }

    public void setAuteurPrincipal(Chercheur auteurPrincipal) {
        this.auteurPrincipal = auteurPrincipal;
    }
}
