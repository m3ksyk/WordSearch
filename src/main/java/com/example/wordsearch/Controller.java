package com.example.wordsearch;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String indexPage(){
        return "search";
    }
    @GetMapping("/search")
    public String searchForm(WebRequest request, Model model){
        return "search";
    }

    @PostMapping("/search")
    @ResponseBody
    public String SearchResult(@RequestParam("sitename") String sitename, @RequestParam("word") String word){
      int result = Util.performSearch(sitename, word);
    return "Number of word " + word + " found on site " + sitename + " : " + result;
    }
}
