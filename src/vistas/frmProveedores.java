package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controlador.GestionProveedorDAO;
import entidad.Cliente;
import entidad.Proveedor;
import utils.Validacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmProveedores extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JLabel lblProveedores;
	private JLabel label_1;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private Button btnActualizar;
	private JLabel lblBuscarPorRuc;
	private JTextField txtBuscar;
	private JLabel lblLupa;
	private JLabel label_4;
	private Button button_1;
	private Button button_2;
	private JLabel label_5;
	private JLabel label_6;
	private Button button_3;
	private JTable tblProveedor;
	DefaultTableModel model = new DefaultTableModel();
	GestionProveedorDAO gp = new GestionProveedorDAO();
	private JLabel lblBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmProveedores dialog = new frmProveedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmProveedores() {
		setBounds(0,0,687,480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0,0,687,480);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblProveedores = new JLabel("PROVEEDORES");
		lblProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedores.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblProveedores.setBounds(269, 11, 184, 30);
		panel.add(lblProveedores);
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(this);
		label_1.setIcon(new ImageIcon(frmProveedores.class.getResource("/img/cerrarVnt.png")));
		label_1.setBounds(645, 11, 32, 30);
		panel.add(label_1);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(193, 18, 5));
		panel_1.setBounds(0, 47, 687, 341);
		panel.add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(0, 35, 687, 268);
		panel_1.add(scrollPane);
		
		tblProveedor = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		tblProveedor.addMouseListener(this);
		scrollPane.setViewportView(tblProveedor);
		
		btnActualizar = new Button("Actualizar Tabla");
		btnActualizar.addActionListener(this);
		btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizar.setFont(new Font("Roboto Medium", Font.BOLD, 14));
		btnActualizar.setBounds(252, 309, 177, 22);
		panel_1.add(btnActualizar);
		
		lblBuscarPorRuc = new JLabel("BUSCAR POR RUC");
		lblBuscarPorRuc.setForeground(Color.WHITE);
		lblBuscarPorRuc.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBuscarPorRuc.setBounds(10, 10, 177, 14);
		panel_1.add(lblBuscarPorRuc);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(197, 10, 188, 19);
		panel_1.add(txtBuscar);
		
		lblLupa = new JLabel("");
		lblLupa.addMouseListener(this);
		lblLupa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLupa.setBounds(395, 10, 30, 22);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(lblLupa.getWidth(), lblLupa.getHeight(), Image.SCALE_SMOOTH));
		lblLupa.setIcon(imgBuscar);
		panel_1.add(lblLupa);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(frmProveedores.class.getResource("/img/add_icon-icons.com_74429.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(70, 399, 65, 43);
		panel.add(label_4);
		
		button_1 = new Button("Agregar Nuevo Proveedor");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(this);
		button_1.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_1.setBounds(24, 448, 160, 22);
		panel.add(button_1);
		
		button_2 = new Button("Modificar un Proveedor");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.addActionListener(this);
		button_2.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_2.setBounds(274, 448, 140, 22);
		panel.add(button_2);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(frmProveedores.class.getResource("/img/pen_edit_modify_pencil_icon_181536 (1).png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(311, 399, 65, 43);
		panel.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(565, 399, 60, 43);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/1486504830-delete-dustbin-empty-recycle-recycling-remove-trash_81361 (1).png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_6.getWidth(),label_6.getHeight() , Image.SCALE_SMOOTH));
		label_6.setIcon(imgCerrar);
		panel.add(label_6);
		
		button_3 = new Button("Eliminar Proveedor");
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.addActionListener(this);
		button_3.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		button_3.setBounds(530, 448, 132, 22);
		panel.add(button_3);
		
		model.addColumn("Código");
		model.addColumn("RUC");
		model.addColumn("Nombre");
		model.addColumn("Dirección");
		model.addColumn("Telfono");
		model.addColumn("Información");
		tblProveedor.setModel(model);
		
		lblBuscar = new JLabel("*");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setBounds(160, 8, 46, 14);
		panel_1.add(lblBuscar);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		listarProveedores();
		lblBuscar.setVisible(false);
		ajustarAnchoColumnas();
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblLupa) {
			do_lblLupa_mouseClicked(arg0);
		}
		if (arg0.getSource() == label_1) {
			mouseClickedLabel_1(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == tblProveedor) {
			do_tblProveedor_mouseEntered(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == panel) {
			mousePressedPanel(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mousePressedPanel(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == panel) {
			mouseDraggedPanel(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedPanel(MouseEvent arg0) {
		int x = arg0.getXOnScreen();
		int y = arg0.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(arg0);
		}
		if (arg0.getSource() == button_3) {
			actionPerformedButton_3(arg0);
		}
		if (arg0.getSource() == button_2) {
			actionPerformedButton_2(arg0);
		}
		if (arg0.getSource() == button_1) {
			actionPerformedButton_1(arg0);
		}
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
		listarProveedores();
		frmAddProveedor addprove=new frmAddProveedor();
		addprove.setVisible(true);
		addprove.setLocationRelativeTo(null);
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		listarProveedores();
		frmPrincipalEmp pri=new frmPrincipalEmp();
		pri.setVisible(true);
		pri.setLocationRelativeTo(null);
		this.dispose();
	}
	protected void actionPerformedButton_2(ActionEvent arg0) {
		listarProveedores();
		frmModProveedor mod=new frmModProveedor();
		mod.setVisible(true);
		mod.setLocationRelativeTo(null);
	}
	
	protected void actionPerformedButton_3(ActionEvent arg0) {
		frmEliminarProveedor elim=new frmEliminarProveedor();
		elim.setVisible(true);
		elim.setLocationRelativeTo(null);
	}
	
	void listarProveedores() {
		model.setRowCount(0);
		ArrayList<Proveedor> data = gp.listarProveedor();
		for (Proveedor p : data) {
			//crear arreglo
			Object fila[] = {p.getIdProveedor(),
							 p.getRuc(),
							 p.getNombre(),
							 p.getDireccion(),
							 p.getTelefono(),
							 p.getInformacion()};
			model.addRow(fila);
		}
		
	}
	
	private void buscarRUC() {
		String ruc;
		int fila;
		ruc = getBuscar();
		listarProveedores();
		fila = 	confirmarRUC(tblProveedor,ruc,1);	
		lblBuscar.setVisible(false);
		
		if (ruc == null) {
			Buscar(true);
		}
		else if(fila == -1) {
			mensaje("El número de RUC nó se encuentra registrado.");
			txtBuscar.requestFocus();	
		}
		else {
			tblProveedor.changeSelection(fila, 1, false, false);
		}
					
	}
	
	private String getBuscar() {
		String ruc = null;
		if(txtBuscar.getText().trim().length() == 0) {
			Buscar(true);
		}
			
		else if(txtBuscar.getText().trim().matches(Validacion.RUC) == false)
			mensaje("Formato incorrecto del RUC. Ingrese solo un número de 11 dígitos");
		else
			ruc = txtBuscar.getText();
		
	return ruc;

	}
	
	private void mensaje(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 0);
	}
	
	private void Buscar(boolean i) {
		lblBuscar.setVisible(i);
		txtBuscar.requestFocus();
	}
	
	public int confirmarRUC(JTable tabla,String info,int columna) {
		int fila = -1;
		for(int i = 0 ; i < tabla.getRowCount() ; i++) {
			if(tabla.getValueAt(i,columna).equals(info)) {
				fila = i;
				break;
			}
		}
		return fila;
		}
	protected void do_lblLupa_mouseClicked(MouseEvent arg0) {
		buscarRUC();
	}
	protected void do_btnActualizar_actionPerformed(ActionEvent arg0) {
		listarProveedores();
	}
	protected void do_tblProveedor_mouseEntered(MouseEvent arg0) {
		tblProveedor.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblProveedor.getColumnModel();
		//Ocultar Codigo de usuario
		tblProveedor.getColumnModel().getColumn(0).setMaxWidth(0);
		tblProveedor.getColumnModel().getColumn(0).setMinWidth(0);
		tblProveedor.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tblProveedor.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		//fin de codigo
		//tcm.getColumn(0).setPreferredWidth(anchoColumna(9));  // Codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));  // RUC
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  // Nombre
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25));  // Direccion
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));  // telefono
		tcm.getColumn(5).setPreferredWidth(anchoColumna(30));  // Informacion
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
}
