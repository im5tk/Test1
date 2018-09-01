import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MarioMove extends Applet implements KeyListener{
	static Image img;
	int x= 80, y= 50, dir= 0, num= 0;

    public void init(){
		setBackground(Color.white);
		img = getImage(getDocumentBase(),"mario_left.png");
		addKeyListener(this);
    }

    public void paint(Graphics g){
		int xoff;
		Dimension  size = getSize();
		g.setColor(getBackground());
		xoff= (dir*3+num)*80;
		g.drawImage(img,x,y,x+80,y+80,xoff,0,xoff+80,80,this);
	}

	public void keyPressed(KeyEvent e){
		Dimension  size = getSize();

    	if(num == 2){
			num = 0;
		}else{
			num += 1;
		}

		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT :
				img = getImage(getDocumentBase(),"mario_right.png");
				if(x > size.width-80){
				}else{
					x=x+10; dir=0;
				}
				repaint();
				break;
			case KeyEvent.VK_LEFT :
				img = getImage(getDocumentBase(),"mario_left.png");
				if(x < 0){
				}else{
					x=x-10; dir=0;
				}
				repaint();
				break;
		}
	}
	public void keyReleased(KeyEvent e) { }
	public void keyTyped(KeyEvent e) { }
}