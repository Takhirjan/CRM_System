package SprintTask.almaty.Task2.Controller;

import SprintTask.almaty.Task2.Model.ApplicationRequest;
import SprintTask.almaty.Task2.Model.CourseModel;
import SprintTask.almaty.Task2.Repository.ApplicationRepository;
import SprintTask.almaty.Task2.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
  @Autowired
  private ApplicationRepository applicationRepository;

  @Autowired
  private CourseRepository courseRepository;

  @GetMapping(value = "/")
  public String indexPage(Model model) {
//    List<ApplicationRequest> applicationRequests = applicationRepository.findAllByHandled();
    List<ApplicationRequest> applicationRequests = applicationRepository.findAllByIdGreaterThan(0L);
    model.addAttribute("applicationRequests", applicationRequests);
    return "index";
  }

  @PostMapping(value = "/add-application")
  public String addApplication(ApplicationRequest application) {
    applicationRepository.save(application);
    return "redirect:/";
  }

  @GetMapping(value = "/add-application")
  public String addApplicationPage(Model model) {
  List<CourseModel> courseModels=courseRepository.findAll();
  model.addAttribute("course",courseModels);
    return "addapplication";
  }

  @GetMapping(value = "/new-application")
  public String newApplication(Model model) {
    List<ApplicationRequest> applicationRequests = applicationRepository.findAllByHandled(false);
    model.addAttribute("NewapplicationRequests", applicationRequests);
    return "new-application";
  }

  @GetMapping(value = "/all-set-application")
  public String ReadyApplication(Model model) {
    List<ApplicationRequest> applicationRequests = applicationRepository.findAllByHandled(true);
    model.addAttribute("ReadyApplication",applicationRequests);
    return "all-set-application";
  }
  @GetMapping(value = "/details-new-application/{zayavkaId}")
  public String musicDetails(@PathVariable(name = "zayavkaId") Long id, Model model) {
    ApplicationRequest applicationRequest=applicationRepository.findById(id).orElse(null);
    model.addAttribute("zayavka", applicationRequest);

    List<CourseModel> courseModels=courseRepository.findAll();
    model.addAttribute("course",courseModels);
    return "details-new-application";
  }
  @PostMapping(value = "/delete-application")
  public String deleteMusic(@RequestParam(name = "id") Long id){
    applicationRepository.deleteById(id);
    return "redirect:/";
  }
}