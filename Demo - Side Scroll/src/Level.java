
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;


public class Level extends Rectangle2D.Double {

	private ArrayList<Sprite> scene;
	
	public Level() {
		scene = new ArrayList<Sprite>();
		scene.add(new Sprite("tree.gif",150,150,175,300,false));
		scene.add(new Sprite("house.jpg",525,250,200,200,false));
		scene.add(new Sprite("sun.jpg",575,50,150,150,false));
		this.width = 800;
		this.height = 600;
	}
	
	public void draw(Graphics2D g2, ImageObserver io) {
		for (Sprite mi : scene)
			mi.draw(g2, io);
	}
	
}
