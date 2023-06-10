package SprintTask.almaty.Task2.Repository;

import SprintTask.almaty.Task2.Model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel,Long> {

}
