
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.io.*,java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");

	if(request.getParameter("id") != null){
		String id = request.getParameter("id");
		session.setAttribute("id",id);
	}
	String sessionId = (String)session.getAttribute("id");
	
	if(request.getParameter("password") != null){
		String password = request.getParameter("password");
		session.setAttribute("password",password);
	}
	String sessionPWD = (String)session.getAttribute("password");
	
	PrintWriter writer = response.getWriter();
	String filePath = application.getRealPath("./" + sessionId
			+ ".txt");
	String filePath2 = application.getRealPath("./movie1.txt");
	String filePath3 = application.getRealPath("./movie2.txt");
	String balance;
	String movie1;
	String movie2;
	
	FileReader mv1;
	mv1 = new FileReader(filePath2);
	BufferedReader br3 = new BufferedReader(mv1);
	String mv1_seat = br3.readLine();
	session.setAttribute("mv1_seat",mv1_seat);
	
	FileReader mv2;
	mv2 = new FileReader(filePath3);
	BufferedReader br2 = new BufferedReader(mv2);
	String mv2_seat = br2.readLine();
	session.setAttribute("mv2_seat",mv2_seat);
	
	File file = new File(filePath);
    if (!file.exists())
    {
    	writer.println("<script type='text/javascript'>");
        writer.println("alert('�ش� ���̵� �������� �ʽ��ϴ�.');");
        writer.println("history.back();");
        writer.println("</script>");
        writer.flush();
        return;
    }
    else{
    	FileReader fr;
    	fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String source= br.readLine();
		
		balance =br.readLine();
		movie1 = br.readLine();
		movie2 = br.readLine();
		session.setAttribute("balance",balance);
		session.setAttribute("movie1",movie1);
		session.setAttribute("movie2",movie2);
		if(!source.equals(sessionPWD))
		{
			writer.println("<script type='text/javascript'>");
	        writer.println("alert('��й�ȣ�� Ʋ�Ƚ��ϴ�.');");
	        writer.println("history.back();");
	        writer.println("</script>");
	        writer.flush();
	        return;
		}
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>ȸ�� ����</title>
</head>
<body>
	<form action="logout.jsp" method="POST">
		<%=sessionId %>
		���� �α��� <input type="submit" value="�α׾ƿ�" />
	</form>
	<form action="addPoint.jsp" method="POST">
		<br><%=sessionId %>
		���� ���� ����Ʈ�� <%=balance %>�� �Դϴ�. <br>
		����Ʈ :<input type="text" name="Point" required  pattern="\d{0,100000000}"><input type="submit" value="����Ʈ����" />
	</form>
	
	<br>
	<br>
	<form action="reserve.jsp" method="POST">
	<table border="1px solid">
		<tr>
			<td colspan="5">A ��ȭ��</td>
		</tr>

		<tr>
			<td>�󿵰�</td>
			<td>��ȭ</td>
			<td>�󿵽ð�</td>
			<td>�ܿ� �¼���</td>
			<td>����</td>
		</tr>

		<tr>
			<td>1��</td>
			<td>�ŵ�ƽ�</td>
			<td>13:00~15:00</td>
			<td><%=mv1_seat %></td>
			<td><input type="number" name="mv1_cnt" min="0"max="50" value="0"></td>
		</tr>

		<tr>
			<td>2��</td>
			<td>�����2</td>
			<td>17:00~19:30</td>
			<td><%=mv2_seat %></td>
			<td><input type="number" name="mv2_cnt" min="0"max="50" value="0"></td>
		</tr>
	</table>
		<input type="submit" value="����" />
	</form>

	<br>
	<br>
	<form action="confirm.jsp" method="POST">
		<input type="submit" value="����Ȯ��" />
	</form>
</body>
</html>
