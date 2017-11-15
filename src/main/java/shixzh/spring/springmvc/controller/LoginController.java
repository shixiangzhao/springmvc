package shixzh.spring.springmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController implements EnvironmentAware {

    private final Log logger = LogFactory.getLog(LoginController.class);

    // 输入"http://localhost:8080/mvc121/"，即可跳转主页
    @RequestMapping(value = { "/" }, method = { RequestMethod.HEAD })
    public String head() {
        return "index.jsp";
    }

    @RequestMapping(value = { "/index", "/" }, method = { RequestMethod.GET })
    public String index(Model model) throws Exception {
        logger.info("=M= processed by index");
        model.addAttribute("msg", "121, one two three four!");
        return "index.jsp";
    }

    private Environment environment = null;

    public void setEnvironment(Environment environment) {
        this.environment = environment;

    }
}
