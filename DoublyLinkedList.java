import java.util.NoSuchElementException;
public class DoublyLinkedList<T> 
{
	T data;
	Node<T> head;
	public DoublyLinkedList()
	{
		head = null;		
	}
	
	public DoublyLinkedList(T t)
	{
		head = new Node<T>(t);
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
			Node<T> currentNode = head;
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
			i+= "null <-- ";
			Node<T> currentNode = head;
			T val = currentNode.data;
			i+= val;
			currentNode = currentNode.next;
			while(currentNode != null)
			{
				val = currentNode.data;
				i+=  " <--> "+val;
				
				currentNode = currentNode.next;
				
			}
			
			i+=" --> null";
		}
		return i;
	}
	
	public T get(int index)
	{
		int size = size();

		if(index< 0 || index>= size || isEmpty())
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			Node<T> currentNode = head;
			int i = 0;
			while(i<index)
			{
				currentNode = currentNode.next;
				i++;
			}
			return currentNode.data;
		}
	}
	
	public boolean contains(T t)
	{
		if(isEmpty())
		{
			return false;
		}
		int size = size();
		for(int i  = 0; i< size; i++)
		{
			if(t == get(i))
			{
				return true;
			}
		}
		return false;
	}
	public Node<T> getNode(int index)
	{
		int size = size(); 
		Node<T> currentNode = head;
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
	
	public void add(int index, T n)
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
		else if( index>0 && index<=size-1)
		{
			Node<T> newNode = new Node<T>(n);
			Node<T> previousNode = getNode(index);
			Node<T> nextNode =previousNode.next;
			newNode.next = nextNode;
			previousNode.next = newNode;
			newNode.prev = previousNode;
			if(nextNode!= null)
			{
			nextNode.prev = newNode;
			}
			
			
		}
		else if( index==1&& size ==2)
		{
			Node<T> firstNode = getNode(0);
			Node<T> secondNode = getNode(1);
			Node<T> newNode = new Node<T>(n);
			newNode.next = secondNode;
			secondNode.prev = newNode;
			firstNode.next = newNode;
			newNode.prev = firstNode;
			secondNode.next = null;
		}
		else if (index == 0)
		{
			Node<T> newNode = new Node<T>(n);
			newNode.next = head;
			head = newNode;
			head.next.prev = newNode;
			newNode.prev = null;
		}
	}
	
	// adds at the end of the list
	public void add(T n)
	{
		int size = size();
		if(isEmpty())
		{
			head = new Node<T>(n);
		}
		else 
		{
			Node<T> newNode = new Node<T>(n);
			Node<T> lastNode = getNode(size-1);
			lastNode.next = newNode;
			newNode.prev = lastNode;
		}
	}
	
	// removes the first node of the list, returns the firstNode data
	public T remove()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		T toReturn = head.data;
		head = head.next;
		head.prev = null;
		return toReturn;
	}
	
	// removes the Node at index, returns the value of the node at index
	public T remove(int index)
	{
		int size = size();
		if(isEmpty() || index<0 || index>=size)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index>0&& index< size-1)
		{
			Node<T> previousNode = getNode(index-1);
			Node<T> nextNode = getNode(index+1);
			previousNode.next = nextNode;
			nextNode.prev = previousNode;
			return get(index);
		}
		else if(index == 0)
		{
			remove();
		}
		else if(index == size-1)
		{
			Node<T> previousNode = getNode(index-1);
			previousNode.next = null;
		}
		return get(index);
	}
	
	public static class Node<T>
	{
		private T data;
		private Node<T> next;
		private Node<T> prev;
		public Node()
		{
			data = null;
			next = null;
			prev = null;
		}
		public Node(T n)
		{
			data = n;
			next = null;
			prev = null;
		}
		public Node(T n, Node<T> nextNode, Node<T> prevNode)
		{
			data = n;
			next = nextNode;
			prev = prevNode;
		}
	}
	
}
