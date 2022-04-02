package bootsample.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	//@Autowired
//	private TaskService taskService;

	@GetMapping("/dashboard")
	public String home(HttpServletRequest request){
		return "dashboard";
	}
	
	@GetMapping("/d_dashboard")
	public String d_dashboard(HttpServletRequest request){
		return "d_dashboard";
	}
	
	@GetMapping("/m_dashboard")
	public String m_dashboard(HttpServletRequest request){
		return "m_dashboard";
	}
	
//	@GetMapping("/all-tasks")
//	public String allTasks(HttpServletRequest request){
//		request.setAttribute("tasks", taskService.findAll());
//		request.setAttribute("mode", "MODE_TASKS");
//		return "index";
//	}
//	
//	@GetMapping("/new-task")
//	public String newTask(HttpServletRequest request){
//		request.setAttribute("mode", "MODE_NEW");
//		return "index";
//	}
//	
//	@PostMapping("/save-task")
//	public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request){
//		taskService.save(task);
//		request.setAttribute("tasks", taskService.findAll());
//		request.setAttribute("mode", "MODE_TASKS");
//		return "index";
//	}
//	
//	@GetMapping("/update-task")
//	public String updateTask(@RequestParam int id, HttpServletRequest request){
//		request.setAttribute("task", taskService.findTask(id));
//		request.setAttribute("mode", "MODE_UPDATE");
//		return "index";
//	}
//	
//	@GetMapping("/delete-task")
//	public String deleteTask(@RequestParam int id, HttpServletRequest request){
//		taskService.delete(id);
//		request.setAttribute("tasks", taskService.findAll());
//		request.setAttribute("mode", "MODE_TASKS");
//		return "index";
//	}
	
}
