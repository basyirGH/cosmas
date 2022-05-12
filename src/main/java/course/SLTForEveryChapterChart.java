package course;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class SLTForEveryChapterChart extends ApplicationFrame {
   
   public SLTForEveryChapterChart( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Learning Mode",            
         "Time (Hours)",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
      final String lecture = "Lecture";        
      final String tutorial = "Tutorial";        
      final String practical = "Practical";        
      final String others = "Others";      
      final String nf2f = "NF2F";
      final String topic1 = "Topic 1 Introduction";        
      final String topic2 = "Topic 2 Quality Assurance Framework";        
      final String topic3 = "Topic 3 Quality Check";        
      final String topic4 = "Topic 4 Software Certification";      
      final String topic5 = "Topic 5 Quality Assurance Management";      
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 4.0 , lecture , topic1 );        
      dataset.addValue( 0.0 , tutorial , topic1 );        
      dataset.addValue( 0.0 , practical , topic1 ); 
      dataset.addValue( 2.0 , others , topic1 );      
      dataset.addValue( 6.0 , nf2f , topic1 );      
      
      dataset.addValue( 4.0 , lecture , topic2 );        
      dataset.addValue( 2.0 , tutorial , topic2 );        
      dataset.addValue( 0.0 , practical , topic2 ); 
      dataset.addValue( 0.0 , others , topic2 );      
      dataset.addValue( 6.0 , nf2f , topic2 );      
      
      dataset.addValue( 6.0 , lecture , topic3 );        
      dataset.addValue( 3.0 , tutorial , topic3 );        
      dataset.addValue( 0.0 , practical , topic3 ); 
      dataset.addValue( 0.0 , others , topic3 );      
      dataset.addValue( 9.0 , nf2f , topic3 );      
      
      dataset.addValue( 6.0 , lecture , topic4 );        
      dataset.addValue( 3.0 , tutorial , topic4 );        
      dataset.addValue( 0.0 , practical , topic4 ); 
      dataset.addValue( 0.0 , others , topic4 );      
      dataset.addValue( 9.0 , nf2f , topic4 );      
      
      dataset.addValue( 6.0 , lecture , topic5 );        
      dataset.addValue( 3.0 , tutorial , topic5 );        
      dataset.addValue( 0.0 , practical , topic5 ); 
      dataset.addValue( 0.0 , others , topic5 );      
      dataset.addValue( 9.0 , nf2f , topic5 );      
      
      
             

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
	   SLTForEveryChapterChart chart = new SLTForEveryChapterChart("Student Learning Time of Every Chapter for Course SQA", 
         "SLT Distribution with Respective Learning Mode");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}