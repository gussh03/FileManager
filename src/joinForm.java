import javax.swing.*;
import java.awt.*;

/**
 * Created by hyeon-yeong on 2017. 2. 7..
 */
public class joinForm {
    private JPanel mianPanel;
    private JPanel top;
    private JPanel bottom;
    private JPanel center;
    private JTextField ID;
    private JPasswordField pwd;
    private JButton btn;
    private JLabel idLabel;
    private JLabel pwdLabel;
    private JLabel JOIN;
    private JPasswordField pwdCheck;
    private JButton joinButton;
    private JFrame frame;

    void joinForm() {
        frame = new JFrame();
        frame.setSize(300, 400);
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
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
        mianPanel = new JPanel();
        mianPanel.setLayout(new BorderLayout(0, 0));
        mianPanel.setBackground(new Color(-1));
        top = new JPanel();
        top.setLayout(new BorderLayout(0, 0));
        top.setBackground(new Color(-157030));
        top.setPreferredSize(new Dimension(0, 20));
        mianPanel.add(top, BorderLayout.NORTH);
        bottom = new JPanel();
        bottom.setLayout(new BorderLayout(0, 0));
        bottom.setBackground(new Color(-79671));
        bottom.setPreferredSize(new Dimension(0, 20));
        mianPanel.add(bottom, BorderLayout.SOUTH);
        center = new JPanel();
        center.setLayout(new GridBagLayout());
        center.setOpaque(false);
        mianPanel.add(center, BorderLayout.CENTER);
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        center.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        center.add(spacer2, gbc);
        ID = new JTextField();
        ID.setBackground(new Color(-1));
        ID.setOpaque(false);
        ID.setPreferredSize(new Dimension(150, 24));
        ID.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        center.add(ID, gbc);
        pwd = new JPasswordField();
        pwd.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        center.add(pwd, gbc);
        btn = new JButton();
        btn.setBackground(new Color(-1));
        btn.setText("중복확인");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        center.add(btn, gbc);
        idLabel = new JLabel();
        idLabel.setFont(new Font("Apple Chancery", Font.BOLD, 16));
        idLabel.setForeground(new Color(-12300455));
        idLabel.setPreferredSize(new Dimension(50, 16));
        idLabel.setText("ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        center.add(idLabel, gbc);
        pwdLabel = new JLabel();
        pwdLabel.setFont(new Font("Apple Chancery", Font.BOLD, 16));
        pwdLabel.setForeground(new Color(-12300455));
        pwdLabel.setPreferredSize(new Dimension(100, 16));
        pwdLabel.setText("PASSWORD");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        center.add(pwdLabel, gbc);
        JOIN = new JLabel();
        JOIN.setBackground(new Color(-12300455));
        JOIN.setFont(new Font("Andale Mono", Font.BOLD, 36));
        JOIN.setForeground(new Color(-12300455));
        JOIN.setText("JOIN IN");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        center.add(JOIN, gbc);
        pwdCheck = new JPasswordField();
        pwdCheck.setAlignmentY(0.5f);
        pwdCheck.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        center.add(pwdCheck, gbc);
        joinButton = new JButton();
        joinButton.setBackground(new Color(-1));
        joinButton.setText("Join");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        center.add(joinButton, gbc);
        final JLabel label1 = new JLabel();
        label1.setFont(new Font("Apple Chancery", Font.BOLD, 14));
        label1.setForeground(new Color(-12300455));
        label1.setPreferredSize(new Dimension(150, 16));
        label1.setText("PASSWORD CHECK");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        center.add(label1, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mianPanel;
    }
}