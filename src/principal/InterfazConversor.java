package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilidades.UnidadesUtil.*;

class InterfazConversor extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel labelCantidad;
	private JTextField txtCantidad;
	private JLabel labelUnidadOrigen;
	private JLabel labelUnidadDestino;
    private JComboBox<Unidad> unidadOrigenCB;
    private JComboBox<Unidad> unidadDestinoCB;
    private JLabel labelResult;

    public InterfazConversor(Unidad[] unidades, ActionListener convertirListener) {
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setLayout(new BorderLayout());

        labelCantidad = new JLabel("Cantidad a convertir:");
        txtCantidad = new JTextField(10);

        labelUnidadOrigen = new JLabel("Convertir de:");
        unidadOrigenCB = new JComboBox<>(unidades);

        labelUnidadDestino = new JLabel("Convertir a:");
        unidadDestinoCB = new JComboBox<>(unidades);

        JButton botonVolver = new JButton("Volver");
        JButton botonConvertir = new JButton("Convertir");
        labelResult = new JLabel(""); // etiqueta donde se mostrará el resultado de conversión

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4, 2));
        topPanel.add(labelCantidad);
        topPanel.add(txtCantidad);
        topPanel.add(labelUnidadOrigen);
        topPanel.add(unidadOrigenCB);
        topPanel.add(labelUnidadDestino);
        topPanel.add(unidadDestinoCB);
        topPanel.add(labelResult);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(botonVolver);
        bottomPanel.add(botonConvertir);

        botonConvertir.addActionListener(convertirListener);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor(InterfazConversor.this).dispose();
                Principal.mostrarMenuSeleccionConversor();
            }
        });

        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public double getCantidad() {
        try {
            return Double.parseDouble(txtCantidad.getText());
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }

    public Unidad getUnidadOrigen() {
        return (Unidad) unidadOrigenCB.getSelectedItem();
    }

    public Unidad getUnidadDestino() {
        return (Unidad) unidadDestinoCB.getSelectedItem();
    }

    public void setResultado(String resultado) {
        labelResult.setText(resultado);
    }
    
    
}

