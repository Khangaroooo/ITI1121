public class GenericArrayStack<E> implements Stack<E> {

    private E[] elems;
    private int top, capacity; 
	
   // Constructor
   @SuppressWarnings( "unchecked" )
    public GenericArrayStack( int capacity ) {
		this.capacity = capacity;
		elems = (E[])(new Object[capacity]);
		top =-1;
    }

    // Returns true if this ArrayStack is empty
    public boolean isEmpty() {
		return (top == -1);
    }

    public void push( E elem ) {
		if(top < capacity){
		top = top +1 ;
		elems[(top)] = elem;
		}else{
			System.out.println("Overflow");
		}
    }
	
		public E pop() {
		if(isEmpty()){
        return null;
    }else{
        E a = elems[top];
        elems[top]= null;
        top--;
        return a;
    }

    }

    public E peek() {

    if(isEmpty()){
        return null;
    }
    return elems[top];

    }
}