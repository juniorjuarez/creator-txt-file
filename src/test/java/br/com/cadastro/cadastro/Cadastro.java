package br.com.cadastro.cadastro;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Cadastro {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro window = new Cadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 357, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(34, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(74, 8, 178, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(34, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(74, 36, 178, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		
		/*Botão cadastrar*/
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cria se uma classe cliente  que estancia os metodos da classe cliente
				Cliente cliente = new Cliente();
				/*Seta as informações recebidas nas labels quando clica no botão cadastrar*/
				cliente.setNome(txtNome.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setIdade(Integer.parseInt(txtIdade.getText()));
				
				try {
					/*Chama o metodo cadastrar, o try catch foi usado pra correção de erro com o java*/
					JOptionPane.showMessageDialog(null, cliente.salvar());
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/*Limpa os formulários*/
				txtNome.setText("");
				txtEmail.setText("");
				txtIdade.setText("");
				
			}
		});
		btnNewButton.setBounds(163, 101, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Idade");
		lblNewLabel_2.setBounds(34, 68, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(74, 65, 178, 20);
		frame.getContentPane().add(txtIdade);
		txtIdade.setColumns(10);
	}
}
