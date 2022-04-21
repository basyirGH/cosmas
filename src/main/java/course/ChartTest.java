package course;

import java.sql.SQLException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class ChartTest extends ApplicationFrame {
   
   public ChartTest( String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset( ) {
	   
	  DAO dao = new DAO();
	 
	  DefaultPieDataset dataset = new DefaultPieDataset( );
	  try {
	      dataset.setValue( "PLO1 (Knowledge and Understanding)" , dao.getCourseCountForPLO("PLO1"));  
	      dataset.setValue( "PLO2 (Practical Skills)" , dao.getCourseCountForPLO("PLO2"));
	      dataset.setValue( "PLO3 (Cognitive Skills)" , dao.getCourseCountForPLO("PLO3"));  
	      dataset.setValue( "PLO4 (Communication Skills)" , dao.getCourseCountForPLO("PLO4"));
	      dataset.setValue( "PLO5 (Interpersonal Skills)" , dao.getCourseCountForPLO("PLO5"));  
	      dataset.setValue( "PLO6 (Ethics & Professionalism)" , dao.getCourseCountForPLO("PLO6"));
	      dataset.setValue( "PLO7 (Personal Skills)" , dao.getCourseCountForPLO("PLO7"));  
	      dataset.setValue( "PLO8 (Entrepreneurial Skills)" , dao.getCourseCountForPLO("PLO8"));
	      dataset.setValue( "PLO9 Leadership, Autonomy & Responsibility" , dao.getCourseCountForPLO("PLO9"));
	      dataset.setValue( "PLO10 (Digital Skills)" , dao.getCourseCountForPLO("PLO10"));  
	      dataset.setValue( "PLO11 (Numeracy Skills)" , dao.getCourseCountForPLO("PLO11"));
	  }
	  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	  }
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart3D(      
         "Number of Courses with Respective PLOs",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);
      
      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }

   public static void main( String[ ] args ) {
	  ChartTest demo = new ChartTest( "Course Analysis" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}