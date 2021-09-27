/*

Реалізувати колекцію LinkedList, ArrayList (З збільшенням capacity(розмір));
add();+
remove();+
size();+
contains();
Реалізувати клас SerializationUtil з методами серіалізації та десереалізації
**Stack, Queue 

*/


//import Lab2.*;

public class Program {
    public static void main(String[] args){
        LinkedList<Integer> ll = new  LinkedList<Integer>(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.printContent();
        System.out.println("size = " + ll.size());
        // ll.remove(4);
        // ll.printContent();
        // ll.remove(3);
        // ll.printContent();
        // ll.remove(2);
        // ll.printContent();
        // ll.remove(1);
        // ll.printContent();
        // System.out.println("new size = " + ll.size());
        
        System.out.println("contains 10 " + ll.contains(10));
        System.out.println("contains 5 " + ll.contains(5));
        System.out.println("contains -1 " + ll.contains(-1));
        System.out.println("contains 25 " + ll.contains(25));
        System.out.println("contains 3 " + ll.contains(3));

        System.out.println("");
        System.out.println("ArryaList");
        System.out.println("");

        ArrayList al = new ArrayList(3);
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        for(int i = 0 ; i < 20; i++){
            al.add(i);
            System.out.println("size = " + al.size());
            System.out.println("capacity = " + al.capacity());
        }
        al.printContent();
        System.out.println("size = " + al.size());
        System.out.println("contains 10 " + al.contains(10));
        System.out.println("contains 5 " + al.contains(5));
        System.out.println("contains -1 " + al.contains(-1));
        System.out.println("contains 25 " + al.contains(25));
        System.out.println("contains 3 " + al.contains(3));
        al.remove(4);
        al.printContent();
        al.remove(3);
        al.printContent();
        al.remove(2);
        al.printContent();
        al.remove(1);
        al.printContent();
        System.out.println("new size = " + al.size());

    }
}



