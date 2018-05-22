package formularios;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controladores.Acao;


public class FormularioPrincipal {
	
	//Contrutor
	public FormularioPrincipal(){
		
		//JFrame
		JFrame frm = new JFrame("Formulário");		
		frm.setSize(380, 390);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		frm.setLayout(null);
		
		
		
		// JLabel
		JLabel lblNomeP = new JLabel("Nome do Produto:");
		lblNomeP.setBounds(20, 20, 150, 20);
						
		JLabel lblValor = new JLabel("Valor do Produto:");
		lblValor.setBounds(20, 60, 180, 20);
						
		JLabel lblQuantidade = new JLabel("Quantidade em Estoque:");
		lblQuantidade.setBounds(20, 100, 150, 20);
				
				
				
		//JTextField
		JTextField txtNomeP = new JTextField();
		txtNomeP.setBounds(180, 20, 150, 20);	
			
				
		JTextField txtValor = new JTextField();
		txtValor.setBounds(180, 60, 150, 20);
				
				
		JTextField txtQuantidade = new JTextField();
		txtQuantidade.setBounds(180, 100, 150, 20);
				
				
		//JButton
		JButton btn = new JButton("CADASTRAR");
		btn.setBounds(125, 150, 130, 20);
		
		
		
		// DefaultTableModel - Serve para agrupar os dados
		DefaultTableModel exibirDados = new DefaultTableModel();
		
		//Criar colunas
		exibirDados.addColumn("PRODUTO");
		exibirDados.addColumn("VALOR");
		exibirDados.addColumn("QUANTIDADE");	
			
		//Intanciar acao
		Acao a = new Acao();
		
		// JTable - Serve para exibir o DefaultTableModel
		JTable tabela = new JTable(a.listarProdutos());
				
		
		// JScrollPane - Barra de rolagem englobando o JTable
		JScrollPane barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(20, 190, 330, 150);	
		
		
		//Ação no botão de cadastro
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Obter os dados informados pelo usuário
				String nomeP = txtNomeP.getText();
				double valorP = Double.parseDouble(txtValor.getText());
				int quantidadeP = Integer.parseInt(txtQuantidade.getText());
				
				// Criar objeto e chamar o método
				a.Cadastrar(nomeP, valorP, quantidadeP);
				
				//Atualizar tabela
				tabela.setModel(a.listarProdutos());
				
				// Limpar campos
				txtNomeP.setText("");
				txtValor.setText("");
				txtQuantidade.setText("");
				
				// Cursor no campo nome
				txtNomeP.requestFocus();			
				
				
			}
		});	
		
		//Adcionar Ação a tabela
		tabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				//Obter a linha
				int linha = tabela.getSelectedRow();
				
				//obter os dados
				String nomeP = tabela.getValueAt(linha, 0).toString();
				double valor = Double.parseDouble(tabela.getValueAt(linha, 1).toString());
				int quantidade = Integer.parseInt(tabela.getValueAt(linha, 2).toString());
				
								
				//Criar o novo formulario
				FormularioAlteracao f = new FormularioAlteracao(nomeP, valor, quantidade, linha);
				
				//fechar formulario
				frm.dispose();
				
				
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			
				
			}
			
		
				
			
		});
		
		
		
		frm.add(lblNomeP);
		frm.add(lblValor);
		frm.add(lblQuantidade);
		
		frm.add(txtNomeP);
		frm.add(txtValor);
		frm.add(txtQuantidade);
		frm.add(barraRolagem);
		
		frm.add(btn);
		
		frm.setVisible(true);
		
		
	}

}
