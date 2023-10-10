import java.util.ArrayList;

class Deposito<E>{
    private ArrayList<E> almacen;
    public Deposito(){
        almacen=new ArrayList<E>();
    }
    public void add(E b){
        almacen.add(b);
    }
    public E get(){
        if(almacen.size()!=0){
            return almacen.remove(0);
        }
        else{
            return null;
        }
    }
    public int check(){
        return almacen.size();
    }
}