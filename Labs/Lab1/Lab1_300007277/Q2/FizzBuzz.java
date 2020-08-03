public class FizzBuzz{
  
  public static void whichIsIt(int number){
    String answer;
    if ((number%15) == 0){
      answer = "FizzBuzz";
      printA(number, answer);
    }else{
        if((number%5) == 0){
          answer = "Buzz";
          printA(number, answer);
        }
        else{
          if((number%3) == 0){
            answer = "Fizz";
            printA(number, answer);
          }
        }
      }
  }
  
  public static void printA(int number, String answer){
  System.out.println(number+" "+answer);
  }
  
  public static void main(String[] args){
    for(int i = 1; i<=30;i++){
      whichIsIt(i);
    }
  }
}