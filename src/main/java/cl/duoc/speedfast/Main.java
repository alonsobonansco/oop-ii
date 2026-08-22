package cl.duoc.speedfast;

import cl.duoc.speedfast.model.*;

/**
 * Punto de entrada de la aplicación. Asigna objetos de las subclases a variables de
 * la superclase Pedido y llama a sus métodos para demostrar sobrescritura y sobrecarga.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Pedido[] pedidos = {
                    new PedidoComida("001", "calle 123", 17, true),
                    new PedidoEncomienda("002", "calle 456", 23, 53.0),
                    new PedidoExpress("003", "calle 789", 14)
            };

            for (Pedido p : pedidos) {
                p.ejecutarProceso();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Proceso de reparto cancelado.");
        }
    }
}
