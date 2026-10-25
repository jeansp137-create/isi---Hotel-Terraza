# Hotel Terraza – Sistema de Gestión Hotelera (Fase de Inicio)

Proyecto de **Ingeniería de Software I** – Universidad de los Llanos (Villavicencio, 2026). Análisis y diseño orientado a objetos según Stephen Schach.

**Docente:** Ing. Olga Lucero Vega Márquez
**Estudiantes:** Youbry Camilo Mendoza Martínez, Diego Mauricio Lancheros Molina, Juan Sebastián Correa Aguilera y Julián David Fernández Ruiz.

## 1. Descripción del sistema

**Hotel Terraza** es un establecimiento de hospedaje con **40 habitaciones**, distribuidas en cuatro pisos (del 2 al 5) con 10 habitaciones por piso:

| Piso | Habitaciones |
|---|---|
| 2 | 201–205 y 201A–205A |
| 3 | 301–305 y 301A–305A |
| 4 | 401–405 y 401A–405A |
| 5 | 501–505 y 501A–505A |

Cada habitación está siempre en uno de tres estados: **Libre**, **Ocupada** o **En mantenimiento**.

Hoy toda la operación (reservas, ingresos, asignación de cuartos, consumos de tienda/minibar y liquidación) se lleva en **libros físicos y registros en papel**, lo que genera ineficiencias, riesgo de pérdida de información y largos tiempos de espera.

**Objetivo:** un sistema **local, liviano y centralizado**, operado **exclusivamente desde la terminal de Recepción**, que digitalice la operación diaria, controle en tiempo real las 40 habitaciones, calcule tarifas según ocupación y medio de pago, y centralice la liquidación final, las devoluciones y las métricas de recaudo.

- **Usuario operativo exclusivo:** el Recepcionista.
- **Actores de negocio:** Cliente (huésped) y plataforma Booking.
- **Actores externos:** servicio de Taxis y Proveedores de insumos.

## 2. Prototipo (maqueta)

El prototipo de [`docs/Prototipo/`](docs/Prototipo/) es **solo una maqueta** para que la propietaria vea cómo se verá el sistema. **No es el sistema final** y contiene únicamente **4 requerimientos**:

| # | Módulo del prototipo | Qué hace |
|---|---|---|
| 1 | **Usuarios** | Registra huéspedes (documento, nombre, apellido, teléfono, correo) |
| 2 | **Check-in** | Registra la llegada de un huésped (documento, habitación, fecha, noches) |
| 3 | **Check-out** | Registra la salida de un huésped (documento, habitación, fecha, observaciones) |
| 4 | **Alimentos** | Registra platillos/productos (nombre, tipo, precio, descripción) |

Cada módulo tiene su **historial con búsqueda**. Los datos se guardan en archivos `.txt` dentro de una carpeta `data/` que se crea sola al ejecutar. Tecnología: **Java 17** (servidor web integrado, sin librerías externas); se usa desde el navegador.

> El prototipo **no** valida disponibilidad, no calcula tarifas y no muestra el panel de las 40 habitaciones. Eso corresponde al sistema completo (ver [`docs/Modelos`](docs/Modelos/)).

## 3. Requisitos previos

- Windows 10 u 11.
- **JDK 17** instalado (se probó con Eclipse Adoptium `jdk-17.0.20.101-hotspot`).
- Navegador web.
- Los scripts asumen el JDK en `C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot`. Si lo tiene en otra ruta o versión, edite la línea `set "JAVA_HOME=..."` al inicio de `compilar.bat` y `ejecutar.bat`.

## 4. Compilar y ejecutar el prototipo

1. **Obtener el proyecto:** clone el repositorio o descargue el `.zip` y descomprímalo.
2. **Ir a la carpeta del prototipo:** abra `docs/Prototipo/` en el Explorador de archivos.
3. **Compilar:** haga doble clic en **`compilar.bat`** (o desde una terminal: `cd docs\Prototipo` y luego `compilar.bat`). Espere el mensaje *"Compilacion lista"*. Se creará la carpeta `bin/`.
4. **Ejecutar:** haga doble clic en **`ejecutar.bat`** (o `ejecutar.bat` desde la terminal). Se inicia el servidor y se muestra que está escuchando en el puerto 8080.
5. **Abrir el prototipo:** en el navegador entre a **http://localhost:8080**.
6. **Probar:** abra el menú (☰) y registre un usuario, luego un check-in y un check-out con el mismo documento. Use los botones *Ver historial* para consultar los registros.
7. **Detener:** en la ventana del servidor presione `Ctrl + C`.

> Nota: para registrar un check-in o check-out, el documento debe haberse registrado antes en **Usuarios**.

### Solución de problemas

| Problema | Posible causa | Solución |
|---|---|---|
| `compilar.bat` muestra *ERROR: No se pudo compilar* | JDK no instalado o ruta distinta | Instalar JDK 17 y ajustar `JAVA_HOME` en los `.bat` |
| `ejecutar.bat` dice *Primero debes compilar* | Falta la carpeta `bin/` | Ejecutar antes `compilar.bat` |
| El navegador no abre la página | Servidor detenido o puerto 8080 ocupado | Verificar que `ejecutar.bat` siga abierto y que nada más use el puerto 8080 |

## 5. Estructura del repositorio

```
.
├── README.md
└── docs/
    ├── Contexto/
    │   ├── hipotesis_problema.md
    │   ├── actores.md
    │   └── riesgos_identificados.md
    ├── Modelos/
    │   ├── Negocio/          (modelo de negocio, casos de uso y PDF)
    │   └── Requerimientos/   (requerimientos funcionales y no funcionales)
    ├── Prototipo/            (maqueta: src/, compilar.bat, ejecutar.bat, informe)
    └── Entrevistas/
        └── entrevista1/
            ├── lista_preguntas.md
            └── acta_entrevista.md
```

## 6. Documentación de la Fase de Inicio

| Documento | Ubicación |
|---|---|
| Hipótesis del problema | [docs/Contexto/hipotesis_problema.md](docs/Contexto/hipotesis_problema.md) |
| Actores | [docs/Contexto/actores.md](docs/Contexto/actores.md) |
| Riesgos identificados | [docs/Contexto/riesgos_identificados.md](docs/Contexto/riesgos_identificados.md) |
| Modelo de negocio (resumen) | [docs/Modelos/Negocio/README.md](docs/Modelos/Negocio/README.md) |
| Modelo de requerimientos (resumen) | [docs/Modelos/Requerimientos/README.md](docs/Modelos/Requerimientos/README.md) |
| **Informe completo (PDF): negocio, casos de uso y requerimientos** | [docs/Modelos/Negocio/modelo_negocio_y_requerimientos.pdf](docs/Modelos/Negocio/modelo_negocio_y_requerimientos.pdf) |
| Prototipo | [docs/Prototipo/README.md](docs/Prototipo/README.md) |
| Informe del prototipo (PDF) | [docs/Prototipo/informe_prototipo.pdf](docs/Prototipo/informe_prototipo.pdf) |
| Lista de preguntas – Entrevista 1 | [docs/Entrevistas/entrevista1/lista_preguntas.md](docs/Entrevistas/entrevista1/lista_preguntas.md) |
| Acta – Entrevista 1 | [docs/Entrevistas/entrevista1/acta_entrevista.md](docs/Entrevistas/entrevista1/acta_entrevista.md) |

