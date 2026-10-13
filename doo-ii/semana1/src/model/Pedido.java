package model;

/**
 * Clase genérica de un pedido y superclase de subtipos de pedidos.
 * Es abstract porque no necesita ser instanciada.
 */
public abstract class Pedido {
    private final String idPedido;
    private final String tipoPedido;
    private String direccionEntrega;

    public Pedido(String idPedido, String tipoPedido, String direccionEntrega) {
        if (idPedido == null || idPedido.isBlank()) {
            throw new IllegalArgumentException("El ID del pedido no puede estar vacío.");
        }
        if (tipoPedido == null || tipoPedido.isBlank()) {
            throw new IllegalArgumentException("El tipo de pedido debe ser válido.");
        }
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        setDireccionEntrega(direccionEntrega);
    }

    // Métodos que las subclases deben implementar
    // ===========================================
    public abstract void asignarRepartidor();

    public abstract void asignarRepartidor(String nombreRepartidor);
    // ===========================================

    public void setDireccionEntrega(String direccionEntrega) {
        if (direccionEntrega == null || direccionEntrega.isBlank()) {
            throw new IllegalArgumentException("La dirección de entrega debe ser válida.");
        }
        this.direccionEntrega = direccionEntrega;
    }
}
