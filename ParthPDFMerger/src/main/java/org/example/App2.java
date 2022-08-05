package org.example;

import java.io.File;
import java.util.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class App2
{
    public static void main( String[] args )
    {
        new App2().combine();
    }

    public void combine()
    {
        try
        {
            System.out.println("How many PDFs would you like to merge?");
            Scanner userIn = new Scanner(System.in);
            int numPDFs = userIn.nextInt();
            System.out.println("What would you like to name the merged file? (include relative path for desired location with .pdf at the end)");
            String name = userIn.next();
            name += userIn.nextLine();
            PDFMergerUtility mergePdf = new PDFMergerUtility();
            String path = null;
            for (int i = 0; i < numPDFs; i++)
            {
                System.out.println("Input the direct file path of file " + (i+1));
                path = userIn.next();
                path+= userIn.nextLine();
                mergePdf.addSource(path);
            }
            mergePdf.setDestinationFileName(name);
            mergePdf.mergeDocuments();
            System.out.println("Merge completed. Check specified location to find the file.");
        }
        catch(Exception e)
        {
            System.out.println("Did not input a viable file source");
        }
    }


}
