import java.util.Iterator;
import java.util.Map;

import ner.annot.gene;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;



public class POSGeneAnnotate extends JCasAnnotator_ImplBase {

  /*
   * A Named Entity Annotator based on the POS Tag NER given with the scripts
   * for Homework 1. 
   * 
   * Uses the Stanford NLP based POS tagger to identify the Nouns in the document.
   * Use the start and end markers of the noun POS tags to label the NER offsets.
   * 
   * 
   */
  
  private String myName = "POSAnnotator";
  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    try {
      PosTagNamedEntityRecognizer posTgr = new PosTagNamedEntityRecognizer();
      String docText = arg0.getDocumentText();
      String id = docText.split(" ")[0];
      String txt = docText;//docText.split(" ", 2)[1];
      Map<Integer, Integer> postags = posTgr.getGeneSpans(txt);
      Iterator<Integer> nnit = postags.keySet().iterator();
      while (nnit.hasNext()){
        Integer key = (Integer) nnit.next();
        int beg = key.intValue();
        if (beg == 0){
          continue;
        }
        int end = postags.get(key);
        gene annt = new gene(arg0);
        annt.setDocID(id);
        annt.setBegin(beg);
        annt.setEnd(end);
        annt.setSource(myName);
        annt.addToIndexes();
        //System.out.println(beg+ " " + end + " " + docText.length());
      }
    } catch (ResourceInitializationException e) {
      // TODO Auto-generated catch block
    }
    
  }

}
