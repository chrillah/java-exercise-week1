import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // be användaren att mata in en temperatur i Celsius
        // Konvertera temperaturen till Fahrenheit
        // Spara de 5 senaste temperaturerna i en array
        // Visa medelvärdet av alla konverteringar


        // Krav:
        // Använd Scanner för input
        // Implementera felhantering för ogiltig input
        // Visa temperaturhistoriken på ett snyggt sätt
        // Inkludera en metod för att konvertera tillbaka till Celsius

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
    }

    static double convertToFahrenheit(double temp) {
        return (temp * 1.8) + 32;
    }
    static double convertToCelsius(double temp) {
        return (temp - 32) / 1.8;
    }
}

