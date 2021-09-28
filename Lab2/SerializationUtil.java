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
        oos.writeObject(_pojo.number);
        oos.writeObject(_pojo.isUsed);
        oos.writeObject(_pojo.title);
    }

    private void readObject(ObjectInputStream ois) 
      throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        Pojo pojo = new Pojo();
        pojo.number = (int)ois.readObject();
        pojo.isUsed = (boolean)ois.readObject();
        pojo.title =  (String)ois.readObject();
        _pojo = pojo;
    }
}
