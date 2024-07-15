import java.awt.*;
public class Elect{
    public int ElectPower = -1;
    public int x;
    public int y;
    public Boolean unit = false;
    public int radius = 0;
    public Color color = Color.WHITE;
    public Elect(int x,int y,int ElectPower,Color color){
        this.x = x;
        this.y = y;
        this.ElectPower = ElectPower;
        this.radius = 10;
        this.color = color;
    }

    public Elect(int x,int y,boolean unit){
        this.x = x;
        this.y = y;
        this.unit = unit;
    }
}
