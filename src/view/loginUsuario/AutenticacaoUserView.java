/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.loginUsuario;

import control.SessaoUserController;
import control.UsuarioController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Usuario;
import view.PrincipalView;
import view.loginCliente.LoginClienteView;

/**
 *
 * @author Leo
 */
public class AutenticacaoUserView extends javax.swing.JFrame {

    /**
     * Creates new form AutenticacaoUserView
     */
    public AutenticacaoUserView() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jtfSenha = new javax.swing.JPasswordField();
        jbtEntrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbtRetornar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Acessar administração do Easy Market");

        jLabel2.setText("Login");

        jLabel3.setText("Senha");

        jbtEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/OK.png"))); // NOI18N
        jbtEntrar.setText("Entrar");
        jbtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEntrarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Abort.png"))); // NOI18N
        jButton2.setText("Sair");

        jbtRetornar.setText("Retornar");
        jbtRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRetornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtRetornar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtEntrar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(jtfSenha))))
                        .addGap(122, 122, 122))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtEntrar)
                    .addComponent(jButton2)
                    .addComponent(jbtRetornar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRetornarActionPerformed
        LoginClienteView v = new LoginClienteView();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbtRetornarActionPerformed

    private void jbtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEntrarActionPerformed
        //Verifica se o CPF existe no banco
        String senha = new String(jtfSenha.getPassword());
        String login = new String(jtfLogin.getText());

        //if (validation(senha)) {
        Usuario u = new Usuario();
        try {
            
            u = UsuarioController.getInstance().Autenticacao(login, senha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não encontrado");
        }
        
        
        try {
    
            
            if (u.getSenha() == null) {
            JOptionPane.showMessageDialog(this, "Login inválido");
        } else {

            try {

                SessaoUserController.getInstance().setUsuario(u);

                JOptionPane.showMessageDialog(this, "Olá, bem vindo ao Easy Market");
                PrincipalView v = new PrincipalView();
                v.setLocationRelativeTo(null);
                v.setExtendedState(JFrame.MAXIMIZED_BOTH);
                v.setVisible(true);

                this.setVisible(false);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro no Login");
            }

        }

            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro no Login");
        }
    
       // }

    }//GEN-LAST:event_jbtEntrarActionPerformed

    //Validação dos campos em obrigatórios
    private boolean validation(String senha) {
        if (jtfLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Login é obrigatório.");
            jtfLogin.requestFocus();
            return false;
        } else if (senha == "") {
            JOptionPane.showMessageDialog(this, "Campo Senha é obrigatório.");
            jtfSenha.requestFocus();
            return false;
        }

        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AutenticacaoUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutenticacaoUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutenticacaoUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutenticacaoUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutenticacaoUserView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtEntrar;
    private javax.swing.JButton jbtRetornar;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JPasswordField jtfSenha;
    // End of variables declaration//GEN-END:variables
}
