package euler.level1;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MaximumPathSum {
	public static void main(String[] args) {
		BufferedReader reader = null;
		String line = null;
		
		Node root = null;
		
		Node upperParent = null;
		Node previousUpperParent = null;
		Node nextUpperParent = null;
		
		Node justCreatedNode = null;
		
		String[] numbersInALine = null;
		
		try {
			reader = new BufferedReader(new FileReader("triangle1.txt"));
					
			while((line = reader.readLine()) != null) {
				numbersInALine = line.split(" ");
				
				if (numbersInALine.length == 1) {
					root = new Node(Integer.parseInt(numbersInALine[0]));
					root.setLeftParent(null);
					root.setRightParent(null);
					root.setSum(root.getValue());
					
					upperParent = root;
				}
				else if (numbersInALine.length == 2) {
					justCreatedNode = root.createLeftChild(Integer.parseInt(numbersInALine[0]));
					justCreatedNode.setLeftParent(null);
					
					justCreatedNode.setSum(justCreatedNode.getValue() + root.getSum());
					
					justCreatedNode = root.createRightChild(Integer.parseInt(numbersInALine[1]));
					justCreatedNode.setRightParent(null);
					
					justCreatedNode.setSum(justCreatedNode.getValue() + root.getSum());
					
					upperParent = root.getLeftChild();
				}
				else {
					for (int i = 0; i < numbersInALine.length; i++) {
						if (i == 0) {
							justCreatedNode = upperParent.createLeftChild(Integer.parseInt(numbersInALine[0]));
							
							justCreatedNode.setSum(justCreatedNode.getValue() + justCreatedNode.getRightParent().getSum());
							
							nextUpperParent = justCreatedNode;
							
							justCreatedNode.setLeftParent(null);
							
							upperParent = upperParent.getRightParent().getRightChild();
							previousUpperParent = upperParent.getLeftParent().getLeftChild();
							
							continue;
						}
						
						if (i == numbersInALine.length - 1) {
							justCreatedNode = upperParent.createRightChild(Integer.parseInt(numbersInALine[i]));
							justCreatedNode.setRightParent(null);
							
							justCreatedNode.setSum(justCreatedNode.getValue() + justCreatedNode.getLeftParent().getSum());
							
							upperParent = nextUpperParent;
							
							continue;
						}
						
						justCreatedNode = upperParent.createLeftChild(Integer.parseInt(numbersInALine[i]));
						previousUpperParent.setRightChild(justCreatedNode);
						justCreatedNode.setLeftParent(previousUpperParent);
						
						int maxSum = (justCreatedNode.getLeftParent().getSum() > justCreatedNode.getRightParent().getSum()) ? justCreatedNode.getLeftParent().getSum() : justCreatedNode.getRightParent().getSum();
						justCreatedNode.setSum(maxSum + justCreatedNode.getValue());
						
						if (upperParent.getRightParent() != null) {
							upperParent = upperParent.getRightParent().getRightChild();
							previousUpperParent = upperParent.getLeftParent().getLeftChild();
						}
					}
				}
			}
		}
		catch(IOException exception) {
			exception.printStackTrace();
		}
		finally {
			try {
				if(reader != null) {
					reader.close();	
				}
			}
			catch(IOException exception) {
				exception.printStackTrace();	
			}
		}
		
		Node currentNode = root;

		while (currentNode.getLeftChild() != null) {
			currentNode = currentNode.getLeftChild();
		}
		
		int result = 0;
		
		while(currentNode.getRightParent() != null) {
			if (currentNode.getSum() > result) {
				result = currentNode.getSum();
			}
				
			currentNode = currentNode.getRightParent().getRightChild();
		}
			
		if (currentNode.getSum() > result) {
			result = currentNode.getSum();
		}
		
		System.out.println("Maximum sum is: " + result);
	}
	
	private static class Node {
		private Node leftParent;
		private Node rightParent;
		
		private Node leftChild;
		private Node rightChild;
		
		private int value;
		private int sum;
		
		public Node(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;	
		}
		
		public int getSum() {
			return this.sum;	
		}
		
		public void setSum(final int sum) {
			this.sum = sum;
		}
		
		public Node createLeftChild(final int value) {
			this.leftChild = new Node(value);
			
			this.leftChild.setRightParent(this);
			
			return this.leftChild;
		}
		
		public Node createRightChild(final int value) {
			this.rightChild = new Node(value);
			
			this.rightChild.setLeftParent(this);
			
			return this.rightChild;
		}
		
		public Node getLeftChild() {
			return this.leftChild;
		}
		
		public Node getRightChild() {
			return this.rightChild;
		}
		
		public Node getLeftParent() {
			return this.leftParent;
		}
		
		public void setLeftParent(final Node leftParent) {
			this.leftParent = leftParent;
		}
		
		public Node getRightParent() {
			return this.rightParent;
		}
		
		public void setRightParent(final Node rightParent) {
			this.rightParent = rightParent;
		}
		
		public void setRightChild(final Node rightChild) {
			this.rightChild = rightChild;
		}
	}
}
