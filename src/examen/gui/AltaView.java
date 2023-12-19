package examen.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AltaView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3248935605060849357L;
	private JTextField textModelo;
	private JTextField textNumero;
	private JComboBox<String> comboBox;

	public AltaView(AppController appView) {
		super(appView);
		setLayout(null);

		JLabel lblMarca = new JLabel("Car brand:");
		lblMarca.setBounds(269, 102, 66, 14);
		add(lblMarca);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(345, 98, 97, 22);
		add(comboBox);

		comboBox.addItem("Peugeot");
		comboBox.addItem("Renault");
		comboBox.addItem("Seat");
		comboBox.addItem("Toyota");

		JLabel lblModelo = new JLabel("Model:");
		lblModelo.setBounds(289, 127, 46, 14);
		add(lblModelo);

		textModelo = new JTextField();
		textModelo.setBounds(345, 124, 97, 20);
		add(textModelo);
		textModelo.setColumns(10);

		JLabel lblAntigedad = new JLabel("Age:");
		lblAntigedad.setBounds(299, 152, 29, 14);
		add(lblAntigedad);

		textNumero = new JTextField();
		textNumero.setEditable(false);
		textNumero.setBounds(384, 149, 22, 20);
		add(textNumero);
		textNumero.setColumns(10);
		textNumero.setText("1");

		JButton btnMenos = new JButton("-");
		btnMenos.setBounds(336, 148, 46, 23);
		add(btnMenos);

		btnMenos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textNumero.setText(appView.restar(Integer.parseInt(textNumero.getText())).toString());
			}
		});

		JButton btnMas = new JButton("+");
		btnMas.setBounds(407, 148, 46, 23);
		add(btnMas);

		btnMas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textNumero.setText(appView.sumar(Integer.parseInt(textNumero.getText())).toString());
			}
		});

		JButton btnAceptar = new JButton("Accept");
		btnAceptar.setBounds(293, 205, 89, 23);
		add(btnAceptar);

		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appView.insertar(comboBox.getSelectedItem().toString(), textModelo.getText(),
						Integer.parseInt(textNumero.getText()));
				JOptionPane.showMessageDialog(null, "Car registered successfully", "Saved",
						JOptionPane.INFORMATION_MESSAGE);
				appView.irConsultar();
			}
		});

		JButton btnCancelar = new JButton("Cancel");
		btnCancelar.setBounds(398, 205, 89, 23);
		add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appView.irConsultar();
			}
		});
	}

	public void limpiar() {
		textModelo.setText("");
		textNumero.setText("1");
		comboBox.setSelectedIndex(-1);
	}

}
