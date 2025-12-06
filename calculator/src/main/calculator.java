package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ISLEM;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator frame = new calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton AC_C = new JButton("AC");
		AC_C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ISLEM.setText("");
				
			}
			
			
		});
		AC_C.setBounds(10, 213, 80, 40);
		contentPane.add(AC_C);

		JButton X = new JButton("X");
		X.setBounds(109, 213, 80, 40);
		contentPane.add(X);

		JButton kes = new JButton("%");
		kes.setBounds(221, 213, 80, 40);
		contentPane.add(kes);

		JButton bol = new JButton("/");
		bol.setBounds(329, 213, 80, 40);
		contentPane.add(bol);

		JButton carp = new JButton("*");
		carp.setBounds(329, 259, 80, 40);
		contentPane.add(carp);

		JButton cıkar = new JButton("-");
		cıkar.setBounds(329, 308, 80, 40);
		contentPane.add(cıkar);

		JButton top = new JButton("+");
		top.setBounds(329, 354, 80, 40);
		contentPane.add(top);

		JButton sonuc = new JButton("=");
		sonuc.setBounds(329, 403, 80, 40);
		contentPane.add(sonuc);

		JButton yedı = new JButton("7");
		yedı.setBounds(10, 259, 80, 40);
		contentPane.add(yedı);

		JButton sekız = new JButton("8");
		sekız.setBounds(109, 259, 80, 40);
		contentPane.add(sekız);

		JButton dokuz = new JButton("9");
		dokuz.setBounds(221, 259, 80, 40);
		contentPane.add(dokuz);

		JButton dort = new JButton("4");
		dort.setBounds(10, 308, 80, 40);
		contentPane.add(dort);

		JButton bes = new JButton("5");
		bes.setBounds(109, 308, 80, 40);
		contentPane.add(bes);

		JButton altı = new JButton("6");
		altı.setBounds(221, 308, 80, 40);
		contentPane.add(altı);

		JButton bır = new JButton("1");
		bır.setBounds(10, 354, 80, 40);
		contentPane.add(bır);

		JButton ıkı = new JButton("2");
		ıkı.setBounds(109, 354, 80, 40);
		contentPane.add(ıkı);

		JButton uc = new JButton("3");
		uc.setBounds(221, 354, 80, 40);
		contentPane.add(uc);

		JButton sıfır = new JButton("0");
		sıfır.setBounds(109, 403, 80, 40);
		contentPane.add(sıfır);

		JButton vılgul = new JButton(",");
		vılgul.setBounds(221, 403, 80, 40);
		contentPane.add(vılgul);

		ISLEM = new JTextField();
		ISLEM.setBounds(10, 11, 412, 156);
		contentPane.add(ISLEM);
		ISLEM.setColumns(10);

		// 🔢 Sayı butonları için listener
		sıfır.addActionListener(sayilistener);
		bır.addActionListener(sayilistener);
		ıkı.addActionListener(sayilistener);
		uc.addActionListener(sayilistener);
		dort.addActionListener(sayilistener);
		bes.addActionListener(sayilistener);
		altı.addActionListener(sayilistener);
		yedı.addActionListener(sayilistener);
		sekız.addActionListener(sayilistener);
		dokuz.addActionListener(sayilistener);

		// ➕➖✖️➗ Operatör butonları için listener
		top.addActionListener(operatorlistener);
		cıkar.addActionListener(operatorlistener);
		carp.addActionListener(operatorlistener);
		bol.addActionListener(operatorlistener);
		sonuc.addActionListener(operatorlistener);
	}

	
	ActionListener sayilistener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton kaynak = (JButton) e.getSource();
			String yazı = kaynak.getText();
			ISLEM.setText(ISLEM.getText() + yazı);
		}
	};

	
	ActionListener operatorlistener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton kaynak = (JButton) e.getSource();
			String operator = kaynak.getText();

			switch (operator) {
				case "+":
					ISLEM.setText(ISLEM.getText() + " + ");
					break;
				case "-":
					ISLEM.setText(ISLEM.getText() + " - ");
					break;
				case "*":
					ISLEM.setText(ISLEM.getText() + " * ");
					break;
				case "/":
					ISLEM.setText(ISLEM.getText() + " / ");
					break;
				case "=":
				    try {
				        String ifade = ISLEM.getText().trim();

				        
				        ifade = ifade.replace(" ", "");

				       
				        double sonuc = 0;
				        if (ifade.contains("+")) {
				            String[] sayilar = ifade.split("\\+");
				            sonuc = Double.parseDouble(sayilar[0]) + Double.parseDouble(sayilar[1]);
				        } else if (ifade.contains("-")) {
				            String[] sayilar = ifade.split("\\-");
				            sonuc = Double.parseDouble(sayilar[0]) - Double.parseDouble(sayilar[1]);
				        } else if (ifade.contains("*")) {
				            String[] sayilar = ifade.split("\\*");
				            sonuc = Double.parseDouble(sayilar[0]) * Double.parseDouble(sayilar[1]);
				        } else if (ifade.contains("/")) {
				            String[] sayilar = ifade.split("\\/");
				            sonuc = Double.parseDouble(sayilar[0]) / Double.parseDouble(sayilar[1]);
				        }

				        ISLEM.setText(String.valueOf(sonuc));

				    } catch (Exception ex) {
				        ISLEM.setText("Hata!");
				    }
				    break;
			}
		}
	};
}


		 
		 
		 
	 

	
	 
	

