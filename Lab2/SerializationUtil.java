import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationUtil implements Serializable{
    private Pojo _pojo;

    public SerializationUtil(Pojo _pojo) {
        this._pojo = _pojo;
    }

    private void writeObject(ObjectOutputStream oos) 
      throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(_pojo);
    }

    private void readObject(ObjectInputStream ois) 
      throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        Pojo pojo = (Pojo)ois.readObject();
        _pojo = pojo;
    }
}
