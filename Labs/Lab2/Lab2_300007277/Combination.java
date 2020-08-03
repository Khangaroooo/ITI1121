public class Combination{
  private int f,s,t;
  public Combination(int first, int second, int third){
    this.f = first;
    this.s = second;
    this.t = third;
  }
  public boolean equals(Combination other){
    boolean b;
    if (this.f == other.f && this.s == other.s && this.t == other.t){
      b = true;
    }else{
      b = false;
    }
    return b;
  }
  public String toString(){
    return (this.f+":"+this.s+":"+this.t);
  }
}