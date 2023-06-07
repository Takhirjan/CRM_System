package SprintTask.almaty.Task2.Repository;

import SprintTask.almaty.Task2.Model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationRequest,Long>  {
List<ApplicationRequest> findAllByHandled(boolean handled);
}
