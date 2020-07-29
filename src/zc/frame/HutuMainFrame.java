package zc.frame;


import zc.panel.MainPanel;
import zc.panel.SpendPanel;

import javax.swing.JFrame;

public class HutuMainFrame extends JFrame{
    public static HutuMainFrame instance = new HutuMainFrame();

    private HutuMainFrame(){
        this.setSize(500,450);
        this.setTitle("一本糊涂账1");
        this.setContentPane(MainPanel.instance);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }

}