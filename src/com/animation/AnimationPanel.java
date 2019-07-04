package com.animation;

import java.awt.Graphics;

import javax.swing.JPanel;

class AnimationPanel extends JPanel implements Runnable {
	/*ʹ��Runnable�ӿڴ����̵߳Ĳ��裺
	 * 1��ʵ��Runable�ӿڣ�����ʵ���˸ýӿڵ����run()�������д�����߳�ִ�еĴ���
	 * 2������ʵ����Runnabled�ӿ����ʵ��
	 * 3�������߳����ʵ�������ù��췽��Thread(Runnable target)��ʵ����Runnabled�ӿ����ʵ����ֵ��target
	 */
	Thread runner;
	int r = 25, x = 0, y = 0, d = 1;
	
	AnimationPanel() { //���췽������������ʽ���ø��๹�췽�������췽��û�з���ֵ����
		start();
	}

	public void start() {
		if (runner == null) // ==����ϵ�����
			runner = new Thread(this); //this����ʵ����������
		runner.start();
	}

	@Override
	public void run() {
		while (true) {
			x = x + d;
			y = y + d;
			if (x > 400 - 2 * r) //��ֹԽ��
				x = r;
			if (y > 200 - 2 * r)
				y = r;
			repaint();	//����һ֡ͼ��
			try {
				Thread.sleep(33);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Graphics��Ҫһ�����壨ÿ��Java������ǻ��壩���ڻ�����ֱ�ӻ�ͼ��
	public void paint(Graphics g) { //����paint()�������ڸ÷�����ʹ��ϵͳ�����Graphics����g����ͼ�Ρ�
		g.clearRect(0, 0, 400, 200); //���������ͼ��
		g.drawOval(x, y, r, r); //����Բ����Բ
	}

}
