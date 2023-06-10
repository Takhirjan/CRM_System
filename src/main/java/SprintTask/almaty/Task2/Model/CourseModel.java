package SprintTask.almaty.Task2.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_price")
@Getter
@Setter
public class CourseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "price")
  private int price;

  @Column(name = "course")
  private String courseName;

}
