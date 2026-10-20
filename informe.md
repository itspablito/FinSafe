# Acta de Constitución del Proyecto

## 1. Información General del Proyecto

| Campo | Detalle |
|---|---|
| **Nombre del proyecto** | FinSafe - App de Control de Gastos Personales y Presupuestos Compartidos |
| **Patrocinador** | Grupo del proyecto |
| **Gerente del proyecto** | Líder del Proyecto |
| **Cliente** | Usuarios jóvenes, parejas y grupos de viajes / compañeros de piso |
| **Responsable** | Equipo de Desarrollo de Software (Grupo de Trabajo) |
| **Fecha de inicio esperada** | Semana 1 |
| **Fecha de finalización esperada** | Semana 16 |

## 2. Definición del Problema

Actualmente, muchas personas jóvenes, estudiantes y grupos (parejas, compañeros de vivienda o viajeros) enfrentan dificultades para llevar un registro claro de sus finanzas diarias y gestionar gastos compartidos. El uso de métodos manuales como hojas de cálculo o notas escritas suele generar desorganización, falta de visibilidad del presupuesto mensual y conflictos o desentendimientos al momento de calcular quién debe cuánto a quién. Existe la necesidad de una solución digital centralizada, ágil e intuitiva que simplifique el control del presupuesto personal y optimice la división de gastos colectivos sin requerir configuraciones complejas.

## 3. Definición de los Objetivos

| Objetivos | Criterios de Evaluación de los Objetivos |
|---|---|
| **1. Desarrollar un producto funcional en 16 semanas:** Diseñar, codificar y desplegar la aplicación móvil/web funcional dentro del marco de tiempo académico. | Cumplimiento del 100% de las historias de usuario prioritarias del Product Backlog antes de la semana 16, con una demo funcional desplegada en un entorno de pruebas/producción. |
| **2. Automatizar el cálculo de saldos compartidos:** Implementar un algoritmo que calcule y simplifique la distribución de deudas en grupos. | El algoritmo debe calcular con un 100% de precisión matemática los saldos individuales y sugerir la menor cantidad de transacciones de liquidación posibles en pruebas UAT. |
| **3. Garantizar una experiencia de usuario intuitiva:** Lograr que la navegación y el registro de transacciones sean rápidos y sencillos. | Registro de una transacción de gasto en menos de 15 segundos y una calificación promedio de usabilidad (SUS) superior a 80/100 en pruebas con usuarios piloto. |

## 4. Alcance del Proyecto

| Dentro del Alcance (In-Scope) | Fuera del Alcance (Out-of-Scope) |
|---|---|
| **Gestión de Usuarios:** Registro, inicio de sesión seguro y gestión de perfil. | **Integración bancaria en tiempo real:** No se conectará la app automáticamente con cuentas bancarias ni sistemas de Open Banking. |
| **Finanzas Personales:** Registro de ingresos/gastos, categorización básica y visualización de presupuesto mensual. | **Pasarela de pagos reales:** La app no procesará transacciones monetarias reales ni transferencias interbancarias (se limitará al registro contable). |
| **Módulo Compartido:** Creación de grupos (parejas/viajes), adición de integrantes vía código/enlace y registro de gastos comunes. | **Soporte multimoneda en tiempo real:** No se manejarán conversiones automáticas entre divisas con tipos de cambio en directo. |
| **Algoritmo de Liquidación:** Cálculo automático de balances ("quién debe a quién") y resumen de saldos por grupo. | **Soporte fuera de línea avanzado:** No se contempla sincronización compleja offline-to-online. |
| **Reportes e Indicadores:** Dashboard visual con gráficos de gastos por categoría y exportación de datos en PDF/CSV. | |

## 5. Suposiciones

1. **Disponibilidad del equipo:** Todos los integrantes del equipo dedicarán entre 8 y 10 horas semanales durante las 16 semanas del semestre para cumplir con los entregables.
2. **Infraestructura sin costo:** Se utilizarán servicios cloud y bases de datos en niveles gratuitos, para el desarrollo y despliegue sin incurrir en costos monetarios.
3. **Acceso a herramientas de desarrollo:** El equipo cuenta con equipos de cómputo adecuados y acceso a herramientas de colaboración (GitHub, Figma, Trello/Jira).
4. **Requisitos estables:** La definición funcional inicial del proyecto se mantendrá sin cambios drásticos (evitando el scope creep) a partir del cierre de la semana 3.