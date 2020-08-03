 public class ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters; 
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters); 
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//methode that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){
	int length = values.length;
	
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if (values[j] > values[i]) {
					char temp = values[i];
					values[i]=values[j];
					values[j]=temp;
				}
			}
		}

		}
	}