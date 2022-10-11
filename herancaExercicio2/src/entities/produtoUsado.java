package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class produtoUsado extends Produto {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dataFabricacao;
	
	public produtoUsado() {
		super();
	}

	public produtoUsado(String nome, double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String etiquetaPreco() {
		return getNome() 
				+ " (usado) $ "
				+ String.format("%.2f", getPreco())
				+ " (Data de fabricação: "
				+ sdf.format(dataFabricacao)
				+ ")";			
	}
	
}
