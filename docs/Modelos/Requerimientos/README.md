# Modelo de Requerimientos – Hotel Terraza

Resumen del modelo de requerimientos. El detalle completo (flujos paso a paso y diagramas) está en el [PDF del modelo de negocio y requerimientos](../Negocio/modelo_negocio_y_requerimientos.pdf).

> En el sistema, el **Recepcionista es el único actor** que interactúa con el software. El Cliente y Booking no lo usan directamente.

## Casos de requerimientos del sistema

| Código | Caso | En el prototipo |
|---|---|---|
| CdR-01 | Gestionar Reserva | No |
| CdR-02 | Registrar Cliente | **Sí** (módulo *Usuarios*) |
| CdR-03 | Gestionar Habitaciones | No |
| CdR-04 | Realizar Check-in | **Sí** (módulo *Check-in*) |
| CdR-05 | Registrar Consumo de Tienda/Minibar | **Sí**, parcial (módulo *Alimentos*) |
| CdR-06 | Registrar Abono | No |
| CdR-07 | Realizar Check-out (Liquidar Cuenta) | **Sí** (módulo *Check-out*) |
| CdR-08 | Consultar Reportes y Métricas | No |

## Requerimientos funcionales

| ID | Descripción |
|---|---|
| RF-01 | Gestionar las 40 habitaciones (pisos 2 a 5) con estado en tiempo real: Libre, Ocupada, En mantenimiento |
| RF-02 | Registrar reservas sin pago inicial (canal directo o Booking), con abonos voluntarios opcionales |
| RF-03 | Registrar devoluciones totales de abonos y liberar la habitación en cancelación previa |
| RF-04 | Reliquidar proporcionalmente por salida anticipada |
| RF-05 | Exención de hospedaje a niños de 3 años o menos |
| RF-06 | Liquidar consumos puntuales de visitantes sin tarifa de cliente adicional |
| RF-07 | Registro obligatorio de cliente: nombre completo, identificación, nacionalidad, correo, procedencia y motivo; vincular habitación |
| RF-08 | Cálculo de tarifa según personas y recargo de \$5.000 por persona/noche con tarjeta |
| RF-09 | Recargo de late check-out de \$10.000 por hora después de la 1:00 p.m. |
| RF-10 | Cerrar cuenta, pasar cliente a *No hospedado* y habitación a *Libre* solo con saldo \$0 |
| RF-11 | Reportes financieros de ingresos netos por medio de pago |

## Requerimientos no funcionales

| ID | Descripción |
|---|---|
| RNF-01 | Arquitectura: aplicación de escritorio monolítica y local en la terminal de Recepción |
| RNF-02 | Rendimiento: respuestas menores a 2 segundos en consultas de disponibilidad |
| RNF-03 | Usabilidad: menús desplegables para el catálogo, evitando digitar valores |
| RNF-04 | Normativa fiscal: no emite facturación electrónica (la maneja un software fiscal independiente) |

> **Nota sobre el prototipo:** la maqueta se ve en el navegador (servidor local en Java) únicamente para mostrar la idea; el sistema final seguirá lo definido en RNF-01.

