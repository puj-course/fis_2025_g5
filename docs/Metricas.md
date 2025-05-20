# Implementaciones de Métricas de Calidad

## Complejidad Ciclomática

Esta métrica mide la cantidad de caminos independientes en el código y se usa para estimar su complejidad lógica, controlando estructuras como `if`, `else`, `while`, `try-catch`, etc.
Utilizando la formula:
Complejidad = N° de decisiones + 1

### Ejemplo usando nuestro código

La función `editarInfo` tiene **5 decisiones** (3 `if-else` y 2 `try-catch`).

**Fórmula:**

Complejidad = N° de decisiones + 1

Complejidad = 5 + 1 = 6


### Interpretación del resultado

| Valor de complejidad | Nivel        | Interpretación                                                 |
|----------------------|--------------|----------------------------------------------------------------|
| 1–4                  | Buena        | Código simple, fácil de leer, probar y mantener.              |
| 5–10                 | Aceptable    | Ligeramente complejo. Mantenible, pero podría mejorar.        |
| 11–20                | Alta         | Muy complejo. Requiere refactorización.                       |
| 21 o más             | Muy alta     | Inmanejable. Difícil de probar o mantener correctamente.      |

---

### Aplicación de la métrica en funciones

#### `initialize()` en `EditarController`
- 4 `if-else` + 1 `try-catch` = 5 decisiones  
- **Complejidad:** 5 + 1 = **6** → Aceptable

#### `obtenerEmprendimiento()` en `EmprendimientosController`
- 1 `try-catch` + 1 `while` + 1 `for` = 3 decisiones  
- **Complejidad:** 3 + 1 = **4** → Buena

#### `registrar()` en `SignupUController`
- 1 `if-else` + 1 `try-catch` = 2 decisiones  
- **Complejidad:** 2 + 1 = **3** → Buena

---

### Cálculo de complejidad de una clase completa: `MainController`

- `initialize()` → 1 `try-catch`  
- `goToTelas()` → 1 `try-catch`  
- `goToEmprendimientos()` → 1 `try-catch`  
- `goToProveedores()` → 1 `try-catch`  
- `hayUsuario()` → 1 `if` + 1 `if-else`

**Total de decisiones:** 6  
**Complejidad:** 6 + 1 = **7** → Aceptable

---

### Complejidad ciclomática del código completo

| Clase                     | Complejidad |
|---------------------------|-------------|
| EditarController          | 13          |
| LogInController           | 6           |
| MainController            | 9           |
| SignupEController         | 4           |
| SignupPController         | 4           |
| SignupUController         | 3           |
| EmprendimientosController | 11          |
| ProveedorController       | 11          |
| TelasController           | 11          |
| DBConnection              | 4           |
| SMS                       | 3           |
| User                      | 2           |
| Utilityes                 | 1           |
| **Total**                 | **82 + 1 = 83** |

**Conclusión:**  
Una complejidad total de 83 es razonable para un proyecto mediano-pequeño. Algunas clases superan el valor de 10, lo que sugiere que podrían beneficiarse de una futura refactorización o división de responsabilidades.

---

## Longitud de Código

Esta métrica mide cuán extenso es el código, lo cual impacta su mantenimiento y posibilidad de errores.

### Longitud por clase:

| Clase                      | Líneas de código |
|----------------------------|------------------|
| App.java                   | 34               |
| DBConnection.java          | 39               |
| EditarController.java      | 141              |
| Emprendimiento.java        | 62               |
| EmprendimientosController  | 193              |
| LogInController.java       | 80               |
| MainController.java        | 115              |
| Proveedor.java             | 62               |
| ProveedorController.java   | 192              |
| SMS.java                   | 40               |
| SignupController.java      | 65               |
| SignupEController.java     | 86               |
| SignupPController.java     | 86               |
| SignupUController.java     | 68               |
| Tela.java                  | 53               |
| TelasController.java       | 191              |
| User.java                  | 50               |
| Utilityes.java             | 19               |
| **Total del proyecto**     | **1576 líneas**  |

**Conclusión:**  
Cada clase tiene una longitud razonable (ninguna supera las 200 líneas), lo cual facilita su mantenimiento y pruebas.  
Con 1576 líneas en total, el proyecto puede considerarse de **tamaño mediano**. Mientras se mantengan buenas prácticas, será fácil de probar y mantener.


