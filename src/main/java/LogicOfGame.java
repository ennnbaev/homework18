
public class LogicOfGame {
    int height;
    int weight;
    public int[][] board;

    LogicOfGame(int height, int weight) {
        this.height = height;
        this.weight = weight;
        this.board = new int[height][weight];
    }

    void printBoard() {
        for (int i = 0; i < weight; i++) {
            System.out.print("|");
            for (int j = 0; j < height; j++) {
                if (this.board[j][i] == 1) {
                    System.out.print(" $ ");
                } else {
                    System.out.print(" ^ ");
                }
            }
            System.out.println("|");
        }
        System.out.println("=======================");
    }

    public void act() {
        int[][] nextBoard = new int[height][weight];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                int countOfNeighbours = liveNeighbours(j, i);
                if (checkError(j, i) == 1) {
                    if (countOfNeighbours < 2) {
                        nextBoard[j][i] = 0;
                    }
                    if (countOfNeighbours == 2 || countOfNeighbours == 3) {
                        nextBoard[j][i] = 1;
                    }
                    if (countOfNeighbours > 3) {
                        nextBoard[j][i] = 0;
                    }
                } else {
                    if (countOfNeighbours == 3) {
                        nextBoard[j][i] = 1;
                    }

                }
            }
        }
        this.board = nextBoard;
    }

    public void setLive(int x, int y) {
        this.board[y][x] = 1;
    }

    public int liveNeighbours(int x, int y) {
        int counter = 0;
        counter += checkError(x + 1, y);
        counter += checkError(x, y + 1);
        counter += checkError(x + 1, y + 1);
        counter += checkError(x - 1, y - 1);
        counter += checkError(x - 1, y);
        counter += checkError(x - 1, y + 1);
        counter += checkError(x, y - 1);
        counter += checkError(x + 1, y - 1);
        return counter;
    }

    int checkError(int x, int y) {
        try {
            return board[x][y];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return 0;
        }
    }

}
