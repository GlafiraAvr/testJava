/**
 * Created by Glafira on 10.08.2015.
 */
public class Chair  extends  Furniture{
    enum TypeSoft { soft,hard };
    private
    TypeSoft seat,back;

    String colorUpholster;

    public Chair() {
        super();
        seat = back = TypeSoft.hard;
        colorUpholster = "-";
    }

    public Chair(java.lang.String name, float price, java.lang.String material, int length, int width, int height, String seat, String back, java.lang.String colorUpholster) {
        super(name, price, material, length, width, height);
        this.seat = TypeSoft.valueOf(seat);
        this.back = TypeSoft.valueOf(back);
        this.colorUpholster = colorUpholster;
    }

    public String getSeat() {
        return seat.toString();
    }

    public String getBack() {
        return back.toString();
    }



    public void setSeat(String seat) {
        this.seat = TypeSoft.valueOf(seat);
    }

    public void setBack(String back) {
        this.back = TypeSoft.valueOf(back);
    }

    public void setColorUpholster(java.lang.String colorUpholster) {
        if  (seat == TypeSoft.soft || back == TypeSoft.soft) {
            this.colorUpholster = colorUpholster;
        }
        else
         this.colorUpholster = "";
    }

    @Override
    public java.lang.String toString() {
        String colorUpholster ="";
        if  (!this.colorUpholster.equals(""))
            colorUpholster = " colorUpholster=" + colorUpholster + '\n' ;
        return "Chair" +
                " name - " + name + '\n' +
                " price - " + price + '$'+'\n' +
                " material - " + material + '\n' +
                " seat=" + seat + '\n' +
                " back=" + back + '\n' +
                colorUpholster+
                " size - "+ + length+"x"+ width +"x"+height + " (mm)"+"\n";


    }
}
