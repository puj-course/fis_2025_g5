# fis_2025_g5
fis_2025_g5

# 👕 ROPA - Moda Consciente

**Concientización sobre el impacto ambiental de la industria de la moda**

---

## 📖 Descripción

**ROPA** es una plataforma web diseñada para conectar emprendedores del sector moda con proveedores textiles, fomentando el consumo responsable y la transparencia ambiental. A través de esta herramienta, los usuarios pueden conocer el impacto ambiental de distintos tipos de tejidos, comparar alternativas más sostenibles y acceder a emprendimientos alineados con los principios de la moda ética.

Este proyecto surge como una respuesta a la creciente preocupación por la contaminación de la industria textil, una de las más contaminantes del mundo, y busca empoderar a los actores del sector con información confiable, visual y educativa.

---

## 🚀 Características Principales

- 🌍 Información sobre el daño ambiental de materiales como algodón, poliéster, viscosa, entre otros.
- 🛍️ Promoción de emprendimientos sostenibles, visibilizando alternativas éticas en la moda.
- 📊 Visualización de datos y estadísticas relevantes sobre contaminación hídrica, emisión de CO₂, uso energético, etc.
- 🧵 Conexión entre proveedores y emprendedores, facilitando decisiones de compra más conscientes.

---

## 🧠 Arquitectura y Diseño

El sistema está estructurado bajo una arquitectura cliente-servidor, siguiendo el patrón Modelo Vista Controlador (MVC). Además, se adoptaron principios de desacoplamiento y responsabilidad única, facilitando la mantenibilidad del código y su escalabilidad.

### 🔷 Componentes:

- **Frontend**: Interfaz desarrollada con JavaFX, priorizando la experiencia de usuario.
- **Backend**: Lógica de negocio en Java.
- **Base de datos**: MySQL, con tablas optimizadas para categorías de tela, proveedores y emprendimientos.
- **Automatización CI/CD**: GitHub Actions.

---

## ⚙️ Tecnologías Utilizadas

| Categoría              | Tecnología            |
|------------------------|------------------------|
| Lenguajes              | Java, SQL              |
| Interfaz gráfica       | JavaFX                 |
| Base de datos          | MySQL                  |
| Automatización y DevOps| GitHub Actions         |
| Control de versiones   | Git y GitHub           |
| Metodología            | Scrum + Poker Planning |

---

## 🛠️ Estructura del Proyecto
ROPA
├── /src # Código fuente Java
├── /tests # Pruebas unitarias
├── /docs # Documentación del sistema
├── /.github/workflows # Pipelines de GitHub Actions
├── README.md
└── pom.xml # Configuración Maven

---

## 🔁 Metodología de Desarrollo

El proyecto se desarrolla bajo la metodología ágil Scrum, con iteraciones semanales (sprints), usando historias de usuario, sub-issues y planificación con Poker Scrum. Se definieron milestones temáticos (base de datos, UI, backend, etc.), que permiten visualizar el progreso por módulos.

### Herramientas de gestión:

- Tablero Kanban: Seguimiento de issues (`Backlog`, `Ready`, `In Progress`, `Done`).
- 7 sprints ejecutados hasta la fecha.
- Issues organizados por prioridad, asignación y complejidad.

---

## ⚙️ DevOps y Automatización

Se configuraron dos pipelines con GitHub Actions:

### 🔧 `cd.yml`
- Compilación automática con Maven
- Ejecución de pruebas
- Validación de artefactos
- Subida de resultados

### 🧩 `estructura.yml`
- Validación de estructura del repositorio
- Generación de informes simulados
- Subida de artefactos

Estos procesos se ejecutan en cada push a ramas clave (`main`, `develop`, `workflow-patch`), garantizando la integridad y la calidad continua del proyecto.

---

📚 Documentación Adicional
Diagramas de clases y entidad-relación

Mockups de interfaz

Guía de usuario

Infografía de impacto ambiental por tela (incluida en /docs)

Reportes de sprints y métricas de rendimiento

📈 Impacto Esperado
ROPA busca transformar la forma en que consumimos moda, empoderando tanto a consumidores como a emprendedores con datos y herramientas para elegir responsablemente. A través de tecnología, diseño y educación ambiental, se construye un puente hacia una industria textil más ética y sostenible.

📩 Contacto
Para dudas, sugerencias o contribuciones, contacta a:

Juan Felipe Gutiérrez

Santiago Galindo

Laura Sofía Aponte

Juan Esteban Bello

  
## Infografia sobre el proyecto
![](https://github.com/puj-course/fis_2025_g5/blob/786692b24da2ee1617bae19a0291ce3abe01e25b/ROPA%20.png)

.
