
public class LinkedList<T> implements ICollection<T>{
    private T _val;
    private LinkedList<T> _next;

    public LinkedList(T val) {
        _val = val;
    }

    @Override
    public void add(T value){
        if(_next == null){
            _next = new LinkedList<T>(value);
            return;
        }
        _next.add(value);
    }

    @Override
    public int size(){
        if(_next == null){
            return 1;
        }
        return _next.size() + 1;
    }

    @Override
    public int capacity() {
        return size();
    }

    @Override
    public void remove(int pos){
        LinkedList<T> curr = this;
    
        checkForIndexBoundary(pos);

        if(pos == 0){
            removeItself();
            return;
        }

        for(int i = 0; i < pos - 1; i++){
            if(curr != null){
                curr = curr._next;
            }
        }
        
        LinkedList<T> next = curr._next;
        if(next == null){
            throw new ArrayIndexOutOfBoundsException("Can't delete itself");
        }
        curr._next = next._next;
        next = null;
    }

    private void checkForIndexBoundary(int givenIndex){
        int size = size();
        if(givenIndex > size){
            throw new ArrayIndexOutOfBoundsException("index was " + givenIndex + " but max index is " + (size - 1));
        }
    }

    private void removeItself(){
        if(_next == null){
            _val = null;
            return;
        }
        _val = _next._val;
        _next = _next._next;
    }

    @Override
    public boolean contains(T searchedValue){
        LinkedList<T> iterator = this;
        while(iterator != null){
            if(iterator._val == searchedValue){
                return true;
            }
            iterator = iterator._next;
        }
        return false;
    }

    @Override
    public void printContent(){
        printAll();
    }

    private String printAll(){
        System.out.println(_val.toString());
        if(_next != null){
            return _next.printAll();
        }
        return "";
    }

}
