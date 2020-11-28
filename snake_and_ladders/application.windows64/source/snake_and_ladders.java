import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class snake_and_ladders extends PApplet {

player p1 = new player();
player p2 = new player();
public void setup(){
  
}
public void draw(){
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

public int xp(int pos){
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
public int yp(int pos){
  if(pos%10==0){
  return 225+(10-(pos/10)-1)*50;}
  return 175+(10-(pos/10)-1)*50;
}

public void mousePressed() {
  if(click(100,150,50,200)){
    p1.play();
  }
  if(click(650,150,50,200)){
    p2.play();
  }
}

public boolean click(int x,int y,int width,int height){
  if (mouseX >= x && mouseX <= x+width && 
    mouseY >= y && mouseY <= y+height) {
    return true;
  } else {
    return false;
  }
}
class player{
  int pos;
  int roll;
  public void show(int po){
    fill(255,100,255,200);
    stroke((po)%255);
    circle(xp(pos),yp(pos),50);
    int x = (po==0)? 110:660;
    int y = 300;
    textSize(32);
    fill(255,100,255);
    rect(x-5,y-30,40,40);
    fill(0,0,0);
    text(roll, x+5,y);
  }
  public void play(){
    if(pos>=100){
    pos = 100;
    return;
    }
    roll = PApplet.parseInt(random(1,7));
    if(pos+roll>100){
    return;
    }
    pos+=roll; 
    if(pos==99){pos=58;}
    else if(pos==97){pos=65;}
    else if(pos==93){pos=25;}
    else if(pos==89){pos=48;}
    else if(pos==75){pos=44;}
    else if(pos==60){pos=23;}
    else if(pos==53){pos=15;}
    else if(pos==50){pos=11;}
    else if(pos==35){pos=9;}
    else if(pos==21){pos=3;}
    else if(pos==24){pos=7;}
    
    else if(pos==4){pos=16;}
    else if(pos==18){pos=22;}
    else if(pos==26){pos=37;}
    else if(pos==12){pos=33;}
    else if(pos==49){pos=51;}
    else if(pos==42){pos=61;}
    else if(pos==55){pos=74;}
    else if(pos==88){pos=92;}
    else if(pos==85){pos=95;}
    else if(pos==82){pos=98;}
  }
}
  public void settings() {  size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "snake_and_ladders" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
