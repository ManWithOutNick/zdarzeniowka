package zdarzeniowka;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JNetworkDevicePanel extends JBasicPanel  {
	private static final long serialVersionUID = 8913270095466798762L;
	
	public JNetworkDevicePanel() {super();
	this.setLayout(new GridBagLayout());
	labels = new JLabel[6];
	textFields = new JTextField[3];
	textArea = new JTextArea();
    textArea.setLineWrap(true);
    textArea.setEditable(editable);
    scrollPane = new JScrollPane(textArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setPreferredSize(new Dimension(322, 130));
	String[] stringLabel = {"Adres MAC:", "Adres IP:", "Konfiguracja:", "Typ:", "Id urzadzenia:", "Uwagi:"},
			configuration = {"0", "1"}, type = {"Komputer", "Switch", "Serwer", "Router", "AP", "Inne"};
	cb = new JComboBox[2];
	cb[0] = new JComboBox<String>(configuration);
	cb[1] = new JComboBox<String>(type);
	for(int i = 0; i < 6; i++){
		if (i < 3){
			if (i < 2){
				textFields[i] = new JTextField(28);	
				cb[i].setPrototypeDisplayValue("Such wow w");
				cb[i].setFont(normal);
				cb[i].setEnabled(editable);
			}
			else {
				textFields[i] = new JTextField(8);
			}
			textFields[i].setFont(normal);
			textFields[i].setEditable(editable);
			}
		labels[i] = new JLabel(stringLabel[i]);
		labels[i].setFont(normal);		
	}
	for (int i = 0; i < 2; i++){
    	ctop.insets = insets0;
		ctop.gridwidth = 1;
    	ctop.anchor = GridBagConstraints.LINE_END;
		ctop.gridx = 0;
		ctop.gridy = i;
		ctop.ipady = 0;
		topPanel.add(labels[i], ctop);
		ctop.insets = insets1;
		ctop.ipady = 6;
		ctop.anchor = GridBagConstraints.LINE_START;
		ctop.gridx = 1;
		ctop.gridwidth = 4;
		topPanel.add(textFields[i], ctop);
	}
	cbot.insets = insets0;
	cbot.anchor = GridBagConstraints.LINE_END;
	cbot.gridx = 0;
	cbot.gridy = 2;
	cbot.ipady = 0;
	botPanel.add(labels[2], cbot);
	cbot.insets = insets1;
	cbot.anchor = GridBagConstraints.LINE_START;
	cbot.gridx = 1;
	cbot.ipady = 6;
	botPanel.add(cb[0], cbot);	
	cbot.anchor = GridBagConstraints.LINE_END;
	cbot.gridx = 2;
	cbot.ipady = 0;
	botPanel.add(labels[3], cbot);
	cbot.anchor = GridBagConstraints.LINE_START;
	cbot.gridx = 3;
	cbot.ipady = 6;
	botPanel.add(cb[1], cbot);
	
	cbot.insets = insets0;
	cbot.anchor = GridBagConstraints.LINE_END;
	cbot.gridx = 0;
	cbot.gridy = 3;
	cbot.ipady = 0;
	botPanel.add(labels[4], cbot);
	cbot.insets = insets1;
	cbot.anchor = GridBagConstraints.LINE_START;
	cbot.gridwidth = 3;
	cbot.gridx = 1;
	cbot.ipady = 6;
	botPanel.add(textFields[2], cbot);	
	
	cbot.insets = new Insets(20,0,10,0);
	cbot.anchor = GridBagConstraints.LINE_END;
	cbot.gridx = 0;
	cbot.gridy = 4;
	cbot.ipady = 0;
	cbot.gridwidth = 1;
	botPanel.add(labels[5], cbot);
	cbot.insets = new Insets(20,20,10,0);
	cbot.anchor = GridBagConstraints.LINE_START;
	cbot.gridx = 1;
	cbot.gridwidth = 3;
	botPanel.add(scrollPane, cbot);	
	
	cpane.anchor = GridBagConstraints.CENTER;
	cpane.gridx = 0;
	this.add(topPanel, cpane);
	cpane.gridy = 1;
	cpane.insets = new Insets(20,0,0,12);
	this.add(botPanel, cpane);	

	}

}
