public class TestC{
  public static void main(String[] args){
    int t = 0;
    Combination c = new Combination(1,1,1);
    SecurityAgent bob = new SecurityAgent();
    DoorLock d = bob.getDoorLock();
    while(d.isOpen() == false){
      if(d.n == 3){
        bob.activateDoorLock();
      }else{
        int f = t/25 + 1;
        int s = (t - (f-1)*25)/5 + 1;
        int h = t%5+1;
        c = new Combination((f),(s),(h));   
        d.open(c);
        t++;
      }
    }
    System.out.println("Number of tries: "+t+"\n Code was "+c.toString());
  }
}