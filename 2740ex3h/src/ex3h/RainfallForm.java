package ex3h;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JLabel label;
	private JLabel label_2;
	private String [] strRainfall = {"1.2","2.7", "2.2", "3.1","2.9","5.1",
			"3.2","2.7","3.6","1.8","2.2","1.7"};

	private String [] Rainfall;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
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
	public RainfallForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly Rainfall");
		lblMonthlyRainfall.setBounds(10, 11, 93, 14);
		contentPane.add(lblMonthlyRainfall);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 36, 48, 231);
		contentPane.add(scrollPane);
		
		JList monthList = new JList();
		monthList.setBackground(UIManager.getColor("Label.background"));
		monthList.setEnabled(false);
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sep", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(monthList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(68, 36, 48, 231);
		contentPane.add(scrollPane_1);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setBorder(UIManager.getBorder("TextField.border"));
		scrollPane_1.setViewportView(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(165, 40, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setBounds(165, 70, 46, 14);
		contentPane.add(lblAverage);
		
		JLabel lblMaxium = new JLabel("Maximum");
		lblMaxium.setBounds(165, 100, 46, 14);
		contentPane.add(lblMaxium);
		
		JLabel lblMinimum = new JLabel("Minimum");
		lblMinimum.setBounds(165, 130, 46, 14);
		contentPane.add(lblMinimum);
		
		lblNewLabel = new JLabel("0.0");
		lblNewLabel.setLabelFor(lblTotal);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(225, 35, 46, 26);
		lblNewLabel.setBorder(UIManager.getBorder("TextField.border"));
		contentPane.add(lblNewLabel);
		
		label = new JLabel("0.0");
		label.setLabelFor(lblMaxium);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBorder(UIManager.getBorder("TextField.border"));
		label.setBounds(225, 95, 46, 26);
		contentPane.add(label);
		
		label_1 = new JLabel("0.0");
		label_1.setLabelFor(lblAverage);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBorder(UIManager.getBorder("TextField.border"));
		label_1.setBounds(225, 65, 46, 26);
		contentPane.add(label_1);
		
		label_2 = new JLabel("0.0");
		label_2.setLabelFor(lblMinimum);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBorder(UIManager.getBorder("TextField.border"));
		label_2.setBounds(225, 125, 46, 26);
		contentPane.add(label_2);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCalculate_actionPerformed(arg0);
			}
		});
		btnCalculate.setBounds(182, 176, 89, 23);
		contentPane.add(btnCalculate);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setText("0.0");
		textField.setBounds(68, 295, 37, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNewButton_actionPerformed(arg0);
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(52, 326, 75, 23);
		contentPane.add(btnNewButton);
	}
	
	protected void do_btnCalculate_actionPerformed(ActionEvent arg0) {
		rainfall rainfall = new rainfall(strRainfall);
		
		DecimalFormat fmt = new DecimalFormat("0.0");
		lblNewLabel.setText(fmt.format(rainfall.getTotal2()));
		label_1.setText(fmt.format(rainfall.getAverage2()));
		label.setText(fmt.format(rainfall.getHighest2()));
		label_2.setText(fmt.format(rainfall.getLowest2()));
	}
	
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		btnNewButton.setEnabled(true);
		textField.setEnabled(true);
		textField.setText((String) rainfallList.getSelectedValue());
		textField.requestFocus();
		textField.selectAll();		
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		int selectedIndex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(textField.getText());
		strRainfall[selectedIndex] = Double.toString(r);
		rainfallList.repaint();
		
		textField.setText("0.0");
		btnNewButton.setEnabled(false);
		textField.setEnabled(false);
		lblNewLabel.setText("0.0");
		label_1.setText("0.0");
		label.setText("0.0");
		label_2.setText("0.0");
		
		rainfallList.clearSelection();
		btnNewButton.setEnabled(false);
		textField.setEnabled(false);
	}
}
