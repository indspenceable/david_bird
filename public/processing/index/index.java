//Global variables
Point cursor_location;
Point cursor_target;
Point center;
ArrayList destinations;

int r,g,b;
int nToC(int x) {
  return sin(x/1000.0)*127 + 128;
}
void drawCircle(Point p) {
  noStroke();
  ellipse(p.x,p.y,10,10);
}
void drawMouseCircle(Point p, int _r, int _g, int _b) {
  fill(0,0,0);
  ellipse(p.x,p.y,10,10);
  fill(255,255,255);
  ellipse(p.x,p.y,9,9);
  fill(_r,_g,_b);
  ellipse(p.x,p.y,5,5);
}
public static double distance( Point p1, Point p2 ) {
  return Math.sqrt(Math.pow(p2.x-p1.x, 2) + Math.pow(p2.y-p1.y, 2));
}
void setup() {
  cursor_location = new Point(0,50);
  cursor_target = new Point(50,50);
  center = new Point( 100,100 );
  destinations = new ArrayList()
}
void draw() {
  r += 3;
  g += 2;
  b += 1;
  background(0);
  //background(nToC(r),nToC(g),nToC(b));

  //Draw paths between the center and each point
  //Skip for now.

  fill(nToC(r),nToC(g),nToC(b));
  //Draw each point
  for (int a = 0; a < destinations.size(); a++ ) {
    Point p = (Point)destinations[a];
    drawCircle(p);
  }

  while (destinations.size() > 30) {
    destinations.remove(0);
  }

  fill(255)
  //Draw the center
  //drawCircle(center);

  fill(0);
  //move the Mouse
  if (distance(cursor_location,cursor_target) < 1) {
    cursor_location = cursor_target
  } else {
    cursor_location.x += (cursor_target.x - cursor_location.x)/10.0
      cursor_location.y += (cursor_target.y - cursor_location.y)/10.0
    destinations.push(new Point( cursor_location.x, cursor_location.y ) );
  }

  //Draw the mouse 
  drawMouseCircle(cursor_location,nToC(b),nToC(r),nToC(g));
}
void mouseDragged() {
  cursor_target = new Point(mouseX, mouseY); 
}
void mousePressed() {
  cursor_target = new Point(mouseX, mouseY); 
}


