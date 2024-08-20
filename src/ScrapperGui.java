import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class ScrapperGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrapperGui frame = new ScrapperGui();
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
	public ScrapperGui() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 806, 613);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(238, 243, 12));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JTextField txtEnterACar = new JTextField();
	        txtEnterACar.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		 txtEnterACar.setText("");
	        	}
	        });
	        txtEnterACar.setText("Enter a car brand...");
	       
	        txtEnterACar.setToolTipText("");
	        txtEnterACar.setBounds(235, 151, 182, 19);
	        contentPane.add(txtEnterACar);
	        txtEnterACar.setColumns(10);

	        JLabel lblNewLabel = new JLabel("USED CAR FINDER");
	        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
	        lblNewLabel.setBounds(279, 25, 213, 114);
	        contentPane.add(lblNewLabel);

	        JTextArea resultArea = new JTextArea();
	        resultArea.setText("The results will be here soon");
	        resultArea.setBounds(40, 206, 719, 342);
	        contentPane.add(resultArea);
	        resultArea.setEditable(false);

	        JCheckBox chckbxNewCheckBox = new JCheckBox("Detailed");
	        chckbxNewCheckBox.setSelected(true);
	        chckbxNewCheckBox.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        chckbxNewCheckBox.setBounds(542, 150, 85, 21);
	        contentPane.add(chckbxNewCheckBox);
	        
	        JButton btnNewButton = new JButton("Enter");
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String brand = txtEnterACar.getText();
	                ScrapperMain scrapper = new ScrapperMain();
	                try {
	               
	                    String result = scrapper.scrapeData(brand, true);
	                    resultArea.setText(result);
	                } catch (IOException ex) {
	                    resultArea.setText("An error occurred while scraping the data.");
	                }
	            }
	        });
	        btnNewButton.setBounds(438, 150, 85, 21);
	        contentPane.add(btnNewButton);
	        
	
	        txtEnterACar.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    btnNewButton.doClick(); // Butona tıklama işlemi gerçekleştirir
	                }
	            }
	        });

	}
}
