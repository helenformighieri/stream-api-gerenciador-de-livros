import java.util.*;
import java.util.stream.*;

public class GerenciadorDeLivros {
    public static void main(String[] args) {
        List<Livro> livros = Arrays.asList(
                new Livro("Nome do Vento", "Patrick Rothfuss", 2009, 65.50),
                new Livro("Noivos do Inverno", "Christelle Dabos", 2018, 47.90),
                new Livro("O Temor do Sábio", "Patrick Rothfuss", 2011, 49.90),
                new Livro("A Cidade de Bronze", "S. A. Chakraborty", 2018, 73.29),
                new Livro("Trono de Vidro", "Sarah J. Maas", 2012, 39.90),
                new Livro("O Feiticeiro de Terramar", "Ursula K. Le Guin", 1968, 29.90)
        );

        // Filtrar livros por autor
        List<Livro> livrosPorAutor= livros.stream()
                .filter(livro -> livro.getAutor().equals("Patrick Rothfuss"))
                .toList();

        // Obter títulos de livros publicados após 2010
        List<String> titulosRecentes = livros.stream()
                .filter(livro -> livro.getAnoPublicacao() > 2010)
                .map(Livro::getTitulo)
                .toList();

        // Calcular preço médio dos livros
        double precoMedio = livros.stream()
                .mapToDouble(Livro::getPreco)
                .average()
                .orElse(0.0);

        // Listar livros em ordem alfabética de título
        List<Livro> livrosOrdenados = livros.stream()
                .sorted(Comparator.comparing(Livro::getTitulo))
                .toList();

        // Contar livros por ano de publicação
        Map<Integer, Long> livrosPorAno = livros.stream()
                .collect(Collectors.groupingBy(Livro::getAnoPublicacao, Collectors.counting()));

        // Exibir resultados
        System.out.println("Livros do Autor: " + livrosPorAutor);
        System.out.println("-----------------------");
        System.out.println("Títulos Recentes: " + titulosRecentes);
        System.out.println("-----------------------");
        System.out.println("Preço Médio: " + precoMedio);
        System.out.println("-----------------------");
        System.out.println("Livros Ordenados: " + livrosOrdenados);
        System.out.println("-----------------------");
        System.out.println("Livros por Ano: " + livrosPorAno);
    }
}
