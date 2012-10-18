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

  File gResult;
  String sourcePOS = "POSAnnotator";
  String sourceSimple = "SimpleAnnotator";
  
  @Override()
  public void initialize(){
    gResult =new File(
            (String)getConfigParameterValue("OutputFile"));
  }
  
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
        ofi.write(dId+"|"+beg+" "+end+"|"+txt+"|"+source+"\n");
        ofi.close();
      }
    } catch (CASException e1) {
    } catch (IOException e){
    }
   
   //System.out.println("Reached the end");
   }
}