//   appletviewer charmove.htm
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class charmove extends Applet implements KeyListener
{   static  Image   img;
    int     x= 80, y= 50, dir= 0, num= 0;

    public void init()
    {   setBackground(Color.white);
        img = getImage(getDocumentBase(),"mario.gif");
        addKeyListener(this);
    }

    public void paint(Graphics g)
    {   int yoff;
        Dimension  size = getSize();
        g.setColor(getBackground());
        g.fillRect(0, 0, size.width, size.height);
        if (img!=null)
        {
            yoff= (dir*3+num)*80;
            g.drawImage(img,x,y,x+80,y+80,0,yoff,80,yoff+80,this);
        }
    }

    public void keyPressed(KeyEvent e)
    {
	Dimension  size = getSize();
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT : 
		if(x > size.width-80){
		}else{
			x=x+10; dir=0;
		}
		if(num == 2){
			num = 0;
		}else{
			num += 1;
		}
        	repaint();
 		break;
            case KeyEvent.VK_LEFT : 
		if(x == 0){
		}else{
			x=x-10; dir=1;
		}
		if(num == 2){
			num = 0;
		}else{
			num += 1;
		}
        	repaint();
		break;
        }

    }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }
}