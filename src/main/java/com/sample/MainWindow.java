package com.sample;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	public JPanel questionPanel;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainWindow frame = new MainWindow();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 610);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(531, 84, 393, 477);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 914, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Virtual Medicine Doctor");
		lblNewLabel.setBounds(385, 23, 191, 14);
		panel_1.add(lblNewLabel);
		
		questionPanel = new JPanel();
		questionPanel.setBounds(10, 84, 511, 393);
		contentPane.add(questionPanel);
		questionPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 488, 511, 73);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
	}
}