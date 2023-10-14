package java9;

import lecture1.objects.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository /*extends JpaRepository<Student, Long>*/{

    Optional<Student> findById(Long id);

    List<Student> findAllByIds(List<Long> ids);//size 0,10,50

//    Student findById(Long id);

    //1, 2, 3, 4
    //ERROR, FAIL, SUCCESS
}
