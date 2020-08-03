public class DoorLock{
  private Combination c;
  final int MAX_NUMBER_OF_ATTEMPTS = 3;
  public boolean isActivated, isOpen;
  public int n;
  public DoorLock(Combination combination){
    this.c = combination;
    this.n = 0;
    this.isActivated = true;
    this.isOpen = false;
  }
  public boolean isOpen(){
    return this.isOpen;
  }
  public boolean isActivated(){
    return this.isActivated;
  }
  public void activate(Combination combination){
    if (c == combination){
      this.isActivated = true;
      this.n = 0;
    }
  }
  public boolean open(Combination combination){
    boolean o = false;
    if (c.equals(combination)==true){
      o = true;
      this.isOpen = true;
      this.n = 0;
    }else{
      this.n++;
      if(this.n == MAX_NUMBER_OF_ATTEMPTS){
        this.isActivated = false;
      }
    }
    return o;
  }
}