/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.Aluno;
import model.FormatLetras;
import model.FormatNumbers;
import utils.BdAluno;


/**
 *
 * @author paulojp
 */
public class JFAluno extends javax.swing.JFrame {  
   
    // Variável que recebe a instância da tela principal
    private JFPrincipal telaPrincipal;
    
    /**
     * Creates new form Aluno
     */
    public JFAluno() {
        initComponents();
        
        // Desabilita os campos ao iniciar a janela
        desabilitaCampos();
        jT0Mat.setDocument(new FormatNumbers(7));
        jT1Nome.setDocument(new FormatLetras(100));
        
       
    }
    
    
    // Construtor reabilita tela principal - recebe a instância
    JFAluno(JFPrincipal telaPrincipal) throws SQLException {
        
        // this(esta janela 'jFCliente') - abre a própria janela ao execultar o contrutor
        this();
        
        this.telaPrincipal = telaPrincipal;
        
        BdAluno d = new BdAluno();
        alunos = d.getLista("%"+""+"%"); 
        // Após pesquisar os contatos, executa o método p/ exibir o resultado na tabela pesquisa
        mostraPesquisa(alunos);
        alunos.clear();
        limpaCampos();
        habilitaCampos();
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jC4Nivel = new javax.swing.JComboBox<>();
        jC3Serie = new javax.swing.JComboBox<>();
        jC2Curso = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jBExcluir = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBNovo1 = new javax.swing.JButton();
        jBCadastrar1 = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jBCadastrar2 = new javax.swing.JButton();
        jT1Nome = new javax.swing.JTextField();
        jT0Mat = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTPesquisar = new javax.swing.JTextField();
        jBPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePesquisa = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar alunos");
        setBackground(new java.awt.Color(0, 184, 0));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel4.setText("Monitor:");

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("*Matrícula: ");

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel11.setText("Série:");

        jC4Nivel.setBackground(new java.awt.Color(204, 255, 204));
        jC4Nivel.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jC4Nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jC4Nivel.setBorder(null);
        jC4Nivel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jC3Serie.setBackground(new java.awt.Color(204, 255, 204));
        jC3Serie.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jC3Serie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1°", "2°", "3°" }));
        jC3Serie.setBorder(null);
        jC3Serie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jC2Curso.setBackground(new java.awt.Color(204, 255, 204));
        jC2Curso.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jC2Curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administração", "Finanças", "Informática", "Redes de computadores" }));
        jC2Curso.setBorder(null);
        jC2Curso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jC2Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC2CursoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("*Nome: ");

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel12.setText("Curso:");

        jBExcluir.setBackground(new java.awt.Color(0, 153, 0));
        jBExcluir.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jBExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/imagens/delete.png"))); // NOI18N
        jBExcluir.setText("EXCLUIR");
        jBExcluir.setBorderPainted(false);
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBAlterar.setBackground(new java.awt.Color(0, 153, 0));
        jBAlterar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jBAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jBAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/imagens/save-file-option.png"))); // NOI18N
        jBAlterar.setText("SALVAR ALTERAÇÕES");
        jBAlterar.setBorderPainted(false);
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jBNovo1.setBackground(new java.awt.Color(0, 153, 0));
        jBNovo1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBNovo1.setForeground(new java.awt.Color(255, 255, 255));
        jBNovo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/imagens/unlock.png"))); // NOI18N
        jBNovo1.setText("DESBLOQUEAR");
        jBNovo1.setBorderPainted(false);
        jBNovo1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jBNovo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovo1ActionPerformed(evt);
            }
        });

        jBCadastrar1.setBackground(new java.awt.Color(0, 153, 0));
        jBCadastrar1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBCadastrar1.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/imagens/piece-of-paper-and-pencil_1.png"))); // NOI18N
        jBCadastrar1.setText("LIMPAR");
        jBCadastrar1.setBorderPainted(false);
        jBCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrar1ActionPerformed(evt);
            }
        });

        jBSair.setBackground(new java.awt.Color(255, 0, 0));
        jBSair.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jBSair.setForeground(new java.awt.Color(255, 255, 255));
        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/imagens/sair-menu.png"))); // NOI18N
        jBSair.setText("SAIR");
        jBSair.setBorderPainted(false);
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        jBCadastrar2.setBackground(new java.awt.Color(0, 153, 0));
        jBCadastrar2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jBCadastrar2.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/imagens/file.png"))); // NOI18N
        jBCadastrar2.setText("CADASTRAR");
        jBCadastrar2.setBorderPainted(false);
        jBCadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrar2ActionPerformed(evt);
            }
        });

        jT1Nome.setEditable(false);
        jT1Nome.setBackground(new java.awt.Color(204, 255, 204));
        jT1Nome.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N

        jT0Mat.setBackground(new java.awt.Color(204, 255, 204));
        jT0Mat.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jT0Mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT0MatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBNovo1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBCadastrar1)
                        .addGap(18, 18, 18)
                        .addComponent(jBCadastrar2)
                        .addGap(18, 18, 18)
                        .addComponent(jBAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jBExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jBSair))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jT0Mat)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                            .addComponent(jT1Nome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jC2Curso, 0, 396, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jC3Serie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jC4Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jC4Nivel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jC2Curso, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jC3Serie, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jT1Nome)
                    .addComponent(jT0Mat, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNovo1)
                    .addComponent(jBCadastrar1)
                    .addComponent(jBAlterar)
                    .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBAlterar, jBExcluir});

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTPesquisar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jBPesquisar.setBackground(new java.awt.Color(0, 153, 0));
        jBPesquisar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jBPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/imagens/iconfinder_search_322497 (1).png"))); // NOI18N
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jTablePesquisa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTablePesquisa.setModel(tmAluno);
        jTablePesquisa.setRowHeight(25);
        jTablePesquisa.getTableHeader().setReorderingAllowed(false);
        jTablePesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePesquisa);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jBPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTPesquisar)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Cadastro de Clientes");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
     
    
    // BOTÃO PESQUISAR - Precionando
    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        // Ao clicar em pesquisar, é executado o método que efetua a pesquisa, e outro método que exibe a lista da pesquisa
        try {            
            listaContatos(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Problemas ao listar contatos.");            
        }
    }//GEN-LAST:event_jBPesquisarActionPerformed
    
    // TABELA PESQUISA - Selecionando registro com o clique do mouse
    private void jTablePesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePesquisaMouseClicked
        // Salva a posição da linha selecionada na tabela de pesquisa
        int linhaSelecionada = jTablePesquisa.getSelectedRow();
        
        jT0Mat.setText(jTablePesquisa.getValueAt(linhaSelecionada, 0).toString());
        jT1Nome.setText((String) jTablePesquisa.getValueAt(linhaSelecionada, 1));
        jC2Curso.setSelectedItem((String) jTablePesquisa.getValueAt(linhaSelecionada, 2));
        jC3Serie.setSelectedItem((String) jTablePesquisa.getValueAt(linhaSelecionada, 3));
        jC4Nivel.setSelectedItem((String) jTablePesquisa.getValueAt(linhaSelecionada, 4));
        
        // Ao selecionar um registro, os campos são ativados possibilitando fazer alterações
        habilitaCamposAlterar();
    }//GEN-LAST:event_jTablePesquisaMouseClicked
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        // habilita a janela principal
        telaPrincipal.setEnabled(true);
        
    }//GEN-LAST:event_formWindowClosed

    private void jC2CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC2CursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jC2CursoActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        try {
            alteraRegistro();
            BdAluno d = new BdAluno();
            alunos = d.getLista("%"+""+"%");
            // Após pesquisar os contatos, executa o método p/ exibir o resultado na tabela pesquisa
            mostraPesquisa(alunos);
            alunos.clear();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao alterar registro.");
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    // BOTÃO EXCLUIR - Precionando
    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        try {
            excluirRegistro();
            BdAluno d = new BdAluno();
            alunos = d.getLista("%"+""+"%");
            // Após pesquisar os contatos, executa o método p/ exibir o resultado na tabela pesquisa
            mostraPesquisa(alunos);
            alunos.clear();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao excluir registro.");
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovo1ActionPerformed
        habilitaCampos();
        // Limpa os dados dos campos
    }//GEN-LAST:event_jBNovo1ActionPerformed

    private void jBCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrar1ActionPerformed
        limpaCampos();
        habilitaCampos();
    }//GEN-LAST:event_jBCadastrar1ActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBCadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrar2ActionPerformed
        cadastraRegistro();
    }//GEN-LAST:event_jBCadastrar2ActionPerformed

    private void jT0MatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT0MatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT0MatActionPerformed
    
    
    
    
    /* ----CADASTRO-> */
    // MÉTODOS:
    
    // Método p/ cadastrar um registro no banco de dados.
    private void cadastraRegistro() {
        // Antes de cadastrar, verifica se o usuário está com algum registro selecionado
        if (jT1Nome.isEditable()) {
            // Antes de cadastrar, verifica se os campos foram preenchidos
            if (verificaDados()) {
                try {
                    Aluno c = new Aluno();
               
                    c.setMatricula(Integer.valueOf(jT0Mat.getText()));
                    c.setNomeAluno(jT1Nome.getText());
                    c.setCurso((String) jC2Curso.getSelectedItem());
                    if (null != (String) jC3Serie.getSelectedItem())switch ((String) jC3Serie.getSelectedItem()) {
                        case "1°":
                            c.setSerie(1);
                            break;
                        case "2°":
                            c.setSerie(2);
                            break;
                        case "3°":
                            c.setSerie(3);
                            break;
                        default:
                            break;
                    }
                    if (null != (String) jC4Nivel.getSelectedItem())switch ((String) jC4Nivel.getSelectedItem()) {
                        case "Não":
                            c.setNivel(0);
                            break;
                        case "Sim":
                            c.setNivel(1);
                            break;
                        default:
                            break;
                    }
                    
                    BdAluno d = new BdAluno();

                    d.adicionaAluno(c);

                    JOptionPane.showMessageDialog(rootPane, "Dados cadastrados com sucesso.");
                    limpaCampos();

                    alunos = d.getLista("%"+""+"%"); 
                    // Após pesquisar os contatos, executa o método p/ exibir o resultado na tabela pesquisa
                    mostraPesquisa(alunos);
                    alunos.clear();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar aluno.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Para cadastrar um novo aluno.\nClique no botão 'Limpar'.");
        }
    }
    
    // Método p/ validação do formulário
    private boolean verificaDados() {
        if ((!jT0Mat.getText().equals("")) && (!jT1Nome.getText().equals(""))) {            
            return true;
        }
        JOptionPane.showMessageDialog(rootPane, "Dados imcompletos.");
        return false;
    }
    
    // Método p/ concatenar a data
    /*private String data() {
        String d = jT2DataAno.getText() + "-" + jT2DataMes.getText() + "-" + jT2DataDia.getText();
        
        return d;
    }*/
    /* <-CADASTRO---- */ 
    
    
    
    
    /* ----PESQUISA-> */
    // MÉTODOS:
    
    // Edita os campos e colunas da tabela de resultados
    DefaultTableModel tmAluno = new DefaultTableModel(new Object[] {"Matrícula", "Nome", "Curso", "Série", "Monitor"}, 0) {
    @Override
    public boolean isCellEditable(int rowIndex, int mColIndex){  
    return false;  
    }
    };
    List<Aluno> alunos;
        
    
    // Lista a quantidade de resultado, de acordo com o nome passado no campo pesquisa
    private void listaContatos() throws SQLException {
        limpaCampos();
        BdAluno d = new BdAluno();
        alunos = d.getLista("%" + jTPesquisar.getText() + "%"); 
        
        // Após pesquisar os contatos, executa o método p/ exibir o resultado na tabela pesquisa
        mostraPesquisa(alunos);
        alunos.clear();
    }
    
    // Mostra a lista de resultado de acordo com o nome passado no campo pesquisa
    private void mostraPesquisa(List<Aluno> alunos) {
        // Limpa a tabela sempre que for solicitado uma nova pesquisa
        limparTabela();
        
        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum registro encontrado.");
        } else {            
            // Linha em branco usada no for, para cada registro é criada uma nova linha 
            String[] linha = new String[] {null, null, null, null, null, null, null};
            // P/ cada registro é criada uma nova linha, cada recebe linha os campos do registro
            for (int i = 0; i < alunos.size(); i++) {
                tmAluno.addRow(linha);
                tmAluno.setValueAt(alunos.get(i).getMatricula(), i, 0);
                tmAluno.setValueAt(alunos.get(i).getNomeAluno(), i, 1);
                tmAluno.setValueAt(alunos.get(i).getCurso(), i, 2);
                tmAluno.setValueAt(alunos.get(i).getSerie()+"º", i, 3);
                if((alunos.get(i).getNivel())==0){
                    tmAluno.setValueAt("Não", i, 4);    
                } 
                if((alunos.get(i).getNivel())==1){
                    tmAluno.setValueAt("Sim", i, 4);    
                } 
            }            
        }
    }
    
    // Limpa a tabela de resultados
    private void limparTabela() {       
        while (tmAluno.getRowCount() > 0) {            
            tmAluno.removeRow(0);
        }
    } 
    /* <-PESQUISA---- */      
    
    
    
    /* ----EXCLUIR-> */
    // MÉTODOS:
    
    // Exclui resgistro
    private void excluirRegistro() throws SQLException {
        // Se algum registro estiver selecionado
        if (jTablePesquisa.getSelectedRow() != -1) {
            // Exibe uma janela de confirmação antes de exluir o registro
            int resp = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este registro?",
                    "Confirmação!", JOptionPane.YES_NO_OPTION);

            // Se a confirmação for SIM
            if (resp == JOptionPane.YES_NO_OPTION) {
                // Recebe a linha selecionada
                int linhaSelecionada = jTablePesquisa.getSelectedRow();
                // Recebe o ID da linha selecionada
                int id = (int) jTablePesquisa.getValueAt(linhaSelecionada, 0);
                // Remove o registro, usando como parâmetro, o id da linha selecionada                
                BdAluno d = new BdAluno();
                d.remove(id);

                JOptionPane.showMessageDialog(rootPane, "Registro excluido com sucesso.");
                limpaCampos();
                desabilitaCampos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Registro não selecionado.");
        }
    }
    /* <-EXCLUIR---- */
    
    
    
    
    /* ----ALTERAR-> */
    // MÉTODOS:
    
    // Altera registro
    private void alteraRegistro() throws SQLException {
        if (jTablePesquisa.getSelectedRow() != -1) {
            if(verificaDados()){
            int resp = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente alterar este registro?",
                    "Confirmação!", JOptionPane.YES_NO_OPTION);

            // Se a confirmação for SIM
            if (resp == JOptionPane.YES_NO_OPTION) {                

                Aluno c = new Aluno();
                BdAluno d = new BdAluno();
                
                c.setMatricula(Integer.valueOf(jT0Mat.getText()));
                c.setNomeAluno(jT1Nome.getText());
                c.setCurso((String) jC2Curso.getSelectedItem());
                if (null != (String) jC3Serie.getSelectedItem())switch ((String) jC3Serie.getSelectedItem()) {
                    case "1°":
                        c.setSerie(1);
                        break;
                    case "2°":
                        c.setSerie(2);
                        break;
                    case "3°":
                        c.setSerie(3);
                        break;
                    default:
                        break;
                }
                if (null != (String) jC4Nivel.getSelectedItem())switch ((String) jC4Nivel.getSelectedItem()) {
                    case "Não":
                        c.setNivel(0);
                        break;
                    case "Sim":
                        c.setNivel(1);
                        break;
                    default:
                        break;
                }       

                d.altera(c);
                
                JOptionPane.showMessageDialog(rootPane, "Registro alterado com sucesso.");
                limpaCampos();
                desabilitaCampos();
                listaContatos();
            }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Registro não selecionado.");
        }
    }
    /* <-ALTERAR---- */
    
    
    
    
    /* ----OUTROS-> */
    // MÉTODOS:
    
    // Limpa os campos do formulário
    private void limpaCampos() {
        jT0Mat.setText("");
        jT1Nome.setText("");
    }
    
    // Desabilita os campos do formulário
    private void desabilitaCampos() {
        jT0Mat.setEditable(false);
        jT1Nome.setEditable(false);
    }
    
    // Habilita os campos do formulário
    private void habilitaCampos() {
        
        jT0Mat.setEditable(true);
        jT1Nome.setEditable(true);

    }
    
    private void habilitaCamposAlterar() {
        
        jT0Mat.setEditable(false);
        jT1Nome.setEditable(true);

    }
    
    
    /* <-OUTROS---- */
    
    
    
    
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
            java.util.logging.Logger.getLogger(JFAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFAluno().setVisible(true);
            }
        });
    }    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBCadastrar1;
    private javax.swing.JButton jBCadastrar2;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo1;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSair;
    private javax.swing.JComboBox<String> jC2Curso;
    private javax.swing.JComboBox<String> jC3Serie;
    private javax.swing.JComboBox<String> jC4Nivel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jT0Mat;
    private javax.swing.JTextField jT1Nome;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTable jTablePesquisa;
    // End of variables declaration//GEN-END:variables

}
