package programa;

public abstract class Dulce extends Producto{
    private int serie;

    public Dulce(int serie){
        super(serie);
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }

    public abstract String comer();
}
