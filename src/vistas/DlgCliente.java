package vistas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import controlador.GestionClienteDAO;
import entidad.Cliente;
import entidad.Producto;
import utils.Validacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgCliente extends JDialog implements ActionListener, KeyListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCliente;
	private JTable tblCliente;
	DefaultTableModel model=new DefaultTableModel();
	GestionClienteDAO gc=new GestionClienteDAO();
	private JButton cancelButton;
	private JButton okButton;
	TableRowSorter<DefaultTableModel> sorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCliente dialog = new DlgCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCliente() {
		setBounds(100, 100, 450, 311);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCliente = new JLabel("Buscar DNI: ");
			lblCliente.setFont(new Font("Roboto Light", Font.PLAIN, 16));
			lblCliente.setBounds(10, 11, 117, 29);
			contentPanel.add(lblCliente);
		}
		{
			txtCliente = new JTextField();
			txtCliente.addKeyListener(this);
			txtCliente.addActionListener(this);
			txtCliente.setFont(new Font("Roboto Light", Font.PLAIN, 16));
			txtCliente.setColumns(10);
			txtCliente.setBounds(108, 12, 168, 26);
			contentPanel.add(txtCliente);
		}
		{
			ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 54, 414, 174);
			contentPanel.add(scrollPane);
			{
				tblCliente = new JTable(){
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int rowIndex,int columnIndex){
						return false;}
				};
				tblCliente.addMouseListener(this);
				model.addColumn("ID");
				model.addColumn("Nombre Completo");
				model.addColumn("DNI");
				tblCliente.setModel(model);
				tblCliente.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblCliente);
				//FILTRAR JTABLE
				tblCliente.setAutoCreateRowSorter(true);
				sorter = new TableRowSorter<>(model);
				tblCliente.setRowSorter(sorter);
				//
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("");
				okButton.addMouseListener(this);
				okButton.addActionListener(this);
				okButton.setIcon(new ImageIcon(DlgCliente.class.getResource("/img/Accept256_25070.png")));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("");
				cancelButton.addMouseListener(this);
				cancelButton.addActionListener(this);
				cancelButton.setIcon(new ImageIcon(DlgCliente.class.getResource("/img/delete_unapprove_discard_remove_x_red_icon-icons.com_55984.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		ajustarAnchoColumnas();
		listarClientes();
	}
	private void listarClientes(){
		ArrayList<Cliente>listaPro=gc.listar();
		for (Cliente c : listaPro) {
			Object [] fila={
					c.getIdCliente(),
					c.getNombre(),
					c.getDni()
			};
			model.addRow(fila);
		}
	}
	private String buscarDNI(){
		String id = txtCliente.getText().trim();
		return id;
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(null,s,"Alerta",0);
	}
	/*private void buscarId(int xid) {
		if(xid==0){
			txtCliente.setText("");
			txtCliente.requestFocus();
			return;
		}else{
		ArrayList<Cliente>listar=gc.listarXId(xid);
		model.setRowCount(0);
		if(listar.size()==0){
			alerta("Cliente no existe !");
			listarClientes();
		}else{
			for (Cliente c : listar) {
				Object [] fila={
						c.getIdCliente(),
						c.getNombre(),
						c.getDni()
				};
				model.addRow(fila);
				txtCliente.setText("");
			}
		}}
	}*/
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == txtCliente) {
			do_txtCliente_actionPerformed(arg0);
		}
		if (arg0.getSource() == okButton) {
			actionPerformedOkButton(arg0);
		}
		if (arg0.getSource() == cancelButton) {
			actionPerformedCancelButton(arg0);
		}
	}
	private void enviarDatos() {
		int fila;
		String id,nom,dni;
		
		fila=tblCliente.getSelectedRow();
		if(fila == -1) {
			alerta("Debe seleccionar un Cliente");
		}
		else {
			id = tblCliente.getValueAt(fila, 0).toString();
			nom = tblCliente.getValueAt(fila, 1).toString();
			dni = tblCliente.getValueAt(fila, 2).toString();
			
			frmVenta.txtId.setText(id);
			frmVenta.txtNombre.setText(nom);
			frmVenta.txtDNI.setText(dni);
			
			this.dispose();
		}
	}
	protected void actionPerformedCancelButton(ActionEvent arg0) {
		this.dispose();
	}
	protected void actionPerformedOkButton(ActionEvent arg0) {
		enviarDatos();
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCliente.getColumnModel();
		//Ocultar Codigo de usuario
		tblCliente.getColumnModel().getColumn(0).setMaxWidth(0);
		tblCliente.getColumnModel().getColumn(0).setMinWidth(0);
		tblCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tblCliente.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		//fin de codigo
		//tcm.getColumn(0).setPreferredWidth(anchoColumna(9));  // Codigo
		tcm.getColumn(1).setPreferredWidth(70);  // Nombre
		tcm.getColumn(2).setPreferredWidth(30);  // DNI
	}
	
	void filtrar() {
		String dni = buscarDNI();		
		try {
			sorter.setRowFilter(RowFilter.regexFilter(dni, 2));
			
		} catch (Exception e2) {
			alerta("Error: " + e2);
		}
	}

	protected void do_txtCliente_actionPerformed(ActionEvent arg0) {
		
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtCliente) {
			do_txtCliente_keyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		filtrar();
	}
	protected void do_txtCliente_keyPressed(KeyEvent e) {
		//filtrar();
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == cancelButton) {
			do_cancelButton_mouseEntered(e);
		}
		if (e.getSource() == okButton) {
			do_okButton_mouseEntered(e);
		}
		if (e.getSource() == tblCliente) {
			do_tblCliente_mouseEntered(e);
		}
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_tblCliente_mouseEntered(MouseEvent e) {
		tblCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void do_okButton_mouseEntered(MouseEvent e) {
		okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void do_cancelButton_mouseEntered(MouseEvent e) {
		cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
