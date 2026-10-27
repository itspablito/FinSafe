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
