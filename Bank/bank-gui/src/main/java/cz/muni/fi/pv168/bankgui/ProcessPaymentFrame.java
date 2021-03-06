/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.bankgui;

import cz.fi.muni.pv168.bank.Account;
import cz.fi.muni.pv168.bank.AccountManager;
import cz.fi.muni.pv168.bank.BankManager;
import cz.fi.muni.pv168.bank.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Aneta Moravcikova
 */
public class ProcessPaymentFrame extends javax.swing.JFrame {

    private JFrame parent;
    private Person owner;
    private AccountManager accountManager;
    private BankManager bankManager;
    private final ResourceBundle bundle;
    private Object[] dataFrom;
    private Object[] dataTo;
    private final static Logger log = LoggerFactory.getLogger(ProcessPaymentFrame.class);

    /**
     * Creates new form ProcessPaymentForm
     */
    public ProcessPaymentFrame
     (AccountManager accM, BankManager bM, AccountsFrame aThis, Person owner, ResourceBundle bundle) {
        this.parent = aThis;
        this.owner = owner;
        this.accountManager = accM;
        this.bankManager = bM;
        this.bundle = bundle;
        setBoxes();
        this.setTitle(bundle.getString("processPayment"));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        processPayment = new javax.swing.JButton();
        sum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();

        processPayment.setText(bundle.getString("processPayment"));
        processPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processPaymentActionPerformed(evt);
            }
        });

        jLabel1.setText(bundle.getString("sum"));

        jLabel2.setText(bundle.getString("from"));

        jLabel3.setText(bundle.getString("to"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payment-icon.png"))); // NOI18N
        jLabel4.setText(bundle.getString("processPayment"));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(this.dataFrom));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(this.dataTo));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, 0, 90, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(processPayment)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(processPayment)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processPaymentActionPerformed

         
        Long fromNumber;
        Long toNumber;
        try {
            fromNumber = Long.parseLong(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
            toNumber = Long.parseLong(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()));
            if (fromNumber == toNumber) {
                throw new NumberFormatException();
            }            
        } catch (NumberFormatException ex){
            log.error("Wrong account(s) number");
            JOptionPane.showMessageDialog(rootPane, "Wrong account number(s), try again.");
            return;
        }
        Account fromAcc = accountManager.getAccount(fromNumber);
        Account toAcc = accountManager.getAccount(toNumber);
        if (toAcc == null) {            
            log.error("Wrong to account number");
            JOptionPane.showMessageDialog(rootPane, "Account you want to send money to doesnt exist.");
            return;
        }
        if (fromAcc == null) {            
            log.error("Wrong from account number");
            JOptionPane.showMessageDialog(rootPane, "Wrong From account.");
            return;
        }
        double sumDouble = 0.0;
        String sumString = sum.getText();
        if (sumString.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Sum is empty.");
            return;
        } else {
            try {
                sumDouble = Double.parseDouble(sumString);
                bankManager.processPayment(sumDouble, fromAcc, toAcc);
            } catch (NumberFormatException ex) {                
                log.error("Sum not double");
                JOptionPane.showMessageDialog(rootPane, "Sum must be double number.");
                return;
            }
        }
        AccountTableModel model = (AccountTableModel) ((AccountsFrame) parent).getTable().getModel();
        model.processPayment(sumDouble, fromAcc, toAcc);
        ((AccountsFrame) parent).getTable().setVisible(false);
        ((AccountsFrame) parent).getTable().setVisible(true);
        ((AccountTableModel) ((AccountsFrame) parent).getTable().getModel()).fireTableDataChanged();

        this.setVisible(false);
        this.parent.setVisible(false);
        new AccountsFrame(owner, (JFrame) this.parent.getParent(), bankManager, accountManager).setVisible(true);
    }//GEN-LAST:event_processPaymentActionPerformed


    
    private void setBoxes() {
        List<String> myDataTo = new ArrayList<>();
        List<String> myDataFrom = new ArrayList<>();
        for(Account acc : accountManager.findAllAccounts()) {
            myDataTo.add(acc.getNumber().toString());
        }
        this.dataTo = myDataTo.toArray();
        
        for(Account acc : bankManager.findAllAccountsByPerson(owner)) {
            myDataFrom.add(acc.getNumber().toString());
        }
        this.dataFrom = myDataFrom.toArray();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton processPayment;
    private javax.swing.JTextField sum;
    // End of variables declaration//GEN-END:variables
}

