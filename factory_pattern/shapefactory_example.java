public interface Shape {
    double area();
} //define a common attribute for all classes to use. 

public class Circle implements Shape {
    private double radius; 

    public Circle(double radius){
        this.radius = radius; 
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }
}

public class Rectangle implements Shape {
    private double length; 
    private double breadth; 

    public Rectangle(double length, double breadth){
        this.length = length; 
        this.breadth = breadth; 
    }

    @Override 
    public double area(){
        return length * breadth; 
    }
}

//this is used so that the user doesnt have to see the entire working of creating an object and can just do so by simply using the factory class to produce objects. 
//this uses the OOPs principle of encapsulation.
public class ShapeFactory {
    public static Shape createShape(String shapeType, double... params){
        switch(shapeType.toLowerCase()){
            case "circle":
                return new Circle(params[0]);
            case "rectangle":
                return new Rectangle(params[0], params[1]);
            default: 
                throw new IllegalArgumentException("Unknown shape type. Sorry!");
        }
    }
}

public class Main {
    public static void main(String[] args){
        Shape circle = ShapeFactory.createShape("circle", 5);  //base template/syntax for making use of factory class 
        System.out.println("Circle area " + circle.area());
        Shape rectangle = ShapeFactory.createShape("rectangle", 10, 20);
        System.out.println("Rectangle area " + rectangle.area());
    }
}
