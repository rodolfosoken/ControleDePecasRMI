package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ClienteGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 777, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoServidor = new JLabel("Nome do Servidor");
		lblNomeDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoServidor.setBounds(28, 23, 164, 39);
		contentPane.add(lblNomeDoServidor);
		
		textField = new JTextField();
		textField.setBounds(185, 30, 275, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBounds(488, 33, 89, 23);
		contentPane.add(btnConectar);
		
		JLabel lblOffline = new JLabel("Offline");
		lblOffline.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOffline.setBounds(631, 28, 67, 28);
		contentPane.add(lblOffline);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(28, 89, 528, 209);
		contentPane.add(panel);
		panel.setLayout(null);
	}
}
