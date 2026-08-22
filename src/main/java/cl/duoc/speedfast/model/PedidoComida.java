package cl.duoc.speedfast.model;

public class PedidoComida extends Pedido {
    private boolean mochilaEnBuenEstado;

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm, boolean mochilaEnBuenEstado) {
        super("PEDIDO COMIDA", idPedido, direccionEntrega, distanciaKm);
        this.mochilaEnBuenEstado = mochilaEnBuenEstado;
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
