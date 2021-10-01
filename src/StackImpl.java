import java.util.EmptyStackException;

public class StackImpl <E> implements Stack<E>{
     private E[] data;
     private int max;
     private int lib;
     private E last;


     public StackImpl(int max){
         data = (E[]) new Object[max];
         this.max = max;
         this.lib =0;
     }

     @Override
     public void push (E e) throws FullStackException{
         if(lib < max){
             data[lib]= e;
             lib++;
         }
         else{
             throw new FullStackException();
         }
     }

     @Override
     public E pop() throws EmptyStackException {
         if(lib!=0){
          data[0]=null;
          for(int i=0;i<(lib-1);i++){
              data[i]=data[i+1];
          }
          data[lib-1]=null;
          lib--;
          E e = data[this.lib];
          return e;
         }else{
             throw new EmptyStackException();
         }
     }

    @Override
     public int size(){
         return data.length;
     }
}
