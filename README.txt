================================================================================
                    CRM FUMIGIL - SISTEMA DE GESTION DE SERVICIOS
================================================================================

Version: 1.0-FINAL
Fecha: Junio 2026
Desarrollado por: [Nombre del Estudiante]
Asignatura: Base de Datos / Programacion

================================================================================
DESCRIPCION DEL PROYECTO
================================================================================

CRM FumiGil es un sistema de gestion integral para una empresa de multiservicios
especializada en:

    • Fumigacion Residencial e Industrial
    • Desinfeccion de Ambientes
    • Control de Plagas
    • Certificacion de Servicios

El sistema permite administrar clientes, trabajadores, servicios, insumos,
ordenes de servicio, certificados y generar reportes estadisticos.

================================================================================
TECNOLOGIAS UTILIZADAS
================================================================================

Backend:
    - Java 17
    - JavaFX 17 (Interfaz grafica)
    - Oracle Database 18c / XE
    - PL/SQL (Procedimientos, funciones, triggers, paquetes)
    - JDBC (Conexion a base de datos)
    - Maven (Gestion de dependencias)

Librerias:
    - Jakarta Mail (Envio de correos electronicos)
    - iText 7 (Generacion de PDF)
    - ControlsFX (Componentes adicionales para JavaFX)
    - OJDBC11 (Driver de Oracle)

Entorno de desarrollo:
    - Apache NetBeans 29
    - Oracle SQL Developer
    - Git / GitHub

================================================================================
ESTRUCTURA DEL PROYECTO
================================================================================

CRM-FumiGil/
├── pom.xml                          # Configuracion de Maven y dependencias
├── README.txt                       # Este archivo
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── fumigil/
│   │   │           └── crm/
│   │   │               ├── aplicacion/
│   │   │               │   └── MainApp.java           # Punto de entrada
│   │   │               ├── controladores/
│   │   │               │   ├── LoginController.java
│   │   │               │   ├── DashboardController.java
│   │   │               │   ├── ClienteController.java
│   │   │               │   ├── TrabajadorController.java
│   │   │               │   ├── OrdenController.java
│   │   │               │   ├── CertificadoController.java
│   │   │               │   ├── ServicioController.java
│   │   │               │   ├── InsumoController.java
│   │   │               │   └── ReporteController.java
│   │   │               ├── modelos/
│   │   │               │   ├── Usuario.java
│   │   │               │   ├── Cliente.java
│   │   │               │   ├── Trabajador.java
│   │   │               │   ├── Cargo.java
│   │   │               │   ├── Servicio.java
│   │   │               │   ├── OrdenServicio.java
│   │   │               │   ├── DetalleServicio.java
│   │   │               │   ├── Insumo.java
│   │   │               │   ├── DetalleInsumo.java
│   │   │               │   ├── Certificado.java
│   │   │               │   └── enums/
│   │   │               │       ├── Rol.java
│   │   │               │       ├── EstadoOrden.java
│   │   │               │       └── TipoCliente.java
│   │   │               ├── dao/
│   │   │               │   ├── UsuarioDAO.java
│   │   │               │   ├── ClienteDAO.java
│   │   │               │   ├── TrabajadorDAO.java
│   │   │               │   ├── OrdenServicioDAO.java
│   │   │               │   ├── ServicioDAO.java
│   │   │               │   ├── InsumoDAO.java
│   │   │               │   └── CertificadoDAO.java
│   │   │               ├── servicios/
│   │   │               │   ├── UsuarioService.java
│   │   │               │   ├── ClienteService.java
│   │   │               │   ├── TrabajadorService.java
│   │   │               │   ├── OrdenServicioService.java
│   │   │               │   ├── ServicioService.java
│   │   │               │   ├── InsumoService.java
│   │   │               │   ├── CertificadoService.java
│   │   │               │   ├── EmailService.java
│   │   │               │   └── PDFService.java
│   │   │               ├── utilidades/
│   │   │               │   ├── DBConnection.java
│   │   │               │   ├── SessionManager.java
│   │   │               │   ├── Validator.java
│   │   │               │   └── PDFGenerator.java
│   │   │               └── exception/
│   │   │                   ├── BusinessException.java
│   │   │                   └── DatabaseException.java
│   │   └── resources/
│   │       └── com/
│   │           └── fumigil/
│   │               └── crm/
│   │                   ├── fxml/
│   │                   │   ├── Login.fxml
│   │                   │   ├── Dashboard.fxml
│   │                   │   ├── ClienteView.fxml
│   │                   │   ├── TrabajadorView.fxml
│   │                   │   ├── OrdenView.fxml
│   │                   │   ├── CertificadoView.fxml
│   │                   │   ├── ServicioView.fxml
│   │                   │   ├── InsumoView.fxml
│   │                   │   └── ReporteView.fxml
│   │                   └── css/
│   │                       └── styles.css
│   └── test/
│       └── java/
│           └── com/
│               └── fumigil/
│                   └── crm/
│                       └── test/
│                           └── DAOTest.java

================================================================================
REQUISITOS PREVIOS
================================================================================

Antes de ejecutar el proyecto, asegurese de tener instalado:

1. Java JDK 17 o superior
   - Descargar de: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

2. Apache NetBeans 12 o superior
   - Descargar de: https://netbeans.apache.org/

3. Oracle Database XE 18c o superior
   - Descargar de: https://www.oracle.com/database/technologies/xe-downloads.html

4. Oracle SQL Developer (opcional, para gestionar la BD)
   - Descargar de: https://www.oracle.com/database/sqldeveloper/

5. Maven (incluido en NetBeans)

================================================================================
CONFIGURACION DE LA BASE DE DATOS
================================================================================

Paso 1: Crear el usuario y tablespace

Ejecutar en SQL Developer como usuario SYSTEM:

-------------------------------------------------------------------------------
CREATE TABLESPACE fumigil
DATAFILE 'C:\app\oracle\oradata\XE\fumigil.dbf'
SIZE 100M AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED;

CREATE USER jose IDENTIFIED BY "jose1051"
DEFAULT TABLESPACE fumigil
TEMPORARY TABLESPACE TEMP;

ALTER USER jose QUOTA UNLIMITED ON fumigil;

GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW, CREATE SEQUENCE,
      CREATE PROCEDURE, CREATE TRIGGER TO jose;
-------------------------------------------------------------------------------

Paso 2: Ejecutar el script de creacion de tablas

Conectarse como usuario jose y ejecutar el archivo:
    database/script_completo.sql

Este script crea:
    - 13 tablas
    - 8 secuencias
    - 18 triggers
    - 11 procedimientos
    - 10 funciones
    - Datos de prueba (departamentos, ciudades, servicios, insumos, usuario admin)

Paso 3: Verificar la instalacion

Ejecutar:
-------------------------------------------------------------------------------
SELECT table_name FROM user_tables ORDER BY table_name;
SELECT object_name, object_type FROM user_objects WHERE object_type IN ('PROCEDURE', 'FUNCTION');
-------------------------------------------------------------------------------

================================================================================
CONFIGURACION DE LA CONEXION A BASE DE DATOS
================================================================================

Editar el archivo: src/main/java/utilidades/DBConnection.java

Modificar los siguientes parametros segun su configuracion:

-------------------------------------------------------------------------------
private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
private static final String USER = "jose";
private static final String PASSWORD = "jose1051";
-------------------------------------------------------------------------------

Si su base de datos tiene un SID diferente, cambielo:
    - Para XE: jdbc:oracle:thin:@localhost:1521:XE
    - Para XEPDB1: jdbc:oracle:thin:@localhost:1521/XEPDB1

================================================================================
CONFIGURACION DEL CORREO ELECTRONICO
================================================================================

Editar el archivo: src/main/java/servicios/EmailService.java

Modificar los siguientes parametros:

-------------------------------------------------------------------------------
private static final String EMAIL_FROM = "su_correo@gmail.com";
private static final String EMAIL_PASSWORD = "su_contraseña_de_aplicacion";
-------------------------------------------------------------------------------

Nota: Para Gmail, debe usar una "contraseña de aplicacion":
    1. Activar verificación en dos pasos
    2. Generar contraseña de aplicacion
    3. Usar esa contraseña (no la de su cuenta)

================================================================================
EJECUCION DEL PROYECTO
================================================================================

Desde NetBeans:
    1. Abrir el proyecto en NetBeans
    2. Click derecho en el proyecto -> Clean and Build
    3. Click derecho en el proyecto -> Run

Desde terminal (con Maven):
-------------------------------------------------------------------------------
mvn clean javafx:run
-------------------------------------------------------------------------------

Desde terminal (con el wrapper de Maven - Windows):
-------------------------------------------------------------------------------
.\mvnw.cmd clean javafx:run
-------------------------------------------------------------------------------

================================================================================
CREDENCIALES DE ACCESO
================================================================================

Una vez configurada la base de datos, puede iniciar sesion con:

    Usuario: admin@fumigil.com
    Contrasena: admin123

Para registrar nuevos clientes o trabajadores, use el modulo correspondiente
desde el dashboard.

================================================================================
MODULOS DEL SISTEMA
================================================================================

1. LOGIN
   - Autenticacion de usuarios
   - Validacion de credenciales

2. DASHBOARD
   - Panel principal con estadisticas
   - Acceso rapido a todos los modulos

3. CLIENTES (CRUD)
   - Registrar clientes (Persona Natural o Empresa)
   - Editar, eliminar y buscar clientes
   - Ver historial de servicios

4. TRABAJADORES (CRUD)
   - Registrar trabajadores
   - Asignar cargos
   - Control de fechas de ingreso

5. SERVICIOS (CRUD)
   - Registrar servicios (fumigacion, desinfeccion, etc.)
   - Asignar insumos a cada servicio
   - Precios base

6. INSUMOS (CRUD)
   - Registrar insumos quimicos y equipos
   - Control de precios de venta y costo

7. ORDENES DE SERVICIO
   - Crear ordenes con cliente, trabajador y servicio
   - Cambiar estados: PENDIENTE -> ASIGNADA -> EJECUTADA -> FINALIZADA
   - Agregar servicios adicionales a una orden existente
   - Ver detalle de servicios e insumos utilizados

8. CERTIFICADOS
   - Generacion automatica al finalizar orden
   - Validacion de certificados por codigo
   - Descarga de certificados en PDF

9. REPORTES
   - Ordenes por estado
   - Servicios mas solicitados
   - Clientes frecuentes
   - Ingresos por periodo
   - Exportacion a texto

================================================================================
ESTADOS DE UNA ORDEN DE SERVICIO
================================================================================

El flujo de estados es el siguiente:

    PENDIENTE -> ASIGNADA -> EJECUTADA -> FINALIZADA
         |           |            |            |
         └───────────┴────────────┴────────────┴──> CANCELADA

- PENDIENTE: Orden creada, esperando asignacion de tecnico
- ASIGNADA: Tecnico asignado a la orden
- EJECUTADA: Servicio realizado en campo
- FINALIZADA: Servicio completado, certificado generado
- CANCELADA: Orden cancelada

================================================================================
TRIGGERS EN LA BASE DE DATOS
================================================================================

El sistema cuenta con los siguientes triggers para automatizar procesos:

1. trg_generar_certificado
   - Se ejecuta cuando una orden cambia a FINALIZADA
   - Genera automaticamente un certificado

2. trg_evitar_certificado_duplicado
   - Evita crear dos certificados para la misma orden

3. trg_orden_ejecutada
   - Registra la fecha de ejecucion al cambiar a EJECUTADA

4. trg_orden_finalizada
   - Registra la fecha de finalizacion al cambiar a FINALIZADA

5. trg_validar_estado_orden
   - Valida que los cambios de estado sean logicos

6. trg_validar_cliente_activo
   - Verifica que el cliente exista y este activo

7. trg_validar_trabajador_activo
   - Verifica que el trabajador exista y este activo

8. trg_validar_precio_servicio
   - Valida que el precio del servicio sea mayor a 0

9. trg_validar_precio_insumo
   - Valida que el precio del insumo sea mayor a 0

10. trg_validar_cantidad_insumo
    - Verifica que la cantidad de insumo sea positiva

================================================================================
PROCEDIMIENTOS Y FUNCIONES PL/SQL
================================================================================

Procedimientos principales:
    - ingresar_cliente: Registra un nuevo cliente
    - ingresar_trabajador: Registra un nuevo trabajador
    - ingresar_servicio: Registra un nuevo servicio
    - ingresar_insumo: Registra un nuevo insumo
    - crear_orden_servicio: Crea una orden con su servicio
    - cambiar_estado_orden: Cambia el estado de una orden
    - agregar_inspeccion: Agrega una inspeccion a una orden

Funciones principales:
    - calcular_total_orden: Calcula el total de una orden
    - obtener_total_gastado_cliente: Total gastado por un cliente
    - obtener_ordenes_por_estado: Cuenta ordenes por estado
    - servicios_mas_usados: Retorna los servicios mas solicitados
    - obtener_clientes_con_mas_servicios: Top clientes frecuentes

================================================================================
DIAGRAMA DE BASE DE DATOS
================================================================================

Las tablas principales y sus relaciones:

    DEPARTAMENTO (1) -----< (N) CIUDAD (1) -----< (N) USUARIO
                                                          |
                                    +---------------------+---------------------+
                                    |                     |                     |
                              CLIENTE               TRABAJADOR               CARGO
                                    |                     |
                                    +----------+----------+
                                               |
                                        ORDEN_SERVICIO
                                               |
                        +----------------------+----------------------+
                        |                      |                      |
                  DETALLE_SERVICIO        CERTIFICADO           DETALLE_INSUMO
                        |                                             |
                   SERVICIO                                      INSUMO

================================================================================
SOLUCION DE PROBLEMAS COMUNES
================================================================================

1. Error: "No se pudo conectar a la base de datos"
   - Verificar que Oracle XE este ejecutandose
   - Verificar credenciales en DBConnection.java
   - Verificar que el puerto 1521 este disponible

2. Error: "ORA-01031: privileges insufficient"
   - Ejecutar: GRANT CREATE PROCEDURE, CREATE TRIGGER TO jose;

3. Error: "No se encuentra el archivo FXML"
   - Limpiar y reconstruir el proyecto
   - Verificar que los archivos .fxml esten en src/main/resources/fxml/

4. Error: "java.lang.NullPointerException en fechas"
   - Verificar que las fechas no sean nulas antes de formatearlas

5. Error al generar PDF: "NoClassDefFoundError: com/itextpdf/kernel/pdf/PdfDocument"
   - Verificar que la dependencia de iText este en pom.xml
   - Ejecutar: mvn clean compile

6. Error: "ORA-20001: Ya existe un certificado"
   - Eliminar el certificado duplicado: DELETE FROM CERTIFICADO WHERE id_orden_servicio = X;

================================================================================
COMMITS DE GIT (REFERENCIA)
================================================================================

El desarrollo se organizo en 40 commits distribuidos en:

- Sprint 0: Configuracion inicial (commits 1-3)
- Sprint 1: Modelos (commits 4-8)
- Sprint 2: DAOs (commits 9-16)
- Sprint 3: Services (commits 17-20)
- Sprint 4: Controladores y vistas (commits 21-30)
- Sprint 5: Refactorizacion y Clean Code (commits 31-35)
- Sprint 6: Pruebas y documentacion (commits 36-38)
- Sprint 7: Bonus (commits 39-40)

Cada commit sigue el formato: tipo(alcance): descripcion

Ejemplos:
    feat(model): agregar clase Usuario con atributos basicos
    fix(dao): corregir NullPointerException en conexion a BD
    docs: agregar JavaDoc a metodos publicos

================================================================================
INTEGRANTES DEL EQUIPO (OPCIONAL)
================================================================================

- Lider de proyecto: [Nombre]
- Programador 1: [Nombre]
- Programador 2: [Nombre]

================================================================================
LICENCIA
================================================================================

Este proyecto fue desarrollado con fines academicos para la asignatura
de Base de Datos / Programacion.

================================================================================
CONTACTO
================================================================================

Para soporte o consultas:
    Email: [tu_email@dominio.com]
    GitHub: [tu_usuario_github]

================================================================================
AGRADECIMIENTOS
================================================================================

Agradecimientos al profesor de la asignatura por la guia y seguimiento
durante el desarrollo del proyecto.

================================================================================
                    FIN DEL DOCUMENTO
================================================================================