package recursion;

public class BasicStar {
private Pixel center;
private double radius;

public BasicStar(){
    double height = Painter.getFrameHeight()/2;
    double width = Painter.getFrameWidth()/2;
    this.center = new Pixel (width, height);
    double maxRadius = Math.min(width, height)/2;
    this.radius = maxRadius/4;
}

public BasicStar(Pixel center, double radius){
    this.center = new Pixel(center);
    this.radius = radius;
}

public Pixel getCenter(){
    return new Pixel(center);
}
public double getRadius(){
    return this.radius;
}
public void draw(){
    Pixel begin = new Pixel(this.center); 
    Pixel end = new Pixel(center.getX() + getRadius(), center.getY());

            Painter.drawLine(begin, end);
            end.rotateRelativeToPixel(center, (2*Math.PI)/6);
            Painter.drawLine(begin, end);
            end = new Pixel(center.getX() + getRadius(), center.getY());
            end.rotateRelativeToPixel(center, (4*Math.PI)/6);
            Painter.drawLine(begin, end);
            end = new Pixel(center.getX() + getRadius(), center.getY());
            end.rotateRelativeToPixel(center, (6*Math.PI)/6);
            Painter.drawLine(begin, end);
            end = new Pixel(center.getX() + getRadius(), center.getY());
            end.rotateRelativeToPixel(center, (8*Math.PI)/6);
            Painter.drawLine(begin, end);
            end = new Pixel(center.getX() + getRadius(), center.getY());
            end.rotateRelativeToPixel(center, (10*Math.PI)/6);
            Painter.drawLine(begin, end);

}
}