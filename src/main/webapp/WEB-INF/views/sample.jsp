<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<script type="text/javascript">				
		$(document).ready(function() {
			//alert('ksh1');
		});
		
		$(window).ready(function() {
			//alert('ksh2');
		});
		
		window.onload = function() {
			//alert('ksh3');
		};
	</script>
</head>
<body>
<h1>
	Hello SAMPLE world !!  
</h1>

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


