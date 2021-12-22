import java.util.Arrays;

public class Program {

    public static void main(String[] args){
        var res = findUnique(new int[]{1,2,1,1,1,1});
        System.out.println(res);
        System.out.println();
        System.out.println();
        System.out.println();
//        int[] inp = new int[]{5,3,2,8,1,5};
        int[] inp = new int[]{5,3,2,8,1,5,8,6,9,2,1,5,5,7,0,4}; // на такой массив ушло 16 итераций (не включая сортировку)
        int[] sorted = sort(inp);
        for(int i:sorted){
            System.out.print(String.format("%s,", i));
        }
    }


    private static int findUnique(int[] input) throws IllegalArgumentException{
        if(input.length == 0)
            throw new IllegalArgumentException();

        if(input.length == 1)
            return input[0];
            
        if(input.length % 2 != 0) {
            return xorArr(input);
        }
        
        if(input[0] == input[1]) {
            return xorArr(Arrays.stream(input).skip(1).toArray());
        }
        
        if (input[0] == input[2]) {
            return input[1];
        }else {
            return input[0];
        }
        
    }

    private static int xorArr(int [] arr){
        int res = 0;
        for(int i = 1; i < arr.length; ++i) {
            if(res != 0)
                return arr[i-1];
            res = arr[i-1] ^ arr[i];
        }
        return res;
    }
    
    private static int[] sort(int [] arr){
//        int iterations = 0;
        int countOdd = 0;
        int[] oddPosArr = new int[arr.length];
        int[] oddArr = new int[arr.length];
        for(int i = 0; i < arr.length; ++i) {
            if(isEven(arr[i])) {
                continue;
            }
            oddPosArr[countOdd] = i;
            oddArr[countOdd] = arr[i];
            countOdd++;
//            iterations++;
        }
        
        oddPosArr = Arrays.stream(oddPosArr).limit(countOdd).toArray();
        int[] sortedOddArr = Arrays.stream(oddArr).limit(countOdd).sorted().toArray();
        
        for(int i = 0; i < oddPosArr.length; ++i) {
            arr[oddPosArr[i]] = sortedOddArr[i];
//            iterations++;
        }
//        System.out.println(iterations);
        return arr;
    }
  
    static boolean isEven(int a){
        return a % 2 == 0;
    }
    
}
