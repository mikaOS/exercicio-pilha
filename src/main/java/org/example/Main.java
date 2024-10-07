import java.util.NoSuchElementException;
import java.util.Scanner;

class Celula<T> {
    private final T item;
    private Celula<T> proximo;

    public Celula() {
        this.item = null;
        setProximo(null);
    }

    public Celula(T item) {
        this.item = item;
        setProximo(null);
    }

    public Celula(T item, Celula<T> proximo) {
        this.item = item;
        this.proximo = proximo;
    }

    public T getItem() {
        return item;
    }

    public Celula<T> getProximo() {
        return proximo;
    }

    public void setProximo(Celula<T> proximo) {
        this.proximo = proximo;
    }
}

class Pilha<E> {

    private Celula<E> topo;
    private Celula<E> fundo;

    public Pilha() {

        Celula<E> sentinela = new Celula<E>();
        fundo = sentinela;
        topo = sentinela;

    }

    public boolean vazia() {
        return fundo == topo;
    }

    public void empilhar(E item) {

        topo = new Celula<E>(item, topo);
    }

    public E desempilhar() {

        E desempilhado = consultarTopo();
        topo = topo.getProximo();
        return desempilhado;

    }

    public E consultarTopo() {

        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na pilha!");
        }

        return topo.getItem();

    }

}

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        Pilha<Character> pilha = new Pilha<>();

        while (true) {
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();

                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                        pilha.empilhar(input.charAt(i));
                    } else if (input.charAt(i) == ')' || input.charAt(i) == ']') {
                        if (pilha.vazia()) {
                            break;
                        }
                        pilha.desempilhar();
                    }
                }

                if (pilha.vazia()) {
                    System.out.println("Correto");
                } else {
                    System.out.println("Incorreto");
                }
            }
        }
    }
}
