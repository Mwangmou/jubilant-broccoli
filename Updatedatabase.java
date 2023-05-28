package yingpianxinxiGL;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shujukulianjie.Mysql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updatedatabase extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldid;
    private JTextField textFieldname;
    private JTextField textFieldhot;
    private JTextField textFielddirector;
    private JTextField textFieldactor;
    private JTextField textFieldstartdate;
    private JTextField textFieldenddate;
    private JTextField textFieldMovieduration;
    private JTextField textFieldfare;
    private JTextField textFieldMoviegenre;
    private JTextField textFieldcountry;
    private JTextField textFieldsynopsis;
    private JTextField textFieldscore;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Updatedatabase frame = new Updatedatabase();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Updatedatabase() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 450, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEnterid = new JLabel("请输入要更新的记录id：");
        lblEnterid.setBounds(74, 30, 160, 16);
        contentPane.add(lblEnterid);

        JLabel lblname = new JLabel("影片名：");
        lblname.setBounds(74, 70, 160, 16);
        contentPane.add(lblname);

        JLabel lblhot = new JLabel("热度：");
        lblhot.setBounds(74, 110, 160, 16);
        contentPane.add(lblhot);

        JLabel lbldirector = new JLabel("导演：");
        lbldirector.setBounds(74, 150, 160, 16);
        contentPane.add(lbldirector);

        JLabel lblactor = new JLabel("主演：");
        lblactor.setBounds(74, 190, 160, 16);
        contentPane.add(lblactor);
        
        JLabel lblstartdate = new JLabel("上映时间：");
        lblstartdate.setBounds(74, 230, 160, 16);
        contentPane.add(lblstartdate);
        
        JLabel lblenddate = new JLabel("下映时间：");
        lblenddate.setBounds(74, 270, 160, 16);
        contentPane.add(lblenddate);
        
        JLabel lblMovieduration = new JLabel("时长：");
        lblMovieduration.setBounds(74, 310, 160, 16);
        contentPane.add(lblMovieduration);
        
        JLabel lblfare = new JLabel("票价：");
        lblfare.setBounds(74, 350, 160, 16);
        contentPane.add(lblfare);
        
        JLabel lblMoviegenre = new JLabel("类型：");
        lblMoviegenre.setBounds(74, 390, 160, 16);
        contentPane.add(lblMoviegenre);
        
        JLabel lblcountry = new JLabel("国家：");
        lblcountry.setBounds(74, 430, 160, 16);
        contentPane.add(lblcountry);
        
        JLabel lblsynopsis = new JLabel("简介：");
        lblsynopsis.setBounds(74, 470, 160, 16);
        contentPane.add(lblsynopsis);
        
        JLabel lblscore = new JLabel("评分：");
        lblscore.setBounds(74, 510, 160, 16);
        contentPane.add(lblscore);
        
        //
        textFieldid = new JTextField();
        textFieldid.setBounds(246, 25, 130, 26);
        contentPane.add(textFieldid);
        textFieldid.setColumns(10);

        textFieldname = new JTextField();
        textFieldname.setBounds(246, 65, 130, 26);
        contentPane.add(textFieldname);
        textFieldname.setColumns(10);

        textFieldhot = new JTextField();
        textFieldhot.setBounds(246, 105, 130, 26);
        contentPane.add(textFieldhot);
        textFieldhot.setColumns(10);

        textFielddirector = new JTextField();
        textFielddirector.setBounds(246, 145, 130, 26);
        contentPane.add(textFielddirector);
        textFielddirector.setColumns(10);
        
        textFieldactor = new JTextField();
        textFieldactor.setBounds(246, 185, 130, 26);
        contentPane.add(textFieldactor);
        textFieldactor.setColumns(10);
        
        textFieldstartdate = new JTextField();
        textFieldstartdate.setBounds(246, 225, 130, 26);
        contentPane.add(textFieldstartdate);
        textFieldstartdate.setColumns(10);
        
        textFieldenddate = new JTextField();
        textFieldenddate.setBounds(246, 265, 130, 26);
        contentPane.add(textFieldenddate);
        textFieldenddate.setColumns(10);
        
        textFieldMovieduration = new JTextField();
        textFieldMovieduration.setBounds(246, 305, 130, 26);
        contentPane.add(textFieldMovieduration);
        textFieldMovieduration.setColumns(10);
        
        textFieldfare = new JTextField();
        textFieldfare.setBounds(246, 345, 130, 26);
        contentPane.add(textFieldfare);
        textFieldfare.setColumns(10);
        
        textFieldMoviegenre = new JTextField();
        textFieldMoviegenre.setBounds(246, 385, 130, 26);
        contentPane.add(textFieldMoviegenre);
        textFieldMoviegenre.setColumns(10);
        
        textFieldcountry = new JTextField();
        textFieldcountry.setBounds(246, 425, 130, 26);
        contentPane.add(textFieldcountry);
        textFieldcountry.setColumns(10);
        
        textFieldsynopsis = new JTextField();
        textFieldsynopsis.setBounds(246, 465, 130, 26);
        contentPane.add(textFieldsynopsis);
        textFieldsynopsis.setColumns(10);
        
        textFieldscore = new JTextField();
        textFieldscore.setBounds(246, 505, 130, 26);
        contentPane.add(textFieldscore);
        textFieldscore.setColumns(10);

        JButton btnUpdate = new JButton("更新");
        
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldid.getText());
                String name = textFieldname.getText();
                String hot = textFieldhot.getText();
                String director = textFielddirector.getText();
                String actor = textFieldactor.getText();
                String startdate = textFieldstartdate.getText();
                String enddate = textFieldenddate.getText();
                String Movieduration = textFieldMovieduration.getText();
                String fare = textFieldfare.getText();
                String Moviegenre = textFieldMoviegenre.getText();
                String country = textFieldcountry.getText();
                String synopsis = textFieldsynopsis.getText();
                String score = textFieldscore.getText();
                updateData(id, name, hot, director, actor, startdate, enddate, Movieduration, fare, Moviegenre, country, synopsis, score);
            }
        });
        btnUpdate.setBounds(246, 545, 130, 26);
        contentPane.add(btnUpdate);
    }

    /**
     * 更新数据
     * @param id 要更新的记录id
     * @param name 新的参数1
     * @param hot 新的参数2
     * @param director 新的参数3
     * ......
     */
    private void updateData(int id, String name, String hot, String director, String actor, String startdate, String enddate, String Movieduration, String fare, String Moviegenre, String country, String synopsis, String score) {
        Connection connection = null;

        try {
            // 连接数据库
        	connection = Mysql.getConnection();//已连接

            // 创建SQL语句
            String sql = "UPDATE movie SET name='?', hot='?' , director='?',actorid='?' ,  startdate='?' ,  enddate='?' ,  Movieduration='?'  , fare='?' , Moviegenre='?'  , country='?' , synopsis='?' ,  score='?'  WHERE id = '?'";

            // 创建PreparedStatement对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // 设置参数
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, hot);
            preparedStatement.setString(3, director);
            preparedStatement.setString(4, actor);
            preparedStatement.setString(5, startdate);
            preparedStatement.setString(6, enddate);
            preparedStatement.setString(7, Movieduration);
            preparedStatement.setString(8, fare);
            preparedStatement.setString(9, Moviegenre);
            preparedStatement.setString(10, country);
            preparedStatement.setString(11, synopsis);
            preparedStatement.setString(12, score);
            
            preparedStatement.setInt(13, id);

            // 执行更新操作
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("数据已更新成功");
                JOptionPane.showMessageDialog(Updatedatabase.this, "记录修改成功！");
            }
        } catch (SQLException ex) {
            System.out.println("更新数据时出现异常" + ex.getMessage());
        } finally {
            try {
                // 关闭数据库连接
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("关闭连接时出现异常" + ex.getMessage());
            }
        }
    }
}














//package yingpianxinxiGL;
//
//import java.awt.EventQueue;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import shujukulianjie.Mysql;
//
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class Updatedatabase extends JFrame {
//
//    private JPanel contentPane;
//    private JTextField textFieldId;
//    private JTextField textFieldValue;
//   
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Updatedatabase frame = new Updatedatabase();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * Create the frame.
//     */
//    public Updatedatabase() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 450, 300);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setTitle("修改电影信息");
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//        
//        JLabel lblEnterId = new JLabel("请输入要更新的记录id：");
//        lblEnterId.setBounds(74, 57, 160, 16);
//        contentPane.add(lblEnterId);
//        
//        JLabel lblEnterNewValue1 = new JLabel("请输入新的值：");
//        lblEnterNewValue1.setBounds(74, 104, 133, 16);
//        contentPane.add(lblEnterNewValue1);
//        
//        textFieldId = new JTextField();
//        textFieldId.setBounds(246, 52, 130, 26);
//        contentPane.add(textFieldId);
//        textFieldId.setColumns(10);
//        
//        textFieldValue = new JTextField();
//        textFieldValue.setBounds(246, 99, 130, 26);
//        contentPane.add(textFieldValue);
//        textFieldValue.setColumns(10);
//        
//        JButton btnUpdate = new JButton("更新");
//        btnUpdate.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int id = Integer.parseInt(textFieldId.getText());
//                String value = textFieldValue.getText();
//                updateData(id, value);
//            }
//        });
//        btnUpdate.setBounds(166, 162, 117, 29);
//        contentPane.add(btnUpdate);
//    }
//    
//    /**
//     * 更新数据
//     * @param id 要更新的记录id
//     * @param value 新的值
//     */
//    private void updateData(int id, String value) {
//        Connection connection = null;
//
//        try {
//            // 连接数据库
//          
//        	connection = Mysql.getConnection();//已连接
//            // 创建SQL语句
//            String sql = "UPDATE movie SET name=?  WHERE id = ?";
//
//            // 创建PreparedStatement对象
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            // 设置参数
//            preparedStatement.setString(1, value);
//            preparedStatement.setInt(2, id);
//
//            // 执行更新操作
//            int rowsUpdated = preparedStatement.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("数据已更新成功");
//            }
//        } catch (SQLException ex) {
//            System.out.println("更新数据时出现异常" + ex.getMessage());
//        } finally {
//            try {
//                // 关闭数据库连接
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("关闭连接时出现异常" + ex.getMessage());
//            }
//        }
//    }
//}
