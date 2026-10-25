# Prototipo (maqueta) – Hotel Terraza

Maqueta funcional para que la propietaria vea más o menos cómo será el sistema. **No es el sistema final**: solo incluye 4 requerimientos.

## Contenido

| Elemento | Descripción |
|---|---|
| `compilar.bat` | Compila `src/` hacia `bin/` con `javac` (JDK 17) |
| `ejecutar.bat` | Inicia el servidor en http://localhost:8080 |
| `src/hotel/HotelApp.java` | Servidor web y manejo de formularios |
| `src/hotel/Paginas.java` | HTML de las pantallas |
| `src/hotel/ArchivoUtil.java` | Lectura/escritura de archivos `.txt` en `data/` |
| `informe_prototipo.pdf` | Informe del prototipo (versión del modelo de negocio al 16/10/2026) |

La carpeta `data/` (registros en `.txt`) se **crea automáticamente** al ejecutar y no se versiona porque contiene datos personales de prueba.

## Requerimientos incluidos y su relación con el modelo

| Módulo del prototipo | Ruta | Campos | Caso de requerimiento relacionado |
|---|---|---|---|
| Usuarios | `/usuarios` | documento, nombre, apellido, teléfono, correo | CdR-02 Registrar Cliente (RF-07) |
| Check-in | `/checkin` | documento, habitación, fecha, noches | CdR-04 Realizar Check-in |
| Check-out | `/checkout` | documento, habitación, fecha, observaciones | CdR-07 Realizar Check-out |
| Alimentos | `/alimentos` | nombre, tipo, precio, descripción | CdR-05 Registrar Consumo (catálogo) |

Validaciones: campos obligatorios, documento de usuario no repetido, y check-in/check-out solo para documentos ya registrados.

## Fuera del alcance de la maqueta
Reservas y abonos, panel de las 40 habitaciones con sus estados, cálculo de tarifas y recargos (tarjeta, late check-out), reliquidación por salida anticipada, devoluciones y reportes financieros.

## Cómo ejecutarla
Ver las instrucciones paso a paso en el [README principal](../../README.md#4-compilar-y-ejecutar-el-prototipo).
