package formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controladores.Acao;

public class FormularioAlteracao {
	
	
		//Construtor
	
		public FormularioAlteracao(String nomeP, double valor, int quantidade, int linha){
			
			//JFrame
			JFrame frm1 = new JFrame("Formulário");		
			frm1.setSize(370, 210);
			frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frm1.setLocationRelativeTo(null);
			frm1.setLayout(null);		
					
					
			// JLabel
			JLabel lblNomeP = new JLabel("Nome do Produto:");
			lblNomeP.setBounds(20, 20, 150, 20);
							
			JLabel lblValor = new JLabel("Valor do Produto:");
			lblValor.setBounds(20, 60, 180, 20);
								
			JLabel lblQuantidade = new JLabel("Quantidade em Estoque:");
			lblQuantidade.setBounds(20, 100, 150, 20);				
							
							
			//JTextField
			JTextField txtNomeP = new JTextField(nomeP);
			txtNomeP.setBounds(180, 20, 150, 20);	
						
							
			JTextField txtValor = new JTextField(String.valueOf(valor));
			txtValor.setBounds(180, 60, 150, 20);
							
						
			JTextField txtQuantidade = new JTextField(String.valueOf(quantidade));
			txtQuantidade.setBounds(180, 100, 150, 20);
							
							
			//JButton
			JButton btn1 = new JButton("ALTERAR");
			btn1.setBounds(30, 140, 90, 20);
			
			//JButton
			JButton btn2 = new JButton("EXCLUIR");
			btn2.setBounds(130, 140, 90, 20);
			
			//JButton
			JButton btn3 = new JButton("CANCELAR");
			btn3.setBounds(230, 140, 100, 20);
			
			
			
			//Botao Alterar
			btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					//Obter dados
					String nomeP = txtNomeP.getText();
					double valor = Double.parseDouble(txtValor.getText());
					int quantidade = Integer.parseInt(txtQuantidade.getText());
					
					
					//Executar alteraçao
					Acao a = new Acao();
					a.alterar(nomeP, valor, quantidade, linha);
					
					//Fechar fomulario
					frm1.dispose();
					
					//Chamar o formulario principal
					FormularioPrincipal f = new FormularioPrincipal();
					
				}
			});
			
			//Botao Excluir
			btn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					//Método para executar a exclusao
					
					Acao a = new Acao();
					a.excluir(linha);
					
					// Fechar formulário atual
					frm1.dispose();
					
					// Chamar o formulário principal
					FormularioPrincipal f = new FormularioPrincipal();
					
				}
			});
				
			//botao Cancelar
			btn3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					//Metodo para cancelar acao
					frm1.dispose();
					
					//Formulario principarl
					FormularioPrincipal f = new FormularioPrincipal();
					
				}
			});
			
	
					
					
			frm1.add(lblNomeP);
			frm1.add(lblValor);
			frm1.add(lblQuantidade);
			
			frm1.add(txtNomeP);
			frm1.add(txtValor);
			frm1.add(txtQuantidade);
						
			frm1.add(btn1);
			frm1.add(btn2);
			frm1.add(btn3);
			
			frm1.setVisible(true);
		
	}

}
