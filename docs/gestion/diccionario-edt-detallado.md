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
