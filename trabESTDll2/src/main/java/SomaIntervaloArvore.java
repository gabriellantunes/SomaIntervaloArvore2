class NoArvore {
    int valor;
    NoArvore esquerdo;
    NoArvore direito;

    NoArvore(int valor) {
        this.valor = valor;
    }

    NoArvore(int valor, NoArvore esquerdo, NoArvore direito) {
        this.valor = valor;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }
}

public class SomaIntervaloArvore {
    public int somaIntervaloArvore(NoArvore raiz, int inicio, int fim) {
        if (raiz == null) {
            return 0;
        }

        int soma = 0;
        if (inicio <= raiz.valor && raiz.valor <= fim) {
            soma += raiz.valor;
        }
        if (inicio < raiz.valor) {
            soma += somaIntervaloArvore(raiz.esquerdo, inicio, fim);
        }
        if (raiz.valor < fim) {
            soma += somaIntervaloArvore(raiz.direito, inicio, fim);
        }

        return soma;
    }

    public static void main(String[] args) {
        NoArvore raiz = new NoArvore(10);
        raiz.esquerdo = new NoArvore(5);
        raiz.esquerdo.esquerdo = new NoArvore(3);
        raiz.esquerdo.esquerdo.esquerdo = new NoArvore(1);
        raiz.esquerdo.direito = new NoArvore(7);
        raiz.esquerdo.direito.esquerdo = new NoArvore(6);
        raiz.direito = new NoArvore(15);
        raiz.direito.esquerdo = new NoArvore(13);
        raiz.direito.direito = new NoArvore(18);

        SomaIntervaloArvore solucao = new SomaIntervaloArvore();
        System.out.println(solucao.somaIntervaloArvore(raiz, 6, 10));
    }
}
