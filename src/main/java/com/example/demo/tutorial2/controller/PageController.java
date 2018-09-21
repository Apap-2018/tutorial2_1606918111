package com.example.demo.tutorial2.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController{
    @RequestMapping("/viral")
    public String index(){
        return "viral2jari";
    }

    @RequestMapping("/challenge")
    public String challenge(@RequestParam(value="name") String name, Model model) {
        model.addAttribute("name",name);
        return "challenge";
    }
    
    @RequestMapping(value={"/challenge","challenge/{name}"})
    public String challengePath(@PathVariable Optional<String> name, Model model){
        if(name.isPresent()){
            model.addAttribute("name", name.get());
        }
        else{
            model.addAttribute("name","KB");
        }
        return "challenge";
        
    }

    @RequestMapping("/generator")
    public String generator(
        @RequestParam(value="a",required=false, defaultValue="1") int a, 
        @RequestParam(value="b", required=false, defaultValue="1") int b, 
        Model model ){
            String result ="hm";
            String temp="";

            if(a>1){
                for(int i=0;i<a-1;i++){
                    result+="m";
                }
            }
            if(b>1){
                for(int j=0;j<=b-1;j++){
                    temp+= " " +result;
                }
                result= temp;
                
            }
            
        
            model.addAttribute("a",a);
            model.addAttribute("b",b);
            model.addAttribute("result",result);
            return "generator";

    }

    
}