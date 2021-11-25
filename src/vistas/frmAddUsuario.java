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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import controlador.GestionUsuarioDAO;
import entidad.Usuario;
import utils.Validacion;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class frmAddUsuario extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNuevoUsuario;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblUsuario;
	private JLabel lblClave;
	private JLabel lblFechaRegistro;
	private JButton button;
	private JTextField txtUsuario;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JLabel label_7;
	int xMouse,yMouse;
	private JPasswordField pswClave;
	GestionUsuarioDAO gu=new GestionUsuarioDAO();
	private JComboBox cboTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmAddUsuario dialog = new frmAddUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmAddUsuario() {
		setBounds(0, 0, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193,18,5));
		panel.setBounds(0, 0, 450, 350);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.addMouseMotionListener(this);
		panel_1.addMouseListener(this);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNuevoUsuario = new JLabel("NUEVO USUARIO");
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblNuevoUsuario.setBounds(129, 23, 191, 26);
		panel_1.add(lblNuevoUsuario);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCodigo.setBounds(26, 75, 96, 26);
		panel_1.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNombre.setBounds(26, 112, 96, 29);
		panel_1.add(lblNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblApellido.setBounds(26, 152, 96, 27);
		panel_1.add(lblApellido);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblUsuario.setBounds(26, 190, 96, 24);
		panel_1.add(lblUsuario);
		
		lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblClave.setBounds(26, 225, 96, 26);
		panel_1.add(lblClave);
		
		lblFechaRegistro = new JLabel("Tipo:");
		lblFechaRegistro.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblFechaRegistro.setBounds(26, 262, 118, 26);
		panel_1.add(lblFechaRegistro);
		
		button = new JButton("GUARDAR");
		button.addActionListener(this);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(frmAddUsuario.class.getResource("/img/Accept256_25070.png")));
		button.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		button.setBounds(129, 304, 158, 35);
		panel_1.add(button);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(190, 190, 168, 26);
		panel_1.add(txtUsuario);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtApellido.setColumns(10);
		txtApellido.setBounds(190, 152, 168, 26);
		panel_1.add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(190, 112, 168, 26);
		panel_1.add(txtNombre);
		
		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setForeground(Color.DARK_GRAY);
		txtCodigo.setText("AUTOGENERADO");
		txtCodigo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(190, 75, 168, 26);
		panel_1.add(txtCodigo);
		
		label_7 = new JLabel("");
		label_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_7.addMouseListener(this);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), Image.SCALE_SMOOTH));
		label_7.setIcon(imgCerrar);
		panel_1.add(label_7);
		
		pswClave = new JPasswordField();
		pswClave.setBounds(190, 225, 168, 26);
		panel_1.add(pswClave);
		
		cboTipo = new JComboBox();
		cboTipo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Tipo", "Administrador", "Cajero"}));
		cboTipo.setBounds(190, 267, 158, 21);
		panel_1.add(cboTipo);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_7) {
			mouseClickedLabel_7(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
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
	protected void mouseClickedLabel_7(MouseEvent arg0) {
		this.dispose();
	}
	protected void mousePressedPanel_1(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == panel_1) {
			mouseDraggedPanel_1(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedPanel_1(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
	String leerNombre(){
		String nombre=null;
		if(txtNombre.getText().trim().length()==0){
			alerta("Campo Nombre Vacio");}
		else if(txtNombre.getText().trim().matches(Validacion.nomApell)==false){
			alerta("El nombre debe tener de 3 - 25 carateres !");
		}else{
			nombre = txtNombre.getText().trim();
		}
		return nombre;
	}
	String leerApellido(){
		String apellido=null;
		if(txtApellido.getText().trim().length()==0){
			alerta("Campo Apellido Vacio");
		}else if(txtApellido.getText().trim().matches(Validacion.nomApell)==false){
			alerta("El apellido debe tener de 3 - 25 caracteres !");
		}else{
			apellido = txtApellido.getText().trim();
		}
		return apellido;
	}
	String leerUsuario(){
		String usuario=null;
		if(txtUsuario.getText().trim().length()==0){
			alerta("Campo Usuario Vacio");
		}else{
			usuario=txtUsuario.getText().trim();
		}
		return usuario;
	}
	String leerClave(){
		String clave=null;
		if(String.valueOf(pswClave.getPassword()).trim().length()==0){
			alerta("Campo Contraseña Vacio");
		}else if(String.valueOf(pswClave.getPassword()).trim().matches(Validacion.psw)==false){
			alerta("Formato Incorrecto ejm.: A12345");
		}else{
			clave = String.valueOf(pswClave.getPassword());
		}
		return clave;
	}
	int leerTipo(){
		int tipo=0;
		if(cboTipo.getSelectedIndex()==0){
			alerta("Selecicone Tipo de usuario!");
		}else{
			tipo = cboTipo.getSelectedIndex();
		}
		return tipo;
	}
	
	void alerta(String s){
		JOptionPane.showMessageDialog(null,s,"ALERTA",1);
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		/*REGISTRAR*/
		registrarUsuario();
		limpiarCampos();
	}
	void registrarUsuario(){
		String nom = leerNombre(),apell = leerApellido(),user = leerUsuario(),psw = leerClave();
		int tip = leerTipo();
		if(nom==null||apell==null||user==null||psw==null||tip==0){
			alerta("No se registraron los datos");
		}else{
			Usuario u=new Usuario();
			u.setNombre(nom);
			u.setApellido(apell);
			u.setUsuario(user);
			u.setClave(psw);
			u.setIdtipo(tip);
			int ok = gu.registrar(u);
			if(ok==0){
				alerta("Error en el registro");
			}else{
				mensaje("Registro Exitoso");
			}
		}
		
	}
	void limpiarCampos(){
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		pswClave.setText("");
		//
		txtNombre.requestFocus();
	}
}
