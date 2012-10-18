
import java.util.regex.Pattern;


import ner.annot.gene;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
public class SimpleGeneAnnotate extends JCasAnnotator_ImplBase {

  private String [] patRules = {"[A-Z][a-z0-9]*", "[A-Z0-9-]*", "[A-Za-z0-9-]*[0-9]", "[0-9][A-Za-z-]*"};
  private String myName = "SimpleAnnotator";
  
  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    
    String docText = arg0.getDocumentText();
    gene annt = new gene(arg0);
    String id = docText.split(" ")[0];
    String txt = docText.split(" ", 2)[1];
    String [] words = txt.split(" ");
    int coff = id.length() + 1;
    for (int i = 0; i < words.length; i++){
      String wd = words[i];
      if (mayBeGene(wd, i)){
        //store annotation
        int bg = coff;
        int end = wd.length();
        annt.setDocID(id);
        annt.setBegin(bg);
        annt.setEnd(bg+end);
        annt.setSource(myName);
        annt.addToIndexes();
      }
      coff += wd.length() + 1;
      
    }
    
  }
  
  public Boolean mayBeGene(String w, int idx){
    for(int i=0; i<patRules.length; i++){
      if (idx == 0 && i == 0){
        continue;
      }
      if (Pattern.matches(patRules[i], w)){
        //System.out.println(w);
        return true;
      }
    }
    return false;
  }

}
