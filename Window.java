import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener{
	private JTextField Name,numberCourse,feeTex;
	private JButton submit,clear;
	private JRadioButton home,overseas;
	private JPanel panel,panelRadiobtn,panelNumCourse,panelbtn,panelFee;

	public Window() {
		setSize(500,300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		//first part :
		panel = new JPanel();
		panel.add(new JLabel("Enter Name :"));
		Name = new JTextField(15);
		panel.add(Name);
		
		//second part(radio buttons)
		home = new JRadioButton("Home");
		overseas = new JRadioButton("Overseas");
		ButtonGroup radiobtn = new ButtonGroup();
		radiobtn.add(home);
		radiobtn.add(overseas);
		panelRadiobtn = new JPanel();
		panelRadiobtn.add(home);
		panelRadiobtn.add(overseas);
		
		// part 3:
		panelNumCourse = new JPanel();
		panelNumCourse.add(new JLabel("Number of Courses:"));
		numberCourse = new JTextField(11);
		panelNumCourse.add(numberCourse);
		//part buttons:
		submit = new JButton("Submit");
		submit.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		panelbtn = new JPanel();
		panelbtn.add(submit);
		panelbtn.add(clear);
		//part 4:
		panelFee = new JPanel();
		panelFee.add(new JLabel("Fee"));
		feeTex = new JTextField(20);
		feeTex.setEditable(false);
		panelFee.add(feeTex);
		
		
		
		
				
		
		add(panel);
		add(panelRadiobtn);
		add(panelNumCourse);
		add(panelbtn);
		add(panelFee);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		Window form = new Window();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==submit) {
			Name.getText();
			DecimalFormat format = new DecimalFormat("$###,##,#00");
			int noc = Integer.parseInt(numberCourse.getText());
			Boolean homecl = home.isSelected();
			CalculateFee fee = new CalculateFee(getName(), noc, homecl);
			double x = fee.calfee();
			feeTex.setText(format.format(x));
			
		}
		if (e.getSource()==clear) {
			Name.setText(" ");
			feeTex.setText(" ");
			numberCourse.setText(" ");
			
		}
		
		
	}


}
