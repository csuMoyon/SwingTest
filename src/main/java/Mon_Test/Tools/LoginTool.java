package Mon_Test.Tools;

import javax.swing.*;
import java.sql.*;

public class LoginTool {
    /**
     * 判断字符串是否为空
     * @param str 接收的字符串
     * @return 返回的结果
     */
    public boolean isEmpty(String str){
        return str==null||"".equals(str.trim());
    }

    /**
     * 验证登录信息
     * @param jPanel 面板
     * @param userText 用户名
     * @param passText 密码
     * @param status 身份，0表示学生，1表示教师
     * @return 返回一个boolean型的值
     */
    public static boolean isLogin(JPanel jPanel,String userText,String passText,int status){
        LoginTool loginTool = new LoginTool();
        if(loginTool.isEmpty(userText)&&!loginTool.isEmpty(passText)){
            JOptionPane.showMessageDialog(jPanel,"用户名不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!loginTool.isEmpty(userText)&& loginTool.isEmpty(passText)){
            JOptionPane.showMessageDialog(jPanel,"密码不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(loginTool.isEmpty(userText)&& loginTool.isEmpty(passText)){
            JOptionPane.showMessageDialog(jPanel,"用户名和密码不能同时为空！","提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!check(userText, passText,status)){
            JOptionPane.showMessageDialog(jPanel,"用户名或密码错误！","提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(check(userText, passText,status)){
            JOptionPane.showMessageDialog(jPanel,"登录成功！页面即将跳转","提示",JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    /**
     * 结合数据库进行检验
     * @param user 用户名
     * @param pas 密码
     * @param status 身份，0表示学生，1表示教师
     * @return 返回一个boolean型的值
     */
    public static boolean check(String user,String pas,int status){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://rm-bp13q56zxy7l79i117o.mysql.rds.aliyuncs.com:3306/Test?serverTimezone=GMT&useSSL=false",
                    "zllw","zllw619@");
            String sql = "select * from demo where username = ? and password = ? and status = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pas);
            preparedStatement.setInt(3,status);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return true;
            }
        }catch(ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try{
                    resultSet.close();
                }catch (SQLException e){
                    System.out.println("resultSet error~");
                }
            }
            if(preparedStatement!=null){
                try{
                    preparedStatement.close();
                }catch (SQLException e){
                    System.out.println("preparedStatement error~");
                }
            }
            if(connection!=null){
                try{
                    connection.close();
                }catch (SQLException e){
                    System.out.println("connection error~");
                }
            }
        }
        return false;
    }
}
