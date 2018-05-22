package controladores;

import java.util.ArrayList;

public class Produto {

	//Atributos
	private String nomeP;
	private double valorP;
	private int quantidadeP;
	
	//ArrayLiust
	public static ArrayList<Produto> dados = new ArrayList<>();

	//Metodos Magivos
	public String getNomoP() {
		return nomeP;
	}

	public void setNomoP(String nomeP) {
		this.nomeP = nomeP;
	}

	public double getValorP() {
		return valorP;
	}

	public void setValorP(double valorP) {
		this.valorP = valorP;
	}

	public int getQuantidadeP() {
		return quantidadeP;
	}

	public void setQuantidadeP(int quantidadeP) {
		this.quantidadeP = quantidadeP;
	}
	
	
	
	
}
