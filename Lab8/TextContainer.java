import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;

@SaveTo(path="file.txt")
public class TextContainer {
    @Save
    public String text = "sdffdsfdsdfs";

    @Save
    public int someNumber;

    @Saver
    public void save(String path, List<Field> fieldsToWrite) throws IOException, IllegalArgumentException, IllegalAccessException{
        final String fieldSerFormat = "%s:%s;\n";//generic_desc:value
        FileOutputStream fis = new FileOutputStream(path);
        for (Field field : fieldsToWrite) {
            String line = String.format(fieldSerFormat,field.toGenericString(),field.get(this));
            fis.write(line.getBytes(StandardCharsets.UTF_8));
        }
        fis.close();
    }
}
