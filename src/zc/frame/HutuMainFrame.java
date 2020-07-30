package zc.frame;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import zc.entity.Category;
import zc.panel.MainPanel;
import zc.panel.SpendPanel;

import javax.swing.JFrame;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

    public static void main(String[] args) throws IOException {
        instance.setVisible(true);
        MainPanel.instance.workingPanel.show(SpendPanel.instance);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        Category category = new Category();
        listAll(session);

        session.commit();
        session.close();
    }

    private static void listAll(SqlSession session) {

        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getId()+":"+c.getName());
        }
    }

}