package cl.duoc.speedfast.model;

public class PedidoExpress extends Pedido {
    private static final double LIMITE_DISTANCIA_KM = 20;

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super("PEDIDO EXPRESS", idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    protected boolean validarPedido() {
        System.out.println("Verificando que la distancia esté dentro del límite permitido...");

        if (getDistanciaKm() > LIMITE_DISTANCIA_KM) {
            System.out.println("[ERROR] No es posible realizar un envío express por la distancia.\n");
            return false;
        }

        System.out.println("[OK] Distancia dentro del límite.\n");
        return true;
    }

    @Override
    protected int calcularTiempoEntrega() {
        // 10m tiempo base, pero si > 5km, se agregan 5m extra
        return (getDistanciaKm() > 5) ? 15 : 10;
    }
}
