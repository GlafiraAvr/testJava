import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Glafira on 11.08.2015.
 */
public  class Conteiner {
    ArrayList<Furniture> list;
    static  int count=0;
    static  float avaragePrice;
    static  float allPrice;

    public Conteiner() {
       this.list = new ArrayList<Furniture>();
    }

    public Conteiner(ArrayList<Furniture> list) {
        this.list = list;
    }

    public  void  add(Furniture fur){
        this.list.add(fur);
        allPrice+=fur.getPrice();
        count++;

    }

    public float  getAvaragePrice(){
        if (count==0)
                return 0;
        return allPrice/count;


    }

    @Override
    public String toString() {
        String result;
        if (list.size()>0){
         result="List \n";
        for (Furniture fur:list){
           result =  result.concat(fur.toString()).concat("\n");
        }
        }else
         result = "List is Empty!!";

        return result;
    }

    public void Sort(){

        Collections.sort(list);
    }

    public static int getCount() {
        return count;
    }
}
