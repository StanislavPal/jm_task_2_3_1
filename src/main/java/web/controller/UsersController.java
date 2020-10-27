package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    //Получим всех пользователей из дао и передадим в представление на отображение
    @GetMapping()
    public String index(Model model) {
        System.out.println("==========get index============");
        model.addAttribute("users", userService.index());
        return "users/index";
    }

    //Получим одного юзера по его id и передадим в представление на отображение
    @GetMapping("/{id}")
    public String showById(@PathVariable("id") long id,
                               Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id,
                               Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/edit";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id,
                          Model model) {
        userService.delete(id);
        return "redirect:/users";
    }

//    @PostMapping()
//    public String create(@RequestParam("name") String name,
//                       @RequestParam("lastname") String lastName,
//                       @RequestParam("age") int age) {
//        userService.create(name, lastName, age);
//        System.out.println("-----post--------");
//        return "redirect:/users";
//    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.create(user.getName(), user.getLastName(), user.getAge());
        System.out.println("-----post--------");
        System.out.println(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        userService.update(id,
                user.getName(),
                user.getLastName(),
                user.getAge());
        return "redirect:/users";
    }
}
