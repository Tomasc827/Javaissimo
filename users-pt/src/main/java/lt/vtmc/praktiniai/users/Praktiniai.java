package lt.vtmc.praktiniai.users;

import java.util.*;
import java.util.stream.Collectors;

public class Praktiniai {

    public static Integer countUsersOlderThen25(List<User> users) {
//        return users.stream().filter(user -> user.getAge() > 25).count();
        Integer counter = 0;
        for(User one : users) {
            if(one.getAge() > 25) {
                counter++;
            }
        } return counter;
    }

    public static double getAverageAge(List<User> users) {
        double avg = 0;
        for(User one : users ) {
            avg += one.getAge();
        }
        return avg / users.size();
//        return users.stream().mapToDouble(User::getAge).average().orElse(0.0);
    }

    public static Integer getMinAge(List<User> users) {
        Integer min = users.get(0).getAge();
        for(User one : users) {
            if(one.getAge() < min) {
                min = one.getAge();
            }
        }
        return min;
//        return users.stream().min(Comparator.comparing(User::getAge)).map(User::getAge).orElse(0);
    }

    public static User findByName(List<User> users, String name) {
        for (User one : users) {
            if(one.getName().equals(name)) {
                return one;
            }
        } return null;
//        users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    public static List<User> sortByAge(List<User> users) {
        users.sort(Comparator.comparing(User::getAge));
        return users;
//        return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());

    }

    public static User findOldest(List<User> users) {
        int oldest = 0;
        User oldestUser = null;
        for(User one : users) {
            if(one.getAge() > oldest) {
                oldest = one.getAge();
                oldestUser = one;
            }
        } return oldestUser;
//       return users.stream().max(Comparator.comparing(User::getAge)).orElse(null);
    }

    public static int sumAge(List<User> users) {
        int totalAge = 0;
        for(User one : users) {
            totalAge += one.getAge();
        }
        return totalAge;

//        return users.stream().map(User::getAge).reduce(0,Integer::sum);
    }

}
