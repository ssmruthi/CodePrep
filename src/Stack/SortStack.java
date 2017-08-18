package Stack;

import java.util.Stack;

public class SortStack {

	public Stack<Integer> sort(Stack<Integer> input) { // 4 8 6 7 2

		Stack<Integer> temp = new Stack<Integer>(); 
		int value;

		while (!input.isEmpty()) {

			if (temp.isEmpty() || input.peek() > temp.peek()) 
				temp.push(input.pop());
			else {
				value = input.pop();
				while (!temp.isEmpty() && temp.peek() > value) {
					input.push(temp.pop());
				}
				temp.push(value);
			}
		}
		
		
		while(!temp.isEmpty()){
			input.push(temp.pop());
		}
		
		return input;
	}
}
