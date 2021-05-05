public class CLinkedList {
	private ListNode head;
	private ListNode tail;
	private int size;
	public CLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	public void add(Object x) {
		if(head==null) {
			head = new ListNode(x);
			tail = head;
			head.setNext(head);
		}
		else {

		}
	}
}