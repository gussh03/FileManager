import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hyeon-yeong on 2017. 2. 7..
 */
public class joinForm {
    private JPanel mainPanel;
    private JPanel top;
    private JPanel bottom;
    private JPanel center;
    private JPanel contentLabel;
    private JPanel content;
    private JLabel joinLabel;
    private JTextField ID;
    private JLabel IDLabel;
    private JPasswordField pwd;
    private JButton checkButton;
    private JTextField fileName;
    private JPasswordField pwdCheck;
    private JButton JOINButton;
    private static JFrame frame;

    public joinForm(ConnectServer cs) {

        frame = new JFrame("Join In");
        frame.setContentPane(mainPanel);
        frame.setSize(400, 400);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        checkButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String ls[];
                String ID1 = "B," + ID.getText() + ",";
                cs.sendData(ID1);
                String temp = cs.getData();
                ls = temp.split(",");
                if (ls[0].equals("T")) {
                    JOptionPane.showMessageDialog(null, "ID를 사용하실수 있습니다", "OK", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "ID가 이미 사용중입니다.", "Warning", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JOINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = ID.getText();
                String pw = new String(pwd.getPassword());
                String pw2 = new String(pwdCheck.getPassword());
                String fiName = fileName.getText();
                if (pw.equals(pw2)) {
                    cs.joinData(id, pw, pw2, fiName);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "패스워드 2개가 일치하지 않습니다.", "Warning", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
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
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBackground(new Color(-1));
        top = new JPanel();
        top.setLayout(new BorderLayout(0, 0));
        top.setBackground(new Color(-157030));
        top.setPreferredSize(new Dimension(0, 20));
        mainPanel.add(top, BorderLayout.NORTH);
        bottom = new JPanel();
        bottom.setLayout(new BorderLayout(0, 0));
        bottom.setBackground(new Color(-79671));
        bottom.setPreferredSize(new Dimension(0, 20));
        mainPanel.add(bottom, BorderLayout.SOUTH);
        center = new JPanel();
        center.setLayout(new BorderLayout(0, 0));
        center.setOpaque(false);
        mainPanel.add(center, BorderLayout.CENTER);
        contentLabel = new JPanel();
        contentLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        contentLabel.setOpaque(false);
        contentLabel.setPreferredSize(new Dimension(0, 40));
        center.add(contentLabel, BorderLayout.NORTH);
        joinLabel = new JLabel();
        joinLabel.setFont(new Font("Andale Mono", Font.PLAIN, 18));
        joinLabel.setForeground(new Color(-12300455));
        joinLabel.setPreferredSize(new Dimension(100, 35));
        joinLabel.setText("Join In");
        contentLabel.add(joinLabel);
        content = new JPanel();
        content.setLayout(new GridBagLayout());
        content.setAlignmentX(0.5f);
        content.setAlignmentY(0.5f);
        content.setBackground(new Color(-1));
        content.setOpaque(false);
        center.add(content, BorderLayout.CENTER);
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        content.add(spacer2, gbc);
        ID = new JTextField();
        ID.setBackground(new Color(-1));
        ID.setOpaque(false);
        ID.setPreferredSize(new Dimension(140, 24));
        ID.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(ID, gbc);
        IDLabel = new JLabel();
        IDLabel.setFont(new Font("Andale Mono", Font.PLAIN, 14));
        IDLabel.setForeground(new Color(-12300455));
        IDLabel.setPreferredSize(new Dimension(30, 16));
        IDLabel.setText("ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        content.add(IDLabel, gbc);
        pwd = new JPasswordField();
        pwd.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(pwd, gbc);
        final JLabel label1 = new JLabel();
        label1.setFont(new Font("Andale Mono", Font.PLAIN, 14));
        label1.setForeground(new Color(-12300455));
        label1.setPreferredSize(new Dimension(80, 16));
        label1.setText("PASSWORD");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        content.add(label1, gbc);
        checkButton = new JButton();
        checkButton.setOpaque(false);
        checkButton.setText("check");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(checkButton, gbc);
        final JLabel label2 = new JLabel();
        label2.setFont(new Font("Andale Mono", Font.PLAIN, 14));
        label2.setForeground(new Color(-12300455));
        label2.setPreferredSize(new Dimension(80, 16));
        label2.setText("PWD CHECK");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        content.add(label2, gbc);
        pwdCheck = new JPasswordField();
        pwdCheck.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(pwdCheck, gbc);
        final JLabel label3 = new JLabel();
        label3.setFont(new Font("Andale Mono", Font.PLAIN, 14));
        label3.setForeground(new Color(-12300455));
        label3.setPreferredSize(new Dimension(80, 16));
        label3.setText("저장소 이름");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        content.add(label3, gbc);
        fileName = new JTextField();
        fileName.setBackground(new Color(-1));
        fileName.setOpaque(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(fileName, gbc);
        JOINButton = new JButton();
        JOINButton.setOpaque(false);
        JOINButton.setText("JOIN");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        content.add(JOINButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
