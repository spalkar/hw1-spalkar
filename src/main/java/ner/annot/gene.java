

/* First created by JCasGen Wed Oct 17 03:26:59 EDT 2012 */
package ner.annot;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Oct 17 16:21:45 EDT 2012
 * XML source: /home/spalkar/workspace/hw1-spalkar/src/main/resources/POSaeDescriptor.xml
 * @generated */
public class gene extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(gene.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected gene() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public gene(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public gene(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public gene(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: docID

  /** getter for docID - gets the document identifier for the sentence under analysis
   * @generated */
  public String getDocID() {
    if (gene_Type.featOkTst && ((gene_Type)jcasType).casFeat_docID == null)
      jcasType.jcas.throwFeatMissing("docID", "ner.annot.gene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((gene_Type)jcasType).casFeatCode_docID);}
    
  /** setter for docID - sets the document identifier for the sentence under analysis 
   * @generated */
  public void setDocID(String v) {
    if (gene_Type.featOkTst && ((gene_Type)jcasType).casFeat_docID == null)
      jcasType.jcas.throwFeatMissing("docID", "ner.annot.gene");
    jcasType.ll_cas.ll_setStringValue(addr, ((gene_Type)jcasType).casFeatCode_docID, v);}    
   
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets Stores the source of the annotation
   * @generated */
  public String getSource() {
    if (gene_Type.featOkTst && ((gene_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "ner.annot.gene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((gene_Type)jcasType).casFeatCode_source);}
    
  /** setter for source - sets Stores the source of the annotation 
   * @generated */
  public void setSource(String v) {
    if (gene_Type.featOkTst && ((gene_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "ner.annot.gene");
    jcasType.ll_cas.ll_setStringValue(addr, ((gene_Type)jcasType).casFeatCode_source, v);}    
  }

    