import processing.core.*;

public class Human implements Interface{
    float x;

    public static  PApplet a=Main.processing;

    @Override
    public void ShowObject() {
        x=a.mouseX;
        a.noStroke();
        a.fill(255);
        a.circle(x, 505, 20);
        a.fill(0);
        a.circle(x+5, 505, 3);
        a.circle(x-5, 505, 3);
        a.fill(255);
        a.rect(x-10, 515, 20, 25);
        a.stroke(255);
        a.line(x-5, 540, x-5, 550);
        a.line(x+5, 540, x+5, 550);
        a.line(x+10, 515, x+15, 525);
        a.line(x+15, 525, x+10, 535);
        a.line(x-17, 525, x-10, 525);
        a.line(x-17, 512, x-17, 525);
        a.noStroke();
        a.rect(x-19, 516, 5, 4);
    }
    
}
