public class ListNode<anyType> {
	private anyType value;
	private ListNode<anyType> next;
	public ListNode(anyType initValue, ListNode<anyType> initNext) {
		value = initValue;
		next = initNext;
	}
	public ListNode(anyType initValue) {
		this(initValue,null);
	}
	public anyType getValue() {
		return value;
	}
	public ListNode<anyType> getNext() {
		return next;
	}
	public void setValue(anyType newValue) {
		value = newValue;
	}
	public void setNext(ListNode<anyType> newNext) {
		next = newNext;
	}
}