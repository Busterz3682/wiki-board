<%@page import="com.side.wiki.document.domain.DocumentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						style="text-align: center;">
						<td width="5"></td>
						<td>문서조회</td>
						<td width="5"></td>
					</tr>
				</table>
				<form action="/wiki/updateDoc" method="post">
					<table>
						<tr>
							<td>&nbsp;<input type="hidden" value="${doc.docTitle }" name="docTitle"></td>
							<td align="center">제목</td>
							<td>${doc.docTitle }</td>
							<td>&nbsp;</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td align="center">내용</td>
							<td><textarea name="docContent" cols="50" rows="13" >${doc.docContent }</textarea></td>
							<td>&nbsp;</td>
						</tr>
						<tr height="1" bgcolor="#dddddd">
							<td colspan="4"></td>
						</tr>
						<tr height="1" bgcolor="#82B5DF">
							<td colspan="4"></td>
						</tr>
						<td>등록일시 - ${doc.docDate }</td>
						<tr align="right"></tr>
						<tr align="center">
							<td>&nbsp;</td>
							<td colspan="2"><input type="submit" value="수정">
							<td colspan="2"><input type="button" value="삭제">
							<td>&nbsp;</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
 
</html>
