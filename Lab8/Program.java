import java.lang.reflect.Method;

public class Program {
    public static void main(String[] Args) throws Exception{
        TestEverything();
        //SaveTester.SaveAll();
        TextContainer tc = SaveTester.DeSerialize();
    }

    public static void TestEverything(){
        for (Method method : Program.class.getMethods()) {
            if(method.isAnnotationPresent(TestAttr.class)){
                try{
                    var annotation = method.getAnnotation(TestAttr.class);
                    method.invoke(new Program(), annotation.a(), annotation.b(), annotation.expected());
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        }
    }

    @TestAttr(a=2,b=5,expected=7)
    public void test(int a, int b,int expected) throws Exception{
        int res = a+b;
        if(res != expected){
            throw new Exception("Test failed: expected:"+expected+"; actual="+res);
        }
        System.out.println("Test passed! Result is like expected");
    }

}
