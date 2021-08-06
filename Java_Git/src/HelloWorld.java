import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// My First Program
class HelloWorld {
	public static LinkedList<Integer> l1[]; 
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        
        LinkedList<LinkedList<Integer>> td = new LinkedList<LinkedList<Integer>>();
        
        LinkedList<Integer> l1=new LinkedList<Integer>();
        l1.add(1);
        td.add(l1);
     
        
        ArrayList<LinkedList<Integer>> al=new ArrayList<LinkedList<Integer>>();
        
        LinkedList<Integer> l2=new LinkedList<Integer>();
        l2.add(2);
        l2.add(3);
        l2.add(4);
        al.add(l2);
      //  al.add(l1);
        
        ListIterator<Integer> itr= al.get(0).listIterator();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        //System.out.println(al.get(0).);
       // LinkedList<Integer> temp=al.get(0);
        
       // al.get(1).addAll(al.get(0));
        
        al.add(1,al.get(0));
        
        ListIterator<Integer> itr1= al.get(1).listIterator();
        
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }
        System.out.println(al.get(1).size());
        
        
        System.out.println(al.get(0)==al.get(1));
      
    }
}