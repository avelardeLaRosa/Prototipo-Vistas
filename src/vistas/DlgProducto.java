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

import controlador.GestionProductoDAO;
import entidad.Producto;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgProducto extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNomPro;
	private JTable tblProducto;
	DefaultTableModel model=new DefaultTableModel();
	GestionProductoDAO gp=new GestionProductoDAO();
	private JButton button;
	private JButton button_1;
	private JButton okButton;
	private JButton cancelButton;

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
			JLabel lblProducto = new JLabel("Producto");
			lblProducto.setFont(new Font("Roboto Light", Font.PLAIN, 16));
			lblProducto.setBounds(10, 11, 65, 29);
			contentPanel.add(lblProducto);
		}
		{
			txtNomPro = new JTextField();
			txtNomPro.setFont(new Font("Roboto Light", Font.PLAIN, 16));
			txtNomPro.setColumns(10);
			txtNomPro.setBounds(85, 13, 168, 26);
			contentPanel.add(txtNomPro);
		}
		{
			button = new JButton("");
			button.addActionListener(this);
			button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button.setBounds(266, 11, 40, 29);
			ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
			ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH));
			button.setIcon(imgBuscar);
			contentPanel.add(button);
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
				model.addColumn("Codigo");
				model.addColumn("Producto");
				model.addColumn("Precio");
				model.addColumn("Stock");
				tblProducto.setModel(model);
				tblProducto.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblProducto);
			}
		}
		{
			button_1 = new JButton("");
			button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_1.addActionListener(this);
			button_1.setIcon(new ImageIcon(DlgProducto.class.getResource("/img/arrow_refresh_15732.png")));
			button_1.setBounds(316, 11, 40, 29);
			contentPanel.add(button_1);
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
		}
		listarProdutos();
	}
	private void listarProdutos(){
		ArrayList<Producto>listaPro=gp.listarProductos();
		for (Producto p : listaPro) {
			Object [] fila={
					p.getIdProducto(),
					p.getNombre(),
					"S/. " + p.getPrecio(),
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
						"S/. "+p.getPrecio(),
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
		if(txtNomPro.getText().trim().length()==0){
			alerta("Campo Vacio");
		}else{
			nomPro = txtNomPro.getText().trim();
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
		if (arg0.getSource() == button_1) {
			actionPerformedButton_1(arg0);
		}
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		buscarXNombreProducto(leerNomPro());
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
		listarProdutos();
	}
	protected void actionPerformedOkButton(ActionEvent arg0) {
		enviarDatos();
	}
	private void enviarDatos() {
		int fila;
		String cod,nom,stock,precio;
		
		fila=tblProducto.getSelectedRow();
		
		cod = tblProducto.getValueAt(fila, 0).toString();
		nom = tblProducto.getValueAt(fila, 1).toString();
		stock = tblProducto.getValueAt(fila, 2).toString();
		precio = tblProducto.getValueAt(fila, 3).toString();
		
		frmVenta.txtCodPro.setText(cod);
		frmVenta.txtNomPro.setText(nom);
		frmVenta.txtStockPro.setText(stock);
		frmVenta.txtPrecioPro.setText(precio);
		
		this.dispose();
	}
	protected void actionPerformedCancelButton(ActionEvent arg0) {
		this.dispose();
	}
}
