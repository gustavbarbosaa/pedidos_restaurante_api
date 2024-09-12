import dao.CardapioDAO;
import dao.PessoaDAO;
import domain.Cardapio;
import domain.Estoque;
import domain.Produto;
import persistence.JPAUtil;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        System.out.println("Seja bem vindo ao guguinha restaurante!");

        System.out.println("Estes são nossos produtos disponíveis: ");
        var cardapioDAO = new CardapioDAO();
        List<Estoque> produtosCardapio = cardapioDAO.getCardapio();

        for (Estoque produtoCardapio : produtosCardapio) {
            for (Produto produto : produtoCardapio.getProdutos()) {
                System.out.println(String.format("%-30s %10.2f", "ID:" + produto.getId() + "-> " + produto.getNome(), produto.getPreco()));
                System.out.println("Quantidade: " + produtoCardapio.getQuantidade());
            }
        }

        System.out.println("Informe o ID do item: ");
        Scanner scanner = new Scanner(System.in);
        Long idItem = scanner.nextLong();

        System.out.println("Informe a quantidade de itens: ");
        int quantidadeItens = scanner.nextInt();

        var jpaUtil = new JPAUtil();
        var pessoaDAO = new PessoaDAO(jpaUtil);

        System.out.println(pessoaDAO.realizarPedido(idItem, quantidadeItens));
    }
}
