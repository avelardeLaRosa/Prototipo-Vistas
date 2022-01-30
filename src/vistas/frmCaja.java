package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.GestionCajaDAO;
import controlador.GestionCajaPruebaDAO;
import entidad.Caja;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class frmCaja extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse,yMouse;
	private JPanel panel_1;
	private JLabel lblEligaUnaOpcion;
	private JLabel lblCaja;
	private JLabel label;
	private JButton btnApertura;
	private JButton btnCierre;
	GestionCajaDAO gc = new GestionCajaDAO();
	GestionCajaPruebaDAO gcp=new GestionCajaPruebaDAO();
	
	public static Caja c=new Caja();;
	public static int cod_estado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmCaja dialog = new frmCaja();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmCaja() {
		setBounds(100, 100, 494, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(193, 18, 5));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 494, 210);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 474, 188);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblEligaUnaOpcion = new JLabel("Elija una opcion");
		lblEligaUnaOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligaUnaOpcion.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblEligaUnaOpcion.setBounds(122, 67, 246, 26);
		panel_1.add(lblEligaUnaOpcion);
		
		lblCaja = new JLabel("CAJA");
		lblCaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaja.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblCaja.setBounds(112, 11, 256, 26);
		panel_1.add(lblCaja);
		
		label = new JLabel("");
		label.addMouseListener(this);
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(432, 11, 32, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH));
		label.setIcon(new ImageIcon(frmCaja.class.getResource("/img/leftarrow_theapplication_izquierda_4435.png")));
		panel_1.add(label);
		
		btnApertura = new JButton("Apertura ");
		btnApertura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApertura.addActionListener(this);
		btnApertura.setIcon(new ImageIcon(frmCaja.class.getResource("/img/uparrow_arriba_1538.png")));
		btnApertura.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnApertura.setBounds(47, 113, 144, 43);
		panel_1.add(btnApertura);
		
		btnCierre = new JButton("Cierre");
		btnCierre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCierre.addActionListener(this);
		btnCierre.setIcon(new ImageIcon(frmCaja.class.getResource("/img/arrowdown_flech_1539.png")));
		btnCierre.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnCierre.setBounds(264, 113, 144, 43);
		panel_1.add(btnCierre);
		setUndecorated(true);
		setLocationRelativeTo(null);
		AperturayCierre();
		
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
		this.setLocation(x-xMouse, y-yMouse);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCierre) {
			actionPerformedBtnCierre(arg0);
		}
		if (arg0.getSource() == btnApertura) {
			actionPerformedBtnApertura(arg0);
		}
	}
	protected void actionPerformedBtnApertura(ActionEvent arg0) {
		
		frmCajaApertura aper=new frmCajaApertura();
		aper.setVisible(true);
		aper.setLocationRelativeTo(null);
		this.dispose();
		
		
	}
	protected void actionPerformedBtnCierre(ActionEvent arg0) {
		
		frmCajaCierre cierre=new frmCajaCierre();
		cierre.setVisible(true);
		cierre.setLocationRelativeTo(null);
		this.dispose();
	
		
		
	}
	protected void mouseClickedLabel(MouseEvent arg0) {
		frmPrincipalEmp pri=new frmPrincipalEmp();
		pri.setVisible(true);
		pri.setLocationRelativeTo(null);
		this.dispose();
	}
	
	private void AperturayCierre() {
		cod_estado = gc.ValidarCaja();
		
		if(cod_estado == 1) {
			btnCierre.setEnabled(false);
			btnApertura.setEnabled(true);
		}
		else{
			btnApertura.setEnabled(false);
			btnCierre.setEnabled(true);
		}
		

	}
}
