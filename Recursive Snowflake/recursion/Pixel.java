package recursion;

public class Pixel {
private double x;
private double y;

public Pixel(){
    x = 0;
    y = 0;
}

public Pixel(double x, double y){
    this.x = x;
    this.y = y;
}

public Pixel(Pixel center){
    this();
    if(center != null){
        this.x = center.x;
        this.y = center.y;
    }
}

public double getX(){
    return x;
}
public double getY(){
    return y;
}
public void translate(Pixel p){
    this.x = this.x + p.x;
    this.y = this.y + p.y;
}
public void rotateRelativeToAxesOrigin(double theta){
    double tempX = this.x;
    double tempY = this.y;
    this.x = ((tempX)*(Math.cos(theta)) - ((tempY)*(Math.sin(theta))));
    this.y = ((tempX)*(Math.sin(theta)) - ((tempY)*(Math.cos(theta))));
}
public void rotateRelativeToPixel(Pixel p1, double theta){
    double tempX = this.x;
    double tempY = this.y;
    Pixel translatedPixel = new Pixel(tempX-p1.getX(), tempY-p1.getY());
    translatedPixel.rotateRelativeToAxesOrigin(theta);
    this.x = translatedPixel.getX() + p1.getX();
    this.y = translatedPixel.getY() + p1.getY();
}
}