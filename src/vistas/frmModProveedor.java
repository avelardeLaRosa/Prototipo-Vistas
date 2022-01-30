package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import controlador.GestionClienteDAO;
import controlador.GestionProveedorDAO;
import entidad.Cliente;
import entidad.Proveedor;
import utils.Validacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmModProveedor extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	int xMouse,yMouse;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblModificaProveedor;
	private JLabel label_1;
	private JPanel panel_2;
	private JLabel lblCodigoDeProveedor;
	private JTextField txtBuscar;
	private JLabel lblLupa;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblTelefono;
	private JTextField txtDireccion;
	private JLabel lblTelefono_1;
	private JLabel lblInfoExtra;
	private JTextField txtTelefono;
	private JButton btnGuardar;
	private JLabel lblBuscar;
	private JLabel lblRUCA;
	private JTextField txtRUC;
	GestionProveedorDAO gp = new GestionProveedorDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmModProveedor dialog = new frmModProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmModProveedor() {
		setBounds(0, 0, 450, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193,18,5));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 450, 380);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 380);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblModificaProveedor = new JLabel("MODIFICA PROVEEDOR");
		lblModificaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaProveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblModificaProveedor.setBounds(88, 11, 248, 26);
		panel_1.add(lblModificaProveedor);
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(this);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight() , Image.SCALE_SMOOTH));
		label_1.setIcon(imgCerrar);
		panel_1.add(label_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 46, 410, 51);
		panel_1.add(panel_2);
		
		lblCodigoDeProveedor = new JLabel("N\u00FAmero de RUC");
		lblCodigoDeProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCodigoDeProveedor.setBounds(10, 11, 162, 26);
		panel_2.add(lblCodigoDeProveedor);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(179, 12, 168, 26);
		panel_2.add(txtBuscar);
		
		lblLupa = new JLabel("");
		lblLupa.addMouseListener(this);
		lblLupa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLupa.setBounds(357, 11, 31, 29);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(lblLupa.getWidth(),lblLupa.getHeight() , Image.SCALE_SMOOTH));
		lblLupa.setIcon(imgBuscar);
		panel_2.add(lblLupa);
		
		lblBuscar = new JLabel("*");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscar.setForeground(Color.RED);
		lblBuscar.setBounds(128, 13, 48, 12);
		panel_2.add(lblBuscar);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(190, 150, 168, 26);
		panel_1.add(txtNombre);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(190, 183, 168, 29);
		panel_1.add(txtDireccion);
		
		lblInfoExtra = new JLabel("Info Extra:");
		lblInfoExtra.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblInfoExtra.setBounds(48, 258, 96, 26);
		panel_1.add(lblInfoExtra);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(190, 223, 168, 26);
		panel_1.add(txtTelefono);
		
		btnGuardar = new JButton("GUARDAR CAMBIOS");
		btnGuardar.addActionListener(this);
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnGuardar.setBounds(109, 343, 188, 26);
		panel_1.add(btnGuardar);
		
		txtRUC = new JTextField();
		txtRUC.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtRUC.setEditable(false);
		txtRUC.setColumns(10);
		txtRUC.setBounds(190, 118, 168, 26);
		panel_1.add(txtRUC);
		
		lblRUC = new JLabel("*");
		lblRUC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRUC.setForeground(Color.RED);
		lblRUC.setBounds(98, 125, 46, 14);
		panel_1.add(lblRUC);
		
		lblNom = new JLabel("*");
		lblNom.setForeground(Color.RED);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(108, 157, 46, 14);
		panel_1.add(lblNom);
		
		lblDir = new JLabel("*");
		lblDir.setForeground(Color.RED);
		lblDir.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDir.setBounds(118, 191, 46, 14);
		panel_1.add(lblDir);
		
		lblTele = new JLabel("*");
		lblTele.setForeground(Color.RED);
		lblTele.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTele.setBounds(119, 228, 46, 14);
		panel_1.add(lblTele);
		
		txtInfo = new JTextField();
		txtInfo.setBounds(190, 260, 168, 26);
		panel_1.add(txtInfo);
		txtInfo.setColumns(10);
		
		lblContacto = new JLabel("Contacto:");
		lblContacto.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblContacto.setBounds(48, 295, 96, 26);
		panel_1.add(lblContacto);
		
		txtContacto = new JTextField();
		txtContacto.setColumns(10);
		txtContacto.setBounds(190, 297, 168, 26);
		panel_1.add(txtContacto);
		
		lblRUCA = new JLabel("RUC:");
		lblRUCA.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRUCA.setBounds(48, 118, 96, 29);
		panel_1.add(lblRUCA);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNombre.setBounds(48, 150, 96, 29);
		panel_1.add(lblNombre);
		
		lblTelefono = new JLabel("Direccion:");
		lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono.setBounds(48, 185, 96, 27);
		panel_1.add(lblTelefono);
		
		lblTelefono_1 = new JLabel("Telefono:");
		lblTelefono_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono_1.setBounds(48, 223, 96, 24);
		panel_1.add(lblTelefono_1);
		setUndecorated(true);
		setLocationRelativeTo(null);
		ActivarCAMPOS(false);
		lblBuscar.setVisible(false);
		lblerror(false);
	}
	
	//Codigo Global
		private int codigoG = -1;
		private JLabel lblRUC;
		private JLabel lblNom;
		private JLabel lblDir;
		private JLabel lblTele;
		private JTextField txtInfo;
		private JLabel lblContacto;
		private JTextField txtContacto;
	//

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblLupa) {
			do_lblLupa_mouseClicked(arg0);
		}
		if (arg0.getSource() == label_1) {
			mouseClickedLabel_1(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
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
		
		this.setLocation(x - xMouse, y - yMouse);
	}
	
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		this.dispose();
	}
	
	private void ActivarCAMPOS(boolean i) {
		txtRUC.setEditable(i);
		txtNombre.setEditable(i);
		txtDireccion.setEditable(i);
		txtTelefono.setEditable(i);
		txtContacto.setEditable(i);
		txtInfo.setEditable(i);
	}
	
	private void Buscar(boolean i) {
		lblBuscar.setVisible(i);
		txtBuscar.requestFocus();
	}
	
	protected void do_lblLupa_mouseClicked(MouseEvent arg0) {
		buscarRUC();
	}
	
	private void buscarRUC() {
		String ruc;
		ruc = getBuscar();
		ArrayList<Proveedor> data = new GestionProveedorDAO().listarProveedorXRuc(ruc);
		lblBuscar.setVisible(false);
		ActivarCAMPOS(false);
		limpiarMOD();
		if (ruc == null) {
			Buscar(true);
		}
		
		else if (data.size() == 0) {
			mensaje("El número de RUC ingresado no existe");
			lblBuscar.setVisible(true);
			txtBuscar.requestFocus();
			limpiar();
		} 
		else {
			Proveedor p = data.get(0);
			txtRUC.setText(p.getRuc());
			txtNombre.setText(p.getNombre());
			txtDireccion.setText(p.getDireccion());
			txtTelefono.setText(p.getTelefono());
			txtInfo.setText(p.getInformacion());
			txtContacto.setText(p.getContacto());
			codigoG = p.getIdProveedor();
			ActivarCAMPOS(true);
			
		}
	}
	
	private void limpiar() {
		txtBuscar.setText("");
		txtRUC.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtInfo.setText("");
		txtBuscar.requestFocus();
		txtContacto.setText("");
	}
	
	private void limpiarMOD() {
		txtNombre.setText("");
		txtRUC.setText("");
		txtTelefono.setText("");
		txtInfo.setText("");
	}
	
	private String getBuscar() {
		String ruc = null;
		if(txtBuscar.getText().trim().length() == 0) {
			Buscar(true);
		}
			
		else if(txtBuscar.getText().trim().matches(Validacion.RUC) == false){
			mensaje("El RUC a modificar debe contener 11 números");
			limpiar();
		}
		else
			ruc = txtBuscar.getText();
		
	return ruc;

	}
	private String getContacto(){
		String cont=null;
		cont = txtContacto.getText().trim();
		return cont;
	}
	
	private void mensaje(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 0);
	}
	
	private void mensaje1(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 1);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
	}
	
	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		actualizarProveedor();
	}
	
	void actualizarProveedor(){
		String ruc,nomb,dir,tlf,info,cont;
		ruc = getRUC();
		nomb = getNombre();	
		dir = getDireccion();
		tlf = getTelefono();
		info = getInformacion();
		cont = getContacto();
		lblBuscar.setVisible(false);
		
		if(codigoG == -1) {
			mensaje("Debe buscar un proveedor, antes de modificar.");
			limpiar();
			Buscar(true);
			return;
		}
		
		if(ruc == null || nomb == null || dir == null || tlf == null) {
			//
		}
		
		else {
			Proveedor p= new Proveedor();
			
			p.setRuc(ruc);
			p.setNombre(nomb);
			p.setDireccion(dir);
			p.setTelefono(tlf);
			p.setInformacion(info);
			p.setIdProveedor(codigoG);
			p.setContacto(cont);
			int ok = gp.actualizar(p);
			
			if(ok == 0)
				mensaje("Error en la modificación");
			else {
				mensaje1("La modificación se realizó satisfactoriamente");
				limpiar();
				txtBuscar.requestFocus();
				codigoG = -1;
				ActivarCAMPOS(false);
			}		
		}
	}
	
	
	private String getRUC() {
		String ruc = null;
		if(txtRUC.getText().trim().length() == 0) {
			lblRUC.setVisible(true);
			txtRUC.requestFocus();
		}
			
		else if(txtRUC.getText().trim().matches(Validacion.RUC) == false)
			mensaje("Formato incorrecto del RUC. Ingrese solo un número de 11 dígitos");
		else
			ruc = txtRUC.getText();
		
	return ruc;
	}
	
	private String getNombre() {
		String usu = null;
		if(txtNombre.getText().trim().length() == 0) {
			lblNom.setVisible(true);
			txtNombre.requestFocus();
		}
			
		else if(txtNombre.getText().trim().matches(Validacion.NOMBREYAPELLIDO) == false)
			mensaje("Formato incorrecto del NOMBRE. Solo de 3 a 45 letras y 1 espacio por nombre");
		else
			usu = txtNombre.getText();
		
	return usu;
	}
	
	private String getDireccion() {
		String dir = null;
		if(txtDireccion.getText().trim().length() == 0) {
			lblDir.setVisible(true);
			txtDireccion.requestFocus();
		}
		/*else if(txtDireccion.getText().trim().matches(Validaciones.DIRECCION) == false)
			mensaje("Formato incorrecto de la dirección. Ingresar solo letras, numeros, punto y numeral de 3 a 45 Caracteres");*/
		else
			dir = txtDireccion.getText();
		
	return dir;

	}
	
	private String getInformacion() {
		return txtInfo.getText();
	}
	
	
	private String getTelefono() {
		String tlf = null;
		if(txtTelefono.getText().trim().length() == 0) {
			lblTele.setVisible(true);
			txtTelefono.requestFocus();
		}
		else if(txtTelefono.getText().trim().matches(Validacion.TELEFONO) == false)
			mensaje("Formato incorrecto del Telefono. Ingresar de 7 a 9 números");
		else
			tlf = txtTelefono.getText();
		
	return tlf;

	}
	
	private void lblerror(boolean tof) {
		lblRUC.setVisible(tof);
		lblNom.setVisible(tof);
		lblDir.setVisible(tof);
		lblTele.setVisible(tof);
	}
}
