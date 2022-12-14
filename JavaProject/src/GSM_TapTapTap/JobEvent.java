package GSM_TapTapTap;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;

public class JobEvent {
	DecimalFormat form = new DecimalFormat("#.##");
	static ImageIcon buyOk = new ImageIcon(Main.class.getResource("/image/jobBuyCheck.png"));
	
	public void jobEventer() {
		Main.buildingButton[1].addActionListener(event->{
			for (int i = 0; i < 4; i++) {
				Main.buildingButton[i].setVisible(false);
			}
			Main.save.setVisible(false);
			Main.load.setVisible(false);
			
			Main.job.setVisible(true);
			Main.job1.setVisible(true);
			Main.job2.setVisible(true);
			Main.jobExit.setVisible(true);
		});
		
		Main.jobExit.addActionListener(event->{
			Main.job.setVisible(false);
			Main.job1.setVisible(false);
			Main.job2.setVisible(false);
			Main.jobExit.setVisible(false);
			
			Main.save.setVisible(true);
			Main.load.setVisible(true);
			for (int i = 0; i < 4; i++) {
				Main.buildingButton[i].setVisible(true);
			}
		});
		
		Main.job1.addActionListener(event->{
			if (Main.job1Check == false) {
				if (Main.autoTapSpeed <= 0.5 && Main.money >= 1000000 && Main.dia >= 30) {
					Main.job1Check = true;
					Main.money -= 1000000;
					Main.dia -= 30; 
					
					Main.moneyL.setText("◇  : " + Change.change(Main.money));
					Main.diaL.setText("★  : " + Main.dia);
					
					Main.job1.setIcon(buyOk);
				}
			}
		});
		
		Main.job2.addActionListener(event->{
			if (Main.job2Check == false) {
				if (Main.autoTapSpeed <= 0.3 && Main.money >= 15000000 && Main.dia >= 100) {
					Main.job2Check = true;
					Main.autoTapSpeed = 0.05;
					Main.money -= 15000000;
					Main.dia -= 100; 
					
					Main.auto.setText("AUTO : " + form.format(Main.autoTapSpeed));
					Main.moneyL.setText("◇  : " + Change.change(Main.money));
					Main.diaL.setText("★  : " + Main.dia);
					
					Main.job2.setIcon(buyOk);
				}
			}
		});
	}
}
