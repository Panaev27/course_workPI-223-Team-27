package rgr;

import javax.swing.*;


public abstract class Form {
	JFrame Frame;
	JPanel mainPanel;
	
	
	//����� ��� ��������� ������ �� �����
	private void setup() {
			// JButton btnExit = new JButton("�����");
	}
			
	protected JDialog createDialog(String title, boolean modal) {
		JDialog dialog = new JDialog(Frame,title, modal);
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.setSize(200, 90);
	    dialog.setLocation(600,600);
	    return dialog;
	}
	public boolean getResisible() {
	    return Frame.isResizable();
	}
	
	

}
