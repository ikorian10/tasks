import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        try(Scanner numbers = new Scanner(new File(args[0]))) {
            while(numbers.hasNext()){
                nums.add(numbers.nextInt());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        minSteps(nums);
    }
    public static void minSteps(ArrayList<Integer> values){
        Collections.sort(values);
        int mid = values.get(values.size() / 2);
        int steps = 0;
        for(int num : values){
            steps += Math.abs(num - mid);
        }
        if(steps <= 20){
            System.out.println(steps);
        } else {
            System.out.println("20 ходов недостаточно для приведения всех элементов массива к одному числу");
        }
    }
}
