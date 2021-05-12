public class ListNode<anyType> {
	private anyType value;
	private ListNode next;
	public ListNode(anyType initValue, ListNode initNext) {
		value = initValue;
		next = initNext;
	}
	public ListNode(anyType initValue) {
		this(initValue,null);
	}
	public anyType getValue() {
		return value;
	}
	public ListNode getNext() {
		return next;
	}
	public void setValue(anyType newValue) {
		value = newValue;
	}
	public void setNext(ListNode newNext) {
		next = newNext;
	}
}