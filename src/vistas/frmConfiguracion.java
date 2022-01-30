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
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmConfiguracion extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel_1;
	int xMouse,yMouse;
	private JLabel label;
	private JButton btnCerrarSesion;
	private JButton btnUsuarios;
	private JButton btnContacto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmConfiguracion dialog = new frmConfiguracion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmConfiguracion() {
		setBounds(100, 100, 361, 294);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(new Color(193, 18, 5));
			panel.setBounds(0, 0, 361, 294);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				panel_1 = new JPanel();
				panel_1.addMouseMotionListener(this);
				panel_1.addMouseListener(this);
				panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_1.setBounds(10, 0, 341, 294);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					btnCerrarSesion = new JButton("Cerrar Sesion");
					btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnCerrarSesion.addActionListener(this);
					btnCerrarSesion.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
					btnCerrarSesion.setIcon(new ImageIcon(frmConfiguracion.class.getResource("/img/logOut.png")));
					btnCerrarSesion.setBounds(0, 198, 341, 44);
					panel_1.add(btnCerrarSesion);
				}
				{
					btnContacto = new JButton("Contactos");
					btnContacto.addActionListener(this);
					btnContacto.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
					btnContacto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnContacto.setIcon(new ImageIcon(frmConfiguracion.class.getResource("/img/live_contacts_15412.png")));
					btnContacto.setBounds(0, 143, 341, 44);
					panel_1.add(btnContacto);
				}
				{
					btnUsuarios = new JButton("Usuarios");
					btnUsuarios.addMouseListener(this);
					btnUsuarios.addActionListener(this);
					btnUsuarios.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
					btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnUsuarios.setIcon(new ImageIcon(frmConfiguracion.class.getResource("/img/user_32_px.png")));
					btnUsuarios.setBounds(0, 88, 341, 44);
					panel_1.add(btnUsuarios);
				}
				{
					JLabel lblConfiguracion = new JLabel("CONFIGURACION");
					lblConfiguracion.setHorizontalAlignment(SwingConstants.LEFT);
					lblConfiguracion.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
					lblConfiguracion.setBounds(10, 28, 207, 26);
					panel_1.add(lblConfiguracion);
				}
				{
					label = new JLabel("");
					label.addMouseListener(this);
					label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setBounds(307, 11, 24, 26);
					ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
					ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
					label.setIcon(imgCerrar);
					panel_1.add(label);
				}
			}
		}
		permisos();
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == btnUsuarios) {
			mouseClickedBtnUsuarios(arg0);
		}
		if (arg0.getSource() == label) {
			mouseClickedLabel(arg0);
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
	protected void mousePressedPanel_1(MouseEvent arg0) {
		xMouse=arg0.getX();
		yMouse=arg0.getY();
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
		this.setLocation(x - xMouse, y-yMouse);
	}
	protected void mouseClickedLabel(MouseEvent arg0) {
		frmPrincipalEmp pri=new frmPrincipalEmp();
		pri.setVisible(true);
		pri.setLocationRelativeTo(null);
		this.dispose();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnContacto) {
			do_btnContacto_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnUsuarios) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnCerrarSesion) {
			actionPerformedBtnCerrarSesion(arg0);
		}
	}
	protected void actionPerformedBtnCerrarSesion(ActionEvent arg0) {
		cerrarSesion();
	}
	int cerrarSesion(){
		int n = JOptionPane.showConfirmDialog(null,"¿Desea Cerrar Sesión?","Cerrar Sesión",JOptionPane.YES_NO_OPTION);
		if(n==0){
			frmLogin log=new frmLogin();
			log.setVisible(true);
			log.setLocationRelativeTo(null);
			this.dispose();
		}
		return n;
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		frmUsuarios user=new frmUsuarios();
		user.setVisible(true);
		user.setLocationRelativeTo(null);
		this.dispose();
	}
	private void mensaje(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(null, s,"ERROR",0);
	}
	private void permisos(){
		switch (frmLogin.u.getIdtipo()) {
		case 2: btnUsuarios.setEnabled(false);
			break;
		default:
			break;
		}
	}
	protected void do_btnContacto_actionPerformed(ActionEvent arg0) {
		DlgContactos dc = new DlgContactos();
		dc.setVisible(true);
		dc.setLocationRelativeTo(this);
	}
	protected void mouseClickedBtnUsuarios(MouseEvent arg0) {
		alerta("No Cuenta con los permisos");
	}
}
