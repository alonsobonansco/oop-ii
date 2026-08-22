package cl.duoc.speedfast.model;

public class PedidoExpress extends Pedido {
    private static final double LIMITE_DISTANCIA_KM = 20;

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super("PEDIDO EXPRESS", idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    protected int calcularTiempoEntrega() {
        // 10m tiempo base, pero si > 5km, se agregan 5m extra
        return (getDistanciaKm() > 5) ? 15 : 10;
    }
}
