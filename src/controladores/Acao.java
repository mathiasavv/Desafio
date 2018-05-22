package controladores;

import javax.swing.table.DefaultTableModel;

public class Acao {
	
	//Metodo para cadastrar produto
	public void Cadastrar(String nome, double valor, int quantidade){

	Produto p = new Produto(); 
	p.setNomoP(nome);
	p.setValorP(valor);
	p.setQuantidadeP(quantidade);
	
	//Adcionar ao ArrayList
	Produto.dados.add(p);
	
	}
	
	//Método para retornar os dados do produto
	public DefaultTableModel listarProdutos() {
			
			
		//DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Produto");
		modelo.addColumn("Valor");
		modelo.addColumn("Quantidade");
			
			for(int indice=0; indice<Produto.dados.size(); indice++) {
			modelo.addRow(new Object[] {
				Produto.dados.get(indice).getNomoP(),
				Produto.dados.get(indice).getValorP(),
				Produto.dados.get(indice).getQuantidadeP()
				});
				
			}
			return modelo;
		}
	
	
	// Método para excluir
		public void excluir(int linha) {
			Produto.dados.remove(linha);
			
		}
	
		// Método para alterar
		public void alterar(String nomeP, double valor, int quantidade, int linha) {
			
			// Criar objeto
			Produto p = new Produto();
			p.setNomoP(nomeP);
			p.setValorP(valor);
			p.setQuantidadeP(quantidade);
			
			// Realizar a alteração
			Produto.dados.set(linha, p);
			
		}
}
