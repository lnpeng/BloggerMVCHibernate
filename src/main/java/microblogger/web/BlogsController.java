package microblogger.web;

import microblogger.dao.BlogRepository;
import microblogger.dao.entity.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/blogs")
public class BlogsController {
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private BlogRepository blogRepository;

    @Autowired
    public BlogsController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @RequestMapping(method = GET)
    public List<Blog> blogs(
    		@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return blogRepository.findBlogs(max, count);
    }

    @RequestMapping(method = POST)
    public String saveBlog(BlogForm form, Model model, Principal principal) throws Exception { 
        blogRepository.save(new Blog(null, form.getMessage(), new Date()));
        return "redirect:/blogs";
    }
}
