
package com.bbc.dom.bbcdomiweb.controller;

/**
 *
 * @author Christian Gutierrez
 */

import com.bbc.dom.bbcdomiweb.dao.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController {
	
ModelAndView mv = new ModelAndView();

        @Autowired
	private HomeDao HomeDao;
        
	@RequestMapping("/home")	
	public ModelAndView redirectHome(){		
		
		mv.setViewName("main/home");
                String a = HomeDao.construirRuta("hfdsgjfhgjsdghds");
		return mv;
		
	}
        @RequestMapping("/error")	
	public ModelAndView redirectHerror(){		
		
		mv.setViewName("main/error");
                System.out.println("error");
                String a = HomeDao.construirRuta("hfdsgjfhgjsdghds");
		return mv;
		
	}

}