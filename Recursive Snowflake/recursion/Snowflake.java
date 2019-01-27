package recursion;

public class Snowflake {
private BasicStar basic;
private int depth;

public Snowflake(){
    double height = Painter.getFrameHeight()/2;
    double width = Painter.getFrameWidth()/2;
    Pixel center = new Pixel (width, height);
    double maxRadius = Math.min(width, height)/2;
    double radius = maxRadius/4;
    this.basic = new BasicStar(center, radius);
    this.depth = 2;
}

public Snowflake(BasicStar basic, int depth){
    this();
    if(basic!=null){
        this.basic = basic;
        this.depth = depth;
    }
}

public int getDepth(){
    return this.depth;
}

public BasicStar getBasic(){
    return this.basic;
}

public double getRadius(BasicStar basic){
    return this.basic.getRadius();
}

public Pixel getBasicCenter(BasicStar basic){
    return this.basic.getCenter();
}

public void draw(){
    draw(this.depth, basic.getCenter(), basic.getRadius());
}

private void draw(int depth, Pixel center, double radius){
    BasicStar basic = new BasicStar(center, radius);

    if(depth==1){
        basic.draw();
    }
    else{
        Pixel p = new Pixel(center.getX() + radius, center.getY());
        draw(depth - 1, p, (radius/3));
        for(int i=0; i<6; i=i+1){
            p.rotateRelativeToPixel(center, (2*Math.PI)/6);
            BasicStar temp = new BasicStar(p, radius/3);
            temp.draw();
        }
    }
}
}
