package A3;

import java.util.Stack;

public class Q4B {
	Stack<String> forwardStack;
	Stack<String> backwardStack;
	
	public Q4B() {
		this.forwardStack = new Stack<>();
		this.backwardStack = new Stack<>();
	}
	
	public Q4B(String url) {
		this.forwardStack = new Stack<>();
		this.backwardStack = new Stack<>();
		backwardStack.push(url);
	}
	
	
	public void visit(String url){
		if (!forwardStack.isEmpty()) forwardStack.clear();
		backwardStack.push(url);
		System.out.println("Visited: " + url);
	}
	
	public String back(){
		if (backwardStack.isEmpty()) {
			System.out.print("Cannot go back");
			return null;
		}
		
		if (backwardStack.size() < 2) {
			System.out.print("Cannot go back");
			return backwardStack.peek();
		}
		forwardStack.push(getCurrentPage());
		backwardStack.pop();
		return backwardStack.peek();
	}
	
	public String forward() {
		if (forwardStack.isEmpty()) {
			System.out.print("Cannot go forward");
			return backwardStack.peek();
		}
		String page = forwardStack.pop();
		backwardStack.push(page);
		return page;
	}
	
	public String getCurrentPage() {
		if (backwardStack.isEmpty()) {
			return null;
		}
		return backwardStack.peek();
	}
	
	public String getHistory() {
		String forwardString;
		String backString;
		if (forwardStack.isEmpty()) {
			forwardString = "[empty]";
		}
		else {
			forwardString = forwardStack.toString();
		}
		if (backwardStack.isEmpty()) {
			backString = "[empty]";
		}
		else {
			backString = backwardStack.toString();
		}
		return "Current: " + getCurrentPage() + " Back History: " + backString + " Forward History: " + forwardString;
	}
	
	public boolean canGoForward() {
		if (forwardStack.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean canGoBack() {
		if (backwardStack.isEmpty() || backwardStack.size() < 2) {
			return false;
		}
		return true;
	}
	
	public void clearHistory() {
		String currPage = getCurrentPage();
		backwardStack.clear();
		forwardStack.clear();
		backwardStack.push(currPage);
		System.out.print("History cleared");
	}
	
}