package entities;

public class produtoImportado extends Produto {

	private double alfandegaLivre;

	public produtoImportado() {
		super();
	}

	public produtoImportado(String nome, double preco, double alfandegaLivre) {
		super(nome, preco);
		this.alfandegaLivre = alfandegaLivre;
	}

	public double getAlfandegaLivre() {
		return alfandegaLivre;
	}

	public void setAlfandegaLivre(double alfandegaLivre) {
		this.alfandegaLivre = alfandegaLivre;
	}

	public double precoTotal() {
		return getPreco() + alfandegaLivre;
	}
	
	@Override
	public String etiquetaPreco() {
		return getNome() 
				+ " $ "
				+ String.format("%.2f", precoTotal())
				+ " (Alfândega livre: $ "
				+ String.format("%.2f", alfandegaLivre)
				+ ")";
		
	}
	
}
