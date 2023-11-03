package programa;

public abstract class Dulce extends Producto{
    private int serie;

    public Dulce(){
        super();
    }
    public int getSerie(){
        return serie;
    }

    public abstract String comer();
}
