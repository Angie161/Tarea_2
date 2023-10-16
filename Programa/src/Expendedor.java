public class Expendedor{
    private Deposito<Bebida> coca = new Deposito<>();
    private Deposito<Bebida> sprite= new Deposito<>();
    private Deposito<Bebida> fanta= new Deposito<>();
    private Deposito<Dulce> snikers= new Deposito<>();
    private Deposito<Dulce> super8= new Deposito<>();

    private Deposito<Moneda> monVu = new Deposito<>();


    public Expendedor(int numProductos){
        for(int i=0; i<numProductos;i++){
            coca.add(new CocaCola(100+i));
            sprite.add(new Sprite(200+i));
            fanta.add(new Fanta(300+i));
            snikers.add(new Snickers(400+i));
            super8.add(new Super8(500+i));
        }
    }
    public Producto comprarProducto(Moneda m,TipoProducto cual) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {

        if(m==null){
            throw new PagoIncorrectoException();
        }

        switch (cual) {
            case COCA:
                if (m.getValor() >= Precio.VALCOCA.getPrecio() && coca.check() != 0) {
                    for (int i = 0; i < (m.getValor() - Precio.VALCOCA.getPrecio()) / 100; i++) {
                        monVu.add(new Moneda100());
                    }
                    return coca.get();
                }
                else {
                    monVu.add(m);
                    if(m.getValor()<Precio.VALCOCA.getPrecio()){
                        throw new PagoInsuficienteException();
                    }
                    else if(coca.check()==0) {
                        throw new NoHayProductoException();
                    }
                }

            case SPRITE:
                if (m.getValor() >= Precio.VALSPRITE.getPrecio() && sprite.check() != 0) {
                    for (int i = 0; i < (m.getValor() - Precio.VALSPRITE.getPrecio()) / 100; i++) {
                        monVu.add(new Moneda100());
                    }
                    return sprite.get();
                }
                else {
                    monVu.add(m);
                    if(m.getValor()<Precio.VALSPRITE.getPrecio()){
                        throw new PagoInsuficienteException();
                    }
                    else if(sprite.check()==0) {
                        throw new NoHayProductoException();
                    }
                }

            case FANTA:
                if (m.getValor() >= Precio.VALFANTA.getPrecio() && fanta.check() != 0) {
                    for (int i = 0; i < (m.getValor() - Precio.VALFANTA.getPrecio()) / 100; i++) {
                        monVu.add(new Moneda100());
                    }
                    return fanta.get();
                }
                else {
                    monVu.add(m);
                    if(m.getValor()<Precio.VALFANTA.getPrecio()){
                        throw new PagoInsuficienteException();
                    }
                    else if(fanta.check()==0) {
                        throw new NoHayProductoException();
                    }
                }

            case SNICKERS:
                if (m.getValor() >= Precio.VALSNICK.getPrecio() && snikers.check() != 0) {
                    for (int i = 0; i < (m.getValor() - Precio.VALSNICK.getPrecio()) / 100; i++) {
                        monVu.add(new Moneda100());
                    }
                    return snikers.get();
                }
                else {
                    monVu.add(m);
                    if(m.getValor()<Precio.VALSNICK.getPrecio()){
                        throw new PagoInsuficienteException();
                    }
                    else if(snikers.check()==0) {
                        throw new NoHayProductoException();
                    }
                }

            case SUPER8:
                if (m.getValor() >= Precio.VALSUPER8.getPrecio() && super8.check() != 0) {
                    for (int i = 0; i < (m.getValor() - Precio.VALSUPER8.getPrecio()) / 100; i++) {
                        monVu.add(new Moneda100());
                    }
                    return super8.get();
                }
                else {
                    monVu.add(m);
                    if(m.getValor()<Precio.VALSUPER8.getPrecio()){
                        throw new PagoInsuficienteException();
                    }
                    else if(super8.check()==0) {
                        throw new NoHayProductoException();
                    }
                }

            default:
                monVu.add(m);
                throw new NoHayProductoException();
        }
    }

    public Moneda getVuelto(){
        return monVu.get();
    }
}
