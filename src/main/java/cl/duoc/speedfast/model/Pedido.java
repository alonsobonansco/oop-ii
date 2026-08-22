package cl.duoc.speedfast.model;

public abstract class Pedido {
    private final String tipoPedido;
    private final String idPedido;
    private String direccionEntrega;
    private final double distanciaKm;

    public Pedido(String tipoPedido, String idPedido, String direccionEntrega, double distanciaKm) {
        this.tipoPedido = tipoPedido;
        this.idPedido = idPedido;
        setDireccionEntrega(direccionEntrega);
        this.distanciaKm = distanciaKm;
    }

    // Template method
    public final void ejecutarProceso() {
        mostrarResumen();
        if (!validarPedido()) {
            System.out.println("→ No es posible realizar el envío.\n\n");
            return;
        }
        realizarEntrega();
    }

    protected abstract boolean validarPedido();

    private void realizarEntrega() {
        System.out.println("✔ El pedido se encuentra en reparto.\n\n");
    }

    protected abstract int calcularTiempoEntrega();

    private void mostrarResumen() {
        String textoResumen = """
                ===================
                %s #%s
                ===================
                
                Dirección: %s
                Distancia: %.1f km
                Tiempo estimado de entrega: %d minutos
                """.formatted(
                getTipoPedido(), getIdPedido(),
                getDireccionEntrega(),
                getDistanciaKm(),
                calcularTiempoEntrega()
        );

        System.out.println(textoResumen);
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        if (direccionEntrega == null || direccionEntrega.isBlank()) {
            throw new IllegalArgumentException("La dirección de entrega debe ser válida.");
        }
        this.direccionEntrega = direccionEntrega;
    }
}
