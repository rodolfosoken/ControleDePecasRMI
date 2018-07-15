package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import impl.Cliente;
import impl.PartImpl;
import interfaces.Part;
import javax.swing.SpinnerNumberModel;

public class ClienteGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeServidor;
	private Cliente cliente;
	private JTextField textFieldNomePA;
	private JTextField textFieldNomeServidorPA;
	private JTextField textFieldPartCodPA;
	private JTextArea textAreaDescPA;
	private JList<Part> listComponentsPartAtualPA;
	private JList<Part> listParts;
	private JList<Part> listSubParts;
	
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
		setBounds(100, 100, 1039, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoServidor = new JLabel("Nome do Servidor");
		lblNomeDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoServidor.setBounds(28, 23, 164, 39);
		contentPane.add(lblNomeDoServidor);
		
		textNomeServidor = new JTextField();
		textNomeServidor.setText("S1");
		textNomeServidor.setBounds(185, 30, 275, 28);
		contentPane.add(textNomeServidor);
		textNomeServidor.setColumns(10);

		JLabel lblStatus = new JLabel("Offline");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(616, 30, 164, 28);
		contentPane.add(lblStatus);
		
		JButton btnConectar = new JButton("Conectar");
		
		btnConectar.setBounds(488, 33, 89, 23);
		contentPane.add(btnConectar);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(341, 87, 309, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNovaPeca = new JButton("Nova Peça");
		btnNovaPeca.setBounds(176, 413, 123, 23);
		panel.add(btnNovaPeca);
		btnNovaPeca.setEnabled(false);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 107, 46, 14);
		panel.add(lblNome);
		
		JLabel lblDesc = new JLabel("Descrição:");
		lblDesc.setBounds(10, 174, 63, 14);
		panel.add(lblDesc);
		
		JLabel lblComponentes = new JLabel("Componentes :");
		lblComponentes.setBounds(10, 256, 89, 14);
		panel.add(lblComponentes);
		
		textFieldNomePA = new JTextField();
		textFieldNomePA.setBounds(80, 104, 198, 20);
		panel.add(textFieldNomePA);
		textFieldNomePA.setColumns(10);
		
		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(10, 138, 46, 14);
		panel.add(lblServidor);
		
		textFieldNomeServidorPA = new JTextField();
		textFieldNomeServidorPA.setEditable(false);
		textFieldNomeServidorPA.setBounds(80, 135, 198, 20);
		panel.add(textFieldNomeServidorPA);
		textFieldNomeServidorPA.setColumns(10);
		
		JLabel lblCodPea = new JLabel("Cod. Peça");
		lblCodPea.setBounds(10, 61, 76, 14);
		panel.add(lblCodPea);
		
		textFieldPartCodPA = new JTextField();
		textFieldPartCodPA.setBounds(80, 58, 133, 20);
		panel.add(textFieldPartCodPA);
		textFieldPartCodPA.setColumns(10);
		
		JLabel lblPea = new JLabel("Peça Atual");
		lblPea.setBounds(10, 11, 89, 23);
		panel.add(lblPea);
		lblPea.setHorizontalAlignment(SwingConstants.LEFT);
		lblPea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(223, 57, 76, 23);
		panel.add(btnBuscar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 281, 289, 114);
		panel.add(scrollPane_2);
		
		listComponentsPartAtualPA = new JList<Part>();
		scrollPane_2.setViewportView(listComponentsPartAtualPA);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(80, 168, 203, 52);
		panel.add(scrollPane_3);
		
		textAreaDescPA = new JTextArea();
		textAreaDescPA.setLineWrap(true);
		textAreaDescPA.setColumns(8);
		scrollPane_3.setViewportView(textAreaDescPA);
		
		JLabel lblListPartRepository = new JLabel("Peças no Repositório Atual");
		lblListPartRepository.setHorizontalAlignment(SwingConstants.CENTER);
		lblListPartRepository.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListPartRepository.setBounds(722, 84, 217, 29);
		contentPane.add(lblListPartRepository);
		
		JButton btnSavePart = new JButton("→");
		btnSavePart.setEnabled(false);

		btnSavePart.setBounds(660, 253, 66, 23);
		contentPane.add(btnSavePart);
		
		JButton btnEditPart = new JButton("←");
		btnEditPart.setBounds(660, 320, 66, 23);
		btnEditPart.setEnabled(false);
		contentPane.add(btnEditPart);
		
		JLabel lblListaAtualDe = new JLabel("Lista Atual de Peças");
		lblListaAtualDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaAtualDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaAtualDe.setBounds(10, 84, 222, 29);
		contentPane.add(lblListaAtualDe);
		
		JButton btnAddSubPart2List = new JButton("←");

		btnAddSubPart2List.setEnabled(false);
		btnAddSubPart2List.setBounds(242, 253, 89, 23);
		contentPane.add(btnAddSubPart2List);
		
		JButton btnApagar = new JButton("Remover da Lista");
		btnApagar.setEnabled(false);
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnApagar.setBounds(28, 506, 182, 28);
		contentPane.add(btnApagar);
		
		JButton btnSaveSubPart2Part = new JButton("→");

		btnSaveSubPart2Part.setEnabled(false);
		btnSaveSubPart2Part.setBounds(242, 320, 89, 23);
		contentPane.add(btnSaveSubPart2Part);
		
		JLabel lblQtd = new JLabel("Qtd.");
		lblQtd.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtd.setBounds(259, 197, 46, 14);
		contentPane.add(lblQtd);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner.setBounds(256, 222, 62, 20);
		contentPane.add(spinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(740, 124, 273, 351);
		contentPane.add(scrollPane);
		
		listParts = new JList<Part>();
		scrollPane.setViewportView(listParts);

		listParts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listParts.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 124, 222, 371);
		contentPane.add(scrollPane_1);
		
		listSubParts = new JList<Part>();
		scrollPane_1.setViewportView(listSubParts);
		listSubParts.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		//========================= Listeners ============================================
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setEnabled(false);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listParts.setModel(loadListRepositorio());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setBounds(805, 486, 89, 23);
		contentPane.add(btnAtualizar);
		
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
						
	//=================== Debug =============
						Part part = new PartImpl("Peça1", "Peça composta criada por um cliente",cliente.getNomeServidor());
						Part part2 = new PartImpl("Peça2", "componente criado por um cliente",cliente.getNomeServidor());
						part.addComponent(part2, 5);
						cliente.getPartrepository().addPart(part);
		//==================
						listParts.setModel(loadListRepositorio());
						btnAtualizar.setEnabled(true);
						btnNovaPeca.setEnabled(true);
						btnEditPart.setEnabled(true);
						
					}
				} catch (RemoteException | NotBoundException e1) {
					JOptionPane.showMessageDialog(contentPane, 
							"Não foi possível se conectar ao servidor: "+e1.getMessage(), // mensagem
							"Erro ao criar cliente", // titulo da janela
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnEditPart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!listParts.isSelectionEmpty()) {
					cliente.setPart((PartImpl) listParts.getSelectedValue());
					loadPart(listParts.getSelectedValue());	
					btnSavePart.setEnabled(true);
					btnAddSubPart2List.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(contentPane, 
							"Não há peça selecionada. ", // mensagem
							"Nada selecionado", // titulo da janela
							JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		btnNovaPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadPart(new PartImpl(cliente.getNomeServidor()));
					btnSavePart.setEnabled(true);
					btnAddSubPart2List.setEnabled(true);
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(contentPane, 
							"Não foi possível criar uma nova peça: "+e1.getMessage(), // mensagem
							"Erro ao criar peça", // titulo da janela
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnSavePart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveToRepository();
			}
		});
		
		btnAddSubPart2List.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClientePart();
				try {
					cliente.add2ListaAtual(cliente.getPart(),(int)spinner.getValue());
					listSubParts.setModel(loadListSubPartsPA());
					btnSaveSubPart2Part.setEnabled(true);
					btnApagar.setEnabled(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnSaveSubPart2Part.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		//============================== Fim do método ===============================
	}
	
	private void setClientePart() {
		cliente.getPart().setNomeServidor(textFieldNomeServidorPA.getText());
		cliente.getPart().setPartNome(textFieldNomePA.getText());
		cliente.getPart().setPartCod(textFieldPartCodPA.getText());
		cliente.getPart().setPartDesc(textAreaDescPA.getText());
	}
	
	private void moveToRepository() {
		setClientePart();
		try {
			cliente.getPartrepository().addPart(cliente.getPart());
			loadPart(new PartImpl(cliente.getNomeServidor()));// limpa campos
			listParts.setModel(loadListRepositorio()); // recarrega a lista do repositório
			
		} catch (RemoteException e1) {
			JOptionPane.showMessageDialog(contentPane, 
					"Não foi possível salvar a peça: "+e1.getMessage(), // mensagem
					"Erro ao salvar", // titulo da janela
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadPart(Part part) {
		cliente.setPart((PartImpl)part);
		textFieldPartCodPA.setText(cliente.getPart().getPartCod());
		textFieldNomePA.setText(cliente.getPart().getPartNome());
		textFieldNomeServidorPA.setText(cliente.getPart().getNomeServidor());
		textAreaDescPA.setText(cliente.getPart().getPartDesc());
		try {
			listComponentsPartAtualPA.setModel(loadListComponentesPA());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(contentPane, 
					"Não foi possível carregar os componentes da peça: "+e.getMessage(), // mensagem
					"Erro ao carregar componentes", // titulo da janela
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private AbstractListModel<Part> loadListSubPartsPA() throws RemoteException {
		
		List<Part> listParts = cliente.getListListaAtual();
		
		return new AbstractListModel<Part>() {
			private static final long serialVersionUID = 1L;
			public int getSize() {
				return listParts.size();
			}
			public Part getElementAt(int index) {
				return listParts.get(index);
			}
		};
	}
	
	private AbstractListModel<Part> loadListComponentesPA() throws RemoteException {
		
		List<Part> listParts = cliente.getPart().getListComponentes();
		
		return new AbstractListModel<Part>() {
			private static final long serialVersionUID = 1L;
			public int getSize() {
				return listParts.size();
			}
			public Part getElementAt(int index) {
				return listParts.get(index);
			}
		};
	}

	private AbstractListModel<Part> loadListRepositorio() throws RemoteException {
		
		List<Part> listParts = cliente.getPartrepository().getListParts();
		
		return new AbstractListModel<Part>() {
			private static final long serialVersionUID = 1L;
			public int getSize() {
				return listParts.size();
			}
			public Part getElementAt(int index) {
				return listParts.get(index);
			}
		};
	}
}
