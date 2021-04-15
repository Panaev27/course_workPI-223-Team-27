package rgr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class MainForm extends Form {
	
	Calculator calc = new Calculator();//��������� ������������
	TXTWriter intoTXT = new TXTWriter(new File(MainForm.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+File.separator+"Output.txt");
	HTMLWriter intoHtml = new HTMLWriter(new File(MainForm.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+File.separator+"Output.html");//��������� ��� ������ � ����
	//������ ����, � ������� ������������ ������ �������� ������
	JTextField inputHeight;
	JTextField inputLength;
	JTextField inputWidth;
	JTextField inputPeriod;
	JComboBox<String> combo_buildType;
	JComboBox<String> combo_buildForm;
	JComboBox<String> combo_fundament;
	JComboBox<String> combo_doors;
	JTextField inputPromo;
	JTextField output;
	JComboBox<String> combo_panelVid;
	String outputText = "===================================== %%1$s"
			+ "������: %s %%1$s"
			+ "������: %s %%1$s"
			+ "�����: %s %%1$s"
			+ "��� �������������: %s %%1$s"
			+ "����� ������: %s %%1$s"
			+ "��� ������: %s %%1$s"
			+ "�����: %s %%1$s"
			+ "���������: %s %%1$s"
			+ "�����: %s %%1$s"
			+ "��������: %s %%1$s"
			+ "�������� �����: %s %%1$s";//����� ������ � ����
	
	public MainForm() {
		setup();
		
		JMenuBar menu = new JMenuBar(); //������ ������� ����
		JMenu menuMain = new JMenu("�������"); //������ ������� ����
		JMenuItem menuExit = new JMenuItem("�����"); //������ ������ �����
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				}
			});
		JMenuItem menuAboutDev = new JMenuItem("������������");//������ ������ ������ ����������
		menuAboutDev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InfoForm info = new InfoForm();
				}
			});
		JMenuItem menuSaveTxt = new JMenuItem("���������� � txt");//������ ������ ���������� � txt ����
		JMenuItem menuSaveHtml = new JMenuItem("���������� � html");//������ ������ ���������� � html ����
		//��������� ���� � ������� ����
		menu.add(menuMain);
		menuMain.add(menuSaveTxt);
		menuMain.add(menuSaveHtml);
		menuMain.add(menuAboutDev);
		menuMain.add(menuExit);
		
		Frame.setJMenuBar(menu);//��������� ������� ���� � �����
		
		JLabel heightLabel = new JLabel("������: "); // ����������� ������
		heightLabel.setBounds(20,10,50,30);
		mainPanel.add(heightLabel);
		inputHeight = new JTextField("3"); // ����������� ���� �����
		inputHeight.setBounds(70,10,40,30);
		mainPanel.add(inputHeight);
		
		JLabel lengthLabel = new JLabel("�����: "); // ����������� ������
		lengthLabel.setBounds(130,10,50,30);
		mainPanel.add(lengthLabel);
		inputLength = new JTextField("5"); // ����������� ���� �����
		inputLength.setBounds(175,10,40,30);
		mainPanel.add(inputLength);
		
		JLabel widthLabel = new JLabel("������: "); // ����������� ������
		widthLabel.setBounds(240,10,60,30);
		mainPanel.add(widthLabel);
		inputWidth = new JTextField("5"); // ����������� ���� �����
		inputWidth.setBounds(295,10,40,30);
		mainPanel.add(inputWidth);
		
		JLabel buildTypeLabel = new JLabel("�������� ��� ������������� ������: "); // ����������� ������
		buildTypeLabel.setBounds(20,40,250,30);
		mainPanel.add(buildTypeLabel);
		String[] combo_strings = {"��������-��������", "��������-�������"}; // ������ �����-����
		combo_buildType = new JComboBox<String>(combo_strings);
		combo_buildType.setBounds(20,70,200,30);
		mainPanel.add(combo_buildType);
		
		JLabel buildFormLabel = new JLabel("�������� ����� ������: "); // ����������� ������
		buildFormLabel.setBounds(20,105,250,30);
		mainPanel.add(buildFormLabel);
		combo_strings = new String[]{"�������", "������������", "��������"}; // ������ �����-����
		combo_buildForm = new JComboBox<String>(combo_strings);
		combo_buildForm.setBounds(20,135,200,30);
		combo_buildForm.addActionListener(new ActionListener() {//��������� ������ ��� ������� �����
			@Override
			public void actionPerformed(ActionEvent e) {
				if (combo_buildForm.getSelectedIndex()==0) {
					inputHeight.setEditable(false);
					inputHeight.setText("1");
				} else {
					inputHeight.setEditable(true);
				}
				}
			});
		combo_buildForm.getActionListeners()[0].actionPerformed(new ActionEvent(combo_buildForm, 0, null));//�������� ���������� ������ ��� ������� �����
		mainPanel.add(combo_buildForm);
		
		JLabel panelVidLabel = new JLabel("�������� ��� ������: "); // ����������� ������
		panelVidLabel.setBounds(20,170,250,30);
		mainPanel.add(panelVidLabel);
		combo_strings = new String[]{"����������� �������-������", "�������-������", "��������� �������-������"}; // ������ �����-����
		combo_panelVid = new JComboBox<String>(combo_strings);
		combo_panelVid.setBounds(20,200,200,30);
		mainPanel.add(combo_panelVid);
		
		JLabel periodLabel = new JLabel("�������� �����(���.): "); // ����������� ������
		periodLabel.setBounds(20,240,200,30);
		mainPanel.add(periodLabel);
		inputPeriod = new JTextField("7");  // ����������� ���� �����
		inputPeriod.setBounds(160,240,40,30);
		mainPanel.add(inputPeriod);
		
		JLabel fundamentLabel = new JLabel("�������� ���������: "); // ����������� ������
		fundamentLabel.setBounds(20,280,200,30);
		mainPanel.add(fundamentLabel);
		combo_strings = new String[]{"����������", "��������", "��������������", "��������"}; // ������ �����-����
		combo_fundament = new JComboBox<String>(combo_strings);
		combo_fundament.setBounds(20,310,200,30);
		mainPanel.add(combo_fundament);
		
		JLabel doorsLabel = new JLabel("�������� ��� �����: "); // ����������� ������
		doorsLabel.setBounds(20,350,200,30);
		mainPanel.add(doorsLabel);
		combo_strings = new String[]{"���������", "��������-����������", "�������", "��������"}; // ������ �����-����
		combo_doors = new JComboBox<String>(combo_strings);
		combo_doors.setBounds(20,380,200,30);
		mainPanel.add(combo_doors);
		
		JLabel promoLabel = new JLabel("��������: "); // ����������� ������
		promoLabel.setBounds(20,430,200,30);
		mainPanel.add(promoLabel);
		inputPromo = new JTextField(""); // ����������� ���� �����
		inputPromo.setBounds(90,430,200,30);
		mainPanel.add(inputPromo);
		
		JLabel calcLabel = new JLabel("�������� �����: "); // ����������� ������
		calcLabel.setBounds(20,470,200,30);
		mainPanel.add(calcLabel);
		output = new JTextField(""); // ����������� ���� �����
		output.setBounds(120,470,150,30);
		output.setEditable(false); //��������� ��������������, ����� ������� ���� ������
		mainPanel.add(output);
		
		JButton button_calc = new JButton("����������"); // ������ ������ ������ ��������
		button_calc.setBounds(20,550,120,50);
		button_calc.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				startCalc();
				}
			});
		mainPanel.add(button_calc);
		//������ ��������� ��� ������  � ����: "���������� � ����"
		menuSaveTxt.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ ��������� �������, ���� ������������ ��� �������� ��������
				if (startCalc()) {
					//��������� ������ ��� ������. %%1$s ��� �������� ������
					String forWrite = "";
					forWrite=String.format("===================================== %%1$s"
							+ "������: %s %%1$s"
							+ "������: %s %%1$s"
							+ "�����: %s %%1$s"
							+ "��� �������������: %s %%1$s"
							+ "����� ������: %s %%1$s"
							+ "��� ������: %s %%1$s"
							+ "�����: %s %%1$s"
							+ "���������: %s %%1$s"
							+ "�����: %s %%1$s"
							+ "��������: %s %%1$s"
							+ "�������� �����: %s %%1$s"
							,inputHeight.getText(), inputWidth.getText(),inputLength.getText(),combo_buildType.getSelectedItem(),combo_buildForm.getSelectedItem(), combo_panelVid.getSelectedItem(), inputPeriod.getText(), combo_fundament.getSelectedItem(),combo_doors.getSelectedItem(),inputPromo.getText(),output.getText());
					//������� � ����
					intoTXT.append(forWrite);
					createDialog("��� ��������� ������� � ����������� ������� � ����", true);
					}
				}
			});
		menuSaveHtml.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ ��������� �������, ���� ������������ ��� �������� ��������
				if (startCalc()) {
					//��������� ������ ��� ������. %%1$s ��� �������� ������
					String forWrite = "";
					forWrite=String.format(outputText
							,inputHeight.getText(), inputWidth.getText(),inputLength.getText(),combo_buildType.getSelectedItem(),combo_buildForm.getSelectedItem(), combo_panelVid.getSelectedItem(), inputPeriod.getText(), combo_fundament.getSelectedItem(),combo_doors.getSelectedItem(),inputPromo.getText(),output.getText());
					//������� � ����
					intoHtml.append(forWrite);
					createDialog("��� ��������� ������� � ����������� ������� � ����", true);
					}
				}
			});
		//������ ����� �������
		Frame.setVisible(true);
	}
	
	//����� ��� �������������� ���������
	private void setup() {
		// �������� ������������ ����
		Frame = new JFrame("����������� �������� ���� ������");
		Frame.setBounds(500,200,380,700);
		Frame.setResizable(false); // ������������� ������ ����
		
		//������ ������ ��� ����������� �����������
		mainPanel = new JPanel(); 
		mainPanel.setLayout(null);
		Frame.add(mainPanel);
		
		//������ ������ ������
		JButton btnExit = new JButton("�����");
		btnExit.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				}
			});
		btnExit.setBounds(220,550,120,50);
		mainPanel.add(btnExit);
		
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//����� ��� �������� ���������� ����
	
	
	//�������� ��������. ���������� true ��� ������, false ��� �������
	private boolean startCalc() {
		// ��������� ����
		if (calc.isInteger(inputPeriod.getText()) && calc.isDouble(inputLength.getText()) && calc.isDouble(inputWidth.getText())&& calc.isDouble(inputHeight.getText())) {
			int period = Integer.parseInt(inputPeriod.getText());
			double length = Double.parseDouble(inputLength.getText());
			double width = Double.parseDouble(inputWidth.getText());
			double height = Double.parseDouble(inputHeight.getText());
			//��������� �� ������������� ��������
			if (period>0&&length>0&&width>0&&height>0) {
				double price = calc.CalculateHangarCost(combo_doors.getSelectedIndex(), period, length, width, height, combo_buildType.getSelectedIndex(), combo_fundament.getSelectedIndex(), combo_buildForm.getSelectedIndex(), inputPromo.getText(), combo_panelVid.getSelectedIndex());
				price = Math.floor(price*100)/100;
				//������� � ����
				output.setText(String.valueOf(price));
				return true;
				} else {
				JDialog dialog = createDialog("������� ������� ���������!", true);
				JLabel label = new JLabel("��������� �� ������ ���� ��������������!");
				label.setBounds(1, 1, 100, 40);
				dialog.add(label);
				dialog.setVisible(true);
				return false;
			}
			
			} else {
				JDialog dialog = createDialog("������� ������� ���������!", true);
				JLabel label = new JLabel("������� ������� ���������!");
				label.setBounds(1, 1, 100, 40);
				dialog.add(label);
				dialog.setVisible(true);
				return false;
			}
	}
}