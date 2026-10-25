package hotel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilidad sencilla para leer y escribir archivos de texto.
 * Cada linea es un registro. Los campos se separan con |
 */
public class ArchivoUtil {

    private static final String CARPETA_DATOS = "data";

    /** Crea la carpeta data y los archivos si no existen. */
    public static void prepararArchivos() throws IOException {
        File carpeta = new File(CARPETA_DATOS);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        crearSiNoExiste("usuarios.txt");
        crearSiNoExiste("checkins.txt");
        crearSiNoExiste("checkouts.txt");
        crearSiNoExiste("alimentos.txt");
    }

    private static void crearSiNoExiste(String nombre) throws IOException {
        File archivo = new File(CARPETA_DATOS, nombre);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
    }

    /** Agrega una linea al final del archivo. */
    public static synchronized void agregarLinea(String nombreArchivo, String linea) throws IOException {
        File archivo = new File(CARPETA_DATOS, nombreArchivo);
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(archivo, true), StandardCharsets.UTF_8))) {
            bw.write(linea);
            bw.newLine();
        }
    }

    /** Lee todas las lineas del archivo (ignora vacias). */
    public static synchronized List<String> leerLineas(String nombreArchivo) throws IOException {
        List<String> lineas = new ArrayList<String>();
        File archivo = new File(CARPETA_DATOS, nombreArchivo);
        if (!archivo.exists()) {
            return lineas;
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    lineas.add(linea);
                }
            }
        }
        return lineas;
    }

    /** Escapa el caracter | para que no rompa el formato. */
    public static String limpiar(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.trim().replace("|", "/").replace("\n", " ").replace("\r", "");
    }
}
