package sample;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import sample.BazaPodataka;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.LoginController;
import java.sql.Connection;
import java.sql.DriverManager;

public class ObrisiKorisnikController {

//Elementi FXML datoteke -----------------------------------------------------------------------------------------------
    @FXML
    private Button odustaniButton;

    @FXML
    private Button obrisiKorisnikButton;
//----------------------------------------------------------------------------------------------------------------------

    private Connection connection;
    private BazaPodataka bazaPodataka;

    KorisniciAdministratorController podaci = new KorisniciAdministratorController();

//Metode za kontrolu akcija tipki --------------------------------------------------------------------------------------
    public void obrisiKorisnikButtonOnAction(ActionEvent event){
        bazaPodataka = new BazaPodataka();
        obrisiKorisnika();

        Stage stageObrisiKontakt = (Stage) obrisiKorisnikButton.getScene().getWindow();
        stageObrisiKontakt.close();
    }

    public void odustaniButtonOnAction(ActionEvent event){
        Stage stageObrisiKontakt = (Stage) odustaniButton.getScene().getWindow();
        stageObrisiKontakt.close();
    }
//----------------------------------------------------------------------------------------------------------------------

    private void obrisiKorisnika(){
        try{
            //Upit bazi podataka za brisanje korisnika iz liste korisnika
            String query = "DELETE FROM korisnik " +
                    "WHERE ID = " + podaci.ID1;

            //Izvrsavanje upita
            connection = bazaPodataka.getConnection();
            int set = connection.createStatement().executeUpdate(query);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
