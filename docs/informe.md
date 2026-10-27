
# Acta de Constitución del Proyecto: FinSafe

## 1. Información General del Proyecto

| Campo | Detalle |
|---|---|
| Nombre del proyecto | FinSafe - Aplicación de Control de Gastos Personales y Presupuestos Compartidos |
| Patrocinador | Grupo del proyecto |
| Gerente del proyecto | Líder del Proyecto |
| Cliente | Jóvenes, estudiantes, parejas, viajeros y compañeros de vivienda |
| Responsable | Equipo de Desarrollo de Software |
| Fecha de inicio esperada | Semana 1 |
| Fecha de finalización esperada | Semana 16 |
| Duración estimada | 16 semanas |
| Presupuesto | Uso prioritario de herramientas y servicios gratuitos |

## 2. Definición del Problema

Los jóvenes, estudiantes y grupos que comparten gastos enfrentan dificultades para controlar sus finanzas personales, supervisar sus presupuestos y determinar cuánto dinero debe cada integrante a los demás. El uso de notas, cálculos manuales y hojas de cálculo puede ocasionar errores, falta de organización y desacuerdos financieros. Por ello, se requiere una solución digital centralizada que facilite el registro de ingresos y gastos, la visualización del presupuesto y la distribución transparente de las obligaciones económicas compartidas.

## 3. Definición de los Objetivos

### 3.1. Objetivo General

Desarrollar y desplegar, en un máximo de 16 semanas, una versión funcional de FinSafe que permita gestionar ingresos y gastos personales, consultar presupuestos mensuales, administrar grupos de gastos compartidos y calcular automáticamente los saldos entre sus integrantes, verificando su funcionamiento mediante pruebas de aceptación.

**Criterio de aceptación general:** Al finalizar la semana 16, ¿la aplicación está desplegada, funciona el 100 % de las historias de usuario prioritarias aprobadas y se superan las pruebas de aceptación definidas?

- **Sí:** se cumplen todos los requisitos establecidos en el criterio de aceptación.
- **No:** falta al menos uno de los requisitos establecidos.

### 3.2. Objetivos Específicos

| Objetivo | Criterio de evaluación |
|---|---|
| 1. Desarrollar el producto dentro del plazo establecido. | El 100 % de las historias de usuario prioritarias aprobadas funciona al finalizar la semana 16 y existe una demostración desplegada. |
| 2. Automatizar la liquidación de gastos compartidos. | Todos los casos de prueba definidos producen saldos matemáticamente correctos y las transacciones sugeridas permiten saldar las deudas del grupo. |
| 3. Facilitar el uso de la aplicación. | Los usuarios piloto registran un gasto en menos de 15 segundos y la puntuación promedio de usabilidad SUS es superior a 80/100. |

## 4. Alcance del Proyecto

### 4.1. Entregables Incluidos

| Entregable | Descripción |
|---|---|
| Aplicación funcional | Aplicación web o móvil desplegada en un entorno de pruebas. |
| Gestión de usuarios | Registro, inicio de sesión y administración básica del perfil. |
| Finanzas personales | Registro de ingresos, gastos, categorías y presupuesto mensual. |
| Gastos compartidos | Creación de grupos, incorporación de integrantes mediante código o enlace y registro de gastos comunes. |
| Algoritmo de liquidación | Cálculo de saldos individuales y propuesta de transacciones para saldar deudas. |
| Panel de reportes | Gráficos de gastos por categoría y exportación de información a PDF o CSV. |
| Documentación y pruebas | Instrucciones básicas de uso, casos de prueba y resultados de aceptación. |

### 4.2. Exclusiones del Proyecto

- **Integración bancaria:** no se conectará automáticamente con bancos ni plataformas de Open Banking.
- **Pagos reales:** no se procesarán transferencias, pagos interbancarios ni movimientos monetarios.
- **Conversión multimoneda en tiempo real:** no se consultarán tipos de cambio ni se convertirán automáticamente divisas.
- **Funcionamiento sin conexión avanzado:** no se implementará sincronización compleja entre datos locales y servidores.
- **Funciones adicionales no aprobadas:** no se incorporarán módulos que excedan el alcance acordado sin evaluar y aprobar formalmente el cambio.

## 5. Registro de Interesados

Los niveles de poder e interés son estimaciones iniciales que deberán revisarse durante la planificación del proyecto.

| Interesado | Poder | Interés | Estrategia de gestión | Criterio de éxito |
|---|---|---|---|---|
| Patrocinador del proyecto | Alto | Alto | Gestionar de cerca mediante revisiones semanales. | El producto se entrega en 16 semanas y cumple los requisitos prioritarios. |
| Gerente del proyecto | Alto | Alto | Mantener comunicación continua y controlar el alcance, el tiempo y los avances. | Se cumplen los hitos y criterios de aceptación acordados. |
| Equipo de desarrollo | Medio | Alto | Coordinar tareas, revisar código y realizar reuniones de seguimiento. | Los módulos asignados funcionan y superan las pruebas previstas. |
| Usuarios jóvenes y estudiantes | Bajo | Alto | Consultar sus necesidades y realizar pruebas de usabilidad. | Pueden registrar movimientos y consultar sus presupuestos sin dificultades importantes. |
| Parejas y compañeros de vivienda | Medio | Alto | Involucrarlos en pruebas de gastos y balances compartidos. | Los saldos reflejan correctamente las obligaciones de cada integrante. |
| Administradores de gastos grupales | Medio | Alto | Recoger retroalimentación sobre los reportes y la liquidación de deudas. | Pueden identificar las deudas pendientes y comprender cómo liquidarlas. |
| Docente evaluador | Alto | Alto | Presentar avances y solicitar retroalimentación en los hitos académicos. | El proyecto cumple los requisitos académicos y los criterios de evaluación establecidos. |
| Persona beneficiada por la falta de transparencia de las deudas | Bajo | Medio | Identificar posibles objeciones y explicar cómo la transparencia de los registros afecta a los integrantes. | Las obligaciones registradas pueden verificarse y los integrantes conocen los saldos que les corresponden. |

**Interesado potencialmente perjudicado:** La persona que obtiene una ventaja de mantener deudas poco claras podría perderla si FinSafe hace transparentes los saldos. Este interesado es una hipótesis que deberá validarse; no se presupone que todos los usuarios presenten este comportamiento.

## 6. Supuestos

- **Suponemos que** todos los integrantes dedicarán entre 8 y 10 horas semanales durante las 16 semanas del proyecto.
- **Suponemos que** los servicios gratuitos de alojamiento, bases de datos y desarrollo serán suficientes para construir y probar el producto.
- **Suponemos que** el equipo dispondrá de computadores adecuados y herramientas de colaboración como GitHub y Figma.
- **Suponemos que** los requisitos prioritarios permanecerán estables después de la semana 3, salvo cambios aprobados por el equipo.
- **Suponemos que** será posible reclutar usuarios piloto para validar la funcionalidad y la usabilidad de la aplicación.

## 7. Restricciones

- **Tiempo:** el proyecto debe finalizar en un máximo de 16 semanas académicas.
- **Personal:** el trabajo dependerá de la disponibilidad de los integrantes y de su dedicación semanal.
- **Presupuesto:** se priorizarán herramientas gratuitas y no se asumirán gastos adicionales sin aprobación del equipo.
- **Tecnología:** las funcionalidades estarán limitadas por las herramientas seleccionadas, los conocimientos del equipo y los recursos de infraestructura disponibles.
- **Alcance:** no se desarrollarán integraciones bancarias, procesamiento de pagos reales ni sincronización avanzada sin conexión durante esta fase.

## 8. Riesgos Iniciales del Proyecto

| Riesgo | Impacto potencial | Respuesta inicial |
|---|---|---|
| Retrasos en el desarrollo. | Entregables incompletos al finalizar la semana 16. | Priorizar las historias esenciales y revisar los avances semanalmente. |
| Errores en el algoritmo de liquidación. | Saldos incorrectos y pérdida de confianza de los usuarios. | Validar los cálculos con casos de prueba que representen diferentes distribuciones de gastos. |
| Exposición o pérdida de datos personales. | Afectación de la privacidad y seguridad de los usuarios. | Implementar controles de acceso, autenticación segura y medidas de protección de datos. |
| Limitaciones de los servicios gratuitos. | Interrupciones o dificultades para desplegar el producto. | Verificar los límites de uso y preparar una alternativa tecnológica viable. |
| Participación insuficiente de usuarios piloto. | Evidencia limitada para validar la usabilidad. | Reclutar participantes con anticipación y programar las pruebas. |

## 9. Aprobación Formal del Acta

La aprobación formal autoriza el inicio del proyecto bajo los objetivos, entregables, exclusiones y restricciones establecidos en este documento.

| Nombre completo | Rol de autorización | Fecha de aprobación | Firma o evidencia de aprobación |
|---|---|---|---|
| Juan Pablo Rodriguez Gutierrez | Patrocinador | 2026-10-20 | Juan Rodriguez |
| Juan Jose Guzman Camacho | Gerente del proyecto | 2026-10-22 | Juan Guzman |

**Declaración de aprobación:** Los responsables autorizados declaran que han revisado y aprobado el propósito, los objetivos, el alcance, los supuestos, las restricciones y los criterios de aceptación de FinSafe, y autorizan el inicio del proyecto bajo las condiciones definidas.

**Nota:** Los campos de autorización deberán completarse con los datos reales de los responsables. La aprobación solo será válida cuando exista una firma o confirmación explícita de las personas autorizadas.

