package maria.DSSInyecciones;

public interface Quest<T> {
	  T embark() throws QuestFailedException;
}