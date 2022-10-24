<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr
						style="background: url('img/table_mid.gif') repeat-x; text-align: center;">
						<td width="5"><img src="img/table_left.gif" width="5"
							height="30" /></td>
						<td>글쓰기</td>
						<td width="5"><img src="img/table_right.gif" width="5"
							height="30" /></td>
					</tr>
				</table>
				<form action="insertDoc" method="post">
					<table>
						<tr>
							<td>&nbsp;</td>
							<td align="center">제목</td>
							<td><input name="docTitle" size="50" maxlength="100"></td>
							<td>&nbsp;</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">내용</td>
							<td><textarea name="docContent" cols="50" rows="13"></textarea></td>
							<td>&nbsp;</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr height="1" bgcolor="#82B5DF">
							<td colspan="4"></td>
						</tr>
						<tr align="center">
							<td>&nbsp;</td>
							<td colspan="2"><input type="submit" value="등록"> <input
								type=button value="취소">
							<td>&nbsp;</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
 
</html>
