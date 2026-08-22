🚚 Speed Fast App
---  
Actividad formativa 2 (Semana 2)

### Autor:

Alonso Antonio Bonansco Vergara  
Desarrollo Orientado a Objetos II - 004A  
Analista Programador Computacional

---

### 📖 Descripción:

Este proyecto es una aplicación desarrollada en **Java** y **Maven** que simula el flujo logístico de una empresa de reparto a
domicilio. La columna vertebral de la aplicación implementa el Patrón de Diseño Conductual Template Method para orquestar de manera centralizada el ciclo de vida secuencial e inmutable de cada despacho.

### 🚀 Explicación del Patrón de Diseño Template Method
Se implementa este patrón conductual para definir el esqueleto inmutable de un algoritmo en la superclase (`public final void ejecutarProceso()`), encapsulando el orden secuencial del negocio y protegiendo el flujo mediante el uso estricto de modificadores de acceso para evitar fugas de arquitectura. La jerarquía de control se distribuye estratégicamente según su nivel de visibilidad:
* **`public`:** Expone únicamente el método plantilla (`ejecutarProceso()`) como el botón de encendido oficial hacia el entorno de ejecución (`Main.java`).
* **`protected`:** Oculta los pasos abstractos variables (`validarPedido()` y `calcularTiempoEntrega()`) del mundo exterior, pero los desbloquea exclusivamente para que las subclases personalicen su comportamiento interno mediante `@Override`.
* **`private`:** Sella por completo las rutinas fijas y procedimentales (`mostrarResumen()` y `realizarEntrega()`) dentro del contexto estricto de la superclase, garantizando que ningún componente externo altere el comportamiento base del sistema.


---

### 📂 Estructura:
#### *Nota: El Main queda intencionalmente en la raíz del paquete principal.

```text
speed-fast-semana-2/
├── .gitignore                              
├── pom.xml                                 
└── src/
    └── main/
        └── java/                           
            └── cl/
                └── duoc/
                    └── speedfast/          
                        ├── Main.java                    # Punto de entrada de la aplicación
                        └── model/                       # Clases y entidades del dominio
                            ├── Pedido.java              - Superclase
                            ├── PedidoComida.java        - Subclase
                            ├── PedidoEncomienda.java    - Subclase
                            └── PedidoExpress.java       - Subclase
```

---

### 🛠️ Instrucciones para clonar y ejecutar

Requisitos del sistema:

* **JDK:** Java 25 (LTS) o superior

1. Clonar el repositorio desde la terminal de la computadora o IDE:  
   git clone https://github.com/alonsobonansco/speed-fast-semana2.git
2. Ir a File →️ Open y seleccionar la carpeta raíz del proyecto (la carpeta que contiene el archivo pom.xml).
3. Ejecutar el `Main` desde su clase en el paquete raíz `cl.duoc.speedfast`



