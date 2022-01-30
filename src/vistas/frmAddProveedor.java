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
import java.awt.image.ImagingOpException;

import javax.swing.border.LineBorder;

import controlador.GestionProveedorDAO;
import entidad.Cliente;
import entidad.Proveedor;
import utils.Validacion;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAddProveedor extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	int xMouse,yMouse;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JLabel lblNuevoProveedor;
	private JLabel lblCodigoDeProveedor;
	private JTextField txtRUC;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblTelefono;
	private JTextField txtDireccion;
	private JLabel lblTelefono_1;
	private JTextField txtTelefono;
	private JLabel lblInfoExtra;
	private JButton btnGuardar;
	private JLabel lblRUC;
	private JLabel lblNom;
	private JLabel lblDir;
	private JLabel lblTele;
	GestionProveedorDAO gp = new GestionProveedorDAO();
	private JTextField txtInformacion;
	private JTextField txtContacto;
	private JLabel lblContacto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmAddProveedor dialog = new frmAddProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmAddProveedor() {
		setBounds(0, 0, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 450, 350);
		panel.setBackground(new Color(193,18,5));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(this);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH));
		label.setIcon(imgCerrar);
		panel_1.add(label);
		
		lblNuevoProveedor = new JLabel("NUEVO PROVEEDOR");
		lblNuevoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblNuevoProveedor.setBounds(107, 21, 212, 26);
		panel_1.add(lblNuevoProveedor);
		
		lblCodigoDeProveedor = new JLabel("N\u00FAmero de RUC:");
		lblCodigoDeProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCodigoDeProveedor.setBounds(10, 74, 158, 26);
		panel_1.add(lblCodigoDeProveedor);
		
		txtRUC = new JTextField();
		txtRUC.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtRUC.setColumns(10);
		txtRUC.setBounds(190, 75, 168, 26);
		panel_1.add(txtRUC);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNombre.setBounds(10, 110, 96, 29);
		panel_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(190, 112, 168, 26);
		panel_1.add(txtNombre);
		
		lblTelefono = new JLabel("Direccion:");
		lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono.setBounds(10, 150, 96, 27);
		panel_1.add(lblTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(190, 152, 168, 26);
		panel_1.add(txtDireccion);
		
		lblTelefono_1 = new JLabel("Telefono:");
		lblTelefono_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono_1.setBounds(10, 190, 96, 24);
		panel_1.add(lblTelefono_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(190, 190, 168, 26);
		panel_1.add(txtTelefono);
		
		lblInfoExtra = new JLabel("Informaci\u00F3n Extra:");
		lblInfoExtra.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblInfoExtra.setBounds(10, 225, 135, 26);
		panel_1.add(lblInfoExtra);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(frmAddProveedor.class.getResource("/img/check_40622.png")));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnGuardar.setBounds(130, 298, 158, 41);
		panel_1.add(btnGuardar);
		
		lblRUC = new JLabel("*");
		lblRUC.setForeground(Color.RED);
		lblRUC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRUC.setBounds(131, 80, 46, 14);
		panel_1.add(lblRUC);
		
		lblNom = new JLabel("*");
		lblNom.setForeground(Color.RED);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(72, 116, 46, 14);
		panel_1.add(lblNom);
		
		lblDir = new JLabel("*");
		lblDir.setForeground(Color.RED);
		lblDir.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDir.setBounds(83, 155, 46, 14);
		panel_1.add(lblDir);
		
		lblTele = new JLabel("*");
		lblTele.setForeground(Color.RED);
		lblTele.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTele.setBounds(76, 195, 46, 14);
		panel_1.add(lblTele);
		
		txtInformacion = new JTextField();
		txtInformacion.setBounds(190, 225, 168, 26);
		panel_1.add(txtInformacion);
		txtInformacion.setColumns(10);
		
		txtContacto = new JTextField();
		txtContacto.setColumns(10);
		txtContacto.setBounds(190, 261, 168, 26);
		panel_1.add(txtContacto);
		
		lblContacto = new JLabel("Contacto:");
		lblContacto.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblContacto.setBounds(10, 261, 135, 26);
		panel_1.add(lblContacto);
		setUndecorated(true);
		setLocationRelativeTo(null);
		lblerror(false);
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label) {
			mouseClickedLabel(arg0);
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
	protected void mouseClickedLabel(MouseEvent arg0) {
		this.dispose();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		lblerror(false);
		registrarProveedor();
	}
	
	void registrarProveedor(){
		String ruc, nomb,dir,tlf,info,contacto;
		
		ruc = getRUC();
		nomb = getNombre();
		dir = getDireccion();
		tlf = getTelefono();
		info = getInformacion();
		contacto = getContacto();
		
		
		if(ruc == null || nomb == null || dir == null || tlf == null) {
			mensaje1("No se pudo registrar proveedor");
		}
		
		else {
			Proveedor p = new Proveedor();
			p.setRuc(ruc);
			p.setNombre(nomb);
			p.setDireccion(dir);
			p.setTelefono(tlf);
			p.setInformacion(info);
			p.setContacto(contacto);
			int ok = gp.registrar(p);
			
			if(ok == 0)
				mensaje("Error en el registro");
			else {
				mensaje1("El registro de Proveedor se realizó satisfactoriamente");
				limpiar();
				txtRUC.requestFocus();
			}
				
		}
		
		
	}
	
	private void lblerror(boolean tof) {
		lblRUC.setVisible(tof);
		lblNom.setVisible(tof);
		lblDir.setVisible(tof);
		lblTele.setVisible(tof);
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
	private String getContacto(){
		String con=null;
			con = txtContacto.getText().trim();
		return con;
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
		return txtInformacion.getText();
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
	
	private void mensaje(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 0);
	}
	
	private void mensaje1(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 1);
		
	}
	
	private void limpiar() {
		txtRUC.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtInformacion.setText("");
		txtContacto.setText("");
	}
}
