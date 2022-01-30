package vistas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import controlador.GestionProductoDAO;
import entidad.Producto;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgProducto extends JDialog implements ActionListener, KeyListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscarPro;
	private JTable tblProducto;
	DefaultTableModel model=new DefaultTableModel();
	GestionProductoDAO gp=new GestionProductoDAO();
	private JButton okButton;
	private JButton cancelButton;
	TableRowSorter<DefaultTableModel> sorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		setBounds(100, 100, 450, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProducto = new JLabel("Buscar Producto");
			lblProducto.setFont(new Font("Roboto Light", Font.PLAIN, 16));
			lblProducto.setBounds(10, 11, 129, 29);
			contentPanel.add(lblProducto);
		}
		{
			txtBuscarPro = new JTextField();
			txtBuscarPro.addKeyListener(this);
			txtBuscarPro.setFont(new Font("Roboto Light", Font.PLAIN, 16));
			txtBuscarPro.setColumns(10);
			txtBuscarPro.setBounds(138, 12, 168, 26);
			contentPanel.add(txtBuscarPro);
		}
		{
			ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 52, 414, 206);
			contentPanel.add(scrollPane);
			{
				tblProducto = new JTable(){
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int rowIndex,int columnIndex){
						return false;}
				};
				tblProducto.addMouseListener(this);
				model.addColumn("Codigo");
				model.addColumn("Producto");
				model.addColumn("Precio");
				model.addColumn("Stock");
				tblProducto.setModel(model);
				tblProducto.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblProducto);
				//FILTRAR JTABLE
				tblProducto.setAutoCreateRowSorter(true);
				sorter = new TableRowSorter<>(model);
				tblProducto.setRowSorter(sorter);
				//
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setIcon(new ImageIcon(DlgProducto.class.getResource("/img/check_40622.png")));
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.addActionListener(this);
				cancelButton.setIcon(new ImageIcon(DlgProducto.class.getResource("/img/delete_unapprove_discard_remove_x_red_icon-icons.com_55984.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			ajustarAnchoColumnas();
		}
		listarProdutos();
	}
	private void listarProdutos(){
		ArrayList<Producto>listaPro=gp.listarProductos();
		for (Producto p : listaPro) {
			Object [] fila={
					p.getIdProducto(),
					p.getNombre(),
					p.getPrecio(),
					p.getCantidad()
			};
			model.addRow(fila);
		}
	}
	private void buscarXNombreProducto(String nomPro){
		model.setRowCount(0);
		ArrayList<Producto>listarNomPro=gp.listarXNombrePro(nomPro);
		if(listarNomPro.size()==0){
			alerta("Producto no existe !");
		}else{
			for (Producto p : listarNomPro) {
				Object [] fila={
						p.getIdProducto(),
						p.getNombre(),
						p.getPrecio(),
						p.getCantidad()
				};
				model.addRow(fila);
			}
			
		}
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(null, s,"ALERTA",2);
	}
	private String leerNomPro(){
		String nomPro=null;
		if(txtBuscarPro.getText().trim().length()==0){
			alerta("Campo Vacio");
		}else{
			nomPro = txtBuscarPro.getText().trim();
		}
		return nomPro;
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cancelButton) {
			actionPerformedCancelButton(arg0);
		}
		if (arg0.getSource() == okButton) {
			actionPerformedOkButton(arg0);
		}
	}
	protected void actionPerformedOkButton(ActionEvent arg0) {
		enviarDatos();
	}
	private void enviarDatos() {
		int fila;
		String cod,nom,stock,precio;
		
		fila=tblProducto.getSelectedRow();
		if(fila == -1) {
			alerta("Debe seleccionar un Producto");
		}
		else {
			cod = tblProducto.getValueAt(fila, 0).toString();
			nom = tblProducto.getValueAt(fila, 1).toString();
			precio = tblProducto.getValueAt(fila, 2).toString();
			stock = tblProducto.getValueAt(fila, 3).toString();
			
			frmVenta.txtCodPro.setText(cod);
			frmVenta.txtNomPro.setText(nom);
			frmVenta.txtStockPro.setText(stock);
			frmVenta.txtPrecioPro.setText(precio);
			
			this.dispose();
		}
		
	}
	protected void actionPerformedCancelButton(ActionEvent arg0) {
		this.dispose();
	}
	
	private String buscarPro(){
		String id = txtBuscarPro.getText().trim();
		return id;
	}
	
	void filtrar() {
		String pro = buscarPro();		
		try {
			sorter.setRowFilter(RowFilter.regexFilter("(?i)"+pro, 1));
			
		} catch (Exception e2) {
			alerta("Error: " + e2);
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBuscarPro) {
			do_txtBuscarPro_keyTyped(e);
		}
	}
	protected void do_txtBuscarPro_keyTyped(KeyEvent e) {
		filtrar();
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == tblProducto) {
			do_tblProducto_mouseEntered(e);
		}
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_tblProducto_mouseEntered(MouseEvent e) {
		tblProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblProducto.getColumnModel();
		//Ocultar Codigo de usuario
		tblProducto.getColumnModel().getColumn(0).setMaxWidth(0);
		tblProducto.getColumnModel().getColumn(0).setMinWidth(0);
		tblProducto.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tblProducto.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		//fin de codigo
		//tcm.getColumn(0).setPreferredWidth(anchoColumna(9));  // Codigo
		tcm.getColumn(1).setPreferredWidth(100);  // producto
		tcm.getColumn(2).setPreferredWidth(10);  // precio
		tcm.getColumn(3).setPreferredWidth(10);  // Stock
	}
}
