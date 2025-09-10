//Implement a class called Rectangle which is a subclass of
//        GraphicObject and:
//        → has two additional fields: length and width.
//→ has an appropriate constructor.
//        → has a toString method which prints the length and width as
//well as the x and y coordinates.

package graphics;

public class Rectangle extends GraphicObject {
    private double length;
    private double width;

    public Rectangle(int x, int y, double length, double width) {
        super(x, y);
        this.length = length;
        this.width = width;
    }

    @Override
    public void resize(double multiplier) {
        length = length * multiplier;
        width *= multiplier;
    }

    @Override
    public String toString() {
        return "Rectangle length = " + length + " width = " + width
                + " at " + super.toString();
    }
}
