package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.css.RGBColor;

import controlador.GestionUsuarioDAO;
import entidad.Usuario;
import utils.Validacion;


import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class frmLogin extends JFrame implements MouseListener, MouseMotionListener {

	private JPanel contentPane;
	private JPanel panel;
	int xmouse, ymouse; //globales para almacenar direccion x  e y
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblContrasea;
	private JSeparator separator_1;
	private JLabel lblUser;
	private JLabel lblContra;
	private JPanel pn_Entrar;
	private JLabel lblEntrar;
	private JPanel pn_Cerrar;
	private JLabel lblX;
	private JLabel lbl_Ver;
	private JLabel lbl_NoVer;
	private JLabel label;
	GestionUsuarioDAO gu=new GestionUsuarioDAO();
	public static Usuario u=new Usuario();
	private JTextField txtU;
	private JPasswordField txt_Contraseña;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 510, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("USUARIO:");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblNewLabel.setBounds(137, 179, 99, 31);
		lblNewLabel.setForeground(new Color(193, 18, 5));
		panel.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(137, 251, 238, 9);
		separator.setBackground(new Color(193, 18, 5));
		panel.add(separator);
		
		lblContrasea = new JLabel("CONTRASE\u00D1A:");
		lblContrasea.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblContrasea.setBounds(137, 271, 164, 31);
		lblContrasea.setForeground(new Color(193, 18, 5));
		panel.add(lblContrasea);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(137, 334, 238, 9);
		separator_1.setBackground(new Color(193, 18, 5));
		panel.add(separator_1);
		
		lblUser = new JLabel("");
		lblUser.setBounds(95, 221, 32, 31);
		//ajustar imagen a label
		ImageIcon iconUser = new ImageIcon(getClass().getResource("/img/user_32_px.png")); //DIRECCION DEL ICONO
		ImageIcon imgUser = new ImageIcon(iconUser.getImage().getScaledInstance(lblUser.getWidth(), lblUser.getHeight(), Image.SCALE_SMOOTH));
		lblUser.setIcon(imgUser);
		//FIN
		panel.add(lblUser);
		
		lblContra = new JLabel("");
		lblContra.setBounds(95, 302, 32, 31);
		//inicio
		ImageIcon iconContra = new ImageIcon(getClass().getResource("/img/contra_32_px.png")); //JALAR DIRECCION DE IMAGEN
		ImageIcon imgContra = new ImageIcon(iconContra.getImage().getScaledInstance(lblContra.getWidth(), lblContra.getHeight(), Image.SCALE_SMOOTH));//COORDENADAS DEL LABEL
		lblContra.setIcon(imgContra);
		//final
		panel.add(lblContra);
		
		pn_Entrar = new JPanel();
		pn_Entrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pn_Entrar.addMouseListener(this);
		pn_Entrar.setBounds(159, 354, 164, 38);
		pn_Entrar.setBackground(new Color(193, 18, 5 ));
		panel.add(pn_Entrar);
		pn_Entrar.setLayout(null);
		
		lblEntrar = new JLabel("ENTRAR");
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setBackground(Color.WHITE);
		lblEntrar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblEntrar.setBounds(44, 11, 80, 14);
		lblEntrar.setForeground(Color.WHITE);
		pn_Entrar.add(lblEntrar);
		
		pn_Cerrar = new JPanel();
		pn_Cerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pn_Cerrar.addMouseListener(this);
		pn_Cerrar.setBackground(Color.WHITE);
		pn_Cerrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		pn_Cerrar.setBackground(new Color(193,18,5));
		pn_Cerrar.setBounds(472, 0, 38, 38);
		panel.add(pn_Cerrar);
		pn_Cerrar.setLayout(null);
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(10, 11, 20, 20);
		pn_Cerrar.add(lblX);
		lblX.setFont(new Font("Yu Gothic Light", Font.PLAIN, 20));
		
		lbl_Ver = new JLabel("");
		lbl_Ver.addMouseListener(this);
		lbl_Ver.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ver.setIcon(new ImageIcon(frmLogin.class.getResource("/img/ver.png")));
		lbl_Ver.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		lbl_Ver.setBounds(375, 309, 38, 24);
		panel.add(lbl_Ver);
		
		lbl_NoVer = new JLabel("");
		lbl_NoVer.addMouseListener(this);
		lbl_NoVer.setIcon(new ImageIcon(frmLogin.class.getResource("/img/no_ver.png")));
		lbl_NoVer.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NoVer.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		lbl_NoVer.setVisible(false);
		lbl_NoVer.setBounds(375, 309, 38, 24);
		panel.add(lbl_NoVer);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(159, 19, 178, 149);
		ImageIcon icoLogLogin = new ImageIcon(getClass().getResource("/img/logoLogin.png"));
		ImageIcon imgLogLogin = new ImageIcon(icoLogLogin.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(imgLogLogin);
		panel.add(label);
		
		txtU = new JTextField();
		txtU.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtU.setBorder(null);
		txtU.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		txtU.setBounds(137, 220, 238, 31);
		panel.add(txtU);
		txtU.setColumns(10);
		
		txt_Contraseña = new JPasswordField();
		txt_Contraseña.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_Contraseña.setBorder(null);
		txt_Contraseña.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		txt_Contraseña.setBounds(137, 303, 238, 31);
		panel.add(txt_Contraseña);
		setUndecorated(true); //para quitar la barrera minimizar y cerrar 
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lbl_NoVer) {
			mouseClickedLbl_NoVer(arg0);
		}
		if (arg0.getSource() == lbl_Ver) {
			mouseClickedLbl_Ver(arg0);
		}
		if (arg0.getSource() == pn_Cerrar) {
			mouseClickedPnCerrar(arg0);
		}	
		if (arg0.getSource() == pn_Entrar) {
			mouseClickedPnEntrar(arg0);
		}
	}

	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == panel) {
			mousePressedPanel(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mousePressedPanel(MouseEvent arg0) {
		xmouse = arg0.getX(); //ALMACENA POSICION DE EJE X 
		ymouse = arg0.getY(); //ALMACENA POSICION DE EJE Y
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == panel) {
			mouseDraggedPanel(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedPanel(MouseEvent arg0) {
		int x = arg0.getXOnScreen(); //POSICION DEL EJE X EN PANTALLA
 		int y = arg0.getYOnScreen(); //POSICION DEL EJE Y EN PANTALLA
		
		this.setLocation(x - xmouse, y - ymouse);
	}
	protected void mouseClickedPnCerrar(MouseEvent arg0) {
		this.dispose();
	}
	protected void mouseClickedPnEntrar(MouseEvent arg0) {
		login(leerUsuario(),leerClave());
	}
	protected void mouseClickedLbl_Ver(MouseEvent arg0) {
		lbl_Ver.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR)); //cursor de mano al click
		lbl_Ver.setVisible(false); //se oculta la img ver
		lbl_NoVer.setVisible(true); // se muestra el img no ver
		txt_Contraseña.setEditable(true); //texto editable
		txt_Contraseña.setEchoChar((char)0); // se muestra texto
		txt_Contraseña.setFont(new Font("Yu Gothic", Font.PLAIN, 16)); //ajuste de fuente para texto 
		txt_Contraseña.setForeground(Color.BLACK); //ajuste de color
	}
	protected void mouseClickedLbl_NoVer(MouseEvent arg0) {
		lbl_NoVer.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		lbl_Ver.setVisible(true);
		lbl_NoVer.setVisible(false);
		txt_Contraseña.setEditable(true);
		txt_Contraseña.setEchoChar('*');
		txt_Contraseña.setForeground(Color.BLACK);
		txt_Contraseña.setFont(new Font("Yu Gothic", Font.PLAIN, 16));

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private void login(String usr, String psw){
		u = gu.login(usr, psw);
		if(u!=null){
			mensaje("¡ Bienvenido " + u.getNombre()+" !");
			frmPrincipalEmp pri = new frmPrincipalEmp();
			pri.setVisible(true);
			pri.setLocationRelativeTo(this);
			this.dispose();
			
		}else{
			mensaje("Datos invalidos");
		}
	}
	private void mensaje(String string) {
		JOptionPane.showMessageDialog(null, string);
		
	}

	private String leerUsuario(){
		String user=null;
		if(txtU.getText().trim().length()==0){
			alerta("Campo usuario vacio !");
		}else{
			user = txtU.getText().trim();
		}
		return user;
	}
	private String leerClave(){
		String clave=null;
		if(String.valueOf(txt_Contraseña.getPassword()).trim().length()==0){
			alerta("Campo clave vacio !");
		}else{
			clave=String.valueOf(txt_Contraseña.getPassword()).trim();
		}
		return clave;
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(null, s,"Alerta",2);
	}
}
