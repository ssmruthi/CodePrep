import java.util.Stack;

/*
 * Added Generic implementation
 * Added peek()
 * Optimized the pop and push function
 * The two stacks need not be emptied every time value is pushed.
 * The popping Stack can pick values from the Pushing stack only when it gets empty 
 * 
 */
public class QueueViaStackOptimized{
	
	static class Queue<T>{

        Stack<T> stackPushingOnTop = new Stack<T>();
        Stack<T> stackPoppingOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack          
            stackPushingOnTop.push(value);
        }

        public T peek() {
           
             if(stackPoppingOnTop.isEmpty()){
               while(!stackPushingOnTop.isEmpty()){
                    stackPoppingOnTop.push(stackPushingOnTop.pop());
                }
            }
            
             return stackPoppingOnTop.peek();
        }

        public T dequeue() {
            
            if(stackPoppingOnTop.isEmpty()){
               while(!stackPushingOnTop.isEmpty()){
                    stackPoppingOnTop.push(stackPushingOnTop.pop());
                }
            }
            
            return stackPoppingOnTop.pop();
            
        }
    }
}
