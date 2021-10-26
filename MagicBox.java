import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
                Arrays.stream(scan.nextLine().split("\\s+"))
                                    .map(Integer::parseInt)
                                    .forEach(queue::offer);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
                Arrays.stream(scan.nextLine().split("\\s+"))
                                    .map(Integer::parseInt)
                                    .forEach(stack::push);

                int itemsWorth = 0;

        while (!queue.isEmpty() && !stack.isEmpty()){
            int firstBoxItem = queue.peek();
            int secondBoxItem = stack.peek();
            int sum = firstBoxItem + secondBoxItem;

            if(sum%2==0){
                itemsWorth+=sum;
                queue.poll();
            }else{
                queue.offer(secondBoxItem);
            }
            stack.pop();
        }
        if (queue.isEmpty()) System.out.println("First magic box is empty.");
        if (stack.isEmpty()) System.out.println("Second magic box is empty.");

        if(itemsWorth>=90){
            System.out.println("Wow, your prey was epic! Value: "+itemsWorth);
        }else{
            System.out.println("Poor prey... Value: "+itemsWorth);
        }


    }
}
