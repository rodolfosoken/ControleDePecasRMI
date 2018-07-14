package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setTitle("Controle de Peças RMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNovoServidor = new JButton("Novo Servidor");
		btnNovoServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServidorGui servidor = new ServidorGui();
				servidor.setDefaultCloseOperation(HIDE_ON_CLOSE);
				servidor.show();
			}
		});
		btnNovoServidor.setBounds(63, 57, 153, 71);
		contentPane.add(btnNovoServidor);
		
		JButton btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteGui cliente = new ClienteGui();
				cliente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cliente.show();
			}
		});
		btnNovoCliente.setBounds(226, 57, 153, 71);
		contentPane.add(btnNovoCliente);
	}

}
