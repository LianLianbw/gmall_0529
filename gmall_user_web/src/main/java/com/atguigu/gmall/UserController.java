package com.atguigu.gmall;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.movie.MovieService;
import com.atguigu.gmall.user.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Reference
    MovieService movieService;

    @RequestMapping("/movie")
    public Movie buyTicket(String userId, String mId){
        Movie movie = movieService.getMovie("1");
        return movie;
    }

}
