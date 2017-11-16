package P7;

public class Hashtable{
	
	public class HashNode{
		private String key;
		private String value;
		private HashNode next;
		
		public HashNode(String newKey, String newValue){
			this.key = newKey;
			this.value = newValue;
			this.next = null;
		}
	}
	
	
	private HashNode[] arr;
	private int size;
	public Hashtable() {
		arr = new HashNode[1000000];
		size = 0;
	}
	
	public boolean containsKey(String key){
		int index =  ((Math.abs(key.hashCode())) % (arr.length));
		HashNode current = arr[index];
		if(current == null){
			return false;
		}else{
			while(current != null){
				if(current.key.equals(key)){
					return true;
				}
				current = current.next;
			}
		}
		
		return false;	
		
	}
	
	public String get(String key){
		//check if the key in the hashtable;
		if(!containsKey(key)){
			return null;
		}
		int index =  ((Math.abs(key.hashCode())) % (arr.length));
		HashNode start = arr[index];
		while(start != null){
			if(start.key.equals(key)){
				return start.value;
			}
			start = start.next;
		}
		return null;
}
	
	public void put(String key, String value){
		int index =  ((Math.abs(key.hashCode())) % (arr.length));
		HashNode start = arr[index];
		HashNode newNode = new HashNode(key, value);
		
			if(arr[index] == null){
				arr[index] = newNode;
				size++;
				return;
			}
			start.next = newNode;
			arr[index] = start;
			size++;
			
	}

	public String remove(String key) throws Exception{

		if(!containsKey(key)){
			throw new Exception();
		}
		int index =  ((Math.abs(key.hashCode())) % (arr.length));
		HashNode current = arr[index];
		if(current.key.equals(key)){
			arr[index] = current.next;
			size--;
			return current.value;
		}
		
		HashNode previous = current;
		current = current.next;
		
		while(current!= null){
			if(current.key.equals(key)){
				previous.next = current.next;
				size--;
				return current.value;
			}
			previous = current;
		    current = current.next;	
		}

		return null;
}
 
}
