package frontend;

import backend.Answer;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client extends javax.swing.JFrame {

    private static DataInputStream dis;
    private static DataOutputStream dos;
    private static Socket so;
    Server s =new Server();

    public Client(){
        initComponents();
    }
    @SuppressWarnings("unchecked")

    private void initComponents(){
        txtBotTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollPaneChat = new javax.swing.JScrollPane();
        labelChat = new javax.swing.JTextArea();
        txtChatUser = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chatbot By SK");

        txtBotTitle.setBackground(new java.awt.Color(255, 0, 51));
        txtBotTitle.setFont(new java.awt.font("Lithos Pro Regular", 1, 14));
        txtBotTitle.setForeground(new java.awt.Color(0,0,0));
        txtBotTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBotTitle.setText("Chatbot by SK");

        labelChat.setEditable(false);
        labelChat.setBackground(new java.awt.Color(0,0,0));
        labelChat.setColumns(20);
        labelChat.setForeground(new java.awt.Color(255,255,255));
        labelChat.setRows(5);
        labelChat.setText("----- hello----\n");
        scrollPaneChat.setViewportView(labelChat);

        txtChatUser.setBackground(new java.awt.Color(0,0,0));
        txtChatUser.setForeground(new java.awt.Color(255,255,255));
        txtChatUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChatUserActionPerformed(evt);
            }
        });

        btnSend.setBackground(new java.awt.Color(0,0,0));
        btnSend.setFont(new java.awt.Font("Hello", 1,12));
        btnSend.setForeground(new java.awt.Color(255,255,255));
        btnSend.setText("send");
        btnSend.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                btnSendActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.font("Hello", 1, 12));
        jLabel1.setText("Bot by Sk");

        jLabel2.setFont(new java.awt.Font("Hello", 1, 12));
        jLabel2.setText("Bot by SK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6,6,6)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(scrollPaneChat, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1))
                                        .addGroup((layout.createSequentialGroup()
                                                .addGroup(layout.createSequentialGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtChatUser, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(txtBotTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18,18,18)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSend)))
                                        .addContainerGap())
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtBotTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtChatUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(scrollPaneChat, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(13, 13, 13))
        );

        pack();
    }

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt){
        if(!txtChatUser.getText().equalsIgnoreCase("")){
            try {
                dos.writeUTF(txtChatUser.getText());
                if(txtChatUser.getText().equalsIgnoreCase("/quite")){
                    System.out.println("App has been terminated");
                    System.exit(0);
                } else{
                    String jawabanBot = dis.readUTF();
                    System.out.println("Respond" + jawabanBot);
                    labelChat.append("kamu: "+ txtChatUser.getText() + "\n" + jawabanBot+ "\n");
                    txtChatUser.setText("");
                    txtChatUser.requestFocus();
                }
            } catch (IOException e){
            }
        }else{
            labelChat.append("Kamu: \nBot: You cannot enter empty message\n");
        }
    }

    private void txtChatUserActionPerformed(java.awt.event.ActionEvent evt){

    }
    public static void main(String args[]){
        try{
            for(javax.swing.UIManager.setLookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex){
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null,ex);
        } catch (IllegalAccessException ex){
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new Client().setVisible(true);
            }
        });
        try{
            so=new Socket("127.0.0.1", 1239);
            dis= new DataInputStream(so.getInputStream());
            dos=new DataOutputStream(so.getOutputStream());
        } catch(IOException e){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea labelChat;
    private javax.swing.JScrollPane scrollPaneChat;
    private javax.swing.JLabel txtBotTitle;
    private javax.swing.JTextField txtChatUser;

}
