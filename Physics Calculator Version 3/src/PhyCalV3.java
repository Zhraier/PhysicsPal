import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class PhyCalV3 extends JFrame implements ActionListener{
	
	JComboBox comboBox;
	//GRESA
	JLabel soltitle = new JLabel();
	JLabel given = new JLabel("Given");
	JLabel givenum = new JLabel();
	JLabel required = new JLabel("Required");
	JLabel requinum = new JLabel();
	JLabel solution = new JLabel("Solution");
	JLabel solut;
	JLabel solutop;
	JLabel solutop2 = new JLabel();
	JLabel solut1;
	JLabel solutop1;
	JLabel solutop3 = new JLabel();
	JLabel solcor;
	JLabel solcor2;
	JLabel answer2 = new JLabel();
	ImageIcon img = new ImageIcon(getClass().getResource("/Untitled.jpg"));
	JLabel background = new JLabel("",img,JLabel.CENTER);
	ImageIcon img2 = new ImageIcon(getClass().getResource("/Untitled2.jpg"));
	JLabel background2 = new JLabel("",img2,JLabel.CENTER);
	JPanel box = new JPanel();
	JPanel bbox = new JPanel();
	JPanel solbox = new JPanel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel find;
	JLabel find2;
	JLabel find3;
	JLabel equal;
	JLabel decor;
	JLabel decor2;
	JLabel name;
	JLabel sol = new JLabel("");
	JLabel form = new JLabel();
	JLabel mid = new JLabel();
	JLabel mid2 = new JLabel();
	JLabel top = new JLabel();
	JLabel top2 = new JLabel();
	JLabel bot = new JLabel();
	JRadioButton button1 = new JRadioButton();
	JRadioButton button2 = new JRadioButton();
	JRadioButton button3 = new JRadioButton();
	JLabel title = new JLabel("Physics Calculator");
	JLabel answer = new JLabel();
	//momentum
	JTextField momenum = new JTextField();
	JTextField mvelnum = new JTextField();
	JTextField massnum = new JTextField();
	//velocity
	JTextField velnum = new JTextField();
	JTextField dispnum = new JTextField();
	JTextField vtimenum = new JTextField();
	//power
	JTextField worknum = new JTextField();
	JTextField powernum = new JTextField();
	JTextField timenum = new JTextField();
	//capacitance
	JTextField cap1 = new JTextField();
	JTextField cap2 = new JTextField();
	JTextField cap3 = new JTextField();
	//amount of heat
	JTextField req = new JTextField();
	JTextField hmass = new JTextField();
	JTextField spec = new JTextField();
	JTextField temp = new JTextField();
	JTextField temp2 = new JTextField();
	DefaultListCellRenderer listRenderer;
	JButton calculate = new JButton("Compute");
	String[] power;
	JFrame frame = new JFrame();
	JFrame gresa = new JFrame();;
	RoundlIcon roundIcon;
	ButtonGroup group = new ButtonGroup();
	public static Font customFont = null;
	public static Font customFont2 = null;
	PhyCalV3(){
		File fontFile = new File("C:\\Users\\PJ\\Documents\\font\\LiquidCrystal-Normal.otf");
		File fontFile2 = new File("C:\\Users\\PJ\\Documents\\font\\LiquidCrystal-Bold.otf");
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			customFont2 = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		}catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (Exception e) {
		    e.printStackTrace();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		String[] physics = {"Power","Velocity","Momentum","Capacitance","Heat Capacity"};
		
		//choices for topic
		comboBox = new JComboBox(physics);
		comboBox.setFocusable(false);
		comboBox.addActionListener(this);
		listRenderer = new DefaultListCellRenderer();
	    listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
	    comboBox.setRenderer(listRenderer);
	    comboBox.setFont(new Font("Arial",Font.BOLD,18));
		frame.setBounds(125, 100, 200, 25);
		
		title.setBounds(65, 13, 390, 50);
		title.setFont(customFont.deriveFont(45f));
		title.setForeground(Color.decode("#80e5ff"));
		title.setOpaque(false);
		
		sol.setBounds(15,350,200,35);
		sol.setFont(new Font("Arial",Font.BOLD,30));
		sol.setForeground(Color.WHITE);
		
		answer.setBounds(150, 400, 200, 35);
		answer.setFont(customFont2.deriveFont(30f));
	    answer.setForeground(Color.green);
	    answer.setOpaque(true);
	    answer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.DARK_GRAY));
	    answer.setHorizontalAlignment(SwingConstants.CENTER);
		
		calculate.setFont(new Font(null,Font.BOLD,15));
		calculate.addActionListener(this);
		calculate.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		momenum.setBorder(new BevelBorder(BevelBorder.RAISED));
		mvelnum.setBorder(new BevelBorder(BevelBorder.RAISED));
		massnum.setBorder(new BevelBorder(BevelBorder.RAISED));
		velnum.setBorder(new BevelBorder(BevelBorder.RAISED));
		dispnum.setBorder(new BevelBorder(BevelBorder.RAISED));
		vtimenum.setBorder(new BevelBorder(BevelBorder.RAISED));
		worknum.setBorder(new BevelBorder(BevelBorder.RAISED));
		powernum.setBorder(new BevelBorder(BevelBorder.RAISED));
		timenum.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		box.setBorder(new LineBorder(Color.BLACK, 1));
		bbox.setBorder(new LineBorder(Color.BLACK, 1));
		comboBox.setBorder(new BevelBorder(BevelBorder.RAISED));

		//choices for formulas
		roundIcon = new RoundlIcon(Color.YELLOW);
		button1.setIcon(roundIcon);
		button2.setIcon(roundIcon);
		button3.setIcon(roundIcon);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button1.setSize(150, 150);
		button2.setSize(150, 150);
		button3.setSize(150, 150);
		button1.setFont(new Font(null,Font.BOLD,19));
		button2.setFont(new Font(null,Font.BOLD,19));
		button3.setFont(new Font(null,Font.BOLD,19));
		button1.setForeground(Color.decode("#ffffff"));
		button2.setForeground(Color.decode("#ffffff"));
		button3.setForeground(Color.decode("#ffffff"));
		button1.setOpaque(false);
		button2.setOpaque(false);
		button3.setOpaque(false);
		group.add(button1);
		group.add(button2);
		group.add(button3);
		
		background.setBounds(0, 0, 500, 600);
		background2.setBounds(0, 0, 450, 550);
        comboBox.setBounds(190, 73, 135, 25);
		frame.getContentPane().setBackground(Color.decode("#808080"));
		frame.add(title);
		frame.add(comboBox);
		frame.add(background);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(500,600);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public class CustomComboBoxUI extends BasicComboBoxUI {
	    private Color arrowColor;

	    public CustomComboBoxUI(Color arrowColor) {
	        this.arrowColor = arrowColor;
	    }

	    @Override
		public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
	        super.paintCurrentValue(g, bounds, hasFocus);
	        
	        int arrowWidth = 5;
	        int arrowHeight = 3;
	        int arrowX = bounds.x + bounds.width - arrowWidth - 2;
	        int arrowY = bounds.y + (bounds.height - arrowHeight) / 2;

	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(arrowColor);
	        g2.fillPolygon(new int[] {arrowX, arrowX + arrowWidth / 2, arrowX + arrowWidth},
	                       new int[] {arrowY, arrowY + arrowHeight, arrowY},
	                       3);
	    }
	}
	class RoundlIcon implements Icon {
		  Color color;
		  public RoundlIcon(Color c) {
		    color = c;
		  }
		  public void paintIcon (Component c, Graphics g,
		                        int x, int y) {
		    g.setColor(color);
		    g.fillOval (
		      x, y, getIconWidth(), getIconHeight());
		  }
		  public int getIconWidth() {
		    return 10;
		  }
		  public int getIconHeight() {
		    return 10;
		  }
		}
	public void Power() {
		
		button1.setText("Power");
		button2.setText("Work");
		button3.setText("Time(P)");
		button1.setBounds(105, 110, 100, 25);
		button2.setBounds(205, 110, 75, 25);
		button3.setBounds(290, 110, 100, 25);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(title);
		frame.add(background);
		
	}
	public void Velocity() {
		
		button1.setText("Velocity");
		button2.setText("Displacement");
		button3.setText("Time(V)");
		button1.setBounds(70, 110, 100, 25);
		button2.setBounds(170, 110, 160, 25);
		button3.setBounds(330, 110, 100, 25);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(title);
		frame.add(background);
		
	}
	public void Momentum() {
		
		button1.setText("Momentum");
		button2.setText("Velocity(M)");
		button3.setText("Mass");
		button1.setBounds(75, 110, 130, 25);
		button2.setBounds(205, 110, 125, 25);
		button3.setBounds(335, 110, 100, 25);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(title);
		frame.add(background);
		
	}
	public void Capacitance() {
		
		button1.setText("Series");
		button2.setText("Parallel");
		button1.setBounds(115, 110, 100, 25);
		button2.setBounds(290, 110, 100, 25);
		frame.add(button1);
		frame.add(button2);
		frame.add(title);
		frame.add(background);
		
	}
	public void AmountHeat() {
		
		button1.setText("Required");
		button2.setText("Mass(H)");
		button3.setText("Specific");
		button1.setBounds(75, 110, 130, 25);
		button2.setBounds(205, 110, 125, 25);
		button3.setBounds(320, 110, 100, 25);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(title);
		frame.add(background);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//topic chosen
		if(e.getSource()==comboBox) {
			
			if(comboBox.getSelectedIndex()==0) {
				
				removeComponents();
				answer.setText("");
				Power();
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
			        AbstractButton button = buttons.nextElement();
			  
			            // set the icon of the other buttons to yellow
			            RoundlIcon yellowIcon = new RoundlIcon(Color.YELLOW);
			            button.setIcon(yellowIcon);
			        
				}
				
			}
			if(comboBox.getSelectedIndex()==1) {
				
				removeComponents();
				answer.setText("");
				Velocity();
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
			        AbstractButton button = buttons.nextElement();
			  
			            // set the icon of the other buttons to yellow
			            RoundlIcon yellowIcon = new RoundlIcon(Color.YELLOW);
			            button.setIcon(yellowIcon);
			        
				}
				
			}
            if(comboBox.getSelectedIndex()==2) {
				
				removeComponents();
				answer.setText("");
				Momentum();
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
			        AbstractButton button = buttons.nextElement();
			  
			            // set the icon of the other buttons to yellow
			            RoundlIcon yellowIcon = new RoundlIcon(Color.YELLOW);
			            button.setIcon(yellowIcon);
			        
				}
				
			}
            if(comboBox.getSelectedIndex()==3) {
				
				removeComponents();
				answer.setText("");
				Capacitance();
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
			        AbstractButton button = buttons.nextElement();
			  
			            // set the icon of the other buttons to yellow
			            RoundlIcon yellowIcon = new RoundlIcon(Color.YELLOW);
			            button.setIcon(yellowIcon);
			        
				}
				
			}
            if(comboBox.getSelectedIndex()==4) {
				
				removeComponents();
				answer.setText("");
				AmountHeat();
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
			        AbstractButton button = buttons.nextElement();
			  
			            // set the icon of the other buttons to yellow
			            RoundlIcon yellowIcon = new RoundlIcon(Color.YELLOW);
			            button.setIcon(yellowIcon);
			        
				}
				
			}
			
		}
		//button formula topic
		String selectedText = button1.getText();
		if(e.getSource()==button1) {
			roundIcon = new RoundlIcon(Color.RED);
			button1.setIcon(roundIcon);
			removeComponents();
			answer.setText("");
			for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = buttons.nextElement();
		        if (button != button1) {
		            // set the icon of the other buttons to yellow
		            RoundlIcon yellowIcon = new RoundlIcon(Color.YELLOW);
		            button.setIcon(yellowIcon);
		        }
			}
			//POWER TOPIC
			if(selectedText.equals("Power")) {
			solbox.setBackground(Color.decode("#d9d9d9"));
			solbox.setBounds(150, 465, 200, 83);
			solbox.setBorder(new LineBorder(Color.BLACK, 1));
			form.setBounds(155, 490, 100, 25);
			form.setFont(new Font("Arial",Font.BOLD,18));
			form.setText("Power = ");
			mid.setBounds(235, 483, 120, 25);
			mid.setFont(new Font(null,Font.BOLD,15));
			mid.setText("_____________");
			top.setBounds(262, 475, 120, 25);
			top.setFont(new Font("Arial",Font.BOLD,18));
			top.setText("Work");
			bot.setBounds(262, 510, 120, 25);
			bot.setFont(new Font("Arial",Font.BOLD,18));
			bot.setText("Time");
			bbox.setBackground(Color.decode("#cccccc"));
			bbox.setBounds(110,145,270,230);
			box.setBackground(Color.decode("#99ffcc"));
			box.setBounds(125,160,240,200);
			name = new JLabel("POWER");
			name.setForeground(Color.decode("#00cc00"));
			name.setFont(customFont.deriveFont(30f));
			name.setBounds(205,170,100,30);
			removeComponents();
			timenum.setText("");
			worknum.setText("");
			label2 = new JLabel("W");
			label3 = new JLabel("T");
			label2.setBounds(317, 215, 75, 25);
			label2.setFont(customFont2.deriveFont(25f));
			label3.setBounds(317,270,75,25);
			label3.setFont(customFont2.deriveFont(25f));
			worknum.setFont(customFont.deriveFont(18f));
			timenum.setFont(customFont.deriveFont(18f));
			worknum.setBackground(Color.decode("#E2DB19"));
			timenum.setBackground(Color.decode("#E2DB19"));
			worknum.setBounds(200, 215, 100, 25);
			timenum.setBounds(200, 270, 100, 25);
			calculate.setBounds(200, 315, 100, 30);
			calculate.setFocusable(false);
			find = new JLabel("P  = ");
			find.setBounds(140, 240, 75, 25);
			find.setFont(customFont2.deriveFont(30f));
			decor = new JLabel("______________");
			decor.setBounds(192, 235, 120, 25);
			decor.setFont(new Font(null,Font.BOLD,15));
			frame.add(bot);
			frame.add(top);
			frame.add(mid);
			frame.add(form);
			frame.add(solbox);
			frame.add(sol);
			frame.add(name);
			frame.add(find);
			frame.add(decor);
			frame.add(button1);
			frame.add(button2);
			frame.add(button3);
			frame.add(answer);
			frame.add(title);
			frame.add(calculate);
			frame.add(label2);
			frame.add(worknum);
			frame.add(label3);
			frame.add(timenum);
			frame.add(box);
			frame.add(bbox);
			frame.add(background);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500,600);
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			}
			else if(selectedText.equals("Velocity")) {
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(135, 465, 230, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(145, 490, 100, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Velocity = ");
				mid.setBounds(250, 483, 120, 25);
				mid.setFont(new Font(null,Font.BOLD,15));
				mid.setText("_____________");
				top.setBounds(240, 475, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Displacement");
				bot.setBounds(277, 510, 120, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("Time");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(110,145,270,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(125,160,240,200);
				name = new JLabel("VELOCITY");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(195,170,150,30);
				removeComponents();
				dispnum.setText("");
				vtimenum.setText("");
				label2 = new JLabel("D");
				label3 = new JLabel("T");
				label2.setBounds(317, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(317,270,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				dispnum.setFont(customFont.deriveFont(18f));
				vtimenum.setFont(customFont.deriveFont(18f));
				dispnum.setBackground(Color.decode("#E2DB19"));
				vtimenum.setBackground(Color.decode("#E2DB19"));
				dispnum.setBounds(200, 215, 100, 25);
				vtimenum.setBounds(200, 270, 100, 25);
				calculate.setBounds(200, 315, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("V  = ");
				find.setBounds(140, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("______________");
				decor.setBounds(192, 235, 120, 25);
				decor.setFont(new Font(null,Font.BOLD,15));
				frame.add(bot);
				frame.add(top);
				frame.add(mid);
				frame.add(form);
				frame.add(solbox);
				frame.add(sol);
				frame.add(name);
				frame.add(find);
				frame.add(decor);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label2);
				frame.add(dispnum);
				frame.add(label3);
				frame.add(vtimenum);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
            else if(selectedText.equals("Momentum")) {
				
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(115, 465, 270, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(120, 490, 120, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Momentum = ");
				mid.setBounds(288, 488, 120, 25);
				mid.setFont(new Font(null,Font.BOLD,20));
				mid.setText("x");
				top.setBounds(238, 490, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Mass");
				bot.setBounds(305, 490, 120, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("Velocity");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(55,145,370,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(70,160,340,200);
				name = new JLabel("MOMENTUM");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(175,170,170,30);
				removeComponents();
				massnum.setText("");
				mvelnum.setText("");
				label2 = new JLabel("M");
				label3 = new JLabel("V");
				label2.setBounds(188, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(340,215,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				massnum.setFont(customFont.deriveFont(18f));
				mvelnum.setFont(customFont.deriveFont(18f));
				massnum.setBackground(Color.decode("#E2DB19"));
				mvelnum.setBackground(Color.decode("#E2DB19"));
				massnum.setBounds(150, 243, 100, 25);
				mvelnum.setBounds(298, 243, 100, 25);
				calculate.setBounds(200, 300, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("P  = ");
				find.setBounds(90, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("x");
				decor.setBounds(265, 239, 120, 25);
				decor.setFont(new Font(null,Font.BOLD,30));
				frame.add(bot);
				frame.add(top);
				frame.add(mid);
				frame.add(form);
				frame.add(solbox);
				frame.add(sol);
				frame.add(name);
				frame.add(find);
				frame.add(decor);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label2);
				frame.add(massnum);
				frame.add(label3);
				frame.add(mvelnum);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
			if(selectedText.equals("Series")) {
				
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(70, 455, 340, 93);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(80, 490, 100, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Ctotal = ");
				mid2.setBounds(165, 465, 250, 25);
				mid2.setFont(new Font(null,Font.BOLD,15));
				mid2.setText("_____________________________");
				mid.setBounds(165, 495, 250, 25);
				mid.setFont(new Font(null,Font.BOLD,15));
				mid.setText("_______   +   _______   +   _______");
				top2.setBounds(277, 455, 100, 25);
				top2.setFont(new Font("Arial",Font.BOLD,17));
				top2.setText("1");
				top.setBounds(175, 488, 250, 25);
				top.setFont(new Font("Arial",Font.BOLD,17));
				top.setText("  1                 1                1");
				bot.setBounds(174, 515, 250, 25);
				bot.setFont(new Font("Arial",Font.BOLD,17));
				bot.setText(" C1              C2             C3 ");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(55,145,370,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(70,160,340,200);
				name = new JLabel("SERIES");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(210,170,100,30);
				removeComponents();
				cap1.setText("");
				cap2.setText("");
				cap3.setText("");
				label1 = new JLabel("C1");
				label2 = new JLabel("C2");
				label3 = new JLabel("C3");
				label1.setBounds(145, 270, 75, 25);
				label1.setFont(customFont2.deriveFont(25f));
				label2.setBounds(225, 270, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(315,270,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				cap1.setFont(customFont.deriveFont(18f));
				cap2.setFont(customFont.deriveFont(18f));
				cap3.setFont(customFont.deriveFont(18f));
				cap1.setBackground(Color.decode("#E2DB19"));
				cap2.setBackground(Color.decode("#E2DB19"));
				cap3.setBackground(Color.decode("#E2DB19"));
				cap1.setBounds(170, 270, 50, 25);
				cap2.setBounds(257, 270, 50, 25);
				cap3.setBounds(347, 270, 50, 25);
				calculate.setBounds(200, 315, 100, 30);
				calculate.setFocusable(false);
				find2 = new JLabel("1");
				find2.setBounds(97, 228, 75, 25);
				find2.setFont(customFont2.deriveFont(30f));
				find3 = new JLabel("____");
				find3.setBounds(88, 234, 75, 25);
				find3.setFont(new Font(null,Font.BOLD,15));
				equal = new JLabel(" = ");
				equal.setBounds(125, 240, 75, 25);
				equal.setFont(customFont2.deriveFont(30f));
				find = new JLabel("Ct");
				find.setBounds(90, 261, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor2 = new JLabel("  1        1        1 ");
				decor2.setBounds(168, 220, 250, 25);
				decor2.setFont(customFont.deriveFont(30f));
				decor = new JLabel("_______   +   _______   +   _______");
				decor.setBounds(165, 235, 240, 25);
				decor.setFont(new Font(null,Font.BOLD,15));
				frame.add(equal);
				frame.add(mid2);
				frame.add(top2);
				frame.add(bot);
				frame.add(top);
				frame.add(mid);
				frame.add(form);
				frame.add(solbox);
				frame.add(sol);
				frame.add(cap1);
				frame.add(cap2);
				frame.add(cap3);
                frame.add(find);
                frame.add(find2);
                frame.add(find3);
                frame.add(decor2);
                frame.add(decor);
				frame.add(name);
				frame.add(button1);
				frame.add(button2);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label1);
				frame.add(label2);
				frame.add(label3);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
			if(selectedText.equals("Required")) {
				
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(20, 465, 450, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(30, 490, 130, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Required = ");
				mid.setBounds(135, 489, 350, 25);
				mid.setFont(new Font(null,Font.BOLD,18));
				mid.setText("Mass ( Specific Heat )( Temp Change ) ");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(45,145,400,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(60,160,370,200);
				name = new JLabel("REQUIRED");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(195,170,150,30);
				removeComponents();
				hmass.setText("");
				spec.setText("");
				temp.setText("");
				temp2.setText("");
				label1 = new JLabel("M");
				label2 = new JLabel("C");
				label3 = new JLabel("ΔT");
				label1.setBounds(145, 215, 75, 25);
				label1.setFont(customFont2.deriveFont(25f));
				label2.setBounds(225, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(340,215,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				hmass.setFont(customFont.deriveFont(18f));
				spec.setFont(customFont.deriveFont(18f));
				temp.setFont(customFont.deriveFont(18f));
				temp2.setFont(customFont.deriveFont(18f));
				hmass.setBackground(Color.decode("#E2DB19"));
				spec.setBackground(Color.decode("#E2DB19"));
				temp.setBackground(Color.decode("#E2DB19"));
				temp2.setBackground(Color.decode("#E2DB19"));
				hmass.setBounds(130, 245, 50, 25);
				spec.setBounds(207, 245, 50, 25);
				temp.setBounds(290, 245, 50, 25);
				temp2.setBounds(360, 245, 50, 25);
				calculate.setBounds(200, 300, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("Q  = ");
				find.setBounds(75, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("(              )(              -             )");
				decor.setBounds(190, 243, 240, 25);
				decor.setFont(new Font(null,Font.BOLD,18));
				frame.add(form);
				frame.add(sol);
				frame.add(mid);
				frame.add(solbox);
				frame.add(hmass);
				frame.add(spec);
				frame.add(temp);
				frame.add(temp2);
				frame.add(find);
				frame.add(decor);
				frame.add(name);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label1);
				frame.add(label2);
				frame.add(label3);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		}
		String selectedText2 = button2.getText();
		if(e.getSource()==button2) {
			roundIcon = new RoundlIcon(Color.RED);
			button2.setIcon(roundIcon);
			removeComponents();
			answer.setText("");
			for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = buttons.nextElement();
		        if (button != button2) {
		            // set the icon of the other buttons to yellow
		            RoundlIcon yellowIcon = new RoundlIcon(Color.YELLOW);
		            button.setIcon(yellowIcon);
		        }
			}
			//POWER TOPIC
			if(selectedText2.equals("Work")) {
				
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(135, 465, 230, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(150, 490, 120, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Work = ");
				mid.setBounds(285, 488, 120, 25);
				mid.setFont(new Font(null,Font.BOLD,20));
				mid.setText("x");
				top.setBounds(220, 490, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Power");
				bot.setBounds(305, 490, 120, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("Time");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(55,145,370,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(70,160,340,200);
				name = new JLabel("WORK");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(210,170,170,30);
				removeComponents();
				powernum.setText("");
				timenum.setText("");
				label2 = new JLabel("P");
				label3 = new JLabel("T");
				label2.setBounds(188, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(340,215,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				powernum.setFont(customFont.deriveFont(18f));
				timenum.setFont(customFont.deriveFont(18f));
				powernum.setBackground(Color.decode("#E2DB19"));
				timenum.setBackground(Color.decode("#E2DB19"));
				powernum.setBounds(150, 243, 100, 25);
				timenum.setBounds(298, 243, 100, 25);
				calculate.setBounds(200, 300, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("W  = ");
				find.setBounds(85, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("x");
				decor.setBounds(265, 239, 120, 25);
				decor.setFont(new Font(null,Font.BOLD,30));
				frame.add(bot);
				frame.add(top);
				frame.add(mid);
				frame.add(form);
				frame.add(solbox);
				frame.add(sol);
				frame.add(name);
				frame.add(find);
				frame.add(decor);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label2);
				frame.add(powernum);
				frame.add(label3);
				frame.add(timenum);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
			else if(selectedText2.equals("Displacement")) {
				
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(90, 465, 310, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(100, 490, 150, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Displacement = ");
				mid.setBounds(322, 488, 120, 25);
				mid.setFont(new Font(null,Font.BOLD,20));
				mid.setText("x");
				top.setBounds(241, 490, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Velocity");
				bot.setBounds(344, 490, 120, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("Time");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(55,145,370,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(70,160,340,200);
				name = new JLabel("DISPLACEMENT");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(165,170,190,30);
				removeComponents();
				velnum.setText("");
				vtimenum.setText("");
				label2 = new JLabel("V");
				label3 = new JLabel("T");
				label2.setBounds(188, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(340,215,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				velnum.setFont(customFont.deriveFont(18f));
				vtimenum.setFont(customFont.deriveFont(18f));
				velnum.setBackground(Color.decode("#E2DB19"));
				vtimenum.setBackground(Color.decode("#E2DB19"));
				velnum.setBounds(150, 243, 100, 25);
				vtimenum.setBounds(298, 243, 100, 25);
				calculate.setBounds(200, 300, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("D  = ");
				find.setBounds(85, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("x");
				decor.setBounds(265, 239, 120, 25);
				decor.setFont(new Font(null,Font.BOLD,30));
				frame.add(bot);
				frame.add(top);
				frame.add(mid);
				frame.add(form);
				frame.add(solbox);
				frame.add(sol);
				frame.add(name);
				frame.add(find);
				frame.add(decor);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label2);
				frame.add(velnum);
				frame.add(label3);
				frame.add(vtimenum);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
            else if(selectedText2.equals("Velocity(M)")) {
            	
            	solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(135, 465, 230, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(145, 490, 100, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Velocity = ");
				mid.setBounds(250, 483, 120, 25);
				mid.setFont(new Font(null,Font.BOLD,15));
				mid.setText("_____________");
				top.setBounds(250, 475, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Momentum");
				bot.setBounds(277, 510, 120, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("Mass");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(110,145,270,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(125,160,240,200);
				name = new JLabel("VELOCITY");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(195,170,150,30);
				removeComponents();
				momenum.setText("");
				massnum.setText("");
				label2 = new JLabel("P");
				label3 = new JLabel("M");
				label2.setBounds(317, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(317,270,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				momenum.setFont(customFont.deriveFont(18f));
				massnum.setFont(customFont.deriveFont(18f));
				momenum.setBackground(Color.decode("#E2DB19"));
				massnum.setBackground(Color.decode("#E2DB19"));
				momenum.setBounds(200, 215, 100, 25);
				massnum.setBounds(200, 270, 100, 25);
				calculate.setBounds(200, 315, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("V  = ");
				find.setBounds(140, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("______________");
				decor.setBounds(192, 235, 120, 25);
				decor.setFont(new Font(null,Font.BOLD,15));
				frame.add(bot);
				frame.add(top);
				frame.add(mid);
				frame.add(form);
				frame.add(solbox);
				frame.add(sol);
				frame.add(name);
				frame.add(find);
				frame.add(decor);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label2);
				frame.add(momenum);
				frame.add(label3);
				frame.add(massnum);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
			if(selectedText2.equals("Parallel")) {
				
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(130, 465, 230, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(135, 490, 100, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Ctotal = ");
				mid.setBounds(220, 489, 190, 25);
				mid.setFont(new Font(null,Font.BOLD,18));
				mid.setText("C1  +  C2  +  C3");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(55,145,370,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(70,160,340,200);
				name = new JLabel("PARALLEL");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(195,170,150,30);
				removeComponents();
				cap1.setText("");
				cap2.setText("");
				cap3.setText("");
				label1 = new JLabel("C1");
				label2 = new JLabel("C2");
				label3 = new JLabel("C3");
				label1.setBounds(185, 215, 75, 25);
				label1.setFont(customFont2.deriveFont(25f));
				label2.setBounds(272, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(359,215,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				cap1.setFont(customFont.deriveFont(18f));
				cap2.setFont(customFont.deriveFont(18f));
				cap3.setFont(customFont.deriveFont(18f));
				cap1.setBackground(Color.decode("#E2DB19"));
				cap2.setBackground(Color.decode("#E2DB19"));
				cap3.setBackground(Color.decode("#E2DB19"));
				cap1.setBounds(170, 245, 50, 25);
				cap2.setBounds(257, 245, 50, 25);
				cap3.setBounds(347, 245, 50, 25);
				calculate.setBounds(200, 300, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("Ct  = ");
				find.setBounds(90, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("          +           +   ");
				decor.setBounds(159, 243, 240, 25);
				decor.setFont(new Font(null,Font.BOLD,25));
				frame.add(form);
				frame.add(sol);
				frame.add(mid);
				frame.add(solbox);
				frame.add(cap1);
				frame.add(cap2);
				frame.add(cap3);
                frame.add(find);
                frame.add(decor);
				frame.add(name);
				frame.add(button1);
				frame.add(button2);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label1);
				frame.add(label2);
				frame.add(label3);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
			if(selectedText2.equals("Mass(H)")) {
				
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(95, 465, 300, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(105, 490, 100, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Mass = ");
				mid.setBounds(173, 483, 220, 25);
				mid.setFont(new Font(null,Font.BOLD,15));
				mid.setText("___________________________");
				top.setBounds(240, 475, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Required");
				bot.setBounds(173, 510, 220, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("(Specific)(Temp Change)");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(35,145,420,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(50,160,390,200);
				name = new JLabel("MASS");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(210,170,100,30);
				removeComponents();
				req.setText("");
				spec.setText("");
				temp.setText("");
				temp2.setText("");
				label1 = new JLabel("Q");
				label2 = new JLabel("C");
				label3 = new JLabel("ΔT");
				label1.setBounds(330, 223, 75, 25);
				label1.setFont(customFont2.deriveFont(25f));
				label2.setBounds(140,263,75,25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(400,263,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				req.setFont(customFont.deriveFont(18f));
				spec.setFont(customFont.deriveFont(18f));
				temp.setFont(customFont.deriveFont(18f));
				temp2.setFont(customFont.deriveFont(18f));
				req.setBackground(Color.decode("#E2DB19"));
				spec.setBackground(Color.decode("#E2DB19"));
				temp.setBackground(Color.decode("#E2DB19"));
				temp2.setBackground(Color.decode("#E2DB19"));
				req.setBounds(220, 223, 100, 25);
				spec.setBounds(172, 263, 50, 25);
				temp.setBounds(255, 263, 50, 25);
				temp2.setBounds(325, 263, 50, 25);
				calculate.setBounds(200, 310, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("M  = ");
				find.setBounds(70, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor2 = new JLabel("(              )(              -             )");
				decor2.setBounds(155, 260, 240, 25);
				decor2.setFont(new Font(null,Font.BOLD,18));
				decor = new JLabel("____________________________");
				decor.setBounds(160, 235, 230, 25);
				decor.setFont(new Font(null,Font.BOLD,15));
				frame.add(top);
				frame.add(mid);
				frame.add(bot);
				frame.add(form);
				frame.add(solbox);
				frame.add(req);
				frame.add(spec);
				frame.add(temp);
				frame.add(temp2);
				frame.add(decor);
				frame.add(decor2);
				frame.add(find);
				frame.add(name);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label1);
				frame.add(label2);
				frame.add(label3);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		}
		String selectedText3 = button3.getText();
		if(e.getSource()==button3) {
			roundIcon = new RoundlIcon(Color.RED);
			button3.setIcon(roundIcon);
			removeComponents();
			answer.setText("");
			for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = buttons.nextElement();
		        if (button != button3) {
		            // set the icon of the other buttons to yellow
		            RoundlIcon yellowIcon = new RoundlIcon(Color.YELLOW);
		            button.setIcon(yellowIcon);
		        }
			}
			//POWER TOPIC
			if(selectedText3.equals("Time(P)")) {
				
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(150, 465, 200, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(160, 490, 100, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Time = ");
				mid.setBounds(235, 483, 120, 25);
				mid.setFont(new Font(null,Font.BOLD,15));
				mid.setText("_____________");
				top.setBounds(262, 475, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Work");
				bot.setBounds(262, 510, 120, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("Power");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(110,145,270,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(125,160,240,200);
				name = new JLabel("TIME");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(218,170,150,30);
				removeComponents();
				worknum.setText("");
				powernum.setText("");
				label2 = new JLabel("W");
				label3 = new JLabel("P");
				label2.setBounds(317, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(317,270,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				worknum.setFont(customFont.deriveFont(18f));
				powernum.setFont(customFont.deriveFont(18f));
				worknum.setBackground(Color.decode("#E2DB19"));
				powernum.setBackground(Color.decode("#E2DB19"));
				worknum.setBounds(200, 215, 100, 25);
				powernum.setBounds(200, 270, 100, 25);
				calculate.setBounds(200, 315, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("T  = ");
				find.setBounds(140, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("______________");
				decor.setBounds(192, 235, 120, 25);
				decor.setFont(new Font(null,Font.BOLD,15));
				frame.add(bot);
				frame.add(top);
				frame.add(mid);
				frame.add(form);
				frame.add(solbox);
				frame.add(sol);
				frame.add(name);
				frame.add(find);
				frame.add(decor);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label2);
				frame.add(worknum);
				frame.add(label3);
				frame.add(powernum);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
            else if(selectedText3.equals("Time(V)")) {
            	
            	solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(150, 465, 200, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(160, 490, 100, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Time = ");
				mid.setBounds(235, 483, 120, 25);
				mid.setFont(new Font(null,Font.BOLD,15));
				mid.setText("_____________");
				top.setBounds(224, 475, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Displacement");
				bot.setBounds(252, 510, 120, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("Velocity");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(110,145,270,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(125,160,240,200);
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(110,145,270,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(125,160,240,200);
				name = new JLabel("TIME");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(218,170,150,30);
				removeComponents();
				dispnum.setText("");
				velnum.setText("");
				label2 = new JLabel("D");
				label3 = new JLabel("V");
				label2.setBounds(317, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(317,270,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				dispnum.setFont(customFont.deriveFont(18f));
				velnum.setFont(customFont.deriveFont(18f));
				dispnum.setBackground(Color.decode("#E2DB19"));
				velnum.setBackground(Color.decode("#E2DB19"));
				dispnum.setBounds(200, 215, 100, 25);
				velnum.setBounds(200, 270, 100, 25);
				calculate.setBounds(200, 315, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("T  = ");
				find.setBounds(140, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("______________");
				decor.setBounds(192, 235, 120, 25);
				decor.setFont(new Font(null,Font.BOLD,15));
				frame.add(bot);
				frame.add(top);
				frame.add(mid);
				frame.add(form);
				frame.add(solbox);
				frame.add(sol);
				frame.add(name);
				frame.add(find);
				frame.add(decor);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label2);
				frame.add(dispnum);
				frame.add(label3);
				frame.add(velnum);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
            else if(selectedText3.equals("Mass")) {
            	
            	solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(150, 465, 200, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(160, 490, 100, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Mass = ");
				mid.setBounds(235, 483, 120, 25);
				mid.setFont(new Font(null,Font.BOLD,15));
				mid.setText("_____________");
				top.setBounds(235, 475, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Momentum");
				bot.setBounds(252, 510, 120, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("Velocity");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(110,145,270,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(125,160,240,200);
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(110,145,270,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(125,160,240,200);
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(110,145,270,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(125,160,240,200);
				name = new JLabel("MASS");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(218,170,150,30);
				removeComponents();
				momenum.setText("");
				mvelnum.setText("");
				label2 = new JLabel("P");
				label3 = new JLabel("V");
				label2.setBounds(317, 215, 75, 25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(317,270,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				momenum.setFont(customFont.deriveFont(18f));
				mvelnum.setFont(customFont.deriveFont(18f));
				momenum.setBackground(Color.decode("#E2DB19"));
				mvelnum.setBackground(Color.decode("#E2DB19"));
				momenum.setBounds(200, 215, 100, 25);
				mvelnum.setBounds(200, 270, 100, 25);
				calculate.setBounds(200, 315, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("M = ");
				find.setBounds(140, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor = new JLabel("______________");
				decor.setBounds(192, 235, 120, 25);
				decor.setFont(new Font(null,Font.BOLD,15));
				frame.add(bot);
				frame.add(top);
				frame.add(mid);
				frame.add(form);
				frame.add(solbox);
				frame.add(sol);
				frame.add(name);
				frame.add(find);
				frame.add(decor);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label2);
				frame.add(momenum);
				frame.add(label3);
				frame.add(mvelnum);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			
				
			}
            if(selectedText3.equals("Specific")) {
				
				solbox.setBackground(Color.decode("#d9d9d9"));
				solbox.setBounds(85, 465, 330, 83);
				solbox.setBorder(new LineBorder(Color.BLACK, 1));
				form.setBounds(93, 490, 100, 25);
				form.setFont(new Font("Arial",Font.BOLD,18));
				form.setText("Specific = ");
				mid.setBounds(193, 483, 220, 25);
				mid.setFont(new Font(null,Font.BOLD,15));
				mid.setText("__________________________");
				top.setBounds(260, 475, 120, 25);
				top.setFont(new Font("Arial",Font.BOLD,18));
				top.setText("Required");
				bot.setBounds(200, 510, 220, 25);
				bot.setFont(new Font("Arial",Font.BOLD,18));
				bot.setText("(Mass)(Temp Change)");
				bbox.setBackground(Color.decode("#cccccc"));
				bbox.setBounds(35,145,420,230);
				box.setBackground(Color.decode("#99ffcc"));
				box.setBounds(50,160,390,200);
				name = new JLabel("SPECIFIC");
				name.setForeground(Color.decode("#00cc00"));
				name.setFont(customFont.deriveFont(30f));
				name.setBounds(210,170,100,30);
				removeComponents();
				req.setText("");
				hmass.setText("");
				temp.setText("");
				temp2.setText("");
				label1 = new JLabel("Q");
				label2 = new JLabel("M");
				label3 = new JLabel("ΔT");
				label1.setBounds(330, 223, 75, 25);
				label1.setFont(customFont2.deriveFont(25f));
				label2.setBounds(130,263,75,25);
				label2.setFont(customFont2.deriveFont(25f));
				label3.setBounds(400,263,75,25);
				label3.setFont(customFont2.deriveFont(25f));
				req.setFont(customFont.deriveFont(18f));
				hmass.setFont(customFont.deriveFont(18f));
				temp.setFont(customFont.deriveFont(18f));
				temp2.setFont(customFont.deriveFont(18f));
				req.setBackground(Color.decode("#E2DB19"));
				hmass.setBackground(Color.decode("#E2DB19"));
				temp.setBackground(Color.decode("#E2DB19"));
				temp2.setBackground(Color.decode("#E2DB19"));
				req.setBounds(220, 223, 100, 25);
				hmass.setBounds(172, 263, 50, 25);
				temp.setBounds(255, 263, 50, 25);
				temp2.setBounds(325, 263, 50, 25);
				calculate.setBounds(200, 310, 100, 30);
				calculate.setFocusable(false);
				find = new JLabel("C  = ");
				find.setBounds(70, 240, 75, 25);
				find.setFont(customFont2.deriveFont(30f));
				decor2 = new JLabel("(              )(              -             )");
				decor2.setBounds(155, 260, 240, 25);
				decor2.setFont(new Font(null,Font.BOLD,18));
				decor = new JLabel("____________________________");
				decor.setBounds(160, 235, 230, 25);
				decor.setFont(new Font(null,Font.BOLD,15));
				frame.add(top);
				frame.add(mid);
				frame.add(bot);
				frame.add(form);
				frame.add(solbox);
				frame.add(req);
				frame.add(hmass);
				frame.add(temp);
				frame.add(temp2);
				frame.add(decor);
				frame.add(decor2);
				frame.add(find);
				frame.add(name);
				frame.add(button1);
				frame.add(button2);
				frame.add(button3);
				frame.add(answer);
				frame.add(title);
				frame.add(calculate);
				frame.add(label1);
				frame.add(label2);
				frame.add(label3);
				frame.add(box);
				frame.add(bbox);
				frame.add(background);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,600);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		}
		//sends to calculate values
		if(e.getSource()==calculate) {
			calculatevalues();
	}
	}
	//remove and reset
	private void removeComponents() {
	    Component[] components = frame.getContentPane().getComponents(); // Get all components in the content pane
	    for (Component component : components) {
	        if(component != comboBox) { // Don't remove the combo box
	            frame.getContentPane().remove(component); // Remove the component
	        }
	    }
	    frame.revalidate(); // Revalidate the frame to update the layout
	    frame.repaint(); // Repaint the frame to update the display
	}
	
	private void calculatevalues() {
		//calculates all the power stuff
	if(comboBox.getSelectedIndex()==0) {
	    double powin = 0, workin = 0, timein = 0, result = 0;
		try {
		    if (!powernum.getText().isEmpty()) {
	            powin = Double.parseDouble(powernum.getText());
	        }
	        if (!worknum.getText().isEmpty()) {
	            workin = Double.parseDouble(worknum.getText());
	        }
	        if (!timenum.getText().isEmpty()) {
	            timein = Double.parseDouble(timenum.getText());
	        }

	        if (button2.isSelected()) {
	            result = powin * timein;
	    	    double roundedValue = (double) Math.round(result * 100) / 100;
                answer.setText(roundedValue + " Joules");    
	        } else if (button1.isSelected()) {
	            result = workin / timein;
	    	    double roundedValue = (double) Math.round(result * 100) / 100;
	            answer.setText(roundedValue + " Watts");
	        } else if (button3.isSelected()){
	            result = workin / powin;
	    	    double roundedValue = (double) Math.round(result * 100) / 100;
	            answer.setText(roundedValue + " seconds");
	        }

	    } catch (NumberFormatException nfe) {
	        JOptionPane.showMessageDialog(frame, "Please input valid numbers into the textfield", "ERROR", JOptionPane.ERROR_MESSAGE);
	    }
}
	//calculates all the velocity stuff
		else if(comboBox.getSelectedIndex()==1) {
			double velin = 0, dispin = 0, vtimein = 0, result = 0;
			try {
			    if (!velnum.getText().isEmpty()) {
		            velin = Double.parseDouble(velnum.getText());
		        }
		        if (!dispnum.getText().isEmpty()) {
		            dispin = Double.parseDouble(dispnum.getText());
		        }
		        if (!vtimenum.getText().isEmpty()) {
		            vtimein = Double.parseDouble(vtimenum.getText());
		        }

		        if (button2.isSelected()) {
		            result = velin * vtimein;
		    	    double roundedValue = (double) Math.round(result * 100) / 100;
		            answer.setText(roundedValue + " meters");
		        } else if (button1.isSelected()) {
		            result = dispin / vtimein;
		    	    double roundedValue = (double) Math.round(result * 100) / 100;
		            answer.setText(roundedValue + " m/s");
		        } else if (button3.isSelected()){
		            result = dispin / velin;
		    	    double roundedValue = (double) Math.round(result * 100) / 100;
		            answer.setText(roundedValue + " seconds");
		        }

		    } catch (NumberFormatException nfe) {
		        JOptionPane.showMessageDialog(frame, "Please input valid numbers into the textfield", "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		}
	//calculates all the momentum stuff
		else if(comboBox.getSelectedIndex()==2) {
			double momin = 0, mvelin = 0, massin = 0, result = 0;
			try {
			    if (!momenum.getText().isEmpty()) {
		            momin = Double.parseDouble(momenum.getText());
		        }
		        if (!mvelnum.getText().isEmpty()) {
		            mvelin = Double.parseDouble(mvelnum.getText());
		        }
		        if (!massnum.getText().isEmpty()) {
		            massin = Double.parseDouble(massnum.getText());
		        }

		        if (button1.isSelected()) {
		            result = massin * mvelin;
		    	    double roundedValue = (double) Math.round(result * 100) / 100;
		            answer.setText(roundedValue + " kg m/s");
		        } else if (button2.isSelected()) {
		            result = momin / massin;
		    	    double roundedValue = (double) Math.round(result * 100) / 100;
		            answer.setText(roundedValue + " m/s");
		        } else if (button3.isSelected()){
		            result = momin / mvelin;
		    	    double roundedValue = (double) Math.round(result * 100) / 100;
		            answer.setText(roundedValue + " kg");
		        }

		    } catch (NumberFormatException nfe) {
		        JOptionPane.showMessageDialog(frame, "Please input valid numbers into the textfield", "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		}
		else if(comboBox.getSelectedIndex()==3) {
			
			double cap1in = 0, cap2in = 0, cap3in = 0, result = 0, nresult = 0, solcap1 = 0, solcap2 = 0, solcap3 = 0;
			try {
				cap1in = Double.parseDouble(cap1.getText());
				cap2in = Double.parseDouble(cap2.getText());
				cap3in = Double.parseDouble(cap3.getText());
			if (button1.isSelected()) {
				result = 1/cap1in + 1/cap2in + 1/cap3in;
				double roundedValue = (double) Math.round(result * 1000.0) / 1000.0;
				nresult = 1/roundedValue;
				double nroundedValue = (double) Math.round(nresult * 100) / 100;
				answer.setText(nroundedValue + " F");
				if (gresa != null) {
		            gresa.dispose();
		            
		        }
				given.setForeground(Color.decode("#0000ff"));
				given.setFont(new Font("Arial",Font.BOLD,25));
				given.setBounds(0,0,80,40);
				given.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				given.setHorizontalAlignment(SwingConstants.CENTER);
				givenum.setText("C1 = "+cap1in+"  C2 = "+cap2in+"  C3 = "+cap3in);
				givenum.setFont(new Font("Arial",Font.BOLD,20));
				givenum.setBounds(90, 20, 300, 100);
				required.setForeground(Color.decode("#0000ff"));
				required.setFont(new Font("Arial",Font.BOLD,25));
				required.setBounds(0,105,120,40);
				required.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				required.setHorizontalAlignment(SwingConstants.CENTER);
				requinum = new JLabel("Series Total Capacitance (Ctotal)");
				requinum.setFont(new Font("Arial",Font.BOLD,20));
				requinum.setBounds(75, 130, 350, 100);
				solution.setForeground(Color.decode("#0000ff"));
				solution.setFont(new Font("Arial",Font.BOLD,25));
				solution.setBounds(0,220,120,40);
				solution.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				solution.setHorizontalAlignment(SwingConstants.CENTER);
				solut = new JLabel("  1             1              1 ");
				solut.setBounds(130, 250, 250, 25);
				solut.setFont(new Font("Arial",Font.BOLD,20));
				solutop = new JLabel("_____   +   _____   +   _____");
				solutop.setBounds(123, 257, 250, 25);
				solutop.setFont(new Font("Arial",Font.BOLD,18));
				solutop2.setText(String.format("%.2f       %.2f        %.2f", cap1in, cap2in, cap3in));
				solutop2.setBounds(127, 260, 250, 75);
				solutop2.setFont(new Font("Arial", Font.BOLD, 20));
				solcor = new JLabel(" = ");
				solcor.setBounds(225, 317, 250, 25);
				solcor.setFont(new Font("Arial",Font.BOLD,25));
				solut1 = new JLabel("                1               ");
				solut1.setBounds(139, 340, 250, 25);
				solut1.setFont(new Font("Arial",Font.BOLD,20));
				solutop1 = new JLabel("________________________");
				solutop1.setBounds(123, 350, 250, 25);
				solutop1.setFont(new Font("Arial",Font.BOLD,18));
				solcap1 = 1/cap1in;
				solcap2 = 1/cap2in;
				solcap3 = 1/cap3in;
				solutop3.setText(String.format("%.3f   +   %.3f   +   %.3f", solcap1, solcap2, solcap3));
				solutop3.setBounds(123, 360, 250, 75);
				solutop3.setFont(new Font("Arial", Font.BOLD, 20));
				solcor2 = new JLabel(" = ");
				solcor2.setBounds(225, 417, 250, 25);
				solcor2.setFont(new Font("Arial",Font.BOLD,25));
				answer2.setText(nroundedValue + " F");
				answer2.setBounds(165, 457, 150, 25);
				answer2.setFont(new Font("Arial",Font.BOLD,20));
				answer2.setForeground(Color.decode("#009933"));
				answer2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				answer2.setHorizontalAlignment(SwingConstants.CENTER);
				gresa.add(given);
				gresa.add(requinum);
				gresa.add(givenum);
				gresa.add(required);
				gresa.add(solution);
				gresa.add(solut);
				gresa.add(solutop);
				gresa.add(solutop2);
				gresa.add(solcor);
				gresa.add(solut1);
				gresa.add(solutop1);
				gresa.add(solutop3);
				gresa.add(solcor2);
				gresa.add(answer2);
				gresa.add(background2);
				gresa.pack();
				gresa.setLayout(null);
				gresa.setResizable(false);
				gresa.setVisible(true);
				gresa.setSize(450,550);
				gresa.getContentPane().setBackground(Color.decode("#e6e6e6"));
		        gresa.setLocation(920, 100);
			}
			if (button2.isSelected()) {
				result = cap1in + cap2in + cap3in;
				double roundedValue = (double) Math.round(result * 100) / 100;
				answer.setText(roundedValue + " F");
			}
		} catch (NumberFormatException nfe) {
	        JOptionPane.showMessageDialog(frame, "Please input valid numbers into the textfield", "ERROR", JOptionPane.ERROR_MESSAGE);
	    }
			
		}
		else if(comboBox.getSelectedIndex()==4) {
			
			double reqin = 0, hmassin = 0, specin = 0, tempin = 0, temp2in = 0, result = 0, nresult = 0, n2result = 0;
			try {
			    if (!req.getText().isEmpty()) {
		            reqin = Double.parseDouble(req.getText());
		        }
		        if (!hmass.getText().isEmpty()) {
		            hmassin = Double.parseDouble(hmass.getText());
		        }
		        if (!spec.getText().isEmpty()) {
		            specin = Double.parseDouble(spec.getText());
		        }
		        if (!temp.getText().isEmpty()) {
		            tempin = Double.parseDouble(temp.getText());
		        }
		        if (!temp2.getText().isEmpty()) {
		            temp2in = Double.parseDouble(temp2.getText());
		        }

		        if (button1.isSelected()) {
		            result = tempin - temp2in;
		            double roundedValue = (double) Math.round(result * 100) / 100;
		            nresult = hmassin * specin * roundedValue;
		    	    double nroundedValue = (double) Math.round(nresult * 100) / 100;
		            answer.setText(nroundedValue + " J");
		        }
		        if (button2.isSelected()) {
		            result = tempin - temp2in;
		            double roundedValue = (double) Math.round(result * 100) / 100;
		            nresult = specin * roundedValue;
		    	    double nroundedValue = (double) Math.round(nresult * 100) / 100;
		    	    n2result = reqin / nroundedValue;
		    	    double n2roundedValue = (double) Math.round(n2result * 100) / 100;
		            answer.setText(n2roundedValue + " grams");
		        }
		        if (button3.isSelected()) {
		            result = tempin - temp2in;
		            double roundedValue = (double) Math.round(result * 100) / 100;
		            nresult = hmassin * roundedValue;
		    	    double nroundedValue = (double) Math.round(nresult * 100) / 100;
		    	    n2result = reqin / nroundedValue;
		    	    double n2roundedValue = (double) Math.round(n2result * 100) / 100;
		            answer.setText(n2roundedValue + " J/g C");
		        }

		    } catch (NumberFormatException nfe) {
		        JOptionPane.showMessageDialog(frame, "Please input valid numbers into the textfield", "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
			
		}
	}
}