package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controlador.GestionCategoriaDAO;
import controlador.GestionProductoDAO;
import entidad.Categoria;
import entidad.DetalleVenta;
import entidad.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmInventarioReporte extends JFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JLabel lblReporteDeInventario;
	private JLabel label_1;
	private JPanel panel;
	private JComboBox cboInventario;
	private JLabel lblVisualizarPorCategoria;
	GestionCategoriaDAO gc=new GestionCategoriaDAO();
	private JScrollPane scrollPane;
	private JTable tblInventario;
	private JButton btnExportarInventario;
	DefaultTableModel model=new DefaultTableModel();
	GestionProductoDAO gp=new GestionProductoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInventarioReporte frame = new frmInventarioReporte();
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
	public frmInventarioReporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(193, 18, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		lblReporteDeInventario = new JLabel("REPORTE DE INVENTARIO");
		lblReporteDeInventario.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeInventario.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblReporteDeInventario.setBounds(121, 11, 283, 36);
		contentPane.add(lblReporteDeInventario);
		
		panel = new JPanel();
		panel.setBounds(10, 0, 529, 351);
		contentPane.add(panel);
		panel.setLayout(null);
		
		label_1 = new JLabel("");
		label_1.setBounds(471, 11, 32, 30);
		panel.add(label_1);
		label_1.addMouseListener(this);
		label_1.setIcon(new ImageIcon(frmInventarioReporte.class.getResource("/img/leftarrow_theapplication_izquierda_4435.png")));
		
		cboInventario = new JComboBox();
		cboInventario.addActionListener(this);
		cboInventario.setBounds(195, 53, 206, 30);
		panel.add(cboInventario);
		
		lblVisualizarPorCategoria = new JLabel("Visualizar por Categoria");
		lblVisualizarPorCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		lblVisualizarPorCategoria.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblVisualizarPorCategoria.setBounds(10, 53, 175, 30);
		panel.add(lblVisualizarPorCategoria);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 509, 206);
		panel.add(scrollPane);
		
		tblInventario = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		model.addColumn("ID Producto");
		model.addColumn("Nombre");
		model.addColumn("Stock");
		model.addColumn("Precio");
		model.addColumn("Categoria");
		model.addColumn("Proveedor");
		tblInventario.setModel(model);
		tblInventario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblInventario);
		
		btnExportarInventario = new JButton("EXPORTAR INVENTARIO");
		btnExportarInventario.addActionListener(this);
		btnExportarInventario.setBounds(195, 310, 169, 30);
		panel.add(btnExportarInventario);
		listarProductos();
		cargarComboEquipo();
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_1) {
			mouseClickedLabel_1(arg0);
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
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		DlgOpcReportes dop=new DlgOpcReportes();
		dop.setVisible(true);
		dop.setLocationRelativeTo(this);
		this.dispose();
	}
	private int leerCategoria() {
		int cbo=0;
			cbo = cboInventario.getSelectedIndex();
		return cbo;
	}
	void cargarComboEquipo() {
		ArrayList<Categoria> cbo = gc.listar();
		cboInventario.addItem("Selecione Tipo ");
		for (Categoria c : cbo) {
		cboInventario.addItem(c.getDes_categoria());
	}	
	}
	void listarXCategoria(int idCat){
		model.setRowCount(0);
		ArrayList<Producto>listar = gp.listarXCat(idCat);
		if(idCat==0){
			listarProductos();
			return;
		}else if(listar.size()==0){
			alerta("Producto no Existe");
			cboInventario.setSelectedIndex(0);
			listarProductos();
		}else{
			for(Producto p: listar){
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
	private void listarXCat(){
		int id = leerCategoria();
		
		switch (id) {
		case 0: break;
		case 1: listarXCategoria(id);break;
		case 2: listarXCategoria(id);break;
		case 3: listarXCategoria(id);break;
		case 4: listarXCategoria(id);break;
		case 5: listarXCategoria(id);break;
		case 6: listarXCategoria(id);break;
		case 7: listarXCategoria(id);break;
		case 8: listarXCategoria(id);break;
		case 9: listarXCategoria(id);break;
		default:listarXCategoria(id);
			break;
		}
	}
	void imprimePDF() {

		//PASO 1 : ASIGNAR EL NOMBRE DEL ARCHIVO Y UBICACION
		String nomArchivo = "reportes/reporteInventario.pdf";
		try {
					//PASO 2: AGREGAR UNA PLANTILLA 
					Document plantilla=new Document();
					//PASO 3: CREAR ARCHIVO PDF EN FISICO
					FileOutputStream fos=new FileOutputStream(nomArchivo);
					//PASO 4: RELACIONAR LA PLANTILLA CON EL ARCHIVO PDF
					PdfWriter pdfWrt = PdfWriter.getInstance(plantilla, fos);
					//PASO 5: PLANTILLA A MODO DE ESCRITURA
					plantilla.open();
					//PASO 6: AGREGAR LOS COMPONENTES
					//imagenes
					Image img= Image.getInstance("img/logoChanny.png");
					img.scaleToFit(80,80);
					img.setAlignment(Chunk.ALIGN_RIGHT);
					plantilla.add(img);
					//--titulo
					Paragraph p=new Paragraph("Reporte de Inventario",FontFactory.getFont("arial",20,Font.ITALIC,BaseColor.BLACK));
					p.setAlignment(Chunk.ALIGN_CENTER);
					plantilla.add(p);
					//--linea en blanco
					Paragraph b=new Paragraph(" ");
					plantilla.add(b);
					//--listado de productos
					ArrayList<Producto>listar=gp.listarProductos();
					//validar resultado
					if(listar==null||listar.size()==0){
						alerta("No existe inventario para ser exportado !");
					}else{
						//crear una tabla
						PdfPTable table=new PdfPTable(4);
						//agregar las columnas
						table.addCell("ID Producto");
						table.addCell("Detalle");
						table.addCell("Stock");
						table.addCell("Precio");
						//bucle para obtener la data
						for (Producto pro : listar) {
										table.addCell(String.valueOf(pro.getIdProducto()));
										table.addCell(pro.getNombre());
										table.addCell(String.valueOf(pro.getCantidad()));
										table.addCell("S/."+String.format("%.2f", pro.getPrecio()));
							}
						//agregar la tabla a la plantilla
							plantilla.add(table);
						}
			
					//PASO 7: CERRAR LA PLANTILLA
					plantilla.close();
					//PASO 8: MOSTRAR EL ARCHIVO PDF
					Desktop.getDesktop().open(new File(nomArchivo));
				
			} 
			catch (Exception e) {
			System.out.println("Error al crear el archivo");
		}
		
		
		
		
	}

	private void alerta(String s) {
		JOptionPane.showMessageDialog(this,s,"ERROR",0);
		
	}
	private void mensaje(String s) {
		JOptionPane.showMessageDialog(this,s);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnExportarInventario) {
			actionPerformedButton(arg0);
		}
		if (arg0.getSource() == cboInventario) {
			actionPerformedCboInventario(arg0);
		}
	}
	protected void actionPerformedCboInventario(ActionEvent arg0) {
		listarXCat();
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		imprimePDF();
	}
}
