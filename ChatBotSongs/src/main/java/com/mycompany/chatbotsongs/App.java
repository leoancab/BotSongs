package com.mycompany.chatbotsongs;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static String pathImg = "Imagenes/";
    public static String pathFiles = "Archivos/";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PantallaPrincipal"));
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static ImageView foto(String imagen, int x, int y) {
        ImageView vistaImagen = null;
        try ( FileInputStream fis = new FileInputStream(imagen)) {
            Image foto = new Image(fis, x, y, false, false);
            vistaImagen = new ImageView(foto);
        } catch (IOException e) {
            System.out.println("No se encuentra la imagen");
        }
        return vistaImagen;
    }
    
    

}