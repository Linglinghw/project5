package ling111folder;
import java.util.Arrays;
import java.util.Stack;
public class project5 {
	static void bubblestack(int arr[],int s) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int a : arr) {
			stack.push(a); //push()把值推入stack
		}
		Stack<Integer> stack1 = new Stack<Integer>();
		for(int q = 0;q < s;q++) {
			if(q % 2 == 0) {
				while(!stack.isEmpty()) {
					int w = stack.pop(); //pop()移除stack頂部的值
					if(stack1.isEmpty()) {
						stack1.push(w);
					}
					else {
						if(stack1.peek() > w) {
							int ele = stack1.pop();
							stack1.push(w);
							stack1.push(ele);
						}
						else {
							stack1.push(w);
						}
					}
				}
				arr[s-1-q] = stack1.pop();
			}
			else
			{
				while(!stack1.isEmpty()) {
					int w = stack1.pop();
					if(stack.isEmpty())
						stack.push(w);
					else {
						if(stack.peek() > w) {
							int ele = stack.pop();
							stack.push(w);
							stack.push(ele);
						}
						else
							stack.push(w);
					}
				}
				arr[s-1-q] = stack.pop();
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		int arr[] = {1,3,8,4,7,6};
		bubblestack(arr,arr.length);
	}
}
