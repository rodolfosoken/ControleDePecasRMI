package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import impl.Cliente;

public class ClienteGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeServidor;
	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGui frame = new ClienteGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoServidor = new JLabel("Nome do Servidor");
		lblNomeDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoServidor.setBounds(28, 23, 164, 39);
		contentPane.add(lblNomeDoServidor);
		
		textNomeServidor = new JTextField();
		textNomeServidor.setBounds(185, 30, 275, 28);
		contentPane.add(textNomeServidor);
		textNomeServidor.setColumns(10);

		JLabel lblStatus = new JLabel("Offline");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(616, 30, 164, 28);
		contentPane.add(lblStatus);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textNomeServidor.getText().isEmpty())
						JOptionPane.showMessageDialog(contentPane, 
								"O nome do servidor não pode estar em branco: ", // mensagem
								"Campo Obrigatório", // titulo da janela
								JOptionPane.ERROR_MESSAGE);
					else {
						cliente = new Cliente(textNomeServidor.getText());
						lblStatus.setText("Conectado à "+cliente.getNomeServidor());
						
					}
				} catch (RemoteException | NotBoundException e1) {
					JOptionPane.showMessageDialog(contentPane, 
							"Não foi possível se conectar ao servidor: "+e1.getMessage(), // mensagem
							"Erro ao criar cliente", // titulo da janela
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConectar.setBounds(488, 33, 89, 23);
		contentPane.add(btnConectar);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(28, 127, 528, 209);
		contentPane.add(panel);
		panel.setLayout(null);
	}
}
