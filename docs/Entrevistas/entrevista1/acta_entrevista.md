# Acta de Reunión – Entrevista 1

| Campo | Detalle |
|---|---|
| **Proyecto** | Sistema de Gestión Hotelera – Hotel Terraza |
| **Asignatura** | Ingeniería de Software I – Universidad de los Llanos |
| **Fase** | Inicio |
| **Tipo de reunión** | Primera entrevista con el cliente |
| **Fecha** | 25 de octubre de 2026 |
| **Hora de inicio** | 10:00 a. m. |
| **Hora de cierre** | [por completar] |
| **Lugar** | Hotel Terraza – Recepción |
| **Modalidad** | Presencial |
| **Resultado** | Reunión exitosa – objetivos cumplidos |

## 1. Participantes

| Nombre | Rol | Organización |
|---|---|---|
| Amparo Morales | Propietaria del hotel (cliente / stakeholder principal) | Hotel Terraza |
| Julián David Fernández Ruiz | Estudiante de Ingeniería de Software, desarrollador del sistema y Recepcionista en turno | Equipo de desarrollo / Hotel Terraza |

> Julián atendió la recepción durante su turno y aprovechó para presentar el prototipo a la propietaria.

## 2. Objetivos de la reunión
1. Presentar el **modelo de dominio y de negocio** del hotel (actores, casos de uso y requerimientos).
2. **Validar el prototipo** con la propietaria.
3. Seleccionar el **requerimiento funcional prioritario**.
4. Acordar los **compromisos de entrega**.

## 3. Documentos y material usados
- Informe de [modelo de negocio y requerimientos](../../Modelos/Negocio/modelo_negocio_y_requerimientos.pdf).
- [Prototipo](../../Prototipo/) ejecutado con `compilar.bat` y `ejecutar.bat` (navegador en `http://localhost:8080`).
- [Lista de preguntas](lista_preguntas.md) de la entrevista.

> **Aclaración:** el prototipo es una **maqueta** para que la propietaria vea más o menos cómo quedará el software. No es el sistema completo y solo implementa **4 requerimientos**.

## 4. Desarrollo de la reunión

### 4.1 Presentación del modelo de dominio y de negocio
Se presentó lo recopilado sobre el hotel:

- **Habitaciones:** 40, en los pisos 2 a 5 (201–205 y 201A–205A, y así en cada piso), con estados **Libre**, **Ocupada** y **En mantenimiento**.
- **Actores (Schach):** Recepcionista (usuario operativo exclusivo); Cliente y Booking como actores de negocio; Taxis y Proveedores como actores externos.
- **Reglas de negocio ya levantadas:** reservas sin pago obligatorio y abonos voluntarios, No-Show sin penalidad, devolución total por cancelación previa con abono, reliquidación por salida anticipada, niños de 3 años o menos sin cobro de hospedaje, desayuno de visitantes a \$12.000, recargo de \$5.000 por persona/noche con tarjeta, y recargo de \$10.000 por hora tras la 1:00 p. m.
- **Tarifario y catálogo** de bar, aseo y lavandería.

**Resultado:** el modelo de negocio fue **revisado con la propietaria**, quien lo confirmó como reflejo de la operación del hotel.

### 4.2 Validación del prototipo
Se recorrieron los **4 módulos de la maqueta**:

| Módulo | Qué se mostró |
|---|---|
| **Usuarios** | Registro de huésped (documento, nombre, apellido, teléfono, correo) y su historial con búsqueda |
| **Check-in** | Registro de llegada (documento, habitación, fecha, noches); solo permite documentos ya registrados |
| **Check-out** | Registro de salida (documento, habitación, fecha, observaciones) |
| **Alimentos** | Registro de productos/platillos (nombre, tipo, precio, descripción) |

Se explicó que la maqueta **no incluye** aún: reservas y abonos, panel visual de las 40 habitaciones, cálculo de tarifas y recargos, reliquidación, devoluciones ni reportes.

**Resultado:** la propietaria **validó** el prototipo como una buena representación de la apariencia y del flujo general (menú lateral, formularios simples e historiales con búsqueda).

### 4.3 Selección del requerimiento funcional prioritario

| Requerimiento | Valor para el negocio | Decisión |
|---|---|---|
| **Check-in / Reservas** (CdR-04, apoyado en CdR-01 y CdR-02) | Muy alto: controla la ocupación y reemplaza el libro físico | **Seleccionado como prioritario** |
| Check-out y liquidación (CdR-07) | Alto | Siguiente iteración |
| Gestión de habitaciones (CdR-03) | Alto | Siguiente iteración |
| Consumos de tienda/minibar (CdR-05) y abonos (CdR-06) | Medio | Posterior |
| Reportes y métricas (CdR-08) | Medio | Posterior |

**Decisión:** el requerimiento funcional prioritario es **Check-in / Reservas**. El **Check-in** ya existe en la maqueta; las **Reservas** aún no están en el prototipo y se incorporarán en la siguiente etapa.

### 4.4 Riesgos tratados
- **Pérdida de datos:** al ser un sistema local, se hablará de un plan de respaldos ([riesgos_identificados.md](../../Contexto/riesgos_identificados.md)).
- **Curva de aprendizaje del personal:** se ve manejable por la simplicidad de las pantallas; se plantea una capacitación corta y un periodo de uso paralelo con el libro físico.

## 5. Acuerdos y compromisos

| # | Acuerdo | Responsable | Fecha |
|---|---|---|---|
| 1 | Tomar **Check-in / Reservas** como requerimiento prioritario del desarrollo | Equipo de desarrollo | Inmediata |
| 2 | Incorporar las **Reservas** (con abonos voluntarios y No-Show) al prototipo / sistema | Equipo de desarrollo | [por definir] |
| 3 | Entregar el repositorio con documentación, informe en PDF y prototipo ejecutable | Julián Fernández | [por definir] |
| 4 | Confirmar tarifas y catálogo vigentes del hotel | Amparo Morales | [por definir] |
| 5 | Designar a la persona responsable de las copias de seguridad | Amparo Morales | [por definir] |
| 6 | Programar la siguiente reunión para validar los requerimientos y el avance | Ambas partes | [por definir] |

## 6. Alcance acordado para la siguiente entrega
- **Incluye:** reservas, check-in, registro de clientes y consulta de estado de las 40 habitaciones.
- **No incluye (por ahora):** integración automática con Booking, facturación electrónica (la maneja un software fiscal independiente) y reportes avanzados.

## 7. Cierre
Se dio por concluida la reunión con la conformidad de la propietaria sobre el modelo, el prototipo y el requerimiento prioritario.

## 8. Firmas

| Nombre | Rol | Firma |
|---|---|---|
| Amparo Morales | Propietaria del hotel | ______________ |
| Julián David Fernández Ruiz | Estudiante / Recepcionista | ______________ |
