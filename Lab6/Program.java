
public class Program {
    public static void main(String[] Args) throws Exception{
        Task1(Args);
        final int arrLen = 6;
        Task2(arrLen);
        Task3();
    }

    private static void Task1(String[] args) throws Exception{
        float right;
        float result = 0;

        String[] operands = args[0].split("[+\\-*/]");
        String[] operators = args[0].split("[\\d]");
        result =  Float.parseFloat(operands[0]);
        for (int i = 1; i < operators.length; i++) {
            right = Float.parseFloat(operands[i]);
            switch (operators[i]) {
                case "+":
                    result += right;
                    break;
                case "*":
                    result *= right;            
                    break;
                case "-":    
                    result -= right;
                    break;
                case "/":
                    result /= right;
                    break;
                default:
                    throw new Exception("no such operator" + operators[i]);
            }
        }
        System.out.println(result);
    }

    private static void Task2(int arrLen){
        int[] arr = new int[arrLen];
        int max = arrLen/2;

        for (int i = 0; i <= max; i++) {
            arr[i] = max - i;
        }

        for(int i = max+1; i < arr.length; i++){
            arr[i] = i - max;
        }
        //не было сказано, какое поведение должно быть при len % 2 == 0, так что оставляю 3, 2, 1, 0, 1, 2
        for(int i : arr){
            System.out.print(i + ", ");
        }
    }

    private static void Task3(){
        System.out.println("\n1 - enter;\n2 - show all;\n3 - exit;");
        StringBuilder stringBuilder = new StringBuilder();
        boolean cont = true;
        while (cont) {
            String line = System.console().readLine();
            switch (line) {
                case "1": {
                    String input = System.console().readLine();
                    if (input.startsWith("+")) {
                        stringBuilder.append(input.substring(1, input.length())).append(" ");
                    } else if (isValidWordToRemove(stringBuilder.toString(), input)) {
                        String sub = input.substring(1);
                        stringBuilder = new StringBuilder(stringBuilder.toString().replaceAll(sub+"\s*", "").trim());
                    }else{
                        System.out.println("Word is not found");
                    }
                    break;
                }
                case "2": {
                    String res = stringBuilder.toString();
                    System.out.println(res);
                    break;
                }
                case "3": {
                    System.out.println("Exiting");
                    cont = false;
                    return;
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private static boolean isValidWordToRemove(String str, String toDelete){
        return toDelete.startsWith("-") && str.contains(toDelete.substring(1, toDelete.length()));
    }

}
