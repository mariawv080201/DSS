package maria.DSSInyecciones;

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

