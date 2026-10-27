# Estructura de Desglose de Trabajo (EDT) - FinSafe

Proyecto: **FinSafe - App de Control de Gastos Personales y Presupuestos Compartidos**.
Fuente de alcance: Acta de Constitución del Proyecto (16 semanas).

## 1. Estructura jerárquica

- **1.0 FinSafe: aplicación de control de gastos personales y presupuestos compartidos (100 %)**
  - **1.1 Diseño y arquitectura (10 %)**
    - 1.1.1 Prototipo de interfaz
    - 1.1.2 Arquitectura y modelo de datos
  - **1.2 Gestión de usuarios (8 %)**
    - 1.2.1 Módulo de registro e inicio de sesión seguro
    - 1.2.2 Módulo de perfil de usuario
  - **1.3 Finanzas personales (16 %)**
    - 1.3.1 Módulo de ingresos y gastos
    - 1.3.2 Catálogo de categorías
    - 1.3.3 Vista de presupuesto mensual
  - **1.4 Módulo compartido (23 %)**
    - 1.4.1 Módulo de grupos
    - 1.4.2 Mecanismo de invitación por código o enlace
    - 1.4.3 Módulo de gastos comunes
    - 1.4.4 Algoritmo de liquidación y resumen de saldos por grupo
  - **1.5 Reportes e indicadores (11 %)**
    - 1.5.1 Dashboard de gastos por categoría
    - 1.5.2 Exportación de datos en PDF y CSV
  - **1.6 Calidad y despliegue (18 %)**
    - 1.6.1 Repositorio con pipeline CI/CD
    - 1.6.2 Suite de pruebas automatizadas
    - 1.6.3 Aplicación desplegada en entorno de pruebas/producción
    - 1.6.4 Informe de pruebas UAT y de usabilidad (SUS)
  - **1.7 Gestión del proyecto (14 %)**
    - 1.7.1 Plan del proyecto (backlog, EDT y cronograma)
    - 1.7.2 Informes de seguimiento y actas de reuniones
    - 1.7.3 Documentación final y demo funcional

**Verificación de la regla del 100 %:** 10 + 8 + 16 + 23 + 11 + 18 + 14 = 100.

## 2. Correspondencia con el Acta

| Elemento del Acta | Paquete(s) del EDT |
|---|---|
| Gestión de usuarios: registro, inicio de sesión seguro y perfil | 1.2.1, 1.2.2 |
| Finanzas personales: ingresos/gastos, categorización y presupuesto mensual | 1.3.1, 1.3.2, 1.3.3 |
| Módulo compartido: grupos, integrantes por código/enlace y gastos comunes | 1.4.1, 1.4.2, 1.4.3 |
| Algoritmo de liquidación y resumen de saldos por grupo | 1.4.4 |
| Reportes: gráficos por categoría y exportación PDF/CSV | 1.5.1, 1.5.2 |
| Objetivo 1: diseñar, codificar y desplegar en 16 semanas | 1.1, 1.6.1, 1.6.3, 1.7 |
| Objetivos 2 y 3: precisión en UAT, registro en menos de 15 s y SUS superior a 80 | 1.6.2, 1.6.4 |

Quedan fuera del EDT, como establece el Acta: integración bancaria, pasarela de pagos reales, multimoneda en tiempo real y soporte offline avanzado.

## 3. Diccionario del EDT

| Código | Paquete de trabajo | Descripción |
|---|---|---|
| 1.1.1 | Prototipo de interfaz | Pantallas navegables en Figma de los flujos principales (registro de gasto, grupos y dashboard), con la paleta y componentes visuales base. |
| 1.1.2 | Arquitectura y modelo de datos | Diagrama de componentes de la aplicación y esquema de base de datos (usuarios, transacciones, grupos y saldos). |
| 1.2.1 | Módulo de registro e inicio de sesión seguro | Alta de cuenta, inicio y cierre de sesión con contraseñas cifradas y protección de rutas privadas. |
| 1.2.2 | Módulo de perfil de usuario | Consulta y edición de los datos personales del usuario registrado. |
| 1.3.1 | Módulo de ingresos y gastos | Alta, edición y eliminación de transacciones personales con monto, fecha y descripción, optimizado para registrar en menos de 15 s. |
| 1.3.2 | Catálogo de categorías | Conjunto de categorías básicas predefinidas y su asignación a cada transacción. |
| 1.3.3 | Vista de presupuesto mensual | Pantalla con el presupuesto del mes y el total gastado frente a él; no incluye los gráficos por categoría (1.5.1). |
| 1.4.1 | Módulo de grupos | Creación de grupos (parejas, viajes, compañeros de piso) y consulta de sus integrantes. |
| 1.4.2 | Mecanismo de invitación por código o enlace | Generación de código o enlace único para que nuevos integrantes se unan a un grupo. |
| 1.4.3 | Módulo de gastos comunes | Registro de gastos de grupo indicando quién pagó y cómo se divide entre los integrantes. |
| 1.4.4 | Algoritmo de liquidación y resumen de saldos por grupo | Cálculo automático de los saldos individuales y de las transacciones mínimas para saldar deudas ("quién debe a quién"), con el resumen por grupo. |
| 1.5.1 | Dashboard de gastos por categoría | Gráficos visuales de gastos por categoría y período a partir de las transacciones registradas. |
| 1.5.2 | Exportación de datos en PDF y CSV | Descarga de los datos de transacciones y reportes en formato PDF y CSV. |
| 1.6.1 | Repositorio con pipeline CI/CD | Repositorio del proyecto con integración y despliegue continuos que ejecutan las pruebas en cada cambio. |
| 1.6.2 | Suite de pruebas automatizadas | Pruebas unitarias y de integración, con énfasis en la exactitud de los saldos del algoritmo de liquidación. |
| 1.6.3 | Aplicación desplegada en entorno de pruebas/producción | Versión funcional de la app accesible en la nube, usando niveles gratuitos de infraestructura. |
| 1.6.4 | Informe de pruebas UAT y de usabilidad (SUS) | Resultados documentados de las pruebas con usuarios piloto: precisión del algoritmo, tiempo de registro y puntaje SUS. |
| 1.7.1 | Plan del proyecto (backlog, EDT y cronograma) | Product Backlog priorizado, este EDT y el cronograma de 16 semanas, con requisitos estables desde la semana 3. |
| 1.7.2 | Informes de seguimiento y actas de reuniones | Registros periódicos del avance del equipo y actas de cada reunión de coordinación. |
| 1.7.3 | Documentación final y demo funcional | Documentación de cierre del proyecto y demostración de la aplicación funcionando en la semana 16. |

# RACI 

## OBS y matriz RACI - FinSafe

Códigos según [EDT.md](EDT.md). Equipo de 3 personas.

## OBS 

| Código | Rol | Persona |
|---|---|---|
| L | Líder del proyecto y DevOps/QA | Juan Jose Guzman Camacho |
| B | Desarrollador backend / algoritmo | Jesus Ediber Arenas Guzmán |
| F | Desarrollador frontend / UX | Juan Pablo Rodriguez Gutierrez|

## Matriz RACI

R = Responsable, A = Aprobador (exactamente uno por paquete), C = Consultado, I = Informado.

| Código | Paquete | L | B | F |
|---|---|---|---|---|
| 1.1.1 | Prototipo de interfaz | C | C | **A/R** |
| 1.1.2 | Arquitectura y modelo de datos | C | **A/R** | C |
| 1.2.1 | Registro e inicio de sesión seguro | I | **A/R** | R |
| 1.2.2 | Perfil de usuario | **A/R** | C | R |
| 1.3.1 | Ingresos y gastos | I | R | **A/R** |
| 1.3.2 | Catálogo de categorías | I | C | **A/R** |
| 1.3.3 | Presupuesto mensual | C | R | **A/R** |
| 1.4.1 | Grupos | I | **A/R** | R |
| 1.4.2 | Invitación por código o enlace | I | R | **A/R** |
| 1.4.3 | Gastos comunes | C | **A/R** | R |
| 1.4.4 | Algoritmo de liquidación | C | **A/R** | I |
| 1.5.1 | Dashboard por categoría | I | C | **A/R** |
| 1.5.2 | Exportación PDF/CSV | I | **A/R** | C |
| 1.6.1 | Repositorio con CI/CD | **A/R** | C | C |
| 1.6.2 | Suite de pruebas | **A/R** | R | I |
| 1.6.3 | Aplicación desplegada | **A/R** | C | C |
| 1.6.4 | Informe UAT y SUS | **A/R** | I | R |
| 1.7.1 | Plan del proyecto | **A/R** | C | C |
| 1.7.2 | Seguimiento y actas | **A/R** | C | C |
| 1.7.3 | Documentación final y demo | **A/R** | R | R |

## Verificación de carga (horas de los paquetes donde la persona es A/R)

| Persona | Paquetes | Horas |
|---|---|---|
| L | 1.2.2, 1.6.1, 1.6.2, 1.6.3, 1.6.4, 1.7.1, 1.7.2, 1.7.3 | 14 + 18 + 18 + 15 + 27 + 18 + 27 + 16 = 153 |
| B | 1.1.2, 1.2.1, 1.4.1, 1.4.3, 1.4.4, 1.5.2 | 18 + 21 + 15 + 27 + 39 + 19 = 139 |
| F | 1.1.1, 1.3.1, 1.3.2, 1.3.3, 1.4.2, 1.5.1 | 25 + 26 + 15 + 28 + 18 + 28 = 140 |
| **Total** | | **432** |

Disponibilidad por persona: ~144 h (8-10 h x 16 semanas). Cada fila tiene exactamente una A.


# Diccionario detallado de la EDT - FinSafe

Complemento de [EDT.md](EDT.md) para el codelab. Cada paquete tiene su criterio de aceptación verificable y una estimación de horas (regla 8/80: entre 8 y 80 h).
Las horas son orientativas: equipo de 3 personas x 144 h = 432 h.

| Código | Paquete de trabajo | Descripción | Criterio de aceptación | Horas |
|---|---|---|---|---|
| 1.1.1 | Prototipo de interfaz | Pantallas navegables en Figma de registro de gasto, grupos y dashboard, con paleta y componentes base | Los 3 flujos son navegables y el equipo los aprueba antes de cerrar la semana 3 | 25 |
| 1.1.2 | Arquitectura y modelo de datos | Diagrama de componentes y esquema de BD (usuarios, transacciones, grupos, saldos) | Diagrama y esquema versionados en el repo y revisados por todo el equipo | 18 |
| 1.2.1 | Módulo de registro e inicio de sesión seguro | Alta, login y cierre de sesión con contraseñas cifradas | Un usuario se registra e ingresa; la contraseña nunca queda en texto plano; las rutas protegidas rechazan accesos sin sesión | 21 |
| 1.2.2 | Módulo de perfil de usuario | Consulta y edición de datos del usuario | Los cambios persisten tras cerrar sesión y volver a entrar | 14 |
| 1.3.1 | Módulo de ingresos y gastos | Alta, edición y eliminación de transacciones personales | Registrar un gasto toma menos de 15 s en pruebas con usuarios | 26 |
| 1.3.2 | Catálogo de categorías | Categorías básicas predefinidas y su asignación a transacciones | Toda transacción tiene categoría y se puede filtrar por ella | 15 |
| 1.3.3 | Vista de presupuesto mensual | Presupuesto del mes frente al total gastado | El total gastado mostrado coincide con la suma de las transacciones del mes | 28 |
| 1.4.1 | Módulo de grupos | Creación de grupos y consulta de integrantes | Un usuario crea un grupo y ve la lista de sus integrantes | 15 |
| 1.4.2 | Mecanismo de invitación por código o enlace | Código o enlace único para unirse a un grupo | Un usuario nuevo se une a un grupo usando el código o enlace y aparece como integrante | 18 |
| 1.4.3 | Módulo de gastos comunes | Gasto de grupo con pagador y división entre integrantes | La suma de las partes es igual al total del gasto en el 100 % de los casos de prueba | 27 |
| 1.4.4 | Algoritmo de liquidación y resumen de saldos por grupo | Saldos individuales y transacciones mínimas de liquidación | Saldos correctos al 100 % en los casos de prueba y número mínimo de transacciones sugeridas, validado en UAT | 39 |
| 1.5.1 | Dashboard de gastos por categoría | Gráficos por categoría y período | Los totales de cada gráfico coinciden con los datos registrados | 28 |
| 1.5.2 | Exportación de datos en PDF y CSV | Descarga de transacciones y reportes | Ambos archivos abren correctamente y sus totales coinciden con la app | 19 |
| 1.6.1 | Repositorio con pipeline CI/CD | Integración y despliegue continuos | Un push a la rama principal dispara el pipeline; una prueba fallida bloquea el merge | 18 |
| 1.6.2 | Suite de pruebas automatizadas | Pruebas unitarias y de integración, con énfasis en el algoritmo | Las pruebas se ejecutan en el pipeline y cubren los casos del algoritmo de liquidación | 18 |
| 1.6.3 | Aplicación desplegada en entorno de pruebas/producción | Versión funcional accesible en la nube (capa gratuita) | La demo es accesible por URL y los flujos prioritarios funcionan | 15 |
| 1.6.4 | Informe de pruebas UAT y de usabilidad (SUS) | Resultados de pruebas con usuarios piloto | Informe con mínimo 5 usuarios piloto y SUS promedio superior a 80/100 | 27 |
| 1.7.1 | Plan del proyecto (backlog, EDT y cronograma) | Backlog priorizado, EDT y cronograma de 16 semanas | Backlog en Trello/Jira y requisitos congelados al cierre de la semana 3 | 18 |
| 1.7.2 | Informes de seguimiento y actas de reuniones | Registro periódico de avance y actas de coordinación | Existe un informe de seguimiento por semana y un acta por cada reunión realizada | 27 |
| 1.7.3 | Documentación final y demo funcional | Documentación de cierre y demostración | 100 % de historias prioritarias cumplidas y demo funcionando en la semana 16 | 16 |

**Total: 432 h.**
