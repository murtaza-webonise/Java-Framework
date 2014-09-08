
import com.webo.test.School;
import com.webo.wizard.config.BeanFactory;
import com.webo.wizard.config.PropertyParser;

public class Tester {

	public static void main(String[] args) {

		PropertyParser pp = new PropertyParser();
		pp.parser("/home/webonise/workspace/WizardFrameworkTest/src/main/resources/properties.json");
		School sc = (School) BeanFactory.retrFromMap("school");
		sc.setSchoolName("I.L.V.A");
		System.out.println(sc.getSchoolName());
		School sc1 = (School) BeanFactory.retrFromMap("school");
		System.out.println(sc1.getSchoolName());
		

	}

}
