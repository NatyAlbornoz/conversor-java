package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import conversores.*;
import utilidades.UnidadesUtil;
import utilidades.UnidadesUtil.*;

public class Principal {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mostrarMenuSeleccionConversor();
			}
		});
	}

	static void mostrarMenuSeleccionConversor() {
		String[] opciones = { "Conversor de Divisas", "Conversor de Temperatura" };

		JComboBox<String> comboBox = new JComboBox<>(opciones);
		comboBox.setSelectedIndex(0);

		int result = JOptionPane.showConfirmDialog(null, comboBox, "Selecciona un tipo de conversor:",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			int seleccion = comboBox.getSelectedIndex();

			if (seleccion == 0) {
				crearYMostrarInterfazConversor("Conversor de Divisas", UnidadesUtil.getArrayDivisas());
			} else if (seleccion == 1) {
				crearYMostrarInterfazConversor("Conversor de Temperatura", UnidadesUtil.getArrayUnidadesTemperatura());
			}
		}
	}

	private static void crearYMostrarInterfazConversor(String titulo, Unidad[] unidades) {
		JFrame frame = new JFrame(titulo);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);

		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		contentPanel.setLayout(new BorderLayout());

		JLabel labelCantidad = new JLabel("Cantidad a convertir:");
		JTextField txtCantidad = new JTextField(10);

		JLabel labelUnidadOrigen = new JLabel("Convertir de:");
		JComboBox<Unidad> UnidadOrigenCB = new JComboBox<>(unidades);

		JLabel labelUnidadDestino = new JLabel("Convertir a:");
		JComboBox<Unidad> UnidadDestinoCB = new JComboBox<>(unidades);
		UnidadDestinoCB.setSelectedIndex(1);
		
		JButton botonConvertir = new JButton("Convertir");
		JButton botonVolver = new JButton("Volver");
		JLabel labelResultado1 = new JLabel(""); // etiqueta donde se mostrará "Resultado:"
		JLabel labelResultado2 = new JLabel(""); // etiqueta donde se mostrará el resultado de conversión

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(4, 2));
		topPanel.add(labelCantidad);
		topPanel.add(txtCantidad);
		topPanel.add(labelUnidadOrigen);
		topPanel.add(UnidadOrigenCB);
		topPanel.add(labelUnidadDestino);
		topPanel.add(UnidadDestinoCB);
		topPanel.add(labelResultado1);
		topPanel.add(labelResultado2);

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(botonConvertir);
		bottomPanel.add(botonVolver);

		botonConvertir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String unidadOrigen = ((Unidad) UnidadOrigenCB.getSelectedItem()).getSimbolo();
				String unidadDestino = ((Unidad) UnidadDestinoCB.getSelectedItem()).getSimbolo();

				try {
					double cantidad = Double.parseDouble(txtCantidad.getText());

					double resultado = 0;
					if (titulo.contains("Divisa")) {
						resultado = ConversorDivisas.convertirDivisas(unidadOrigen, unidadDestino, cantidad);
					} else if (titulo.contains("Temperatura")) {
						resultado = ConversorTemperatura.convertirTemperatura(unidadOrigen, unidadDestino, cantidad);
					}

					labelResultado1.setText("Resultado:");
					labelResultado2.setText(
							String.format("%.2f %s = %.2f %s", cantidad, unidadOrigen, resultado, unidadDestino));
				} catch (NumberFormatException ex) {
					labelResultado2.setText("Cantidad no válida");
				} catch (IllegalArgumentException ex) {
					labelResultado2.setText("Unidad no válida");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mostrarMenuSeleccionConversor();
			}
		});

		contentPanel.add(topPanel, BorderLayout.CENTER);
		contentPanel.add(bottomPanel, BorderLayout.SOUTH);

		frame.add(contentPanel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	
}
