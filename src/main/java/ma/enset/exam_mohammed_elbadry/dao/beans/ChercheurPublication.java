// File: src/main/java/ma/enset/exam_mohammed_elbadry/dao/beans/ChercheurPublication.java
package ma.enset.exam_mohammed_elbadry.dao.beans;

public class ChercheurPublication {
    private int chercheurId;
    private int publicationId;

    public ChercheurPublication(int chercheurId, int publicationId) {
        this.chercheurId = chercheurId;
        this.publicationId = publicationId;
    }

    public ChercheurPublication() {
    }

    public int getChercheurId() {
        return chercheurId;
    }

    public void setChercheurId(int chercheurId) {
        this.chercheurId = chercheurId;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }
}