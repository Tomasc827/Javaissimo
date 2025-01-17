import java.util.HashMap;

public class Database {
    private HashMap<Bird,Integer> birds;

    public Database() {
        this.birds = new HashMap<>();
    }

    public void addBird(Bird bird) {
        if(bird.getName() == null || bird.getName().isEmpty()) {
            throw new IllegalArgumentException("Bird name cannot be empty or null");
        }
        if(bird.getLatinName() == null || bird.getLatinName().isEmpty()) {
            throw new IllegalArgumentException("Latin name cannot be empty or null");
        }
        if (bird.getName().length() > 255) {
            throw new NameTooLongException("Name cannot be over 255 characters");
        }
        if (bird.getLatinName().length() > 255) {
            throw new NameTooLongException("Latin name cannot be over 255 characters");
        }
        boolean birdFound = false;
        for(Bird one : birds.keySet()) {
            if(one.getName().equalsIgnoreCase(bird.getName())) {
                birdFound = true;
                break;
            }
        }
        if (!birdFound) {
            birds.put(bird,0);
            System.out.println("Bird added successfully.");
        } else {
            System.out.println("Bird already exists in the database.");
        }


    }

    public void observation(String birdName) {
        for(Bird one : birds.keySet()){
            if(one.getName().equalsIgnoreCase(birdName.toLowerCase())){
                birds.put(one,birds.get(one) + 1);
                return;
            }
        }
        System.out.println("Not a bird");
    }

    public void printOne(String name) {
        for (Bird one : birds.keySet()) {
            if(one.getName().equalsIgnoreCase(name.toLowerCase())){
                System.out.println(one + ": " + birds.get(one) + " observations");
                return;
            }
        }
        System.out.println("Bird does not exist.");
    }

    public void printAll() {
        if (birds.isEmpty()) {
            System.out.println("No birds in database");
            return;
        }
        for (Bird one : birds.keySet()) {
            System.out.println(one + ": " + birds.get(one) + " observations");
        }
    }


}
