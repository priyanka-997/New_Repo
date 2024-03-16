package api.test;

import java.util.ArrayDeque;

public class Test {   i/p- {}{}()

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		static boolean bracketsBalanced(String st) {
		
		ArrayDeque<> stack = new ArrayDeque<>();
		
		for (int i = 0; i < st.length(); i++) {
			
			char x = st.charAt(i);
			
			if (x=='{' || x== '{' || x== '(' ) {
				
				stack.push(x);
				
			}
			
			if(stack.isEmpty()
				 return false;
			
			char check;
			
			switch(x) {
			case '}';
			
			check=  stack.pop();
			
			if ( check == '{' || check == '(' ) {
				
				return false;
				
				break;
			}
			
			case '}';
			
			check= stack.pop();
			
			if (check == '{' || check == '(') {
				
				return false;
				break;
			}
			}
		
			case ')';
			
			check = stack.pop();
			
			if (check == '{' || check == '{') {
				
				return false;
				break;
			}
		}
		
		return (stack.isEmpty())
		
		}
	}


