public abstract class Bebida extends Producto{
    private int serie;
    public Bebida(int numSerie){
        super();
        this.serie=numSerie;
    }
    public int getSerie(){ return serie; }
}
