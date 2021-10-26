import java.util.Scanner;

public class BookWorm {
    static int pRow = 0;
    static int pCol = 0;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scan.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();

            if (line.contains("P")){
                pRow = row;
                pCol = line.indexOf("P");

                matrix[pRow][pCol]='-';
            }
        }

        String command = scan.nextLine();

            while (!command.equals("end")) {
                switch (command) {
                    case "up":
                        pRow -= 1;
                        if (isOutOfBounds(matrix,pRow,pCol)){
                            if(input.length()>0){
                            input = input.substring(0,input.length()-1);
                            }
                            pRow += 1;
                        }else {
                            matrix[pRow + 1][pCol] = '-';
                            char element = matrix[pRow][pCol];

                            if (Character.isLetter(element) && element!='P') {
                                input += element;

                            }
                        }
                        matrix[pRow][pCol] = 'P';
                        break;
                    case "right":
                        pCol += 1;
                        if (isOutOfBounds(matrix,pRow,pCol)){
                            if(input.length()>0){
                                input = input.substring(0,input.length()-1);
                            }
                            pCol -= 1;
                        }else {
                            matrix[pRow][pCol - 1] = '-';
                            char element = matrix[pRow][pCol];

                            if (Character.isLetter(element) && element!='P') {
                                input += element;

                            }

                        }
                        matrix[pRow][pCol] = 'P';
                        break;
                    case "left":
                        pCol -= 1;
                        if (isOutOfBounds(matrix,pRow,pCol)){
                            if(input.length()>0){
                                input = input.substring(0,input.length()-1);
                            }
                            pCol += 1;
                        }else {
                            matrix[pRow][pCol + 1] = '-';
                            char element = matrix[pRow][pCol];

                            if (Character.isLetter(element) && element!='P') {
                                input += element;

                            }

                        }
                        matrix[pRow][pCol] = 'P';
                        break;
                    case "down":
                     pRow += 1;
                        if (isOutOfBounds(matrix,pRow,pCol)){
                            if(input.length()>0){
                                input = input.substring(0,input.length()-1);
                            }
                            pRow -= 1;
                        }else {
                            matrix[pRow - 1][pCol] = '-';
                            char element = matrix[pRow][pCol];

                            if (Character.isLetter(element) && element!='P') {
                                input += element;
                            }

                        }
                        matrix[pRow][pCol] = 'P';
                        break;
                }
                command = scan.nextLine();
            }

        System.out.println(input);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }


    private static boolean isOutOfBounds(char[][] matrix, int newRow, int newCol) {
        return newRow<0 || newRow>= matrix.length || newCol<0 || newCol>= matrix[newRow].length;
    }
}
