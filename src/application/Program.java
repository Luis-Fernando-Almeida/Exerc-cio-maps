package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Map<String, Integer> candidateVotes = new LinkedHashMap<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String candidateName = fields[0];
                int votes = Integer.parseInt(fields[1]);

                if (candidateVotes.containsKey(candidateName)) {
                    int currentVotes = candidateVotes.get(candidateName);
                    candidateVotes.put(candidateName, currentVotes + votes);
                } else {
                    candidateVotes.put(candidateName, votes);
                }
                line = br.readLine();
            }
            for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
