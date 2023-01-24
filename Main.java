import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName=sc.nextLine();
        File file=new File("F:\\Git\\File-Copier\\"+fileName);
        File copyfile=new File("F:\\Git\\File-Copier\\"+fileName);
        File temporaryFile=null;
        FileReader readFile=null;
        FileWriter writeFile=null;

        readFile = new FileReader("F:\\Git\\File-Copier\\"+fileName);
        if(file.exists()){

            if(copyfile.exists()){

                temporaryFile = new File("F:\\Git\\File-Copier\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy"+fileName.substring(fileName.indexOf("."),fileName.length()));

                String subfilename=fileName.substring(0,fileName.indexOf("."));
                String extension=fileName.substring(fileName.indexOf("."),fileName.length());

                if(temporaryFile.exists()){
                    int count=2;
                    int i;
                    while(true){
                        temporaryFile = new File("F:\\Git\\File-Copier\\"+subfilename+" - Copy ("+count+")"+extension);
                        if(!temporaryFile.exists()){
                            break;
                        }
                        count++;
                    }
                    writeFile = new FileWriter("F:\\Git\\File-Copier\\"+subfilename+" - Copy ("+count+")"+extension);
                    while((i=readFile.read())!=-1){
                        writeFile.write(i);
                    }
                    System.out.println("Successfully.");
                }else{
                    int i;
                    writeFile = new FileWriter("F:\\Git\\File-Copier\\"+subfilename+" - Copy"+extension);
                    while((i=readFile.read())!=-1){
                        writeFile.write(i);
                    }
                    System.out.println("Successfully.");
                }
            }
            else {
                int i;
                writeFile = new FileWriter("F:\\Git\\File-Copier\\"+fileName);
                while((i=readFile.read())!=-1){
                    writeFile.write(i);
                }
                System.out.println("Successfully.");
            }


        }
        else{
            System.out.println("File dosen't exists...");
        }

        readFile.close();
        writeFile.close();

    }
}
