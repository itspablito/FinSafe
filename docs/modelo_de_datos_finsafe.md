# Modelo de Datos - FinSafe

**Documento de referencia:** Paquete de trabajo 1.1.2 de la EDT.
**Tipo de Base de Datos:** Relacional (SQL).

## 1. Diagrama de Entidades y Relaciones

A continuación, se detalla el esquema relacional de las entidades requeridas en el alcance de FinSafe.

### 1.1. Entidad: `Usuario`
Almacena la información de las personas registradas en la plataforma.
*   **id** (PK): UUID o Entero autoincremental.
*   **nombre**: Cadena de texto (Obligatorio).
*   **correo_electronico**: Cadena de texto (Obligatorio, ÚNICO). Evita el registro duplicado.
*   **password_hash**: Cadena de texto (Obligatorio).
    *   *Restricción de seguridad:* Almacenado mediante algoritmo de hash con salt. Prohibido texto plano o cifrado reversible.

### 1.2. Entidad: `Categoria`
Catálogo de clasificación para los movimientos financieros.
*   **id** (PK): Entero autoincremental.
*   **nombre**: Cadena de texto.
*   **tipo**: Enum (INGRESO, GASTO).

### 1.3. Entidad: `Transaccion` (Finanzas Personales)
Registra los ingresos y gastos individuales.
*   **id** (PK): Entero autoincremental.
*   **valor**: Decimal (Obligatorio).
    *   *Restricción:* Debe ser un valor estrictamente positivo.
*   **fecha**: Date/Timestamp (Obligatorio).
*   **descripcion**: Cadena de texto.
*   **usuario_id** (FK): Relación N:1 con `Usuario`.
*   **categoria_id** (FK): Relación N:1 con `Categoria`.

### 1.4. Entidad: `Presupuesto`
Define los límites de gasto mensual de un usuario.
*   **id** (PK): Entero autoincremental.
*   **monto_establecido**: Decimal (Obligatorio).
*   **mes_anio**: Date/String (Obligatorio, formato YYYY-MM).
*   **usuario_id** (FK): Relación N:1 con `Usuario`.
    *   *Restricción:* Combinación `usuario_id` + `mes_anio` debe ser ÚNICA (solo un presupuesto activo por mes/usuario).

### 1.5. Entidad: `Grupo`
Administración de grupos de gastos compartidos.
*   **id** (PK): Entero autoincremental.
*   **nombre_grupo**: Cadena de texto (Obligatorio).
*   **codigo_invitacion**: Cadena de texto (Obligatorio, ÚNICO).
*   **creador_id** (FK): Relación N:1 con `Usuario`.

### 1.6. Tabla Intermedia: `Grupo_Usuario` (Integrantes)
Gestiona la relación de muchos a muchos (N:M) entre Usuarios y Grupos.
*   **grupo_id** (FK): Relación con `Grupo`.
*   **usuario_id** (FK): Relación con `Usuario`.
    *   *Restricción:* La llave primaria compuesta `(grupo_id, usuario_id)` evita que un usuario sea agregado dos veces al mismo grupo.

### 1.7. Entidad: `Gasto_Compartido`
Registra los pagos realizados dentro de un grupo para la posterior liquidación.
*   **id** (PK): Entero autoincremental.
*   **valor**: Decimal (Obligatorio, Positivo).
*   **fecha**: Date/Timestamp (Obligatorio).
*   **descripcion**: Cadena de texto (Obligatorio).
*   **grupo_id** (FK): Relación N:1 con `Grupo` (El grupo al que pertenece el gasto).
*   **usuario_reporta_id** (FK): Relación N:1 con `Usuario` (Quién realizó el pago).

## 2. Restricciones Generales de Integridad
1.  **Eliminación Segura:** Todas las claves foráneas (FK) deben configurarse para rechazar eliminaciones accidentales o en cascada (ON DELETE RESTRICT) cuando existan transacciones o gastos financieros vinculados, preservando el historial financiero.
2.  **Obligatoriedad (NOT NULL):** Todos los campos financieros (valores) y fechas no pueden ser nulos.