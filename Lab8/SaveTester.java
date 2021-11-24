import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StringReader;
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
            // String line = String.format(fieldSerFormat,field.toGenericString(),field.get(tx));
            fields.add(field);
        }

        saveMethod.invoke(tx, filePath, fields);
    }


    public static TextContainer DeSerialize() throws IOException, IllegalArgumentException, IllegalAccessException{
        String filePath = TextContainer.class.getAnnotation(SaveTo.class).path();
        FileInputStream fis = new FileInputStream(filePath);
        String[] contents = (new String(fis.readAllBytes(), StandardCharsets.UTF_8)).split(";");
        fis.close();

        // List<Field> fields = new ArrayList<Field>();
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

                // String searchedTypeName = field.getGenericType().getTypeName();
                // String givenTypeName = line.substring(0,line.indexOf(" "));
                // if(searchedTypeName == givenTypeName){
                Object value = line.substring(line.lastIndexOf(":")+1);
                field.set(result, value);
                // }
                // String currFieldName = line.substring(line.indexOf(className)+className.length()+1, endIndex);
                // line.split(regex)
            }
            // fields.add(field);
        }
        // String text = "Егор Алла Александр";
        // Pattern pattern = Pattern.compile("А.+а").matcher(text);
        // if (matcher.find()) {
        //     String res = text.substring(matcher.start(), matcher.end());
        // }
        return result;
    }

}
