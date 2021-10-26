import java.util.Scanner;

public class MouseAndCheese {
    static int pRow = 0;
    static int pCol = 0;
    static int numCheese = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scan.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();

            if (line.contains("M")) {
                pRow = row;
                pCol = line.indexOf("M");

                matrix[pRow][pCol] = '-';
            }
        }

        String command = scan.nextLine();

        while (!command.equals("end")) {
            if (command.equals("up")) {
                pRow -= 1;

                if (isOutOfBounds(matrix, pRow, pCol)) {
                    System.out.println("Where is the mouse?");
                    matrix[pRow+1][pCol]='-';
                    break;
                } else {
                    matrix[pRow + 1][pCol] = '-';
                    if (matrix[pRow][pCol] == 'c') {
                        numCheese++;
                    } else if (matrix[pRow][pCol] == 'B') {
                        pRow -= 1;
                        if (isOutOfBounds(matrix, pRow, pCol)) {
                            System.out.println("Where is the mouse?");
                            matrix[pRow+1][pCol]='-';
                            break;
                        }else {
                            matrix[pRow + 1][pCol] = '-';
                            if (matrix[pRow][pCol] == 'c') {
                                numCheese++;
                            }
                        }
                    }
                    matrix[pRow][pCol]='M';
                }

            } else if (command.equals("right")) {
                pCol += 1;
                if (isOutOfBounds(matrix, pRow, pCol)) {
                    System.out.println("Where is the mouse?");
                    matrix[pRow][pCol-1]='-';
                    break;
                } else {
                    matrix[pRow ][pCol-1] = '-';
                    if (matrix[pRow][pCol] == 'c') {
                        numCheese++;
                    } else if (matrix[pRow][pCol] == 'B') {
                        pCol += 1;
                        if (isOutOfBounds(matrix, pRow, pCol)) {
                            System.out.println("Where is the mouse?");
                            matrix[pRow][pCol-1]='-';
                            break;
                        } else {
                            matrix[pRow][pCol - 1] = '-';
                            if (matrix[pRow][pCol] == 'c') {
                                numCheese++;
                            }
                        }
                    }
                    matrix[pRow][pCol]='M';
                }
                } else if (command.equals("left")) {
                pCol -= 1;
                if (isOutOfBounds(matrix, pRow, pCol)) {
                    System.out.println("Where is the mouse?");
                    matrix[pRow][pCol+1]='-';
                    break;
                } else {
                    matrix[pRow ][pCol+1] = '-';
                    if (matrix[pRow][pCol] == 'c') {
                        numCheese++;
                    } else if (matrix[pRow][pCol] == 'B') {
                        pCol -= 1;
                        if (isOutOfBounds(matrix, pRow, pCol)) {
                            System.out.println("Where is the mouse?");
                            matrix[pRow][pCol+1]='-';
                            break;
                        } else {
                            matrix[pRow][pCol + 1] = '-';
                            if (matrix[pRow][pCol] == 'c') {
                                numCheese++;
                            }
                        }
                    }
                    matrix[pRow][pCol]='M';
                }
                } else if (command.equals("down")) {
                pRow += 1;
                if (isOutOfBounds(matrix, pRow, pCol)) {
                    System.out.println("Where is the mouse?");
                    matrix[pRow-1][pCol]='-';
                    break;
                } else {
                    matrix[pRow - 1][pCol] = '-';
                    if (matrix[pRow][pCol] == 'c') {
                        numCheese++;
                    } else if (matrix[pRow][pCol] == 'B') {
                        pRow += 1;
                        if (isOutOfBounds(matrix, pRow, pCol)) {
                            System.out.println("Where is the mouse?");
                            matrix[pRow-1][pCol]='-';
                            break;
                        } else {
                            matrix[pRow - 1][pCol] = '-';
                            if (matrix[pRow][pCol] == 'c') {
                                numCheese++;
                            }
                        }
                    }
                    matrix[pRow][pCol]='M';
                }

            }
            command = scan.nextLine();
            }

         if (numCheese>=5){
             System.out.println("Great job, the mouse is fed "+numCheese+" cheeses!");
         }else{
             System.out.println("The mouse couldn't eat the cheeses, she needed "+(5-numCheese)+" cheeses more.");
         }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

        }


    private static boolean isOutOfBounds(char[][] matrix, int newRow, int newCol) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }

}