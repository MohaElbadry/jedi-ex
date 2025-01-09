package ma.enset.exam_mohammed_elbadry.dao;

import ma.enset.exam_mohammed_elbadry.dao.beans.Chercheur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChercheurDaoImpl implements ChercheurDao {

    @Override
    public List<Chercheur> findAll() {
        try {
            List<Chercheur> chercheurs = new ArrayList<>();
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM chercheur;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Chercheur chercheur = new Chercheur();
                chercheur.setNom(resultSet.getString("NOM"));
                chercheur.setPrenom(resultSet.getString("PRENOM"));
                chercheur.setEmail(resultSet.getString("EMAIL"));
                chercheur.setSpecialite(resultSet.getString("SPECIALITE"));
                chercheurs.add(chercheur);
            }
            return chercheurs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Chercheur findById(int id) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM chercheur WHERE ID=?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) return null;
            Chercheur chercheur = new Chercheur();
            chercheur.setNom(resultSet.getString("NOM"));
            chercheur.setPrenom(resultSet.getString("PRENOM"));
            chercheur.setEmail(resultSet.getString("EMAIL"));
            chercheur.setSpecialite(resultSet.getString("SPECIALITE"));
            return chercheur;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Chercheur chercheur) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO chercheur VALUES (null,?,?,?,?)");
            statement.setString(1, chercheur.getNom());
            statement.setString(2, chercheur.getPrenom());
            statement.setString(3, chercheur.getEmail());
            statement.setString(4, chercheur.getSpecialite());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Chercheur chercheur) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE chercheur SET NOM=?, PRENOM=?, EMAIL=?, SPECIALITE=? WHERE ID=?");
            statement.setString(1, chercheur.getNom());
            statement.setString(2, chercheur.getPrenom());
            statement.setString(3, chercheur.getEmail());
            statement.setString(4, chercheur.getSpecialite());
            statement.setInt(5, chercheur.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM chercheur WHERE ID=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}