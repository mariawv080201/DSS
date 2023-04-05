package maria.DSSInyecciones;

public class HolyGrailQuest implements Quest<HolyGrail> {
	  public HolyGrailQuest() { /*...*/ }
	  public HolyGrail embark() throws QuestFailedException {
	    // Do whatever it means to embark on a quest
	    return new HolyGrail("a grail that is so powerfull","the fairies",true);
	  }
	}