package cl.duoc.speedfast;

import cl.duoc.speedfast.model.*;

public class Main {
    public static void main(String[] args) {
        Pedido[] pedidos = {
                new PedidoComida("001", "calle 123", 17, true),
                new PedidoEncomienda("002", "calle 456", 23, 53.0),
                new PedidoExpress("003", "calle 789", 14)
        };

        for (Pedido p : pedidos) {
            p.ejecutarProceso();
        }
    }
}
