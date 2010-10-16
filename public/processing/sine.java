
int offset;
int total;
int counter;
int tick;
int SPACING = 1;
ArrayList al;

draw_width = width - 30;
draw_height = height - 10;

void setup() {
  
  al = new ArrayList();
  int _tick = 0;
  while (al.size() < draw_width/SPACING) {
    al.add(0,(height/2)*Math.sin((++_tick)*(2*Math.PI)/(draw_width/SPACING)) + (height/2));
  }
  total = al.size();
  tick = 0;
  counter = 0;
  noStroke();
}

int nToC(int n) {
  return 100.0*(sin(n/10.0)) + 100;
}

void draw() {
  background(255);
  offset++;
  if (counter++%10 == 9) {
    counter = 0;
    tick++;
  }
  for (int x = 0; x < total; x++ ) {
    fill(nToC(tick),nToC(2*tick),nToC(3*tick))
    ellipse(SPACING*x,al[(x+offset)%total],2,2);
  }
}

