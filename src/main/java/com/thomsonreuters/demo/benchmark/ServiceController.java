package com.thomsonreuters.demo.benchmark;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

import static java.lang.Thread.sleep;

@Controller
public class ServiceController {
    private static final Random RANDOM = new Random();

    @RequestMapping(value = "/sleep/{m}/{s}", method = RequestMethod.GET)
    public
    @ResponseBody
    Response sleepNormal(@PathVariable("m") int m, @PathVariable("s") int s, HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        long responseTime = (long) (m + s * RANDOM.nextGaussian());
        sleep(responseTime);
        response.addHeader("responseTimeInMillis", String.valueOf(responseTime));
        return new Response(0, responseTime);
    }
}
