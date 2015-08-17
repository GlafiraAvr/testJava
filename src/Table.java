/**
 * Created by Glafira on 10.08.2015.
 */
public class Table extends Furniture {
    private  String shape;
    boolean sliding;

    public Table() {
        super();
        this.shape = "rectangle";
        this.sliding = false;

    }


    public Table(String name, float price, String material, int length, int width, int height, String shape, boolean sliding) {
        super(name, price, material, length, width, height);
        this.shape = shape;
        this.sliding = sliding;
    }

    public String getShape() {
        return shape;
    }

    public boolean isSliding() {
        return sliding;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setSliding(boolean sliding) {
        this.sliding = sliding;
    }

    @Override
    public String toString() {
        String strIsSl = "";
        if (sliding)
            strIsSl = "sliding"+ '\n';

        return "Table" + '\n' +
                " name - " + name + '\n' +
                " price - " + price + '$'+'\n' +
                " material - " + material + '\n' +
                " shape - " + shape + '\n' +
                strIsSl+
                " size - "+ + length+"x"+ width +"x"+height +" (mm)"+"\n\n";

    }
}
