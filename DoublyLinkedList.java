public class DoublyLinkedList{
  
  private class LinkedNode{
    private int payload;
    private LinkedNode next;
    private LinkedNode previous;
    
    private LinkedNode(int payload,LinkedNode previous,LinkedNode next){
      this.payload=payload;
      this.previous=previous;
      this.next=next;
    }
    
    private int getPayload(){return payload;}
  }
  private LinkedNode head;
  private int size=0;
  
  private DoublyLinkedList(LinkedNode head){this.head=head;}
  public DoublyLinkedList(){this(null);}
    
  private void add(LinkedNode node){
    if (head==null){
      head=node;
      return;
    }
    LinkedNode currentNode = head;
    while (currentNode.next!=null){
      currentNode=currentNode.next;
    }
    currentNode.next=node;
    node.previous=currentNode;      
    size++;
  }

  public void add(int payload){this.add(new LinkedNode(payload,null,null));}
  
  public String toString(){
    String result=new String();
    LinkedNode currentNode = head;
    while (currentNode!=null){
      result+=currentNode.getPayload()+" ";
      currentNode=currentNode.next;
    }
    return result;
  }
  
  public boolean exists(int payload){
    LinkedNode currentNode = head;
    while(currentNode!=null){
      if (currentNode.getPayload()==payload) return true;
      currentNode=currentNode.next;
    }
    return false;
  }
  
  public int getSize(){return size;}
  
  public boolean delete(int payload){
    if (head==null) return false;
    else if (head.getPayload()==payload){
      head=head.next;  
      head.previous=null;
      size--;
      return true;
    }
    LinkedNode currentNode=head;
    while (currentNode.next!=null){
      if (currentNode.next.getPayload()==payload){
        LinkedNode newNext=currentNode.next.next;
        currentNode.next=newNext;
        newNext.previous=currentNode;
        size--;
        return true;
      }
      currentNode=currentNode.next;
    }
    return false;
  }
  
  public void reverse(){
    LinkedNode currentNode=head;
    if (currentNode==null) return;
    while (currentNode.next!=null){
      LinkedNode temp=currentNode.next;
      currentNode.next=currentNode.previous;
      currentNode.previous=temp;
      currentNode=currentNode.previous;
    }
    LinkedNode temp=currentNode.next;
    currentNode.next=currentNode.previous;
    currentNode.previous=temp;
    head=currentNode;
    //System.out.println(head.next.getPayload());
  }
  
  public static void main(String[] args){
    DoublyLinkedList list=new DoublyLinkedList();
    list.add(3);
    list.add(5);list.add(13);list.add(35);list.add(83);list.add(23);
    System.out.println(list.toString());
    list.reverse();
    System.out.println(list.toString());
    System.out.println(list.exists(3));
  
  }
  
}