public abstract class Dulce extends Producto{
    private int serie;
    public Dulce(int numSerie){
        super();
        this.serie=numSerie;
    }
    public int getSerie(){ return serie; }
}
