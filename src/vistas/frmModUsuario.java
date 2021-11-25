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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmModUsuario extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse,yMouse;
	private JPanel panel_1;
	private JLabel lblModificaUsuario;
	private JPanel panel_2;
	private JLabel lblCodigoDeUsuario;
	private JTextField txtCodigo;
	private JLabel label_2;
	private JLabel label_3;
	private JButton button;
	private JLabel label;
	private JTextField txtNombre;
	private JLabel label_1;
	private JTextField txtApellido;
	private JLabel label_4;
	private JTextField txtUsuario;
	private JLabel label_5;
	private JTextField txtClave;
	private JLabel label_6;
	private JDateChooser dcFecha;
	GestionUsuarioDAO gu=new GestionUsuarioDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmModUsuario dialog = new frmModUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmModUsuario() {
		setBounds(0, 0, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193,18,5));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 450, 350);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblModificaUsuario = new JLabel("MODIFICA USUARIO");
		lblModificaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblModificaUsuario.setBounds(111, 11, 221, 26);
		panel_1.add(lblModificaUsuario);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 46, 410, 51);
		panel_1.add(panel_2);
		
		lblCodigoDeUsuario = new JLabel("Codigo de Usuario:");
		lblCodigoDeUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCodigoDeUsuario.setBounds(10, 11, 162, 26);
		panel_2.add(lblCodigoDeUsuario);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(179, 12, 168, 26);
		panel_2.add(txtCodigo);
		
		label_2 = new JLabel("");
		label_2.addMouseListener(this);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setBounds(357, 11, 31, 29);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_SMOOTH));
		label_2.setIcon(imgBuscar);
		panel_2.add(label_2);
		
		label_3 = new JLabel("");
		label_3.addMouseListener(this);
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgCerrar);
		panel_1.add(label_3);
		
		button = new JButton("GUARDAR CAMBIOS");
		button.addActionListener(this);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		button.setBounds(132, 298, 188, 41);
		panel_1.add(button);
		
		label = new JLabel("Nombre:");
		label.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label.setBounds(20, 108, 96, 29);
		panel_1.add(label);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(184, 108, 168, 26);
		panel_1.add(txtNombre);
		
		label_1 = new JLabel("Apellido:");
		label_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_1.setBounds(20, 148, 96, 27);
		panel_1.add(label_1);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtApellido.setColumns(10);
		txtApellido.setBounds(184, 148, 168, 26);
		panel_1.add(txtApellido);
		
		label_4 = new JLabel("Usuario:");
		label_4.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_4.setBounds(20, 186, 96, 24);
		panel_1.add(label_4);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(184, 186, 168, 26);
		panel_1.add(txtUsuario);
		
		label_5 = new JLabel("Clave:");
		label_5.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_5.setBounds(20, 221, 96, 26);
		panel_1.add(label_5);
		
		txtClave = new JTextField();
		txtClave.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtClave.setColumns(10);
		txtClave.setBounds(184, 221, 168, 26);
		panel_1.add(txtClave);
		
		label_6 = new JLabel("Fecha Registro:");
		label_6.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_6.setBounds(20, 258, 118, 26);
		panel_1.add(label_6);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(184, 258, 166, 26);
		panel_1.add(dcFecha);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == label_2) {
			mouseClickedLabel_2(e);
		}
		if (e.getSource() == label_3) {
			mouseClickedLabel_3(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == panel) {
			mousePressedPanel(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mousePressedPanel(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
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
	protected void mouseClickedLabel_3(MouseEvent e) {
		this.dispose();
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(null,s,"Alerta",2);
	}
	private void mensaje(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	private int leerId(){
		int id=0;
		try {
			if(txtCodigo.getText().trim().length()==0){
				alerta("Campo Codigo Vacio");
			}else{
				id = Integer.parseInt(txtCodigo.getText().trim());
			}
			
		} catch (NumberFormatException e) {
			alerta("Solo se aceptan numeros !");
		}
		
		return id;
	}
	private String leerNombre(){
		String nom=null;
		if(txtNombre.getText().trim().length()==0){
			alerta("Campo Nombre Vacio");
		}else if(txtNombre.getText().trim().matches(Validacion.nomApell)==false){
			alerta("El nombre debe tener de 3 - 25 caracteres !");
		}else{
			nom = txtNombre.getText().trim();
		}
		return nom;
	}
	private String leerApellido(){
		String apellido=null;
		if(txtApellido.getText().trim().length()==0){
			alerta("Campo Nombre Vacio");
		}else if(txtApellido.getText().trim().matches(Validacion.nomApell)==false){
			alerta("El apellido debe tener de 3 - 25 caracteres !");
		}else{
			apellido = txtApellido.getText().trim();
		}
		return apellido;
	}
	private String leerUsuario(){
		String usuario=null;
		if(txtApellido.getText().trim().length()==0){
			alerta("Campo Usuario Vacio");
		}else{
			usuario = txtUsuario.getText().trim();
		}
		return usuario;
	}
	private String leerContraseña(){
		String contraseña = null;
		if(txtClave.getText().trim().length()==0){
			alerta("Campo Clave Vacio");
		}else if(txtClave.getText().trim().matches(Validacion.psw)){
			alerta("Formato incorrecto, ejemplo: Aa12345");
		}else{
			contraseña = txtClave.getText().trim();
		}
		
		return contraseña;
	}
	private String leerFecha(){
		String fecha=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			fecha = sdf.format(dcFecha.getDate());
		} catch (NullPointerException e) {
			alerta("Campo fecha vacio");
		}
		return fecha;
	}
	private void listarCampos(int id){
		ArrayList<Usuario>listarId=gu.listarXId(id);
		if(listarId.size()==0){
			alerta("Usuario no existe !");
		}else{
		for(Usuario u: listarId){
			txtCodigo.setText(String.valueOf(u.getIdUsuario()));
			txtCodigo.setEditable(false);
			txtNombre.requestFocus();
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
			txtUsuario.setText(u.getUsuario());
			txtClave.setText(u.getClave());
			try {
				dcFecha.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(u.getFecha_registro()));
			} catch (ParseException e) {
				e.getMessage();
			}
		}
		}
	}
	private void modificarUsuario(){
		int id = leerId();
		String nom = leerNombre(),
			   apell=leerApellido(),
			   user=leerUsuario(),
			   psw=leerContraseña(),
			   fecha=leerFecha();
		
		if(id==0||nom==null||apell==null||user==null||psw==null||fecha==null){
			alerta("No se actualizo usuario !");
		}else{
			Usuario u=new Usuario();
			u.setIdUsuario(id);
			u.setNombre(nom);
			u.setApellido(apell);
			u.setUsuario(user);
			u.setClave(psw);
			u.setFecha_registro(fecha);	
			int ok = gu.modificar(u);
			if(ok==0){
				alerta("Error al actualizar usuario !");
			}else{
				mensaje("Actualizacion Exitosa !");
			}	
		}
	}
	
	protected void mouseClickedLabel_2(MouseEvent e) {
		listarCampos(leerId());
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		modificarUsuario();
		limpiarCampos();
		
	}

	private void limpiarCampos() {
		txtCodigo.setText("");
		txtCodigo.setEditable(true);
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		dcFecha.setDate(null);
	}
}
