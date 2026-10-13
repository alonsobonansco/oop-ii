package app;

import model.*;

/**
 * Punto de entrada de la aplicación. Asigna objetos de las subclases a variables de la superclase Pedido
 * y llama a sus métodos para demostrar sobrescritura y sobrecarga.
 *
 * @author Alonso Bonansco
 * @version 1.0.0
 * @since Semana 1
 */
public class Main {
    public static void main(String[] args) {
        // Asignación de subclase a una referencia de la superclase (Upcasting)
        Pedido comida = new PedidoComida(
                "001", "Comida", "calle123", true);
        Pedido encomienda = new PedidoEncomienda(
                "002", "Encomienda", "calle456", 28.0);
        Pedido express = new PedidoExpress(
                "003", "Express", "calle789", 55.0);

        comida.asignarRepartidor();
        comida.asignarRepartidor("Carlos");

        encomienda.asignarRepartidor();
        encomienda.asignarRepartidor("José");

        express.asignarRepartidor();
        express.asignarRepartidor("Jaime");
    }
}
