import java.util.ArrayList;

public class Deposito<T>{
    private ArrayList<T> almacen;
    public Deposito(){
        almacen=new ArrayList<T>();
    }
    public void add(T b){
        almacen.add(b);
    }
    public T get(){
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