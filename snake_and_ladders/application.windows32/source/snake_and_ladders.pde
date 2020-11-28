player p1 = new player();
player p2 = new player();
void setup(){
  size(800,800);
}
void draw(){
  background(230,230,250);
  fill(256,256,256);
  stroke(0);
  strokeWeight(1);
  rect(150,150,500,500);
  for(int i=1;i<10;i++){
    int x=50*(i+3);
    int y=150;
    line(x,y,x,y+500);
  }
   for(int i=1;i<10;i++){
    int x=150;
    int y=800-50*(i+3);
    line(x,y,x+500,y);
  }
  stroke(255,0,0);
  strokeWeight(5);
  line(xp(99),yp(99),xp(58),yp(58));
  line(xp(97),yp(97),xp(65),yp(65));
  line(xp(89),yp(89),xp(48),yp(48));
  line(xp(75),yp(75),xp(44),yp(44));
  line(xp(60),yp(60),xp(23),yp(23));
  line(xp(53),yp(53),xp(15),yp(15));
  line(xp(50),yp(50),xp(11),yp(11));
  line(xp(35),yp(35),xp(9),yp(9));
  line(xp(21),yp(21),xp(3),yp(3));
  line(xp(24),yp(24),xp(7),yp(7));
  line(xp(93),yp(93),xp(25),yp(25));
  stroke(0,0,255);
  line(xp(4),yp(4),xp(16),yp(16));
  line(xp(18),yp(18),xp(22),yp(22));
  line(xp(26),yp(26),xp(31),yp(31));
  line(xp(12),yp(12),xp(33),yp(33));
  line(xp(49),yp(49),xp(51),yp(51));
  line(xp(42),yp(42),xp(61),yp(61));
  line(xp(55),yp(55),xp(74),yp(74));
  line(xp(88),yp(88),xp(92),yp(92));
  line(xp(85),yp(85),xp(95),yp(95));
  line(xp(82),yp(82),xp(98),yp(98));
  fill(0,0,0);
  textSize(24);
  for(int i=1;i<101;i++){
    text(i,xp(i)-20,yp(i)+10);
  }
  
  rect(100,150,50,200);
  rect(650,150,50,200);
  fill(255,255,255);
  text("P1",110,200);
  text("P2",660,200);
  p1.show(0);
  p2.show(760);
  
}

int xp(int pos){
  int x = (pos%10==0) ? 10 : pos%10;
  if(pos%10==0 && (pos/10)%2==1){
    return 175+(x-1)*50;
  }
  if(pos%10==0 && (pos/10)%2==0){
    return 800-(175+(x-1)*50);
  }
  if((pos/10)%2==1){
    return 800-(175+(x-1)*50);
  }
  else{
    return 175+(x-1)*50;
  }
}
int yp(int pos){
  if(pos%10==0){
  return 225+(10-(pos/10)-1)*50;}
  return 175+(10-(pos/10)-1)*50;
}

void mousePressed() {
  if(click(100,150,50,200)){
    p1.play();
  }
  if(click(650,150,50,200)){
    p2.play();
  }
}

boolean click(int x,int y,int width,int height){
  if (mouseX >= x && mouseX <= x+width && 
    mouseY >= y && mouseY <= y+height) {
    return true;
  } else {
    return false;
  }
}
