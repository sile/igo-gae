<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>

<html>
  <head>
    <Meta Http-equiv="content-type" Content="text/html; charset=UTF-8">
    <title>Igo: 形態素解析</title>
  </head>

  <body>
    <a href="http://sourceforge.jp/projects/igo/">Igo</a>を用いた形態素解析を行います。<br />
    テキストを入力して「形態素解析」ボタンを押してください。<br />
    <form method="POST" action="/parse">
      <textarea name="text" cols="50" rows="10"></textarea>
      <br />
      <input type="submit" value="形態素解析" />
    </form>
  </body>
</html>
