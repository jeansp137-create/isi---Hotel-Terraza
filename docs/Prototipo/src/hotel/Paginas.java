package hotel;

import java.util.List;

/**
 * Genera el HTML de todas las pantallas del hotel.
 */
public class Paginas {

    public static String plantilla(String titulo, String contenido) {
        return "<!DOCTYPE html>\n"
            + "<html lang=\"es\">\n"
            + "<head>\n"
            + "  <meta charset=\"UTF-8\">\n"
            + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
            + "  <title>" + titulo + " | Hotel Terraza</title>\n"
            + "  <style>\n"
            + estilos()
            + "  </style>\n"
            + "</head>\n"
            + "<body>\n"
            + "  <header class=\"top\">\n"
            + "    <button class=\"btn-menu-lat\" type=\"button\" onclick=\"abrirMenu()\" aria-label=\"Abrir menu\">&#9776;</button>\n"
            + "    <div class=\"brand\">Hotel Terraza</div>\n"
            + "  </header>\n"
            + "  <div id=\"fondo-menu\" class=\"fondo-menu\" onclick=\"cerrarMenu()\"></div>\n"
            + "  <aside id=\"menu-lat\" class=\"menu-lat\">\n"
            + "    <div class=\"menu-cab\">\n"
            + "      <strong>Menu</strong>\n"
            + "      <button type=\"button\" class=\"btn-cerrar\" onclick=\"cerrarMenu()\">&times;</button>\n"
            + "    </div>\n"
            + "    <a href=\"/\" onclick=\"cerrarMenu()\">Inicio</a>\n"
            + "    <a href=\"/usuarios\" onclick=\"cerrarMenu()\">Usuarios</a>\n"
            + "    <a href=\"/checkin\" onclick=\"cerrarMenu()\">Check-in</a>\n"
            + "    <a href=\"/checkout\" onclick=\"cerrarMenu()\">Check-out</a>\n"
            + "    <a href=\"/alimentos\" onclick=\"cerrarMenu()\">Alimentos</a>\n"
            + "  </aside>\n"
            + "  <main class=\"contenido\">\n"
            + contenido
            + "  </main>\n"
            + "  <footer>Hotel Terraza - Sistema de hotel</footer>\n"
            + "  <script>\n"
            + "    function abrirMenu() {\n"
            + "      document.getElementById('fondo-menu').classList.add('visible');\n"
            + "      document.getElementById('menu-lat').classList.add('abierto');\n"
            + "    }\n"
            + "    function cerrarMenu() {\n"
            + "      document.getElementById('fondo-menu').classList.remove('visible');\n"
            + "      document.getElementById('menu-lat').classList.remove('abierto');\n"
            + "    }\n"
            + "  </script>\n"
            + "</body>\n"
            + "</html>";
    }

    private static String estilos() {
        return "    * { box-sizing: border-box; margin: 0; padding: 0; }\n"
            + "    body { font-family: Georgia, 'Times New Roman', serif; background: #f3efe6; color: #1f2a24; min-height: 100vh; }\n"
            + "    .top { background: linear-gradient(120deg, #1f4d3a, #2f6b4f); color: #fff; padding: 14px 20px; display: flex; align-items: center; gap: 14px; }\n"
            + "    .brand { font-size: 1.5rem; letter-spacing: 1px; font-weight: bold; }\n"
            + "    .btn-menu-lat { background: transparent; color: #fff; border: 1px solid #d7eadf; width: 42px; height: 42px; border-radius: 8px; font-size: 1.3rem; cursor: pointer; line-height: 1; margin-top: 0; }\n"
            + "    .btn-menu-lat:hover { background: rgba(255,255,255,0.12); }\n"
            + "    .fondo-menu { display: none; position: fixed; inset: 0; background: rgba(0,0,0,0.4); z-index: 20; }\n"
            + "    .fondo-menu.visible { display: block; }\n"
            + "    .menu-lat { position: fixed; top: 0; left: 0; width: 260px; height: 100%; background: #163828; color: #fff; z-index: 30; transform: translateX(-100%); transition: transform 0.2s ease; padding: 18px 0; }\n"
            + "    .menu-lat.abierto { transform: translateX(0); }\n"
            + "    .menu-cab { display: flex; justify-content: space-between; align-items: center; padding: 0 18px 16px; border-bottom: 1px solid #2f6b4f; margin-bottom: 10px; }\n"
            + "    .btn-cerrar { background: transparent; color: #fff; border: none; font-size: 1.6rem; cursor: pointer; margin-top: 0; line-height: 1; padding: 0 6px; }\n"
            + "    .menu-lat a { display: block; color: #e8f5ee; text-decoration: none; padding: 12px 22px; }\n"
            + "    .menu-lat a:hover { background: #1f4d3a; }\n"
            + "    .contenido { max-width: 900px; margin: 28px auto; padding: 0 18px 40px; }\n"
            + "    h1 { font-size: 1.8rem; margin-bottom: 8px; color: #1f4d3a; }\n"
            + "    h2 { font-size: 1.2rem; margin: 8px 0 14px; color: #1f4d3a; }\n"
            + "    p.desc { margin-bottom: 22px; color: #4a554f; }\n"
            + "    .grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(180px, 1fr)); gap: 14px; margin-top: 20px; }\n"
            + "    .btn-menu { display: block; background: #fff; border: 2px solid #1f4d3a; color: #1f4d3a; text-decoration: none; padding: 22px 14px; text-align: center; border-radius: 8px; font-weight: bold; }\n"
            + "    .btn-menu:hover { background: #1f4d3a; color: #fff; }\n"
            + "    form { background: #fff; padding: 22px; border-radius: 8px; border: 1px solid #d7d0c2; margin-bottom: 18px; }\n"
            + "    .busqueda { display: flex; gap: 10px; align-items: flex-end; flex-wrap: wrap; }\n"
            + "    .busqueda label { flex: 1; min-width: 200px; margin-top: 0; }\n"
            + "    .acciones { display: flex; gap: 10px; flex-wrap: wrap; margin-top: 8px; }\n"
            + "    label { display: block; margin: 12px 0 4px; font-size: 0.92rem; }\n"
            + "    input, select, textarea { width: 100%; padding: 10px; border: 1px solid #b9b2a4; border-radius: 6px; font-size: 1rem; font-family: inherit; }\n"
            + "    button { margin-top: 16px; background: #1f4d3a; color: #fff; border: none; padding: 12px 22px; border-radius: 6px; cursor: pointer; font-size: 1rem; }\n"
            + "    button:hover { background: #163828; }\n"
            + "    .btn-sec { display: inline-block; background: #fff; color: #1f4d3a; border: 2px solid #1f4d3a; padding: 10px 18px; border-radius: 6px; text-decoration: none; font-weight: bold; margin-top: 8px; }\n"
            + "    .btn-sec:hover { background: #e8f5ee; }\n"
            + "    .ok { background: #e7f6ec; border: 1px solid #8ec9a3; color: #1f4d3a; padding: 12px; border-radius: 6px; margin-bottom: 16px; }\n"
            + "    .error { background: #fdecea; border: 1px solid #e3a29a; color: #7a2e24; padding: 12px; border-radius: 6px; margin-bottom: 16px; }\n"
            + "    table { width: 100%; border-collapse: collapse; background: #fff; border-radius: 8px; overflow: hidden; }\n"
            + "    th, td { border-bottom: 1px solid #e4ddd0; padding: 10px 12px; text-align: left; font-size: 0.92rem; }\n"
            + "    th { background: #1f4d3a; color: #fff; }\n"
            + "    tr:nth-child(even) { background: #faf7f0; }\n"
            + "    footer { text-align: center; padding: 18px; color: #6b726c; font-size: 0.85rem; }\n"
            + "    .vacio { color: #6b726c; font-style: italic; }\n";
    }

    public static String inicio() {
        String cuerpo =
            "<h1>Bienvenido a Hotel Terraza</h1>"
            + "<p class=\"desc\">Sistema sencillo para gestionar usuarios, check-in, check-out y alimentos.</p>"
            + "<div class=\"grid\">"
            + "  <a class=\"btn-menu\" href=\"/usuarios\">Registrar usuarios</a>"
            + "  <a class=\"btn-menu\" href=\"/checkin\">Registrar check-in</a>"
            + "  <a class=\"btn-menu\" href=\"/checkout\">Registrar check-out</a>"
            + "  <a class=\"btn-menu\" href=\"/alimentos\">Registrar alimentos</a>"
            + "</div>";
        return plantilla("Inicio", cuerpo);
    }

    public static String usuarios(String mensaje, boolean error) {
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append("<h1>Registro de usuarios</h1>");
        cuerpo.append("<p class=\"desc\">Crea una cuenta de huesped del hotel.</p>");
        if (mensaje != null) {
            cuerpo.append("<div class=\"").append(error ? "error" : "ok").append("\">").append(mensaje).append("</div>");
        }
        cuerpo.append("<form method=\"POST\" action=\"/usuarios\">");
        cuerpo.append("<label>Documento</label><input name=\"documento\" required>");
        cuerpo.append("<label>Nombre</label><input name=\"nombre\" required>");
        cuerpo.append("<label>Apellido</label><input name=\"apellido\" required>");
        cuerpo.append("<label>Telefono</label><input name=\"telefono\" required>");
        cuerpo.append("<label>Correo</label><input type=\"email\" name=\"correo\" required>");
        cuerpo.append("<button type=\"submit\">Guardar usuario</button>");
        cuerpo.append("</form>");
        cuerpo.append("<a class=\"btn-sec\" href=\"/usuarios/historial\">Ver historial de usuarios</a>");
        return plantilla("Usuarios", cuerpo.toString());
    }

    public static String checkin(String mensaje, boolean error) {
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append("<h1>Registro de check-in</h1>");
        cuerpo.append("<p class=\"desc\">Registra la llegada de un huesped a su habitacion.</p>");
        if (mensaje != null) {
            cuerpo.append("<div class=\"").append(error ? "error" : "ok").append("\">").append(mensaje).append("</div>");
        }
        cuerpo.append("<form method=\"POST\" action=\"/checkin\">");
        cuerpo.append("<label>Documento del huesped</label><input name=\"documento\" required>");
        cuerpo.append("<label>Numero de habitacion</label><input name=\"habitacion\" required>");
        cuerpo.append("<label>Fecha de llegada</label><input type=\"date\" name=\"fecha\" required>");
        cuerpo.append("<label>Noches</label><input type=\"number\" name=\"noches\" min=\"1\" value=\"1\" required>");
        cuerpo.append("<button type=\"submit\">Registrar check-in</button>");
        cuerpo.append("</form>");
        cuerpo.append("<a class=\"btn-sec\" href=\"/checkin/historial\">Ver historial de check-in</a>");
        return plantilla("Check-in", cuerpo.toString());
    }

    public static String checkout(String mensaje, boolean error) {
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append("<h1>Registro de check-out</h1>");
        cuerpo.append("<p class=\"desc\">Registra la salida de un huesped.</p>");
        if (mensaje != null) {
            cuerpo.append("<div class=\"").append(error ? "error" : "ok").append("\">").append(mensaje).append("</div>");
        }
        cuerpo.append("<form method=\"POST\" action=\"/checkout\">");
        cuerpo.append("<label>Documento del huesped</label><input name=\"documento\" required>");
        cuerpo.append("<label>Numero de habitacion</label><input name=\"habitacion\" required>");
        cuerpo.append("<label>Fecha de salida</label><input type=\"date\" name=\"fecha\" required>");
        cuerpo.append("<label>Observaciones</label><textarea name=\"observaciones\" rows=\"3\"></textarea>");
        cuerpo.append("<button type=\"submit\">Registrar check-out</button>");
        cuerpo.append("</form>");
        cuerpo.append("<a class=\"btn-sec\" href=\"/checkout/historial\">Ver historial de check-out</a>");
        return plantilla("Check-out", cuerpo.toString());
    }

    public static String alimentos(String mensaje, boolean error) {
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append("<h1>Registro de alimentos</h1>");
        cuerpo.append("<p class=\"desc\">Agrega platillos o productos del restaurante del hotel.</p>");
        if (mensaje != null) {
            cuerpo.append("<div class=\"").append(error ? "error" : "ok").append("\">").append(mensaje).append("</div>");
        }
        cuerpo.append("<form method=\"POST\" action=\"/alimentos\">");
        cuerpo.append("<label>Nombre del alimento</label><input name=\"nombre\" required>");
        cuerpo.append("<label>Tipo</label>");
        cuerpo.append("<select name=\"tipo\" required>");
        cuerpo.append("<option value=\"Desayuno\">Desayuno</option>");
        cuerpo.append("<option value=\"Almuerzo\">Almuerzo</option>");
        cuerpo.append("<option value=\"Cena\">Cena</option>");
        cuerpo.append("<option value=\"Bebida\">Bebida</option>");
        cuerpo.append("<option value=\"Snack\">Snack</option>");
        cuerpo.append("</select>");
        cuerpo.append("<label>Precio</label><input type=\"number\" name=\"precio\" min=\"0\" step=\"0.01\" required>");
        cuerpo.append("<label>Descripcion</label><textarea name=\"descripcion\" rows=\"3\"></textarea>");
        cuerpo.append("<button type=\"submit\">Guardar alimento</button>");
        cuerpo.append("</form>");
        cuerpo.append("<a class=\"btn-sec\" href=\"/alimentos/historial\">Ver historial de alimentos</a>");
        return plantilla("Alimentos", cuerpo.toString());
    }

    public static String historial(String titulo, String descripcion, String accion, String volver,
            String pistaBusqueda, String busqueda, String[] encabezados, List<String> registros) {
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append("<h1>").append(titulo).append("</h1>");
        cuerpo.append("<p class=\"desc\">").append(descripcion).append("</p>");
        cuerpo.append("<form class=\"busqueda\" method=\"GET\" action=\"").append(accion).append("\">");
        cuerpo.append("<label>Buscar<input name=\"q\" value=\"").append(escaparHtml(busqueda == null ? "" : busqueda)).append("\" placeholder=\"").append(pistaBusqueda).append("\"></label>");
        cuerpo.append("<button type=\"submit\">Buscar</button>");
        cuerpo.append("</form>");
        cuerpo.append("<div class=\"acciones\">");
        cuerpo.append("<a class=\"btn-sec\" href=\"").append(volver).append("\">Volver</a>");
        if (busqueda != null && !busqueda.trim().isEmpty()) {
            cuerpo.append("<a class=\"btn-sec\" href=\"").append(accion).append("\">Ver todos</a>");
        }
        cuerpo.append("</div>");
        cuerpo.append("<h2>Resultados</h2>");
        cuerpo.append(tabla(encabezados, registros));
        return plantilla(titulo, cuerpo.toString());
    }

    private static String tabla(String[] encabezados, List<String> registros) {
        if (registros == null || registros.isEmpty()) {
            return "<p class=\"vacio\">No hay registros para mostrar.</p>";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<table><thead><tr>");
        for (int i = 0; i < encabezados.length; i++) {
            sb.append("<th>").append(encabezados[i]).append("</th>");
        }
        sb.append("</tr></thead><tbody>");
        for (int i = 0; i < registros.size(); i++) {
            String[] campos = registros.get(i).split("\\|", -1);
            sb.append("<tr>");
            for (int j = 0; j < encabezados.length; j++) {
                String valor = j < campos.length ? campos[j] : "";
                sb.append("<td>").append(escaparHtml(valor)).append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</tbody></table>");
        return sb.toString();
    }

    private static String escaparHtml(String texto) {
        if (texto == null) {
            return "";
        }
        return texto
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;");
    }
}
