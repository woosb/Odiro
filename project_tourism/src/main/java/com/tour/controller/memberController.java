package com.tour.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.tour.dto.MemberDTO;
import com.tour.memberService.MemberService;

@Controller
public class memberController {

	@Inject    //서비스를 호출하기 위해서 의존성을 주입
    JavaMailSender mailSender;     //메일 서비스를 사용하기 위해 의존성을 주입함.
	@Inject
    MemberService MemberService; //서비스를 호출하기 위해 의존성을 주입
  
    //로깅을 위한 변수
    private static final Logger logger=
    LoggerFactory.getLogger(memberController.class);
    private static final String String = null;
    private String e_mail=null;
    
    	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
    	public ModelAndView naver_login(String e_mail,String nick,HttpServletRequest req) throws Exception
    	{
    		HttpSession session = req.getSession();
    		session.setAttribute("e_mail", e_mail);
    		session.setAttribute("nick", nick);
    		boolean flag = MemberService.email_check(e_mail);
    		ModelAndView mv = new ModelAndView();
    		if(flag)
    		{
     	        
     	        mv.setViewName("/member/join");
     	        
     	        mv.addObject("e_mail",e_mail);
     	        
    		}else
    		{
    			session.setAttribute("nick", MemberService.getnick(e_mail));
     	        mv.setViewName("/memberDetail/detail");
   
    		}
    		return mv;
    	}
    	@RequestMapping(value="/member/idfind", method=RequestMethod.POST)
    	public ModelAndView idFind(String nick, HttpServletResponse response_equals) throws IOException
    	{
    		 if(!MemberService.nick_check(nick)) {
    			 String e_mail=MemberService.get_email(nick);
     	        response_equals.setContentType("text/html; charset=UTF-8");
     	        PrintWriter out_equals = response_equals.getWriter();
     	        
     	        ModelAndView mv = new ModelAndView();
     	        
     	        mv.setViewName("/member/idfind");
     	        
     	        mv.addObject("e_mail",e_mail);
     	        
     	        return mv;
     	    }else {
     	        response_equals.setContentType("text/html; charset=UTF-8");
     	        PrintWriter out_equals = response_equals.getWriter();
     	        out_equals.println("<script>alert('없는 아이디입니다.'); history.go(-1);</script>");
     	        out_equals.flush();
     	        
     	    }
     	    
     	    ModelAndView mv = new ModelAndView();
     	    mv.setViewName("/member/idfind");
     	    
     	 
     	        return mv;
    	}
    	@RequestMapping(value="/member/naverLogin", method=RequestMethod.GET)
    	public String naver() throws IOException
    	{
    		
    		return "/member/naverLogin";
    	}
    	@RequestMapping(value="/member/idfind", method=RequestMethod.GET)
    	public String id_Find()
    	{
    		return "/member/idfind";
    	}
    	@RequestMapping(value="/member/passwordFind", method=RequestMethod.GET)
    	public String passwordFind()
    	{
    		return "/member/passwordFind";
    	}
    	@RequestMapping(value="/member/emailCheck", method=RequestMethod.POST)
    	public ModelAndView emailCheck(String e_mail, HttpServletResponse response_equals) throws Exception
    	{
    		 System.out.println(e_mail);
    	        System.out.println(MemberService);
    	        MemberService.email_check(e_mail);
    	        
    	    if(!MemberService.email_check(e_mail)) {
    	        
    	        response_equals.setContentType("text/html; charset=UTF-8");
    	        PrintWriter out_equals = response_equals.getWriter();
    	        
    	        ModelAndView mv = new ModelAndView();
    	        
    	        mv.setViewName("/member/passwordFind");
    	        
    	        mv.addObject("e_mail",e_mail);
    	        
    	        return mv;
    	    }else {
    	        response_equals.setContentType("text/html; charset=UTF-8");
    	        PrintWriter out_equals = response_equals.getWriter();
    	        out_equals.println("<script>alert('없는 아이디입니다.'); history.go(-1);</script>");
    	        out_equals.flush();
    	        
    	    }
    	    
    	    ModelAndView mv = new ModelAndView();
    	    mv.setViewName("/member/passwordFind");
    	    
    	 
    	        return mv;
    	}
    	 @RequestMapping( value = "/member/pass{e_mail}" , method=RequestMethod.POST )
         public ModelAndView mailSending2(HttpServletRequest request,@PathVariable String e_mail, HttpServletResponse response_email) throws IOException {
  
             Random r = new Random();
             int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
             
             String setfrom = "hanryang0307@gmail.com";
             String title = "비밀번호 찾기 인증 번호 입니다."; // 제목
             String content =
             
             System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
             
             System.getProperty("line.separator")+
                     
             "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
             
             +System.getProperty("line.separator")+
             
             System.getProperty("line.separator")+
     
             " 인증번호는 " +dice+ " 입니다. "
             
             +System.getProperty("line.separator")+
             
             System.getProperty("line.separator")+
             
             "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
             
             
             try {
                 MimeMessage message = mailSender.createMimeMessage();
                 MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                         true, "UTF-8");
  
                 messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
                 messageHelper.setTo(e_mail); // 받는사람 이메일
                 messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
                 messageHelper.setText(content); // 메일 내용
                 
                 mailSender.send(message);
             } catch (Exception e) {
                 System.out.println(e);
             }
             
             ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
             mv.setViewName("/member/pass_injeung");     //뷰의이름
             mv.addObject("dice", dice);
             
             System.out.println("mv : "+mv);
  
             response_email.setContentType("text/html; charset=UTF-8");
             PrintWriter out_email = response_email.getWriter();
             out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
             out_email.flush();
             this.e_mail=e_mail+".com";
             
             return mv;
             
         }
    	 @RequestMapping(value = "/member/pass_injeung.do{dice}", method = RequestMethod.POST)
    	    public ModelAndView pass_injeung(String email_injeung, @PathVariable String dice, HttpServletResponse response_equals) throws IOException {
    	 
    	        
    	        System.out.println("마지막 : email_injeung : "+email_injeung);
    	        
    	        System.out.println("마지막 : dice : "+dice);
    	        
    	        
    	        //페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
    	         
    	        ModelAndView mv = new ModelAndView();
    	        
    	        mv.setViewName("/member/passChange");
    	        
    	        mv.addObject("e_mail",email_injeung);
    	        
    	        if (email_injeung.equals(dice)) {
    	            
    	            //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
    	            
    	            
    	            System.out.println(e_mail);
    	            mv.setViewName("member/passChange");
    	            
    	            mv.addObject("e_mail",e_mail);
    	            
    	            //만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
    	            //한번더 입력할 필요가 없게 한다.
    	            
    	            response_equals.setContentType("text/html; charset=UTF-8");
    	            PrintWriter out_equals = response_equals.getWriter();
    	            out_equals.println("<script>alert('인증번호가 일치하였습니다. 비밀번호 변경창으로 이동합니다.');</script>");
    	            out_equals.flush();
    	    
    	            return mv;
    	            
    	            
    	        }else if (email_injeung != dice) {
    	            
    	            
    	            ModelAndView mv2 = new ModelAndView(); 
    	            
    	            mv2.setViewName("member/email_injeung");
    	            
    	            response_equals.setContentType("text/html; charset=UTF-8");
    	            PrintWriter out_equals = response_equals.getWriter();
    	            out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
    	            out_equals.flush();
    	            
    	    
    	            return mv2;
    	            
    	        }    
    	    
    	        return mv;
    	        
    	    }
    	 @RequestMapping(value="/member/pass_Change{e_mail}",method = RequestMethod.POST)
    	 public ModelAndView pass_Change(MemberDTO dto,@PathVariable String e_mail,String user_pass) throws Exception
    	 {
    		 dto.setUser_pass(user_pass);
     		dto.setE_mail(this.e_mail);
     		MemberService.passChange(dto);
     		ModelAndView mv = new ModelAndView();
             
             mv.setViewName("/member/login_form");
             
             return mv;
    	 }
    	//로그인 맵핑
	    @RequestMapping(value="/member/login_form", method = RequestMethod.GET)
	    public String login() {
	        return "member/login_form";
	    }
	    //회원정보 맵핑
	    @RequestMapping(value="/member/login", method = RequestMethod.GET)
	    public String member() {
	        return "member/login";
	    }
	    //로그아웃 맵핑
	    @RequestMapping(value="/member/logout", method = RequestMethod.GET)
	    public ModelAndView logout(HttpServletRequest req) {
	    	HttpSession session = req.getSession();
	    	session.removeAttribute("e_mail");
	    	session.removeAttribute("nick");
	    	session.removeAttribute("user_pass");
	    	ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
            mv.setViewName("/member/login_form");     //뷰의이름
            return mv;
	    }
	    //로그인 포스트
    	@RequestMapping(value = "/member/login_form", method = RequestMethod.POST)
    	public ModelAndView login(MemberDTO dto, HttpServletRequest req,String e_mail,String user_pass, HttpServletResponse response)throws Exception
    	{
    		HttpSession session = req.getSession();
    		dto.setE_mail(e_mail);
    		dto.setUser_pass(user_pass);
    		boolean flag=MemberService.loginCheck(dto, session);
    		 response.setContentType("text/html; charset=UTF-8");
             PrintWriter out = response.getWriter();
             ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
    		if(flag)
    		{
    			mv.setViewName("/member/login");     //뷰의이름
    		}else
    		{
    			out.println("<script>alert('로그인에 실패하였습니다 로그인창으로 돌아갑니다');</script>");
    			out.println("<script>history.back();</script>");
    			out.flush();
    		}
    		return mv;
    	}
    	//회원가입
    	@RequestMapping("/member/join_check.do{e_mail}")
        public ModelAndView join(MemberDTO dto,@PathVariable String e_mail,String user_pass,String user_nick) throws Exception 
        {
    		
    		dto.setUser_pass(user_pass);
    		dto.setE_mail(e_mail);
    		dto.setNickName(user_nick);
    		MemberService.join(dto);
    		ModelAndView mv = new ModelAndView();
            
            mv.setViewName("/member/login_form");
            
            return mv;
        }
    	
    
    // mailSending 코드
        @RequestMapping( value = "/member/auth.do{e_mail}" , method=RequestMethod.POST )
        public ModelAndView mailSending(HttpServletRequest request,@PathVariable String e_mail, HttpServletResponse response_email) throws IOException {
 
            Random r = new Random();
            int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
            String setfrom = "hanryang0307@gmail.com";
            String title = "회원가입 인증 이메일 입니다."; // 제목
            String content =
            
            System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
            
            System.getProperty("line.separator")+
                    
            "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
            
            +System.getProperty("line.separator")+
            
            System.getProperty("line.separator")+
    
            " 인증번호는 " +dice+ " 입니다. "
            
            +System.getProperty("line.separator")+
            
            System.getProperty("line.separator")+
            
            "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
            
            
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                        true, "UTF-8");
 
                messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
                System.out.println(setfrom);
                messageHelper.setTo(e_mail); // 받는사람 이메일
                System.out.println(e_mail);
                messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
                messageHelper.setText(content); // 메일 내용
                
                
                mailSender.send(message);
            } catch (Exception e) {
                System.out.println("실행 실패");
                e.printStackTrace();
            }
            
            ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
            mv.setViewName("/member/email_injeung");     //뷰의이름
            mv.addObject("dice", dice);
            
            System.out.println("mv : "+mv);
 
            response_email.setContentType("text/html; charset=UTF-8");
            PrintWriter out_email = response_email.getWriter();
            out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
            out_email.flush();
            this.e_mail=e_mail;
            
            return mv;
            
        }
    
    //이메일 인증 페이지 맵핑 메소드
    @RequestMapping("/member/email.do")
    public String email() throws IOException {
        return "member/email";
    }
    
    
    //이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
    //내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
    //틀리면 다시 원래 페이지로 돌아오는 메소드
    @RequestMapping(value = "/member/join_injeung.do{dice}", method = RequestMethod.POST)
    public ModelAndView join_injeung(String email_injeung, @PathVariable String dice, HttpServletResponse response_equals) throws IOException {
 
        
        System.out.println("마지막 : email_injeung : "+email_injeung);
        
        System.out.println("마지막 : dice : "+dice);
        
        
        //페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
         
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("/member/join.do");
        
        mv.addObject("e_mail",email_injeung);
        
        if (email_injeung.equals(dice)) {
            
            //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
            
            
            
            mv.setViewName("member/join");
            
            mv.addObject("e_mail",e_mail);
            
            //만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
            //한번더 입력할 필요가 없게 한다.
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하였습니다. 회원가입창으로 이동합니다.');</script>");
            out_equals.flush();
    
            return mv;
            
            
        }else if (email_injeung != dice) {
            
            
            ModelAndView mv2 = new ModelAndView(); 
            
            mv2.setViewName("member/email_injeung");
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
            out_equals.flush();
            
    
            return mv2;
            
        }    
    
        return mv;
        
    }
  //이메일 중복확인을 하는 메소드
    @RequestMapping("/member/email_check.do")
    public ModelAndView email_check(String e_mail, HttpServletResponse response_equals) throws Exception    {
        System.out.println(e_mail);
        System.out.println(MemberService);
        MemberService.email_check(e_mail);
        
    if(MemberService.email_check(e_mail)) {
        
        response_equals.setContentType("text/html; charset=UTF-8");
        PrintWriter out_equals = response_equals.getWriter();
        out_equals.println("<script>alert('사용하실 수 있는 이메일 입니다.');</script>");
        out_equals.flush();
        
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("/member/email");
        
        mv.addObject("e_mail",e_mail);
        
        return mv;
        
        
    } else {
        response_equals.setContentType("text/html; charset=UTF-8");
        PrintWriter out_equals = response_equals.getWriter();
        out_equals.println("<script>alert('사용할 수 없는 이메일 입니다. 다른 이메일을 입력해주세요.'); history.go(-1);</script>");
        out_equals.flush();
        
    }
    
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/member/email");
    
 
        return mv;
    }
    
  //회원아이디로 해당 회원의 정보를 검색하는 메소드

    @RequestMapping("/member/member_profile.do")
    public ModelAndView member_profile(HttpSession session, MemberDTO dto) throws Exception{
        
        //세션에 저장되어 있는 회원의 아이디를 변수에 저장함
        String e_mail =(String)session.getAttribute("e_mail");
        System.out.println(e_mail);
        //데이터베이스에서 검색한 값들을 DTO타입에 LIST에 저장한다.
        java.util.List<MemberDTO> list = MemberService.member_profile(e_mail);
        System.out.println(list);
        Map<String,Object> map = new HashMap<>();
        
        //map에 리스트를 저장해서 출력할 view로 이동시킨다.
             
        ModelAndView mv = new ModelAndView();
        
        //if문에서 list null처리를 할때에는 isEmpty()를 사용해서 null체크후 처리를 해주어야 한다.
        //list안에 값이 들어있을때 실행되는 구문
        if(!list.isEmpty()) {
            
            map.put("list", list);
            
            mv.addObject("map",map);
            
            mv.setViewName("member/member_profile");
            
        }
        
        return mv;
    }
  //회원의 아이디로 회원 프로필을 출력하는 메소드 (네이버)
    @RequestMapping(value = "naver_member_profile.do")
    public ModelAndView naver_member_profile(HttpSession session, MemberDTO dto) throws Exception{
        
        
        //세션에 저장되어 있는 회원의 아이디를 변수에 저장함
        String user_id =(String)session.getAttribute("navername");
        
        //데이터베이스에서 검색한 값들을 DTO타입에 LIST에 저장한다.
        java.util.List<MemberDTO> list = MemberService.member_profile(user_id);
        
        Map<String,Object> map = new HashMap<>();
        
        //map에 리스트를 저장해서 출력할 view로 이동시킨다.
        
        //list가 null이면 회원정보가 없는것이므로 경고창을 출력하도록 함
        
        ModelAndView mv = new ModelAndView();
        
        //if문에서 list null처리를 할때에는 isEmpty()를 사용해서 null체크후 처리를 해주어야 한다.
        //list안에 값이 들어있을때 실행되는 구문
            
            
            map.put("list", list);
            
            mv.addObject("map",map);
            
            mv.setViewName("member/member_profile");
            

        return mv;
    }
    
    
        //회원의 아이디로 회원 프로필을 출력하는 메소드 (카카오톡)
        @RequestMapping(value = "kakao_member_profile.do")
        public ModelAndView kakao_member_profile(HttpSession session, MemberDTO dto) throws Exception{
                
                
            //세션에 저장되어 있는 회원의 아이디를 변수에 저장함
            String user_id =(String)session.getAttribute("kakaonickname");
                
            //데이터베이스에서 검색한 값들을 DTO타입에 LIST에 저장한다.
            java.util.List<MemberDTO> list = MemberService.member_profile(user_id);
                
            Map<String,Object> map = new HashMap<>();
                
            //map에 리스트를 저장해서 출력할 view로 이동시킨다.
                
            //list가 null이면 회원정보가 없는것이므로 경고창을 출력하도록 함
                
            ModelAndView mv = new ModelAndView();
                
                //if문에서 list null처리를 할때에는 isEmpty()를 사용해서 null체크후 처리를 해주어야 한다.
                //list안에 값이 들어있을때 실행되는 구문
                    
                    map.put("list", list);
                    
                    mv.addObject("map",map);
                    
                    mv.setViewName("member/member_profile");
                    

                return mv;
            }

        @RequestMapping("/member/admin")
        public ModelAndView admin(HttpSession session, MemberDTO dto) throws Exception{
            //데이터베이스에서 검색한 값들을 DTO타입에 LIST에 저장한다.
            java.util.List<MemberDTO> list = MemberService.member();
            System.out.println(list);
            Map<String,Object> map = new HashMap<>();
            
            //map에 리스트를 저장해서 출력할 view로 이동시킨다.
                 
            ModelAndView mv = new ModelAndView();
            
            //if문에서 list null처리를 할때에는 isEmpty()를 사용해서 null체크후 처리를 해주어야 한다.
            //list안에 값이 들어있을때 실행되는 구문
            if(!list.isEmpty()) {
                
                map.put("list", list);
                
                mv.addObject("map",map);
                
                mv.setViewName("member/admin");
                
            }
            
            return mv;
        }
        @RequestMapping(value="/member/delete", method = RequestMethod.POST)
        public ModelAndView remove(String e_mail) throws Exception
        {
        	System.out.println(e_mail);
        	MemberService.remove(e_mail);
        	java.util.List<MemberDTO> list = MemberService.member();
            System.out.println(list);
            Map<String,Object> map = new HashMap<>();
        	 ModelAndView mv = new ModelAndView();
        	 if(!list.isEmpty()) {
                 
                 map.put("list", list);
                 
                 mv.addObject("map",map);
                 
                 mv.setViewName("member/admin");
                 
             }
        	return mv;
        }
        @RequestMapping(value="/member/update", method = RequestMethod.POST)
        public ModelAndView update(String nickName, String e_mail,MemberDTO dto)
        {
        	dto.setE_mail(e_mail);
        	dto.setNickName(nickName);
        	System.out.println(nickName);
        	MemberService.update(dto);
        	 ModelAndView mv = new ModelAndView();
        	 mv.setViewName("/member/member_profile");
 
        	return mv;
        }
     // 닉네임 중복 체크 컨트롤러
    	@RequestMapping(value = "/member/nickCheck", method = RequestMethod.GET)
    	@ResponseBody
    	public int nickCheck(@RequestParam("userNick") String user_nick) throws Exception {

    		return MemberService.nickName_check(user_nick);
    	}
}
