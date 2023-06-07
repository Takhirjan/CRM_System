package SprintTask.almaty.Task2.Controller;

import SprintTask.almaty.Task2.Model.ApplicationRequest;
import SprintTask.almaty.Task2.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
  @Autowired
  private ApplicationRepository applicationRepository;

  @GetMapping(value = "/")
  public String indexPage(Model model) {
    List<ApplicationRequest> applicationRequests = applicationRepository.findAllByHandled(false);
    model.addAttribute("applicationRequests", applicationRequests);
    return "index";
  }
  @PostMapping(value = "/add-application")
  public String addApplication(ApplicationRequest application){
    applicationRepository.save(application);
    return "redirect:/";
  }
  @GetMapping(value = "/add-application")
  public String addApplicationPage(Model model){
    return "addapplication";
  }
}