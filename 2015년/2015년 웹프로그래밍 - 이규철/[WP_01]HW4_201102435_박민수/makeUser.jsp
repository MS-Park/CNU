<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.io.*,java.util.*"%>
<%
	String result = null;
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	PrintWriter writer = null;
	String filePath = application.getRealPath("./" + id
				+ ".txt");
	
	File file = new File(filePath);
    if (file.exists())
    	result = "FAIL";
    else{
	writer = new PrintWriter(filePath);
	writer.println(password);
	writer.println(0);
	writer.println(0);
	writer.println(0);
	result = "SUCCESS";
	writer.close();
    }
%>

<script type="text/javascript">
	var result = "<%=result%>";
	if(result == "SUCCESS")
	{
		alert("���ԿϷ�");
		location.href ="main.html";
	}
	else if(result == "FAIL"){
		alert("���̵� �ߺ��˴ϴ�.");
		history.back();
	}

</script>
