import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Created by Glafira on 13.08.2015.
 */
public class ReadConsole implements Iterable<ItemElement>{

    private  BufferedReader bf;
    public void startRead(String info){
        bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(info);

    }
    @Override
    public Iterator<ItemElement> iterator() {

        return null;
    }

    public class ItemElementCL implements ItemElement{
        @Override
        public String readFieldByName(String fieldName, String defaultVal) {
            System.out.print("Input value "+fieldName+": ");

            try {
                return bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        public String readClassName() {
            System.out.print("Input class :");
            try {
                return  bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
