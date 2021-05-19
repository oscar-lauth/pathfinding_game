public class CLinkedList<anyType> {
	private ListNode<anyType> head;
	private ListNode<anyType> tail;
	private int size;
	public CLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	public void add(anyType x) {
		if(head==null) { //empty
			head = new ListNode<anyType>(x);
			tail = head;
			tail.setNext(head);
		}
		else {
			tail.setNext(new ListNode<anyType>(x));
			tail = tail.getNext();
			tail.setNext(head);
		}
		size++;
	}
	public void addFirst(anyType x) {
		if(head==null) {
			head = new ListNode<anyType>(x);
			tail = head;
			tail.setNext(head);
		}
		else {
			ListNode<anyType> oldFirst = head;
			head = new ListNode<anyType>(x);
			head.setNext(oldFirst);
			tail.setNext(head);
		}
		size++;
	}
	public void add(int index, anyType x) {
		if(index == 0) {
			addFirst(x);
		}
		else if(index == size-1) {
			add(x);
		}
		else {
			ListNode<anyType> current = head;
			for(int i=1;i<index;i++) { //sets current to ListNode before index
				current = current.getNext();
			}
			current.setNext(new ListNode<anyType>(x,current.getNext()));
			size++;

		}
	}
	public void showList() {
		if (head==null)						//if list is empty
         System.out.println("List is empty");
      else
      {
         ListNode<anyType> current =  head;
         while(current.getNext() != head)
         {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
         }	
         System.out.println(current.getValue());
         System.out.println("And here is the last element's next: " + current.getNext().getValue());
      
      }
	}
	public int size() {
		return size;
	}
	public anyType getFirst() {
		if(head==null) {
			return null;
		}
		return head.getValue();
	}
	public anyType getLast() {
		if(head==null) {
			return null;
		}
		return tail.getValue();
	}
	public anyType get(int index) {
		if(index==0) {
			return getFirst();
		}
		else if(index==size-1) {
			return getLast();
		}
		else {
			ListNode<anyType> current = head;
			for(int i=0;i<index;i++) {
				current = current.getNext();
			}
			return current.getValue();
		}
	}

}