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
import entidad.Caja;
import entidad.Producto;
import entidad.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCajaApertura extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	int xMouse,yMouse;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label_1;
	private JLabel lblEntrada;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JLabel lblComentarios;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	GestionCajaDAO gc=new GestionCajaDAO();
	private JTextField txtInfo;
	private JButton btnIngresar;

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
		lblEntrada.setBounds(10, 68, 207, 26);
		panel_1.add(lblEntrada);
		
		lblCantidad = new JLabel("CANTIDAD:");
		lblCantidad.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblCantidad.setBounds(10, 105, 96, 29);
		panel_1.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(66, 145, 87, 26);
		panel_1.add(txtCantidad);
		
		lblComentarios = new JLabel("COMENTARIOS:");
		lblComentarios.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblComentarios.setBounds(10, 192, 168, 29);
		panel_1.add(lblComentarios);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(frmCajaApertura.class.getResource("/img/Accept256_25070.png")));
		btnGuardar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnGuardar.setBounds(306, 128, 141, 43);
		panel_1.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(frmCajaApertura.class.getResource("/img/delete_unapprove_discard_remove_x_red_icon-icons.com_55984.png")));
		btnCancelar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnCancelar.setBounds(306, 208, 141, 43);
		panel_1.add(btnCancelar);
		
		lblNewLabel = new JLabel("S/.");
		lblNewLabel.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 145, 46, 26);
		panel_1.add(lblNewLabel);
		
		txtInfo = new JTextField();
		txtInfo.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtInfo.setBounds(10, 232, 182, 26);
		panel_1.add(txtInfo);
		txtInfo.setColumns(10);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnIngresar.setBounds(306, 68, 141, 43);
		panel_1.add(btnIngresar);
		setUndecorated(true);
		setLocationRelativeTo(null);
		mostrarMontoApertura();
		habilitar(false);
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
		this.dispose();
	}
	private double leerCantidad(){
		double cantidad=0;
		try {
			if(txtCantidad.getText().trim().length()==0){
				alerta("Debe ingresar Cantidad de Apertura");
			}else{
				cantidad = Double.parseDouble(txtCantidad.getText().trim());
			}
		} catch (Exception e) {
			alerta("Formato incorrecto !!");
		}
		return cantidad;
	}

	private void alerta(String string) {
		JOptionPane.showMessageDialog(null,string,"ALERTA",2);
		
	}
	private void mostrarMontoApertura(){
		Caja c=gc.listarMonto();
		if(c==null){
			alerta("No se ingreso Monto!");
		}else{
			txtCantidad.setText(String.valueOf(c.getMonto()));
			txtInfo.setText(c.getComentario());
		}
	}
	private double leerMonto(){
		double monto=0;
		try{
		if(txtCantidad.getText().trim().length()==0){
			alerta("Debe ingresar Monto de apertura");
		}else{
			monto = Double.parseDouble(txtCantidad.getText().trim());
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
	private void modificarMonto(){
		double monto=leerCantidad();
		String comentario=leerComentario();
		
		if(monto==0||comentario==null){
			alerta("No se ingreso monto");
		}else{
			Caja c=new Caja();
			c.setMonto(monto);
			c.setComentario(comentario);
			int ok = gc.actualizarMonto(c);
			if(ok==0){
				alerta("Error al actualizar usuario !");
			}else{
				mensaje("Actualizacion Exitosa !");
				habilitar(false);
			}	
		}
	}
	private void mensaje(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		modificarMonto();
	}
	private void habilitar(boolean tof){
		txtCantidad.setEditable(tof);
		txtInfo.setEditable(tof);
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		habilitar(true);
		txtCantidad.requestFocus();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		this.dispose();
	}
}
