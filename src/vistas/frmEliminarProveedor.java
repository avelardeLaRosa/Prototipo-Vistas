package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controlador.GestionProveedorDAO;
import entidad.Proveedor;
import utils.Validacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;

public class frmEliminarProveedor extends JDialog implements MouseListener, ActionListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblSeleccioneOIngrese;
	private JLabel lblBuscarPorRuc;
	private JTextField txtBuscar;
	private JLabel label_2;
	private JLabel label_3;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JTable tblProveedor;
	DefaultTableModel model = new DefaultTableModel();
	GestionProveedorDAO gp = new GestionProveedorDAO();
	frmProveedores bp = new frmProveedores();
	private JLabel lblBuscar;
	int xMouse,yMouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmEliminarProveedor dialog = new frmEliminarProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmEliminarProveedor() {
		setBounds(0, 0, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 450, 350);
		panel.setBackground(new Color(193,18,5));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.addMouseMotionListener(this);
		panel_1.addMouseListener(this);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblSeleccioneOIngrese = new JLabel("Seleccione o ingrese un RUC");
		lblSeleccioneOIngrese.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneOIngrese.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblSeleccioneOIngrese.setBounds(34, 25, 352, 26);
		panel_1.add(lblSeleccioneOIngrese);
		
		lblBuscarPorRuc = new JLabel("BUSCAR POR RUC");
		lblBuscarPorRuc.setForeground(Color.BLACK);
		lblBuscarPorRuc.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblBuscarPorRuc.setBounds(23, 78, 172, 22);
		panel_1.add(lblBuscarPorRuc);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(205, 78, 179, 22);
		panel_1.add(txtBuscar);
		
		label_2 = new JLabel("");
		label_2.addMouseListener(this);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setBounds(390, 78, 30, 22);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscarr=new ImageIcon(icoBuscar.getImage().getScaledInstance(label_2.getWidth(),label_2.getHeight(), Image.SCALE_SMOOTH));
		label_2.setIcon(imgBuscarr);
		panel_1.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.addMouseListener(this);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_3.getWidth(),label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgCerrar);
		panel_1.add(label_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(10, 111, 410, 191);
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
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnEliminar.setBounds(125, 313, 172, 26);
		panel_1.add(btnEliminar);
		
		lblBuscar = new JLabel("*");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscar.setForeground(Color.RED);
		lblBuscar.setBounds(170, 79, 46, 14);
		panel_1.add(lblBuscar);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		model.addColumn("Código");
		model.addColumn("RUC");
		model.addColumn("Nombre");
		model.addColumn("Direccion");
		tblProveedor.setModel(model);
		
		ajustarAnchoColumnas();
		listarProveedores();
		
		
		
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_2) {
			do_label_2_mouseClicked(arg0);
		}
		if (arg0.getSource() == label_3) {
			mouseClickedLabel_3(arg0);
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
		if (arg0.getSource() == panel_1) {
			mousePressedPanel_1(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLabel_3(MouseEvent arg0) {
		this.dispose();
	}
	
	
	void listarProveedores() {
		model.setRowCount(0);
		ArrayList<Proveedor> data = gp.listarProveedor();
		for (Proveedor p : data) {
			//crear arreglo
			Object fila[] = {p.getIdProveedor(),
							 p.getRuc(),
							 p.getNombre(),
							 p.getDireccion()};
							
			model.addRow(fila);
		}
		
	}
		
	
	private void Buscar(boolean i) {
		lblBuscar.setVisible(i);
		txtBuscar.requestFocus();
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
		tcm.getColumn(1).setPreferredWidth(anchoColumna(25));  // RUC
		tcm.getColumn(2).setPreferredWidth(anchoColumna(40));  // Nombre
		tcm.getColumn(3).setPreferredWidth(anchoColumna(40));  // Nombre
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	private void mensaje(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 0);
	}
	
	private void mensaje1(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 1);
	}
	
	protected void do_label_2_mouseClicked(MouseEvent arg0) {
		buscarRUC();
	}
	
	private void buscarRUC() {
		String ruc;
		int fila;	
		listarProveedores();
		ArrayList<Proveedor> data = gp.listarProveedor();
		lblBuscar.setVisible(false);
		if (data.size() == 0) {
			mensaje("No hay Proveedores registrados");
		}
		else {
			ruc = getBuscar();
			fila = 	bp.confirmarRUC(tblProveedor,ruc,1);
			
			if (ruc == null) {
				Buscar(true);
			}
			else if(fila == -1) {
				mensaje("EL Número de RUC nó se encuentra registrado.");
				txtBuscar.requestFocus();	
			}
			else {
				tblProveedor.changeSelection(fila, 1, false, false);
			}
		}
		
	}
	
	private String getBuscar() {
		String ruc = null;
		if(txtBuscar.getText().trim().length() == 0) {
			Buscar(true);
		}
			
		else if(txtBuscar.getText().trim().matches(Validacion.RUC) == false)
			mensaje("El número de RUC debe contener 11 números");
		else
			ruc = txtBuscar.getText();
		
	return ruc;

	}
	
	
	private void eliminarProveedor() {
		int boton, posFila, codigo;
		ArrayList<Proveedor> data = gp.listarProveedor();
		lblBuscar.setVisible(false);		
		if (data.size() == 0) {
			mensaje("No hay Proveedores registrados");
			return;
		}
		
		posFila = tblProveedor.getSelectedRow();
		
		if(posFila == -1) {
			mensaje("Seleccione o busque un Proveedor a eliminar");
			txtBuscar.requestFocus();
			return;
		}
		
		boton = JOptionPane.showConfirmDialog(this, "Seguro de eliminar ? "," Sistema",JOptionPane.YES_NO_OPTION);
		if(boton == 0) {		
			codigo = (int) tblProveedor.getValueAt(posFila, 0);
			int res = gp.eliminar(codigo);
			if(res == 0)
				mensaje("Error al eliminar");
			else {
				mensaje1("Proveedor eliminado");
				listarProveedores();
				txtBuscar.setText("");
				txtBuscar.requestFocus();
			}
			
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		eliminarProveedor();
	}
	protected void do_tblProveedor_mouseEntered(MouseEvent arg0) {
		tblProveedor.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mousePressedPanel_1(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
	}
	
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == panel_1) {
			mouseDraggedPanel_1(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedPanel_1(MouseEvent arg0) {
		int x = arg0.getXOnScreen();
		int y = arg0.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
}
