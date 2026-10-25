# Riesgos Identificados – Hotel Terraza

## 1. Metodología
Cada riesgo se evalúa por **probabilidad** (Baja/Media/Alta) e **impacto** (Bajo/Medio/Alto), con estrategia de mitigación y responsable.

## 2. Riesgos técnicos

### RT-01. Pérdida de datos en sistema monolítico local
- **Descripción**: toda la información (reservas, huéspedes, ocupación) reside en un único equipo y base de datos local. Una falla de disco, corrupción de archivos, malware, borrado accidental o corte de energía durante una escritura podría provocar la pérdida total o parcial de los datos.
- **Probabilidad**: Media — **Impacto**: Alto — **Nivel**: **Crítico**
- **Consecuencias**: pérdida de reservas futuras, imposibilidad de verificar huéspedes alojados, pérdida del historial.

#### Plan de backups

| Elemento | Definición |
|---|---|
| **Qué se respalda** | Archivo/base de datos del sistema y archivos de configuración |
| **Frecuencia** | Automático **diario** al cierre del turno; copia adicional manual antes de cualquier actualización |
| **Retención** | Últimos 7 diarios, 4 semanales y 3 mensuales |
| **Regla 3-2-1** | 3 copias, en 2 medios distintos (disco local + USB/disco externo), 1 fuera del hotel (nube o custodia del administrador) |
| **Ubicación** | Carpeta `backups/` local, unidad externa y almacenamiento remoto |
| **Verificación** | Prueba de restauración **mensual** en un equipo distinto |
| **Responsable** | Recepcionista (ejecución) y Administrador del hotel (supervisión) |
| **RPO / RTO objetivo** | Pérdida máxima de 1 día de datos / recuperación en menos de 2 horas |
| **Contingencia** | Si el sistema no está disponible, usar formato de **registro en papel de emergencia** y digitar después |

#### Mitigaciones complementarias
- Uso de **UPS** para evitar apagados abruptos.
- Escrituras transaccionales para evitar corrupción parcial.
- Antivirus actualizado y restricción de dispositivos externos no autorizados.

### RT-02. Interrupción por falla de hardware o energía
- **Probabilidad**: Media — **Impacto**: Medio
- **Mitigación**: UPS, equipo de respaldo con el sistema preinstalado, procedimiento de contingencia en papel.

### RT-03. Inconsistencias en reservas de Booking (carga manual)
- **Probabilidad**: Media — **Impacto**: Medio
- **Mitigación**: validación de disponibilidad al registrar, revisión diaria de reservas de Booking, plan de integración futura.

## 3. Riesgos operativos

### RO-01. Curva de aprendizaje del personal
- **Descripción**: el personal de recepción está habituado a libros físicos y puede percibir el sistema como una carga adicional, con errores iniciales o resistencia al cambio.
- **Probabilidad**: Alta — **Impacto**: Medio-Alto — **Nivel**: **Alto**
- **Mitigaciones**:
  - Interfaz simple, centrada en **Check-in / Reservas**, con pocos pasos y mensajes claros (como en la maqueta mostrada a la propietaria).
  - **Capacitación** práctica inicial (2 sesiones cortas) y manual de usuario de una página.
  - **Periodo de operación paralela** (sistema + papel) durante 2 semanas.
  - Participación del Recepcionista en la **validación del prototipo**.
  - Soporte cercano durante la primera semana de uso.
- **Indicador**: tiempo promedio de check-in y número de errores de captura por semana.

### RO-02. Rotación de personal
- **Probabilidad**: Media — **Impacto**: Medio
- **Mitigación**: manual de usuario y guía de capacitación reutilizables.

### RO-03. Uso incorrecto o no uniforme del sistema
- **Probabilidad**: Media — **Impacto**: Medio
- **Mitigación**: validaciones de datos obligatorios, reglas claras de registro y revisión periódica.

## 4. Matriz de riesgos

| ID | Riesgo | Prob. | Impacto | Nivel |
|---|---|---|---|---|
| RT-01 | Pérdida de datos (monolito local) | Media | Alto | Crítico |
| RT-02 | Falla de hardware o energía | Media | Medio | Medio |
| RT-03 | Inconsistencias con Booking | Media | Medio | Medio |
| RO-01 | Curva de aprendizaje | Alta | Medio-Alto | Alto |
| RO-02 | Rotación de personal | Media | Medio | Medio |
| RO-03 | Uso incorrecto del sistema | Media | Medio | Medio |

## 5. Seguimiento
Los riesgos se revisarán al cierre de cada fase y tras cada entrevista con el cliente.

