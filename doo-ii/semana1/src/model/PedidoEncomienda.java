package model;

/**
 * Subclase de Pedido. Su atributos son CAPACIDAD_MAXIMA y pesoEncomienda. El primero es
 * el valor máximo permitido para el transporte y el personal, el segundo es el peso real
 * de la encomienda a enviar.
 */
public class PedidoEncomienda extends Pedido {
    private static final double CAPACIDAD_MAXIMA_KG = 60;
    private final double pesoEncomienda;

    public PedidoEncomienda(String idPedido, String tipoPedido, String direccionEntrega, double pesoEncomienda) {
        super(idPedido, tipoPedido, direccionEntrega);

        if (pesoEncomienda <= 0) {
            throw new IllegalArgumentException("El peso de la encomienda debe ser válido.");
        }
        this.pesoEncomienda = pesoEncomienda;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido encomienda]\nVerificando que el peso de la encomienda no exceda el límite...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (pesoEncomienda > CAPACIDAD_MAXIMA_KG) {
            System.out.println("→ [ERROR] El peso de la encomienda supera el límite permitido. No es posible realizar la encomienda.\n\n");
            return;
        }

        System.out.println("→ Peso de la encomienda [OK]\n"
                + "→ Pedido asignado a " + nombreRepartidor + "\n\n");
    }
}
