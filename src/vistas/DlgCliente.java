package vistas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCliente;
	private JTable tblCliente;
	DefaultTableModel model=new DefaultTableModel();
	GestionClienteDAO gc=new GestionClienteDAO();
	private JButton button;
	private JButton cancelButton;
	private JButton okButton;

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
			JLabel lblCliente = new JLabel("Cliente");
			lblCliente.setFont(new Font("Roboto Light", Font.PLAIN, 16));
			lblCliente.setBounds(10, 11, 65, 29);
			contentPanel.add(lblCliente);
		}
		{
			txtCliente = new JTextField();
			txtCliente.setFont(new Font("Roboto Light", Font.PLAIN, 16));
			txtCliente.setColumns(10);
			txtCliente.setBounds(85, 13, 168, 26);
			contentPanel.add(txtCliente);
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
			scrollPane.setBounds(10, 54, 414, 174);
			contentPanel.add(scrollPane);
			{
				tblCliente = new JTable(){
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int rowIndex,int columnIndex){
						return false;}
				};
				model.addColumn("Dni");
				model.addColumn("Nombre Completo");
				tblCliente.setModel(model);
				tblCliente.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblCliente);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("");
				okButton.addActionListener(this);
				okButton.setIcon(new ImageIcon(DlgCliente.class.getResource("/img/Accept256_25070.png")));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("");
				cancelButton.addActionListener(this);
				cancelButton.setIcon(new ImageIcon(DlgCliente.class.getResource("/img/delete_unapprove_discard_remove_x_red_icon-icons.com_55984.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		listarClientes();
	}
	private void listarClientes(){
		ArrayList<Cliente>listaPro=gc.listar();
		for (Cliente c : listaPro) {
			Object [] fila={
					c.getDni(),
					c.getNombre()
			};
			model.addRow(fila);
		}
	}
	private String leerDni(){
		String dni = null;
		if(txtCliente.getText().trim().length()==0){
			alerta("Campo Codigo Vacio");
		}else if(txtCliente.getText().trim().matches(Validacion.DNI)==false){
			alerta("El DNI a buscar debe contener 8 números");
		}else{
			dni = txtCliente.getText().trim();
		}
		return dni;
	}
	private void alerta(String s){
		JOptionPane.showMessageDialog(null,s,"Alerta",0);
	}
	private void buscarDNI(String xdni) {
		if(xdni==null){
			txtCliente.setText("");
			txtCliente.requestFocus();
			return;
		}else{
		ArrayList<Cliente>listar=gc.listarClientexDNI(xdni);
		model.setRowCount(0);
		if(listar.size()==0){
			alerta("Cliente no existe !");
			listarClientes();
		}else{
			for (Cliente c : listar) {
				Object [] fila={
						c.getDni(),
						c.getNombre()
				};
				model.addRow(fila);
				txtCliente.setText("");
			}
		}}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == okButton) {
			actionPerformedOkButton(arg0);
		}
		if (arg0.getSource() == cancelButton) {
			actionPerformedCancelButton(arg0);
		}
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		buscarDNI(leerDni());
	}
	private void enviarDatos() {
		int fila;
		String dni,nom;
		
		fila=tblCliente.getSelectedRow();
		
		dni = tblCliente.getValueAt(fila, 0).toString();
		nom = tblCliente.getValueAt(fila, 1).toString();
		
		
		frmVenta.txtDni.setText(dni);
		frmVenta.txtNombre.setText(nom);
		
		this.dispose();
	}
	protected void actionPerformedCancelButton(ActionEvent arg0) {
		this.dispose();
	}
	protected void actionPerformedOkButton(ActionEvent arg0) {
		enviarDatos();
	}
}
