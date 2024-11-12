
public abstract class GeometricObject {
    private String color = "white";
     private boolean filled;
     private java.util.Date dateCreated;
 
     /** Construct a default geometric object */
     protected GeometricObject() {
       dateCreated = new java.util.Date();
     }

    /** Construct a geometric object with color and filled value */
    protected GeometricObject(String color, boolean filled) {
      dateCreated = new java.util.Date();
      this.color = color;
      this.filled = filled;
    }

    /** Return color */
    public String getColor() {
      return color;
    }

    /** Set a new color */
    public void setColor(String color) {
      this.color = color;
    }

    /** Return filled. Since filled is boolean,
     *  the getter method is named isFilled */
    public boolean isFilled() {
      return filled;
    }

    /** Set a new filled */
    public void setFilled(boolean filled) {
      this.filled = filled;
    }

    /** Get dateCreated */
    public java.util.Date getDateCreated() {
      return dateCreated;
    }
    
    
    @Override
    public String toString() {
        return "created on " + dateCreated
                + ", color: " + color
                + ", and filled: " + filled;
    }

    /** Abstract method getArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
   public abstract double getPerimeter();
  }
    

    class Circle extends GeometricObject implements Comparable<Circle> {    
    private double radius; 
    
    public Circle(double radius) {
        this.radius = radius;
    }

    // construct circle with radius, color, filled status
    public Circle(double radius, String color, boolean filled) {
        super(color, filled); // call the constructor in GeometricObject
        this.radius = radius;
    }
    // return radius
    public double getRadius() {
        return radius;
    }
    // set new radius
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    // implement abstract method getArea
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    // implement getPerimeter
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    // implement Comparable interface to compare circles by radius
    @Override
    public int compareTo(Circle other) {
        if (this.radius < other.radius) {
            return -1; // this circle is smaller
        } else if (this.radius > other.radius) {
            return 1; // this circle is larger
        } else {
            return 0; // equal
        }
        
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // same object
        }
        if (!(obj instanceof Circle)) {
            return false; // not a Circle
        }
        Circle other = (Circle) obj; // cast obj to Circle
        return this.radius == other.radius; // compare radius
    }
    


// override the toString method to describe the Circle

    @Override
    public String toString() {
        return "Circle with radius " + radius + ", color: " + getColor() + ", and filled: " + isFilled();

}
    
    // main method for testing the Circle class
    public static void main(String[] args) {
        // create three circles with different properties
        Circle c1 = new Circle(5, "red", true);
        Circle c2 = new Circle(7, "blue", false);
        Circle c3 = new Circle(5, "green", true);

        // test getArea and getPerimeter methods
        System.out.println("Circle 1 area: " + c1.getArea());
        System.out.println("Circle 1 perimeter: " + c1.getPerimeter());

        // test compareTo method
        System.out.println("Compare c1 and c2: " + c1.compareTo(c2)); // should print -1
        System.out.println("Compare c1 and c3: " + c1.compareTo(c3)); // should print 0

        // test equals method
        System.out.println("c1 equals c2? " + c1.equals(c2)); // should print false
        System.out.println("c1 equals c3? " + c1.equals(c3)); // should print true

        // test toString method
        System.out.println(c1); // should print details of c1
        System.out.println(c2); // should print details of c2
        System.out.println(c3); // should print details of c3
     }    
}

