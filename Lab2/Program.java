import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*

Реалізувати колекцію LinkedList, ArrayList (З збільшенням capacity(розмір));
add();
remove();
size();
contains();
Реалізувати клас SerializationUtil з методами серіалізації та десереалізації
**Stack, Queue 

*/


//import Lab2.*;

public class Program {
    public static void main(String[] args){
        // LinkedList<Integer> ll = new  LinkedList<Integer>(3);
        // TestCollection(ll);

        // System.out.println("");
        // System.out.println("ArryaList");
        // System.out.println("");

        // ArrayList al = new ArrayList(3);
        // TestCollection(al);
        // System.out.println("new size = " + al.size());

        // System.out.println("");
        // System.out.println("Stack");
        // System.out.println("");

        // Stack<Integer> st = new Stack<Integer>(Integer.class , 3);
        // TestCollection(st);


        try{
            TestSerialization();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
 
    private static void TestSerialization() 
        throws IOException, ClassNotFoundException{
        Pojo newPojo = new Pojo();
        newPojo.isUsed = true;
        newPojo.number = 1;
        newPojo.title = "POJO";

        SerializationUtil util = new SerializationUtil(newPojo);

        FileOutputStream fileOutputStream
          = new FileOutputStream("yourfile2.txt");
        ObjectOutputStream objectOutputStream 
          = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(util);
        objectOutputStream.flush();
        objectOutputStream.close();
    
        FileInputStream fileInputStream 
          = new FileInputStream("yourfile2.txt");
        ObjectInputStream objectInputStream 
          = new ObjectInputStream(fileInputStream);
          SerializationUtil e2 = (SerializationUtil) objectInputStream.readObject();
        objectInputStream.close();
    
    }

    private static void TestCollection(ICollection collection){
        
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.printContent();
        System.out.println("size = " + collection.size());
        for(int i = 0 ; i < 20; i++){
            collection.add(i);
            System.out.println("size = " + collection.size());
            System.out.println("capacity = " + collection.capacity());
        }
        for(int i = 0 ; i < 20; i++){
            collection.remove(0);
        }
        collection.printContent();
        System.out.println("size = " + collection.size());
        System.out.println("contains 10 " + collection.contains(10));
        System.out.println("contains 5 " + collection.contains(5));
        System.out.println("contains -1 " + collection.contains(-1));
        System.out.println("contains 25 " + collection.contains(25));
        System.out.println("contains 3 " + collection.contains(3));
        collection.remove(4);
        collection.remove(3);
        collection.remove(2);
        collection.remove(1);
        collection.printContent();
        collection.remove(0);
    }
}



