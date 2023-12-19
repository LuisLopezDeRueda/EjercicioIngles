package examen.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class BienvenidoView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1588724642212845579L;
	private JTextField textField;
	private JRadioButton rdbtnAnonimo;
	private JRadioButton rdbtnIdentificacion;
	private JButton btnEntrar;
	private JLabel lblNewLabel;
	private JLabel lblError;

	public BienvenidoView(AppController appView) {
		super(appView);
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(255, 0, 0));
		setLayout(null);

		JLabel lblBienvenida = new JLabel("Welcome to CarCollection");
		lblBienvenida.setForeground(new Color(183, 54, 201));
		lblBienvenida.setFont(new Font("Playbill", Font.PLAIN, 80));
		lblBienvenida.setBounds(162, 91, 587, 86);
		add(lblBienvenida);

		JLabel lblTipoAcceso = new JLabel("Choose the type of access");
		lblTipoAcceso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoAcceso.setBounds(191, 239, 201, 14);
		add(lblTipoAcceso);

		rdbtnAnonimo = new JRadioButton("Anonymous");
		rdbtnAnonimo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnAnonimo.setBounds(191, 260, 109, 23);
		add(rdbtnAnonimo);

		lblError = new JLabel();

		rdbtnIdentificacion = new JRadioButton("Identification:");
		rdbtnIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnIdentificacion.setBounds(191, 286, 127, 23);
		add(rdbtnIdentificacion);

		rdbtnIdentificacion.setOpaque(false);
		rdbtnAnonimo.setOpaque(false);

		textField = new JTextField();
		textField.setBounds(324, 286, 96, 23);
		add(textField);
		textField.setColumns(10);

		textField.setOpaque(false);

		textField.setEnabled(false);

		btnEntrar = new JButton("Enter");
		btnEntrar.setBounds(571, 338, 101, 34);
		add(btnEntrar);

		btnEntrar.setEnabled(false);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtnAnonimo) {
					rdbtnAnonimo.setSelected(true);
					rdbtnIdentificacion.setSelected(false);
					textField.setEnabled(false);
				} else if (e.getSource() == rdbtnIdentificacion) {
					rdbtnAnonimo.setSelected(false);
					rdbtnIdentificacion.setSelected(true);
					textField.setEnabled(true);
				}
				btnEntrar.setEnabled(true);

			}
		};
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnIdentificacion.isSelected()) {
					String entrar = appView.login(textField.getText());
					if (!entrar.isEmpty()) {
						lblError.setText(entrar);
					} else {
						appView.irConsultar();
					}
				}
				if (rdbtnAnonimo.isSelected()) {
					appView.irConsultar();
				}

			}
		});

		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		rdbtnAnonimo.addActionListener(actionListener);
		rdbtnIdentificacion.addActionListener(actionListener);

		JButton btnSalir = new JButton("Exit");
		btnSalir.setBounds(571, 376, 101, 34);
		add(btnSalir);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\llopezderueda0480\\Downloads\\cashao.jfif"));
		lblNewLabel.setBounds(51, 22, 1240, 657);
		add(lblNewLabel);

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnSalir, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION) != 1) {
					System.exit(0);
				} else {

				}
			}
		});
	}

	public void limpiar() {
		textField.setText("");
		rdbtnIdentificacion.setSelected(false);
		rdbtnAnonimo.setSelected(false);
		lblError.setText("");
		btnEntrar.setEnabled(false);
	}
}
