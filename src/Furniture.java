import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Created by Glafira on 10.08.2015.
 */
public abstract class Furniture implements Comparable<Furniture> {
    protected String name;
    protected float price;
    protected String material;
    int length;
    int width;
    int height;

    private float isZero(float p){

        if (p>=0)
            return p;
        else
            return 0;
    }

    private int isZero(int p){
        if (p<0)
            return 0;
        else
            return p;
    }

    public Furniture() {
        name=this.getClass().getName();
        price=50;
        material="wood";
        length=width=height=0;
    }

    public Furniture(String name, float price, String material, int length, int width, int height) {
        this.name = name;
        this.price = isZero(price);
        this.material = material;
        this.length = isZero(length);
        this.width = isZero(width);
        this.height = isZero(height);
    }

    @Override
    public String toString() {
        return "Furniture " +
                " name - '" + name + '\n' +
                " price - " + price + '$'+'\n' +
                " material - " + material + '\n' +
                " size - "+ + length+"X"+ width +"X"+height +"mm"+"\n\n";
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getMaterial() {
        return material;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = isZero(price);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setLength(int length) {

        this.length = (isZero(length));
    }

    public void setWidth(int width) {

        this.width = isZero(width);
    }

    public void setHeight(int height) {
        this.height = isZero(height);
    }

    @Override
    public int compareTo(Furniture o) {
        if (o instanceof Furniture)
            if( ((Furniture) o).price>this.price )
                return -1;
            else
                return 1;

        return 0;
    }

}
