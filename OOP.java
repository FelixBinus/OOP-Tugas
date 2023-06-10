import java.util.Scanner;
class Candidate {
     String name;
     String gender;
     String address;
     int age;
     String initial;

     Candidate(String name, String gender, String address, int age, String initial){
          this.name = name;
          this.gender = gender;
          this.address = address;
          this.age = age;
          this.initial = initial;
     }
}
public class OOP {
public static void main(String[] args) {
     int choose, idx = 0;
     Candidate[] candidates = new Candidate[100];
     Scanner masukan = new Scanner(System.in);

     do{
          System.out.println("\n-----------------");
          System.out.println("Power Recruitment");
          System.out.println("-----------------\n");
          System.out.println("1. Input New Candidate");
          System.out.println("2. View Candidate's Data");
          System.out.println("3. Remove Candidate");
          System.out.println("4. Exit");
          System.out.println("Choose: ");
          choose = masukan.nextInt();
          masukan.nextLine();
     

     switch(choose){
          case 1:
          String name, gender, address;
          String[] words;
          int age;

          do{
               System.out.println("\nInput candidate's name: ");
               name = masukan.nextLine();
               words = name.split(" ", 10);
               if(words.length < 2){
                    System.out.println("The Minimum Name Length is 2 Words");
               }
          } while(name.length() < 5 || name.length() > 20 || words.length < 2);
         
          String initial = "";
          
          for(int i = 0; i < words.length; i++){
               initial = initial + words[i].charAt(0);
          }
          initial = initial.toUpperCase();

          do{
          System.out.println("\nInput Candidate's Gender: ");
          gender = masukan.nextLine();
          gender = gender.toLowerCase();
          if(!gender.equals("male") && !gender.equals("female")){
               System.out.println("Gender Must be 'Male' or 'Female'");
          }
          }while(!gender.equals("male") && !gender.equals("female"));

          do{
          System.out.println("\nInput Candidate's Address: ");
          address = masukan.nextLine();

          if(!address.endsWith("Street")){
               System.out.println("Address Must End With 'Street'");
               continue;
          }
     }while(!address.endsWith("Street"));


          do{
               System.out.println("\nInput Candidate's Age: ");
               age = masukan.nextInt();
               masukan.nextLine();
               if (age < 17){
                    System.out.println("Please Enter a Valid Age Between 17 to 30");
               }else if(age >30){
                    System.out.println("Please Enter a Valid Age Between 17 to 30");
               }
          }while ( age < 17 || age > 30);

          System.out.println("\nThank You for Reggistering!");
          System.out.println("Your Initial is: "+ initial);

       

          Candidate candidate = new Candidate(name, gender, address, age, initial);
          candidates[idx] = candidate;
          idx++;
          break;
          
          case 2:
               if(idx == 0){
                    System.out.println("\nNo Data!\n");
               }else{
                    System.out.println();
                    bubbleSort(candidates,idx);
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("No. \t| Name \t \t| Initial \t| Gender \t \t| Age\t| Address\t \t \t|");
                    for(int i = 0; i<idx; i++){
                    //System.out.print
                    System.out.println(i+1 + ". \t| " + candidates[i].name+"\t| " + candidates[i].initial + "\t \t| " + candidates[i].gender + "\t \t| " + candidates[i].age + "\t| " + candidates[i].address + "\t \t|");
                    
               }System.out.println("-----------------------------------------------------------------------------------------");
          }
          break;

          case 3:
               if(idx == 0){
                    System.out.println("\nNo Data!\n");
               }else{
                    System.out.println("Enter the Number of the Candidates to Delete [0 for Cancel]: ");
                    int delete = masukan.nextInt();
                    masukan.nextLine();

                    if(delete < 0 || delete > idx){
                         System.out.println("Please Enter a Valid Number!");
                    }else if(delete == 0){
                         System.out.println("Canceled");

                    }else{
                         for(int i = delete - 1; i < idx - 1; i++){
                              candidates[i] = candidates[i+1];
                         }
                         candidates[idx-1] = null;
                         idx--;
                    }
               }
          break;

          case 4:
          System.out.println("\nProgram Exited\n");
          return;
          

          default:
          System.out.println("\nPlease Input a Valid Choice!\n");
          break;

     }
          }while (choose != 4);
}

     static void bubbleSort(Candidate candidates[], int n){
          int i, j;
          Candidate temp;
          for(i = 0; i < n - 1; i++){
               for(j = 0; j < n - i - 1; j++){
                    if (candidates[j].name.compareTo(candidates[j+1].name) > 0){
                         temp = candidates [j];
                         candidates[j] = candidates[j+1];
                         candidates[j+1] = temp;
                    }
               }
          }
     }

}
