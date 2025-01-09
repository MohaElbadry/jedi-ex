// File: src/main/java/ma/enset/exam_mohammed_elbadry/dao/PublicationDaoImpl.java
package ma.enset.exam_mohammed_elbadry.dao;

import ma.enset.exam_mohammed_elbadry.dao.beans.Publication;
import ma.enset.exam_mohammed_elbadry.dao.beans.Chercheur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublicationDaoImpl implements PublicationDao {

    @Override
    public List<Publication> findAll() {
        try {
            List<Publication> publications = new ArrayList<>();
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM publication;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publication publication = new Publication();
                publication.setId(resultSet.getInt("ID"));
                publication.setTitre(resultSet.getString("TITRE"));
                publication.setDatePublication(resultSet.getDate("DATE_PUBLICATION"));
                publication.setType(resultSet.getString("TYPE"));
                publication.setDoi(resultSet.getString("DOI"));

                publications.add(publication);
            }
            return publications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Publication findById(int id) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM publication WHERE ID=?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) return null;
            Publication publication = new Publication();
            publication.setId(resultSet.getInt("ID"));
            publication.setTitre(resultSet.getString("TITRE"));
            publication.setDatePublication(resultSet.getDate("DATE_PUBLICATION"));
            publication.setType(resultSet.getString("TYPE"));
            publication.setDoi(resultSet.getString("DOI"));
            // Assuming you have a method to find Chercheur by ID
            ChercheurDao chercheurDao = new ChercheurDaoImpl();
            Chercheur chercheur = chercheurDao.findById(resultSet.getInt("AUTEUR_PRINCIPAL_ID"));
            return publication;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Publication publication) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO publication VALUES (null,?,?,?,?)");
            statement.setString(1, publication.getTitre());
            statement.setDate(2, new java.sql.Date(publication.getDatePublication().getTime()));
            statement.setString(3, publication.getType());
            statement.setString(4, publication.getDoi());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Publication publication) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE publication SET TITRE=?,  TYPE=?, DOI=? WHERE ID=?");
            statement.setString(1, publication.getTitre());
            statement.setString(2, publication.getType());
            statement.setString(3, publication.getDoi());
            statement.setInt(4, publication.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM publication WHERE ID=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}