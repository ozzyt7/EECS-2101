package q2SLL;

/*****************5 Marks************************
 * Node class representing a song in the playlist
 */
class Node {
	int data;
	Node next;
	
    
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}

/**
 * MusicPlaylist class implementing singly linked list operations
 */
class  MusicPlaylist {
    private Node head;
    private int size;
    
    /**
     * Constructor to initialize empty playlist
     */
    public MusicPlaylist() {
    	this.head = null;
    	this.size = 0;
    }

    
    /*****************5 Marks************************
     * Method to add a song to the end of the playlist
     * @param songId - The ID of the song to be added
     */
    public void addSong(int songId) {
    	Node newNode = new Node(songId);
    	
    	if (head == null) {
    		head = newNode;
    	}
    	else {
    		Node current = head;
    		while(current.next != null) {
    			current = current.next;
    		}
    		current.next = newNode;
    	
    	}
    	size++;
    }
    
    /*****************10 Marks************************
     * Method to find if a pattern exists in the playlist
     * @param pattern - Array of song IDs to search for
     * @return true if pattern is found, false otherwise
     */
    public boolean findPattern(int[] pattern) {
    	Node current = head;

    	while (current != null){
    		int counter = 0;
    		Node temp = current;
    		
    		while (temp != null && counter < pattern.length && pattern[counter] == temp.data){
    			temp = temp.next;
    			counter++;
    		}
    		if(counter == pattern.length) {
    			return true;
    		}
    		
    		current = current.next;
    	}
        return false;
    }
    
    /*****************10 Marks************************
     * Method to display all songs with their indices
     */
    public void displayWithIndices() {
    	if (size == 0) {
    		System.out.print("Playlist is empty!");
    	}
    	StringBuilder sb = new StringBuilder();
    	Node current = head;
    	int index = 0;
    	
    	while (current != null) {
    		sb.append("Index " + index + ": Song ID " + current.data);
    		index++;
    		current = current.next;
    	}
    	
    	System.out.println(sb.toString());
    	
    }
    
    /*****************15 Marks(10+5)************************
     * Method to count how many times a pattern occurs in the playlist
     * (including overlapping occurrences)
     * @param pattern - Array of song IDs to search for
     * @return count of pattern occurrences
     */
    public int countPatternOccurrences(int[] pattern) {
    	if (pattern == null || pattern.length == 0) {
    		return 0;
    	}
    	Node current = head;
    	int patCounter = 0;

    	while (current != null){
    		int counter = 0;
    		Node temp = current;
    		
    		while (temp != null && counter < pattern.length && pattern[counter] == temp.data){
    			temp = temp.next;
    			counter++;
    		}
    		
    		if(counter == pattern.length) {
    			patCounter++;
    		}
    		
    		current = current.next;
    	}
        return patCounter;
    }
    
    /**
     * Method to get playlist as string for display
     * @return String representation of playlist
     * You can check the codes that are provided to you with SLL during lectures to help with this method.
     */
    public String getPlaylistAsString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
    	
    	if (size == 0) {
    		sb.append("]");
    		return sb.toString();
    	}
    	Node current = head;
    	
    	while (current.next != null) {
    		sb.append(current.data + ", ");
    		current = current.next;
    	}
    	sb.append(current.data + "]");
    	return sb.toString();
}
}