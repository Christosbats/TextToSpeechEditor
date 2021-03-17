package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

import model.Document;

public class TuneAudio implements ActionListener {
	
	private Document document;
	
	private int volume;
	private int rate;
	private int pitch;
	public TuneAudio(Document document) {
		
		this.document = document;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		
		JLabel label1 = new JLabel("Volume");
		myPanel.add(label1);
		JSlider slider1 = new JSlider(JSlider.HORIZONTAL,0,100,50);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(0, new JLabel("0") );
		labelTable.put(100, new JLabel("100") );
		slider1.setLabelTable( labelTable );
		slider1.setPaintLabels(true);
		slider1.setMajorTickSpacing(100);
		slider1.setMinorTickSpacing(1);
		slider1.setPaintLabels(true);
		slider1.setPaintTicks(true);
		myPanel.add(slider1);
		
		
		JLabel label2 = new JLabel("Speech Rate");
		myPanel.add(label2);
		JSlider slider2 = new JSlider(JSlider.HORIZONTAL,0,300,150);
		Hashtable<Integer, JLabel> labelTable1 = new Hashtable<Integer, JLabel>();
		labelTable1.put(0, new JLabel("Slow") );
		labelTable1.put(300, new JLabel("Fast") );
		slider2.setLabelTable( labelTable1 );
		slider2.setPaintLabels(true);
		slider2.setMajorTickSpacing(100);
		slider2.setMinorTickSpacing(1);
		slider2.setPaintLabels(true);
		slider2.setPaintTicks(true);
		myPanel.add(slider2);
		
		
		JLabel label3 = new JLabel("Pitch");
		myPanel.add(label3);
		JSlider slider3 = new JSlider(JSlider.HORIZONTAL,0,200,100);
		Hashtable<Integer, JLabel> labelTable2 = new Hashtable<Integer, JLabel>();
		labelTable2.put(0, new JLabel("Low") );
		labelTable2.put(200, new JLabel("High") );
		slider3.setLabelTable( labelTable2 );
		slider3.setPaintLabels(true);
		slider3.setMajorTickSpacing(100);
		slider3.setMinorTickSpacing(1);
		slider3.setPaintLabels(true);
		slider3.setPaintTicks(true);
		myPanel.add(slider3);
		
		
		int result = JOptionPane.showConfirmDialog(null, myPanel, "Please enter the audio parameters",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			volume = slider1.getValue();
			rate = slider2.getValue();
			pitch = slider3.getValue();
			
			document.tuneDocumentAudio(volume, rate, pitch);

			
			
		}
		
	}

	public int getVolume() {
		return volume;
	}

	public int getRate() {
		return rate;
	}

	public int getPitch() {
		return pitch;
	}

	
}