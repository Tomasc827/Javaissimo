import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Console {
    private CalorieCounter calorieCounter;
    private Scanner scan;
    private static final String DEFAULT_FILE_PATH = "calorie_data.txt";
    public Console() {
        this.scan = new Scanner(System.in);
    }

    public void start() {
        Weekdays selectedDay = dayPicker();
        genderPicker(selectedDay);
        menu();
    }

    public Weekdays dayPicker() {
        System.out.println("Pick a day: \n 1. Monday \n 2. Tuesday \n 3. Wednesday \n 4. Thursday \n 5. Friday \n 6. Saturday \n 7. Sunday \n 8. Does not matter");
        int dayChoice = Integer.parseInt(scan.nextLine().trim());
        Weekdays selectedDay;
        switch (dayChoice) {
            case 1 ->  selectedDay = Weekdays.Monday;
            case 2 ->  selectedDay = Weekdays.Tuesday;
            case 3 ->  selectedDay = Weekdays.Wednesday;
            case 4 ->  selectedDay = Weekdays.Thursday;
            case 5 ->  selectedDay = Weekdays.Friday;
            case 6 ->  selectedDay = Weekdays.Saturday;
            case 7 ->  selectedDay = Weekdays.Sunday;
            case 8 ->  selectedDay = Weekdays.DoesNotMatter;
            default -> {
                System.out.println("Invalid Choice, defaulting to does not matter.");
                selectedDay = Weekdays.DoesNotMatter;
            }
        }
        System.out.println("\nYou have selected: " + selectedDay + "\n");
        return selectedDay;
    }

    public void genderPicker(Weekdays selectedDay) {
        System.out.println("Pick your gender: \n 1. Male \n 2. Female \n 3. Does not matter");
        int genderChoice = Integer.parseInt(scan.nextLine().trim());
        Gender gender;
        switch (genderChoice) {
            case 1 -> gender = Gender.Male;
            case 2 -> gender = Gender.Female;
            case 3 -> gender = Gender.DoesNotMatter;
            default -> {
                System.out.println("Invalid Choice, defaulting to does not matter.");
                gender = Gender.DoesNotMatter;
            }
        }         System.out.println("\nYou have selected: " + gender + "\n");

        if(selectedDay != Weekdays.DoesNotMatter && gender != Gender.DoesNotMatter) {
            this.calorieCounter = new CalorieCounter(selectedDay,gender);
        } else if(selectedDay != Weekdays.DoesNotMatter) {
            this.calorieCounter = new CalorieCounter(selectedDay);
        }else if(gender != Gender.DoesNotMatter) {
            this.calorieCounter = new CalorieCounter(gender);
        } else {
            this.calorieCounter = new CalorieCounter();
        }

    }

    public void menu() {
        boolean stop = false;

      while (!stop)  {
            System.out.println("\nPick an Option: \n 1. Add Product \n 2. Add Alcoholic Beverage \n 3. Print One Product \n 4. Print All Products \n 5. Print This Day \n 6. Save To File \n 7. Load From File \n 8. Exit");
            int input = Integer.parseInt(scan.nextLine().trim());
            switch (input) {
                case 1 -> nonAlco();

                case 2 -> alco();

                case 3 -> {
                    System.out.print("Type in the name of the product: ");
                    String name = scan.nextLine().trim().toLowerCase();
                    calorieCounter.printOne(name);
                }
                case 4 -> calorieCounter.printAll();
                case 5 -> System.out.println(calorieCounter);
                case 6 -> saveToFile();
                case 7 -> loadFromFile();
                case 8 -> {
                    stop = true;
                    break;
                }
                default -> System.out.println("\nInvalid number, try again\n");
            }
        }
    }
    private void saveToFile() {
        try {
            System.out.print("Enter filename (or press Enter for default 'calorie_data.txt'): ");
            String filename = scan.nextLine().trim();
            if (filename.isEmpty()) {
                filename = DEFAULT_FILE_PATH;
            }

            Path path = Paths.get(filename);
            String content = calorieCounter.toString();
            Files.writeString(path, content);
            System.out.println("Data successfully saved to " + filename);

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    private void loadFromFile() {
        try {
            System.out.print("Enter filename to load (or press Enter for default 'calorie_data.txt'): ");
            String filename = scan.nextLine().trim();
            if (filename.isEmpty()) {
                filename = DEFAULT_FILE_PATH;
            }

            Path path = Paths.get(filename);
            if (!Files.exists(path)) {
                System.out.println("File does not exist: " + filename);
                return;
            }

            List<String> lines = Files.readAllLines(path);
            parseAndLoadProducts(lines);
            System.out.println("Data successfully loaded from " + filename);

        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    private void parseAndLoadProducts(List<String> lines) {
        String currentName = null;
        double fat = 0, protein = 0, carbs = 0, grams = 1, volume = 0;
        boolean isAlcoholic = false;

        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("Name: ")) {
                if (currentName != null) {
                    createAndAddProduct(currentName, fat, protein, carbs, grams, volume, isAlcoholic);
                }
                currentName = line.substring(6).trim();
                isAlcoholic = false;
                volume = 0;
            } else if (line.startsWith("Fats: ")) {
                fat = Double.parseDouble(line.substring(6).trim());
            } else if (line.startsWith("Proteins: ")) {
                protein = Double.parseDouble(line.substring(10).trim());
            } else if (line.startsWith("Carbs: ")) {
                carbs = Double.parseDouble(line.substring(7).trim());
            } else if (line.startsWith("Ethanol: ")) {
                isAlcoholic = true;
                volume = Double.parseDouble(line.substring(9).trim());
            }
        }
        if (currentName != null) {
            createAndAddProduct(currentName, fat, protein, carbs, grams, volume, isAlcoholic);
        }
    }

    private void createAndAddProduct(String name, double fat, double protein, double carbs,
                                     double grams, double volume, boolean isAlcoholic) {
        try {
            Product product;
            if (isAlcoholic) {
                product = new Alcohol(name, fat, protein, carbs, grams, volume);
            } else {
                product = new Product(name, fat, protein, carbs, grams);
            }
            calorieCounter.addProduct(product);
        } catch (Exception e) {
            System.out.println("Error creating product " + name + ": " + e.getMessage());
        }
    }

    public Product createProduct(boolean isAlcoholic) {
        try {
            System.out.println("Starting values should be entered as 100g/mg");
            System.out.print("Name: ");
            String name = scan.nextLine().trim().toLowerCase();
            System.out.print("Fat Value: ");
            double fat = Double.parseDouble(scan.nextLine().trim());
            System.out.print("Protein: ");
            double protein = Double.parseDouble(scan.nextLine().trim());
            System.out.print("Carbs: ");
            double carbs = Double.parseDouble(scan.nextLine().trim());
            System.out.print("Grams/Milligrams: ");
            double grams = Double.parseDouble(scan.nextLine().trim());

            if (isAlcoholic) {
                System.out.print("Alcohol By Volume (ABV): ");
                double volume = Double.parseDouble(scan.nextLine().trim());

                return new Alcohol(name, fat, protein, carbs, grams, volume);
            } else {
                return new Product(name, fat, protein, carbs, grams);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void nonAlco() {
        Product product = createProduct(false);
        if (product != null) {
            calorieCounter.addProduct(product);
            System.out.println("\nProduct Added Successfully\n");
        }
    }

    public void alco() {
        Product alcohol = createProduct(true);
        if (alcohol != null) {
            calorieCounter.addProduct(alcohol);
            System.out.println("\nAlcoholic Beverage Added Successfully\n");
        }
    }

}
