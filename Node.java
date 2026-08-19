public class Node {

    private Room room;
    private Node next;
    private Node previous;

    public Node(Room room) {

        this.room = room;
        this.next = null;
        this.previous = null;

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

}