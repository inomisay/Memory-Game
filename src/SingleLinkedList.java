
public class SingleLinkedList {
	
	// Attributes
	Node head;

	public int size() {
		int count = 0;
		if(head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while(temp != null) {
				count++;
				temp = temp.getLink();
			}
		}
		return count;
	}
	
	public void add(Object dataToAdd) {
		if(head == null) { // list is empty
			Node newnode = new Node(dataToAdd);
			head = newnode;
		} else {
			Node temp = head;
			while(temp.getLink() != null)
				temp = temp.getLink();
			Node newnode = new Node(dataToAdd);
			temp.setLink(newnode);
		}
	}
	
	public void sortAdd(Object dataToAdd) {
		if(head == null) { // list is empty
			Node newnode = new Node(dataToAdd);
			head = newnode;
		} else if((Integer)dataToAdd < (Integer)head.getData()) { // insert at front
			Node newnode = new Node(dataToAdd);
			newnode.setLink(head);
			head = newnode;
		} else {
			Node temp = head;
			Node previous = null;
			while(temp != null && (Integer)dataToAdd > (Integer)temp.getData()) {
				previous = temp;
				temp = temp.getLink();
			}
			if(temp == null) { // insert at last
				Node newnode = new Node(dataToAdd);
				previous.setLink(newnode);
			} else { // insert in between
				Node newnode = new Node(dataToAdd);
				newnode.setLink(previous.getLink());
				previous.setLink(newnode);
			}
		}
		
	}
	
	public void delete(Object dataToDelete) {
	    if(head == null) {
	        System.out.println("Linked list is empty");
	        return;
	    }
	    
	    // Delete nodes at the beginning of the list that match dataToDelete
	    while(head != null && head.getData().equals(dataToDelete)) {
	        head = head.getLink();
	    }
	    
	    // Delete nodes in the middle or end of the list that match dataToDelete
	    Node temp = head;
	    Node previous = null;
	    while(temp != null) {
	        if(temp.getData().equals(dataToDelete)) {
	            if(previous == null) { // the matching node is the first node
	                head = temp.getLink();
	            } else {
	                previous.setLink(temp.getLink());
	            }
	        } else {
	            previous = temp;
	        }
	        temp = temp.getLink();
	    }
	}

	public void display() {
		if (head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
			    temp = temp.getLink();
			 }
		}
	}
	
	public boolean search(Object item){
		boolean flag = false;
		if (head == null)
			System.out.println("linked list is empty"); 
		else {
			Node temp = head;
		    while (temp != null)  {
		    	if (item == temp.getData()) flag = true;
		         	temp = temp.getLink();
		      	}
		   	}
		return flag;
	}

}
