public class Main {
    public static void main(String[] args) {
        System.out.println("Mando a Pedrito a comprar un snicker por 200 pesos con una moneda de 1500.");
        Moneda m = new Moneda1500();
        Expendedor e = new Expendedor(1);
        Comprador c;
        try {
            c = new Comprador(m,TipoProducto.SNICKERS,e);
            System.out.println("Le pregunto a Pedrito que se esta comiendo luego de volver del mandado,");
            System.out.println("él me dice que unos " + c.queConsumiste() + " y que le sobro " + c.cuantoVuelto() + ".");
            System.out.println("Me emputo con Pedrito por comerse el snicker q era para mi.\n\n");
        } catch(Exception a) {
            System.out.println(a);
        }

        System.out.println("Mando a Pedrito a comprar otro snicker ahora para mi con otra moneda de 1500.");
        m = new Moneda1000();
        try {
            c = new Comprador(m,TipoProducto.SNICKERS,e);
        } catch(Exception a) {
            System.out.println("Le pregunto a Pedrito si esta vez si me trajo mi pedido,");
            System.out.println("él me dice que la maquina le dio un error que decia \"" + a + "\" y le devolvio la moneda de " + e.getVuelto().getValor() + ".");
            System.out.println("Me emputo el doble con Pedrito porque ya no podre comer snickers.\n\n");
        }

        System.out.println("Esta vez mando a Pedrito a comprar una cocacola con una moneda de 1500.");
        e = new Expendedor(1);
        m = new Moneda1000();
        try {
            c = new Comprador(m,TipoProducto.COCA,e);
        } catch(Exception a) {
            System.out.println("Le pregunto a Pedrito si me trajo mi cocacola,");
            System.out.println("él me dice que la maquina le dio otro error que decia \"" + a + "\".");
            System.out.println("Me emputo con el gobierno que tiene todo tan caro.\n\n");
        }

        System.out.println("Le paso una moneda de 1 millon de pesos para que me compre mi coca sin problemas.");
        m = null;
        try {
            c = new Comprador(m,TipoProducto.SPRITE,e);
        } catch(Exception a) {
            System.out.println("Le pregunto a Pedrito si le alcanso para mi cocacola,");
            System.out.println("él me dice que la maquina nuevamente no me quiso vender y decia \"" + a + "\".");
            System.out.println("Me emputo con la vida al descubrir que mi moneda era falsa.");
        }

    }
}
