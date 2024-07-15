import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Canvas  extends java.awt.Canvas implements MouseListener {
    public List<Elect> Elects = new ArrayList<>();
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;
    private static final double K = 9*(Math.pow(10,9));
    public Canvas(){
        addMouseListener(this);
        setSize(WIDTH,HEIGHT);
        Elects.add(new Elect(WIDTH/3,HEIGHT/2,3,Color.RED));
        Elects.add(new Elect(2*(WIDTH/3),HEIGHT/2,-4,Color.BLUE));
//        int interval =50;
//        for (int i = 0; i < HEIGHT/interval; i++) {
//            for (int j = 0; j < WIDTH/interval; j++) {
//                Elects.add(new Elect(j*interval,i*interval,true));
//            }
//        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);
        for (int i = 0; i < WIDTH; i+=WIDTH/30) {
            g.drawLine(i,0,i,HEIGHT);
            g.drawString(i+"",i,HEIGHT/2+100);
        }
        for (Elect e :Elects) {
            int r = e.radius;
            g.setColor(e.color);
            g.drawOval(e.x-r,e.y-r,2*r,2*r);
            g.setColor(Color.BLACK);
            g.drawString(e.ElectPower+"C",e.x,e.y);
        }
        for (Elect e : Elects) {
            if (!e.unit){
                for (Elect other : Elects){
                    if (other != e){
                        g.setColor(e.color);
                        Force(e,other,g2d);
                    }
                }
            }
        }
    }

    public void Force(Elect E1,Elect E2,Graphics2D g){
        double R = Math.sqrt( Math.pow(E1.x-E2.x,2)+Math.pow(E1.y-E2.y,2) );
        double F = (K * E1.ElectPower * E2.ElectPower)/Math.pow(R,2);

        double dx = E2.x-E1.x;
        double dy = E2.y-E1.y;
        double unitDx = dx/R;
        double unitDy = dy/R;
        double endX = E2.x+unitDx * F/10000;
        double endY = E2.y+unitDy * F/10000;
        g.draw(new Line2D.Double(E2.x, E2.y, endX, endY));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 마우스 클릭 시 끝점 좌표 업데이트
        if (!Elects.isEmpty()){
            Elects.get(0).x= e.getPoint().x;
            Elects.get(0).y= e.getPoint().y;
        }
        repaint(); // 패널 다시 그리기
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
