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
import javax.swing.table.DefaultTableModel;

import controlador.GestionProductoDAO;
import entidad.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmEliminarProduct extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	int xMouse, yMouse;
	private JPanel panel_1;
	private JLabel lblIngreseCodigoO;
	private JLabel label_1;
	private JLabel label;
	private JScrollPane scrollPane;
	private JTable tblInventario;
	private JButton btnAceptar;
	private JLabel label_2;
	private JTextField txtCodigo;
	private JLabel label_3;
	DefaultTableModel model=new DefaultTableModel();
	GestionProductoDAO gp=new GestionProductoDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmEliminarProduct dialog = new frmEliminarProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmEliminarProduct() {
		setBounds(0,0,450,350);
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
		
		lblIngreseCodigoO = new JLabel("Ingrese Codigo o Seleccione Producto");
		lblIngreseCodigoO.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseCodigoO.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblIngreseCodigoO.setBounds(34, 25, 352, 26);
		panel_1.add(lblIngreseCodigoO);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH));
		label_1.setIcon(new ImageIcon(frmEliminarProduct.class.getResource("/img/cerrarVnt.png")));
		panel_1.add(label_1);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		label.setBounds(163, 50, 92, 71);
		ImageIcon icoCod=new ImageIcon(getClass().getResource("/img/barcode_icon-icons.com_73665.png"));
		ImageIcon imgCod=new ImageIcon(icoCod.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(imgCod);
		panel_1.add(label);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(10, 165, 410, 137);
		panel_1.add(scrollPane);
		
		tblInventario = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		tblInventario.addMouseListener(this);
		model.addColumn("ID Producto");
		model.addColumn("Nombre");
		model.addColumn("Stock");
		model.addColumn("Precio");
		model.addColumn("Categoria");
		model.addColumn("Proveedor");
		tblInventario.setModel(model);
		tblInventario.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setViewportView(tblInventario);
		
		btnAceptar = new JButton("ELIMINAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnAceptar.setBounds(125, 313, 172, 26);
		panel_1.add(btnAceptar);
		
		label_2 = new JLabel("BUSCAR POR CODIGO");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		label_2.setBounds(10, 132, 172, 22);
		panel_1.add(label_2);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(192, 132, 188, 22);
		panel_1.add(txtCodigo);
		
		label_3 = new JLabel("");
		label_3.addMouseListener(this);
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setBounds(390, 132, 30, 22);
		ImageIcon icoBus=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBus=new ImageIcon(icoBus.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgBus);
		panel_1.add(label_3);
		setUndecorated(true);
		setLocationRelativeTo(null);
		listarProductos();
		
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblInventario) {
			mouseClickedTblInventario(e);
		}
		if (e.getSource() == label_3) {
			mouseClickedLabel_3(e);
		}
		if (e.getSource() == label_1) {
			mouseClickedLabel_1(e);
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
		
		this.setLocation(x - xMouse, y - yMouse);
	}
	protected void mouseClickedLabel_1(MouseEvent e) {
		this.dispose();
	}
	private void listarProductos(){
		ArrayList<Producto>listar=gp.listarProductos();
		model.setRowCount(0);
		if(listar.size()==0){
			alerta("Lista Vacia");
		}else{
			for(Producto p:listar){
				Object[]fila={
						p.getIdProducto(),
						p.getNombre(),
						p.getCantidad(),
						"s/. " + p.getPrecio(),
						p.getDes_categoria(),
						p.getDes_proveedor()
				};
				model.addRow(fila);
			}
		}
	}
	void listarXIdProducto(int id){
		model.setRowCount(0);
		ArrayList<Producto>listar = gp.listarXIdPro(id);
		if(listar.size()==0){
			alerta("Producto no Existe");
			listarProductos();
			txtCodigo.setText("");
		}else{
			for(Producto p: listar){
			Object[] fila={
					p.getIdProducto(),
					p.getNombre(),
					p.getCantidad(),
					"s/. " + p.getPrecio(),
					p.getDes_categoria(),
					p.getDes_proveedor()
			};
			model.addRow(fila);
		}
			}
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(null, s,"ALERTA",2);
	}
	private int leerCodigo(){
		int id=0;
		try{
		if(txtCodigo.getText().trim().length()==0){
			alerta("Campo Codigo Vacio");}
		else{
			id = Integer.parseInt(txtCodigo.getText().trim());
		}
		}catch(NumberFormatException e){
			alerta("Solo se aceptan numeros");
		}
		return id;
	}
	private void mensaje(String s){
		JOptionPane.showMessageDialog(null,s);
	}
	private void eliminarProducto(int xid){
		int boton,id;
		id = leerCodigo();
		boton = JOptionPane.showConfirmDialog(null,"¿Seguro de eliminar PRODUCTO?","SISTEMA",JOptionPane.YES_NO_OPTION);
		if(boton==0){
			int ok = gp.eliminar(xid);
			if(ok==0){
				alerta("Error al eliminar PRODUCTO");
			}else{
				mensaje("Se elimino Producto");
				listarProductos();
			}		
		}
	}
	protected void mouseClickedLabel_3(MouseEvent e) {
		listarXIdProducto(leerCodigo());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		eliminarProducto(leerCodigo());
	}
	private void mostrarCodigo(int pos){
		String id;
		id = tblInventario.getValueAt(pos,0).toString();
		txtCodigo.setText(id);
	}
	protected void mouseClickedTblInventario(MouseEvent e) {
		int pos=tblInventario.getSelectedRow();
		mostrarCodigo(pos);
	}
}
