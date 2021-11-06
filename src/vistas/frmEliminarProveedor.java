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
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class frmEliminarProveedor extends JDialog implements MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JLabel label_1;
	private JTextField textField;
	private JLabel label_2;
	private JLabel label_3;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JTable tbProveedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmEliminarProveedor dialog = new frmEliminarProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmEliminarProveedor() {
		setBounds(0, 0, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 450, 350);
		panel.setBackground(new Color(193,18,5));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("Ingrese Codigo o Seleccione Producto");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		label.setBounds(34, 25, 352, 26);
		panel_1.add(label);
		
		label_1 = new JLabel("BUSCAR POR CODIGO");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		label_1.setBounds(10, 132, 172, 22);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(192, 132, 188, 22);
		panel_1.add(textField);
		
		label_2 = new JLabel("");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setBounds(390, 132, 30, 22);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscarr=new ImageIcon(icoBuscar.getImage().getScaledInstance(label_2.getWidth(),label_2.getHeight(), Image.SCALE_SMOOTH));
		label_2.setIcon(imgBuscarr);
		panel_1.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.addMouseListener(this);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_3.getWidth(),label_3.getHeight(), Image.SCALE_SMOOTH));
		label_3.setIcon(imgCerrar);
		panel_1.add(label_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(10, 165, 410, 137);
		panel_1.add(scrollPane);
		
		tbProveedor = new JTable();
		scrollPane.setViewportView(tbProveedor);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnEliminar.setBounds(125, 313, 172, 26);
		panel_1.add(btnEliminar);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_3) {
			mouseClickedLabel_3(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLabel_3(MouseEvent arg0) {
		this.dispose();
	}
}
