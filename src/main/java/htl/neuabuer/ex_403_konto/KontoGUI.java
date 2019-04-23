package htl.neuabuer.ex_403_konto;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class KontoGUI extends javax.swing.JFrame {

    private DefaultListModel dlm = new DefaultListModel();
    private Konto account;
    private ArrayList<KontoBenutzer> list = new ArrayList<>();

    public KontoGUI() {
        initComponents();
        lilist.setModel(dlm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popmen1 = new javax.swing.JPopupMenu();
        miAddUser = new javax.swing.JMenuItem();
        mitest = new javax.swing.JMenuItem();
        popmen2 = new javax.swing.JPopupMenu();
        miaddKont = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        lilist = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        taLog = new javax.swing.JTextArea();
        lbBalance = new javax.swing.JLabel();

        miAddUser.setText("Add User");
        miAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddUserActionPerformed(evt);
            }
        });
        popmen1.add(miAddUser);

        mitest.setText("Test");
        mitest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitestActionPerformed(evt);
            }
        });
        popmen1.add(mitest);

        miaddKont.setText("Add Konto");
        miaddKont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miaddKontActionPerformed(evt);
            }
        });
        popmen2.add(miaddKont);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lilist.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "User", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        lilist.setComponentPopupMenu(popmen1);
        jScrollPane2.setViewportView(lilist);

        taLog.setEditable(false);
        taLog.setColumns(20);
        taLog.setRows(5);
        taLog.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Log"));
        taLog.setComponentPopupMenu(popmen2);
        jScrollPane1.setViewportView(taLog);

        lbBalance.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        lbBalance.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbBalance.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Balance"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddUserActionPerformed
        String name = JOptionPane.showInputDialog("Enter Name:");
        KontoBenutzer user = new KontoBenutzer(name, account, taLog);
        list.add(user);
        dlm.addElement(user);
    }//GEN-LAST:event_miAddUserActionPerformed

    private void mitestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitestActionPerformed
        for (int selectedIndice : lilist.getSelectedIndices()) {
            new Thread(list.get(selectedIndice)).start();
            repaint();
        }
        
    }//GEN-LAST:event_mitestActionPerformed

    private void miaddKontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miaddKontActionPerformed
        int amount = Integer.parseInt(JOptionPane.showInputDialog("Start-Amount:"));
        account = new Konto(amount, lbBalance);
    }//GEN-LAST:event_miaddKontActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KontoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new KontoGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbBalance;
    private javax.swing.JList<String> lilist;
    private javax.swing.JMenuItem miAddUser;
    private javax.swing.JMenuItem miaddKont;
    private javax.swing.JMenuItem mitest;
    private javax.swing.JPopupMenu popmen1;
    private javax.swing.JPopupMenu popmen2;
    private javax.swing.JTextArea taLog;
    // End of variables declaration//GEN-END:variables
}
