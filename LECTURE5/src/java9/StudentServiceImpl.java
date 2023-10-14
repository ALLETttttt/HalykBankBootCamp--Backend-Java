package java9;

import lecture1.objects.Student;

import java.util.Optional;

public class StudentServiceImpl implements IStudentService{

    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> optional =  studentRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        return optional.get();
    }
}
