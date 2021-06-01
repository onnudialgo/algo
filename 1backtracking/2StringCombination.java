import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class StringCombination {

    public void solution(String input){
        char[] words = input.toCharArray();
        TreeMap<Character, Integer> countMap = new TreeMap<>();
        for(char ch: words){
            countMap.compute(ch, (key, val)->{
                if(val == null) return 1;
                else return val + 1;
            });
        }

        char[] str = new char[countMap.size()];
        int[] counts = new int[countMap.size()];
        int index = 0;
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            str[index] = entry.getKey();
            counts[index] = entry.getValue();
            index++;
        }
        slv(str, counts, 0, new ArrayList<>());

    }

    public void slv(char[] words, int[] counts, int position, ArrayList<Character> result) {
        for (int i = position; i < words.length; i++) {
            if (counts[i] > 0) {
                counts[i]--;
                result.add(words[i]);
                printResult(result);
                slv(words, counts, i, result);
                result.remove(result.size()-1);
                counts[i]++;
            }
        }
    }

    public void printResult(ArrayList<Character> result){
        for(char c : result){
            System.out.print(c);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        StringCombination c = new StringCombination();
        c.solution("AABC");
    }
}
