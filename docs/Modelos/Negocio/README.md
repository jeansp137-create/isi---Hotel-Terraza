# Modelo de Negocio – Hotel Terraza

Resumen del modelo de negocio. El documento completo, con diagramas de casos de uso, tarifario y catálogo, está en [modelo_negocio_y_requerimientos.pdf](modelo_negocio_y_requerimientos.pdf).

## Actores del negocio (Stephen Schach)

| Actor | Rol |
|---|---|
| Cliente | Actor real primario: solicita reserva, abona, hace check-in, consume y liquida |
| Recepcionista | Actor operativo y usuario directo exclusivo del software |
| Plataforma Booking | Actor secundario externo: canal de origen de reservas (sin integración automática) |
| Servicio de Taxis | Actor externo (CdU-N11) |
| Proveedor | Actor externo (CdU-N15) |

## Casos de uso del negocio

| Código | Caso de uso |
|---|---|
| CdU-N01 | Hospedar Cliente |
| CdU-N02 | Vender Servicios Adicionales |
| CdU-N04 | Mantener Habitaciones en Condición de Servicio |
| CdU-N05 | Recibir y Gestionar Reservas de Canales Externos |
| CdU-N09 | Gestionar Reclamaciones y Solicitudes |
| CdU-N10 | Gestionar Objetos Perdidos (Lost & Found) |
| CdU-N11 | Coordinar Transporte para Cliente |
| CdU-N12 | Negociar Tarifa Especial |
| CdU-N13 | Atender Solicitud de Servicio a la Habitación (Room Service) |
| CdU-N14 | Gestionar Quejas o Incidentes de Servicio |
| CdU-N15 | Gestionar Relación con Proveedores de Insumos |

## Reglas de negocio (entrevista de elicitación)

- **Reservas:** no se exige abono ni pago para reservar (ni por Booking ni directo); el abono o pago anticipado es voluntario y el sistema debe registrarlo.
- **No-Show:** si el cliente no llega, se marca No-Show sin penalidad y se libera la habitación.
- **Cancelación previa con abono:** se devuelve la totalidad y se libera la habitación.
- **Salida anticipada:** se cobran solo las noches efectivas (con la tarifa del canal: directa o Booking) más consumos; se devuelve el resto.
- **Niños de 3 años o menos:** no pagan hospedaje.
- **Visitantes:** el desayuno de un visitante cuesta \$12.000 y no se cobra la tarifa de cliente adicional (\$40.000).
- **Pago con tarjeta:** recargo de \$5.000 por persona por noche.
- **Check-out:** hasta la 1:00 p.m.; después, recargo de \$10.000 por hora.

## Tarifas de hospedaje (efectivo/transferencia | tarjeta)

| Acomodación | Efectivo/Transf. | Tarjeta |
|---|---|---|
| 1 cliente | \$110.000 | \$115.000 |
| 2 clientes, 1 cama King | \$150.000 | \$160.000 |
| 2 clientes, 2 camas King | \$155.000 | \$165.000 |
| 3 personas | \$190.000 | \$205.000 |
| 4 personas | \$210.000 | \$230.000 |
| Cliente adicional por noche | \$40.000 | \$45.000 |
| Niños ≤ 3 años | \$0 | \$0 |

El catálogo completo de bar, aseo y lavandería está en el PDF.
