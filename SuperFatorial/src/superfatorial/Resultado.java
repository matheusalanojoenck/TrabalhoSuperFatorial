/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superfatorial;

import business.Cronometro;
import business.SuperFatorialCached;
import business.SuperFatorialDiskCached;
import exceptions.InputException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author matheus
 */
public class Resultado extends javax.swing.JFrame {
    SuperFatorialCached superFatorial;
    SuperFatorialDiskCached superFatorialDisk;
    /**
     * Creates new form Resultado
     * @param numero
     * @param tipoArmz
     * @throws exceptions.InputException
     */
    public Resultado(String numero, String tipoArmz) throws InputException {
        initComponents();
        int valor = Integer.parseInt(numero);
        this.setLabelTitulo(numero);
        
        switch (tipoArmz){
            case "cache":
                superFatorial = new SuperFatorialCached();
                
                Cronometro.inicia();
                this.setTextoResultado(superFatorial.getFatorialCache(valor).toString());
                tempoProcura.setText(Long.toString(Cronometro.fim())+"ms");
                
                Cronometro.inicia();
                setTabelaResultadosCache(superFatorial.getCache());
                tempoCriacao.setText(Long.toString(Cronometro.fim())+"ms");
                break;
            case "txt":
                superFatorialDisk = new SuperFatorialDiskCached();
                
                Cronometro.inicia();
                this.setTextoResultado(superFatorialDisk.getFatorialCache(valor).toString());
                tempoProcura.setText(Long.toString(Cronometro.fim())+"ms");
                
                Cronometro.inicia();
                setTabelaResultadosDisk();
                tempoCriacao.setText(Long.toString(Cronometro.fim())+"ms");
                break;
        }
    }


    private void setLabelTitulo(String labelTitulo) {
        this.labelTitulo.setText("sf("+labelTitulo+")");
    }

    private void setTextoResultado(String textoResultado) {
        this.textoResultado.setText(textoResultado);
    }
    
    private void setTabelaResultadosCache(HashMap<Integer,BigInteger> cache) {
        DefaultTableModel model = (DefaultTableModel) tabelaResultados.getModel();
        cache.keySet().forEach((aux) -> {
            model.addRow(new Object[]{aux, cache.get(aux).toString()});
        });
    }
    
    private void setTabelaResultadosDisk(){
        DefaultTableModel model = (DefaultTableModel) tabelaResultados.getModel();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(superFatorialDisk.getCache().getFileName()));
            for(int i=1; i<=superFatorialDisk.getCache().getSize(); i++){
                model.addRow(new Object[]{Integer.toString(i), superFatorialDisk.getCache().read(i)});
            }
        } catch (IOException e) {
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaResultados = new javax.swing.JTable();
        labelTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoResultado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        labelCriacaoTitulo = new javax.swing.JLabel();
        tempoCriacao = new javax.swing.JLabel();
        labelTituloProcura = new javax.swing.JLabel();
        tempoProcura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resultado - Super Fatorial");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        tabelaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Valor", "Resultado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaResultados.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabelaResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaResultadosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaResultados);

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTitulo.setText("sf(x)");

        textoResultado.setEditable(false);
        textoResultado.setColumns(20);
        textoResultado.setLineWrap(true);
        textoResultado.setRows(5);
        jScrollPane2.setViewportView(textoResultado);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Todos os Resultados");

        labelCriacaoTitulo.setText("Tempo de criação da tabela:");

        tempoCriacao.setText("tempoCriacao");

        labelTituloProcura.setText("Tempo de procura/cálculo:");

        tempoProcura.setText("tempoProcura");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(labelTitulo)
                    .addComponent(botaoVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelCriacaoTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tempoCriacao))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelTituloProcura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tempoProcura)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTituloProcura)
                    .addComponent(tempoProcura))
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCriacaoTitulo)
                    .addComponent(tempoCriacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoVoltar))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
        MainSuperFatorial.menu.setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void tabelaResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaResultadosMouseReleased
        String select = tabelaResultados.getModel().getValueAt(tabelaResultados.getSelectedRow(), 1).toString();
        this.setTextoResultado(select);
        this.setLabelTitulo((tabelaResultados.getModel().getValueAt(tabelaResultados.getSelectedRow(), 0).toString()));
    }//GEN-LAST:event_tabelaResultadosMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCriacaoTitulo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTituloProcura;
    private static javax.swing.JTable tabelaResultados;
    private javax.swing.JLabel tempoCriacao;
    private javax.swing.JLabel tempoProcura;
    private javax.swing.JTextArea textoResultado;
    // End of variables declaration//GEN-END:variables
}
