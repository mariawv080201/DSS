package maria.DSSInyecciones;

public class QuestFailedException extends Exception {
	
	  public QuestFailedException() {
	    super();
	  }
	  public QuestFailedException(String message) {
	    super(message);
	  }
	  public QuestFailedException(Throwable cause) {
	    super(cause);
	  }
	  public QuestFailedException(String message, Throwable cause) {
	    super(message, cause);
	  }
}
