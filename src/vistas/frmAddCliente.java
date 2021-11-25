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
import javax.swing.border.LineBorder;

import controlador.GestionClienteDAO;
import entidad.Cliente;
import utils.Validacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAddCliente extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JPanel panel_1;
	private JLabel lblNuevoCliente;
	private JLabel label_1;
	private JLabel label_3;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JButton button;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	GestionClienteDAO gc = new GestionClienteDAO();
	private JLabel lblNom;
	private JLabel lblApe;
	private JLabel lblDn;
	private JLabel lblTele;
	private JLabel lblCorre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmAddCliente dialog = new frmAddCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmAddCliente() {
		setBounds(0,0, 450, 350);
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
		
		lblNuevoCliente = new JLabel("NUEVO CLIENTE");
		lblNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoCliente.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblNuevoCliente.setBounds(129, 23, 191, 26);
		panel_1.add(lblNuevoCliente);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH));
		label_1.setIcon(imgCerrar);
		panel_1.add(label_1);
		
		label_3 = new JLabel("Nombre");
		label_3.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_3.setBounds(48, 80, 65, 29);
		panel_1.add(label_3);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblApellido.setBounds(48, 120, 96, 27);
		panel_1.add(lblApellido);
		
		lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblDni.setBounds(48, 160, 96, 24);
		panel_1.add(lblDni);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono.setBounds(48, 200, 96, 26);
		panel_1.add(lblTelefono);
		
		button = new JButton("GUARDAR");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(frmAddCliente.class.getResource("/img/check_40622.png")));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		button.setBounds(129, 298, 158, 41);
		panel_1.add(button);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(190, 200, 168, 26);
		panel_1.add(txtTelefono);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtDni.setColumns(10);
		txtDni.setBounds(190, 160, 168, 26);
		panel_1.add(txtDni);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtApellido.setColumns(10);
		txtApellido.setBounds(190, 120, 168, 26);
		panel_1.add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(190, 80, 168, 26);
		panel_1.add(txtNombre);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCorreo.setBounds(48, 240, 96, 26);
		panel_1.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(190, 240, 168, 26);
		panel_1.add(txtCorreo);
		
		lblNom = new JLabel("*");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setForeground(Color.RED);
		lblNom.setBounds(106, 86, 44, 14);
		panel_1.add(lblNom);
		
		lblApe = new JLabel("*");
		lblApe.setForeground(Color.RED);
		lblApe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApe.setBounds(106, 126, 44, 14);
		panel_1.add(lblApe);
		
		lblDn = new JLabel("*");
		lblDn.setForeground(Color.RED);
		lblDn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDn.setBounds(74, 166, 44, 14);
		panel_1.add(lblDn);
		
		lblTele = new JLabel("*");
		lblTele.setForeground(Color.RED);
		lblTele.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTele.setBounds(110, 206, 44, 14);
		panel_1.add(lblTele);
		
		lblCorre = new JLabel("*");
		lblCorre.setForeground(Color.RED);
		lblCorre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCorre.setBounds(100, 246, 44, 14);
		panel_1.add(lblCorre);
		setUndecorated(true);
		setLocationRelativeTo(null);
		lblerror(false);
	}

	public void mouseClicked(MouseEvent arg0) {
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
		xMouse=arg0.getX();
		yMouse=arg0.getY();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == panel) {
			mouseDraggedPanel(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedPanel(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		this.dispose();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			do_button_actionPerformed(e);
		}
	}
	protected void do_button_actionPerformed(ActionEvent e) {
		lblerror(false);
		registrarCliente();
		
	}
	
	void registrarCliente(){
		String nomb,apell,dni,tlf,correo;
		
		nomb = getNombre();
		apell = getApellido();
		dni = getDni();
		tlf = getTelefono();
		correo = getCorreo();
		
		if(nomb == null || apell == null || dni == null || tlf == null || correo == null) {
			//
		}
		
		else {
			Cliente c = new Cliente();
			c.setNombre(nomb);
			c.setApellido(apell);
			c.setDni(dni);
			c.setTelefono(tlf);
			c.setCorreo(correo);
			int ok = gc.registrar(c);
			
			if(ok == 0)
				mensaje("Error en el registro");
			else {
				mensaje1("El registro se realizó satisfactoriamente");
				limpiar();
				txtNombre.requestFocus();
			}
				
		}
		
		
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
	
	private String getApellido() {
		String ape = null;
		if(txtApellido.getText().trim().length() == 0) {
			lblApe.setVisible(true);
			txtNombre.requestFocus();
		}
			
		else if(txtApellido.getText().trim().matches(Validacion.NOMBREYAPELLIDO) == false)
			mensaje("Formato incorrecto del Apellido. Solo de 3 a 45 letras y 1 espacio por apellido");
		else
			ape = txtApellido.getText();
		
	return ape;

	}
	
	private String getDni() {
		String dni = null;
		if(txtDni.getText().trim().length() == 0) {
			lblDn.setVisible(true);
			txtDni.requestFocus();
		}
			
		else if(txtDni.getText().trim().matches(Validacion.DNI) == false)
			mensaje("Formato incorrecto del DNI. Ingresar 8 números");
		else
			dni = txtDni.getText();
		
	return dni;

	}
	
	private String getTelefono() {
		String tlf = null;
		if(txtTelefono.getText().trim().length() == 0) {
			lblTele.setVisible(true);
			txtDni.requestFocus();
		}
		else if(txtTelefono.getText().trim().matches(Validacion.TELEFONO) == false)
			mensaje("Formato incorrecto del Telefono. Ingresar de 7 a 9 números");
		else
			tlf = txtTelefono.getText();
		
	return tlf;

	}
	
	private String getCorreo() {
		String correo = null;
		if(txtCorreo.getText().trim().length() == 0) {
			lblCorre.setVisible(true);
			txtCorreo.requestFocus();
		}
			
		else if(txtCorreo.getText().trim().matches(Validacion.CORREO) == false)
			mensaje("Formato incorrecto del Correo. Ejemplo Paul_Vega@Cibertec.edu.pe");
		else
			correo = txtCorreo.getText();		
	return correo;
	}
	
	
	
	
	private void mensaje(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 0);
	}
	
	private void mensaje1(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 1);
		
	}
	
	private void lblerror(boolean tof) {
		lblNom.setVisible(tof);
		lblApe.setVisible(tof);
		lblDn.setVisible(tof);
		lblTele.setVisible(tof);
		lblCorre.setVisible(tof);
	}
	
	private void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
	}
}
