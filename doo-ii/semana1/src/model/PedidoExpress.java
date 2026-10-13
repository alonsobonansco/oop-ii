package model;

/**
 * Subclase de Pedido. Sus atributos propios son LIMITE_DISTANCIA_KM y distanciaDelObjetivo.
 * El primero es el valor límite que un repartidor puede estar del objetivo para realizar la
 * entrega y el segundo, la distancia real a la que se encuentran.
 */
public class PedidoExpress extends Pedido {
    private static final double LIMITE_DISTANCIA_KM = 100;
    private final double distanciaDelObjetivo;

    public PedidoExpress(String idPedido, String tipoPedido, String direccionEntrega, double distanciaDelObjetivo) {
        super(idPedido, tipoPedido, direccionEntrega);

        if (distanciaDelObjetivo <= 0) {
            throw new IllegalArgumentException("La distancia del objetivo deber ser válida.");
        }
        this.distanciaDelObjetivo = distanciaDelObjetivo;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido express]\nVerificando que haya un repartidor cerca del objetivo...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (distanciaDelObjetivo > LIMITE_DISTANCIA_KM) {
            System.out.println("→ [ERROR] El repartidor se encuentra lejos del objetivo. No es posible realizar el envío express.\n\n");
            return;
        }

        System.out.println("→ Repartidor cerca y con disponibilidad inmediata [OK]\n"
                + "→ Pedido asignado a " + nombreRepartidor + "\n\n");
    }
}
