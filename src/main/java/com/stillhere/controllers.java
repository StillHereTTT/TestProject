package com.stillhere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DJ026743 on 2020/7/1.
 */
public class controllers {
    /**
     * Created by DJ026743 on 2020/6/24.
     */
    @Controller
    @RequestMapping("/home")
    public static class testController {

        @RequestMapping("/index")
        public String index() {
            System.out.println("111");
            return "index";
        }

        public static void main(String[] args) {
            System.out.println("111");
        }
    }
}
