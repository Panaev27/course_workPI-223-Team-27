package rgr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InfoForm extends Form {

    public InfoForm() {
        setup();
        JLabel infoLabel = new JLabel("<html> ������������:<br>"
                + "������ �.�. - ����� �������� ������: 19130630; <br>"
                + "�������� �.�. - ����� �������� ������: 19130619;<br>"
                + "ĸ��� �.�. - ����� �������� ������: 19130602. </html>");
        infoLabel.setBounds(0,0,400,100);
        mainPanel.add(infoLabel);
        Frame.setVisible(true);
    }

    private void setup() {
        Frame = new JFrame("���������� � �������������");
        Frame.setBounds(500,200,380,200);
        Frame.setResizable(false); 

        mainPanel = new JPanel(); 
        mainPanel.setLayout(null);
        Frame.add(mainPanel);

        JButton btnExit = new JButton("�����");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.dispose();
                }
            });
        btnExit.setBounds(100,100,120,50);
        mainPanel.add(btnExit);

        Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public boolean getResisible() {
		return Frame.isResizable();
 
    }
}