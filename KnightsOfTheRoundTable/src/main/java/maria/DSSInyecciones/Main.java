package maria.DSSInyecciones;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    Knight<HolyGrail> knight = context.getBean("knight", Knight.class);
	    
	    try {
			HolyGrail grail = knight.embarkOnQuest();
			System.out.println("The grail is " + grail.getDescription());
			System.out.println("The origin of the grail is " + grail.getOrigin());
			grail.use();
		} catch (QuestFailedException e) {
			e.printStackTrace();
		}
	}
}

