🚚 Speed Fast App
---  
Actividad formativa 1 (Semana 1)

### Autor:

Alonso Antonio Bonansco Vergara  
Desarrollo Orientado a Objetos II - 004A  
Analista Programador Computacional

---

### Descripción:

Este proyecto es una aplicación desarrollada en **Java** que simula el flujo logístico de una empresa de reparto a
domicilio. El objetivo principal es modelar cómo operan diferentes tipos de despachos en el mundo real, controlando el
ciclo de vida de cada orden mediante validaciones estrictas y el uso de buenas prácticas de programación.

### Conceptos de POO utilizados:

* **Herencia y Clase Abstracta:** Se utiliza una superclase abstracta `Pedido` que centraliza los datos comunes y define
  el comportamiento base para las subclases `PedidoComida`, `PedidoEncomienda` y `PedidoExpress`.
* **Polimorfismo Dinámico (Sobrescritura):** Cada subtipo de pedido implementa su propia lógica interna para evaluar si
  el despacho es viable (control de peso, distancia o estado de equipamiento) usando `@Override`.
* **Polimorfismo Estático (Sobrecarga):** Los métodos de asignación permiten dos fases cronológicas: una verificación
  inicial sin argumentos y la asignación final con parámetros.
* **Encapsulamiento e Inmutabilidad:** Se prescinde de getters y setters innecesarios. Las variables críticas de
  distancia y peso se protegen mediante el uso de `final` para evitar la corrupción de datos en tiempo de ejecución.

---

### Estructura:

```text
📁 src/
├── 📁 app/                            # Punto de entrada de la aplicación
│   └── 📄 Main.java 
└── 📁 model/                          # Clases del dominio
    ├── 📄 Pedido.java
    ├── 📄 PedidoComida.java                   
    ├── 📄 PedidoEncomienda.java              
    └── 📄 PedidoExpress.java
```

---

### Instrucciones para clonar y ejecutar

Requisitos del sistema:

* **JDK:** Java 25 (LTS) o superior

1. Clonar el repositorio desde la terminal en Intellij:  
   git clone https://github.com/alonsobonansco/SpeedFastApp.git
2. Marcar la carpeta `src` como "sources root" haciendo click derecho en ella
   -> Mark Directory As -> Sources Root.
3. Ejecutar el main desde su clase en el paquete app

