package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map.Entry;

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
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import impl.Cliente;
import impl.PartImpl;
import interfaces.Part;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
	private JTextField textEndereco;
	private JTextField textPorta;
	private JLabel lblQtdComp;
	private JLabel lblQtdRep;
	
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
		lblNomeDoServidor.setBounds(10, 11, 164, 39);
		contentPane.add(lblNomeDoServidor);
		
		textNomeServidor = new JTextField();
		textNomeServidor.setText("S1");
		textNomeServidor.setBounds(161, 18, 170, 28);
		contentPane.add(textNomeServidor);
		textNomeServidor.setColumns(10);

		JLabel lblStatus = new JLabel("Offline");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(602, 41, 262, 28);
		contentPane.add(lblStatus);
		
		JButton btnConectar = new JButton("Conectar");
		
		btnConectar.setBounds(242, 53, 89, 23);
		contentPane.add(btnConectar);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(341, 100, 309, 434);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNovaPeca = new JButton("Nova Peça");
		btnNovaPeca.setBounds(176, 406, 123, 23);
		panel.add(btnNovaPeca);
		btnNovaPeca.setEnabled(false);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 107, 46, 14);
		panel.add(lblNome);
		
		JLabel lblDesc = new JLabel("Descrição:");
		lblDesc.setBounds(10, 174, 76, 14);
		panel.add(lblDesc);
		
		JLabel lblComponentes = new JLabel("Componentes :");
		lblComponentes.setBounds(10, 256, 89, 14);
		panel.add(lblComponentes);
		
		textFieldNomePA = new JTextField();
		textFieldNomePA.setEnabled(false);
		textFieldNomePA.setBounds(96, 104, 182, 20);
		panel.add(textFieldNomePA);
		textFieldNomePA.setColumns(10);
		
		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(10, 138, 76, 14);
		panel.add(lblServidor);
		
		textFieldNomeServidorPA = new JTextField();
		textFieldNomeServidorPA.setEditable(false);
		textFieldNomeServidorPA.setBounds(96, 135, 182, 20);
		panel.add(textFieldNomeServidorPA);
		textFieldNomeServidorPA.setColumns(10);
		
		JLabel lblCodPea = new JLabel("Cod. Peça");
		lblCodPea.setBounds(10, 61, 76, 14);
		panel.add(lblCodPea);
		
		textFieldPartCodPA = new JTextField();
		textFieldPartCodPA.setBounds(96, 58, 117, 20);
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
		listComponentsPartAtualPA.setToolTipText("Componentes da peça");
		listComponentsPartAtualPA.setForeground(Color.BLACK);
		listComponentsPartAtualPA.setBackground(SystemColor.menu);
		listComponentsPartAtualPA.setEnabled(false);
		scrollPane_2.setViewportView(listComponentsPartAtualPA);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(95, 168, 188, 77);
		panel.add(scrollPane_3);
		
		textAreaDescPA = new JTextArea();
		textAreaDescPA.setEnabled(false);
		textAreaDescPA.setLineWrap(true);
		textAreaDescPA.setColumns(8);
		scrollPane_3.setViewportView(textAreaDescPA);
		
		lblQtdComp = new JLabel("0");
		lblQtdComp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQtdComp.setBounds(237, 256, 62, 23);
		panel.add(lblQtdComp);
		
		JLabel lblListPartRepository = new JLabel("Peças no Repositório Atual :");
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
		
		JLabel lblListaAtualDe = new JLabel("Lista Atual de Peças :");
		lblListaAtualDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaAtualDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaAtualDe.setBounds(10, 89, 182, 29);
		contentPane.add(lblListaAtualDe);
		
		JButton btnAddSubPart2List = new JButton("←");

		btnAddSubPart2List.setEnabled(false);
		btnAddSubPart2List.setBounds(242, 253, 89, 23);
		contentPane.add(btnAddSubPart2List);
		
		JButton btnApagar = new JButton("Limpar da Lista");
		btnApagar.setEnabled(false);

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
		listParts.setValueIsAdjusting(true);
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
					lblQtdRep.setText(String.valueOf(cliente.getPartrepository().getListParts().size()));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setBounds(805, 486, 89, 23);
		contentPane.add(btnAtualizar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(341, 11, 202, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEnd = new JLabel("End.:");
		lblEnd.setBounds(10, 11, 46, 14);
		panel_1.add(lblEnd);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(10, 36, 46, 14);
		panel_1.add(lblPorta);
		
		textEndereco = new JTextField();
		textEndereco.setText("127.0.0.1");
		textEndereco.setEnabled(false);
		textEndereco.setBounds(46, 8, 146, 20);
		panel_1.add(textEndereco);
		textEndereco.setColumns(10);
		
		textPorta = new JTextField();
		textPorta.setText("1099");
		textPorta.setEnabled(false);
		textPorta.setBounds(46, 36, 86, 20);
		panel_1.add(textPorta);
		textPorta.setColumns(10);
		
		JCheckBox chckbxConexoLocal = new JCheckBox("Conexão local");
		chckbxConexoLocal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(!chckbxConexoLocal.isSelected()) {
					textPorta.setEnabled(true);
					textEndereco.setEnabled(true);
				}else {
					textPorta.setEnabled(false);
					textEndereco.setEnabled(false);
				}
					
			}
		});
		chckbxConexoLocal.setSelected(true);
		chckbxConexoLocal.setBounds(549, 11, 113, 23);
		contentPane.add(chckbxConexoLocal);
		
		JLabel lblStatus_1 = new JLabel("Status: ");
		lblStatus_1.setBounds(553, 50, 46, 14);
		contentPane.add(lblStatus_1);
		
		lblQtdRep = new JLabel("0");
		lblQtdRep.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQtdRep.setBounds(949, 87, 51, 22);
		contentPane.add(lblQtdRep);
		
		JLabel lblQtdLista = new JLabel("0");
		lblQtdLista.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQtdLista.setBounds(197, 93, 66, 20);
		contentPane.add(lblQtdLista);
		
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textNomeServidor.getText().isEmpty())
						JOptionPane.showMessageDialog(contentPane, 
								"O nome do servidor não pode estar em branco: ", // mensagem
								"Campo Obrigatório", // titulo da janela
								JOptionPane.ERROR_MESSAGE);
					else {
						if(cliente==null) {
							if(chckbxConexoLocal.isSelected())
								cliente = new Cliente(textNomeServidor.getText());
							else {
								cliente = new Cliente();
								cliente.bind(textNomeServidor.getText(),textEndereco.getText(),Integer.parseInt(textPorta.getText()));
							}
						}else {
						if(chckbxConexoLocal.isSelected())
							cliente.bind(textNomeServidor.getText());
						else
							cliente.bind(textNomeServidor.getText(),textEndereco.getText(),Integer.parseInt(textPorta.getText()));
						}
						lblStatus.setText("Conectado à "+cliente.getNomeServidor());
						listParts.setModel(loadListRepositorio());
						lblQtdRep.setText(String.valueOf(cliente.getPartrepository().getListParts().size()));
						btnAtualizar.setEnabled(true);
						btnNovaPeca.setEnabled(true);
						btnEditPart.setEnabled(true);
						btnBuscar.setEnabled(true);
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
					textFieldNomePA.setEnabled(true);
					textAreaDescPA.setEnabled(true);
					lblQtdComp.setText(String.valueOf(cliente.getPart().getListComponentes().size()));
				}else {
					JOptionPane.showMessageDialog(contentPane, 
							"Por favor, selecione uma peça do repositório. ", // mensagem
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
					textFieldNomePA.setEnabled(true);
					textAreaDescPA.setEnabled(true);
					lblQtdComp.setText(String.valueOf(cliente.getPart().getListComponentes().size()));
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
					loadPart(new PartImpl(cliente.getNomeServidor()));
					btnSaveSubPart2Part.setEnabled(true);
					btnApagar.setEnabled(true);
					lblQtdComp.setText(String.valueOf(cliente.getPart().getListComponentes().size()));
					lblQtdLista.setText(String.valueOf(qtdLista()));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnSaveSubPart2Part.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!cliente.getListaAtual().containsKey(cliente.getPart().getPartCod())) {
					cliente.getPart().setComponentes(cliente.getListaAtual());
					try {
						listComponentsPartAtualPA.setModel(loadListComponentesPA()); // carrega componentes da peça
						cliente.getPartrepository().addPart(cliente.getPart());
						cliente.limpaListaAtual();
						listSubParts.setModel(loadListSubPartsPA());
						lblQtdComp.setText(String.valueOf(cliente.getPart().getListComponentes().size()));
						lblQtdLista.setText(String.valueOf(qtdLista()));
					} catch (RemoteException e1) {
						JOptionPane.showMessageDialog(contentPane, 
								"Não foi possível salvar a peça: "+e1.getMessage(), // mensagem
								"Erro ao salvar", // titulo da janela
								JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, 
							"Você não pode inserir a peça nela mesma ", // mensagem
							"Erro ao salvar", // titulo da janela
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente.limpaListaAtual();
					lblQtdLista.setText(String.valueOf(qtdLista()));
					listSubParts.setModel(loadListSubPartsPA());
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(contentPane, 
							"Não foi possível limpar a lista: "+e1.getMessage(), // mensagem
							"Erro ao apagar a lista", // titulo da janela
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PartImpl p = (PartImpl) cliente.getPartrepository().getPart(textFieldPartCodPA.getText());
					if(p!=null)
						loadPart(p);
					else
						JOptionPane.showMessageDialog(contentPane, 
								"Não foi possível localizar a peça: "+textFieldPartCodPA.getText(), // mensagem
								"Erro ao buscar peça", // titulo da janela
								JOptionPane.ERROR_MESSAGE);
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(contentPane, 
							"Não foi possível localizar a peça: "+e1.getMessage(), // mensagem
							"Erro ao buscar peça", // titulo da janela
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//============================== Fim do método ===============================
	}
	
	private int qtdLista() {
		int cont = 0; 
		if(!cliente.getListaAtual().isEmpty())
			for (Entry<Part, Integer> en : cliente.getListaAtual().values()) {
				cont += en.getValue();
			}
		return cont;
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
			cliente.getPart().setNomeServidor(cliente.getNomeServidor());
			cliente.getPartrepository().addPart(cliente.getPart());
			loadPart(new PartImpl(cliente.getNomeServidor()));// limpa campos
			listParts.setModel(loadListRepositorio()); // recarrega a lista do repositório
			lblQtdRep.setText(String.valueOf(cliente.getPartrepository().getListParts().size()));
			lblQtdComp.setText(String.valueOf(cliente.getPart().getListComponentes().size()));			
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
			listComponentsPartAtualPA.setModel(loadListComponentesPA()); // carrega componentes da peça
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
