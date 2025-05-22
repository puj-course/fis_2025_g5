# 🧵 Plataforma Web Textil Sostenible

Repositorio oficial: [fis_2025_g5 - GitHub](https://github.com/puj-course/fis_2025_g5)

## 📖 Descripción General

Plataforma web que conecta emprendedores y proveedores del sector textil, ofreciendo información transparente sobre el impacto ambiental de los materiales. Tiene como objetivo educar al consumidor, promover alternativas sostenibles y apoyar emprendimientos responsables dentro de la industria de la moda.

---

##  Características principales

-  Información sobre el impacto ambiental de materiales textiles.
-  Conexión entre proveedores y emprendedores sostenibles.
-  Estadísticas sobre contaminación en la industria textil.
-  Clasificación ambiental de tejidos (escala 1–10).
-  Catálogo de textiles y fichas técnicas educativas.

---

##  Tecnologías utilizadas

- **Frontend**: JavaFX  
- **Backend**: Java  
- **Base de Datos**: MySQL  
- **Control de versiones**: GitHub  
- **CI/CD**: GitHub Actions (2 pipelines activos)  
- **Infraestructura y Hosting**: Despliegue automatizado vía pipeline

---

## ⚙️ Arquitectura y Patrones

- **Arquitectura MVC**:
  - **Modelo**: `User`, `Tela`, `Proveedor`, `Emprendimiento`
  - **Vista**: Interfaces JavaFX (`Main.fxml`, `Login.fxml`, etc.)
  - **Controlador**: `MainController`, `LoginController`, `SignupControllers`, etc.
- **Patrones GoF Aplicados**:
  -  **Singleton**: `User`, `SMS`, `DBConnection`
  -  **Builder**: construcción flexible de objetos (`Tela`, `Proveedor`, `Emprendimiento`)
  -  **Iterator (implícito)**: uso de colecciones para alimentar las vistas

---

##  Métricas de Calidad del Código

###  Complejidad Ciclomática Total: 83

- Rango aceptable para un proyecto mediano.
- Clases con mayor complejidad (≥11): `EditarController`, `EmprendimientosController`, `ProveedorController`, `TelasController`.

###  Longitud del Código

- Total del proyecto: **1576 líneas de código**
- Ninguna clase supera las 200 líneas, lo cual mejora la mantenibilidad

---

##  Pruebas Unitarias

- Implementadas con **JUnit 5**
- Casos cubiertos:
  - Verificación de conexión (`DBConnection`)
  - Comportamiento de instancias únicas (`SMS`, `User`)
  - Validación de estructuras construidas con Builder
  - Validación de URLs (`Utilityes`)
  - Controladores y lógica de navegación

---

##  CI/CD con GitHub Actions

- **cd.yml**: Compila el proyecto, ejecuta pruebas y sube artefactos `.jar`
- **estructura.yml**: Valida la estructura del repositorio y genera informe automático

Ambos pipelines se ejecutan en cada push o pull request hacia `main` y `Feature-Develop`.

---

##  Metodología y Organización

- Se implementó **Scrum** durante 13 sprints
- Planeación mediante historias de usuario y sub-issues
- Seguimiento con:
  - Tablero Kanban
  - Poker Scrum para estimaciones
  - Gráficos de burndown y milestones

---

##  Implementación de Módulos Clave

-  **Módulo de SMS**: Envía notificaciones usando Twilio (Singleton)
-  **Validación de enlaces**: Método `Utilityes.urlValida()`
-  **Gestión de usuario activo**: Clase `User` mantiene la sesión

---

##  Descarga y Ejecución de la Aplicación

###  Requisitos previos

- JDK 17 o superior
- JavaFX SDK instalado y vinculado en el entorno (IDE o terminal)
- MySQL corriendo y configurado con la base de datos `ropa.sql`

###  Instrucciones

1. Clona el repositorio:
   ```bash
   git clone https://github.com/puj-course/fis_2025_g5.git
   Abre el proyecto en tu IDE (recomendado: IntelliJ IDEA o Eclipse).

2. Configura el SDK de Java y la librería de JavaFX.

3. Asegúrate de que la base de datos esté creada y configurada (ver clase DBConnection para las credenciales).

4. Ejecuta la clase App.java.

5. También puedes compilar el proyecto desde terminal:
   javac -cp .;path\to\javafx\lib\* g5/ROPA/App.java
   java -cp .;path\to\javafx\lib\* g5.ROPA.App
   

##Impacto Esperado

-Educar al consumidor sobre el impacto ambiental de sus decisiones.
-Apoyar emprendimientos sostenibles.
-Base para un futuro marketplace de moda ética.
