import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        HashMap<String ,Integer> map = new HashMap<>();
        int count = 0;
        
        while(scan.hasNextLine()) {
            String str = scan.nextLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            count++;
        }
        
        Object[] keyArr = map.keySet().toArray(); // 키 값을 배열로 받아옴
        Arrays.sort(keyArr); 
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < keyArr.length; i++) {
            int value = map.get(keyArr[i]);
            double percent = ((double)value /(double) count) * 100;
            sb.append(keyArr[i] + " " + String.format("%.4f", percent) + "\n");
        }
        System.out.println(sb.toString());
    }
}