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
  abstract Object embark() throws QuestFailedException;
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

A continuación he editado el código. Knight y Quest no los he modificado.

En HolyGrailQuest he hecho que devuelva un objeto HolyGrail, cuya clase he creado, y le he dado propiedades al objeto.

```java
public class HolyGrailQuest implements Quest<HolyGrail> {
	public HolyGrailQuest() { /*...*/ }
	public HolyGrail embark() throws QuestFailedException {
	    // Do whatever it means to embark on a quest
	    return new HolyGrail("a grail that is so powerfull","the fairies",true);
	}
}
```
```java
public class HolyGrail {
	private String description;
	private String origin;
	private boolean hasPower;
	  
	public HolyGrail(String description, String origin, boolean hasPower) {
		this.description = description;
		this.origin = origin;
		this.hasPower = hasPower;
	}
	
	public String getDescription() {
		return description;
	}
	  
	public String getOrigin() {
		return origin;
	}
	
	public boolean hasPower() {
		return hasPower;
	  }
	  
	public void use() {
		if (hasPower) {
			System.out.println("You feel the power of the Holy Grail!");
		} else {
			System.out.println("The Holy Grail has no power.");
		}
	}
}
```

En KnightOfTheRoundTable, ahora es un conjunto de elementos T que hereda de Knight<T> y sus atributos son un String name y un Quest<T> quest.
	
```java
public class KnightOfTheRoundTable<T> implements Knight<T> {
	private String name;
	private Quest<T> quest;
	
	public KnightOfTheRoundTable(String name) {
		this.name = name;
	}
	
	public T embarkOnQuest() throws QuestFailedException {
	    return quest.embark();
	}
	
	public void setQuest(Quest<T> quest) {
	    this.quest = quest;
	}
}
```

He tenido que crear una clase de excepción para que compile el programa ya que las clases anteriores lanzaban la excepción QuestFailedException. La he hecho de forma que herede de Exception de Java.
	
```java
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
```
	
Finalmente, he creado una clase Main con la función main dentro. Crea un objeto context de ApplicationContext. El objeto context se refiere al contexto de la aplicación de Spring, que se inicializa al leer y cargar el archivo applicationContext.xml con la información sobre las dependencias. La siguiente línea obtiene una instancia de la clase Knight del contenedor de Spring, utilizando el nombre knight y especificando el tipo Knight<HolyGrail> como un parámetro genérico. La instancia que se obtiene será una instancia de la clase Knight que está configurada en el archivo de configuración de Spring, y que utiliza una instancia de HolyGrail para realizar su trabajo.
	
Creo un objeto HolyGrail llamado grail e imprimo sus características por pantalla y llamo al método use.

```java
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
```
	
## Ejecución
	
Al ser un proyecto Maven, sólo tengo que darle a ejecutar dentro de eclipse y podemos comprobar que funciona.

<image src="/img/itWorks.png" alt="Funciona">

