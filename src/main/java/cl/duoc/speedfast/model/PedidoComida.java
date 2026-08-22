package cl.duoc.speedfast.model;

/**
 * Subclase de Pedido. Su atributo propio es mochilaEnbuenEstado para verificar que
 * la comida llegue en óptimas condiciones.
 */
public class PedidoComida extends Pedido {
    private boolean mochilaEnBuenEstado;

    /**
     * Construye un pedido de comida.
     *
     * @param idPedido            Identificador único de la orden.
     * @param direccionEntrega    Destino físico del despacho.
     * @param distanciaKm         Trayecto en kilómetros.
     * @param mochilaEnBuenEstado true si la mochila térmica está operativa; false si está dañada.
     */
    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm, boolean mochilaEnBuenEstado) {
        super("PEDIDO COMIDA", idPedido, direccionEntrega, distanciaKm);
        this.mochilaEnBuenEstado = mochilaEnBuenEstado;
    }

    @Override
    protected boolean validarPedido() {
        System.out.println("Verificando que la mochila térmica esté en buen estado...");

        if (!mochilaEnBuenEstado) {
            System.out.println("[ERROR] Mochila térmica en mal estado.\n");
            return false;
        }

        System.out.println("[OK] Mochila térmica en buen estado.\n");
        return true;
    }

    @Override
    protected int calcularTiempoEntrega() {
        // 15m + 2m x cada kilometro
        return (int) (15 + 2 * getDistanciaKm());
    }

    public void setMochilaEnBuenEstado(boolean mochilaEnBuenEstado) {
        this.mochilaEnBuenEstado = mochilaEnBuenEstado;
    }
}
