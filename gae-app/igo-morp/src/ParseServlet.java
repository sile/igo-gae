import java.io.IOException;
import javax.servlet.http.*;
import net.reduls.igo.Morpheme;

public class ParseServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String text = req.getParameter("text");
        if(text==null)
            text = "";
        
        resp.setContentType("text/plain; charset=UTF-8");
        for(Morpheme m : Igo.parse(text))
            resp.getWriter().println(m.surface+"\t"+m.feature);
        resp.getWriter().println("EOS");
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
