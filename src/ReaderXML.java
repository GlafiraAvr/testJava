import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Glafira on 12.08.2015.
 */
public class ReaderXML  implements IReader {
    private  Document document;
    private NodeList listElement;
    private  File file = null;




    public void startRead(String fileName) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        file = new File(fileName);
        document = db.parse(file);

        listElement = document.getElementsByTagName("Item");


    }

    @Override
    public Iterator<ItemElementCl> iterator() {

     return   new Iterator<ItemElementCl>() {

            private int index = 0;


            @Override
            public boolean hasNext() {
                if (listElement != null)
                    return index < listElement.getLength();

                return false;
            }

            @Override
            public ItemElementCl next() {
                ItemElementCl el = new ItemElementCl((org.w3c.dom.Element) listElement.item(index++));
                return el;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();

            }


        } ;



    }
    public class ItemElementCl implements ItemElement  {
        private  org.w3c.dom.Element el;

        public void setEl(Element el) {
            this.el = el;
        }

        @Override
        public String readFieldByName(String fieldName, String defaultVal) {


            if (el.hasAttribute(fieldName) )
                return el.getAttribute(fieldName);
            else
                return defaultVal;


        }

        public ItemElementCl(Element el) {
            this.el = (org.w3c.dom.Element)el.getFirstChild().getNextSibling();
        }

        @Override
        public String readClassName() {
            return el.getTagName();
        }
    };








}
