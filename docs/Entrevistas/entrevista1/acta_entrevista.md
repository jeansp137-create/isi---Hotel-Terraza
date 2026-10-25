# Acta de Reunión – Entrevista 1

| Campo | Detalle |
|---|---|
| **Proyecto** | Sistema de gestión Hotel Terraza |
| **Fase** | Inicio |
| **Tipo de reunión** | Primera entrevista con el cliente |
| **Fecha** | [DD/MM/AAAA] *(completar)* |
| **Hora** | [HH:MM – HH:MM] *(completar)* |
| **Lugar** | Hotel Terraza – Recepción |
| **Modalidad** | Presencial |
| **Resultado** | Reunión exitosa – objetivos cumplidos |

> **Nota**: esta acta es una **simulación** elaborada para la documentación académica de la Fase de Inicio. Los nombres y datos deben ajustarse a los de la reunión real.

## 1. Participantes

| Nombre | Rol | Organización |
|---|---|---|
| [Nombre] | Administrador / Representante del hotel | Hotel Terraza |
| [Nombre] | Recepcionista (usuario operativo) | Hotel Terraza |
| [Nombre] | Ingeniero de software – entrevistador | Equipo de desarrollo |
| [Nombre] | Ingeniero de software – secretario/relator | Equipo de desarrollo |

## 2. Objetivos de la reunión
1. Presentar el **modelo de dominio** elaborado a partir de la hipótesis del problema.
2. **Validar el prototipo** con el cliente.
3. Seleccionar el **requerimiento funcional prioritario**.
4. Acordar los **compromisos de entrega**.

## 3. Agenda y desarrollo

| # | Tema | Duración |
|---|---|---|
| 1 | Presentación y objetivos | 10 min |
| 2 | Presentación del modelo de dominio | 20 min |
| 3 | Validación del prototipo | 30 min |
| 4 | Selección del requerimiento prioritario | 15 min |
| 5 | Acuerdos y cierre | 15 min |

### 3.1 Presentación del modelo de dominio
Se presentó el modelo con las entidades y relaciones principales:

- **Habitación** (40 unidades): número, tipo, tarifa, estado.
- **Reserva**: fechas de entrada y salida, canal de origen (directo o Booking), estado.
- **Cliente / Huésped**: datos de identificación y contacto.
- **Estadía (Check-in/Check-out)**: ocupación efectiva de una habitación.
- **Recepcionista**: usuario que registra las operaciones.
- **Servicios externos**: Taxis y Proveedores.

**Observaciones del cliente**
- Confirmó que el modelo refleja la operación real del hotel.
- Indicó que las reservas de Booking se ingresan **manualmente** y deben distinguirse por su canal de origen.
- Solicitó que la habitación tenga un estado de **limpieza**, aunque no sea prioritario en la primera entrega.

**Resultado**: modelo de dominio **aprobado** con ajustes menores.

### 3.2 Validación del prototipo
Se mostró el prototipo ejecutable (mediante `compilar.bat` y `ejecutar.bat`) con el flujo de consulta de disponibilidad, registro de reserva y check-in.

**Comentarios del Recepcionista**
- La pantalla con el estado de las 40 habitaciones es clara y ágil.
- El flujo de check-in es similar al proceso actual, lo que facilita su adopción.
- Pidió resaltar con colores los estados de las habitaciones y confirmar antes de guardar datos.

**Resultado**: prototipo **validado** por el cliente, con mejoras de usabilidad registradas.

### 3.3 Selección del requerimiento funcional prioritario
Se analizaron los requerimientos candidatos:

| Requerimiento | Valor para el negocio | Decisión |
|---|---|---|
| **Check-in / Reservas** | Muy alto: evita dobles reservas y agiliza la recepción | **Seleccionado como prioritario** |
| Check-out | Alto | Siguiente iteración |
| Registro de clientes | Medio | Incluido dentro de Check-in/Reservas |
| Registro de taxis y proveedores | Bajo | Posterior |
| Reportes de ocupación | Medio | Posterior |

**Decisión**: el cliente seleccionó **Check-in / Reservas** como requerimiento funcional prioritario de la primera entrega.

### 3.4 Riesgos tratados
- **Pérdida de datos**: se acordó implementar y documentar un plan de backups; la administración designará a un responsable.
- **Curva de aprendizaje**: el cliente aceptó capacitación corta y un periodo de operación paralela con papel.

## 4. Acuerdos y compromisos

| # | Acuerdo | Responsable | Fecha límite |
|---|---|---|---|
| 1 | Entregar los modelos de negocio y de requerimientos de Check-in / Reservas | Equipo de desarrollo | [fecha] |
| 2 | Incorporar los ajustes de usabilidad del prototipo (colores de estado, confirmación) | Equipo de desarrollo | [fecha] |
| 3 | Entregar el prototipo actualizado con `compilar.bat` y `ejecutar.bat` e instrucciones en el README | Equipo de desarrollo | [fecha] |
| 4 | Proporcionar la lista de tipos de habitación y tarifas | Administración del hotel | [fecha] |
| 5 | Proporcionar un ejemplo de reserva de Booking y del registro actual en papel | Recepcionista | [fecha] |
| 6 | Designar al responsable de backups | Administración del hotel | [fecha] |
| 7 | Programar una segunda reunión para validar el modelo de requerimientos | Ambas partes | [fecha] |

## 5. Alcance acordado para la primera entrega
- **Incluye**: gestión de reservas, check-in, consulta de disponibilidad de las 40 habitaciones y registro de datos del huésped.
- **No incluye**: facturación, integración automática con Booking, gestión de taxis y proveedores, reportes avanzados.

## 6. Cierre
Se dio por concluida la reunión con la conformidad de ambas partes sobre el modelo de dominio, el prototipo y el requerimiento prioritario. Se acordó enviar esta acta por correo para su confirmación en un plazo de 48 horas.

## 7. Firmas

| Nombre | Rol | Firma |
|---|---|---|
| [Nombre] | Representante del hotel | ______________ |
| [Nombre] | Recepcionista | ______________ |
| [Nombre] | Ingeniero de software | ______________ |
| [Nombre] | Ingeniero de software | ______________ |

