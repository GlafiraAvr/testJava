import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Glafira on 10.08.2015.
 */
public class Main {
    static String filename = "untitled1\\simple.xml";
    static  Conteiner conteiner;
    public static void main(String[] strings){
         conteiner = new Conteiner();

        System.out.print(conteiner);
        System.out.println("Total count - " +Conteiner.getCount());
        System.out.print("Avarage prise is "+conteiner.getAvaragePrice());
        conteiner.Sort();
        System.out.println(conteiner);

    }

    private static Furniture readChair(ItemElement el, String name, String price,String material ,String width, String length,String height) {
        String colorUpholster = el.readFieldByName("colorUpholster","");
        String seat = el.readFieldByName("seat","");
        String back = el.readFieldByName("back","");
        return  new Chair(name, Float.parseFloat(price),material,
                Integer.parseInt(length),Integer.parseInt(width),Integer.parseInt(height),
                seat,back,colorUpholster);
    }

    private static Furniture readTable(ItemElement el, String name,String price, String material, String width, String length, String height) {
        boolean slide =Boolean.getBoolean(el.readFieldByName("sliding","false"));
        String shape = el.readFieldByName("shape","");
        return  new Table(name,Float.parseFloat(price),material,
                Integer.parseInt(length),Integer.parseInt(width),Integer.parseInt(height),
                shape,slide);
    }

    private  static void   readXML(){
        ReaderXML readerXML = new ReaderXML();
        try {
            readerXML.startRead(filename);
            for (ItemElement el : readerXML){
                String classname = el.readClassName();
                String name = el.readFieldByName("name","");
                String price  =el.readFieldByName("price", "0");
                String length = el.readFieldByName("length", "0");
                String width = el.readFieldByName("width", "0");
                String height = el.readFieldByName("height", "0");
                String material = el.readFieldByName("material", "");
                if (classname.equals("Table")){

                    conteiner.add(readTable(el,name,price ,material,width,length,height));

                }else
                if (classname.equals("Chair")){



                    conteiner.add(readChair(el, name, price, material, width, length, height));

                }else
                    System.out.println("Unexpected Class " + classname);

            }

        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException  - Can't parse file "+filename);
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("SAXException  - Can't parse file "+filename);
        } catch (IOException e) {
            System.out.println("Can't  open or read the File  "+filename);
        }


    }




}
