package firstPackage;

import java.io.IOException;

import firstPackage.PDFmanager;

public class PDFBox {

    public static void main(String[] args) throws IOException {

       PDFmanager pdfManager = new PDFmanager();
       pdfManager.setFilePath("C:\\Sumit\\test.pdf");
       System.out.println(pdfManager.ToText());       
    
}    
}


