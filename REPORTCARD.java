/* Inheritence Program:
1. Implementation of single level inheritance with proper class names satisfying IS A relationship    1 marks
2. Implementation of multilevel inheritance with proper class names satisfying IS A relationship                 1 marks
3. Passing parameters to the parent class constructors       1 mark for single inheritance and 1 mark for multi level inherirance
*/
import java.io.*;                  //Basic IO Class
import java.sql.Time;              //Class for Time
import java.util.Scanner;          //IO using scanner       
//Parent Class
class SCHOOL
{
    //Variable declaration
	private int schNo;	
    private String schName;
    private String schCity;
    private String schHead;
    //Defalut Constructor
    SCHOOL()
    {
        schNo = 0;
    }
    //Patrameterised Constructor
    SCHOOL(int no,String name,String head)
    {
        schNo = no;
        schName = name;
        schCity = "Delhi";
        schHead = head;
    }
    public void schDisplay()
    {
        System.out.println("\n\t\t*SCHOOL INFORMATION*\n");
        System.out.println("School's No is:\t\t\t"+schNo);
        System.out.println("School's Name is:\t\t"+schName);
        System.out.println("School is in:\t\t\t"+schCity);
        System.out.println("School's Head is:\t\t"+schHead);
    }

}

// Child Class for SCHOOL
class CLASS extends SCHOOL
{
    //Variable decalration
    private String cLocation;
    private String cName;
    private String cSection;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    CLASS()
    {
        //Passing parameter to parent class constructor 
        super(17822,"Mordern Public School","Mr. Augusti");
    }
    public void cRead() throws IOException
    {
        System.out.print("Enter Location of the class:\t");
        cLocation = br.readLine();
        System.out.print("Enter Name of the class:\t");
        cName = br.readLine();
        System.out.print("Enter Section of the class:\t");
        cSection = br.readLine();    
    }
    public void cDisp()
    {
        super.schDisplay();
        System.out.println("\n\t\t*CLASS INFORMATION*\n");
        System.out.println("Location of the class is:\t" + cLocation);
        System.out.println("Name of the class is:\t\t"+cName);
        System.out.println("Section of the class is:\t"+cSection);
    }
}

//Child class to CLASS
class STUDENT extends CLASS
{
	private int sRollNo;
    private String sName;
    private short sAge;
    public void sRead() throws IOException
    {
        super.cRead();
        System.out.print("Enter Student's Roll No.:\t");        
        sRollNo = Integer.parseInt(super.br.readLine());
        System.out.print("Enter Student's Name:\t\t");        
        sName = super.br.readLine();
        System.out.print("Enter Student's Age:\t\t");        
        sAge = Short.parseShort(super.br.readLine());
    }
    public void sDip()
    {
        cDisp();
        System.out.println("\n\t\t*PERSONAL INFORMATION*\n");
        System.out.println("Student's Roll No is.:\t\t" + sRollNo);
        System.out.println("Student's Name is:\t\t" + sName);        
        System.out.println("Student's Age is:\t\t" + sAge);        
    }

}

//Child class to STUDENT
class RESULT extends STUDENT
{
    private String[] sub= {"English","Hindi  ","Maths  ","Science","EVS   "};
    private float[] rMarks = new float[5];
    private float res;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void rRead() throws IOException
	{
        super.sRead(); 
		int i;	
		for(i=0; i<5; i++)
		{
            System.out.print("Marks in " + sub[i] + ":\t\t");
            rMarks[i] = Float.parseFloat(br.readLine());
                if(rMarks[i] < 101)
                {
                    res = res + rMarks[i];
                }
                else
                {
                    i--;
                    System.out.println("Error:Marks should be less than 100");
                }
        }
    }
    
	public void rDisp()
	{
        super.sDip();
        System.out.println("\t\t*MARKS*\n");
        int i;	
        for(i=0; i<5; i++)
        {
            System.out.println("Marks in " + sub[i] + " is:\t\t" + rMarks[i]);
        }
    }
    //Checking if the student is pass or fail
	public void pof()
	{
        float ress = (res/5);
            System.out.println("Percentage :\t\t\t" + ress + "%");
		if (ress>35)
			System.out.println("Result :\t\t\tPASS\n");
		else
			System.out.println("Result :\t\t\tFAIL\n");
    }
}

public class REPORTCARD
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RESULT obj = new RESULT();
        byte ch = 0,choice =0;
     do {      
        System.out.println("\n\t***Please Enter the Following Details for Mordern Public School***\n");
        obj.rRead();
        do
        {
            System.out.print("\n\nChoose from the following:\n\t1. Display Result\n\t2. Status and Percentage\n\t3. Enter Values again or Exit\n\nChoice:\t\t");
            ch =  Byte.parseByte(br.readLine());
            System.out.print("\n");
            if(ch==1)
            {
                System.out.println("\n\n\t\t\t**Report Card:**");
                obj.rDisp();
            }
            else if(ch==2)
            {
                obj.pof();
            }
            else if(ch==3)
            {
                break;
            }
            else
            {
                System.out.println("\n\n\t\t**Not a valid option, please try again!**\n\n");
            }
       }while(ch!=3);
       System.out.print("\nPress 1 if you want to exit, otherwise enter any number to enter new values.\n");
       choice =  Byte.parseByte(br.readLine());
      }while (choice!=1);
    }
}