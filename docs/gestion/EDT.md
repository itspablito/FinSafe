
# Estructura de Desglose de Trabajo (EDT) — FinSafe

## 1. Información general

| Campo | Descripción |
|---|---|
| Proyecto | FinSafe |
| Tipo de proyecto | Aplicación para el control de finanzas personales y presupuestos compartidos |
| Documento de referencia | Acta de Constitución del Proyecto FinSafe |
| Duración estimada | 16 semanas |
| Equipo | Juan Jose Guzman Camacho, Jesus Ediber Arenas Guzmán y Juan Pablo Rodriguez Gutierrez |
| Esfuerzo estimado total | 432 horas |
| Versión | 2.0 |

## 2. Objetivo de la EDT

Descomponer el alcance aprobado de FinSafe en entregables y paquetes de trabajo organizados jerárquicamente, de manera que cada paquete pueda estimarse, asignarse, desarrollarse, verificarse y aceptarse mediante criterios definidos en el diccionario de la EDT.

La EDT representa el trabajo incluido en el proyecto. No constituye por sí misma un cronograma: las fechas, dependencias y secuencia de ejecución se definirán en el cronograma del proyecto.

## 3. Regla del 100 %

La EDT contempla la totalidad del alcance aprobado del proyecto, sin incorporar funcionalidades excluidas en el acta de constitución.

Los porcentajes de primer nivel representan la distribución del alcance total y suman el 100 %. A su vez, los porcentajes de los paquetes hijos representan su participación dentro del paquete padre y suman el 100 % en cada grupo.

Los porcentajes de los paquetes hijos se distribuyeron proporcionalmente a las horas estimadas de cada paquete dentro de su respectivo grupo. Los valores se presentan con un decimal.

## 4. Jerarquía de la EDT

### 1.0 FinSafe — Aplicación de finanzas personales y presupuestos compartidos (100 %)

#### 1.1 Diseño y arquitectura (10 % del proyecto; 100 % del paquete padre)

| Código | Entregable o paquete de trabajo | % del paquete padre | Horas |
|---|---|---:|---:|
| 1.1.1 | Prototipo de interfaz de usuario aprobado | 58,1 % | 25 |
| 1.1.2 | Arquitectura de software y modelo de datos documentados | 41,9 % | 18 |
| | **Total del paquete 1.1** | **100 %** | **43** |

#### 1.2 Gestión de usuarios (8 % del proyecto; 100 % del paquete padre)

| Código | Entregable o paquete de trabajo | % del paquete padre | Horas |
|---|---|---:|---:|
| 1.2.1 | Módulo funcional de registro e inicio de sesión seguro | 60,0 % | 21 |
| 1.2.2 | Módulo funcional de perfil de usuario | 40,0 % | 14 |
| | **Total del paquete 1.2** | **100 %** | **35** |

#### 1.3 Finanzas personales (16 % del proyecto; 100 % del paquete padre)

| Código | Entregable o paquete de trabajo | % del paquete padre | Horas |
|---|---|---:|---:|
| 1.3.1 | Módulo de registro y consulta de ingresos y gastos | 37,7 % | 26 |
| 1.3.2 | Catálogo funcional de categorías financieras | 21,7 % | 15 |
| 1.3.3 | Vista funcional de presupuesto mensual | 40,6 % | 28 |
| | **Total del paquete 1.3** | **100 %** | **69** |

#### 1.4 Módulo compartido (23 % del proyecto; 100 % del paquete padre)

| Código | Entregable o paquete de trabajo | % del paquete padre | Horas |
|---|---|---:|---:|
| 1.4.1 | Módulo funcional de creación y administración de grupos | 15,2 % | 15 |
| 1.4.2 | Mecanismo funcional de invitación mediante código o enlace | 18,2 % | 18 |
| 1.4.3 | Módulo de registro y consulta de gastos compartidos | 27,3 % | 27 |
| 1.4.4 | Algoritmo de liquidación y resumen de saldos por grupo | 39,3 % | 39 |
| | **Total del paquete 1.4** | **100 %** | **99** |

#### 1.5 Reportes e indicadores (11 % del proyecto; 100 % del paquete padre)

| Código | Entregable o paquete de trabajo | % del paquete padre | Horas |
|---|---|---:|---:|
| 1.5.1 | Panel de indicadores y gastos por categoría | 59,6 % | 28 |
| 1.5.2 | Funcionalidad de exportación de información a PDF y CSV | 40,4 % | 19 |
| | **Total del paquete 1.5** | **100 %** | **47** |

#### 1.6 Calidad y despliegue (18 % del proyecto; 100 % del paquete padre)

| Código | Entregable o paquete de trabajo | % del paquete padre | Horas |
|---|---|---:|---:|
| 1.6.1 | Repositorio de código con integración y despliegue continuos (CI/CD) | 23,1 % | 18 |
| 1.6.2 | Suite de pruebas automatizadas documentada y ejecutable | 23,1 % | 18 |
| 1.6.3 | Aplicación desplegada en un entorno de pruebas accesible | 19,2 % | 15 |
| 1.6.4 | Informe de pruebas de aceptación de usuario y usabilidad | 34,6 % | 27 |
| | **Total del paquete 1.6** | **100 %** | **78** |

#### 1.7 Gestión del proyecto (14 % del proyecto; 100 % del paquete padre)

| Código | Entregable o paquete de trabajo | % del paquete padre | Horas |
|---|---|---:|---:|
| 1.7.1 | Plan del proyecto aprobado, con backlog, EDT y cronograma | 29,5 % | 18 |
| 1.7.2 | Registro de seguimiento y actas de reuniones | 44,3 % | 27 |
| 1.7.3 | Paquete de cierre del proyecto con documentación y demostración funcional | 26,2 % | 16 |
| | **Total del paquete 1.7** | **100 %** | **61** |

### 4.1 Resumen de la distribución del alcance

| Código | Paquete principal | Porcentaje del proyecto | Horas estimadas |
|---|---|---:|---:|
| 1.1 | Diseño y arquitectura | 10 % | 43 |
| 1.2 | Gestión de usuarios | 8 % | 35 |
| 1.3 | Finanzas personales | 16 % | 69 |
| 1.4 | Módulo compartido | 23 % | 99 |
| 1.5 | Reportes e indicadores | 11 % | 47 |
| 1.6 | Calidad y despliegue | 18 % | 78 |
| 1.7 | Gestión del proyecto | 14 % | 61 |
| | **Total del proyecto** | **100 %** | **432** |

**Verificación de la regla del 100 %:** los paquetes principales suman el 100 % del alcance. Los paquetes hijos de cada grupo también suman el 100 % de su paquete padre. Los porcentajes expresan distribución del alcance, mientras que las horas representan el esfuerzo estimado; por ello, ambas medidas no tienen que ser idénticas.

## 5. Correspondencia entre el acta de constitución y la EDT

| Alcance definido en el acta | Paquetes de la EDT relacionados | Resultado esperado |
|---|---|---|
| Gestión de usuarios | 1.2.1 y 1.2.2 | Registro, inicio de sesión y administración del perfil |
| Registro de finanzas personales | 1.3.1, 1.3.2 y 1.3.3 | Ingresos, gastos, categorías y presupuesto mensual |
| Administración de grupos compartidos | 1.4.1 y 1.4.2 | Creación de grupos e incorporación mediante invitación |
| Registro y liquidación de gastos comunes | 1.4.3 y 1.4.4 | Gastos compartidos y cálculo de saldos |
| Reportes financieros | 1.5.1 y 1.5.2 | Indicadores visuales y exportación de información |
| Calidad, pruebas y entrega | 1.6.1, 1.6.2, 1.6.3 y 1.6.4 | Código versionado, pruebas, despliegue y evaluación |
| Planeación, seguimiento y cierre | 1.7.1, 1.7.2 y 1.7.3 | Gestión documentada y cierre del proyecto |

### 5.1 Exclusiones del alcance

Los siguientes elementos no forman parte de la EDT ni deben desarrollarse sin una aprobación formal de cambio del alcance:

1. Integración directa con cuentas bancarias.
2. Ejecución de pagos o transferencias de dinero reales.
3. Conversión y administración avanzada de múltiples monedas en tiempo real.
4. Sincronización sin conexión avanzada con resolución automática de conflictos.
5. Funcionalidades nuevas que no estén aprobadas en el acta de constitución.

## 6. Diccionario de la EDT

El diccionario define el contenido, los criterios de aceptación y el esfuerzo estimado de cada paquete de trabajo de último nivel. Un paquete se considera terminado cuando cumple sus criterios de aceptación y su evidencia ha sido revisada por la persona responsable de aprobarlo.

### 1.1.1 — Prototipo de interfaz de usuario aprobado

- **Descripción:** diseño navegable de las pantallas principales de FinSafe, incluidos los flujos de registro, finanzas personales, grupos compartidos y reportes.
- **Entregable:** prototipo de interfaz en Figma u otra herramienta equivalente.
- **Criterios de aceptación:**
  1. Incluye las pantallas correspondientes a las funcionalidades aprobadas en el alcance.
  2. Permite recorrer los flujos principales mediante navegación entre pantallas.
  3. Presenta nombres, botones y mensajes comprensibles y consistentes.
  4. Recibe aprobación explícita del responsable de frontend/UX y del líder del proyecto.
- **Responsable principal:** frontend/UX.
- **Esfuerzo estimado:** 25 horas.

### 1.1.2 — Arquitectura de software y modelo de datos documentados

- **Descripción:** definición de la estructura de la aplicación, los componentes principales, sus relaciones y las entidades necesarias para almacenar la información.
- **Entregable:** documento de arquitectura y diagrama del modelo de datos.
- **Criterios de aceptación:**
  1. Identifica los componentes de frontend, backend y almacenamiento.
  2. Representa las entidades de usuarios, transacciones, categorías, presupuestos, grupos y gastos compartidos.
  3. Define las relaciones y restricciones de integridad necesarias.
  4. Documenta las decisiones técnicas y recibe revisión del equipo.
- **Responsable principal:** backend/algoritmo.
- **Esfuerzo estimado:** 18 horas.

### 1.2.1 — Módulo funcional de registro e inicio de sesión seguro

- **Descripción:** funcionalidad de creación de cuentas y autenticación de usuarios.
- **Entregable:** módulo de registro e inicio de sesión integrado con el sistema de almacenamiento.
- **Criterios de aceptación:**
  1. Permite registrar una cuenta con los campos obligatorios definidos.
  2. Rechaza datos inválidos y evita el registro duplicado de una misma cuenta.
  3. Permite iniciar y cerrar sesión correctamente.
  4. Almacena las contraseñas mediante un algoritmo de hash adecuado para contraseñas, con salt; nunca en texto plano ni mediante cifrado reversible como sustituto del hash.
  5. Las pruebas de autenticación válida e inválida finalizan con los resultados esperados.
- **Responsable principal:** backend/algoritmo.
- **Esfuerzo estimado:** 21 horas.

### 1.2.2 — Módulo funcional de perfil de usuario

- **Descripción:** funcionalidad para consultar y actualizar la información básica del usuario autenticado.
- **Entregable:** pantalla y lógica de administración del perfil.
- **Criterios de aceptación:**
  1. Permite consultar los datos propios de la cuenta.
  2. Permite modificar los campos editables definidos en el alcance.
  3. Valida los datos antes de guardarlos.
  4. Impide que un usuario consulte o modifique el perfil de otra persona sin autorización.
  5. Los cambios persisten y se muestran correctamente después de volver a consultar el perfil.
- **Responsable principal:** frontend/UX.
- **Esfuerzo estimado:** 14 horas.

### 1.3.1 — Módulo de registro y consulta de ingresos y gastos

- **Descripción:** funcionalidad para registrar, consultar, editar y eliminar las transacciones financieras personales permitidas.
- **Entregable:** módulo de transacciones personales.
- **Criterios de aceptación:**
  1. Permite registrar ingresos y gastos con valor, fecha, descripción y categoría cuando corresponda.
  2. Valida que el valor sea válido y positivo, según las reglas definidas.
  3. Permite consultar y modificar transacciones propias.
  4. Calcula los totales a partir de las transacciones almacenadas.
  5. Los cambios realizados se reflejan en las consultas posteriores.
- **Responsable principal:** backend/algoritmo.
- **Esfuerzo estimado:** 26 horas.

### 1.3.2 — Catálogo funcional de categorías financieras

- **Descripción:** catálogo de categorías para clasificar los ingresos y gastos personales.
- **Entregable:** catálogo integrado con el módulo de transacciones.
- **Criterios de aceptación:**
  1. Incluye categorías iniciales de ingresos y gastos.
  2. Permite seleccionar una categoría al registrar o editar una transacción.
  3. Impide asignar una categoría inexistente o incompatible con las reglas definidas.
  4. Las categorías se muestran correctamente en formularios y consultas.
- **Responsable principal:** backend/algoritmo.
- **Esfuerzo estimado:** 15 horas.

### 1.3.3 — Vista funcional de presupuesto mensual

- **Descripción:** interfaz que permite consultar el presupuesto mensual y compararlo con los gastos registrados durante el periodo.
- **Entregable:** vista de presupuesto mensual integrada con los datos financieros.
- **Criterios de aceptación:**
  1. Permite consultar el presupuesto correspondiente al mes seleccionado.
  2. Muestra el presupuesto establecido, el gasto acumulado y el saldo disponible.
  3. Calcula los valores con base en los registros del periodo.
  4. Actualiza los resultados cuando se registra, modifica o elimina un gasto.
  5. Presenta un mensaje comprensible cuando no existe un presupuesto configurado.
- **Responsable principal:** frontend/UX.
- **Esfuerzo estimado:** 28 horas.

### 1.4.1 — Módulo funcional de creación y administración de grupos

- **Descripción:** funcionalidad para crear grupos y consultar sus integrantes.
- **Entregable:** módulo de administración de grupos compartidos.
- **Criterios de aceptación:**
  1. Permite crear un grupo con un nombre válido.
  2. Asocia el grupo con su creador.
  3. Permite consultar los grupos a los que pertenece el usuario.
  4. Controla el acceso a la información según la pertenencia al grupo.
  5. Las operaciones principales cuentan con pruebas funcionales satisfactorias.
- **Responsable principal:** backend/algoritmo.
- **Esfuerzo estimado:** 15 horas.

### 1.4.2 — Mecanismo funcional de invitación mediante código o enlace

- **Descripción:** mecanismo para incorporar usuarios a un grupo mediante una invitación.
- **Entregable:** funcionalidad de generación y validación de invitaciones.
- **Criterios de aceptación:**
  1. Un usuario autorizado puede generar una invitación para un grupo.
  2. El código o enlace permite identificar el grupo correspondiente.
  3. Una invitación inválida o vencida, si se implementa vencimiento, no permite ingresar.
  4. La aceptación de la invitación registra al usuario como integrante del grupo.
  5. La operación no permite incorporaciones duplicadas ni accesos no autorizados.
- **Responsable principal:** backend/algoritmo.
- **Esfuerzo estimado:** 18 horas.

### 1.4.3 — Módulo de registro y consulta de gastos compartidos

- **Descripción:** funcionalidad para registrar gastos asociados a un grupo y consultar la información relacionada.
- **Entregable:** módulo de gastos compartidos.
- **Criterios de aceptación:**
  1. Permite registrar el valor, la fecha, la descripción y el usuario que reporta el gasto.
  2. Asocia cada gasto con un grupo existente.
  3. Permite consultar los gastos del grupo a sus integrantes autorizados.
  4. Valida los valores y campos obligatorios.
  5. Los gastos registrados se reflejan en el resumen del grupo.
- **Responsable principal:** backend/algoritmo.
- **Esfuerzo estimado:** 27 horas.

### 1.4.4 — Algoritmo de liquidación y resumen de saldos por grupo

- **Descripción:** lógica de cálculo para determinar los saldos de los integrantes según los gastos registrados y las reglas de distribución aprobadas.
- **Entregable:** algoritmo de liquidación y vista de resumen de saldos.
- **Criterios de aceptación:**
  1. Calcula el total de gastos compartidos de cada grupo.
  2. Aplica la regla de distribución de gastos documentada para el proyecto.
  3. Calcula los saldos individuales considerando los pagos o aportes registrados.
  4. La suma de los saldos netos de los integrantes es cero, salvo diferencias de redondeo documentadas.
  5. Presenta resultados consistentes con casos de prueba previamente definidos.
  6. Cuando se generen sugerencias de compensación, estas reducen las obligaciones pendientes sin alterar el saldo neto de los participantes.
- **Responsable principal:** backend/algoritmo.
- **Esfuerzo estimado:** 39 horas.

### 1.5.1 — Panel de indicadores y gastos por categoría

- **Descripción:** panel visual para consultar indicadores resumidos de las finanzas personales.
- **Entregable:** dashboard de indicadores financieros.
- **Criterios de aceptación:**
  1. Presenta ingresos, gastos y balance del periodo seleccionado.
  2. Muestra la distribución de gastos por categoría.
  3. Los indicadores coinciden con los datos almacenados para el mismo periodo.
  4. Actualiza la información cuando cambian las transacciones.
  5. Los gráficos y etiquetas permiten identificar claramente los valores representados.
- **Responsable principal:** frontend/UX.
- **Esfuerzo estimado:** 28 horas.

### 1.5.2 — Funcionalidad de exportación de información a PDF y CSV

- **Descripción:** funcionalidad para generar archivos descargables con la información financiera autorizada.
- **Entregable:** exportador de reportes en PDF y CSV.
- **Criterios de aceptación:**
  1. Permite exportar la información del periodo seleccionado.
  2. Genera archivos PDF y CSV que pueden abrirse correctamente.
  3. Los valores exportados coinciden con los datos consultados en la aplicación.
  4. Los archivos incluyen encabezados identificables y fechas cuando correspondan.
  5. La exportación respeta los permisos de acceso del usuario.
- **Responsable principal:** backend/algoritmo.
- **Esfuerzo estimado:** 19 horas.

### 1.6.1 — Repositorio de código con integración y despliegue continuos (CI/CD)

- **Descripción:** repositorio centralizado y configuración automatizada para verificar el código y apoyar el despliegue.
- **Entregable:** repositorio organizado con pipeline CI/CD documentado.
- **Criterios de aceptación:**
  1. El código fuente está versionado en el repositorio acordado.
  2. Se identifican las ramas y reglas básicas de trabajo.
  3. El pipeline ejecuta las verificaciones definidas al producirse los eventos configurados.
  4. Los resultados de las ejecuciones pueden consultarse.
  5. El equipo dispone de instrucciones para contribuir al repositorio.
- **Responsable principal:** líder/DevOps/QA.
- **Esfuerzo estimado:** 18 horas.

### 1.6.2 — Suite de pruebas automatizadas documentada y ejecutable

- **Descripción:** conjunto de pruebas automatizadas para comprobar las funcionalidades críticas y reducir regresiones.
- **Entregable:** suite de pruebas y reporte de ejecución.
- **Criterios de aceptación:**
  1. Incluye pruebas de los módulos críticos de usuarios, transacciones y gastos compartidos.
  2. Incluye casos válidos e inválidos para las reglas principales.
  3. Las pruebas pueden ejecutarse siguiendo instrucciones documentadas.
  4. Los resultados de aprobación y fallo son identificables.
  5. Los defectos detectados se registran para su seguimiento.
- **Responsable principal:** líder/DevOps/QA.
- **Esfuerzo estimado:** 18 horas.

### 1.6.3 — Aplicación desplegada en un entorno de pruebas accesible

- **Descripción:** versión integrada de FinSafe instalada en un entorno donde el equipo pueda verificar las funcionalidades.
- **Entregable:** instancia desplegada y accesible de la aplicación.
- **Criterios de aceptación:**
  1. La aplicación inicia y puede utilizarse en el entorno definido.
  2. Los componentes necesarios están configurados.
  3. Las funcionalidades críticas pueden recorrerse de principio a fin.
  4. Se documentan la dirección de acceso y los pasos de configuración necesarios.
  5. No existen errores bloqueantes conocidos que impidan la demostración principal.
- **Responsable principal:** líder/DevOps/QA.
- **Esfuerzo estimado:** 15 horas.

### 1.6.4 — Informe de pruebas de aceptación de usuario y usabilidad

- **Descripción:** evaluación de los flujos principales con usuarios de prueba y documentación de resultados, incidencias y oportunidades de mejora.
- **Entregable:** informe de aceptación de usuario (UAT) y evaluación de usabilidad mediante la escala SUS.
- **Criterios de aceptación:**
  1. Define los escenarios de prueba y los resultados esperados.
  2. Ejecuta los escenarios con al menos cinco participantes, si se dispone de ellos y dentro de las condiciones aprobadas del proyecto.
  3. Registra los resultados, errores observados y comentarios de los participantes.
  4. Calcula y documenta el resultado SUS cuando se recojan respuestas válidas suficientes.
  5. Si se utiliza una meta SUS superior a 80, se registra como objetivo de evaluación; un resultado inferior debe documentarse y analizarse, no ocultarse.
  6. El informe identifica los defectos bloqueantes pendientes y el resultado de la aceptación funcional.
- **Responsable principal:** líder/DevOps/QA.
- **Esfuerzo estimado:** 27 horas.

### 1.7.1 — Plan del proyecto aprobado, con backlog, EDT y cronograma

- **Descripción:** documentación de la planificación del proyecto, sus entregables, tareas pendientes y distribución temporal.
- **Entregable:** plan del proyecto con backlog, EDT y cronograma.
- **Criterios de aceptación:**
  1. Incluye los entregables aprobados y su descomposición.
  2. Contiene un backlog priorizado y comprensible.
  3. Incluye un cronograma compatible con el horizonte de 16 semanas.
  4. Identifica responsables y estimaciones de esfuerzo.
  5. El equipo revisa y aprueba la versión inicial del plan.
- **Responsable principal:** líder/DevOps/QA.
- **Esfuerzo estimado:** 18 horas.

### 1.7.2 — Registro de seguimiento y actas de reuniones

- **Descripción:** evidencia documentada del seguimiento, las decisiones y los cambios tratados durante el proyecto.
- **Entregable:** registro de seguimiento, actas de reuniones y control de incidencias.
- **Criterios de aceptación:**
  1. Las actas incluyen fecha, participantes, decisiones y compromisos.
  2. Los compromisos tienen un responsable y un estado de seguimiento.
  3. Se registran los avances y las desviaciones relevantes respecto al plan.
  4. Los cambios de alcance se documentan para su aprobación.
  5. La información se encuentra organizada y accesible para el equipo.
- **Responsable principal:** líder/DevOps/QA.
- **Esfuerzo estimado:** 27 horas.

### 1.7.3 — Paquete de cierre del proyecto con documentación y demostración funcional

- **Descripción:** consolidación de los documentos finales y preparación de una demostración de la aplicación.
- **Entregable:** paquete de cierre, documentación final y demostración funcional de FinSafe.
- **Criterios de aceptación:**
  1. Incluye la documentación técnica y de usuario definida para la entrega.
  2. Presenta los resultados de pruebas y las limitaciones conocidas.
  3. Incluye instrucciones suficientes para ejecutar o acceder a la versión demostrable.
  4. La demostración cubre los flujos principales aprobados.
  5. El equipo realiza una revisión final y registra la entrega.
- **Responsable principal:** líder/DevOps/QA.
- **Esfuerzo estimado:** 16 horas.

## 7. Matriz RACI

### 7.1 Roles del equipo

| Sigla | Integrante | Rol |
|---|---|---|
| L | Juan Jose Guzman Camacho | Líder del proyecto, DevOps y QA |
| B | Jesus Ediber Arenas Guzmán | Backend y algoritmos |
| F | Juan Pablo Rodriguez Gutierrez | Frontend y experiencia de usuario (UX) |

### 7.2 Significado de las responsabilidades

- **R — Responsable de ejecución:** realiza el trabajo del paquete.
- **A — Aprobador y responsable final:** responde por la aceptación del paquete. Cada paquete tiene exactamente una `A`.
- **C — Consultado:** aporta información o participa en la revisión.
- **I — Informado:** recibe información sobre el avance o resultado.

Una misma persona puede tener simultáneamente las responsabilidades `A/R` en un paquete. No debe asignarse más de una `A` al mismo paquete de trabajo.

### 7.3 Asignación RACI por paquete

| Código | Paquete de trabajo | L | B | F |
|---|---|---|---|---|
| 1.1.1 | Prototipo de interfaz aprobado | C | C | A/R |
| 1.1.2 | Arquitectura y modelo de datos | C | A/R | C |
| 1.2.1 | Registro e inicio de sesión seguro | C | A/R | R |
| 1.2.2 | Perfil de usuario | I | C | A/R |
| 1.3.1 | Ingresos y gastos | C | A/R | R |
| 1.3.2 | Catálogo de categorías | I | A/R | C |
| 1.3.3 | Presupuesto mensual | C | R | A/R |
| 1.4.1 | Creación y administración de grupos | C | A/R | R |
| 1.4.2 | Invitaciones por código o enlace | C | A/R | R |
| 1.4.3 | Gastos compartidos | C | A/R | R |
| 1.4.4 | Liquidación y resumen de saldos | C | A/R | R |
| 1.5.1 | Panel de indicadores | C | R | A/R |
| 1.5.2 | Exportación a PDF y CSV | C | A/R | R |
| 1.6.1 | Repositorio y pipeline CI/CD | A/R | C | I |
| 1.6.2 | Suite de pruebas automatizadas | A/R | R | C |
| 1.6.3 | Despliegue en entorno de pruebas | A/R | R | C |
| 1.6.4 | Informe UAT y usabilidad | A/R | C | R |
| 1.7.1 | Plan del proyecto | A/R | C | C |
| 1.7.2 | Seguimiento y actas | A/R | I | I |
| 1.7.3 | Cierre, documentación y demostración | A/R | R | R |

**Verificación RACI:** cada fila contiene exactamente una `A`. Las asignaciones deben ser revisadas por el equipo y ajustadas si la distribución real del trabajo cambia.

## 8. Estimación de esfuerzo

### 8.1 Esfuerzo por paquete principal

| Paquete | Horas |
|---|---:|
| 1.1 Diseño y arquitectura | 43 |
| 1.2 Gestión de usuarios | 35 |
| 1.3 Finanzas personales | 69 |
| 1.4 Módulo compartido | 99 |
| 1.5 Reportes e indicadores | 47 |
| 1.6 Calidad y despliegue | 78 |
| 1.7 Gestión del proyecto | 61 |
| **Total** | **432** |

### 8.2 Capacidad estimada

Para un horizonte de 16 semanas y tres integrantes, la estimación de 432 horas equivale a un promedio de 144 horas por integrante durante todo el proyecto, o 9 horas semanales por persona.

Esta cifra es una referencia de capacidad, no una garantía de disponibilidad. La distribución real deberá verificarse contra el cronograma, las responsabilidades RACI y la disponibilidad de cada integrante.

## 9. Criterios generales de control y aceptación

1. Ningún paquete se considera terminado únicamente por haber iniciado o ejecutado sus actividades; debe existir el entregable definido.
2. Cada paquete de último nivel debe contar con evidencia de cumplimiento de sus criterios de aceptación.
3. Los entregables deben ser consistentes con el acta de constitución y las exclusiones de alcance.
4. Los defectos, riesgos y cambios deben registrarse y revisarse por el equipo.
5. Cualquier funcionalidad que modifique el alcance aprobado requiere evaluación y autorización antes de incorporarse.
6. La documentación, el código y las evidencias deben mantenerse en el repositorio o ubicación acordada por el equipo.
