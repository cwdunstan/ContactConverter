import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Choice;
import javax.swing.JProgressBar;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 

public class mainFrame {

	private JFrame frame;
	private JLabel lblContactConverter;
	private Choice outputChoice;
	private JTextField sourceField;
	private JTextField destField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame window = new mainFrame();
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
	public mainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 583, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				converter newConverter = new converter(sourceField.getText(),destField.getText());
				switch(outputChoice.getSelectedItem()) {
				case "CSV":
					newConverter.setOutput("CSV");
					break;
				case "VCARD":
					newConverter.setOutput("VCARD");
					break;
				case "VCARDs":
					newConverter.setOutput("VCARDS");
					break;
				}
				if(newConverter.convert()==0){
					lblContactConverter.setText("Contact Converted.");
				} else {
					lblContactConverter.setText("Contact Converter.");
				}
			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton.setBounds(236, 336, 89, 23);
		frame.getContentPane().add(btnNewButton);
		lblContactConverter = new JLabel("Contact Converter.");
		lblContactConverter.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblContactConverter.setBounds(201, 53, 176, 27);
		frame.getContentPane().add(lblContactConverter);
		
		sourceField = new JTextField();
		sourceField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    sourceField.setText(selectedFile.getPath());
				}
			}
		});

		sourceField.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		sourceField.setBounds(134, 130, 290, 23);
		frame.getContentPane().add(sourceField);
		sourceField.setColumns(10);
		
		destField = new JTextField();
		destField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    destField.setText(selectedFile.getPath());
				}
			}
		});
		destField.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		destField.setBounds(134, 194, 290, 23);
		frame.getContentPane().add(destField);
		destField.setColumns(10);
		
		JLabel lblSource = new JLabel("Source File");
		lblSource.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblSource.setBounds(134, 116, 69, 14);
		frame.getContentPane().add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblDestination.setBounds(134, 181, 69, 14);
		frame.getContentPane().add(lblDestination);
		
		outputChoice = new Choice();
		outputChoice.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		outputChoice.setBounds(236, 265, 89, 26);
		outputChoice.add("CSV");
		outputChoice.add("VCARD");
		outputChoice.add("VCARDs");
		frame.getContentPane().add(outputChoice);
		
		JLabel lblOutputType = new JLabel("Output Type");
		lblOutputType.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblOutputType.setBounds(236, 239, 97, 28);
		frame.getContentPane().add(lblOutputType);
	}
}
