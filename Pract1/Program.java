public class Program {
    
    public static void main(String[] Args) throws Exception{
        Task1();
        Task2();
        Task3();
        Task4();
    }

    private static String[] Task1(){
        String[] words = new String[] {"Don't","worry",",","be","happy!"};
        // String[] expected = new String[] {"Don't","worry",",","be","happy!"};

        int[] arrayOfLengths = new int[words.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< words.length;i++) {
            arrayOfLengths[i] = words[i].length();
            sb.append(words[i]);
        }
        String finalString = sb.reverse().toString();
        String[] resultingArray = new String[words.length];

        for (int beginIndex = 0 , i = 0; i < arrayOfLengths.length; i++) {
            resultingArray[i] = finalString.substring(beginIndex, beginIndex += arrayOfLengths[i]);
            System.out.println(resultingArray[i]);
        }
        return resultingArray;
    }


    private static void Task2(){
        findMultiples(3, 4);
        findMultiples(2, 3);
    }

    public static int[] findMultiples(int x,int n){
        int[] res = new int[x];
        // System.out.print("[");
        for (int i = 1; i <= x; i++) {
            res[i-1] = n *= i;
            // System.out.print(res[i-1] + " ");
        }
        // System.out.print("]");
        // System.out.println();
        return res;
    }

    private static void Task3(){
        String[] blacklist = new String[]{"black","list","badword", "pron"};
        String badPhrase = "some pron is not in black good";
        String goodPhrase = "some movies are good";
        
        System.out.println(hasNoneLetters(blacklist, badPhrase) == false);
        System.out.println(hasNoneLetters(blacklist, goodPhrase) == true);

    }

    public static boolean hasNoneLetters(String[] blackList, String phrase){        
        String[] words = phrase.toLowerCase().replaceAll("[^a-z0-9\s]", "").split(" ");
        for (String word : words) {
            for (String badWord : blackList) {
                if(word.equalsIgnoreCase(badWord)){
                    return false;
                }
            }
        }
        return true;
    }

    private static void Task4(){
        String phrase = "Some text where I have to find the longest word";
        String[] words = phrase.replaceAll("[^a-zA-Z\s]", "").split(" ");
        int max = -1;
        String theLongest = null;
        for (String string : words) {
            if(string.length() > max){
                max = string.length();
                theLongest = string;
            }
        }
        System.out.println(theLongest);
        System.out.println(max);
    }

}
