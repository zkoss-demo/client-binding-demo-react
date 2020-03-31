package react;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.zkoss.lang.Library;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Controller
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Value("${zk.react.shoppingcart.bundle.js}")
    private String shoppingcartBundleJs;
    @Value("${zk.react.shoppingcart.bundle.css}")
    private String shoppingcartBundleCss;

    @PostConstruct
    public void initProperties() throws Exception {
        Library.setProperty("shoppingcart.bundle.js", shoppingcartBundleJs);
        Library.setProperty("shoppingcart.bundle.css", shoppingcartBundleCss);
    }

    @Profile("dev")
    @GetMapping("/dev")
    public String dev() {
        return "index";
    }
}
