import java.io.File;
import java.lang.String;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import ner.annot.gene;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceProcessException;



public class GeneCasConsumer extends CasConsumer_ImplBase {

  /*
   * The CAS Consumer class. It inherits from the CAS Consumer base implementation
   * and overrides the initialize and processCas methods.
   *   
   * It formats each annotation of type gene in the CAS and writes 
   * to an output file. 
   * 
   */
  
  File gResult;
  String sourcePOS = "POSAnnotator";
  String sourceSimple = "SimpleAnnotator";
  
  /*
   * Initialize the CAS consumer. 
   * 
   * Reads the output file configuration parameter and stores it to 
   * a class variable.
   * 
   */
  
  @Override()
  public void initialize(){
    gResult =new File(
            (String)getConfigParameterValue("OutputFile"));
  }
  
  
  /*
   * Processes the CAS annotations
   * Reads the gene type annotations and formats and writes to output file
   * 
   * @param cas
   * 
   */
  
  @Override
  public void processCas(CAS arg0) throws ResourceProcessException {
    // TODO Auto-generated method stub
   
    JCas jcas;
    try {
      jcas = arg0.getJCas();
      String doc = arg0.getDocumentText();
      Iterator anntIter = jcas.getAnnotationIndex(gene.typeIndexID).iterator();
      while (anntIter.hasNext()) {
        gene annt = (gene) anntIter.next();
        String txt = annt.getCoveredText();  
        String dId = annt.getDocID();
        int beg = doc.substring(0, annt.getBegin()).replace(" ", "").length() - dId.length();
        int end = doc.substring(0, annt.getEnd()).replace(" ", "").length() - dId.length() -1;
        String source = annt.getSource();
        //if (source != sourceSimple){
        //  continue;
        //}
        FileWriter ofi = new FileWriter(gResult, true);
        //ofi.write(dId+"|"+beg+" "+end+"|"+txt+"|"+source+"\n");
        ofi.write(dId+"|"+beg+" "+end+"|"+txt+"\n");
        ofi.close();
      }
    } catch (CASException e1) {
    } catch (IOException e){
    }
   
   }
}