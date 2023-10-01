package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        List<Integer> evenNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
//                .filter(x -> x % 3 == 0)
//                .limit(1)
//                .collect(Collectors.toList());
//        evenNumbers.forEach(System.out::println);

        List<User> userList= new ArrayList<>();
        userList.add(new User(1L, 28, "Kuanysh"));
        userList.add(new User(2L,48, "Akhmet"));
        userList.add(new User(3L,18, "Madina"));

        List<Long> userIds = userList.stream().map(User::getId).collect(Collectors.toList());

//        List<String> collect = userList.stream()
//                .sorted(Comparator.comparing(User::getAge))
//                .map(q -> q.getName())
//                .collect(Collectors.toList());
//        collect.forEach(System.out::println);
    }
}
