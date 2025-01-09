//package ma.enset.exam_mohammed_elbadry.presentation.controllers;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import ma.enset.exam_ahmed_houssam_bouzine.dao.beans.Departement;
//import ma.enset.exam_ahmed_houssam_bouzine.dao.beans.Employe;
//import ma.enset.exam_ahmed_houssam_bouzine.dao.beans.Entreprise;
//import ma.enset.exam_ahmed_houssam_bouzine.metier.EntrepriseMetierImpl;
//import ma.enset.exam_ahmed_houssam_bouzine.metier.IEntrepriseMetier;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class MainController implements Initializable {
//    @FXML
//    private TextField nomEntrepriseInput;
//    @FXML
//    private TextField adresseEntrepriseInput;
//    @FXML
//    private TextField telephoneEntrepriseInput;
//    @FXML
//    private TextField emailEntrepriseInput;
//    @FXML
//    private TableView<Entreprise> tableEntreprises;
//
//    @FXML
//    private TableColumn<String,Entreprise> colNomEntreprise;
//    @FXML
//    private TableColumn<String,Entreprise> colAdresseEntreprise;
//    @FXML
//    private TableColumn<String,Entreprise> colTelephoneEntreprise;
//    @FXML
//    private TableColumn<String,Entreprise> colEmailEntreprise;
//    @FXML
//    private TextField searchEntrepriseInput;
//
//    @FXML
//    private TextField nomDepartementInput;
//    @FXML
//    private TableView<Departement> tableDepartements;
//
//
//    @FXML
//    private TableColumn<String, Departement> colNomDepartement;
//    @FXML
//    private TableColumn<String,Departement> colEntrepriseDepartement;
//
//    @FXML
//    private TextField searchDepartementInput;
//
//    @FXML
//    private TextField nomEmployeInput;
//    @FXML
//    private TextField posteEmployeInput;
//    @FXML
//    private TextField salaireEmployeInput;
//
//    @FXML
//    private TableView<Employe> tablesEmployes;
//
//    @FXML
//    private TableColumn<String,Employe> colNomEmploye;
//    @FXML
//    private TableColumn<String,Employe> colPosteEmploye;
//    @FXML
//    private TableColumn<Double,Employe> colSalaireEmploye;
//    @FXML
//    private TableColumn<String,Employe> colDepartementEmploye;
//    @FXML
//    private TextField searchEmployeInput;
//    @FXML
//    private ComboBox<Entreprise> comboboxEntreprise;
//    @FXML
//    private ComboBox<Departement> comboboxDepartement;
//
//
//    ObservableList<Entreprise> entreprises = FXCollections.observableArrayList();
//    ObservableList<Employe> employees = FXCollections.observableArrayList();
//    ObservableList<Departement> departements = FXCollections.observableArrayList();
//    IEntrepriseMetier iEntrepriseMetier;
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//       iEntrepriseMetier = new EntrepriseMetierImpl();
//       //Entreprise
//        colNomEntreprise.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        colAdresseEntreprise.setCellValueFactory(new PropertyValueFactory<>("adresse"));
//        colTelephoneEntreprise.setCellValueFactory(new PropertyValueFactory<>("telephone"));
//        colEmailEntreprise.setCellValueFactory(new PropertyValueFactory<>("email"));
//        entreprises.addAll(iEntrepriseMetier.findAllEntreprise());
//        tableEntreprises.setItems(entreprises);
//        loadEntreprises();
//        searchEntrepriseInput.textProperty().addListener((observableValue, old, newVal) -> {
//            entreprises.clear();
//            entreprises.addAll(iEntrepriseMetier.getEntrepriseParMotCle(newVal));
//        });
//
//        // Departement
//        colNomDepartement.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        colEntrepriseDepartement.setCellValueFactory(new PropertyValueFactory<>("entreprise"));
//        departements.addAll(iEntrepriseMetier.findAllDepartement());
//        tableDepartements.setItems(departements);
//        comboboxEntreprise.getItems().addAll(iEntrepriseMetier.findAllEntreprise());
//        loadDepartements();
//        // Employe
//        colNomEmploye.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        colPosteEmploye.setCellValueFactory(new PropertyValueFactory<>("poste"));
//        colSalaireEmploye.setCellValueFactory(new PropertyValueFactory<>("salaire"));
//        colDepartementEmploye.setCellValueFactory(new PropertyValueFactory<>("departement"));
//        employees.addAll(iEntrepriseMetier.findAllEmploye());
//        comboboxDepartement.getItems().addAll(iEntrepriseMetier.findAllDepartement());
//        tablesEmployes.setItems(employees);
//        loadEmployees();
//
//    }
//    private void loadEmployees(){
//        employees.clear();
//        employees.addAll(iEntrepriseMetier.findAllEmploye());
//        tablesEmployes.setItems(employees);
//    }
//    private void loadEntreprises(){
//        entreprises.clear();
//        entreprises.addAll(iEntrepriseMetier.findAllEntreprise());
//        tableEntreprises.setItems(entreprises);
//    }
//    private void loadDepartements(){
//        departements.clear();
//        departements.addAll(iEntrepriseMetier.findAllDepartement());
//        tableDepartements.setItems(departements);
//    }
//    public void onAddEntreprise() {
//        Entreprise entreprise = new Entreprise();
//        entreprise.setNom(nomEntrepriseInput.getText());
//        entreprise.setAdresse(adresseEntrepriseInput.getText());
//        entreprise.setTelephone(telephoneEntrepriseInput.getText());
//        entreprise.setEmail(emailEntrepriseInput.getText());
//        iEntrepriseMetier.saveEntreprise(entreprise);
//        nomEntrepriseInput.clear();
//        adresseEntrepriseInput.clear();
//        telephoneEntrepriseInput.clear();
//        emailEntrepriseInput.clear();
//        loadEntreprises();
//    }
//    public void onDeleteEntreprise(){
//        Entreprise entreprise = tableEntreprises.getSelectionModel().getSelectedItem();
//        iEntrepriseMetier.deleteEntreprise(entreprise.getId());
//        loadEntreprises();
//    }
//    public void onAddDepartement() {
//        Departement departement = new Departement();
//        departement.setNom(nomDepartementInput.getText());
//        Entreprise entreprise =  comboboxEntreprise.getSelectionModel().getSelectedItem();
//        departement.setEntreprise(entreprise);
//        iEntrepriseMetier.saveDepartement(departement);
//        nomDepartementInput.clear();
//        loadDepartements();
//    }
//    public void onDeleteDepartement(){
//        Departement departement = tableDepartements.getSelectionModel().getSelectedItem();
//        iEntrepriseMetier.deleteDepartement(departement.getId());
//        loadDepartements();
//    } public void onAddEmploye() {
//        Employe employe = new Employe();
//        employe.setNom(nomEmployeInput.getText());
//        employe.setPoste(posteEmployeInput.getText());
//        employe.setSalaire(Double.parseDouble(salaireEmployeInput.getText()));
//        Departement departement =  comboboxDepartement.getSelectionModel().getSelectedItem();
//        employe.setDepartement(departement);
//        iEntrepriseMetier.saveDepartement(departement);
//        nomEmployeInput.clear();
//        posteEmployeInput.clear();
//        salaireEmployeInput.clear();
//        loadEmployees();
//    }
//    public void onDeleteEmploye(){
//        Employe employe = tablesEmployes.getSelectionModel().getSelectedItem();
//        iEntrepriseMetier.deleteEmploye(employe.getId());
//        loadEmployees();
//    }
//}