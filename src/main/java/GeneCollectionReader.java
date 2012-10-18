
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;


public class GeneCollectionReader extends CollectionReader_ImplBase {

  /*
   * The Collection reader for the NER pipeline.
   * 
   * It inherits from the base implementation of the Collection Reader 
   * and implements the abstract methods.
   * 
   * Reads in the input file name via a configuration parameter
   * and extracts each sentence from the file. 
   * Adds each sentence as a separate document in the reader.
   * 
   */
  
  String [] gCont;
  int currLine;
  int totalLines;
  
  
  @Override
  public void initialize() {
    String gText = (String)getConfigParameterValue("InputFile");
    BufferedReader fis;
    totalLines = 0;
    try {
      fis = new BufferedReader(new FileReader(gText));
      while (fis.readLine() != null){
        totalLines += 1;
      }
      fis.close();
      fis = new BufferedReader(new FileReader(gText));
      gCont = new String[totalLines];
      String li = fis.readLine();
      int i = 0;
      while (li != null){
        gCont[i] = li;
        i += 1;
        li = fis.readLine();
      }
    currLine = 0;
    fis.close();
    System.out.println(totalLines);
    } catch (FileNotFoundException e1) {
    }catch (IOException e) {
    }
  }
  
  @Override
  public void getNext(CAS arg0) throws IOException, CollectionException {
    // TODO Auto-generated method stub
    JCas jcas;
    try {
      jcas = arg0.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }
    String text = gCont[currLine];
    currLine += 1;
    //System.out.println(text);
   // put document in CAS
   jcas.setDocumentText(text);
    
  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return new Progress[]{
            new ProgressImpl(currLine,totalLines,Progress.ENTITIES)};
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    // Check if there are more files to be read
    return (currLine < totalLines);
  }

}
