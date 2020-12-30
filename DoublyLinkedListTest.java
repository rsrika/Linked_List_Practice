public class DoublyLinkedListTest 
{
	public static void main(String[] args)
	{
		DoublyLinkedList<String> stringList = new DoublyLinkedList<String>();
		stringList.add("first");
		stringList.add("third");
		stringList.add(1,"second");
		System.out.println(stringList.size());
		stringList.add(2,"fourth");
		System.out.println(stringList);
	}

}
