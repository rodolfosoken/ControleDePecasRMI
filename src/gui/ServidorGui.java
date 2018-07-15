package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ServidorGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	Servidor servidor;
	private JTextField txtEndereco;
	private JTextField txtPorta;

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
		setTitle("Programa Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblServidorStatus = new JLabel("Servidor Status: ");
		lblServidorStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblServidorStatus.setBounds(113, 11, 131, 36);
		contentPane.add(lblServidorStatus);

		JLabel lblStatus = new JLabel("Offline");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(240, 17, 60, 27);
		contentPane.add(lblStatus);

		nomeField = new JTextField();
		nomeField.setText("S1");
		nomeField.setToolTipText("Nome do Servidor");
		nomeField.setBounds(136, 63, 153, 36);
		contentPane.add(nomeField);
		nomeField.setColumns(10);

		JLabel lblNomeDoServidor = new JLabel("Nome do Servidor:");
		lblNomeDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoServidor.setBounds(10, 71, 117, 17);
		contentPane.add(lblNomeDoServidor);

		JButton btnStop = new JButton("Parar Servidor");
		btnStop.setEnabled(false);
		JButton btnStart = new JButton("Inciar Servidor");
		
		btnStart.setBounds(80, 178, 136, 72);
		contentPane.add(btnStart);


		btnStop.setBounds(244, 178, 142, 72);
		contentPane.add(btnStop);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 118, 396, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtEndereco = new JTextField();
		txtEndereco.setText("127.0.0.1");
		txtEndereco.setEnabled(false);
		txtEndereco.setBounds(72, 7, 139, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(10, 0, 84, 33);
		panel.add(lblEndereco);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(221, 0, 46, 33);
		panel.add(lblPorta);
		lblPorta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtPorta = new JTextField();
		txtPorta.setText("1099");
		txtPorta.setEnabled(false);
		txtPorta.setBounds(277, 7, 86, 20);
		panel.add(txtPorta);
		txtPorta.setColumns(10);
		
		JCheckBox chckbxLocal = new JCheckBox("Conexão Local");
		chckbxLocal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(!chckbxLocal.isSelected()) {
					txtEndereco.setEnabled(true);
					txtPorta.setEnabled(true);
				}else {
					txtEndereco.setEnabled(false);
					txtPorta.setEnabled(false);
				}
			}
		});
		chckbxLocal.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxLocal.setSelected(true);
		chckbxLocal.setBounds(295, 63, 130, 36);
		contentPane.add(chckbxLocal);
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if (nomeField.getText().toString().length() == 0)
						JOptionPane.showMessageDialog(contentPane, "Campo nome não pode estar vazio!", // mensagem
								"Erro ao iniciar o servidor", // titulo da janela
								JOptionPane.ERROR_MESSAGE);
					else {
						if(chckbxLocal.isSelected())
							servidor = new Servidor(nomeField.getText());
						else
							servidor = new Servidor(nomeField.getText(),txtEndereco.getText(),Integer.parseInt(txtPorta.getText()));
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
				    		if(chckbxLocal.isSelected())
				    			Servidor.shutdown(nomeField.getText(),null,0);
				    		else
				    			Servidor.shutdown(nomeField.getText(),txtEndereco.getText(),Integer.parseInt(txtPorta.getText()));
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
		
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (servidor != null) {
					try {
						if(chckbxLocal.isSelected())
							servidor.shutdown();
						else
							Servidor.shutdown(nomeField.getText(),txtEndereco.getText(),Integer.parseInt(txtPorta.getText()));
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
		
	    addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
            	try {
            		if(!btnStart.isEnabled())
            			servidor.shutdown();
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                e.getWindow().dispose();
            }
        });
		
	}
}
