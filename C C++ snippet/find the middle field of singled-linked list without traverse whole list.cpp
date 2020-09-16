public int getMiddleElement(LinkedList l)
{
    return getMiddleElement(l.getHead());
}

private int getMileElement(Node n)
{
    Node slow = n;
    Node fast = n;

    while(fast!=null && fast.next!=null)
    {
        fast = fast.next.next;
        slow = slow.next;
    }

    return slow.data;
}