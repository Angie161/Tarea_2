public enum Precio {
    VALCOCA(2000),
    VALSPRITE(1300),
    VALFANTA(1400),
    VALSNICK(200),
    VALSUPER8(300);

    private int precio;

    private Precio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
