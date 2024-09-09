
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorseRacing {

    public static void main(String[] args) {
        // 25 horses, represented by their speed (lower number means faster horse)
        int[] horses = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        findTop3Horses(horses);
    }

    public static void findTop3Horses(int[] horses) {
        // Shuffle the horses array to simulate the race
        List<Integer> horseList = new ArrayList<>();
        for (int horse : horses) {
            horseList.add(horse);
        }
        Collections.shuffle(horseList); // Shuffle to randomize

        // Step 1: Divide horses into 5 groups and race them
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            groups.add(horseList.subList(i * 5, (i + 1) * 5));
            Collections.sort(groups.get(i)); // Sort each group to simulate the race outcome
        }

        // Step 2: Race the winners of each group
        List<Integer> raceOfWinners = new ArrayList<>();
        for (List<Integer> group : groups) {
            raceOfWinners.add(group.get(0)); // Take the winner from each group
        }
        Collections.sort(raceOfWinners); // Sort to determine the fastest

        // Step 3: A1 is the fastest, now we need to determine 2nd and 3rd
        int fastest = raceOfWinners.get(0); // A1
        int secondFastest = raceOfWinners.get(1); // B1
        int thirdFastest = raceOfWinners.get(2); // C1

        // Step 4: Identify remaining contenders for 2nd and 3rd
        List<Integer> contenders = new ArrayList<>();
        contenders.add(groups.get(0).get(1)); // A2
        contenders.add(groups.get(0).get(2)); // A3
        contenders.add(groups.get(1).get(1)); // B2
        contenders.add(groups.get(2).get(1)); // C2
        contenders.add(secondFastest);
        contenders.add(thirdFastest);

        // Step 5: Final race to find 2nd and 3rd
        Collections.sort(contenders); // Sort the contenders
        secondFastest = contenders.get(0); // The 2nd fastest
        thirdFastest = contenders.get(1); // The 3rd fastest

        // Output the results
        System.out.println("The fastest horse is: Horse " + fastest);
        System.out.println("The second fastest horse is: Horse " + secondFastest);
        System.out.println("The third fastest horse is: Horse " + thirdFastest);
    }
}