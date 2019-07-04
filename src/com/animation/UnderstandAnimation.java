package com.animation;

import javax.swing.JFrame;

public class UnderstandAnimation {

	public static void main(String[] args) {
		JFrame frm = new JFrame("¿ÌΩ‚∂Øª≠");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);
		
		AnimationPanel ap = new AnimationPanel();
		ap.setBounds(0, 0, 400, 200);
		frm.getContentPane().add(ap);
		
		frm.setBounds(400, 200, 400, 200);
		frm.setVisible(true);
	}

}
