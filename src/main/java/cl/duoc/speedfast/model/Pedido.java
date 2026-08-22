package cl.duoc.speedfast.model;

/**
 * Clase genérica de un pedido y superclase de subtipos de pedidos.
 * Es abstract porque no necesita ser instanciada.
 */
public abstract class Pedido {
    private final String tipoPedido;
    private final String idPedido;
    private String direccionEntrega;
    private final double distanciaKm;

    /**
     * Constructor que inicializa el estado base e inmutable de un pedido para las subclases.
     *
     * @param tipoPedido       Tipo de pedido.
     * @param idPedido         Identificador único de la orden.
     * @param direccionEntrega Destino físico del despacho.
     * @param distanciaKm      Trayecto en kilómetros.
     * @throws IllegalArgumentException Si el idPedido o la direccionEntrega están vacíos, o
     *                                  si la distancia es menor o igual a cero.
     */
    public Pedido(String tipoPedido, String idPedido, String direccionEntrega, double distanciaKm) {
        if (idPedido == null || idPedido.isBlank()) {
            throw new IllegalArgumentException("El ID del pedido no puede estar vacío.");
        }
        if (distanciaKm <= 0) {
            throw new IllegalArgumentException("La distancia debe ser válida.");
        }
        this.tipoPedido = tipoPedido;
        this.idPedido = idPedido;
        setDireccionEntrega(direccionEntrega);
        this.distanciaKm = distanciaKm;
    }

    /**
     * Orquesta el ciclo de vida secuencial del despacho (Template Method).
     * Muestra el resumen, ejecuta la validación de la subclase y procesa la entrega.
     */
    public final void ejecutarProceso() {
        mostrarResumen();
        if (!validarPedido()) {
            System.out.println("→ No es posible realizar el envío.\n\n");
            return;
        }
        realizarEntrega();
    }

    /**
     * Evalúa si las condiciones operativas de la subclase permiten el envío.
     * Cada tipo de pedido debe implementar sus propias reglas de negocio.
     *
     * @return true si el pedido pasa los controles; false si es rechazado.
     */
    protected abstract boolean validarPedido();

    /**
     * Calcula el tiempo estimado que tardará el reparto en llegar al destino.
     * Cada subclase implementa su propia lógica de estimación.
     *
     * @return Tiempo estimado para la entrega en minutos.
     */
    protected abstract int calcularTiempoEntrega();

    private void realizarEntrega() {
        System.out.println("✔ El pedido se encuentra en reparto.\n\n");
    }

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
