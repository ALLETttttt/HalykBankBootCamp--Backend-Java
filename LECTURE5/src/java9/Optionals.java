package java9;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        new Optionals().invoke();
    }

    void invoke() {
        Optional<String> optional = Optional.of("qwe");

        //mysql
        //users database
        //User.java
        //id first_name last_name middle_name created_at
        //1 qwe asd 02.02.2023
        //2 qwe asd 02.02.2023
        //3 qwe asd 02.02.2023
        //4 qwe asd 02.02.2023

        //Optional<User> optional = repository.findByid(2);
        //optional.isEmpty
        //optional.isPresent
        //Option.empty

        //select * from users where id=2;
        //NotFoundException, Unique

        //

        optional.ifPresentOrElse(q -> success(), this::error);
    }

    void error() {
        System.out.println("error");
    }

    void success() {
        System.out.println("success");
    }
}
