public class SinglyLinkedList{
  
  private class LinkedNode{
    private int payload;
    private LinkedNode next;
    
    private LinkedNode(int payload,LinkedNode next){
      this.payload=payload;
      this.next=next;
    }
    
    private int getPayload(){return payload;}
    private LinkedNode getNext(){return next;}
  }
  private LinkedNode head;
  private int size=0;
  
  private SinglyLinkedList(LinkedNode head){this.head=head;}
  public SinglyLinkedList(){this(null);}
  
  private LinkedNode getHead(){return head;}
  
  private void add(LinkedNode node){
    LinkedNode currentNode = getHead();
    if (currentNode==null) head=node;
    else{
      while (currentNode.next!=null){
        currentNode=currentNode.getNext();
      }
      currentNode.next=node;
    }
    size++;
  }

  public void add(int payload){this.add(new LinkedNode(payload,null));}
  
  public String toString(){
    String result=new String();
    LinkedNode currentNode = getHead();
    while (currentNode!=null){
      result+=currentNode.getPayload()+" ";
      currentNode=currentNode.getNext();
    }
    return result;
  }
  
  public boolean exists(int payload){
    LinkedNode currentNode = getHead();
    while(currentNode!=null){
      if (currentNode.getPayload()==payload) return true;
      currentNode=currentNode.getNext();
    }
    return false;
  }
  
  public int getSize(){return size;}
  
  public boolean delete(int payload){
    LinkedNode currentNode=getHead();
    if (currentNode.getPayload()==payload) head=head.next;
    if (currentNode==null) return false;
    while (currentNode.next!=null){
      if (currentNode.next.getPayload()==payload){
        currentNode.next=currentNode.getNext().getNext();
        return true;
      }
      currentNode=currentNode.getNext();
    }
    return false;
  }
  
  public void reverse(){
    if (head==null) return;
    LinkedNode previousNode=null;
    LinkedNode currentNode = head;
    while(currentNode.next!=null){
      LinkedNode nextNode=currentNode.next;
      currentNode.next=previousNode;
      previousNode=currentNode;
      currentNode=nextNode;
    }
    currentNode.next=previousNode;
    head=currentNode;
  }
  
  public static void main(String[] args){
    SinglyLinkedList list=new SinglyLinkedList();
    list.add(3);
    list.add(5);list.add(13);list.add(35);list.add(83);list.add(23);
    System.out.println(list.toString());
    list.reverse();
    System.out.println(list.toString());
    System.out.println(list.exists(3));
  
  }
  
}