import java.util.Scanner;

public class TestaProduto {
    private static Produto produto1;
    private static Produto produto2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Criar Produto 1 e Produto 2");
            System.out.println("2 - Inserir Estoque Produto 1");
            System.out.println("3 - Inserir Estoque Produto 2");
            System.out.println("4 - Remover Estoque Produto 1");
            System.out.println("5 - Remover Estoque Produto 2");
            System.out.println("6 - Imprimir Estoque Produto 1 e Produto 2");
            System.out.println("7 - Comparar Produto 1 e Produto 2");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarProdutos(scanner);
                    break;
                case 2:
                    inserirEstoque(scanner, produto1);
                    break;
                case 3:
                    inserirEstoque(scanner, produto2);
                    break;
                case 4:
                    removerEstoque(scanner, produto1);
                    break;
                case 5:
                    removerEstoque(scanner, produto2);
                    break;
                case 6:
                    imprimirEstoque();
                    break;
                case 7:
                    compararProdutos();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 8);

        scanner.close();
    }

    private static void criarProdutos(Scanner scanner) {
        System.out.print("Nome do Produto 1: ");
        String nome1 = scanner.next();
        System.out.print("Preço do Produto 1: ");
        float preco1 = scanner.nextFloat();
        System.out.print("Quantidade do Produto 1: ");
        int quantidade1 = scanner.nextInt();

        produto1 = new Produto(nome1, preco1, quantidade1);

        System.out.print("Nome do Produto 2: ");
        String nome2 = scanner.next();
        System.out.print("Preço do Produto 2: ");
        float preco2 = scanner.nextFloat();
        System.out.print("Quantidade do Produto 2: ");
        int quantidade2 = scanner.nextInt();

        produto2 = new Produto(nome2, preco2, quantidade2);

        System.out.println("Produtos criados com sucesso!");
    }

    private static void inserirEstoque(Scanner scanner, Produto produto) {
        if (produto == null) {
            System.out.println("Produto não criado!");
            return;
        }
        System.out.print("Quantidade a adicionar: ");
        int quantidade = scanner.nextInt();
        if (produto.adicionarEstoque(quantidade)) {
            System.out.println("Estoque adicionado com sucesso!");
        } else {
            System.out.println("Erro ao adicionar estoque!");
        }
    }

    private static void removerEstoque(Scanner scanner, Produto produto) {
        if (produto == null) {
            System.out.println("Produto não criado!");
            return;
        }
        System.out.print("Quantidade a remover: ");
        int quantidade = scanner.nextInt();
        if (produto.removerEstoque(quantidade)) {
            System.out.println("Estoque removido com sucesso!");
        } else {
            System.out.println("Erro ao remover estoque!");
        }
    }

    private static void imprimirEstoque() {
        if (produto1 != null) {
            System.out.println("Produto 1: " + produto1);
        } else {
            System.out.println("Produto 1 não criado!");
        }

        if (produto2 != null) {
            System.out.println("Produto 2: " + produto2);
        } else {
            System.out.println("Produto 2 não criado!");
        }
    }

    private static void compararProdutos() {
        if (produto1 == null || produto2 == null) {
            System.out.println("Ambos os produtos devem ser criados para comparação!");
            return;
        }
        if (produto1.equals(produto2)) {
            System.out.println("Produtos são iguais!");
        } else {
            System.out.println("Produtos são diferentes!");
        }
    }
}

