class Expendedor{
    private Deposito<Bebida> coca = new Deposito<>();
    private Deposito<Bebida> sprite= new Deposito<>();
    private Deposito<Moneda> monVu = new Deposito<>();

    private int precio;

    public Expendedor(int numBebidas, int precioBebidas){
        precio=precioBebidas;
        for(int i=0; i<numBebidas;i++){
            coca.add(new CocaCola(100+i));
            sprite.add(new Sprite(200+i));
        }
    }
    public Bebida comprarBebida(Moneda m,TipoBebida cual) {
        //Vuelto
        try {
            switch (cual) {
                case COCA:
                    if (m.getValor() >= precio && coca.check() != 0) {
                        for (int i = 0; i < (m.getValor() - precio) / 100; i++) {
                            monVu.add(new Moneda100());
                        }
                        return coca.get();
                    } else {
                        for (int i = 0; i < m.getValor() / 100; i++) {
                            monVu.add(new Moneda100());
                        }
                        return null;
                    }

                case SPRITE:
                    if (m.getValor() >= precio && sprite.check() != 0) {
                        for (int i = 0; i < (m.getValor() - precio) / 100; i++) {
                            monVu.add(new Moneda100());
                        }
                        return sprite.get();
                    } else {
                        for (int i = 0; i < m.getValor() / 100; i++) {
                            monVu.add(new Moneda100());
                        }
                        return null;
                    }

                default:
                    for (int i = 0; i < m.getValor() / 100; i++) {
                        monVu.add(new Moneda100());
                    }
                    return null;
            }
        } catch(Exception a){
            return null;
        }
    }

    public Moneda getVuelto(){
        return monVu.get();
    }
}
