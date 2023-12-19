package examen.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import examen.modelo.Coche;

public class ExamenService{
	/** Devuelve la lista de coches de la marca indicada que estón registrados en la "base de datos" simulada.
	 * Si no hay coches para la marca indicada, devolveró una lista vacía 
	 * @param marca
	 * @return
	 */
	public List<Coche> consultarCoches(String marca){
		if (marca == null) {
			return new ArrayList<Coche>();
		}
		marca = marca.toUpperCase().trim();
		if (!bbdd.containsKey(marca)) {
			return new ArrayList<Coche>();
		}
		return bbdd.get(marca);
	}
	
	
	/** Crea un coche en la base de datos con la marca, modelo y antigüedad indicados. Por defecto se pondrá
	 * como fecha de última revisión la fecha actual.
	 * @param marca
	 * @param modelo
	 * @param antiguedad
	 */
	public void crearCoche(String marca, String modelo, Integer antiguedad) {
		List<Coche> coches = bbdd.get(marca.toUpperCase().trim());
		if (coches==null) {
			coches = new ArrayList<>();
			bbdd.put(marca.toUpperCase().trim(), coches);
		}
		coches.add(new Coche(marca, modelo, LocalDate.now(), antiguedad));
	}
	
	
	/** Hace login con el código de acceso indicado. Si todo va bien, no devuelve nada. Si el código no es correcto,
	 * lanza AutenticationException con el mensaje de error. El único código de acceso correcto es: 123
	 * @param codigo
	 * @throws AutenticacionException 
	 */
	public void login(String codigo) throws AutenticacionException {
		if (codigo==null || codigo.isEmpty()) {
			throw new AutenticacionException("El código indicado es vacío");
		}
		if (codigo.equals("123")) {
			return;
		}
		if (codigo.length()<3) {
			throw new AutenticacionException("Código incorrecto");
		}
		if (codigo.length()<5) {
			throw new AutenticacionException("No tiene permisos para acceder");
		}
		if (codigo.length()<10) {
			throw new AutenticacionException("Su código de acceso está bloqueado");
		}
		throw new AutenticacionException("Inténtalo de nuevo");
	}
	
	
	// Ignorar este código...
	private static Map<String, List<Coche>> bbdd = new HashMap<String, List<Coche>>();
	static {
		List<Coche> toyota = new ArrayList<Coche>();
		toyota.add(new Coche("Toyota", "Auris", LocalDate.of(2021, 1, 5), 2)); 
		toyota.add(new Coche("Toyota", "Auris", LocalDate.of(2015, 12, 9), 8)); 
		toyota.add(new Coche("Toyota", "Rav4", LocalDate.of(2021, 6, 15),  2));
		toyota.add(new Coche("Toyota", "Corolla", LocalDate.of(2022, 4, 14), 3)); 
		toyota.add(new Coche("Toyota", "Yaris", LocalDate.of(2019, 8, 6), 7)); 
		toyota.add(new Coche("Toyota", "Rav4", LocalDate.of(2021, 8, 24), 2)); 
		List<Coche> seat = new ArrayList<Coche>();
		seat.add(new Coche("Seat", "Córdoba", LocalDate.of(2015, 5, 28), 9)); 
		seat.add(new Coche("Seat", "Ibiza", LocalDate.of(2021, 4, 23), 2)); 
		seat.add(new Coche("Seat", "León", LocalDate.of(2022, 3, 29), 1));
		seat.add(new Coche("Seat", "Córdoba", LocalDate.of(2021, 1, 19), 2));
		seat.add(new Coche("Seat", "León", LocalDate.of(2015, 12, 16), 9));
		seat.add(new Coche("Seat", "Ibiza", LocalDate.of(2018, 10, 17), 6));
		seat.add(new Coche("Seat", "Córdoba", LocalDate.of(2021, 3, 4), 2));
		seat.add(new Coche("Seat", "Ibiza", LocalDate.of(2019, 11, 8), 4));
		seat.add(new Coche("Seat", "León", LocalDate.of(2017,3 , 4), 10));
		seat.add(new Coche("Seat", "Toledo", LocalDate.of(2021, 4, 24), 2));
		seat.add(new Coche("Seat", "Ibiza", LocalDate.of(2015, 5, 23), 10));
		seat.add(new Coche("Seat", "Toledo", LocalDate.of(2016, 10, 25), 7));
		seat.add(new Coche("Seat", "Córdoba", LocalDate.of(2021, 11, 17), 2));
		seat.add(new Coche("Seat", "Toledo", LocalDate.of(2021, 1, 15), 2));
		seat.add(new Coche("Seat", "Ibiza", LocalDate.of(2022, 2, 20), 4));
		seat.add(new Coche("Seat", "Córdoba", LocalDate.of(2022, 6, 4), 3));
		seat.add(new Coche("Seat", "León", LocalDate.of(2015, 7, 31), 8));
		seat.add(new Coche("Seat", "Ibiza", LocalDate.of(2021, 7, 22), 2));
		List<Coche> renault = new ArrayList<Coche>();
		renault.add(new Coche("Renault", "Laguna", LocalDate.of(2023, 7, 17), 1));
		renault.add(new Coche("Renault", "Clío", LocalDate.of(2020, 3, 14), 2));
		renault.add(new Coche("Renault", "Megane", LocalDate.of(2017, 4, 1), 6));
		renault.add(new Coche("Renault", "Megane", LocalDate.of(2018, 10, 12), 6));
		renault.add(new Coche("Renault", "Megane", LocalDate.of(2018, 12, 20), 8));
		renault.add(new Coche("Renault", "Clío", LocalDate.of(2022, 1, 10), 1));
		bbdd.put("TOYOTA", toyota);
		bbdd.put("SEAT", seat);
		bbdd.put("RENAULT", renault);
		
	}
	
	
	
}
