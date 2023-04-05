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

He creado un archivo llamado applicationContext.xml con las dependencias. Este archivo especifica cómo se deben crear y configurar los objetos. Lo he situado en la carpeta src/main/java:
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
 
  <bean id="knight" class="maria.DSSInyecciones.KnightOfTheRoundTable">
    <constructor-arg value="Lancelot" />
    <property name="quest" ref="quest" />
  </bean>
 
  <bean id="quest" class="maria.DSSInyecciones.HolyGrailQuest" />
 
</beans>
```



