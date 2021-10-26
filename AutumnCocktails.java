import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queueIngredients = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueIngredients::offer);


        ArrayDeque<Integer> stackFreshness = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackFreshness::push);

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        while (!stackFreshness.isEmpty() && !queueIngredients.isEmpty()){
            int ingredient = queueIngredients.peek();
            int fresh = stackFreshness.peek();

            if(ingredient <= 0){
                queueIngredients.poll();
                continue;
            }



            int cocktail = ingredient*fresh;

            if(cocktail == 150){
                queueIngredients.poll();
                stackFreshness.pop();
                pearSour ++;
            }else if(cocktail == 250){
                queueIngredients.poll();
                stackFreshness.pop();
                theHarvest++;
            }else if(cocktail == 300){
                queueIngredients.poll();
                stackFreshness.pop();
                appleHinny++;
            }else if(cocktail == 400){
                queueIngredients.poll();
                stackFreshness.pop();
                highFashion++;
            }else{
               stackFreshness.pop();
               queueIngredients.offer(ingredient+5);
               queueIngredients.poll();
            }
        }
        int sumIngredients = 0;
        while (!queueIngredients.isEmpty()){
            sumIngredients+=queueIngredients.poll();
        }


            if(pearSour > 0 && theHarvest > 0 && appleHinny > 0 && highFashion  > 0){
                System.out.println("It's party time! The cocktails are ready!");
            }else{
                System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            }


        if(sumIngredients>0){
            System.out.println("Ingredients left: "+sumIngredients);
        }

        if(appleHinny>0) {
            System.out.println(" # Apple Hinny --> " + appleHinny);
        }
        if(highFashion>0) {
            System.out.println(" # High Fashion --> " + highFashion);
        }
        if(pearSour>0) {
            System.out.println(" # Pear Sour --> " + pearSour);
        }

        if(theHarvest>0) {
            System.out.println(" # The Harvest --> " + theHarvest);
        }

    }
}
