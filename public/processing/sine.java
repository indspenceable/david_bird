int offset;
int total;
int counter;
int tick;
int SPACING = 1;
ArrayList al;

draw_width = width - 30;
draw_height = height - 10;

int FADE_DISTANCE = 60;

void setup() {

  al = new ArrayList();
  int _tick = 0;
  while (al.size() < draw_width/SPACING) {
    double sin = Math.sin((++_tick)*(2*Math.PI)/(draw_width/SPACING));
    int add_val = ((height-30)/2)*sin + ((height-15)/2);

    al.add(0,add_val);
  }
  total = al.size();
  tick = 0;
  counter = 0;
  noStroke();
}

int nToC(int n) {
  return 100.0*(sin(n/10.0)) + 100;
}
void backgroundColor(int tick, int x) {
  int r,g,b;
  r = nToC(tick);
  g = nToC(2*tick);
  b = nToC(3*tick);

  if (x < FADE_DISTANCE) {
    //fade
    r += ((FADE_DISTANCE-x)/FADE_DISTANCE)*(255-r);
    g += ((FADE_DISTANCE-x)/FADE_DISTANCE)*(255-g);
    b += ((FADE_DISTANCE-x)/FADE_DISTANCE)*(255-b);
  }
  fill(r,g,b);
}

void draw() {
  background(255);
  offset++;
  if (counter++%30 == 29) {
    counter = 0;
    tick++;
  }
  for (int x = 0; x < total; x++ ) {
    backgroundColor(tick, x);
    ellipse(10+SPACING*x,al[(x+offset)%total],2,2);
    ellipse(10+SPACING*x+15,al[(x+5+offset)%total],2,2);
  }
}

