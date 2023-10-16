abstract class Moneda implements Comparable<Moneda> {
    public Moneda() {

    }

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();

    @Override
    public int compareTo(Moneda moneda) {
        if(this.getValor() == moneda.getValor()) {
            return 1;
        } else {
            return 0;
        }
    }
}
