public class Rectangle extends Shape{
    private double width,height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width*height;
    }

    @Override
    public double calculateCircumference() {
        return 2*(width*height);
    }



    public String toString() {
        return "Rectangle " +
                "\nWidth= " + getWidth() +
                "\nHeight= "+getHeight()+
                "\nArea= "+calculateArea()+
                "\nPerimeters= "+calculateCircumference();
    }
}
