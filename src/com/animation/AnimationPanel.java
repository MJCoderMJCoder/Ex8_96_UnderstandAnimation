package com.animation;

import java.awt.Graphics;

import javax.swing.JPanel;

class AnimationPanel extends JPanel implements Runnable {
	/*使用Runnable接口创建线程的步骤：
	 * 1、实现Runable接口，并在实现了该接口的类的run()方法里编写想让线程执行的代码
	 * 2、创建实现了Runnabled接口类的实例
	 * 3、创建线程类的实例，并用构造方法Thread(Runnable target)将实现了Runnabled接口类的实例赋值给target
	 */
	Thread runner;
	int r = 25, x = 0, y = 0, d = 1;
	
	AnimationPanel() { //构造方法：子类先隐式调用父类构造方法；构造方法没有返回值类型
		start();
	}

	public void start() {
		if (runner == null) // ==：关系运算符
			runner = new Thread(this); //this代表实例对象自身
		runner.start();
	}

	@Override
	public void run() {
		while (true) {
			x = x + d;
			y = y + d;
			if (x > 400 - 2 * r) //防止越界
				x = r;
			if (y > 200 - 2 * r)
				y = r;
			repaint();	//绘制一帧图像
			try {
				Thread.sleep(33);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Graphics需要一个画板（每个Java组件就是画板），在画板上直接画图，
	public void paint(Graphics g) { //重载paint()方法，在该方法中使用系统传入的Graphics对象g绘制图形。
		g.clearRect(0, 0, 400, 200); //清除矩形区图像
		g.drawOval(x, y, r, r); //绘制圆或椭圆
	}

}
