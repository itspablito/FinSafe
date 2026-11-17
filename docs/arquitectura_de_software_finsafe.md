# Arquitectura de Software - FinSafe

**Documento de referencia:** Paquete de trabajo 1.1.2 de la EDT.
**Proyecto:** FinSafe - Aplicación de Control de Gastos Personales y Presupuestos Compartidos.

## 1. Visión General
La arquitectura de FinSafe se basa en un modelo **Cliente-Servidor** estructurado en tres capas principales. Se han seleccionado tecnologías que cumplen con el presupuesto del proyecto, priorizando el uso de herramientas y servicios gratuitos (Open Source).

## 2. Capas de la Arquitectura

### 2.1. Frontend (Capa de Presentación / Cliente)
*   **Descripción:** Aplicación encargada de la interfaz de usuario, la navegación y la captura de datos.
*   **Responsabilidad:** Consumir los servicios del backend, validar datos básicos de entrada y renderizar vistas como el panel de indicadores (dashboard), las vistas de presupuestos y la gestión de grupos.
*   **Comunicación:** Realiza peticiones HTTP al Backend utilizando el formato JSON.

### 2.2. Backend (Capa de Lógica de Negocio / Servidor)
*   **Tecnología Base:** API REST desarrollada con **Spring Boot (Java)**.
*   **Responsabilidad:** 
    *   Procesar la lógica de negocio de la aplicación.
    *   Validar reglas de integridad (ej. valores de transacciones positivos).
    *   Manejar la seguridad, autenticación (hash + salt) y autorización.
    *   Ejecutar el algoritmo de liquidación de saldos para los gastos compartidos.
*   **Estructura Interna (Paquetes):**
    *   `controllers`: Puntos de entrada de la API REST.
    *   `services`: Lógica de negocio y algoritmos.
    *   `repositories`: Interfaces de acceso a datos.
    *   `models/entities`: Mapeo de la base de datos (JPA).

### 2.3. Almacenamiento (Capa de Datos)
*   **Tecnología Base:** Base de datos relacional (PostgreSQL o MySQL).
*   **Responsabilidad:** Almacenar de forma persistente y segura la información de usuarios, finanzas y configuraciones.
*   **Integridad:** Garantizar la consistencia de los datos mediante claves primarias, claves foráneas y restricciones del modelo relacional.

## 3. Restricciones y Exclusiones Arquitectónicas
De acuerdo con el Acta de Constitución y las exclusiones de alcance, la arquitectura **NO** contempla:
*   Módulos de integración directa con pasarelas de pago o cuentas bancarias reales.
*   Servicios de conversión de divisas en tiempo real.
*   Mecanismos de sincronización sin conexión (offline-first) con resolución automática de conflictos.