import java.util.*;
public class SecurityAgent{
  private Combination c;
  public DoorLock d;
  public SecurityAgent(){
    this.c = new Combination(((int) (Math.random()*5) + 1),((int) (Math.random()*5) + 1),((int) (Math.random()*5) + 1));
    this.d = new DoorLock(this.c);
  }
  public DoorLock getDoorLock(){
    return this.d;
  }
  public void activateDoorLock(){
    d.activate(this.c);
  }
}