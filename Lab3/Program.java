import java.util.List;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;


public class Program{

    public static void main(String[] args){
        Task1();
        Task2();
        Task3();
    }

    private static void Task1(){
        System.out.println();
        System.out.println("=================Task 1 ==================");
        System.out.println();
        /*Вивести в консоль всі змінні в відсортованому вигляді
         які починаються з «с» та трансформувати їх в верхній регістр 
         */
        List<String> myList = Arrays.asList("Cac1", "ca2", "b1", "c2", "c1"); 
        
        var result = myList.stream().filter(x -> x.startsWith("c") ).map(x -> (x.toUpperCase())).sorted().toList();
        String joinedString = String.join(", ", result);
        System.out.println(joinedString);
    }

    private static void Task2(){
        System.out.println();
        System.out.println("=================Task 2 ==================");
        System.out.println();
        /*Заповнити масив розміром n рандомними значеннями в діапазоні (від 0 до 9) та порахувати середнє арифметичне всіх парних чисел */
        Random rn = new Random();
        int n = 10;
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = rn.nextInt(10); 
            System.out.print(arr[i] + ", ");
        }
        System.out.println();

        double average = Arrays.stream(arr).filter(x -> x % 2 == 0).average().getAsDouble();
        System.out.println("avg: " + average);
    }


    private static void Task3(){
        System.out.println();
        System.out.println("=================Task 3 ==================");
        System.out.println();
        /*Данний рядок «sjdhgfsjkavchjwagehf» (Просто набір букв в нижньому регістрі), потрібно підняти в верхній регістр всі букви в діапазоні від H до T по алфавіту */
        String input = "sjdhgfsjkavchjwagehf";

        var res = Stream
            .of(input.split(""))
            .map(x -> {
                if(x.matches("[h-t]")){
                    x = x.toUpperCase();
                }
                return x;
            })
            .toList();

        System.out.println(String.join(", ", res));
    }


}