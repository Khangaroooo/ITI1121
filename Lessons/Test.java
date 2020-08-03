public class Test{
  int value;
  public static void main(String[] args){
    Test i;
    Test a = new Test();
    i = new Test();
    a.value = 4;
    i.value = 5;
    System.out.println(i.value);
    System.out.println(a.value);
  }
}