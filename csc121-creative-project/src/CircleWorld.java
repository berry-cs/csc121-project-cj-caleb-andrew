import java.util.Objects;

import processing.core.PApplet;

/**
 *  Represent the state of my falling circle 
 *  animation
 */
public class CircleWorld  implements IWorld{
	
int x;   // the position of the circle
int y;   // 

public CircleWorld (int x, int y) {
	super ();
	this.x = x;
	this.y = y;		
}

@Override
public int hashCode() {
	return Objects.hash(x, y);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CircleWorld other = (CircleWorld) obj;
	return x == other.x && y == other.y;
}


/** draw a picture with a circle at this world's (x,y)
 * 
 */
public PApplet draw(PApplet w) { 
	w.background(255);   // 0 = black, 255 = white
	w.fill(0,0,255); // solid blue
	w.circle(this.x, this.y, 15);	
	return w; 
	}	


/** produce an updates version of this
 * world where the y position has
 * increased by 1
 
 */
public IWorld update() { 
			if (this.y < 400) {
				return new CircleWorld (this.x, this.y + 1);
			}else {
				return this;
			}
					 
	}
}
