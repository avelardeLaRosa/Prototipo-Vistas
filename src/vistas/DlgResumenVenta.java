package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgResumenVenta extends JDialog implements MouseListener, MouseMotionListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	int xMouse, yMouse;
	private JLabel lblNewLabel;
	private JLabel lblResumenDeVenta;
	private JLabel lblDocumentoGeneradoEs;
	private JLabel lblNumBol;
	private JLabel lblSubTotal;
	private JLabel lblTotal;
	private JLabel lblSTotal;
	private JLabel lblTot;
	private Button button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgResumenVenta dialog = new DlgResumenVenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgResumenVenta() {
		setBounds(100, 100, 352, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.addMouseMotionListener(this);
		contentPanel.addMouseListener(this);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(DlgResumenVenta.class.getResource("/img/comprobado.png")));
		lblNewLabel.setBounds(125, 11, 92, 72);
		contentPanel.add(lblNewLabel);
		
		lblResumenDeVenta = new JLabel("Resumen de Venta");
		lblResumenDeVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblResumenDeVenta.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblResumenDeVenta.setBounds(79, 94, 191, 26);
		contentPanel.add(lblResumenDeVenta);
		
		lblDocumentoGeneradoEs = new JLabel("Documento generado es: ");
		lblDocumentoGeneradoEs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDocumentoGeneradoEs.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblDocumentoGeneradoEs.setBounds(21, 131, 177, 26);
		contentPanel.add(lblDocumentoGeneradoEs);
		
		lblNumBol = new JLabel("B000");
		lblNumBol.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumBol.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblNumBol.setBounds(218, 131, 101, 26);
		contentPanel.add(lblNumBol);
		
		lblSubTotal = new JLabel("Sub Total: ");
		lblSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubTotal.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblSubTotal.setBounds(75, 163, 123, 26);
		contentPanel.add(lblSubTotal);
		
		lblTotal = new JLabel("Total: ");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblTotal.setBounds(75, 197, 123, 26);
		contentPanel.add(lblTotal);
		
		lblSTotal = new JLabel("S/.00.00");
		lblSTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblSTotal.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblSTotal.setBounds(218, 163, 101, 26);
		contentPanel.add(lblSTotal);
		
		lblTot = new JLabel("S/.00.00");
		lblTot.setHorizontalAlignment(SwingConstants.LEFT);
		lblTot.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblTot.setBounds(218, 197, 101, 26);
		contentPanel.add(lblTot);
		
		button = new Button("OK");
		button.addActionListener(this);
		button.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 139, 139));
		button.setBounds(147, 229, 70, 22);
		contentPanel.add(button);
		setUndecorated(true);
		//
		lblNumBol.setText(frmVenta.numBol);
		lblSTotal.setText("S/. "+String.format("%.2f", frmVenta.importeTotal));
		lblTot.setText("S/. "+String.format("%.2f", frmVenta.importeTotal*1.18));
		
	}

	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == contentPanel) {
			mousePressedContentPanel(arg0);
		}
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mousePressedContentPanel(MouseEvent arg0) {
		xMouse = arg0.getX();
		yMouse = arg0.getY();
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == contentPanel) {
			mouseDraggedContentPanel(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedContentPanel(MouseEvent arg0) {
		int x = arg0.getXOnScreen();
		int y = arg0.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		this.dispose();
	}
}
