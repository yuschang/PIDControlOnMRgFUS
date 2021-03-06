/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yustchang;


import java.awt.BasicStroke;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;

import java.awt.Graphics2D;

import javax.swing.Timer;
import javax.swing.text.DefaultCaret;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;




public class GUI_View extends javax.swing.JFrame {
    
    public JButton [] button;
    private GUI_Model model;
    private GUI_Controller control;
    private GUI_Chart chart;
    private IPC_ClientControl ipcClient;
    
    private Timer timer;
    
    private TimeSeries series1;
    private TimeSeries series2;
    private TimeSeries series3;
    private TimeSeries series4;
    private TimeSeries series5;
    
    private boolean roiPlotFlag;

    public String msg_GUIimported;
    
    int SUBPLOT_COUNT= 5;
    
    /** The datasets. */
    public TimeSeriesCollection[] datasets;
    
    /** The most recent value added to series 1. */
    public double[] lastValue = new double[SUBPLOT_COUNT];

    
    // important script to control the controller from VIEW    
    public void setController(GUI_Controller control){
        this.control = control;
    }
    
    public void setIPCClient(IPC_ClientControl ipcClient){
        this.ipcClient = ipcClient;
    }
    

   // constructor
    public GUI_View(GUI_Model model) {   
        
        // initialize the this class 
        this.model = model;       
        this.chart = chart;
        
        roiPlotFlag = false;
        
        model.roi_start_point = 0;
        model.roi_window_size = 0;
        
        msg_GUIimported = "";

        // initialization for the gui window
        initComponents();
      
      //  jPanel3.setBackground(Color.LIGHT_GRAY);
        jPanel2.setBackground(Color.LIGHT_GRAY);
        jPanel4.setBackground(Color.LIGHT_GRAY);
        jPanel3.setBackground(Color.LIGHT_GRAY);
             
        jLabel1.setBackground(Color.red);
        jLabel2.setBackground(Color.WHITE);
      
        
        
        DefaultCaret caret = (DefaultCaret)jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        // initiate the chart
        resetChart();
    } 
    
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        textField1 = new java.awt.TextField();
        textField6 = new java.awt.TextField();
        textField7 = new java.awt.TextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MRgFUS PID Controller");

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yustchang/icon-stop.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yustchang/icon-connection.png"))); // NOI18N
        jButton6.setText("Connect");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        textField1.setText("textField1");

        textField6.setText("textField6");

        textField7.setText("textField7");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yustchang/icon-sonication.png"))); // NOI18N
        jButton8.setText("Start");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yustchang/icon-reset.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yustchang/icon-setup.png"))); // NOI18N
        jButton10.setText("setup");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //  **  register controller as action listener

      
      
    
//  ** this is the Paint part ** 
    public void plotImagesCNV1(ImageVolume REimag){
       //imageCanvas1.setImage(REimag);
    }

    public void plotImagesCNV2(ImageVolume IMimag){
      // imageCanvas2.setImage(IMimag);
    } 
    
    public void plotImagesJLB1(BufferedImage tmap){
        
      Graphics2D gfx = (Graphics2D)jLabel1.getGraphics();
      gfx.drawImage(tmap, 0,0 , this);

      gfx.setColor(Color.RED);
      gfx.setStroke(new BasicStroke(3));
    
  
      gfx.drawRect(model.rectangCoordi[0], model.rectangCoordi[1], model.rectangCoordi[2], model.rectangCoordi[3]);
     // jLabel1.setIcon(new ImageIcon(tmap));

  
    } 
    
    public void plotImagesJLB2(BufferedImage roitmap){
 
      Graphics2D gfx = (Graphics2D)jLabel2.getGraphics();
      gfx.drawImage(roitmap, 0,0 , this);

      gfx.setColor(Color.red);
      gfx.setStroke(new BasicStroke(5));
      gfx.drawLine(model.crossCoordi[0][0], model.crossCoordi[0][1], model.crossCoordi[0][2], model.crossCoordi[0][3]);
      gfx.drawLine(model.crossCoordi[1][0], model.crossCoordi[1][1], model.crossCoordi[1][2], model.crossCoordi[1][3]);
     
      if (model.hotspotTrackedTriger){
                
          gfx.setColor(Color.green);
          gfx.setStroke(new BasicStroke(5));
          gfx.drawLine(model.crossCoordi_cem[0][0], model.crossCoordi_cem[0][1], model.crossCoordi_cem[0][2], model.crossCoordi_cem[0][3]);
          gfx.drawLine(model.crossCoordi_cem[1][0], model.crossCoordi_cem[1][1], model.crossCoordi_cem[1][2], model.crossCoordi_cem[1][3]);

      } else{
                
          gfx.setColor(Color.BLACK);
          gfx.setStroke(new BasicStroke(5));
          gfx.drawLine(model.crossCoordi_cem[0][0], model.crossCoordi_cem[0][1], model.crossCoordi_cem[0][2], model.crossCoordi_cem[0][3]);
          gfx.drawLine(model.crossCoordi_cem[1][0], model.crossCoordi_cem[1][1], model.crossCoordi_cem[1][2], model.crossCoordi_cem[1][3]);

      }

      
      // drawLine(int x1, int y1, int x2, int y2);             
      //jLabel2.setIcon(new ImageIcon(roitmap));

    } 
    
    
    public void plotImagesJLB3(BufferedImage roitmap){
      jLabel3.setIcon(new ImageIcon(roitmap));
    } 
        
        
    public void plotText(String txt){
       textField1.setText(txt);
    }
    

    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // this is top function button

       // ipcClient.stopCalledFromView();
        model.stopProcess = true;
  

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:  
        control.initializeThesocket();
        System.out.println("connection to server was called");
        control.connectArduino();
        setMyText("Socket connection was sent out!");
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        // srat2Run button
        model.stopProcess = false;
        control.startToRun();
   
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // Reset button
        control.stopAndInitialization();        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        // set the initial parameters
        control.setParameters();
   
    }//GEN-LAST:event_jButton10ActionPerformed

    
    public String getMyText(){
        
     String txtcloud  = jTextArea1.getText().trim();
     String lastline = lastLineOFtxt(txtcloud);
     
     return lastline;
    }
    
    private String lastLineOFtxt(String txt){
    
        String [] lines = txt.split("\n");
        String lastline = lines[lines.length -1];
        
     return lastline;
    }
    
    public void setMyText(String text){
               
        String newText =  "\n" + text  ;
        jTextArea1.append( newText );
    }
    
     

        
    public void GUI_Chart() {
        
        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new DateAxis("Time"));
        this.datasets = new TimeSeriesCollection[SUBPLOT_COUNT];
            

        
            series1 = new TimeSeries("MeanTemp " , Millisecond.class);
            this.datasets[0] = new TimeSeriesCollection(series1);
            series2 = new TimeSeries("MaxTemp " , Millisecond.class);
            this.datasets[1] = new TimeSeriesCollection(series2);      
            series3 = new TimeSeries("Dose " , Millisecond.class);
            this.datasets[2] = new TimeSeriesCollection(series3);
            series4 = new TimeSeries("PID output", Millisecond.class);
            this.datasets[3] = new TimeSeriesCollection(series4);
            series5 = new TimeSeries("PID output", Millisecond.class);
            this.datasets[4] = new TimeSeriesCollection(series5);
       
            
            final XYLineAndShapeRenderer renderer0 = new XYLineAndShapeRenderer();
            final XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer();
            final XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
            final XYLineAndShapeRenderer renderer3 = new XYLineAndShapeRenderer();
            final XYLineAndShapeRenderer renderer4 = new XYLineAndShapeRenderer();
            
            final NumberAxis rangeAxis = new NumberAxis("Temperature [C] ");
            rangeAxis.setAutoRangeIncludesZero(false);      
            // for figure 1 and 2
            final XYPlot subplot = new XYPlot(
                    this.datasets[0], null, rangeAxis, new StandardXYItemRenderer()
            );
            subplot.setDataset(1,datasets[1]);
 
            subplot.setRenderer(0, renderer0);
            subplot.setRenderer(1, renderer1);
            subplot.getRendererForDataset(subplot.getDataset(0)).setSeriesPaint(0,Color.BLUE);
            subplot.getRendererForDataset(subplot.getDataset(1)).setSeriesPaint(0,Color.red);
            
            subplot.setBackgroundPaint(Color.white);
            subplot.setDomainGridlinePaint(Color.GRAY);
            subplot.setRangeGridlinePaint(Color.GRAY);
            plot.add(subplot);

            // for figure 3 and 4
            final NumberAxis rangeAxis2 = new NumberAxis("Termal dose [CEM]");
            rangeAxis2.setAutoRangeIncludesZero(true);
            final XYPlot subplot2 = new XYPlot(
                    this.datasets[2], null, rangeAxis2, new StandardXYItemRenderer()
            );
            subplot2.setDataset(1,datasets[3]);
        
            subplot2.setRenderer(0, renderer2);
            subplot2.setRenderer(1, renderer3);
            subplot2.getRendererForDataset(subplot2.getDataset(0)).setSeriesPaint(0,Color.BLACK);
            subplot2.getRendererForDataset(subplot2.getDataset(1)).setSeriesPaint(0,Color.RED);
            
            subplot2.setBackgroundPaint(Color.white);
            subplot2.setDomainGridlinePaint(Color.GRAY);
            subplot2.setRangeGridlinePaint(Color.GRAY);
            plot.add(subplot2);

            // for figure 5       
            final NumberAxis rangeAxis3 = new NumberAxis("Duty Cycle [%]");
           //  rangeAxis3.setAutoRangeIncludesZero(true);
            rangeAxis3.setRange(0, 100);
            final XYPlot subplot3 = new XYPlot(
                    this.datasets[4], null, rangeAxis3, new StandardXYItemRenderer()
            );
            subplot3.setRenderer(0, renderer4);
            subplot3.getRendererForDataset(subplot3.getDataset(0)).setSeriesPaint(0,Color.BLACK);
            subplot3.setBackgroundPaint(Color.white);
            subplot3.setDomainGridlinePaint(Color.GRAY);
            subplot3.setRangeGridlinePaint(Color.GRAY);
            plot.add(subplot3);
            
        // for the final figure
        final JFreeChart chart = new JFreeChart("Moniter", plot);
//        chart.getLegend().setAnchor(Legend.EAST);
        chart.setBorderPaint(Color.black);
        chart.setBorderVisible(true);
        chart.setBackgroundPaint(Color.white);
        
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
  //      plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 4, 4, 4, 4));
        final ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(120000.0);  // 100 seconds
        

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(jPanel4.getSize());
        jPanel4.add(chartPanel);
     
        pack();
        setVisible(true);

    } 
    
    public void resetChart(){
        GUI_Chart();

    }
    
    public void updateChart(double mean, double max){
    
        lastValue[0] = mean;
        lastValue[1] = max;
        datasets[0].getSeries(0).add(new Millisecond(), lastValue[0]);
        datasets[1].getSeries(0).add(new Millisecond(), lastValue[1]);     
        
        lastValue[2] = model.thermalDose;         
        datasets[2].getSeries(0).add(new Millisecond(), lastValue[2]);  
        lastValue[3] = model.max_temp_based_dose;         
        datasets[3].getSeries(0).add(new Millisecond(), lastValue[3]); 
        
        // lastValue[3] = 100 * (0.90 + 0.2 * Math.random());    
        lastValue[4] = model.pidOutput;
        datasets[4].getSeries(0).add(new Millisecond(), lastValue[4]);  
                
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.TextField textField1;
    private java.awt.TextField textField6;
    private java.awt.TextField textField7;
    // End of variables declaration//GEN-END:variables
}
