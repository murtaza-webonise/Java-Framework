import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.webo.annotations.Autoinit;
import com.webo.beans.Address;

public class MyBeanTest {

	public static void main(String[] args) {

		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = parserFactor.newSAXParser();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SAXHandle handler = new SAXHandle();
		File file = new File("src/main/java/com/webo/config/properties.xml");
		try {
			parser.parse(file, handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class SAXHandle extends DefaultHandler {

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (qName.equals("props")) {

			String path = attributes.getValue("value");
			Class<?> obj = null;
			try {
				obj = Class.forName(path);
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}
			Field[] fields = obj.getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Autoinit.class)) {
					Class<?> obj2 = field.getType();
					try {
						Annotation autoinit = field
								.getAnnotation(Autoinit.class);
						// Class obj3=autoinit.getClass();
						Autoinit ai = (Autoinit) autoinit;
						MyFactory mf = new MyFactory();

						Address key = (Address) mf.createMyClass(obj2, "bean");
						key.setState(ai.state());
						key.setCity(ai.city());

						key.setPinCode(ai.pinCode());

						Method method = obj.getMethod("setAddress", obj2);
						method.setAccessible(true);
						method.invoke(obj.newInstance(), key);

					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		// Add the employee to list once end tag is found

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

	}

}
