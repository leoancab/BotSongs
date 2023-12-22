/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.chatbotsongs;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author leoan
 */
public class WhatsappController implements Initializable {

    @FXML
    private VBox vboxWhatsapp1;
    @FXML
    private VBox vboxWhatsapp2;
    @FXML
    private VBox vboxWhatsapp3;
    @FXML
    private VBox subPantalla1;
    public String menu = "¡Hola! Soy BotSongs. ¿En qué te puedo ayudar?\n"
            + "Envía el número de la opción que deseas realizar.\n"
            + "**********MENU**********\n"
            + "1. Generar contraseña\n"
            + "2. Reescribir una canción\n"
            + "3. Salir";

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

    private void iniciar() {
        vboxWhatsapp1.setMinWidth(483);
        vboxWhatsapp2.setMinWidth(400);
        vboxWhatsapp3.setMinWidth(483);
        subPantalla1.setMinHeight(625);
        ImageView iv1 = App.foto(App.pathImg + "ChatBot.png", 400, 400);
        ImageView iv2 = App.foto(App.pathImg + "ChatBot.png", 400, 400);
        vboxWhatsapp1.getChildren().add(iv1);
        vboxWhatsapp3.getChildren().add(iv2);
        subPantalla1.getChildren().add(App.foto(App.pathImg + "Encabezado.jpg", 400, 150));
        abrirBot(crearChat("ChatBot Songs", "ChatBot.png", subPantalla1));
        vboxWhatsapp2.getChildren().add(App.foto(App.pathImg + "Pie.png", 400, 50));
    }

    private HBox crearChat(String nombre, String foto, VBox vbox) {
        HBox hboxChat = new HBox();
        Label lbNombre = new Label(nombre);
        lbNombre.setFont(Font.font("System", FontWeight.BOLD, 20));
        ImageView iv = App.foto(App.pathImg + foto, 50, 50);
        VBox vboxChat = new VBox();
        vboxChat.getChildren().add(lbNombre);
        hboxChat.getChildren().addAll(iv, vboxChat);
        vbox.getChildren().add(hboxChat);
        return hboxChat;
    }

    private void abrirBot(HBox hbox) {
        hbox.setOnMouseClicked((MouseEvent t) -> {
            subPantalla1.getChildren().clear();
            vboxWhatsapp2.getChildren().clear();
            ScrollPane spPantalla = new ScrollPane();
            spPantalla.setContent(subPantalla1);
            subPantalla1.setMinHeight(2000);
            spPantalla.setPrefHeight(650);
            Button btEnviar = new Button("Enviar");
            TextField tfChat = new TextField();
            HBox hboxRespuesta = new HBox();
            hboxRespuesta.getChildren().addAll(tfChat, btEnviar);
            hboxRespuesta.setAlignment(Pos.CENTER);
            hboxRespuesta.setSpacing(20);
            subPantalla1.getChildren().add(App.foto(App.pathImg + "Chat.jpg", 400, 60));
            subPantalla1.setSpacing(10);
            vboxWhatsapp2.getChildren().addAll(spPantalla, hboxRespuesta);
            tfChat.setOnKeyPressed((KeyEvent k) -> {
                if (k.getCode().equals(KeyCode.ENTER)) {
                    enviar(btEnviar, tfChat, menu);
                }
            });
        });
    }

    private void enviar(Button bt, TextField tf, String respuesta) {
        //mensaje(tf.getText(), true);
        mensaje(respuesta, false);
        tf.clear();
        tf.setOnKeyPressed((KeyEvent k1) -> {
            if (k1.getCode().equals(KeyCode.ENTER)) {
                menu(tf, bt);
                tf.clear();
            }
        });
    }

    private void mensaje(String mensaje, boolean m) {
        HBox hbox = new HBox();
        Label lbMensaje = new Label(mensaje);
        hbox.getChildren().add(lbMensaje);
        if (m == true) {
            hbox.setAlignment(Pos.CENTER_RIGHT);
            hbox.setPadding(new Insets(0, 20, 0, 0));
        } else {
            hbox.setAlignment(Pos.CENTER_LEFT);
            hbox.setPadding(new Insets(0, 0, 0, 10));
        }
        subPantalla1.getChildren().add(hbox);
    }

    private String contraseña(String contr) {
        String clave = "";
        String[] palabras = contr.split(",");
        for (String palabra : palabras) {
            for (int j = 0; j < palabra.length(); j++) {
                if (palabra.charAt(j) == 'a') {
                    palabra = palabra.replace(palabra.charAt(j), '@');
                } else if (palabra.charAt(j) == 'e') {
                    palabra = palabra.replace(palabra.charAt(j), '3');
                } else if (palabra.charAt(j) == 'i') {
                    palabra = palabra.replace(palabra.charAt(j), 'L');
                } else if (palabra.charAt(j) == 'o') {
                    palabra = palabra.replace(palabra.charAt(j), '0');
                }
            }
            clave += palabra;
        }
        return clave;
    }

    private void generarContra(TextField tf, Button bt) {
        mensaje("Ingresa las palabras clave separadas por coma:", false);
        tf.setOnKeyPressed((KeyEvent k) -> {
            if (k.getCode().equals(KeyCode.ENTER)) {
                mensaje(tf.getText(), true);
                mensaje("Tu nueva contraseña es: " + contraseña(tf.getText()), false);
                tf.clear();
                agrado();
                tf.setOnKeyPressed((KeyEvent k1) -> {
                    if (k1.getCode().equals(KeyCode.ENTER)) {
                        mensaje(tf.getText(), true);
                        if (tf.getText().equals("1")) {
                            enviar(bt, tf, menu);
                        } else if (tf.getText().equals("2")) {
                            generarContra(tf, bt);
                        }
                        tf.clear();
                    }
                });
            }
        }
        );
    }

    private void agrado() {
        mensaje("Es de tu agrado?\n"
                + "1. Sí!\n"
                + "2. No", false);
    }

    private void menuCanciones() {
        mensaje("Que cancion deseas?", false);
        for (int i = 0; i < ManejoArchivos.LeeFichero("Canciones.txt").size(); i++) {
            mensaje(String.valueOf(i + 1) + ".- " + ManejoArchivos.LeeFichero("Canciones.txt").get(i).split("\\|")[1], false);
        }
    }

    private void reescribirCancion(TextField tf, Button bt) {
        menuCanciones();
        tf.setOnKeyPressed((KeyEvent k) -> {
            if (k.getCode().equals(KeyCode.ENTER)) {
                mensaje(tf.getText(), true);
                //tf.clear();
                tf.setOnKeyPressed((KeyEvent k1) -> {
                    if (k1.getCode().equals(KeyCode.ENTER)) {
                        String opcion = tf.getText();

                        String cancion = ManejoArchivos.LeeFichero("Canciones.txt").get(Integer.valueOf(opcion) - 1).split("\\|")[1].split("-")[0];
                        String musico = ManejoArchivos.LeeFichero("Canciones.txt").get(Integer.valueOf(opcion) - 1).split("\\|")[1].split("-")[1];
                        cancionEscogida("Canción escogida: " + cancion + " de " + musico + "!", bt, opcion, tf);
//                        if (opcion.equals("1")) {
//                            cancionEscogida("Canción escogida: Despacito de Luis Fonsi!", bt, opcion, tf);
//                        } else if (opcion.equals("2")) {
//                            cancionEscogida("Canción escogida: Rayando El Sol de Maná!", bt, opcion, tf);
//                        } else if (opcion.equals("3")) {
//                            cancionEscogida("Canción escogida: La Camisa Negra de Juanes!", bt, opcion, tf);
//                        } else if (opcion.equals("4")) {
//                            cancionEscogida("Canción escogida: Mariposa Traicionera de Maná!", bt, opcion, tf);
//                        } else {
//                            mensaje("Ingreso incorrecto!", false);
//                            reescribirCancion(tf, bt);
//                        }
                    }
                });
            }
        });
    }

    private void cancionEscogida(String cancion, Button bt, String op, TextField tf) {
        mensaje(cancion + "\n"
                + "Ingresa las palabras clave separadas por coma:", false);
        bt.setOnAction((ActionEvent t) -> {
            mostrarLetra(tf.getText(), op);
            tf.clear();
            agrado();
            bt.setOnAction((ActionEvent t2) -> {
                if (tf.getText().strip().equals("1")) {
                    mensaje("Excelente!\n"
                            + "Aquí tienes el archivo:\n"
                            + "Song.txt", false);
                    mensaje(menu, false);
                    tf.clear();
                    bt.setOnAction((ActionEvent t3) -> {
                        menu(tf, bt);
                    });
                } else if (tf.getText().strip().equals("2")) {
                    mensaje(cancion + "\n"
                            + "Ingresa las palabras clave separadas por coma:", false);
                    tf.clear();
                }
            });
        });
    }

    private void mostrarLetra(String texto, String op) {
        mensaje(texto, true);
        String[] palabras = texto.split(",");
        String lista = ManejoArchivos.LeeFichero("Canciones.txt").get(Integer.valueOf(op) - 1).split("\\|")[2];
        String l = "";
        for (String s : cambiarLetra(lista, palabras)) {
            if (!s.equals("\\n")) {
                l += s + " ";
            } else if (s.equals("\\n")) {
                l += ";";
            }
        }
        for (String s : l.split(";")) {
            mensaje(s, false);
        }
    }

    private String[] cambiarLetra(String letra, String[] plb) {
        String[] cancion = letra.replaceAll("\n", "\n").replaceAll("\\n", "\\n").split(" ");
        for (int i = 0; i < cancion.length; i++) {
            if (cancion[i].contains("[REEMPLAZAR]\n") || cancion[i].contains("[REEMPLAZAR]\\n")) {
                cancion[i] = plb[(int) (Math.random() * plb.length)] + "\n";
            } else if (cancion[i].contains("[REEMPLAZAR]")) {
                cancion[i] = plb[(int) (Math.random() * plb.length)];
            }
        }
        return cancion;
    }

    private void menu(TextField tf, Button bt) {
        mensaje(tf.getText(), true);
        if (tf.getText().equals("1")) {
            generarContra(tf, bt);
        } else if (tf.getText().equals("2")) {
            reescribirCancion(tf, bt);
        } else if (tf.getText().equals("3")) {
            mensaje("Fue un gusto servirte!\n"
                    + "Vuelve Pronto!", false);
            tf.clear();
        } else {
            mensaje(menu, false);
        }
    }
}
