
package model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class FormatLetras extends PlainDocument {
    
    private int quantidadeCar;
    public FormatLetras(int maxLen){
        super();
        if(maxLen<=0)
            throw new IllegalArgumentException("Especifique a quantidade!");
        quantidadeCar=maxLen;
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr)
    throws BadLocationException{
        if(str==null||getLength()==quantidadeCar)
            return;
        int totalquantia=(getLength()+str.length());
        if(totalquantia<=quantidadeCar){
            super.insertString(offset, str, attr);
        }
    }        
    
}
