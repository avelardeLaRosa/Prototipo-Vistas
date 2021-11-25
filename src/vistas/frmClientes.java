package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controlador.GestionClienteDAO;
import entidad.Cliente;
import utils.Validacion;

import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmClientes extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblClientes;
	private JPanel panel;
	private JScrollPane scrollPane;
	private Button btnActualizarCli;
	private JLabel lblBuscarPorDni;
	private JTextField txtBuscar;
	private JLabel label_3;
	private Button btnAgregarCli;
	private Button btnModCliente;
	private JLabel label_4;
	private JLabel label_5;
	private Button btnElimCliente;
	private JLabel lblNewLabel;
	private JTable tblClientes;
	int xMouse, yMouse;
	DefaultTableModel model = new DefaultTableModel();
	GestionClienteDAO gc = new GestionClienteDAO();
	private JButton btnBuscar;
	private JLabel lblBuscar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmClientes dialog = new frmClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmClientes() {
		setBounds(0,0,687,480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.addMouseMotionListener(this);
		contentPanel.addMouseListener(this);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new LineBorder(new Color(0,0,0)));
		
		lblClientes = new JLabel("CLIENTES");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblClientes.setBounds(269, 11, 149, 30);
		contentPanel.add(lblClientes);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193, 18, 5));
		panel.setBounds(0, 47, 687, 341);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 35, 687, 268);
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		panel.add(scrollPane);
		
		tblClientes = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		tblClientes.addMouseListener(this);
		scrollPane.setViewportView(tblClientes);
		
		btnActualizarCli = new Button("Actualizar Tabla");
		btnActualizarCli.addActionListener(this);
		btnActualizarCli.setBounds(252, 309, 177, 22);
		btnActualizarCli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizarCli.setFont(new Font("Roboto Medium", Font.BOLD, 14));
		panel.add(btnActualizarCli);
		
		lblBuscarPorDni = new JLabel("BUSCAR POR DNI ");
		lblBuscarPorDni.setBounds(10, 10, 177, 14);
		lblBuscarPorDni.setForeground(Color.WHITE);
		lblBuscarPorDni.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblBuscarPorDni);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(197, 10, 188, 19);
		txtBuscar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		panel.add(txtBuscar);
		ImageIcon icoBus=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(frmClientes.class.getResource("/img/add_icon-icons.com_74429.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(53, 399, 65, 43);
		contentPanel.add(label_3);
		
		btnAgregarCli = new Button("Agregar un Cliente");
		btnAgregarCli.addActionListener(this);
		btnAgregarCli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarCli.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		btnAgregarCli.setBounds(24, 448, 132, 22);
		contentPanel.add(btnAgregarCli);
		
		btnModCliente = new Button("Modificar un Cliente");
		btnModCliente.addActionListener(this);
		btnModCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModCliente.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		btnModCliente.setBounds(274, 448, 132, 22);
		contentPanel.add(btnModCliente);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(frmClientes.class.getResource("/img/pen_edit_modify_pencil_icon_181536 (1).png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(311, 399, 65, 43);
		contentPanel.add(label_4);
		
		label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(565, 399, 56, 43);
		ImageIcon icoMod=new ImageIcon(getClass().getResource("/img/1486504830-delete-dustbin-empty-recycle-recycling-remove-trash_81361 (1).png"));
		ImageIcon imgMod=new ImageIcon(icoMod.getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), Image.SCALE_SMOOTH));
		label_5.setIcon(imgMod);
		contentPanel.add(label_5);
		
		btnElimCliente = new Button("Eliminar Cliente");
		btnElimCliente.addActionListener(this);
		btnElimCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimCliente.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		btnElimCliente.setBounds(530, 448, 132, 22);
		contentPanel.add(btnElimCliente);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(638, 11, 39, 30);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imgCerrar);
		contentPanel.add(lblNewLabel);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Dni");
		model.addColumn("Teléfono");
		model.addColumn("Correo");
		tblClientes.setModel(model);
		
		btnBuscar = new JButton("");
		btnBuscar.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(frmClientes.class.getResource("/img/search_icon-icons.com_74448.png")));
		btnBuscar.setBounds(395, 7, 27, 25);
		panel.add(btnBuscar);
		
		lblBuscar = new JLabel("*");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setBounds(154, 10, 27, 14);
		panel.add(lblBuscar);
		lblBuscar.setVisible(false);
		listarClientes();
		ajustarAnchoColumnas();
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblNewLabel) {
			mouseClickedLblNewLabel(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			do_btnBuscar_mouseEntered(arg0);
		}
		if (arg0.getSource() == tblClientes) {
			do_tblClientes_mouseEntered(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == contentPanel) {
			mousePressedContentPanel(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
		
	}
	protected void mouseClickedLblNewLabel(MouseEvent arg0) {
		frmPrincipalEmp pri=new frmPrincipalEmp();
		pri.setVisible(true);
		pri.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void mousePressedContentPanel(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPanel) {
			mouseDraggedContentPanel(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedContentPanel(MouseEvent arg0) {
		int x=arg0.getXOnScreen();
		int y=arg0.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnActualizarCli) {
			do_btnActualizarCli_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnElimCliente) {
			actionPerformedBtnElimCliente(arg0);
		}
		if (arg0.getSource() == btnModCliente) {
			actionPerformedBtnModCliente(arg0);
		}
		if (arg0.getSource() == btnAgregarCli) {
			actionPerformedBtnAgregarCli(arg0);
		}
	}
	protected void actionPerformedBtnAgregarCli(ActionEvent arg0) {
		listarClientes();
		frmAddCliente addCli=new frmAddCliente();
		addCli.setVisible(true);
		addCli.setLocationRelativeTo(null);
	}
	protected void actionPerformedBtnModCliente(ActionEvent arg0) {
		listarClientes();
		frmModCliente modCli=new frmModCliente();
		modCli.setVisible(true);
		modCli.setLocationRelativeTo(null);
	}
	protected void actionPerformedBtnElimCliente(ActionEvent arg0) {
		listarClientes();
		frmEliminarCliente elimCli=new frmEliminarCliente();
		elimCli.setVisible(true);
		elimCli.setLocationRelativeTo(null);
	}
	
	
	void listarClientes() {
		model.setRowCount(0);
		ArrayList<Cliente> data = gc.listar();
		//paso 3: crear un bucle para recorrido
		for (Cliente c : data) {
			//crear arreglo
			Object fila[] = {c.getIdCliente(),
							 c.getNombre(),
							 c.getApellido(),
							 c.getDni(),
							 c.getTelefono(),
							 c.getCorreo()};
			model.addRow(fila);
		}
		
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblClientes.getColumnModel();
		//Ocultar Codigo de usuario
		tblClientes.getColumnModel().getColumn(0).setMaxWidth(0);
		tblClientes.getColumnModel().getColumn(0).setMinWidth(0);
		tblClientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tblClientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		//fin de codigo
		//tcm.getColumn(0).setPreferredWidth(anchoColumna(9));  // Codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25));  // Nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  // Apellido
		tcm.getColumn(3).setPreferredWidth(anchoColumna(15));  // Dni
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));  // telefono
		tcm.getColumn(5).setPreferredWidth(anchoColumna(30));  // Correo
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	protected void do_btnActualizarCli_actionPerformed(ActionEvent arg0) {
		listarClientes();
	}
	
	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		buscarDNI();
	}
	
	private void buscarDNI() {
		String dni;
		int fila;
		dni = getBuscar();
		listarClientes();
		fila = 	confirmarDNI(tblClientes,dni,3);	
		lblBuscar.setVisible(false);
		
		if (dni == null) {
			Buscar(true);
		}
		else if(fila == -1) {
			mensaje("Cliente no existe !.");
			txtBuscar.requestFocus();	
		}
		else {
			tblClientes.changeSelection(fila, 1, false, false);
		}
					
	}
		
	
	
	private String getBuscar() {
		String dni = null;
		if(txtBuscar.getText().trim().length() == 0) {
			Buscar(true);
		}
			
		else if(txtBuscar.getText().trim().matches(Validacion.DNI) == false)
			mensaje("El DNI a buscar debe contener 8 números");
		else
			dni = txtBuscar.getText();
		
	return dni;

	}
	
	private void mensaje(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 0);
	}
	
	private void Buscar(boolean i) {
		lblBuscar.setVisible(i);
		txtBuscar.requestFocus();
	}
	
	public int confirmarDNI(JTable tabla,String info,int columna) {
		int fila = -1;
		for(int i = 0 ; i < tabla.getRowCount() ; i++) {
			if(tabla.getValueAt(i,columna).equals(info)) {
				fila = i;
				break;
			}
		}
		return fila;
		}
	
	//if(al.confirmarDNI(table,leerDniAlumno(),3)==false)
	
	protected void do_tblClientes_mouseEntered(MouseEvent arg0) {
		tblClientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void do_btnBuscar_mouseEntered(MouseEvent arg0) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
