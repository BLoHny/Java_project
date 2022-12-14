package GSM_TapTapTap;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Main extends JFrame{

	public Main() {}
	
	JFrame f = new JFrame();
	
	//메인화면	 				//상점			  //전직소			  //던전		    	 //보스
	String[] images = {"/image/shop.png", "/image/jopUpgrade.png", "/image/dungeon.png", "/image/bossDungeon.png"};
	ImageIcon[] icons = new ImageIcon[images.length];
	static JButton[] buildingButton = new JButton[4];
	
	public void frame() {
		for (int i = 0; i < images.length; i++) {
			icons[i] = new ImageIcon(Main.class.getResource(images[i]));
			buildingButton[i] = new JButton(icons[i]);
			buildingButton[i].setLocation((25 * (i + 1))  + (i * 180) + (15 * i), 300);
			buildingButton[i].setSize(180, 220);
			
			buildingButton[i].setBorderPainted(false);
			buildingButton[i].setFocusPainted(false);
			buildingButton[i].setContentAreaFilled(false);
			
			buildingButton[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			f.add(buildingButton[i]);
		}
		
		madeInf();
		madeShop();
		madeJob();
		madeDungeon();
		madeBossDungeon();
		madeSave();
		
		f.setTitle("TapTapTap"); //프레임 타이틀
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.getContentPane().setBackground(Color.gray); //배경색
		f.setSize(905, 600); // 프레임 크기
        f.setResizable(false); // 창크기 조절
        f.setLocationRelativeTo(null);//창이 가운데 나오게
        f.setVisible(true); // 화면에 프레임 출력
	}
	
	static JButton save = new JButton("save");
	static JButton load = new JButton("load");
	
	public void madeSave() {
		save.setBounds(650, 15, 100, 40);
		load.setBounds(770, 15, 100, 40);
		
		f.add(save);
		f.add(load);
	}
	
	//정보
	static double damage = 10.0;
	static double money = 100.0;
	static int dia = 0;
	static double autoTapSpeed = 2.0;
	
	static boolean job1Check = false;
	static boolean job2Check = false;
	
	static JPanel inf = new JPanel();
	static JLabel tap = new JLabel("tap : " + Change.change(damage));
	static JLabel moneyL = new JLabel("◇  : " + Change.change(money));
	static JLabel diaL = new JLabel("★  : " + dia);
	static JLabel auto = new JLabel("AUTO : " + autoTapSpeed);
	
	public void madeInf() {
		inf.setBounds(0, 0, 190, 150);
		inf.setLayout(null);
		inf.setVisible(true);
		inf.setBackground(Color.darkGray);
		
		tap.setBounds(5, 10, 190, 18);
		tap.setFont(new Font("굴림", Font.BOLD, 15));
		tap.setVisible(true);
		tap.setForeground(Color.white);
		
		moneyL.setBounds(10, 45, 180, 18);
		moneyL.setFont(new Font("굴림", Font.BOLD, 15));
		moneyL.setVisible(true);
		moneyL.setForeground(Color.white);
		
		diaL.setBounds(10, 80, 180, 18);
		diaL.setFont(new Font("굴림", Font.BOLD, 15));
		diaL.setVisible(true);
		diaL.setForeground(Color.white);
		
		auto.setBounds(10, 115, 180, 18);
		auto.setFont(new Font("굴림", Font.BOLD, 15));
		auto.setVisible(true);
		auto.setForeground(Color.white);
		
		inf.add(tap);
		inf.add(moneyL);
		inf.add(diaL);
		inf.add(auto);
		
		f.add(inf);
	}
	
	static JPanel shop = new JPanel();
	static JButton shopExit = new JButton("x");
	
	/*-----------------------돈돈돈돈돈-----------------------*/
	static int tapMoney = 100; static int tapMoneyLv = 1;
	static int tapDia = 1; static int tapDiaLv = 1;
	static int autoMoney = 1000; static int autoMoneyLv = 1;
	/*-----------------------돈돈돈돈돈-----------------------*/
	
	ImageIcon plusButton = new ImageIcon(Main.class.getResource("/image/plusButton.png"));
	
	static JButton[] buttons = new JButton[3];
	
	static JLabel tapUpgradeMoney_label = new JLabel("Lv." + tapMoneyLv + " tap 강화(◇) - " + tapMoney);
	static JLabel tapUpgradeDia_label = new JLabel("Lv." + tapDiaLv + " tap 강화(★) - " + tapDia);
	static JLabel autoUpgradeMoney_label = new JLabel("Lv." + autoMoneyLv + " auto 강화(◇) - " + autoMoney);
	
	public void madeShop() {
		shop.setBounds(200, 60, 500, 450);
		shop.setLayout(null);
		shop.setVisible(false);
		shop.setBackground(Color.darkGray);
		
		shopExit.setBounds(460, 0, 40, 40);
		shopExit.setVisible(false);
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(plusButton);
			buttons[i].setBounds(430, ((i + 1) * 100), 40, 40);
			buttons[i].setVisible(false);
			
			buttons[i].setBorderPainted(false);
			buttons[i].setFocusPainted(false);
			buttons[i].setContentAreaFilled(false);
			
			buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			shop.add(buttons[i]);
		}
		
		tapUpgradeMoney_label.setBounds(90, 110, 400, 30);
		tapUpgradeMoney_label.setVisible(false);
		tapUpgradeMoney_label.setFont(new Font("굴림", Font.BOLD, 20));
		tapUpgradeMoney_label.setForeground(Color.white);
		
		tapUpgradeDia_label.setBounds(90, 210, 400, 30);
		tapUpgradeDia_label.setVisible(false);
		tapUpgradeDia_label.setFont(new Font("굴림", Font.BOLD, 20));
		tapUpgradeDia_label.setForeground(Color.white);
		
		autoUpgradeMoney_label.setBounds(90, 310, 400, 30);
		autoUpgradeMoney_label.setVisible(false);
		autoUpgradeMoney_label.setFont(new Font("굴림", Font.BOLD, 20));
		autoUpgradeMoney_label.setForeground(Color.white);
		
		shop.add(tapUpgradeMoney_label);
		shop.add(tapUpgradeDia_label);
		shop.add(autoUpgradeMoney_label);
		
		shop.add(shopExit);
		
		f.add(shop);
	}
	
	
	static JPanel job = new JPanel();
	static JButton jobExit = new JButton("x");
	
	static ImageIcon job1Image = new ImageIcon(Main.class.getResource("/image/job1.png"));
	static ImageIcon job2Image = new ImageIcon(Main.class.getResource("/image/job2.png"));
	
	static JButton job1 = new JButton(job1Image);
	static JButton job2 = new JButton(job2Image);
	
	
	public void madeJob() {
		job.setBounds(200, 60, 500, 450);
		job.setLayout(null);
		job.setVisible(false);
		job.setBackground(Color.darkGray);
		
		jobExit.setBounds(460, 0, 40, 40);
		jobExit.setVisible(false);

		job1.setBounds(20,50,220,380);
		job1.setBorderPainted(false);
		job1.setFocusPainted(false);
		job1.setContentAreaFilled(false);
		job1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		job1.setVisible(false);
		
		job2.setBounds(260,50,220,380);
		job2.setBorderPainted(false);
		job2.setFocusPainted(false);
		job2.setContentAreaFilled(false);
		job2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		job2.setVisible(false);
		
		job.add(jobExit);
		job.add(job1);
		job.add(job2);
		
		f.add(job);
	}
	
	static JPanel dungeon = new JPanel();
	static JButton dungeonExit = new JButton("x");
	static JButton monsterExit = new JButton("exit");
	
	static JButton left = new JButton(new ImageIcon(Main.class.getResource("/image/left.png")));
	static JButton right = new JButton(new ImageIcon(Main.class.getResource("/image/right.png")));
	
	static JButton d1 = new JButton("dungeon1");
	static JButton d2 = new JButton("dungeon2");
	static JButton d3 = new JButton("dungeon3");
	
	static String[] monsterImages1 = {"/monsterImage/monster1_1.png", "/monsterImage/monster1_2.png", "/monsterImage/monster1_3.png", "/monsterImage/monster1_4.png", "/monsterImage/monster1_5.png"};
	static JButton monster1 = new JButton(new ImageIcon(Main.class.getResource("/monsterImage/monster1_1.png")));
	
	static String[] monsterImages2 = {"/monsterImage/monster2_1.png", "/monsterImage/monster2_2.png", "/monsterImage/monster2_3.png", "/monsterImage/monster2_4.png", "/monsterImage/monster2_5.png"};
	static JButton monster2 = new JButton(new ImageIcon(Main.class.getResource("/monsterImage/monster2_1.png")));
	
	static String[] monsterImages3 = {"/monsterImage/monster3_1.png", "/monsterImage/monster3_2.png", "/monsterImage/monster3_3.png", "/monsterImage/monster3_4.png", "/monsterImage/monster3_5.png"};
	static JButton monster3 = new JButton(new ImageIcon(Main.class.getResource("/monsterImage/monster3_1.png")));
	
	static JLabel hp = new JLabel("0");
	static JLabel stage = new JLabel("0-0");
	
	public void madeDungeon() {
		dungeon.setBounds(200, 60, 500, 450);
		dungeon.setLayout(null);
		dungeon.setVisible(false);
		dungeon.setBackground(Color.darkGray);
		
		dungeonExit.setBounds(460, 0, 40, 40);
		dungeonExit.setVisible(false);
		
		monsterExit.setBounds(10, 500, 100, 50);
		monsterExit.setVisible(false);
		
		left.setBounds(350, 30, 30, 60);
		left.setCursor(new Cursor(Cursor.HAND_CURSOR));
		left.setVisible(false);
		left.setBorderPainted(false);
		left.setFocusPainted(false);
		left.setContentAreaFilled(false);
		
		right.setBounds(510, 30, 30, 60);
		right.setCursor(new Cursor(Cursor.HAND_CURSOR));
		right.setVisible(false);
		right.setBorderPainted(false);
		right.setFocusPainted(false);
		right.setContentAreaFilled(false);
		
		d1.setBounds(50, 50, 400, 100);
		d1.setVisible(false);
		
		d2.setBounds(50, 175, 400, 100);
		d2.setVisible(false);
		
		d3.setBounds(50, 300, 400, 100);
		d3.setVisible(false);
		
		monster1.setBounds(295, 200, 300, 300);
		monster1.setVisible(false);
		monster1.setBorderPainted(false);
		monster1.setFocusPainted(false);
		monster1.setContentAreaFilled(false);
		monster1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		monster2.setBounds(295, 200, 300, 300);
		monster2.setVisible(false);
		monster2.setBorderPainted(false);
		monster2.setFocusPainted(false);
		monster2.setContentAreaFilled(false);
		monster2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		monster3.setBounds(295, 200, 300, 300);
		monster3.setVisible(false);
		monster3.setBorderPainted(false);
		monster3.setFocusPainted(false);
		monster3.setContentAreaFilled(false);
		monster3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		f.add(monster1);
		f.add(monster2);
		f.add(monster3);
		
		hp.setHorizontalAlignment(JLabel.CENTER);
		hp.setBounds(0, 130, 895, 32);
		hp.setFont(new Font("굴림", Font.BOLD, 30));
		hp.setVisible(false);
		hp.setForeground(Color.white);
		
		stage.setBounds(408, 40, 100, 42);
		stage.setFont(new Font("굴림", Font.BOLD, 40));
		stage.setVisible(false);
		stage.setForeground(Color.white);
		
		dungeon.add(d1);
		dungeon.add(d2);
		dungeon.add(d3);
		dungeon.add(dungeonExit);
		
		f.add(stage);
		f.add(hp);
		f.add(left);
		f.add(right);
		f.add(monsterExit);
		f.add(dungeon);
	}
	
	static JPanel bossDungeon = new JPanel();
	static JButton bossDungeonExit = new JButton("x");
	static JLabel dontUseAuto = new JLabel("* AUTO 사용 불가 *");
	
	static JButton b1 = new JButton("bossDungeon1");
	static JButton b2 = new JButton("bossDungeon2");
	static JButton b3 = new JButton("bossDungeon3");
	
	static JButton boss = new JButton("boss");
	
	static JPanel bossHpBar = new JPanel();
	static JPanel bossCountdownBar = new JPanel();
	
	public void madeBossDungeon(){
		bossDungeon.setBounds(200, 60, 500, 450);
		bossDungeon.setLayout(null);
		bossDungeon.setVisible(false);
		bossDungeon.setBackground(Color.darkGray);
		
		bossDungeonExit.setBounds(460, 0, 40, 40);
		bossDungeonExit.setVisible(false);
		
		dontUseAuto.setBounds(135, 10, 300, 30);
		dontUseAuto.setVisible(false);
		dontUseAuto.setFont(new Font("굴림", Font.BOLD, 25));
		dontUseAuto.setForeground(Color.white);
		
		bossHpBar.setBounds(250, 50, 400, 40);
		bossHpBar.setLayout(null);
		bossHpBar.setVisible(false);
		bossHpBar.setBackground(Color.red);
		
		bossCountdownBar.setBounds(250, 90, 400, 20);
		bossCountdownBar.setLayout(null);
		bossCountdownBar.setVisible(false);
		bossCountdownBar.setBackground(Color.green);
		
		b1.setBounds(50, 50, 400, 100);
		b1.setVisible(false);
		
		b2.setBounds(50, 175, 400, 100);
		b2.setVisible(false);
		
		b3.setBounds(50, 300, 400, 100);
		b3.setVisible(false);
		
		boss.setBounds(275, 170, 350, 350);
		boss.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boss.setVisible(false);
		boss.setBorderPainted(false);
		boss.setFocusPainted(false);
		boss.setContentAreaFilled(false);
		
		bossDungeon.add(dontUseAuto);
		bossDungeon.add(b1);
		bossDungeon.add(b2);
		bossDungeon.add(b3);
		bossDungeon.add(bossDungeonExit);
		
		f.add(bossCountdownBar);
		f.add(bossHpBar);
		f.add(boss);
		f.add(bossDungeon);
	}
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.frame();
		
		ShopEvent shop = new ShopEvent();
		shop.shopEventer();
		
		JobEvent job = new JobEvent();
		job.jobEventer();
		
		DungeonEvent dungeon = new DungeonEvent();
		dungeon.dungeonEventer();
		dungeon.monsterEventer();
		
		BossDungeonEvent bossDungeon = new BossDungeonEvent();
		bossDungeon.bossDungeonEventer();
		bossDungeon.bossEventer();
		
		Save.input();
		Save.output();
	}

}





