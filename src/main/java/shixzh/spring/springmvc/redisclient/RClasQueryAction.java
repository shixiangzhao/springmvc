package shixzh.spring.springmvc.redisclient;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("redis")
@Controller
public class RClasQueryAction {

    //RedisService rs = RedisTool.getRedisService();
    List<Clazz> claslist = new ArrayList<Clazz>();
    Clazz c;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String execute(HttpServletRequest request) {
//        if (rs != null) {
//            System.out.println("RedisService : " + rs);
//            //getAllClas();
//        }
        request.setAttribute("claslist", claslist);
        return "SUCCESS";
    }

//    private void getAllClas() {
//        claslist = new ArrayList<Clas>();
//        int num = Integer.parseInt(rs.get("clas:count"));
//        for (int i = 0; i < num; i++) {
//            String cid = "clas:" + (i + 1);
//            c = new Clas();
//            int id = Integer.parseInt(String.valueOf(rs.getHash(cid, "ID")));
//            c.setId(id);
//            System.out.println("ID:" + id);
//            String name = (String) rs.getHash(cid, "NAME");
//            c.setName(name);
//            System.out.println("NAME:" + name);
//            String comment = (String) rs.getHash(cid, "COMMENT");
//            c.setComment(comment);
//            System.out.println("COMMENT:" + comment);
//            claslist.add(c);
//        }
//    }

}
