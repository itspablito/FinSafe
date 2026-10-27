# OBS y matriz RACI - FinSafe

Códigos según [EDT.md](EDT.md). Equipo de 3 personas.

## OBS (completar con nombres reales)

| Código | Rol | Persona |
|---|---|---|
| L | Líder del proyecto y DevOps/QA | Juan Jose Guzman Camacho |
| B | Desarrollador backend / algoritmo | Jesus Ediber Arenas Guzmán |
| F | Desarrollador frontend / UX | Juan pablo rodriguez gutierrez|

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
