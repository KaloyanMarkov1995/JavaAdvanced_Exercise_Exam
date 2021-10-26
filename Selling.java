import java.util.Scanner;

public class Selling {
    static int pRow = 0;
    static int pCol = 0;
    static int money = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scan.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();

            if (line.contains("S")){
                pRow = row;
                pCol = line.indexOf("S");

                matrix[pRow][pCol]='-';
            }
        }

        while (money<50 ) {
            String command = scan.nextLine();

            if ("up".equals(command)) {
                pRow -= 1;
                if (isOutOfBounds(matrix, pRow, pCol)) {
                    System.out.println("Bad news, you are out of the bakery.");
                    matrix[pRow+1][pCol]='-';
                    break;
                } else {
                    matrix[pRow + 1][pCol] = '-';
                    if (Character.isDigit(matrix[pRow][pCol])) {
                        int coin = Integer.parseInt((matrix[pRow][pCol] + ""));
                        money += coin;
                    } else if (matrix[pRow][pCol] == 'O') {
                        matrix[pRow][pCol] = '-';
                        for (int rows = 0; rows < size; rows++) {
                            for (int cols = 0; cols < size; cols++) {
                                if (matrix[rows][cols] == 'O') {
                                    matrix[rows][cols] = '-';
                                    pRow = rows;
                                    pCol = cols;
                                }
                            }
                        }
                    }
                }
                matrix[pRow][pCol]='S';
            } else if ("right".equals(command)) {
                pCol += 1;
                if (isOutOfBounds(matrix, pRow, pCol)) {
                    System.out.println("Bad news, you are out of the bakery.");
                    matrix[pRow][pCol-1]='-';
                    break;
                } else {
                    matrix[pRow][pCol-1] = '-';
                    if (Character.isDigit(matrix[pRow][pCol])) {
                        int coin = Integer.parseInt((matrix[pRow][pCol] + ""));
                        money += coin;
                    } else if (matrix[pRow][pCol] == 'O') {
                        matrix[pRow][pCol] = '-';
                        for (int rows = 0; rows < size; rows++) {
                            for (int cols = 0; cols < size; cols++) {
                                if (matrix[rows][cols] == 'O') {
                                    matrix[rows][cols] = '-';
                                    pRow = rows;
                                    pCol = cols;
                                }
                            }
                        }
                    }
                }
                matrix[pRow][pCol]='S';
            } else if ("left".equals(command)) {
                pCol -= 1;
                if (isOutOfBounds(matrix, pRow, pCol)) {
                    System.out.println("Bad news, you are out of the bakery.");
                    matrix[pRow][pCol+1]='-';
                    break;
                } else {
                    matrix[pRow][pCol+1] = '-';
                    if (Character.isDigit(matrix[pRow][pCol])) {
                        int coin = Integer.parseInt((matrix[pRow][pCol] + ""));
                        money += coin;
                    } else if (matrix[pRow][pCol] == 'O') {
                        matrix[pRow][pCol] = '-';
                        for (int rows = 0; rows < size; rows++) {
                            for (int cols = 0; cols < size; cols++) {
                                if (matrix[rows][cols] == 'O') {
                                    matrix[rows][cols] = '-';
                                    pRow = rows;
                                    pCol = cols;
                                }
                            }
                        }
                    }
                }
                matrix[pRow][pCol]='S';
            } else if ("down".equals(command)) {
                pRow += 1;
                if (isOutOfBounds(matrix, pRow, pCol)) {
                    System.out.println("Bad news, you are out of the bakery.");
                    matrix[pRow-1][pCol]='-';
                    break;
                } else {
                    matrix[pRow - 1][pCol] = '-';
                    if (Character.isDigit(matrix[pRow][pCol])) {
                        int coin = Integer.parseInt((matrix[pRow][pCol] + ""));
                        money += coin;
                    } else if (matrix[pRow][pCol] == 'O') {
                        matrix[pRow][pCol] = '-';
                        for (int rows = 0; rows < size; rows++) {
                            for (int cols = 0; cols < size; cols++) {
                                if (matrix[rows][cols] == 'O') {
                                    matrix[rows][cols] = '-';
                                    pRow = rows;
                                    pCol = cols;
                                }
                            }
                        }
                    }
                }
                matrix[pRow][pCol]='S';
            }
                 if(money>=50) break;
                }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: "+money);

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
