# Hotel Terraza – Sistema de Gestión Hotelera (Fase de Inicio)

## 1. Descripción del sistema

**Hotel Terraza** es un hotel de **40 habitaciones** que actualmente gestiona reservas, check-in/check-out y ocupación mediante libros físicos y registros en papel. Este proyecto propone un **sistema de escritorio local (monolítico)**, instalado en el equipo de recepción, que digitaliza esas operaciones y reduce errores, duplicidades y tiempos de atención.

Características de la solución:

- **Despliegue local**: una sola aplicación y una base de datos local, sin dependencia de servidores externos.
- **Usuario operativo exclusivo**: el **Recepcionista**.
- **Gestión de las 40 habitaciones**: estado (disponible, ocupada, reservada, en limpieza/mantenimiento), tipo y tarifa.
- **Requerimiento funcional prioritario**: **Check-in / Reservas** (acordado en la primera entrevista).
- **Integración de negocio**: contempla reservas provenientes de **Booking** y la coordinación con **Taxis** y **Proveedores** como actores externos.

> Estado: **Fase de Inicio** – existe un prototipo validado con el cliente; la funcionalidad completa se desarrollará en fases posteriores.

## 2. Estructura del repositorio

```
.
├── README.md
├── compilar.bat
├── ejecutar.bat
└── docs/
    ├── Contexto/
    │   ├── hipotesis_problema.md
    │   ├── actores.md
    │   └── riesgos_identificados.md
    ├── Modelos/
    │   ├── Negocio/
    │   └── Requerimientos/
    ├── Prototipo/
    └── Entrevistas/
        └── entrevista1/
            ├── lista_preguntas.md
            └── acta_entrevista.md
```

## 3. Requisitos previos

- Sistema operativo **Windows 10 u 11**.
- Kit de herramientas necesario para compilar el prototipo (el que invoque `compilar.bat`, p. ej. JDK o .NET SDK) instalado y disponible en el `PATH`.
- Permisos de lectura/escritura en la carpeta del proyecto.

## 4. Compilar y ejecutar el prototipo

### Paso 1. Obtener el proyecto
1. Clone o descargue el repositorio.
2. Si descargó un `.zip`, descomprímalo en una ruta **sin espacios ni caracteres especiales** (p. ej. `C:\HotelTerraza`).

### Paso 2. Compilar
1. Abra el **Explorador de archivos** y ubíquese en la raíz del proyecto (donde está `compilar.bat`).
2. Haga doble clic en **`compilar.bat`**, o desde una terminal:
   ```bat
   cd C:\HotelTerraza
   compilar.bat
   ```
3. Espere el mensaje de finalización. Si aparece algún error, revise que las herramientas de compilación estén instaladas y en el `PATH`.

### Paso 3. Ejecutar
1. Una vez compilado sin errores, haga doble clic en **`ejecutar.bat`**, o desde la terminal:
   ```bat
   ejecutar.bat
   ```
2. Se abrirá la aplicación del Hotel Terraza lista para el uso del Recepcionista.

### Paso 4. Verificación rápida
- Visualizar el listado de las 40 habitaciones y su estado.
- Registrar una reserva y realizar su check-in.

### Solución de problemas

| Problema | Posible causa | Solución |
|---|---|---|
| `compilar.bat` se cierra sin resultado | Herramientas no instaladas o fuera del `PATH` | Instalar el SDK y reabrir la terminal |
| `ejecutar.bat` indica que falta el ejecutable | No se compiló antes | Ejecutar primero `compilar.bat` |
| Error de acceso a archivos | Falta de permisos o ruta protegida | Mover el proyecto a una carpeta con permisos de escritura |

## 5. Documentación de la Fase de Inicio

| Documento | Ubicación |
|---|---|
| Hipótesis del problema | [docs/Contexto/hipotesis_problema.md](docs/Contexto/hipotesis_problema.md) |
| Actores | [docs/Contexto/actores.md](docs/Contexto/actores.md) |
| Riesgos identificados | [docs/Contexto/riesgos_identificados.md](docs/Contexto/riesgos_identificados.md) |
| Lista de preguntas – Entrevista 1 | [docs/Entrevistas/entrevista1/lista_preguntas.md](docs/Entrevistas/entrevista1/lista_preguntas.md) |
| Acta – Entrevista 1 | [docs/Entrevistas/entrevista1/acta_entrevista.md](docs/Entrevistas/entrevista1/acta_entrevista.md) |

