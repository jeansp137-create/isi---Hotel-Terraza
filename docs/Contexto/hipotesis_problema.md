# Hipótesis del Problema – Hotel Terraza

## 1. Contexto
El Hotel Terraza cuenta con **40 habitaciones** distribuidas en los pisos 2 al 5 (por ejemplo 201–205 y 201A–205A), cada una en estado **Libre**, **Ocupada** o **En mantenimiento**. Su operación diaria (reservas, check-in, check-out, control de ocupación, consumos de tienda/minibar y liquidación) se lleva en **libros físicos y registros en papel** manejados por recepción. El detalle está en el [modelo de negocio](../Modelos/Negocio/README.md).

## 2. Problema principal
> **La gestión manual con libros físicos y registros en papel es ineficiente, propensa a errores y no permite conocer en tiempo real la disponibilidad de habitaciones.**

Manifestaciones presumidas del problema:

- **Doble reserva** o sobreocupación de una misma habitación por falta de consulta rápida y centralizada.
- **Tiempos de atención elevados** en el check-in por búsqueda manual y escritura de datos del huésped.
- **Errores de transcripción** (fechas, nombres, tarifas, documentos de identidad).
- **Dificultad para consolidar reservas de Booking** con las registradas directamente en recepción.
- **Pérdida o deterioro** de registros (extravío, tachaduras, humedad, desgaste).
- **Ausencia de reportes** de ocupación e ingresos; la información se consolida manualmente.
- **Dependencia de la memoria** del personal para casos especiales (preferencias, traslados en taxi, pedidos a proveedores).

## 3. Hipótesis
1. Un sistema local que centralice reservas y check-in **reducirá el tiempo de atención** y **eliminará las dobles reservas**.
2. Mostrar el estado de las 40 habitaciones en una sola pantalla **mejorará la toma de decisiones** del Recepcionista.
3. Un registro digital con respaldo periódico **reducirá la pérdida de información** frente al papel.
4. Un diseño simple, centrado en el flujo real de recepción, **minimizará la resistencia al cambio**.

## 4. Necesidades presumidas

| ID | Necesidad | Prioridad presumida |
|---|---|---|
| N1 | Registrar y consultar reservas (fechas, huésped, habitación, tarifa) | Alta |
| N2 | Realizar check-in rápido a partir de una reserva o de un huésped sin reserva | Alta |
| N3 | Ver disponibilidad y estado de las 40 habitaciones en tiempo real | Alta |
| N4 | Registrar check-out y liberar la habitación | Media |
| N5 | Registrar datos de clientes y su historial | Media |
| N6 | Registrar reservas provenientes de Booking (con su tarifa diferenciada) | Media |
| N7 | Registrar solicitudes de taxi y pedidos a proveedores | Baja |
| N10 | Registrar consumos de tienda/minibar y calcular tarifas, recargos y devoluciones | Media |
| N8 | Generar reportes básicos de ocupación | Media |
| N9 | Respaldar y recuperar la información | Alta |

## 5. Riesgos anticipados

| ID | Riesgo | Tipo | Impacto |
|---|---|---|---|
| R1 | Pérdida de datos por fallo del equipo local (sistema monolítico) | Técnico | Alto |
| R2 | Curva de aprendizaje y resistencia al cambio del personal | Operativo | Medio-Alto |
| R3 | Requisitos mal entendidos por falta de validación con el cliente | Proyecto | Alto |
| R4 | Inconsistencias con reservas de Booking (carga manual) | Operativo | Medio |
| R5 | Alcance excesivo para la fase inicial | Proyecto | Medio |
| R6 | Falta de continuidad ante cortes de energía | Técnico | Medio |

Detalle en [riesgos_identificados.md](riesgos_identificados.md).

## 6. Supuestos y restricciones
- El sistema se ejecuta en **un único equipo local** de recepción.
- El **Recepcionista** es el único usuario operativo.
- No se requiere conexión permanente a Internet para la operación básica.
- En la [Entrevista 1](../Entrevistas/entrevista1/acta_entrevista.md) (25/10/2026) se presentó a la propietaria el [prototipo](../Prototipo/README.md) (maqueta de 4 requerimientos). Los demás supuestos quedan por validar en entrevistas posteriores.

