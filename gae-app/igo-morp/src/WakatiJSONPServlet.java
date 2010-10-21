import java.io.IOException;
import javax.servlet.http.*;

public class WakatiJSONPServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String text = req.getParameter("text");
        String callback = req.getParameter("callback");
        if(text==null)
            text = "";

        if(callback==null)
            callback="callback";

        boolean first=true;
        resp.setContentType("Content-type: text/javascript; charset=UTF-8");
        resp.getWriter().print(callback+"([");
        for(String w : Igo.wakati(text)) {
            if(first==false)
                resp.getWriter().print(",");
            first=false;
            resp.getWriter().print("\""+encode(w)+"\"");
        }
        resp.getWriter().println("]);");
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }

    private String encode(String src) {
        StringBuilder sb = new StringBuilder(src.length());
        for(int i=0; i < src.length(); i++) {
            char c = src.charAt(i);
            if(c < 0x80)
                sb.append(c);
            else 
                appendHex(sb, c);
        }
        return sb.toString();
    }

    private void appendHex(StringBuilder sb, char c) {
        final String h = "0123456789ABCDEF";

        sb.append("\\u");
        for(int i=3; i >= 0; i--)
            sb.append(h.charAt((c>>(4*i))&0xF));
    }
}
