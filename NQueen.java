public class NQueen {

    public int[][] table = new int[8][8];
    int level = 0, N = 4;

    public void printTable(int[][] table) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solution(int level) {
        if(level == N) {
            printTable(table);
            System.out.println("");
            return;
        }
        for (int i = level; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(isSafe(i, j, level)){
                    table[i][j] = 1;
                    level++;
                    solution(level);
                    level--;
                    table[i][j] = 0;
                }
                if(j == N - 1 && table[level][j] == 0){
                    return;
                }
            }
        }

    }

    public boolean isSafe(int i, int j, int level){
        for (int row = level; row >= 0; row--){
            if(table[row][j] ==  1) return false;
        }

        for (int row = level, col = j; row >= 0 && col >= 0; row--, col--){
            if(table[row][col] == 1) return false;
        }

        for (int row = level, col = j; row >= 0 && col < N; row--, col++){
            if(table[row][col] == 1) return false;
        }
        return true;
    }

    

    public static void main(String[] args) {
        NQueen nq = new NQueen();
        nq.solution(0);
    }
}
