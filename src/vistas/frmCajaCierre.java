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

import controlador.GestionCajaDAO;
import controlador.GestionCajaEstadoDAO;
import controlador.GestionCajaPruebaDAO;
import entidad.CajaApertura;
import entidad.Caja;
import entidad.CajaCierre;
import entidad.CajaEstado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCajaCierre extends JDialog implements MouseListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JButton button;
	private JButton button_1;
	private JLabel label_3;
	private JLabel lblCierreDeCaja;
	GestionCajaDAO gc=new GestionCajaDAO();
	GestionCajaEstadoDAO gce=new GestionCajaEstadoDAO();
	GestionCajaPruebaDAO gcp=new GestionCajaPruebaDAO();
	private JLabel label;
	private JComboBox cboEstado;
	private JLabel label_1;
	private JComboBox cboNroCaja;
	private JLabel label_2;
	private JLabel label_4;
	private JTextField txtMonto;
	private JLabel label_5;
	private JTextField txtInfo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmCajaCierre dialog = new frmCajaCierre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmCajaCierre() {
		setBounds(0, 0, 477, 340);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193, 18, 5));
		panel.setBounds(0, 0, 477, 340);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 457, 340);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		button = new JButton("Guardar");
		button.addActionListener(this);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(frmCajaCierre.class.getResource("/img/Accept256_25070.png")));
		button.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		button.setBounds(306, 128, 141, 43);
		panel_1.add(button);
		
		button_1 = new JButton("Cancelar");
		button_1.addActionListener(this);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setIcon(new ImageIcon(frmCajaCierre.class.getResource("/img/delete_unapprove_discard_remove_x_red_icon-icons.com_55984.png")));
		button_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		button_1.setBounds(306, 208, 141, 43);
		panel_1.add(button_1);
		
		label_3 = new JLabel("");
		label_3.addMouseListener(this);
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(423, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgCerrar);
		panel_1.add(label_3);
		
		lblCierreDeCaja = new JLabel("CIERRE DE CAJA");
		lblCierreDeCaja.setHorizontalAlignment(SwingConstants.LEFT);
		lblCierreDeCaja.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblCierreDeCaja.setBounds(133, 11, 207, 26);
		panel_1.add(lblCierreDeCaja);
		
		label = new JLabel("Estado: ");
		label.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label.setBounds(10, 60, 124, 29);
		panel_1.add(label);
		
		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		cboEstado.setBounds(134, 62, 135, 26);
		panel_1.add(cboEstado);
		
		label_1 = new JLabel("Seleccione Caja:");
		label_1.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_1.setBounds(11, 100, 124, 29);
		panel_1.add(label_1);
		
		cboNroCaja = new JComboBox();
		cboNroCaja.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		cboNroCaja.setBounds(135, 102, 134, 26);
		panel_1.add(cboNroCaja);
		
		label_2 = new JLabel("Monto:");
		label_2.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_2.setBounds(11, 146, 96, 29);
		panel_1.add(label_2);
		
		label_4 = new JLabel("S/.");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		label_4.setBounds(11, 186, 46, 26);
		panel_1.add(label_4);
		
		txtMonto = new JTextField();
		txtMonto.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtMonto.setColumns(10);
		txtMonto.setBounds(67, 186, 87, 26);
		panel_1.add(txtMonto);
		
		label_5 = new JLabel("COMENTARIOS:");
		label_5.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		label_5.setBounds(11, 223, 168, 29);
		panel_1.add(label_5);
		
		txtInfo = new JTextField();
		txtInfo.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtInfo.setColumns(10);
		txtInfo.setBounds(11, 263, 182, 26);
		panel_1.add(txtInfo);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		cboEstadoCaja();
		cboNumeroCaja();
		cboEstado.setSelectedIndex(frmCaja.cod_estado);
		cboEstado.setEnabled(false);
		/* Cambiar color al JcomboBox*/
		UIManager.put( "ComboBox.disabledBackground", new Color(0,0,0,0) );
		UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
		
		
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == label_3) {
			mouseClickedLabel_3(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLabel_3(MouseEvent e) {
		frmCaja cj=new frmCaja();
		cj.setVisible(true);
		cj.setLocationRelativeTo(null);
		this.dispose();
	}
	private void alerta(String string) {
		JOptionPane.showMessageDialog(null,string,"ALERTA",2);
		
	}
	private void cboEstadoCaja(){
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
	/*private void IngresarMontoCierre(){
		double monto = leerMonto();
		int idUser = obtenerIdUsuario(), nroCaja = leerCboNroCaja(),cbo=leerCboEstado();
		String info = leerComentario();
		if(cbo==2){
			alerta("No se puede seleccionar el estado APERTURADO al cerrar una caja");
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
			cm.setIdCaja(nroCaja);
			int ok = gc.registarMontoApertura(cm);
			if(ok==0){
				alerta("Error al ingresar monto de cierre !");
			}else{
				mensaje("Caja Cerrada !");
				limpiarCampos(true);
				this.dispose();
				frmPrincipalEmp pri=new frmPrincipalEmp();
				pri.setVisible(true);
				pri.setLocationRelativeTo(null);
			}
		}
	}*/
	private void cierreCaja(){
		double monto = leerMonto();
		int idUser = obtenerIdUsuario(), nroCaja = leerCboNroCaja(),cbo=leerCboEstado();
		String info = leerComentario();
		/*if(cbo==2){
			alerta("No se puede seleccionar el estado APERTURADO al cerrar una caja");
			limpiarCampos(true);
			return;
		}
		else */if(monto==0||info==null||cbo==0){
			alerta("No se pudo ingresar monto");
		}else{
			Caja c=new Caja(nroCaja, 1, null);
			CajaCierre cc=new CajaCierre(monto, nroCaja, idUser, 1, null, info);
			int ok=gcp.cierreCaja(c, cc);
			if(ok==0)alerta("error al cerrar caja");
			else mensaje("Caja Cerrada");
			cboEstado.setSelectedIndex(frmCaja.cod_estado);
			this.dispose();
			frmPrincipalEmp pri=new frmPrincipalEmp();
			pri.setVisible(true);
			pri.setLocationRelativeTo(null);
		}
	}
	private void cboEstado(){
		ArrayList<CajaEstado>listar=gce.listarEstado();
		for (CajaEstado ce : listar) {
			cboEstado.addItem(ce.getDes_estado());
		}
	}
	private void limpiarCampos(Boolean tof){
		txtMonto.setText("");
		cboEstado.setSelectedIndex(0);
		txtMonto.requestFocus();
		txtInfo.setText("");
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button_1) {
			actionPerformedButton_1(arg0);
		}
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		cierreCaja();
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
		frmPrincipalEmp cp= new frmPrincipalEmp();
		cp.setVisible(true);
		cp.setLocationRelativeTo(null);
		this.dispose();
	}
}
