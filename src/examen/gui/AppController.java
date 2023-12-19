package examen.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import examen.modelo.Coche;
import examen.services.AutenticacionException;
import examen.services.ExamenService;

public class AppController {

	private JFrame frame;
	private BienvenidoView bienvenidoView;
	private ConsultarView consultarView;
	private AltaView altaView;
	private ExamenService service;
	private List<Coche> listaCoches;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppController window = new AppController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppController() {
		listaCoches = new ArrayList<Coche>();
		service = new ExamenService();
		bienvenidoView = new BienvenidoView(this);
		consultarView = new ConsultarView(this);
		altaView = new AltaView(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setResizable(false);
		frame.setBounds(100, 100, 1920, 1080);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		irBienvenida();
	}

	public void irBienvenida() {
		bienvenidoView.limpiar();
		frame.setContentPane(bienvenidoView);
		frame.revalidate();
	}

	public void irAlta() {
		altaView.limpiar();
		frame.setContentPane(altaView);
		frame.revalidate();
	}

	public void irConsultar() {
		consultarView.limpiar();
		frame.setContentPane(consultarView);
		frame.revalidate();
	}

	public String login(String codigo) {
		try {
			service.login(codigo);
			return "";
		} catch (AutenticacionException e) {
			return e.getMessage();
		}
	}

	public void consutlarCoche(String marca) {
		listaCoches = service.consultarCoches(marca);
	}

	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public Integer sumar(Integer numero) {

		return numero + 1;
	}

	public Integer restar(Integer numero) {
		if (numero == 1) {
			return 1;
		} else
			return numero - 1;
	}

	public void insertar(String marca, String modelo, Integer años) {
		service.crearCoche(marca, modelo, años);
	}
}
