import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
public class Dom4jDome {
	
	public void run(){
		
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read("src/com/xml/schema/web.xml");
			Element rootele=  doc.getRootElement();
			System.out.println(rootele.getName());
			List<Element> elements = rootele.elements();
			for(Element e:elements){
				if("servlet".equals(e.getName())){
					Element servletname = e.element("servlet-name");
					System.out.println(servletname.getText());
					Element servletclass = e.element("servlet-class");
					System.out.println(servletclass.getText());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Dom4jDome().run();
	}
}
