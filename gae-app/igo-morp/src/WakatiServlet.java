import java.io.IOException;
import javax.servlet.http.*;

public class WakatiServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String text = req.getParameter("text");
        if(text==null)
            text = "";
        
        boolean first = true;
        resp.setContentType("text/plain; charset=UTF-8");
        for(String s : Igo.wakati(text)) {
            if(!first)
                resp.getWriter().print(" ");
            first = false;
            resp.getWriter().print(s);
        }
        resp.getWriter().println("");
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
