import java.util.Arrays;

public class PasseioCavaloSemHeuristica {
    private static final int[] movimentosX = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] movimentosY = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int N = 8;

    public boolean resolverPasseio() {
        int[][] tabuleiro = new int[N][N];
        for (int[] linha : tabuleiro) {
            Arrays.fill(linha, -1);
        }

        tabuleiro[0][0] = 0; // Ponto de partida

        if (!resolverPasseioUtil(0, 0, 1, tabuleiro)) {
            System.out.println("Solução não existe");
            return false;
        } else {
            imprimirTabuleiro(tabuleiro);
        }
        return true;
    }

    private boolean resolverPasseioUtil(int x, int y, int movimento, int[][] tabuleiro) {
        if (movimento == N * N) return true;

        for (int k = 0; k < 8; k++) {
            int novoX = x + movimentosX[k];
            int novoY = y + movimentosY[k];
            if (eMovimentoValido(novoX, novoY, tabuleiro)) {
                tabuleiro[novoX][novoY] = movimento;
                if (resolverPasseioUtil(novoX, novoY, movimento + 1, tabuleiro)) {
                    return true;
                } else {
                    tabuleiro[novoX][novoY] = -1; // Backtracking
                }
            }
        }
        return false;
    }

    private boolean eMovimentoValido(int x, int y, int[][] tabuleiro) {
        return x >= 0 && x < N && y >= 0 && y < N && tabuleiro[x][y] == -1;
    }

    private void imprimirTabuleiro(int[][] tabuleiro) {
        for (int[] linha : tabuleiro) {
            for (int celula : linha) {
                System.out.print(celula + "\t");
            }
            System.out.println();
        }
    }
}
