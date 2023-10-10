class Comprador {
    private String sonido;
    private int vuelto=0;

    public Comprador(Moneda m, TipoBebida cualBebida, Expendedor exp) {
        //Sonido
        try {
            sonido = exp.comprarBebida(m, cualBebida).beber();

            //Vuelto
            if (sonido != null) {
                while (true) {
                    try {
                        vuelto = vuelto + exp.getVuelto().getValor();
                    } catch (Exception e) {
                        break;
                    }
                }
            } else {
                while (true) {
                    try {
                        vuelto = vuelto + exp.getVuelto().getValor();
                    } catch (Exception d) {
                        break;
                    }
                }
            }
        } catch (NullPointerException f){
            while (true) {
                try {
                    vuelto = vuelto + exp.getVuelto().getValor();
                } catch (Exception g) {
                    break;
                }
            }
            sonido= null;
        }
    }
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return sonido;
    }
}