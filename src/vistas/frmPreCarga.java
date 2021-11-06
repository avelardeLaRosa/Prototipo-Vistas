package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;

import Hilos.HiloPreCarga;

import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class frmPreCarga extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JLabel lbl_Icono;
	public static JProgressBar pbCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPreCarga frame = new frmPreCarga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPreCarga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_Icono = new JLabel("");
		lbl_Icono.setBounds(10, 22, 245, 261);
		//INTANCIA ICO Y IMG
		ImageIcon icoLogo = new ImageIcon(getClass().getResource("/img/logoChanny.png"));
		ImageIcon imgLogo = new ImageIcon(icoLogo.getImage().getScaledInstance(lbl_Icono.getWidth(), lbl_Icono.getHeight(), Image.SCALE_DEFAULT));
		lbl_Icono.setIcon(imgLogo);
		//FIN DE AJUSTE
		contentPane.add(lbl_Icono);
		
		pbCarga = new JProgressBar();
		pbCarga.addChangeListener(this);
		pbCarga.setBounds(10, 283, 245, 28);
		contentPane.add(pbCarga);
		setUndecorated(true);
		setLocationRelativeTo(this);
		
		carga();
	}
	
	
	
	public void stateChanged(ChangeEvent arg0) {
		if (arg0.getSource() == pbCarga) {
			stateChangedPbCarga(arg0);
		}
	}
	protected void stateChangedPbCarga(ChangeEvent arg0) {
		conexionFrmPrincipal();
	}
	

	public void conexionFrmPrincipal(){ 
		if(pbCarga.getValue()==100){ // si la barra llega a 100 
			frmLogin log = new frmLogin();
			log.setVisible(true); // aparece ventana
			log.setLocationRelativeTo(this); //se centre la ventana
			this.dispose(); //cierre de la ventana 
		}
	}
	
	public void carga(){
		//inicio hilo
				HiloPreCarga carga=new HiloPreCarga();
				carga.start();
	}
	
}
