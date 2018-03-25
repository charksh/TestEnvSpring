<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Sample</title>
	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<script type="text/javascript">	
		
		$(window).ready(function() {
			//alert($("#name").attr("value"));
		});
					
		$(document).ready(function() {
			
			$("#testSubmit").on("click", function() {
				var params = $("#frmTest").serializeArray();
				console.log(params);
				console.log(JSON.stringify(params));
				
				$.ajax({
			        url  	   : '/sample/sampleList.do',
			        type	   : 'POST',
			        contentType : 'application/json',
			        dataType   : 'json',
			        async	   : true,
			        // 서버에서 @RequestBody 형태의 List<Map> 형태로 받기 위해서는 화면에서 json 형태의 string 으로 넘겨줘야 함.
			        data       : JSON.stringify(params),	// JSON -> String, JSON.Parse 는 string -> json 으로 변환
			        //beforeSend : function(xhr) { },
			        // 서버에서 @ResponseBody 형태로 넘기면 그냥 받으면 됨
			        success: function(result, status, xhr) {	// xhr : XMLHttpRequest
			        	console.log(status);
			        	console.log(xhr);
			        	console.log(result);
			        	console.log(result.length);
			        	console.log(result[0]);
			        	console.log(result[0].name);
			            console.log(JSON.stringify(result));
			            
			            $("#resultData").val(result[0].name);
			        },
			        error: function(xhr, status, error) {
			        	console.log(error);
			        }					
				});	
			});
		});
	</script>
</head>
<body>
<h1>
	Hello Mapper Test world !!  
</h1>
	<form:form id="frmTest" name="frmTest" method="post">
		<input id="name" size="100" name="name" value="류성원"><br>
		<input id="phone" size="100" name="phone" value="1234"><br>
	</form:form>
	
	<input id="resultData" size="100" value=""><br>
	<button id="testSubmit" size="100">버튼</button>
	
			<!-- 1.이런식으로 할려면 자바단에서 model 에 넣어야하고 Return Type (View Name) 을 String 으로 넘기면 됨 -->
	        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list}" var="row">
                        ${row.name}&nbsp;
                        ${row.phone}<br>
                </c:forEach>
            </c:when>
            <c:otherwise>
                    	조회된 결과가 없습니다.
            </c:otherwise>
        </c:choose>
        
</body>
</html>


