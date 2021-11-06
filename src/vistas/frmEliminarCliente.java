package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class frmEliminarCliente extends JDialog implements MouseListener, MouseMotionListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblIngreseDniO;
	private JLabel lblBuscarPorDni;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JLabel label_2;
	private JTable table;
	private JLabel label;
	int xMouse,yMouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmEliminarCliente dialog = new frmEliminarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmEliminarCliente() {
		setBounds(0,0,450,350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(193,18,5));
		panel.setBounds(0, 0, 450, 350);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.addMouseMotionListener(this);
		panel_1.addMouseListener(this);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 0, 430, 350);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblIngreseDniO = new JLabel("Ingrese Dni o Seleccione Cliente");
		lblIngreseDniO.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseDniO.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblIngreseDniO.setBounds(40, 45, 352, 26);
		panel_1.add(lblIngreseDniO);
		
		lblBuscarPorDni = new JLabel("BUSCAR POR DNI");
		lblBuscarPorDni.setForeground(Color.BLACK);
		lblBuscarPorDni.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblBuscarPorDni.setBounds(10, 95, 172, 22);
		panel_1.add(lblBuscarPorDni);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(172, 95, 188, 22);
		panel_1.add(textField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0,0,0)));
		scrollPane.setBounds(10, 128, 410, 174);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnEliminar.setBounds(125, 313, 172, 26);
		panel_1.add(btnEliminar);
		
		label_2 = new JLabel("");
		label_2.addMouseListener(this);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(396, 11, 24, 26);
		ImageIcon icoCerrar=new ImageIcon(getClass().getResource("/img/cerrarVnt.png"));
		ImageIcon imgCerrar=new ImageIcon(icoCerrar.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_SMOOTH));
		label_2.setIcon(imgCerrar);
		panel_1.add(label_2);
		
		label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setBounds(370, 95, 30, 22);
		ImageIcon icoBuscar=new ImageIcon(getClass().getResource("/img/search_icon-icons.com_74448.png"));
		ImageIcon imgBuscar=new ImageIcon(icoBuscar.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(imgBuscar);
		panel_1.add(label);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_2) {
			mouseClickedLabel_2(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == panel_1) {
			mousePressedPanel_1(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLabel_2(MouseEvent arg0) {
		this.dispose();
	}
	protected void mousePressedPanel_1(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == panel_1) {
			mouseDraggedPanel_1(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedPanel_1(MouseEvent e) {
		int x=e.getXOnScreen();
		int y=e.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
}
