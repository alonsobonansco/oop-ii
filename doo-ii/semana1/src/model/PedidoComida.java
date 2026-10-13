package model;

/**
 * Subclase de Pedido. Su atributo propio es mochilaEnbuenEstado para verificar que
 * la comida llegue en óptimas condiciones.
 */
public class PedidoComida extends Pedido {
    private boolean mochilaEnBuenEstado;

    public PedidoComida(String idPedido, String tipoPedido, String direccionEntrega, boolean mochilaEnBuenEstado) {
        super(idPedido, tipoPedido, direccionEntrega);
        this.mochilaEnBuenEstado = mochilaEnBuenEstado;
    }

    /**
     * Método heredado de la superclase Pedido. Debe ser sobrescrito con Override. No recibe parámetros.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido comida]\nVerificando que la mochila térmica esté en buen estado...");
    }

    /**
     * Método sobrescrito que implementa la lógica propia de esta subclase,
     * evidenciando comportamiento del método sobrecargado de la superclase.
     *
     * @param nombreRepartidor El nombre del repartidor.
     */
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (!mochilaEnBuenEstado) {
            System.out.println("→ [ERROR] Mochila térmica en mal estado. No es posible realizar un pedido de comida.\n\n");
            return;
        }

        System.out.println("→ Mochila térmica [OK]\n"
                + "→ Pedido asignado a " + nombreRepartidor + "\n\n");
    }

    public void setMochilaEnBuenEstado(boolean mochilaEnBuenEstado) {
        this.mochilaEnBuenEstado = mochilaEnBuenEstado;
    }
}
