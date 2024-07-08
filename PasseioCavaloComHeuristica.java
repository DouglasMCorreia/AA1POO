import java.util.Arrays;

public class PasseioCavaloComHeuristica {
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

        int[] grausDeSaida = calcularGrausDeSaida(x, y, tabuleiro);

        for (int i = 0; i < 8; i++) {
            int novoX = x + movimentosX[grausDeSaida[i]];
            int novoY = y + movimentosY[grausDeSaida[i]];
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

    private int[] calcularGrausDeSaida(int x, int y, int[][] tabuleiro) {
        int[] graus = new int[8];
        Integer[] ordem = {0, 1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i < 8; i++) {
            int novoX = x + movimentosX[i];
            int novoY = y + movimentosY[i];
            if (eMovimentoValido(novoX, novoY, tabuleiro)) {
                graus[i] = contarMovimentosValidos(novoX, novoY, tabuleiro);
            } else {
                graus[i] = -1;
            }
        }

        Arrays.sort(ordem, (a, b) -> graus[a] - graus[b]);
        return Arrays.stream(ordem).mapToInt(Integer::intValue).toArray();
    }

    private int contarMovimentosValidos(int x, int y, int[][] tabuleiro) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int novoX = x + movimentosX[i];
            int novoY = y + movimentosY[i];
            if (eMovimentoValido(novoX, novoY, tabuleiro)) {
                count++;
            }
        }
        return count;
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
