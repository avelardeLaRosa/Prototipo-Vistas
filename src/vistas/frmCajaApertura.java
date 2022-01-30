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

import controlador.GestionCajaDAO;
import controlador.GestionCajaEstadoDAO;
import controlador.GestionCajaPruebaDAO;
import entidad.Caja;
import entidad.CajaEstado;
import entidad.CajaApertura;
import entidad.DetalleVenta;
import entidad.Producto;
import entidad.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class frmCajaApertura extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	int xMouse,yMouse;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label_1;
	private JLabel lblEntrada;
	private JLabel lblMonto;
	private JTextField txtMonto;
	private JLabel lblComentarios;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	GestionCajaDAO gc=new GestionCajaDAO();
	GestionCajaPruebaDAO gcp=new GestionCajaPruebaDAO();
	private JTextField txtInfo;
	private JLabel lblSelecCaja;
	GestionCajaEstadoDAO gce=new GestionCajaEstadoDAO();
	private JComboBox cboNroCaja;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmCajaApertura dialog = new frmCajaApertura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmCajaApertura() {
		setBounds(100, 100, 477, 340);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193, 18, 5));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		panel.setBounds(0, 0, 477, 340);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 457, 340);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(this);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(423, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight() ,Image.SCALE_SMOOTH));
		label_1.setIcon(imgCerrar);
		panel_1.add(label_1);
		
		lblEntrada = new JLabel("APERTURA DE CAJA");
		lblEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		lblEntrada.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblEntrada.setBounds(133, 23, 207, 26);
		panel_1.add(lblEntrada);
		
		lblMonto = new JLabel("Monto:");
		lblMonto.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblMonto.setBounds(10, 146, 96, 29);
		panel_1.add(lblMonto);
		
		txtMonto = new JTextField();
		txtMonto.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtMonto.setColumns(10);
		txtMonto.setBounds(66, 186, 87, 26);
		panel_1.add(txtMonto);
		
		lblComentarios = new JLabel("COMENTARIOS:");
		lblComentarios.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblComentarios.setBounds(10, 223, 168, 29);
		panel_1.add(lblComentarios);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(frmCajaApertura.class.getResource("/img/Accept256_25070.png")));
		btnGuardar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnGuardar.setBounds(306, 105, 141, 43);
		panel_1.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(frmCajaApertura.class.getResource("/img/delete_unapprove_discard_remove_x_red_icon-icons.com_55984.png")));
		btnCancelar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnCancelar.setBounds(306, 185, 141, 43);
		panel_1.add(btnCancelar);
		
		lblNewLabel = new JLabel("S/.");
		lblNewLabel.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 186, 46, 26);
		panel_1.add(lblNewLabel);
		
		txtInfo = new JTextField();
		txtInfo.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtInfo.setBounds(10, 263, 182, 26);
		panel_1.add(txtInfo);
		txtInfo.setColumns(10);
		
		lblSelecCaja = new JLabel("Seleccione Caja:");
		lblSelecCaja.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblSelecCaja.setBounds(10, 100, 124, 29);
		panel_1.add(lblSelecCaja);
		
		cboNroCaja = new JComboBox();
		cboNroCaja.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		cboNroCaja.setBounds(134, 102, 134, 26);
		panel_1.add(cboNroCaja);
		
		lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblEstado.setBounds(9, 60, 124, 29);
		panel_1.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		cboEstado.setBounds(133, 62, 135, 26);
		panel_1.add(cboEstado);
		setUndecorated(true);
		setLocationRelativeTo(null);
		cboEstado();
		cboNumeroCaja();
		cboEstado.setSelectedIndex(frmCaja.cod_estado);
		cboEstado.setEnabled(false);
		/* Cambiar color al JcomboBox*/
		UIManager.put( "ComboBox.disabledBackground", new Color(0,0,0,0) );
		UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
		
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
		this.setLocation(x-xMouse,y-yMouse);
	}
	
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		frmCaja cj=new frmCaja();
		cj.setVisible(true);
		cj.setLocationRelativeTo(null);
		this.dispose();
	}
	private void alerta(String string) {
		JOptionPane.showMessageDialog(null,string,"ALERTA",2);
		
	}
	
	private double leerMonto(){
		double monto=0;
		try{
		if(txtMonto.getText().trim().length()==0){
			alerta("Debe ingresar Monto de apertura");
		}else{
			monto = Double.parseDouble(txtMonto.getText().trim());
		}}catch(NumberFormatException e){
			alerta("Formato incorrecto");
		}
		return monto;
	}
	private String leerComentario(){
		String coment=null;
		if(txtInfo.getText().trim().length()==0){
			alerta("Debe ingresarse un comentario");
		}else{
			coment = txtInfo.getText().trim();
		}
		return coment;
	}
	private int leerCboEstado(){
		int cbo=0;
		if(cboEstado.getSelectedIndex()==0){
			alerta("Seleccione estado");
		}else{
			cbo = cboEstado.getSelectedIndex();
		}
		return cbo;
	}
	private int leerCboNroCaja(){
		int cbo=0;
		if(cboNroCaja.getSelectedIndex()==0){
			alerta("Seleccione Nro. de caja");
		}else{
			cbo = cboNroCaja.getSelectedIndex();
		}
		return cbo;
	}
	private int obtenerIdUsuario(){
		return frmLogin.u.getIdUsuario();
	}
	
	private void mensaje(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		/*IngresarMontoApertura();*/
		aperturaCaja();
		
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		frmPrincipalEmp cp= new frmPrincipalEmp();
		cp.setVisible(true);
		cp.setLocationRelativeTo(null);
		this.dispose();
	}
	private void aperturaCaja(){
		double monto = leerMonto();
		int idUser = obtenerIdUsuario(),cbo=leerCboEstado(),cboCaja=leerCboNroCaja();
		String info = leerComentario();
		/*if(cbo==1){
			alerta("No se puede seleccionar el estado CERRADO al aperturar una caja");
			limpiarCampos(true);
			return;
		}else */if(monto==0||info==null||cbo==0){
			alerta("No se pudo ingresar monto");
		}else{
			Caja c=new Caja(cboCaja, 2, null);
			CajaApertura cm=new CajaApertura(monto, cboCaja, idUser, 2, null, info);
			int ok=gcp.aperturaCaja(c, cm);
			if(ok==0)alerta("error en apertura de caja");
			else mensaje("Caja Aperturada");
			this.dispose();
			frmPrincipalEmp pri=new frmPrincipalEmp();
			pri.setVisible(true);
			pri.setLocationRelativeTo(null);
		}
	}
	/*private void IngresarMontoApertura(){
		double monto = leerMonto();
		int idUser = obtenerIdUsuario(),cbo=leerCboEstado(),cboCaja=leerCboNroCaja();
		String info = leerComentario();
		if(cbo==1){
			alerta("No se puede seleccionar el estado CERRADO al aperturar una caja");
			limpiarCampos(true);
			return;
		}
		else if(monto==0||info==null||cbo==0){
			alerta("No se pudo ingresar monto");
		}else{
			CajaMonto cm=new CajaMonto();
			cm.setMonto(monto);
			cm.setComentario(info);
			cm.setIdUsuario(idUser);
			cm.setCod_estado(cbo);
			cm.setIdCaja(cboCaja);
			int ok = gc.registarMontoApertura(cm);
			if(ok==0){
				alerta("Error al ingresar monto de apertura !");
			}else{
				mensaje("Caja Aperturada !");
				limpiarCampos(true);
				this.dispose();
				frmPrincipalEmp pri=new frmPrincipalEmp();
				pri.setVisible(true);
				pri.setLocationRelativeTo(null);
			}
		}
	}*/
	private void cboEstado(){
		cboEstado.addItem("Elegir");
		ArrayList<CajaEstado>listar=gce.listarEstado();
		for (CajaEstado ce : listar) {
			cboEstado.addItem(ce.getDes_estado());
		}
	}
	public void cboNumeroCaja(){
		cboNroCaja.addItem("Elegir Caja");
		ArrayList<Caja>listar=gcp.listar();
		for (Caja c : listar) {
			cboNroCaja.addItem(c.getIdCaja());
		}
	}
	private void limpiarCampos(Boolean tof){
		txtMonto.setText("");
		cboNroCaja.setSelectedIndex(0);
		txtMonto.requestFocus();
		txtInfo.setText("");
		
	}
}
