package zdarzeniowka;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUI{

	private JFrame frame;
	private JAddPanel addPanel;
	private JSearchPanel searchPanel;
	private JDSPanel dsPanel;
	private JReportPanel reportPanel;
	private JTabbedPane tabbedPane;
	private Font header, normal, italic;
	
	private void initiate(){
		File fontFile1 = new File("font/OpenSans-Regular.ttf"),
				fontFile2 = new File("font/OpenSans-Italic.ttf");
		try {
			Font fontH = Font.createFont(Font.TRUETYPE_FONT, fontFile1);
			header = fontH.deriveFont(20f);
			Font fontN = Font.createFont(Font.TRUETYPE_FONT, fontFile1);
			normal = fontN.deriveFont(13f);
			Font fontI = Font.createFont(Font.TRUETYPE_FONT, fontFile2);
			italic = fontI.deriveFont(10f);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setFont(normal);
		dsPanel = new JDSPanel(normal);
		addPanel= new JAddPanel(normal);
		searchPanel = new JSearchPanel(normal);
		reportPanel = new JReportPanel(normal);
		frame.setLayout(new GridBagLayout());
		
	}
	
	public void addComponents(){
		initiate();
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel topPane = new JPanel();
		JLabel label = new JLabel("Jestem ładnym programem.");
		JLabel label2 = new JLabel("Version 1. beta");
		label.setFont(header);
		label2.setFont(italic);
		topPane.setLayout(new GridBagLayout());

		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.insets = new Insets(0, 3, 0, 0);
		topPane.add(label, c);
		c.gridy = 1;
		topPane.add(label2,c);
		c.gridy = 0;
		frame.add(topPane, c);
	
		tabbedPane.add("Plan DS", dsPanel);	
		tabbedPane.add("Dodaj", addPanel);
		tabbedPane.add("Wyszukaj", searchPanel);
		tabbedPane.add("Raporty", reportPanel);
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 0);
		frame.add(tabbedPane, c);
	}
	
	public void showGUI(){
		frame = new JFrame("System ewidencyjny sieci komputerowej w DS - AC&DW"); 
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icons/cat.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize((new Dimension(600, 500))); 
		frame.setLocation(250, 50);
		
		addComponents();
		
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);		
	}
}
