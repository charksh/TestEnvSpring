<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false"%>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

<script type="text/javascript">
window.onload = function() {
	alert('ksh1');
}
	
$(document).ready(fucntion() {
	alert('ksh2');
});
</script>
