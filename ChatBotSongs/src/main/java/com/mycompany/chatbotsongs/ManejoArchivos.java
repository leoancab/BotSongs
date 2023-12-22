package com.mycompany.chatbotsongs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Este método se encarga de la lectura de los archivos csv utilizando el chrset
 * UTF_8.
 *
 */
public class ManejoArchivos {

    public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(App.pathFiles + nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error: Vuelva a intentarlo.");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Error: Vuelva a intentarlo.");
            }
        }
        return lineas;
    }

    /**
     * Este método se encarga de escribir en los archivos csv proporcionados.
     *
     * @param nombreArchivo
     * @param linea
     */
    public static void EscribirArchivo(String nombreArchivo, String linea) {
        FileWriter fichero = null;
        BufferedWriter bw = null;
        try {
            fichero = new FileWriter(nombreArchivo, true);
            bw = new BufferedWriter(fichero);
            bw.write(linea + "\n");
        } catch (IOException e) {
            System.out.println("Error: Vuelva a intentarlo.");
        } finally {
            try {
                if (null != fichero) {
                    bw.close();
                }
            } catch (IOException e2) {
                System.out.println("Error: Vuelva a intentarlo.");
            }
        }
    }
}
