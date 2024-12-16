import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){



        // 1. Temperaturomvandlare
        // be användaren att mata in en temperatur i Celsius
        // Konvertera temperaturen till Fahrenheit
        // Spara de 5 senaste temperaturerna i en array
        // Visa medelvärdet av alla konverteringar


        // Krav:
        // Använd Scanner för input
        // Implementera felhantering för ogiltig input
        // Visa temperaturhistoriken på ett snyggt sätt
        // Inkludera en metod för att konvertera tillbaka till Celsius


        /// ///////

        // What split() and trim() does
        /*
        String[] wordsWithOutTrim = sentence.split("\\s");
        System.out.println(Arrays.toString(wordsWithOutTrim));
        System.out.println(wordsWithOutTrim.length);
        String[] wordsWithTrim = sentence.trim().split("\\s");
        System.out.println(Arrays.toString(wordsWithTrim));
        System.out.println(wordsWithTrim.length);
         */

        // 2. Ordhanterare
        // Ta emot en mening från användaren -
        // Räkna antal ord i meningen -
        // Hitta det längsta ordet -
        // Vänd på varje ord i meningen -

        // Krav
        // Skapa en meny där användaren kan välja funktion -
        // Implementera en metod som räknar frekvensen av varje bokstav -
        // Lägg till kontroll om meningen är ett palindrom -
        // Hantera skiljetecken och stora/små bokstäver korrekt

        boolean running = true;
        Scanner input2 = new Scanner(System.in);
        System.out.println("Ge mig en mening: ");
        String sentence = input2.nextLine();


        while(running){
            System.out.println("Välj mellan:");
            System.out.println("1) Antal ord");
            System.out.println("2) Längsta ordet");
            System.out.println("3) Dina ord fast baklänges, varför inte");
            System.out.println("4) Bokstäver och hur frekventa de är");
            System.out.println("5) Palindrimo primo?");
            System.out.println("6) Avsluta meny");
            String answer = input2.nextLine();

            if(Objects.equals(answer, "1")){
                System.out.println("Antal ord: "+ countingWords(sentence));
            }
            if(Objects.equals(answer, "2")){
                System.out.println("Längsta ordet: " + longestWord(sentence));
            }
            if(Objects.equals(answer, "3")){
                System.out.println("Här är dina ord, baklänges lol: "+ Arrays.toString(reverseWords(sentence)));
            }
            if(Objects.equals(answer, "4")){
                frequencyLetter(sentence);
            }
            if(Objects.equals(answer, "5")){
                isThisAPalindrom(sentence);
            }
            if(Objects.equals(answer, "6")){
                System.out.println("Hej då(re)");
                running = false;
            }
        }

        /*
        double[] fahrenheitTemps = new double[5];
        double[] celsiusTemps = new double[5];
        Scanner tempInput = new Scanner(System.in);

        // input and converting
        for(int i = 0; i < fahrenheitTemps.length; i++) {
            while(true) {
                try {
                    System.out.println("Input temperature " + (i + 1) + " in Celsius ");
                    String input = tempInput.nextLine();
                    double temp = Double.parseDouble(input);
                    fahrenheitTemps[i] = convertToFahrenheit(temp);
                    break;
                }
                catch(NumberFormatException e) {
                    System.out.println("No fucker, try again");
                }
            }
        }

        // calculate average and present the saved temperature
        double sum = 0;
        for(int i = 0; i<fahrenheitTemps.length; i++){
            sum += fahrenheitTemps[i];
            System.out.println("This is in your index number "+(i+1)+" and the temperature was "+fahrenheitTemps[i]);
        }
        System.out.println("The average temperature is " + sum/fahrenheitTemps.length);

        // converting back to Celsius
        System.out.println("Why not fuck around and make the temperature back to celsius?");
        System.out.println("So here it is: ");
        for(int i = 0; i<fahrenheitTemps.length; i++){
            celsiusTemps[i] = convertToCelsius(fahrenheitTemps[i]);
            System.out.println("This is in your index number "+(i+1)+" and the temperature was "+ celsiusTemps[i]);
        }

         */
    }

    static double convertToFahrenheit(double temp) {
        return (temp * 1.8) + 32;
    }
    static double convertToCelsius(double temp) {
        return (temp - 32) / 1.8;
    }

    static String[] splitSentence(String sentence){
        return sentence.trim().split("\\s+");
    }

    static int countingWords(String sentence){
        String[] words = splitSentence(sentence); // "\\s+" matchar ett eller flera mellanslag
        return words.length;
    }

    static String longestWord(String sentence){
        String[] words = splitSentence(sentence);
        String longestWord = words[0];
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    static String trimmedWords(String sentence){
        return sentence.trim();
    }

    static String[] reverseWords(String sentence){
        String[] words = splitSentence(sentence);

        for ( int i = 0; i < words.length; i++){
            String reversedStr = "";

            for (int j = 0; j < words[i].length(); j++) {
                reversedStr = words[i].charAt(j) + reversedStr;
            }
            words[i] = reversedStr;
        }
        return words;
    }

    static void frequencyLetter(String sentence){
        System.out.println("Din mening ["+sentence+"] har dessa bokstäver i sig: ");
        HashMap<Character, Integer> letterFrequency = new HashMap<>();
        String[] words = splitSentence(sentence);

        for(int i = 0; i < words.length; i++){
            char[] arrayOfLetters = words[i].toCharArray();
            for (int j = 0; j < arrayOfLetters.length; j++){
                if (letterFrequency.containsKey(arrayOfLetters[j])) {
                    int currentCount = letterFrequency.get(arrayOfLetters[j]);
                    letterFrequency.put(arrayOfLetters[j], currentCount + 1);
                } else {
                    letterFrequency.put(arrayOfLetters[j], 1);
                }
            }
        }

        for (HashMap.Entry<Character, Integer> entry : letterFrequency.entrySet()) {
            char key = entry.getKey(); // Hämtar nyckeln
            int value = entry.getValue(); // Hämtar värdet

            System.out.println("Bokstav: " + key + ", Frekvens: " + value);
        }
    }

    static void isThisAPalindrom(String sentence){
        String cleanedSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversedSentence = new StringBuilder(cleanedSentence).reverse().toString();

        if(cleanedSentence.equals(reversedSentence)){
            System.out.println("Palindrom baby!");
        } else {
            System.out.println("No baby, no palindrimo primo");
        }
    }
}

