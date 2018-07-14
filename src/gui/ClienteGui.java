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
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class ClienteGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeServidor;
	private Cliente cliente;
	private JTextField textFieldNome;
	private JTextField textFieldServidor;
	private JTextField textFieldPartCod;

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
		setTitle("Programa Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 584);
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
		panel.setBounds(341, 127, 309, 407);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNovaPea = new JButton("Nova Peça");
		btnNovaPea.setBounds(176, 373, 123, 23);
		panel.add(btnNovaPea);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 89, 46, 14);
		panel.add(lblNome);
		
		JLabel lblDesc = new JLabel("Descrição:");
		lblDesc.setBounds(10, 156, 63, 14);
		panel.add(lblDesc);
		
		JLabel lblComponentes = new JLabel("Componentes :");
		lblComponentes.setBounds(10, 216, 89, 14);
		panel.add(lblComponentes);
		
		JList list = new JList();
		list.setBounds(10, 241, 289, 121);
		panel.add(list);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(101, 86, 164, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JTextArea textAreaDesc = new JTextArea();
		textAreaDesc.setBounds(101, 151, 164, 52);
		panel.add(textAreaDesc);
		
		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(10, 114, 46, 14);
		panel.add(lblServidor);
		
		textFieldServidor = new JTextField();
		textFieldServidor.setBounds(101, 111, 164, 20);
		panel.add(textFieldServidor);
		textFieldServidor.setColumns(10);
		
		JLabel lblCodPea = new JLabel("Cod. Peça");
		lblCodPea.setBounds(10, 45, 76, 14);
		panel.add(lblCodPea);
		
		textFieldPartCod = new JTextField();
		textFieldPartCod.setBounds(101, 42, 112, 20);
		panel.add(textFieldPartCod);
		textFieldPartCod.setColumns(10);
		
		JLabel lblPea = new JLabel("Peça Atual");
		lblPea.setBounds(10, 11, 89, 23);
		panel.add(lblPea);
		lblPea.setHorizontalAlignment(SwingConstants.LEFT);
		lblPea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(223, 41, 76, 23);
		panel.add(btnBuscar);
		
		JList listParts = new JList();
		listParts.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		listParts.setBounds(740, 127, 199, 407);
		contentPane.add(listParts);
		
		JLabel lblListPartRepository = new JLabel("Peças no Repositório");
		lblListPartRepository.setHorizontalAlignment(SwingConstants.CENTER);
		lblListPartRepository.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListPartRepository.setBounds(740, 87, 199, 29);
		contentPane.add(lblListPartRepository);
		
		JList listSubParts = new JList();
		listSubParts.setBounds(10, 127, 222, 374);
		contentPane.add(listSubParts);
		
		JButton btnSavePart = new JButton("→");
		btnSavePart.setBounds(664, 252, 66, 23);
		contentPane.add(btnSavePart);
		
		JButton btnEditPart = new JButton("←");
		btnEditPart.setBounds(664, 286, 66, 23);
		contentPane.add(btnEditPart);
		
		JLabel lblListaAtualDe = new JLabel("Lista Atual de Peças");
		lblListaAtualDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaAtualDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaAtualDe.setBounds(10, 87, 222, 29);
		contentPane.add(lblListaAtualDe);
		
		JButton btnAddSubPart = new JButton("←");
		btnAddSubPart.setBounds(242, 286, 89, 23);
		contentPane.add(btnAddSubPart);
		
		JButton btnApagar = new JButton("Remover da Lista");
		btnApagar.setBounds(28, 512, 182, 28);
		contentPane.add(btnApagar);
	}
}
