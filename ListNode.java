public class ListNode {
	private Object value;
	private ListNode next;
	public ListNode(Object v, ListNode n) {
		value = v;
		next = n;
	}
	public ListNode(Object v) {
		this(v,null);
	}
	public Object getValue() {
		return value;
	}
	public ListNode getNext() {
		return next;
	}
	public void setValue(Object newValue) {
		value = v;
	}
	public void setNext(ListNode newNext) {
		next = n;
	}
}