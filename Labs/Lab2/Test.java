public class Test{
  public static void main(String[] args){
    int t = 0;
    Combination c = new Combination(1,1,1);
    SecurityAgent bob = new SecurityAgent();
    DoorLock d = bob.getDoorLock();
    while(d.isOpen() == false){
      t++;
      if(d.n == 3){
        bob.activateDoorLock();
      }else{
        c = new Combination(((int) (Math.random()*5) + 1),((int) (Math.random()*5) + 1),((int) (Math.random()*5) + 1));;        
        d.open(c);
      }
    }
    System.out.println("Number of tries: "+t+"\n Code was "+c.toString());
  }
}