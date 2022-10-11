package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.produtoImportado;
import entities.produtoUsado;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Produto> list = new ArrayList<>();

		System.out.print("Digite o número do produto: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Dados do #" + (i + 1) + " produto");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char tipo = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if (tipo == 'c') {
				list.add(new Produto(nome, preco));
			} else if (tipo == 'u') {
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				list.add(new produtoUsado(nome, preco, data));
			} else {
				System.out.print("Livre de alfândega: ");
				double alfandegaLivre = sc.nextDouble();
				list.add(new produtoImportado(nome, preco, alfandegaLivre));
			}

		}

		System.out.println();
		System.out.println("Etiquetas de preco:");
		for (Produto prod : list) {
			System.out.println(prod.etiquetaPreco());
		}

		sc.close();

	}

}
