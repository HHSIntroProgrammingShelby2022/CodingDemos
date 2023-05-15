import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;


public class Link {
	  
	  private final int BLOCK_TIMEOUT = 30;
	  private final int SWING_TIMEOUT = 20;
	
	  // Load the sounds from the disk. 
	  private final EasySound2 slashSound = new EasySound2("slash.wav");
	  private final EasySound2 blockSound = new EasySound2("block.wav");
	  
	  
	  private Image sprites;
	  private Rectangle[] spriteRects;
	  
	  private int x, y; // The bottom left corner of link
	  private int action;
	  
	  private int actionTimer;
	
	  public Link(int x, int y) {
		  sprites = new ImageIcon("link.png").getImage();
		  
		  spriteRects = new Rectangle[3]; // Coordinates of each action within the sprite sheet image
		  spriteRects[0] = new Rectangle(0,77,41,46);
		  spriteRects[1] = new Rectangle(468,86,61,59);
		  spriteRects[2] = new Rectangle(413,90,53,55);
		  
		  this.x = x;
		  this.y = y;
		  action = 0;
	  }
	  
	  /*
	   * Link standing, doing nothing.
	   */
	  public void stand() {
		  action = 0;
	  }
	  
	  /*
	   * Link slashes his sword.
	   */
	  public void slash() {
		  if (action == 0) {
			  action = 1;
			  slashSound.play();
			  actionTimer = SWING_TIMEOUT;
		  }
	  }
	  
	  /*
	   * Link blocks with his shield.
	   */
	  public void block() {
		  if (action == 0) {
			  action = 2;
			  blockSound.play();
			  actionTimer = BLOCK_TIMEOUT;
		  }
	  }
	  
	  /*
	   * Draw link using the correct sprite. Currently, link is scaled by 4x.
	   */
	  public void draw(Graphics2D g2, ImageObserver io) {
		    AffineTransform at = g2.getTransform();
		    
		    g2.translate(x, y);
		    g2.scale(4.0, 4.0);
		    
		    g2.drawImage(sprites, 0,-spriteRects[action].height,spriteRects[action].width,0,spriteRects[action].x,spriteRects[action].y,spriteRects[action].x+spriteRects[action].width,spriteRects[action].y+spriteRects[action].height,io);

		    g2.setTransform(at);
	  }
	  
	  
	  public void act() {
		  if (actionTimer > 0) {
			  actionTimer--;
			  if (actionTimer == 0) {
				  stand();
			  }
		  }
	  }
	  
	  
}
