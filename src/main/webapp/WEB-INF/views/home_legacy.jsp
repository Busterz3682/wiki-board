<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="author" content="colorlib.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  </head>
  <body>
    <div class="s003">
      <form action="/wiki/getDoc" method="get">
        <div class="inner-form">
          <div class="input-field first-wrap">
            <div class="input-select">
              
            </div>
          </div>
          <div class="input-field second-wrap">
            <input id="search" type="text" placeholder="Enter Keywords?" name="docTitle" />
          	<ul id="searchResult">
          		
          	</ul>
          </div>
          <div class="input-field third-wrap">
            <button class="btn-search" type="submit">
              <svg class="svg-inline--fa fa-search fa-w-16" aria-hidden="true" data-prefix="fas" data-icon="search" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                <path fill="currentColor" d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z"></path>
              </svg>
            </button>
          </div>
        </div>
      </form>
      <button onclick="location.href='http://localhost:8181/wiki/getRandomDoc'">랜덤문서보기</button>
      <button onclick="location.href='http://localhost:8181/wiki/insertDoc'">문서등록하기</button>
      <button onclick="location.href='http://localhost:8181/wiki/getDocList'">전체문서보기</button>
    </div>
    <script src="js/extention/choices.js"></script>
    <script>
      $('#search').keyup(function(){
    	  let s = $('#search').val()
    	  console.log(s)
    	  $.ajax({
    		  type : 'get',
    		  url : '/wiki/searchDoc',
    		  data : {"search" : s},
    		  success : function(result){
    			  console.log(result);
    			  $('#searchResult').empty();
    			  for(let i = 0; i < (result.length < 10 ? result.length : 10); i++) {
    				  $('#searchResult').append("<li><a href='wiki/getDoc?docTitle="+result[i]+"'>"+result[i]+"</a></li>")
    			  }
    		  },
    		  error : function() {
    			  console.log('no result');
    		  }
    	  });
      });
    </script>
  </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>

