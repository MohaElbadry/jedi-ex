// File: src/main/java/ma/enset/exam_mohammed_elbadry/dao/ChercheurPublicationDaoImpl.java
package ma.enset.exam_mohammed_elbadry.dao;

import ma.enset.exam_mohammed_elbadry.dao.beans.ChercheurPublication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChercheurPublicationDaoImpl implements ChercheurPublicationDao {

    @Override
    public List<ChercheurPublication> findAll() {
        try {
            List<ChercheurPublication> chercheurPublications = new ArrayList<>();
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM chercheur_publication;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ChercheurPublication chercheurPublication = new ChercheurPublication();
                chercheurPublication.setChercheurId(resultSet.getInt("chercheur_id"));
                chercheurPublication.setPublicationId(resultSet.getInt("publication_id"));
                chercheurPublications.add(chercheurPublication);
            }
            return chercheurPublications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ChercheurPublication findById(int id) {
        // This method is not applicable for many-to-many relationships
        throw new UnsupportedOperationException("findById is not supported for ChercheurPublication");
    }

    @Override
    public void save(ChercheurPublication chercheurPublication) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO chercheur_publication VALUES (?,?)");
            statement.setInt(1, chercheurPublication.getChercheurId());
            statement.setInt(2, chercheurPublication.getPublicationId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ChercheurPublication chercheurPublication) {
        // This method is not applicable for many-to-many relationships
        throw new UnsupportedOperationException("update is not supported for ChercheurPublication");
    }

    @Override
    public void delete(int id) {
        // This method is not applicable for many-to-many relationships
        throw new UnsupportedOperationException("delete is not supported for ChercheurPublication");
    }
}