package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.GestionClienteDAO;

import entidad.Cliente;
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
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmModCliente extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JPanel panel_1;
	private JLabel lblModificaUnCliente;
	private JLabel label_1;
	private JPanel panel_2;
	private JLabel lblDniDeCliente;
	private JTextField txtBuscar;
	private JLabel label_4;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JButton button;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JButton btnBuscar;
	GestionClienteDAO gc = new GestionClienteDAO();
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmModCliente dialog = new frmModCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmModCliente() {
		setBounds(0,0,450,350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193,18,5));
		panel.setBounds(0, 0, 450, 350);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblModificaUnCliente = new JLabel("MODIFICA UN CLIENTE");
		lblModificaUnCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaUnCliente.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblModificaUnCliente.setBounds(111, 11, 221, 26);
		panel_1.add(lblModificaUnCliente);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH));
		label_1.setIcon(imgCerrar);
		panel_1.add(label_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 46, 410, 51);
		panel_1.add(panel_2);
		
		lblDniDeCliente = new JLabel("DNI de Cliente");
		lblDniDeCliente.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblDniDeCliente.setBounds(10, 11, 146, 26);
		panel_2.add(lblDniDeCliente);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(179, 12, 168, 26);
		panel_2.add(txtBuscar);
		
		btnBuscar = new JButton("New button");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(frmModCliente.class.getResource("/img/search_icon-icons.com_74448.png")));
		btnBuscar.setBounds(357, 11, 28, 29);
		panel_2.add(btnBuscar);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(151, 12, 24, 26);
		panel_2.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setVisible(false);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		
		label_4 = new JLabel("Nombre");
		label_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_4.setBounds(48, 105, 96, 29);
		panel_1.add(label_4);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(190, 105, 168, 26);
		panel_1.add(txtNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblApellido.setBounds(48, 145, 96, 27);
		panel_1.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtApellido.setColumns(10);
		txtApellido.setBounds(190, 142, 168, 29);
		panel_1.add(txtApellido);
		
		lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblDni.setBounds(48, 183, 96, 24);
		panel_1.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtDni.setColumns(10);
		txtDni.setBounds(190, 183, 168, 26);
		panel_1.add(txtDni);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblTelefono.setBounds(48, 218, 96, 26);
		panel_1.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(190, 218, 168, 26);
		panel_1.add(txtTelefono);
		
		button = new JButton("GUARDAR CAMBIOS");
		button.addActionListener(this);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		button.setBounds(132, 298, 188, 41);
		panel_1.add(button);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCorreo.setBounds(48, 255, 96, 26);
		panel_1.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(190, 255, 168, 26);
		panel_1.add(txtCorreo);
		setUndecorated(true);
		setLocationRelativeTo(null);
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
		xMouse = arg0.getX();
		yMouse = arg0.getY();
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
		
		this.setLocation(x - xMouse, y - yMouse);
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		this.dispose();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			do_button_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		buscarDNI();
	}
	protected void do_button_actionPerformed(ActionEvent e) {
		actualizarCliente();
	}
	
	private void buscarDNI() {
		String dni;
		dni = getBuscar();
		ArrayList<Cliente> data = new GestionClienteDAO().listarClientexDNI(dni);

		if (data.size() == 0) {
			mensaje("Lista vacía");
		} 
		else {
			
			for (Cliente c : data) {
				txtNombre.setText(c.getNombre());
				txtApellido.setText(c.getApellido());
				txtDni.setText(c.getDni());
				txtTelefono.setText(c.getTelefono());
				txtCorreo.setText(c.getCorreo());
				txtCodigo.setText(c.getIdCliente()+"");
			}
		}
	}
	
	private String getNombre() {
		String usu = null;
		if(txtNombre.getText().trim().length() == 0) {
			//lblNom.setVisible(true);
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
			//lblApe.setVisible(true);
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
			//lblDn.setVisible(true);
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
			//lblTele.setVisible(true);
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
			//lblCorre.setVisible(true);
			txtCorreo.requestFocus();
		}
			
		else if(txtCorreo.getText().trim().matches(Validacion.CORREO) == false)
			mensaje("Formato incorrecto del Correo. Ejemplo Paul_Vega@Cibertec.edu.pe");
		else
			correo = txtCorreo.getText();		
	return correo;
	}
	
	private String getBuscar() {
		String dni = null;
		if(txtBuscar.getText().trim().length() == 0) {
			//lblDn.setVisible(true);
			mensaje("vacio");
			txtBuscar.requestFocus();
		}
			
		else if(txtBuscar.getText().trim().matches(Validacion.DNI) == false)
			mensaje("Formato incorrecto del DNI. Ingresar 8 números");
		else
			dni = txtBuscar.getText();
		
	return dni;

	}
	
	
	
	private void mensaje(String msj){
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 0);
	}
	
	private void mensaje1(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema" , 1);
		
	}
	
	void actualizarCliente(){
		String nomb,apell,dni,tlf,correo;
		int codigo;
		
		nomb = getNombre();
		apell = getApellido();
		dni = getDni();
		tlf = getTelefono();
		correo = getCorreo();
		codigo = getCodigo();
		
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
			c.setIdCliente(codigo);
			int ok = gc.actualizar(c);
			
			if(ok == 0)
				mensaje("Error en el registro");
			else {
				mensaje1("El registro se realizó satisfactoriamente");
				limpiar();
				txtBuscar.requestFocus();
			}
				
		}

	}
	
	private void limpiar() {
		txtBuscar.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtBuscar.requestFocus();
	}
	
	private int getCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
}
