import java.lang.reflect.Array;

import javax.swing.text.AbstractDocument.LeafElement;

public class Stack<T> implements ICollection<T> {
    private T[] _elems;
    private int _capacity;
    private int _length;
    private Class<T> _classType;

    public Stack(Class<T> clazz, T val) {
        _capacity = 2;
        _length = 1;
        _classType = clazz;
        _elems = (T[]) Array.newInstance(_classType, _capacity);
    }

    public Stack(Class<T> clazz, int capacity) {
        _capacity = capacity;
        _length = 0;
        _classType = clazz;
        _elems = (T[]) Array.newInstance(clazz, _capacity);
    }

    @Override
    public int size() {
        return _length;
    }

    @Override
    public int capacity() {
        return _capacity;
    }

    @Override
    public void add(T elem){
        _elems[_length] = elem;
        _length += 1;
        if(_length == _capacity){
            resize();
        }
    }

    private void resize(){
        _capacity *= 2;
        T[] newArr = (T[]) Array.newInstance(_classType, _capacity);
        copyFromOld(newArr);
        _elems = newArr;
    }

    private void copyFromOld(Object[] newArr){
        for (int i = 0 ; i < _length; i++) {
            newArr[i] = _elems[i];
        }
    }

    @Override
    public void printContent() {
        for(int i = _length - 1; i >= 0 ; --i){
            System.out.println(_elems[i]);
        }        
    }

    @Override
    public boolean contains(T val) {
        for (int i = _length - 1; i >= 0; --i) {
            if(_elems[i] == val){
                return true;
            }
        }
        return false;  
    }

    @Override
    public void remove(int index) {
        pop();
    }

    public T pop(){
        if(_length == 0){
            return null;
        }

        _length -= 1;
        T res = _elems[_length];
        _elems[_length] = null;
        return res;
    }

}
