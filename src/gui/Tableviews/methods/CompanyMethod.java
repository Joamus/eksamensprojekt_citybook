package gui.Tableviews.methods;

import backend.LogicController;
import entities.Company;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 17-05-2017.
 */
public class CompanyMethod {

    public static HBox hboxCompany = new HBox();

        public static TableView<Company> tvCompany = new TableView<>();
        public static TextField cvrNumber, contactPerson, address, email, zipCode, phoneNumber;

        // Get all the children
        public static ObservableList<Company> getCompany() {
            ObservableList<Company> company = FXCollections.observableArrayList(LogicController.getCompanies());
            return company;
        }

        // Add children method
        public static void addCompany() {
            Company company = new Company();
            company.setCvrNumber(cvrNumber.getText());
            company.setAddress(address.getText());
            company.setEmail(email.getText());
            company.setZipCode(zipCode.getText());
            company.setPhoneNumber(phoneNumber.getText());
            tvCompany.getItems().add(company);
            cvrNumber.clear();
            contactPerson.clear();
            address.clear();
            email.clear();
            zipCode.clear();
            phoneNumber.clear();
        }
        // Delete company method
        public static void deleteCompany() {
            ObservableList<Company> companySelected, allCompanies;
            allCompanies = tvCompany.getItems();
            companySelected = tvCompany.getSelectionModel().getSelectedItems();

            companySelected.forEach(allCompanies::remove);
        }
        // The button 'Indregistrede børn' has been pressed in the menu.
        public static void companyTableviewStart() {

            TableColumn<Company, String> cvrNumberCol = new TableColumn<>("CVR-nummer");
            cvrNumberCol.setMinWidth(120);
            cvrNumberCol.setCellValueFactory(new PropertyValueFactory<>("cvrNumber"));

          /*  TableColumn<ContactPerson, String> contactPersonCol = new TableColumn<>("Kontaktperson");
            contactPersonCol.setMinWidth(120);
            contactPersonCol.setCellValueFactory(new PropertyValueFactory<>("contactPerson")); */

            TableColumn<Company, String> contactPersonCol = new TableColumn<>("Navn");
            contactPersonCol.setMinWidth(120);
            contactPersonCol.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<Company, String> adressCol = new TableColumn<>("Adresse");
            adressCol.setMinWidth(120);
            adressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

            TableColumn<Company, String> emailCol = new TableColumn<>("Email");
            emailCol.setMinWidth(120);
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

            TableColumn<Company, String> zipCodeCol = new TableColumn<>("Postnummer");
            zipCodeCol.setMinWidth(120);
            zipCodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));

            TableColumn<Company, String> phoneNumberCol = new TableColumn<>("Telefonnummer");
            phoneNumberCol.setMinWidth(120);
            phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

            // GridPane for the whole adding and deleting employee area
            GridPane gp3 = new GridPane();

            // VBoxes for TextFields
            VBox addCompanyBox = new VBox();
            addCompanyBox.setSpacing(10);
            addCompanyBox.setPadding(new Insets(1, 10, 100, 10));
            gp3.add(addCompanyBox, 0, 0);


            VBox addCompanyBox2 = new VBox();
            addCompanyBox2.setSpacing(10);
            //gp3.add(addCompanyBox2, 1, 0);

            // Buttons for adding and deleting Companies
            Button addCompanyBtn = new Button("Tilføj firma");
            addCompanyBtn.setId("addEmployeeButton");
            addCompanyBtn.setOnAction(e2 -> addCompany());

            Button deleteCompanyBtn = new Button("Slet firma");
            deleteCompanyBtn.setId("deleteEmployeeButton");
            deleteCompanyBtn.setOnAction(e2 -> deleteCompany());

            // TextFields for adding a child
            cvrNumber = new TextField();
            cvrNumber.setPromptText("CVR-nummer");
            cvrNumber.setMaxWidth(100);

            contactPerson = new TextField();
            contactPerson.setPromptText("Kontaktperson");
            contactPerson.setMaxWidth(100);

            address = new TextField();
            address.setPromptText("Adresse");
            address.setMaxWidth(100);

            email = new TextField();
            email.setPromptText("Email");
            email.setMaxWidth(100);

            zipCode = new TextField();
            zipCode.setPromptText("Post nummer");
            zipCode.setMaxWidth(100);

            phoneNumber = new TextField();
            phoneNumber.setPromptText("Telefon nummer");
            phoneNumber.setMaxWidth(100);

            tvCompany.setEditable(true);


            // adding the TextFields to VBox 1 and VBox 2
            addCompanyBox.getChildren().addAll(cvrNumber, contactPerson, address, email, zipCode, phoneNumber,
                    addCompanyBtn, deleteCompanyBtn);
            Label white = new Label();
            white.setId("whiteCompany");
            white.getStylesheets().addAll("gui/assets/login.css");

            addCompanyBox2.getChildren().addAll(white);

            // Setting the values stores in the getEmployees method to the tableview.
            tvCompany.setItems(getCompany());
            tvCompany.setId("tvAktivitet");
            tvCompany.getStylesheets().addAll("gui/assets/login.css");

            tvCompany.getColumns().addAll(cvrNumberCol, contactPersonCol, adressCol, emailCol, zipCodeCol, phoneNumberCol);
            hboxCompany.setId("hboxAktivitet");
            hboxCompany.getStylesheets().addAll("gui/assets/login.css");
            hboxCompany.getChildren().addAll(addCompanyBox2,tvCompany, gp3);

        }

    }

