abstract class Bebida{
    private int serie;
    public Bebida(int numSerie){
        this.serie=numSerie;
    }
    public int getSerie(){ return serie; }
    public abstract String beber();
}
