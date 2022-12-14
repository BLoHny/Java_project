package GSM_TapTapTap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class DungeonEvent {
	public void dungeonEventer() {
		Main.buildingButton[2].addActionListener(event->{
			for (int i = 0; i < 4; i++) {
				Main.buildingButton[i].setVisible(false);
			}
			Main.save.setVisible(false);
			Main.load.setVisible(false);
			
			Main.dungeon.setVisible(true);
			Main.dungeonExit.setVisible(true);
			Main.d1.setVisible(true);
			Main.d2.setVisible(true);
			Main.d3.setVisible(true);
			
		});
		
		Main.dungeonExit.addActionListener(event->{
			Main.dungeon.setVisible(false);
			Main.dungeonExit.setVisible(false);
			Main.d1.setVisible(false);
			Main.d2.setVisible(false);
			Main.d3.setVisible(false);
			
			Main.save.setVisible(true);
			Main.load.setVisible(true);
			for (int i = 0; i < 4; i++) {
				Main.buildingButton[i].setVisible(true);
			}
		});
		
		Main.monsterExit.addActionListener(event->{
			Main.monsterExit.setVisible(false);
			Main.left.setVisible(false);
			Main.right.setVisible(false);
			Main.monster1.setVisible(false);
			Main.monster2.setVisible(false);
			Main.monster3.setVisible(false);
			Main.hp.setVisible(false);
			Main.stage.setVisible(false);
			
			Main.save.setVisible(true);
			Main.load.setVisible(true);
			for (int i = 0; i < 4; i++) {
				Main.buildingButton[i].setVisible(true);
			}
			
			t.cancel();
			playAuto = false;
		});
		
		Main.d1.addActionListener(event->{
			Main.dungeon.setVisible(false);
			Main.dungeonExit.setVisible(false);
			Main.d1.setVisible(false);
			Main.d2.setVisible(false);
			Main.d3.setVisible(false);
			
			Main.stage.setVisible(true);
			Main.left.setVisible(true);
			Main.right.setVisible(true);
			Main.monsterExit.setVisible(true);
			Main.monster1.setVisible(true);
			
			playAuto = true;
			
			dungeon = 1;
			
			Main.stage.setText("1-" + (m1Indx + 1));
			
			monsterHp = monster1Hp[m1Indx];
			Main.hp.setText(""+Change.hpChange());
			Main.hp.setVisible(true);
			Timer();
		});
		
		Main.d2.addActionListener(event->{
			Main.dungeon.setVisible(false);
			Main.dungeonExit.setVisible(false);
			Main.d1.setVisible(false);
			Main.d2.setVisible(false);
			Main.d3.setVisible(false);
			
			Main.stage.setVisible(true);
			Main.left.setVisible(true);
			Main.right.setVisible(true);
			Main.monsterExit.setVisible(true);
			Main.monster2.setVisible(true);
			
			playAuto = true;
			
			dungeon = 2;
			
			Main.stage.setText("2-" + (m2Indx + 1));
			
			monsterHp = monster2Hp[m2Indx];
			Main.hp.setText(""+Change.hpChange());
			Main.hp.setVisible(true);
			Timer();
		});
		
		Main.d3.addActionListener(event->{
			Main.dungeon.setVisible(false);
			Main.dungeonExit.setVisible(false);
			Main.d1.setVisible(false);
			Main.d2.setVisible(false);
			Main.d3.setVisible(false);
			
			Main.stage.setVisible(true);
			Main.left.setVisible(true);
			Main.right.setVisible(true);
			Main.monsterExit.setVisible(true);
			Main.monster3.setVisible(true);
			
			playAuto = true;
			
			dungeon = 3;
			
			Main.stage.setText("3-" + (m3Indx + 1));
			
			monsterHp = monster3Hp[m3Indx];
			Main.hp.setText(""+Change.hpChange());
			Main.hp.setVisible(true);
			Timer();
		});
		
		Main.left.addActionListener(event->{
			if (dungeon == 1) {
				if (m1Indx != 0) {
					m1Indx--;
					Main.monster1.setIcon(new ImageIcon(Main.class.getResource(Main.monsterImages1[m1Indx])));
					monsterHp = monster1Hp[m1Indx];
					Main.hp.setText(""+Change.hpChange());
					Main.stage.setText("1-" + (m1Indx + 1));
					t.cancel();
					Timer();
				}
			}
			else if (dungeon == 2) {
				if (m2Indx != 0) {
					m2Indx--;
					Main.monster2.setIcon(new ImageIcon(Main.class.getResource(Main.monsterImages2[m2Indx])));
					monsterHp = monster2Hp[m2Indx];
					Main.hp.setText(""+Change.hpChange());
					Main.stage.setText("2-" + (m2Indx + 1));
					t.cancel();
					Timer();
				}
			}
			else if (dungeon == 3) {
				if (m3Indx != 0) {
					m3Indx--;
					Main.monster3.setIcon(new ImageIcon(Main.class.getResource(Main.monsterImages3[m3Indx])));
					monsterHp = monster3Hp[m3Indx];
					Main.hp.setText(""+Change.hpChange());
					Main.stage.setText("3-" + (m3Indx + 1));
					t.cancel();
					Timer();
				}
			}
		});
		
		Main.right.addActionListener(event->{
			if (dungeon == 1) {
				if (m1Indx != 4) {
					m1Indx++;
					Main.monster1.setIcon(new ImageIcon(Main.class.getResource(Main.monsterImages1[m1Indx])));
					monsterHp = monster1Hp[m1Indx];
					Main.hp.setText(""+Change.hpChange());
					Main.stage.setText("1-" + (m1Indx + 1));
					t.cancel();
					Timer();
				}
			}
			else if (dungeon == 2) {
				if (m2Indx != 4) {
					m2Indx++;
					Main.monster2.setIcon(new ImageIcon(Main.class.getResource(Main.monsterImages2[m2Indx])));
					monsterHp = monster2Hp[m2Indx];
					Main.hp.setText(""+Change.hpChange());
					Main.stage.setText("2-" + (m2Indx + 1));
					t.cancel();
					Timer();
				}
			}
			else if (dungeon == 3) {
				if (m3Indx != 4) {
					m3Indx++;
					Main.monster3.setIcon(new ImageIcon(Main.class.getResource(Main.monsterImages3[m3Indx])));
					monsterHp = monster3Hp[m3Indx];
					Main.hp.setText(""+Change.hpChange());
					Main.stage.setText("3-" + (m3Indx + 1));
					t.cancel();
					Timer();
				}
			}
		});
	}
	
	boolean playAuto = false; 
	
	int dungeon = 1;
	
	static double monsterHp;
	int monsterMoney;
	
	static int[] monster1Hp = {100, 500, 3000, 10000, 80000};
	static int[] monster1Money = {75, 300, 2000, 7000, 50000};
	
	static double[] monster2Hp = {300000, 1550000, 8880000, 32000000, 125000000};
	static double[] monster2Money = {200000, 1000000, 8880000, 25000000, 120000000};
	
	static double[] monster3Hp = {1550000000, 7250000000.0, 44500000000.0, 222222222222.0, 222222222222.0};
	static double[] monster3Money = {1275000000, 4825000000.0, 35250000000.0, 21212121212.0, 21212121212.0};
	
	int m1Indx = 0;
	int m2Indx = 0;
	int m3Indx = 0;
	
	Timer t;
	TimerTask task;
	public void Timer() {
		int auto = (int) (Main.autoTapSpeed * 1000);
		t = new Timer();
		task = new TimerTask() {
			@Override
			public void run() {
				if (playAuto == true) {
					if (Main.job1Check == false)
						monsterHp -= Main.damage;
					else
						monsterHp -= Main.damage * 2;
					
					if (monsterHp <= 0) {
						if (dungeon == 1) {
							monsterHp = monster1Hp[m1Indx];
							Main.money += monster1Money[m1Indx];
						}
						else if (dungeon == 2) {
							monsterHp = monster2Hp[m2Indx];
							Main.money += monster2Money[m2Indx];
						}
						else {
							monsterHp = monster3Hp[m3Indx];
							Main.money += monster3Money[m3Indx];
						}
						Main.hp.setText(""+Change.hpChange());
						Main.moneyL.setText("◇  : " + Change.change(Main.money));
					}
					else {
						Main.hp.setText(""+Change.hpChange());
					}
				}
				else {
					t.cancel();
				}
			}
		};
		t.schedule(task, 1000, auto);
	}
	
	public void monsterEventer() {
		Main.monster1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Main.job2Check == false) {
					if (Main.job1Check == false)
						monsterHp -= Main.damage;
					else
						monsterHp -= Main.damage * 2;
					
					if (monsterHp <= 0) {
						monsterHp = monster1Hp[m1Indx];
						Main.money += monster1Money[m1Indx];
						Main.hp.setText(""+Change.hpChange());
						Main.moneyL.setText("◇  : " + Change.change(Main.money));
					}
					else {
						Main.hp.setText(""+Change.hpChange());
					}
				}
			}
		});
		
		Main.monster2.addActionListener(event->{
			if (Main.job2Check == false) {
				if (Main.job1Check == false)
					monsterHp -= Main.damage;
				else
					monsterHp -= Main.damage * 2;
				
				if (monsterHp <= 0) {
					monsterHp = monster2Hp[m2Indx];
					Main.money += monster2Money[m2Indx];
					Main.hp.setText(""+Change.hpChange());
					Main.moneyL.setText("◇  : " + Change.change(Main.money));
				}
				else {
					Main.hp.setText(""+Change.hpChange());
				}
			}
		});
		
		Main.monster3.addActionListener(event->{
			if (Main.job2Check == false) {
				if (Main.job1Check == false)
					monsterHp -= Main.damage;
				else
					monsterHp -= Main.damage * 2;
				
				if (monsterHp <= 0) {
					monsterHp = monster3Hp[m3Indx];
					Main.money += monster3Money[m3Indx];
					Main.hp.setText(""+Change.hpChange());
					Main.moneyL.setText("◇  : " + Change.change(Main.money));
				}
				else {
					Main.hp.setText(""+Change.hpChange());
				}
			}
		});
	}
}







