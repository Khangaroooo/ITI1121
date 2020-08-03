public class Question33{

	public static int[] insertArray(int[] iArray,int indexN, int num){
		int[] nArray = new int[(iArray.length+1)];
		int n = 0;
		for(int i = 0; i < nArray.length; i++){
			if (i == indexN){
				nArray[i] = num;
			}else{
				nArray[i] = iArray[n];
				n++;
			}
		}
		return nArray;
	}


	public static void main(String[] args){
		int[] iArray = new int[]{1,5,4,7,9,6};
		System.out.println("Array before insertion:");
		for(int i = 0; i < iArray.length; i++){
			System.out.println(iArray[i]);
		}
		int[] nArray = insertArray(iArray,3,15);
		System.out.println("Array After insertion of 15 at the index 3:");
		for(int i = 0; i < nArray.length; i++){
			System.out.println(nArray[i]);
		}
	}
}