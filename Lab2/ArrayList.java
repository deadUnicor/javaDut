
public class ArrayList{
    private Object[] _arr;
    private int _capacity;
    private int _length;

    public ArrayList(Object val) {
        _arr = new Object[2];
        _arr[0] = val;
        _capacity = 2;
        _length = 1;
    }

    public ArrayList(Object val, int length) {
        _arr = new Object[length * 2];
        for (int i  = 0; i < length; i++) {
            _arr[i] = val;
        }
        _capacity = _arr.length;
        _length = length;
    }

    public ArrayList(int length) {
        _arr = new Object[length*2];
        _capacity = _arr.length;
        _length = 0;
    }

    public int size(){
        return _length;
    }

    public int capacity(){
        return _capacity;
    }

    public void remove(int pos){
        if(pos >= _length){
            return;
        }

        _arr[pos] = _arr[_length - 1];
        _arr[_length - 1] = new Object();
        _length -= 1;
    }


    public void add(Object elem){
        _arr[_length] = elem;
        _length += 1;
        if(_length == _capacity){
            _capacity *= 2;
            Object[] newArr = new Object[_capacity];
            copyFromOld(newArr);
            _arr = newArr;
        }
    }

    private void copyFromOld(Object[] newArr){
        for (int i = 0 ; i < _length; i++) {
            newArr[i] = _arr[i];
        }
    }

    public boolean contains(Object elem){
        for (int i = 0; i < _length; ++i) {
            if(_arr[i] == elem){
                return true;
            }
        }
        return false;
    }

    public void printContent(){
        for (int i = 0; i < _length; ++i) {
            System.out.println(_arr[i].toString());
        }
    }

}