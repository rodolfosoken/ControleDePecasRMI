package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import impl.Servidor;

public class ServidorGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	Servidor servidor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServidorGui frame = new ServidorGui();
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
	public ServidorGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblServidorStatus = new JLabel("Servidor Status: ");
		lblServidorStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblServidorStatus.setBounds(10, 11, 131, 36);
		contentPane.add(lblServidorStatus);

		JLabel lblStatus = new JLabel("Offline");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(137, 17, 60, 27);
		contentPane.add(lblStatus);

		nomeField = new JTextField();
		nomeField.setText("S1");
		nomeField.setToolTipText("Nome do Servidor");
		nomeField.setBounds(160, 77, 219, 36);
		contentPane.add(nomeField);
		nomeField.setColumns(10);

		JLabel lblNomeDoServidor = new JLabel("Nome do Servidor:");
		lblNomeDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoServidor.setBounds(10, 85, 117, 17);
		contentPane.add(lblNomeDoServidor);

		JButton btnStop = new JButton("Parar Servidor");
		btnStop.setEnabled(false);
		JButton btnStart = new JButton("Inciar Servidor");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (nomeField.getText().toString().length() == 0)
						JOptionPane.showMessageDialog(contentPane, "Campo nome não pode estar vazio!", // mensagem
								"Erro ao iniciar o servidor", // titulo da janela
								JOptionPane.ERROR_MESSAGE);
					else {
						servidor = new Servidor(nomeField.getText());
						nomeField.setEnabled(false);
						btnStart.setEnabled(false);
						btnStop.setEnabled(true);
						lblStatus.setText("Online");
					}

				} catch (RemoteException e) {
					
					JOptionPane.showMessageDialog(contentPane, "Não foi possível iniciar o servidor."+ e.getMessage(), // mensagem
							"Erro ao iniciar o servidor" , // titulo da janela
							JOptionPane.ERROR_MESSAGE);
				} catch (AlreadyBoundException e) {
										
					String[] options = new String[] {"Sim", "Não"};
				    int response = JOptionPane.showOptionDialog(null, "Servidor já está registrado: "
				    		+ "Deseja encerrar o processo em execução?", "Erro ao iniciar o servidor:",
				        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				        null, options, options[0]);
				    if(response == 0) {
				    	try {
							Servidor.shutdown(nomeField.getText());
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(contentPane, 
									"Não foi possível finalizar o servidor."+ e1.getMessage(), // mensagem
									"Erro ao tentar finalizar o servidor: " , // titulo da janela
									JOptionPane.ERROR_MESSAGE);
						} catch (NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    }
				}
			}
		});
		btnStart.setBounds(40, 178, 136, 72);
		contentPane.add(btnStart);

		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (servidor != null) {
					try {
						servidor.shutdown();
					} catch (RemoteException e1) {
						JOptionPane.showMessageDialog(contentPane, "O Registro RMI não foi encontrado", // mensagem
								"Erro ao finalizar o servidor: " + e1.getMessage(), // titulo da janela
								JOptionPane.ERROR_MESSAGE);
					} catch (NotBoundException e1) {
						JOptionPane.showMessageDialog(contentPane, "Este servidor já não está mais registrado.", // mensagem
								"Erro ao finalizar o servidor: " + e1.getMessage(), // titulo da janela
								JOptionPane.ERROR_MESSAGE);
					}
					nomeField.setEnabled(true);
					btnStart.setEnabled(true);
					btnStop.setEnabled(false);
					lblStatus.setText("Offline");
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"Não foi encontrado nenhum servidor para ser finalizado.", // mensagem
							"Erro ao finalizar o servidor: ", // titulo da janela
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnStop.setBounds(215, 178, 142, 72);
		contentPane.add(btnStop);
	}
}
