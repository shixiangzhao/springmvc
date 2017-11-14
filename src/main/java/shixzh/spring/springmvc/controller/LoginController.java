package shixzh.spring.springmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private final Log logger = LogFactory.getLog(LoginController.class);
    
    @RequestMapping(value={"/"}, method={RequestMethod.HEAD})
    public String head() {
        return "index.jsp";
    }
    
    @RequestMapping(value={"/index", "/"}, method={RequestMethod.GET})
    public String index(Model model) throws Exception {
        logger.info("=============processed by index=============");
        model.addAttribute("msg", "121, one two three four!");
        return "index.jsp";
    }
}
