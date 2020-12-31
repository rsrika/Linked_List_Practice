import java.util.NoSuchElementException;

public class LinkedList 
{
	private Node head;
	public static class Node
	{
		private int data;
		private Node next;
		private int index;
		public Node()
		{
			data = 0;
			next = null;
		}
		public Node(int n)
		{
			data = n;
			next = null;
		}
		public Node(int n, Node nextNode)
		{
			data = n;
			next = nextNode;
		}
	}
	public LinkedList()
	{
		head = null;
	}
	public LinkedList(int n)
	{
		head = new Node(n);
	}
	public static String author()
	{
		return "Srikanth, Roshni";
	}
	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		return false;
	}
	public int size()
	{
		int i = 1;
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			Node currentNode = head;
			while(currentNode.next != null)
			{
				i++;
				currentNode = currentNode.next;
			}
		}
		return i; 
	}
	
	public String toString()
	{
		String i = "";
		if(isEmpty())
		{
			return "null";
		}
		else
		{
			Node currentNode = head;
			int val = currentNode.data;
			i+= val;
			i+=" --> ";
			currentNode = currentNode.next;
			while(currentNode != null)
			{
				val = currentNode.data;
				i+= val;
				i+=" --> ";
				currentNode = currentNode.next;
			}
			i+="null";
			return i;
		}
	}
	
	public int get(int index) 
	{
		int size = size();

		if(index< 0 || index>= size || isEmpty())
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			Node currentNode = head;
			int i = 0;
			while(i<index)
			{
				currentNode = currentNode.next;
				i++;
			}
			return currentNode.data;
		}
		
	}
	
	public Node getNode(int index)
	{
		int size = size(); 
		Node currentNode = head;
		if(index< 0 || index>= size|| isEmpty())
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			int i = 0;
			while(i<index)
			{
				currentNode = currentNode.next;
				i++;
			}
		}
		return currentNode;
	}
	
	public boolean contains(int n)
	{
		if(isEmpty())
		{
			return false;
		}
		int size = size();
		for(int i  = 0; i< size; i++)
		{
			if(n == get(i))
			{
				return true;
			}
		}
		return false;
	}
	public void add(int n)
	{
		int size = size();
		if(isEmpty())
		{
			head = new Node(n);
		}
		else 
		{
			Node newNode = new Node(n);
			Node lastNode = getNode(size-1);
			lastNode.next = newNode;
		}
		
		
	}
	// adds before the node
	public void add(int index, int n) 
	{
		int size = size();
		if((index<0 || index>=size) && index !=0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(isEmpty() && index == 0)
		{
			add(n);
		}
		else if( index>0 && index<size-1)
		{
			Node newNode = new Node(n);
			Node previousNode = getNode(index);
			Node nextNode = getNode(index+1);
			previousNode.next = newNode;
			newNode.next = nextNode;
		}
		else if (index == 0)
		{
			Node newNode = new Node(n);
			Node currentNode = head;
			newNode.next = currentNode;
			head = newNode;
		}
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node head2) {
		this.head = head2;
	}
	public int indexOf(int num)
	{
		if(!contains(num))
		{
			return -1;
		}
		else
		{
			Node currentNode = head;
			int i = 0;
			while(currentNode.data != num)
			{
				currentNode = currentNode.next;
				i++;
			}
			return i;
		}
		
	}
	public int remove()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		int toReturn = head.data;
		head = head.next;
		return toReturn;
	}
	public int remove(int index)
	{
		int size = size();
		if(isEmpty() || index<0 || index>=size)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index>0&& index< size-1)
		{
			Node previousNode = getNode(index-1);
			Node nextNode = getNode(index+1);
			previousNode.next = nextNode;
			return get(index);
		}
		else if(index == 0)
		{
			remove();
		}
		else if(index == size-1)
		{
			Node previousNode = getNode(index-1);
			previousNode.next = null;
		}
		return get(index);
	}
	
	public int getData(Node currentNode)
	{
		return currentNode.data;
	}
	public Node getNext(Node currentNode)
	{
		return currentNode.next;
	}
	public void setData(Node currentNode, int val)
	{
		currentNode.data = val;
	}
	public void setNext(Node currentNode, Node nextNode)
	{
		currentNode.next = nextNode;
	}
	
	

}
