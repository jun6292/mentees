<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/showMentoList.css">
</head>
<body>
<section class="info">
  <c:import url="header.jsp"></c:import>  
  
  <center>
    <h1 class="pageTitle">멘토 모집</h1>
  </center>
  <br><br>
  <hr width="70%" size="4" color="gray" class="line"><br>
  <h3 class="writer">작성자: ${mentor.name }</h3>
  <h3 class="mentoTitle"> 제목 : [${mentor.subject}]${mentor.title }</h3>
  
  <h3 class="content">
  </h3>
  <textarea cols="142" rows="15" class="contentInfo" readonly>${mentor.content }</textarea>

  <form action="deleteRecruit" method="post">
    <input type="hidden" name="id" value="${mentor.id}"/>
    <input type="submit" value="글 삭제" class="delete">
  </form>

  <form action="checkMentor" method="post">
    <input type="hidden" name="name" value="${mentor.name} "/>
      <input type="hidden" name="title" value="${mentor.title} "/>
      <input type="hidden" name="content" value="${mentor.content} "/>
     <input type="hidden" name="id" value="${mentor.id} "/>
    <input type="submit" value="글 수정" class="modify">
  </form>
</section>
   
   
<section class="reply">
    <form action="insertMentorComments" method="post">
      댓글 작성 <input type="text" name="content" class="replyArea" placeholder="댓글을 입력하세요.">
      <input type="hidden" name="mentorId" value="${mentor.id}">   
      <input type="submit" value="댓글 등록" class="submitReply">
    </form><br>
   
     <table>
      <tr>
        <td width=70>번호</td>
        <td width=500>댓글</td>
        <td width=200>작성자</td>
        <td width=150>작성일자</td>
        <td width=70></td>
      </tr>
         <c:forEach items="${comments}" var="list">
          <tr>
            <td width=70>${list.id }</td>
            <td width=500>${list.content }</td>
            <td width=200>${list.name }</td>
            <td width=150>${list.regDate }</td>
            <td width=70>
            <form action="deleteMentorComments" method="post" >
            <input type="hidden" name="id" value="${list.id}"/>
            <input type="hidden" name="commentName" value="${list.name}"/>
            <input type="hidden" name="mentorId" value="${list.mentorId}"/>
            <input type="submit" value="댓글 삭제">
            </form>
            </td>
          </tr>
          <br>
        </c:forEach>
   </table>
</section>
</body>
</html>