/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlcreatedoc;

import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author VaidehiB
 */
public class XMLCreateDoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try{
         //root element
         Element carsElement = new Element("cars");
         Document doc = new Document(carsElement);

         //supercars element
         Element supercarElement = new Element("supercars");
         supercarElement.setAttribute(new Attribute("company","Ferrari"));

         //supercars element
         Element carElement1 = new Element("carname");
         carElement1.setAttribute(new Attribute("type","formula one"));
         carElement1.setText("Ferrari 101");

         Element carElement2 = new Element("carname");
         carElement2.setAttribute(new Attribute("type","sports"));
         carElement2.setText("Ferrari 202");

         supercarElement.addContent(carElement1);
         supercarElement.addContent(carElement2);

         doc.getRootElement().addContent(supercarElement);

         XMLOutputter xmlOutput = new XMLOutputter();

         // display ml
         xmlOutput.setFormat(Format.getPrettyFormat());
         xmlOutput.output(doc, System.out); 
         
      } catch(IOException e) {
         e.printStackTrace();
      }
    }
    
}
