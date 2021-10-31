import java.util.NoSuchElementException;
public class LinkedList<E> implements List<E> {
private Node<E> head;
private Node<E> tail;
private Integer size;
public LinkedList() {
        head = null;
        tail = null;
        // head.setNext(tail);
        size = 0;
}
public Node<E> getHead() {
        return head;
}
public Node<E> getTail() {
        return tail;
}
public String toString() {
        String result = "";
        if (this.getHead() == null) {
                return result = "List is empty";
        }
        Node<E> current = head;
        while(current != null) {
                result += current.getData();
                if(current.getNext() != null) {
                        result += ", ";
                }
                current = current.getNext();
        }
        return "List: " + result;
}
public void addAtIndex(E data, int index) {
        if (index < 0 || index > size) {
                throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        else if (data == null) {
                throw new IllegalArgumentException("You cannot add null data to the list");
        }
        if (head == null) {
                head = new Node<E>(data);
        }
        else {
                Node<E> tempStorage;
                Node<E> current = head;
                if (index == 0) {
                        tempStorage = new Node<E>(current.getData(), current.getNext());
                        head.setData(data);
                        head.setNext(tempStorage);
                }
                else {
                        if (index > 1) {
                                for (int x = 0; x < index - 1; x++) {
                                        current = current.getNext();
                                }
                        }
                        tempStorage = current.getNext();
                        current.setNext(new Node<E>(data, tempStorage));
                }
        }
        size();
}
public E getAtIndex(int index) {
        if (index < 0 || index > size - 1) {
                throw new IllegalArgumentException("Your index is out of bounds");
        }
        Node<E> current = head;
        for (int x = 0; x < index; x++) {
                current = current.getNext();
        }
        return current.getData();
}
public E removeAtIndex(int index) {
        if (index < 0 || index > size - 1) {
                throw new IllegalArgumentException("Your index is out of bounds");
        }
        Node<E> removedNode;
        Node<E> current = head;
        if (index == 0) {
                removedNode = new Node<E>(current.getData());
                head.setData(head.getNext().getData());
                head.setNext(head.getNext().getNext());
        }
        else {
                if (index > 1) {
                        for (int x = 0; x < index -1; x++) {
                                current = current.getNext();
                        }
                }
                removedNode = current.getNext();
                current.setNext(current.getNext().getNext());
        }
        size();
        return removedNode.getData();
}
public E remove(E data) {
        if (data == null) {
                throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        Node<E> removedNode = null;
        Node<E> current = head;
        if (head == null) {
                throw new NoSuchElementException("The data is not present in the list");
        }
        if (head.getData() == data) {
                if (head.getNext() == null) {
                        if (head.getData() == data) {
                                removedNode = current;
                                head = null;
                        }
                        else {
                                throw new NoSuchElementException("The data is not present in the list");
                        }
                }
                else {
                        removedNode = new Node<E>(head.getData());
                        head.setData(head.getNext().getData());
                        head.setNext(head.getNext().getNext());
                }
        }
        else {
                while (current.getNext().getData() != data) {
                        current.toString();
                        if (current.getNext() == null) {
                                throw new NoSuchElementException("The data is not present in the list");
                        }
                        else {
                                current = current.getNext();
                        }
                }
                removedNode = current.getNext();
                if (current.getNext().getNext() == null) {
                        current.setNext(null);
                }
                else {
                        current.setNext(current.getNext().getNext());
                }
        }
        size();
        return removedNode.getData();
}
public void clear() {
        head = null;
        size();

}
public boolean isEmpty() {
        return head == null? true:false;
}
public Integer getSize() {
        return size;
}
public int size() {
        Node<E> current = head;
        int x = 0;
        if (head == null) {
                return size;
        }
        else {
                x++;
                while (current.getNext() != null) {
                        current = current.getNext();
                        x++;
                }
                return size = x;

        }
}
}
