/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.chatbotsongs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leoan
 */
public class PantallaPrincipalController implements Initializable {

    @FXML
    private VBox vboxPrincipal1;
    @FXML
    private Pane panePrincipal2;
    @FXML
    private VBox vboxPrincipal3;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciar();
    }

    public void iniciar() {
        vboxPrincipal1.setMinWidth(483);
        panePrincipal2.setMinWidth(400);
        vboxPrincipal3.setMinWidth(483);
        ImageView iv1 = App.foto(App.pathImg + "ChatBot.png", 400, 400);
        ImageView iv2 = App.foto(App.pathImg + "ChatBot.png", 400, 400);
        vboxPrincipal1.getChildren().add(iv1);
        vboxPrincipal3.getChildren().add(iv2);
        ImageView pantalla = App.foto(App.pathImg + "FondoPantalla.jpeg", 400, 1300);
        panePrincipal2.getChildren().add(pantalla);
        ImageView whatsapp = App.foto(App.pathImg + "WhatsApp.png", 50, 50);
        ImageView facebook = App.foto(App.pathImg + "Facebook.png", 50, 50);
        ImageView instagram = App.foto(App.pathImg + "Instagram.png", 50, 50);
        ImageView chrome = App.foto(App.pathImg + "Chrome.png", 50, 50);
        ImageView academico = App.foto(App.pathImg + "Academico.png", 50, 50);
        ubicarFoto(whatsapp, 50, 50);
        ubicarFoto(facebook, 150, 50);
        ubicarFoto(instagram, 250, 50);
        ubicarFoto(chrome, 50, 150);
        ubicarFoto(academico, 150, 150);
        panePrincipal2.getChildren().addAll(whatsapp, facebook, instagram, chrome, academico);
        abrirWhatsapp(whatsapp);
    }

    public void ubicarFoto(ImageView imagen, int numeroAncho, int numeroAltura) {
        imagen.relocate(numeroAncho, numeroAltura);
    }

    public void abrirWhatsapp(ImageView iv) {
        iv.setOnMouseClicked((MouseEvent t) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Whatsapp.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
