# Inyección de dependencias

## Código original

### Knight.java

```java
public interface Knight {
  Object embarkOnQuest() throws QuestFailedException;
}
```

### Quest.java

```java
public interface Quest {
  abstract Object embark()
    throws QuestFailedException;
}
```

### HolyGrailQuest.java
```java
public class HolyGrailQuest implements Quest {
  public HolyGrailQuest() { /*...*/ }
  public Object embark() throws QuestFailedException {
    // Do whatever it means to embark on a quest
    return new HolyGrail();
  }
}
```

### KnightOfTheRoundTable.java

```java
public class KnightOfTheRoundTable implements Knight {
  private String name;
  private Quest quest;
  public KnightOfTheRoundTable(String name) {
    this.name = name;
  }
  public Object embarkOnQuest() throws QuestFailedException {
    return quest.embark();
  }
  public void setQuest(Quest quest) {
    this.quest = quest;
  }
}
```

## Cambios

Usando eclipse, he creado un proyecto Maven. En pom.xml he añadido la dependencia de Spring:
```xml
<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-context</artifactId>
	    <version>6.0.7</version>
  	</dependency>
```



