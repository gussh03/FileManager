import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Created by hyeon-yeong on 2017. 1. 26..
 */
public class mainForm {
    private static JFrame frame;
    private JPanel mainFrame;
    private JPanel top;
    private JPanel bottom;
    private JPanel center;
    private JPanel contentLabel;
    private JLabel name;
    private JPanel content;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton Login;
    private JButton JOININButton;
    private JLabel ID;
    Vector vec = null;
    public mainForm() {
        ConnectServer connectServer = new ConnectServer();
        JOININButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                joinForm join = new joinForm(connectServer);
            }
        });

        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String li[];
                String ID = textField1.getText();
                String PW = new String(passwordField1.getPassword());
                connectServer.Login(ID, PW);
                String temp = connectServer.getData1();
                li = temp.split(","); //temp 는 사용자 계정 만들때 생성한 폴더 이름
                if (!(li[0].equals("F"))) {
                    frame.dispose();
                    vec = connectServer.getVecData();
                    contentForm contentForm = new contentForm(connectServer, temp, vec);
                } else {
                    JOptionPane.showMessageDialog(null, "ID와 PWD를 정확히 입력해주세요", "Warning", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    public static void main(String[] args) {
        frame = new JFrame("File Manager");
        frame.setSize(500, 400);
        frame.setLocation(300, 200);
        frame.setContentPane(new mainForm().mainFrame);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainFrame = new JPanel();
        mainFrame.setLayout(new BorderLayout(0, 0));
        mainFrame.setBackground(new Color(-1));
        mainFrame.setOpaque(true);
        top = new JPanel();
        top.setLayout(new BorderLayout(0, 0));
        top.setBackground(new Color(-157030));
        top.setPreferredSize(new Dimension(0, 20));
        mainFrame.add(top, BorderLayout.NORTH);
        bottom = new JPanel();
        bottom.setLayout(new BorderLayout(0, 0));
        bottom.setBackground(new Color(-79671));
        bottom.setPreferredSize(new Dimension(0, 20));
        mainFrame.add(bottom, BorderLayout.SOUTH);
        center = new JPanel();
        center.setLayout(new BorderLayout(0, 0));
        center.setBackground(new Color(-1));
        center.setForeground(new Color(-12300455));
        center.setInheritsPopupMenu(false);
        mainFrame.add(center, BorderLayout.CENTER);
        contentLabel = new JPanel();
        contentLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        contentLabel.setBackground(new Color(-1));
        contentLabel.setPreferredSize(new Dimension(0, 40));
        center.add(contentLabel, BorderLayout.NORTH);
        name = new JLabel();
        name.setFont(new Font("Andale Mono", Font.BOLD, 18));
        name.setForeground(new Color(-12300455));
        name.setOpaque(false);
        name.setPreferredSize(new Dimension(140, 35));
        name.setText("FILE MANAGER");
        contentLabel.add(name);
        content = new JPanel();
        content.setLayout(new GridBagLayout());
        content.setBackground(new Color(-1));
        content.setOpaque(false);
        center.add(content, BorderLayout.CENTER);
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        content.add(spacer2, gbc);
        textField1 = new JTextField();
        textField1.setBackground(new Color(-1));
        textField1.setOpaque(false);
        textField1.setPreferredSize(new Dimension(150, 24));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(textField1, gbc);
        ID = new JLabel();
        ID.setFont(new Font("Apple Chancery", Font.BOLD, 14));
        ID.setForeground(new Color(-12300455));
        ID.setOpaque(false);
        ID.setPreferredSize(new Dimension(20, 24));
        ID.setText("ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        content.add(ID, gbc);
        passwordField1 = new JPasswordField();
        passwordField1.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(passwordField1, gbc);
        final JLabel label1 = new JLabel();
        label1.setFont(new Font("Apple Chancery", Font.BOLD, 14));
        label1.setForeground(new Color(-12300455));
        label1.setPreferredSize(new Dimension(80, 24));
        label1.setText("PASSWORD");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        content.add(label1, gbc);
        Login = new JButton();
        Login.setBackground(new Color(-157030));
        Login.setBorderPainted(true);
        Login.setContentAreaFilled(false);
        Login.setInheritsPopupMenu(false);
        Login.setLabel("LOGIN");
        Login.setText("LOGIN");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(Login, gbc);
        JOININButton = new JButton();
        JOININButton.setActionCommand("joinBtn");
        JOININButton.setBackground(new Color(-1));
        JOININButton.setText("JOIN IN?");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(JOININButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainFrame;
    }
}
