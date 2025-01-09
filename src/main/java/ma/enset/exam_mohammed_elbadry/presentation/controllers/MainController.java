package ma.enset.exam_mohammed_elbadry.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.exam_mohammed_elbadry.dao.beans.Chercheur;
import ma.enset.exam_mohammed_elbadry.dao.beans.Publication;
import ma.enset.exam_mohammed_elbadry.metier.ILaboratoireService;
import ma.enset.exam_mohammed_elbadry.metier.LaboratoireServiceImpl;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TextField nomChercheurInput, prenomChercheurInput, emailChercheurInput, specialiteChercheurInput;
    @FXML
    private TableView<Chercheur> tableChercheurs;
    @FXML
    private TableColumn<Chercheur, Integer> colIdChercheur;
    @FXML
    private TableColumn<Chercheur, String> colNomChercheur, colPrenomChercheur, colEmailChercheur, colSpecialiteChercheur;

    @FXML
    private TextField titrePublicationInput, datePublicationInput, typePublicationInput, doiPublicationInput;
    @FXML
    private TableView<Publication> tablePublications;
    @FXML
    private TableColumn<Publication, Integer> colIdPublication;
    @FXML
    private TableColumn<Publication, String> colTitrePublication, colTypePublication, colDoiPublication;
    @FXML
    private TableColumn<Publication, Date> colDatePublication;

    private ILaboratoireService laboratoireService = new LaboratoireServiceImpl();
    private ObservableList<Chercheur> chercheurs = FXCollections.observableArrayList();
    private ObservableList<Publication> publications = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize Chercheur Table
        colIdChercheur.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNomChercheur.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenomChercheur.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colEmailChercheur.setCellValueFactory(new PropertyValueFactory<>("email"));
        colSpecialiteChercheur.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        tableChercheurs.setItems(chercheurs);
        loadChercheurs();

        // Initialize Publication Table
        colIdPublication.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitrePublication.setCellValueFactory(new PropertyValueFactory<>("titre"));
        colDatePublication.setCellValueFactory(new PropertyValueFactory<>("datePublication"));
        colTypePublication.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDoiPublication.setCellValueFactory(new PropertyValueFactory<>("doi"));
        tablePublications.setItems(publications);
        loadPublications();
    }

    private void loadChercheurs() {
        chercheurs.clear();
        chercheurs.addAll(laboratoireService.listChercheurs());
    }

    private void loadPublications() {
        publications.clear();
        List<Publication> fetchedPublications = laboratoireService.listPublications();
        System.out.println("Fetched Publications: " + fetchedPublications); // Debug statement
        publications.addAll(fetchedPublications);
    }

    @FXML
    private void onAddChercheur() {
        Chercheur chercheur = new Chercheur(nomChercheurInput.getText(), prenomChercheurInput.getText(), emailChercheurInput.getText(), specialiteChercheurInput.getText());
        laboratoireService.addChercheur(chercheur);
        loadChercheurs();
    }

    @FXML
    private void onAddPublication() {
        try {
            Date datePublication = new SimpleDateFormat("yyyy-MM-dd").parse(datePublicationInput.getText());
            Publication publication = new Publication(titrePublicationInput.getText(), datePublication, typePublicationInput.getText(), doiPublicationInput.getText());
            laboratoireService.addPublication(publication);
            loadPublications();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}