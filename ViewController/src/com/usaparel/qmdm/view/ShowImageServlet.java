package com.usaparel.qmdm.view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ShowImageServlet", urlPatterns = { "/showimageservlet" })
public class ShowImageServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "image/png; charset=utf-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_code = request.getParameter("emp_code").toString();
        
        response.setContentType(CONTENT_TYPE);
        OutputStream out = response.getOutputStream();
        
        
        File file = new File("//home//oracle//Desktop//emp_pics//" + emp_code + ".jpg");
       
        if (file.exists()) {
            FileInputStream input = null;
            try{
                input = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(input);
                byte[] bytes = new byte[10240];
                while(bis.read(bytes, 0, 10240) != -1){
                    out.write(bytes);  
                }
                out.flush();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                if (out != null){
                    out.close();
                }
                if (input != null) {
                    input.close();
                }
                
            }
        }else{
            File noimage = new File("//home//oracle//Desktop//emp_pics//" + "noimage" + ".jpg");
            FileInputStream input = null;
            try{
                input = new FileInputStream(noimage);
                BufferedInputStream bis = new BufferedInputStream(input);
                byte[] bytes = new byte[10240];
                while(bis.read(bytes, 0, 10240) != -1){
                    out.write(bytes);  
                }
                out.flush();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                if (out != null){
                    out.close();
                }
                if (input != null) {
                    input.close();
                }
                
            }
        }
    }
}
