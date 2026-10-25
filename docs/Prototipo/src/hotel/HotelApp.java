package hotel;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Servidor web del Hotel Terraza.
 * Guarda los datos en archivos .txt dentro de la carpeta data/
 *
 * Para ejecutar (despues de compilar):
 *   java -cp bin hotel.HotelApp
 * Luego abre en el navegador: http://localhost:8080
 */
public class HotelApp {

    private static final int PUERTO = 8080;

    public static void main(String[] args) throws Exception {
        ArchivoUtil.prepararArchivos();

        HttpServer server = HttpServer.create(new InetSocketAddress(PUERTO), 0);
        server.createContext("/", new InicioHandler());
        server.createContext("/usuarios", new UsuariosHandler());
        server.createContext("/usuarios/historial", new HistorialUsuariosHandler());
        server.createContext("/checkin", new CheckinHandler());
        server.createContext("/checkin/historial", new HistorialCheckinHandler());
        server.createContext("/checkout", new CheckoutHandler());
        server.createContext("/checkout/historial", new HistorialCheckoutHandler());
        server.createContext("/alimentos", new AlimentosHandler());
        server.createContext("/alimentos/historial", new HistorialAlimentosHandler());
        server.setExecutor(null);

        System.out.println("========================================");
        System.out.println("  Hotel Terraza - servidor iniciado");
        System.out.println("  Abre: http://localhost:" + PUERTO);
        System.out.println("  Para detener: Ctrl + C");
        System.out.println("========================================");
        server.start();
    }

    // ---------- Handlers ----------

    static class InicioHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            responderHtml(ex, 200, Paginas.inicio());
        }
    }

    static class UsuariosHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String mensaje = null;
            boolean error = false;

            if ("POST".equalsIgnoreCase(ex.getRequestMethod())) {
                Map<String, String> form = leerFormulario(ex);
                String documento = ArchivoUtil.limpiar(form.get("documento"));
                String nombre = ArchivoUtil.limpiar(form.get("nombre"));
                String apellido = ArchivoUtil.limpiar(form.get("apellido"));
                String telefono = ArchivoUtil.limpiar(form.get("telefono"));
                String correo = ArchivoUtil.limpiar(form.get("correo"));

                if (documento.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                        || telefono.isEmpty() || correo.isEmpty()) {
                    mensaje = "Todos los campos son obligatorios.";
                    error = true;
                } else if (existeDocumento("usuarios.txt", documento)) {
                    mensaje = "Ya existe un usuario con ese documento.";
                    error = true;
                } else {
                    String linea = documento + "|" + nombre + "|" + apellido + "|" + telefono + "|" + correo;
                    ArchivoUtil.agregarLinea("usuarios.txt", linea);
                    mensaje = "Usuario registrado correctamente.";
                }
            }

            responderHtml(ex, 200, Paginas.usuarios(mensaje, error));
        }
    }

    static class CheckinHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String mensaje = null;
            boolean error = false;

            if ("POST".equalsIgnoreCase(ex.getRequestMethod())) {
                Map<String, String> form = leerFormulario(ex);
                String documento = ArchivoUtil.limpiar(form.get("documento"));
                String habitacion = ArchivoUtil.limpiar(form.get("habitacion"));
                String fecha = ArchivoUtil.limpiar(form.get("fecha"));
                String noches = ArchivoUtil.limpiar(form.get("noches"));

                if (documento.isEmpty() || habitacion.isEmpty() || fecha.isEmpty() || noches.isEmpty()) {
                    mensaje = "Todos los campos son obligatorios.";
                    error = true;
                } else if (!existeDocumento("usuarios.txt", documento)) {
                    mensaje = "El documento no esta registrado. Primero crea el usuario.";
                    error = true;
                } else {
                    String linea = documento + "|" + habitacion + "|" + fecha + "|" + noches;
                    ArchivoUtil.agregarLinea("checkins.txt", linea);
                    mensaje = "Check-in registrado correctamente.";
                }
            }

            responderHtml(ex, 200, Paginas.checkin(mensaje, error));
        }
    }

    static class CheckoutHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String mensaje = null;
            boolean error = false;

            if ("POST".equalsIgnoreCase(ex.getRequestMethod())) {
                Map<String, String> form = leerFormulario(ex);
                String documento = ArchivoUtil.limpiar(form.get("documento"));
                String habitacion = ArchivoUtil.limpiar(form.get("habitacion"));
                String fecha = ArchivoUtil.limpiar(form.get("fecha"));
                String observaciones = ArchivoUtil.limpiar(form.get("observaciones"));

                if (documento.isEmpty() || habitacion.isEmpty() || fecha.isEmpty()) {
                    mensaje = "Documento, habitacion y fecha son obligatorios.";
                    error = true;
                } else if (!existeDocumento("usuarios.txt", documento)) {
                    mensaje = "El documento no esta registrado. Primero crea el usuario.";
                    error = true;
                } else {
                    String linea = documento + "|" + habitacion + "|" + fecha + "|" + observaciones;
                    ArchivoUtil.agregarLinea("checkouts.txt", linea);
                    mensaje = "Check-out registrado correctamente.";
                }
            }

            responderHtml(ex, 200, Paginas.checkout(mensaje, error));
        }
    }

    static class AlimentosHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String mensaje = null;
            boolean error = false;

            if ("POST".equalsIgnoreCase(ex.getRequestMethod())) {
                Map<String, String> form = leerFormulario(ex);
                String nombre = ArchivoUtil.limpiar(form.get("nombre"));
                String tipo = ArchivoUtil.limpiar(form.get("tipo"));
                String precio = ArchivoUtil.limpiar(form.get("precio"));
                String descripcion = ArchivoUtil.limpiar(form.get("descripcion"));

                if (nombre.isEmpty() || tipo.isEmpty() || precio.isEmpty()) {
                    mensaje = "Nombre, tipo y precio son obligatorios.";
                    error = true;
                } else {
                    String linea = nombre + "|" + tipo + "|" + precio + "|" + descripcion;
                    ArchivoUtil.agregarLinea("alimentos.txt", linea);
                    mensaje = "Alimento registrado correctamente.";
                }
            }

            responderHtml(ex, 200, Paginas.alimentos(mensaje, error));
        }
    }

    static class HistorialUsuariosHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String q = parametroGet(ex, "q");
            List<String> registros = filtrar(ArchivoUtil.leerLineas("usuarios.txt"), q);
            responderHtml(ex, 200, Paginas.historial(
                    "Historial de usuarios",
                    "Busca por documento, nombre o apellido.",
                    "/usuarios/historial",
                    "/usuarios",
                    "Documento o nombre",
                    q,
                    new String[]{"Documento", "Nombre", "Apellido", "Telefono", "Correo"},
                    registros));
        }
    }

    static class HistorialCheckinHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String q = parametroGet(ex, "q");
            List<String> usuarios = ArchivoUtil.leerLineas("usuarios.txt");
            List<String> registros = filtrarConHuesped(ArchivoUtil.leerLineas("checkins.txt"), usuarios, q);
            responderHtml(ex, 200, Paginas.historial(
                    "Historial de check-in",
                    "Busca por documento, nombre del huesped o habitacion.",
                    "/checkin/historial",
                    "/checkin",
                    "Documento, nombre o habitacion",
                    q,
                    new String[]{"Documento", "Habitacion", "Fecha", "Noches"},
                    registros));
        }
    }

    static class HistorialCheckoutHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String q = parametroGet(ex, "q");
            List<String> usuarios = ArchivoUtil.leerLineas("usuarios.txt");
            List<String> registros = filtrarConHuesped(ArchivoUtil.leerLineas("checkouts.txt"), usuarios, q);
            responderHtml(ex, 200, Paginas.historial(
                    "Historial de check-out",
                    "Busca por documento, nombre del huesped o habitacion.",
                    "/checkout/historial",
                    "/checkout",
                    "Documento, nombre o habitacion",
                    q,
                    new String[]{"Documento", "Habitacion", "Fecha", "Observaciones"},
                    registros));
        }
    }

    static class HistorialAlimentosHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String q = parametroGet(ex, "q");
            List<String> registros = filtrar(ArchivoUtil.leerLineas("alimentos.txt"), q);
            responderHtml(ex, 200, Paginas.historial(
                    "Historial de alimentos",
                    "Busca por nombre, tipo o descripcion.",
                    "/alimentos/historial",
                    "/alimentos",
                    "Nombre o tipo",
                    q,
                    new String[]{"Nombre", "Tipo", "Precio", "Descripcion"},
                    registros));
        }
    }

    // ---------- Utilidades HTTP ----------

    private static boolean existeDocumento(String archivo, String documento) throws IOException {
        List<String> lineas = ArchivoUtil.leerLineas(archivo);
        for (int i = 0; i < lineas.size(); i++) {
            String[] partes = lineas.get(i).split("\\|", -1);
            if (partes.length > 0 && documento.equals(partes[0])) {
                return true;
            }
        }
        return false;
    }

    private static List<String> filtrar(List<String> registros, String busqueda) {
        if (busqueda == null || busqueda.trim().isEmpty()) {
            return registros;
        }
        String q = busqueda.trim().toLowerCase();
        List<String> resultado = new ArrayList<String>();
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).toLowerCase().contains(q)) {
                resultado.add(registros.get(i));
            }
        }
        return resultado;
    }

    private static List<String> filtrarConHuesped(List<String> registros, List<String> usuarios, String busqueda) {
        if (busqueda == null || busqueda.trim().isEmpty()) {
            return registros;
        }
        String q = busqueda.trim().toLowerCase();
        Set<String> documentos = new HashSet<String>();
        for (int i = 0; i < usuarios.size(); i++) {
            String linea = usuarios.get(i);
            if (linea.toLowerCase().contains(q)) {
                String[] partes = linea.split("\\|", -1);
                if (partes.length > 0) {
                    documentos.add(partes[0]);
                }
            }
        }
        List<String> resultado = new ArrayList<String>();
        for (int i = 0; i < registros.size(); i++) {
            String linea = registros.get(i);
            String[] partes = linea.split("\\|", -1);
            boolean porNombre = partes.length > 0 && documentos.contains(partes[0]);
            if (linea.toLowerCase().contains(q) || porNombre) {
                resultado.add(linea);
            }
        }
        return resultado;
    }

    private static String parametroGet(HttpExchange ex, String clave) throws UnsupportedEncodingException {
        String query = ex.getRequestURI().getRawQuery();
        Map<String, String> mapa = parsearQuery(query);
        String valor = mapa.get(clave);
        return valor == null ? "" : valor;
    }

    private static void responderHtml(HttpExchange ex, int codigo, String html) throws IOException {
        byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
        Headers headers = ex.getResponseHeaders();
        headers.set("Content-Type", "text/html; charset=UTF-8");
        ex.sendResponseHeaders(codigo, bytes.length);
        OutputStream os = ex.getResponseBody();
        os.write(bytes);
        os.close();
    }

    private static Map<String, String> leerFormulario(HttpExchange ex) throws IOException {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        byte[] tmp = new byte[1024];
        int n;
        while ((n = ex.getRequestBody().read(tmp)) != -1) {
            baos.write(tmp, 0, n);
        }
        String cuerpo = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        return parsearQuery(cuerpo);
    }

    private static Map<String, String> parsearQuery(String query) throws UnsupportedEncodingException {
        Map<String, String> mapa = new HashMap<String, String>();
        if (query == null || query.isEmpty()) {
            return mapa;
        }
        String[] pares = query.split("&");
        for (int i = 0; i < pares.length; i++) {
            String[] kv = pares[i].split("=", 2);
            String clave = URLDecoder.decode(kv[0], "UTF-8");
            String valor = kv.length > 1 ? URLDecoder.decode(kv[1], "UTF-8") : "";
            mapa.put(clave, valor);
        }
        return mapa;
    }
}
