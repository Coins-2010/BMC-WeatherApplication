

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;


/**
 *Class for Performing Various functions on two data sets stored in text files.
 * @author del16117483
 * @version 1.0
 */
public class ProjWeather {
    static Scanner MenuScan = new Scanner (System.in);
    static File Temperatures = new File("temperatures.txt");
    static File Windspeeds = new File("windspeeds.txt");
    static int[] arrTemps = new int[100];
    static int[] arrWind = new int[100];
    static int size=0;
    static int num;
    static String B = null;


    /** This method is where the temperatures.txt file is read into the array. 
     * 
     */
    public static void arrTemps(){
        boolean values = true;
        int count = 0;
        
        try{
        	Scanner TempsScanner = new Scanner(Temperatures);
                while (values) {  
		int t = TempsScanner.nextInt();
                if (t != -999) {
                    arrTemps[count] = t;
                    count ++;  
                }
                else {
                    values = false;
                    size=count-1;
                }   

                }
	}
       	catch (FileNotFoundException e) {
            System.out.println("File input error");
        } 
                    int[] adjustedArrTemps = Arrays.copyOfRange (arrTemps, 0,size);
                    System.out.println(Arrays.toString(adjustedArrTemps));
                    
    }
     /** This method is where the windspeeds.txt file is read into the array. 
     * 
     */
    public static void arrWind(){
        boolean values = true;
        int count = 0;
        
        
        try{
        	Scanner WindScanner = new Scanner(Windspeeds);
                while (values) {  
		int t = WindScanner.nextInt();
                if (t != -999) {
                    arrWind[count] = t;
                    count ++;  
                }
                else {
                    values = false;
                    size=count-1;
                }   

                }
	}
       	catch (FileNotFoundException e) {
            System.out.println("File input error");
        } 
        int[] adjustedArrWinds = Arrays.copyOfRange(arrWind,0,size);
        System.out.println(Arrays.toString(adjustedArrWinds));
    }
    /** This method is what finds the maximum value. 
     * The method is set to work with either array.
     * @param DesiredArray
     * @return max
     */
    public static int findMax(int[] DesiredArray){ 
          int max = DesiredArray[0]; 
          for(int i=1;i < size+1;i++){ 
              if(DesiredArray[i] > max){ 
                  max = DesiredArray[i]; 
              } 
          } 
          return max; 
      }
     /** This method is what finds the minimum value. 
     * The method is set to work with either array.
     * @param DesiredArray
     * @return min
     */     
    public static int findMin(int[] DesiredArray){ 
          int min = DesiredArray[0]; 
          for(int i=1;i<size+1;i++){ 
              if(DesiredArray[i] < min){ 
                  min = DesiredArray[i]; 
              } 
          } 
          return min; 
      } 
     /** This method contains the if statements for the Beaufort scale.
     * 
     * @param num
     * @return B
     */     
    public static String beaufort(double num){
        
        
            if (num <=0.99) {
            B = ("0 - Calm");
            }
            else if ((num>=1) && (num <=3.99)){
                B = ("1 - Light Air");
            }
            else if ((num>=4) && (num <=6.99)){
                B = ("2 - Light Breeze");
            }
            else if ((num>=7) && (num <=10.99)){
                B = ("3 - Gentle Breeze");
            }
            else if ((num>=11) && (num <=16.99)){
                B = ("4 - Moderate Breeze");
            }
            else if ((num>=17) && (num <=21.99)){
                B = ("5 - Fresh Breeze");
            }
            else if ((num>=22) && (num <=27.99)){
                B = ("6 - Strong Breeze");
            }
            else if ((num>=28) && (num <=33.99)){
                B = ("7 - Near Gale");
            }
            else if ((num>=34) && (num <=40.99)){
                B = ("8 - Gale");
            }
            else if ((num>=41) && (num <=47.99)){
                B = ("9 - Strong Gale");
            }
            else if ((num>=48) && (num <=55.99)){
                B = ("10 - Storm");
            }
            else if ((num>=56) && (num <=63.99)){
                B = ("11 - Violent Storm");
            }
            else 
                B = ("12 - Hurricane");
        return  B;
            
    
          
        }   
     /** This method is what displays the maximum Temperature. 
     * The method calls upon the earlier method which contains the formula needed.
     */     
    public static void maxTemp(){
        //Call Method to find Max value of Temperature Array
        int maxTemps = findMax(arrTemps);
        System.out.println("Maximum Temperature is: " +maxTemps);   
        ProjWeather.menu3();
    }
     /** This method is what displays the minimum Temperature. 
     * The method calls upon the earlier method which contains the formula needed.
     */  
    public static void minTemp(){
        //Call Method to find Minimum Value of Temperature Array
       int minTemps = findMin(arrTemps);
        System.out.println("Minimum Temperature is: " +minTemps); 
        ProjWeather.menu3();

    }    
      /** This method is what calculates and displays the average temperature. 
     * It uses the integer size to determine the actual length of the array.
     */             
      
    public static void avgTemp(){
        int total = 0; double avtemp=0;
        for (int i = 0; i <=size; i++) {
            total = total + arrTemps[i];
        }
        avtemp = (double)total/(size+1);
        
        System.out.println("Average Temperature is: " +avtemp);
        ProjWeather.menu3();
    }  
     /** This method is what calculates and displays the count of values higher than what has been input by the user. 
     * This works by comparing the value against the array for Temperatures and is counting the results.
     */      
    public static void aboveTemp(){
        Scanner scan;
        scan = new Scanner (System.in);
         System.out.print("Please Enter A Temperature: ");
         int count = 0;
         try {   
        int x = scan.nextInt();

        for (int i = 0; i < size+1; i++) {
            if (arrTemps[i] > x){
                count++;
            }
        }
         
        System.out.println("Count Above: "+count );
        }
         catch(InputMismatchException ex) {
             System.out.println("*************");
             System.out.println("Non Integer Value Entered");
         }

        ProjWeather.menu3();
    }
     /** This method is what calculates and displays the count of values lower than what has been input by the user. 
     * This works by comparing the value against the array and counting the results.
     */      
    public static void belowTemp(){
        Scanner scan;
        scan = new Scanner (System.in);
         System.out.print("Please Enter A Temperature: ");
         int count = 0;
         try{
        int x = scan.nextInt();
        for (int i = 0; i < size+1; i++) {
            if (arrTemps[i] < x){
                count++;
            }
        }
         
        System.out.println("Count Below: "+count );
        }
         catch(InputMismatchException ex){
             System.out.println("*************");
             System.out.println("Non Integer Value Entered");
         }
        ProjWeather.menu3();
    }
     /** This method is what displays the maximum Wind Speed. 
     * The method calls upon the earlier method which contains the formula needed.
     */  
    public static void maxWind(){
        //Call Method to find Max value of Wind Speed Array
        int Wind = findMax(arrWind);
       
        System.out.println("Maximum Wind Speed is: " +Wind);
        System.out.println("Beaufort Scale: "+ beaufort(Wind));
        ProjWeather.menu3();
    }
     /** This method is what displays the maximum Wind Speed. 
     * The method calls upon the earlier method which contains the formula needed.
     */      
    public static void minWind(){
        //Call Method to find Minimum value of Wind Speed Array
        int Wind = findMin(arrWind);
       
        System.out.println("Minimum Wind Speed is: " +Wind);
        System.out.println("Beaufort Scale: "+ beaufort(Wind));
        ProjWeather.menu3();

    }
      /** This method is what calculates and displays the average Wind Speed. 
     * It uses the integer size to determine the actual length of the array.
     */  
    public static void avgWind(){
        int total = 0; double Wind=0;
        for (int i = 0; i <=size; i++) {
            total = total + arrWind[i];
        }
        Wind = (double)total/(size+1);
        System.out.println("Average Windspeed is: " + Wind );
        System.out.println("Beaufort Scale: "+ beaufort(Wind));
       
        ProjWeather.menu3();

    } 
     /** This method is what calculates and displays the count of values higher than what has been input by the user. 
     * This works by comparing the value against the array of windspeeds and is counting the results.
     */     
    public static void aboveWind(){
        Scanner scan;
        scan = new Scanner (System.in);
         System.out.print("Please Enter A Windspeed: ");
         int count = 0;
         try{
        int x = scan.nextInt();
        for (int i = 0; i < size+1; i++) {
            if (arrWind[i] > x){
                count++;
            }
        }

        System.out.println("Count Above: "+count );
        }
         catch(InputMismatchException ex){
             System.out.println("*************");
             System.out.println("Non Integer Value Entered");
         }
        ProjWeather.menu3();
    }
     /** This method is what calculates and displays the count of values lower than what has been input by the user. 
     * This works by comparing the value against the array of windspeeds and is counting the results.
     */     
    public static void belowWind(){
        Scanner scan;
        scan = new Scanner (System.in);
         System.out.print("Please Enter A Windspeed: ");
         int count = 0;
         try{
        int x = scan.nextInt();
        for (int i = 0; i < size+1; i++) {
            if (arrWind[i] < x){
                count++;
            }
        }
        System.out.println("Count Below: "+count );
        }
         catch(InputMismatchException ex){
             System.out.println("*************");
             System.out.println("Non Integer Value Entered");
         }
        ProjWeather.menu3();
    }
    
     /** This method contains the first menu that the user will see when they open the application. 
     * This menu shows the user the two arrays so they can confirm they are correct before they open the application any further.
     */     
    public static void menu(){
        int MenuOption;
        System.out.print("Temperatures = ");
        System.out.println("");
        ProjWeather.arrTemps();
        System.out.println("");
        System.out.println("Windspeeds = ");
        ProjWeather.arrWind();
        System.out.println("");
        System.out.println("");
        System.out.println("If correct and you wish to continue please press 1.");
        System.out.println("For Help press 2");
        System.out.println("If not please press 0 to exit");
        System.out.print("Enter Choice: ");
        try{
        MenuOption = MenuScan.nextInt();
        switch (MenuOption)
        {
        case 1: ; ProjWeather.menu2();
            break;
        case 2: ; ProjWeather.help();
            break;
        case 0: ; System.exit(0);
            break;
            default: invalidMenu();
       
    }
        }
        catch(InputMismatchException ex){
            System.out.println("Non Integer Value Entered");
            invalidMenu();
        }
    }
     /** This method contains the main menu of the application. 
     * This menu allows the users to choose which functions they wish to use.
     */       
    public static void menu2(){
        int MenuOption;
       System.out.println("Menu");
        System.out.println("*************");
        System.out.println("1. Find maximum temperature");
        System.out.println("2. Find minimum temperature");
        System.out.println("3. Find average temperature");
        System.out.println("4. Find number of occasions temperature has been above a certain value");
        System.out.println("5. Find number of occasions temperature has been below a certain value");
        System.out.println("6. Find maximum wind speed and Beaufort Scale");
        System.out.println("7. Find minimum wind speed and Beaufort Scale");
        System.out.println("8. Find average wind speed and Beaufort Scale");
        System.out.println("9. Find number of occasions wind speed has been above a certain Knots");
        System.out.println("10. Find number of occasions wind speed has been below a certain Knots");
        System.out.println("11. Help Screen");
        System.out.println("0. Exit");
        System.out.println("*************");
        System.out.print("Enter Choice: ");
        try{
        MenuOption = MenuScan.nextInt();
        switch (MenuOption)
        {
        case 1:ProjWeather.maxTemp();
            break;
        case 2:ProjWeather.minTemp();
            break;
        case 3:ProjWeather.avgTemp();
            break;
        case 4:ProjWeather.aboveTemp();
            break;
        case 5:ProjWeather.belowTemp();
            break;
        case 6:ProjWeather.maxWind();
            break;
        case 7:ProjWeather.minWind();
            break;
        case 8:ProjWeather.avgWind();
            break;
        case 9:ProjWeather.aboveWind();
            break;
        case 10:ProjWeather.belowWind();
            break;
        case 11: ; ProjWeather.help();
            break;
        case 0: ; System.exit(0);
            break;
        default: invalidMenu();
        
        }
        }
        catch(InputMismatchException ex){
                System.out.println("Non Integer Value Entered");
                invalidMenu();
                }
    
    }
     /** This method contains the return menu of the application. 
     * This menu allows users to return to the main menu.
     */     
    public static void menu3(){
        int MenuOption;
        System.out.println("*************");
        System.out.println("If you would like to go back to the Menu. Please Press 1.");
        System.out.println("If not please press 0 to exit");
        System.out.print("Enter Choice: ");
        try{
        MenuOption = MenuScan.nextInt();
        switch (MenuOption)
        {
        case 1:ProjWeather.menu2();
            break;
        case 0: ; System.exit(0);
            break;
            default: invalidMenu();
    }
        }
        catch(InputMismatchException ex){
            System.out.println("Non Integer Value Entered");
            invalidMenu();
        }
}
     /** This method contains the help screen for the application. 
     * This provides basic help with the application.
     */      
    public static void help(){
        System.out.println("*************");
        System.out.println("Help Screen");
        System.out.println("To use this application, please enter the corresponding");
        System.out.println("values set out on the main menu. This will then perform the");
        System.out.println("selected function.");
        System.out.println("For the Above and Below Functions for the Arrays");
        System.out.println("You need to input a valid integer for the function to work");
        System.out.println("");
        System.out.println("To exit the application at any time you can press 0 on your");
        System.out.println("keyboard unless you are entering a value for a function");
        System.out.println("*************");
        ProjWeather.menu3();
    }
    /**This is the menu a user will see if they enter the wrong data in the menu system.
     * 
     */
    public static void invalidMenu(){
        int MenuOption;
        System.out.println("*************");
        System.out.println("Invalid Selection");
        System.out.println("To go to the Main Menu. Please Press 1.");
        System.out.println("To Exit. Please Press 0");
        System.out.print("Enter Choice: ");
        try{
        MenuOption = MenuScan.nextInt();
        switch (MenuOption)
        {
        case 1:ProjWeather.menu2();
            break;
        case 0: ; System.exit(0);
        default: invalidMenu();
        }
        }
        catch(InputMismatchException ex){
            System.out.println("Non Integer Value Entered");
            invalidMenu();
        }
    }
    /**
     * Main Method for the Application. This is for calling the first menu Method.
     * 
     * @param args 
     */
    public static void main(String[] args) {
       ProjWeather.menu();

       
       
       
    }
    
        
    }

