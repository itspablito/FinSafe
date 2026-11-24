# Documentación de la API REST - FinSafe Backend

**URL Base Local:** `http://localhost:8080`  
**Formato de datos:** `application/json`  
**CORS:** Habilitado para todos los orígenes (`*`).

---

## 1. Autenticación y Seguridad (JWT)

Todas las rutas **excepto** `/api/usuarios/registro` y `/api/usuarios/login` requieren autenticación mediante **Bearer Token**.

* **Cabecera obligatoria en peticiones protegidas:** `Authorization: Bearer <TOKEN_OBTENIDO_EN_LOGIN>`
* **Vigencia del token:** 24 horas.
* Si el token falta, es inválido o expiró, la API responderá con estado `403 Forbidden`.

---

## 2. Módulo de Usuarios

### 2.1 Registrar Usuario (Público)
* **Método:** `POST`
* **Endpoint:** `/api/usuarios/registro`
* **Body (JSON):**
  {
    "nombre": "Ana Gómez",
    "correoElectronico": "ana@ejemplo.com",
    "password": "Password123"
  }
* **Respuesta (`201 Created`):** Devuelve el objeto usuario creado con su `id`.

### 2.2 Iniciar Sesión (Público)
* **Método:** `POST`
* **Endpoint:** `/api/usuarios/login`
* **Body (JSON):**
  {
    "correoElectronico": "ana@ejemplo.com",
    "password": "Password123"
  }
* **Respuesta (`200 OK`):**
  {
    "mensaje": "Inicio de sesión exitoso",
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "usuarioId": 2,
    "nombre": "Ana Gómez"
  }
*(Guardar `token` y `usuarioId` en `localStorage` o estado global del frontend).*

### 2.3 Consultar y Actualizar Perfil (Protegido)
* **Consultar:** `GET /api/usuarios/{usuarioId}`
* **Actualizar:** `PUT /api/usuarios/{usuarioId}`
* **Body para actualizar (JSON):**
  {
    "nombre": "Ana Gómez Actualizado",
    "correoElectronico": "ana.nueva@ejemplo.com"
  }

---

## 3. Módulo de Finanzas Personales (Protegido)

### 3.1 Registrar Transacción
* **Método:** `POST`
* **Endpoint:** `/api/transacciones/usuario/{usuarioId}`
* **Valores válidos para `tipo`:** `INGRESO`, `GASTO`
* **Valores válidos para `categoria`:** `ALIMENTACION`, `TRANSPORTE`, `VIVIENDA`, `ENTRETENIMIENTO`, `SALUD`, `EDUCACION`, `SERVICIOS`, `SALARIO`, `INVERSIONES`, `OTROS` (acepta mayúsculas o minúsculas).
* **Body (JSON):**
  {
    "valor": 150.00,
    "tipo": "GASTO",
    "categoria": "ALIMENTACION",
    "descripcion": "Mercado semanal",
    "fecha": "2026-11-23"
  }

### 3.2 Listar Transacciones del Usuario
* **Método:** `GET`
* **Endpoint:** `/api/transacciones/usuario/{usuarioId}`

### 3.3 Configurar Presupuesto Mensual
* **Método:** `POST`
* **Endpoint:** `/api/presupuestos/usuario/{usuarioId}`
* **Body (JSON):**
  {
    "mes": 11,
    "anio": 2026,
    "limite": 1000.00
  }

### 3.4 Consultar Presupuesto y Saldo Disponible
* **Método:** `GET`
* **Endpoint:** `/api/presupuestos/usuario/{usuarioId}?mes=11&anio=2026`
* **Respuesta (`200 OK`):**
  {
    "id": 1,
    "mes": 11,
    "anio": 2026,
    "limite": 1000.00,
    "gastoAcumulado": 150.00,
    "saldoDisponible": 850.00
  }

---

## 4. Módulo de Gastos Compartidos (Protegido)

### 4.1 Crear Grupo
* **Método:** `POST`
* **Endpoint:** `/api/grupos/usuario/{usuarioId}`
* **Body (JSON):**
  {
    "nombre": "Viaje a Cartagena"
  }
* **Respuesta (`201 Created`):** Devuelve el grupo creado y su `codigoInvitacion` único de 8 caracteres (ej. `"A946A3E0"`).

### 4.2 Unirse a un Grupo por Código
* **Método:** `POST`
* **Endpoint:** `/api/grupos/unirse/usuario/{usuarioId}`
* **Body (JSON):**
  {
    "codigoInvitacion": "A946A3E0"
  }

### 4.3 Listar Grupos de un Usuario y Detalle
* **Listar mis grupos:** `GET /api/grupos/usuario/{usuarioId}`
* **Ver detalle e integrantes:** `GET /api/grupos/{grupoId}/usuario/{usuarioId}`

### 4.4 Registrar Gasto Compartido
* **Método:** `POST`
* **Endpoint:** `/api/grupos/{grupoId}/gastos/usuario/{usuarioSolicitanteId}`
* **Opción A — En partes iguales (`PARTES_IGUALES`):**
  {
    "descripcion": "Cena en grupo",
    "montoTotal": 200.00,
    "fecha": "2026-11-23",
    "pagadorId": 1,
    "tipoDistribucion": "PARTES_IGUALES"
  }
* **Opción B — Montos exactos (`MONTOS_EXACTOS`):**
  {
    "descripcion": "Entradas y transporte",
    "montoTotal": 150.00,
    "fecha": "2026-11-23",
    "pagadorId": 2,
    "tipoDistribucion": "MONTOS_EXACTOS",
    "detalles": [
      { "usuarioId": 1, "monto": 90.00 },
      { "usuarioId": 2, "monto": 60.00 }
    ]
  }

### 4.5 Historial y Balances del Grupo (Quién le debe a quién)
* **Historial de gastos:** `GET /api/grupos/{grupoId}/gastos/usuario/{usuarioId}`
* **Balances y liquidación sugerida:** `GET /api/grupos/{grupoId}/gastos/balances/usuario/{usuarioId}`
* **Respuesta de balances (`200 OK`):**
  {
    "grupoId": 1,
    "nombreGrupo": "Viaje a Cartagena",
    "gastoTotalGrupo": 350.00,
    "saldosIndividuales": [
      {
        "usuarioId": 1,
        "nombre": "Juan Pérez",
        "totalPagado": 200.00,
        "totalConsumido": 190.00,
        "balanceNeto": 10.00
      }
    ],
    "liquidacionSugerida": [
      {
        "deudorId": 2,
        "nombreDeudor": "Ana Gómez",
        "acreedorId": 1,
        "nombreAcreedor": "Juan Pérez",
        "monto": 10.00
      }
    ]
  }

---

## 5. Dashboard y Exportación de Reportes (Protegido)

### 5.1 Indicadores del Panel Principal (FIN-11)
* **Método:** `GET`
* **Endpoint:** `/api/dashboard/usuario/{usuarioId}`
* **Respuesta (`200 OK`):**
  {
    "usuarioId": 1,
    "nombreUsuario": "Juan Pérez",
    "totalIngresos": 1500.50,
    "totalGastos": 140.00,
    "balanceGeneral": 1360.50,
    "cantidadMovimientos": 2,
    "distribucionGastosPorCategoria": [
      {
        "categoria": "ALIMENTACION",
        "total": 140.00,
        "porcentaje": 100.0
      }
    ]
  }

### 5.2 Descargar Reportes (FIN-12)
* **Descargar CSV:** `GET /api/exportar/csv/usuario/{usuarioId}` (Devuelve archivo binario `text/csv`).
* **Descargar PDF:** `GET /api/exportar/pdf/usuario/{usuarioId}` (Devuelve archivo binario `application/pdf`).
*(En el frontend, consumir con `responseType: 'blob'` enviando el `Bearer Token` en los headers para disparar la descarga).*