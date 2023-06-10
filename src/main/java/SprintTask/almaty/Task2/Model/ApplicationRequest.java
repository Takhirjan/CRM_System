package SprintTask.almaty.Task2.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "t_application")
@Getter
@Setter
public class ApplicationRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name="user_name")
  private String userName;


  @Column(name = "commentary")
  private String commentary;

  @Column(name = "phone")
  private String phone;

  @Column(name = "handled")
  private boolean handled;

  @ManyToOne
  private CourseModel  course;
}
