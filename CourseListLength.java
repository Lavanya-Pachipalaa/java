import java.util.List;
import java.util.stream.Collectors;

public class CourseListLength {

    public static List<Integer> getCourseNameCharacterCount(List<String> courses) {
        // TODO: Write code
        if (courses == null || courses.size() == 0)
            return List.of();
        return courses.stream().map(String::length).collect(Collectors.toList());
    }
}