import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SaveTester {
    
    public static void SaveAll() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        TextContainer tx = new TextContainer();
        tx.text = "some cool text";
        tx.someNumber = 123;
        
        String filePath = TextContainer.class.getAnnotation(SaveTo.class).path();
        Method saveMethod = Arrays.stream(TextContainer.class.getMethods()).filter(x->x.isAnnotationPresent(Saver.class)).findFirst().get();
        List<Field> fields = new ArrayList<Field>();
        for(Field field : TextContainer.class.getFields()){
            if(!field.isAnnotationPresent(Save.class)){
                continue;
            }
            fields.add(field);
        }

        saveMethod.invoke(tx, filePath, fields);
    }


    public static TextContainer DeSerialize() throws IOException, IllegalArgumentException, IllegalAccessException{
        String filePath = TextContainer.class.getAnnotation(SaveTo.class).path();
        FileInputStream fis = new FileInputStream(filePath);
        String[] contents = (new String(fis.readAllBytes(), StandardCharsets.UTF_8)).split(";");
        fis.close();

        TextContainer result = new TextContainer();
        String className = TextContainer.class.getName();
        for(Field field : TextContainer.class.getFields()){
            if(!field.isAnnotationPresent(Save.class)){
                continue;
            }

            for (String line : contents) {
                String fieldName =  className +"."+ field.getName();
                if(!line.contains(fieldName)){
                    continue;
                }

                String strValue = line.substring(line.lastIndexOf(":")+1);
                Object value = ParseStringToFieldType(field, strValue);
                field.set(result, value);
           
            }

        }

        return result;
    }

    private static Object ParseStringToFieldType(Field field, String value){
        
        switch (field.getGenericType().getTypeName()) {
            case "int":
                return Integer.parseInt(value);
            case "double":
                return Double.parseDouble(value);
            case "float":
                return Float.parseFloat(value);
            default:
                return value;
        } 
    }

}
