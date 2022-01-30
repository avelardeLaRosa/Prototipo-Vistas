package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DlgContactos extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnFb;
	private JButton btnLk;
	private JButton btnTw;
	private JLabel lblAlexanderVelardeLa;
	private JLabel lblJesusMartinezVelasquez;
	private JLabel lblCristianEstabridisAlarcon;
	private JLabel lblBazanSalvador;
	private JLabel lblMelgarejoAlcalaLeonardo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgContactos dialog = new DlgContactos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgContactos() {
		setBounds(100, 100, 450, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnFb = new JButton("");
			btnFb.addActionListener(this);
			btnFb.setIcon(new ImageIcon(DlgContactos.class.getResource("/img/facebook (6).png")));
			btnFb.setBounds(64, 227, 56, 41);
			contentPanel.add(btnFb);
		}
		{
			btnLk = new JButton("");
			btnLk.setIcon(new ImageIcon(DlgContactos.class.getResource("/img/linkedin (2).png")));
			btnLk.addActionListener(this);
			btnLk.setBounds(198, 227, 56, 41);
			contentPanel.add(btnLk);
		}
		{
			btnTw = new JButton("");
			btnTw.addActionListener(this);
			btnTw.setIcon(new ImageIcon(DlgContactos.class.getResource("/img/twitter (2).png")));
			btnTw.setBounds(327, 227, 56, 41);
			contentPanel.add(btnTw);
		}
		{
			lblAlexanderVelardeLa = new JLabel("Alexander Velarde La Rosa");
			lblAlexanderVelardeLa.setHorizontalAlignment(SwingConstants.CENTER);
			lblAlexanderVelardeLa.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblAlexanderVelardeLa.setBounds(80, 48, 280, 22);
			contentPanel.add(lblAlexanderVelardeLa);
		}
		{
			lblJesusMartinezVelasquez = new JLabel("Jesus Martinez Velasquez");
			lblJesusMartinezVelasquez.setHorizontalAlignment(SwingConstants.CENTER);
			lblJesusMartinezVelasquez.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblJesusMartinezVelasquez.setBounds(80, 80, 280, 22);
			contentPanel.add(lblJesusMartinezVelasquez);
		}
		{
			lblCristianEstabridisAlarcon = new JLabel("Cristian Estabridis Alarcon");
			lblCristianEstabridisAlarcon.setHorizontalAlignment(SwingConstants.CENTER);
			lblCristianEstabridisAlarcon.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblCristianEstabridisAlarcon.setBounds(80, 115, 280, 22);
			contentPanel.add(lblCristianEstabridisAlarcon);
		}
		{
			lblBazanSalvador = new JLabel("Bazan Salvador, Jair Steven");
			lblBazanSalvador.setHorizontalAlignment(SwingConstants.CENTER);
			lblBazanSalvador.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblBazanSalvador.setBounds(80, 148, 280, 22);
			contentPanel.add(lblBazanSalvador);
		}
		{
			lblMelgarejoAlcalaLeonardo = new JLabel("Melgarejo Alcala, Leonardo");
			lblMelgarejoAlcalaLeonardo.setHorizontalAlignment(SwingConstants.CENTER);
			lblMelgarejoAlcalaLeonardo.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblMelgarejoAlcalaLeonardo.setBounds(80, 181, 280, 22);
			contentPanel.add(lblMelgarejoAlcalaLeonardo);
		}
	}
	
	void conexionFb(){
		if(java.awt.Desktop.isDesktopSupported()){
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
			if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
				try {
					java.net.URI uri=new java.net.URI("https://www.facebook.com/");
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					// TODO: handle exception
				}
			}
		}
	}
	void conexionLk(){
		if(java.awt.Desktop.isDesktopSupported()){
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
			if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
				try {
					java.net.URI uri=new java.net.URI("https://pe.linkedin.com/");
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					// TODO: handle exception
				}
			}
		}
	}
	void conexionTw(){
		if(java.awt.Desktop.isDesktopSupported()){
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
			if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
				try {
					java.net.URI uri=new java.net.URI("https://twitter.com/?lang=es");
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					// TODO: handle exception
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLk) {
			actionPerformedBtnLk(arg0);
		}
		if (arg0.getSource() == btnFb) {
			actionPerformedBtnFb(arg0);
		}
		if (arg0.getSource() == btnTw) {
			actionPerformedBtnTw(arg0);
		}
	}
	private void actionPerformedBtnTw(ActionEvent arg0) {
		conexionTw();
		
	}

	private void actionPerformedBtnFb(ActionEvent arg0) {
		conexionFb();
		
	}

	protected void actionPerformedBtnLk(ActionEvent arg0) {
		conexionLk();
	}
}


