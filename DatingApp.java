import java.util.*;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stackMales = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackMales::push);


        ArrayDeque<Integer> queueFemales = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueFemales::offer);

        int matchesCount = 0;

        while (!stackMales.isEmpty() && !queueFemales.isEmpty()){
            int male = stackMales.peek();
            int feMale = queueFemales.peek();

            if(male<=0){
                stackMales.pop();
                continue;
            }

            if(feMale<=0){
                queueFemales.poll();
                continue;
            }

            if(male%25==0){
                stackMales.pop();
                stackMales.pop();
                continue;
            }

            if(feMale%25==0){
                queueFemales.poll();
                queueFemales.poll();
                continue;
            }


            if(male==feMale){
                stackMales.pop();
                queueFemales.poll();
                matchesCount++;
            }else{
                queueFemales.poll();
                stackMales.push(stackMales.pop()-2);
            }
        }

        int numMales = 0;
        int numFemales = 0;

        List<String> males = new ArrayList<>();
                while(!stackMales.isEmpty()){
                    males.add(stackMales.pop()+"");
                    numMales++;
                }

        List<String> feMales = new ArrayList<>();
        while(!queueFemales.isEmpty()){
            feMales.add(queueFemales.poll()+"");
            numFemales++;
        }



        System.out.println("Matches: "+matchesCount);

        if(numMales==0){
            System.out.println("Males left: none");
        }else{
            System.out.print("Males left: ");
               System.out.print(String.join(", ",males));
            System.out.println();
        }

        if(numFemales==0){
            System.out.println("Females left: none");
        }else{
            System.out.print("Females left: ");
                System.out.print(String.join(", ",feMales));
        }

    }
}
