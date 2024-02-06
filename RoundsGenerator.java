import java.util.ArrayList;
import java.util.Scanner;

public class RoundsGenerator {
    public static void main(String[] args) throws Exception {
        
        ArrayList<String> teamNamesArrayList = new ArrayList<>(); 
        enterNames(teamNamesArrayList);
        ArrayList<String> roundsArrayListMain = new ArrayList<>();
        // roundsArrayListMain = roundsGenerator(teamNamesArrayList);
        // roundsArrayListMain = roundsGenerator(0, teamNamesArrayList);

        // roundsPrinter(roundsArrayListMain);

        // int numOfTeams = teamNamesArrayList.size();
        // for(int i = 0; i<numOfTeams - 1; i++){
        //     roundsArrayListMain = roundsGenerator(i, teamNamesArrayList);
        //     roundsPrinter(roundsArrayListMain);
        //     System.out.println("\n");
        // }

        int numOfTeams = teamNamesArrayList.size();
        for(int i = 0; i<numOfTeams - 1; i++){
            roundsArrayListMain = roundsGenerator(i, teamNamesArrayList);
            // make a method that takes two array lists and adds elements of one arraylist to the other
            // after adding all of the generated "rounds" they must be called matches later on... do the following
            // do something here that iterates with step size of 3 in order to show team1 vs team 2 \n team3 vs team4 \n team5 vs team6
            // after that it must print round 2 where team1 vs team3 \n team2 vs team5 \n team4 vs team6 or something like this (different matches)
        }
    }

    public static void enterNames(ArrayList<String> methodArrayList){

        String name;
        boolean flag = true;
        while(flag){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter name (Enter \"end\" to stop): ");
            name = input.nextLine();
            
            if(name.equals("end")){
                input.close();
                flag = false;
            }
            else{
                methodArrayList.add(name);
            }
        }

    }

    public static ArrayList<String> roundsGenerator(ArrayList<String> teamNamesArrayList){

        ArrayList<String> roundsArrayList = new ArrayList<>();

        boolean flag = true;
        int firstTeamIterator = 0;
        int secondTeamIterator = 0;
        int lastTeamIndex = teamNamesArrayList.size() - 1;

        while(flag){

            if(firstTeamIterator == secondTeamIterator){
                if(firstTeamIterator == lastTeamIndex){
                    break;
                }
                else{
                    secondTeamIterator +=1;
                }
            }
               
            String team1 = teamNamesArrayList.get(firstTeamIterator);
            String team2 = teamNamesArrayList.get(secondTeamIterator);
            roundsArrayList.add(team1 + " vs " + team2);

            if(secondTeamIterator == lastTeamIndex){
                firstTeamIterator +=1;
                secondTeamIterator = 0;
            }
            else{
                secondTeamIterator +=1;
            }

        }


        return roundsArrayList;

    }

    public static void roundsPrinter(ArrayList<String> generatedRoundsArrayList){

        for(int i = 1; i<generatedRoundsArrayList.size()+1; i++){
            System.out.println("Round " + i + ": " + generatedRoundsArrayList.get(i-1));
        }

    }

    public static ArrayList<String> roundsGenerator(int selectedTeamIndex, ArrayList<String> teamsAvailable){
        
        ArrayList<String> generatedRoundsArrayList = new ArrayList<>();
        for(int i = 0; i<teamsAvailable.size(); i++){
            if(selectedTeamIndex != i){
                generatedRoundsArrayList.add(teamsAvailable.get(selectedTeamIndex) +" vs " + teamsAvailable.get(i));
            }
        }

        return generatedRoundsArrayList;

    }

}
