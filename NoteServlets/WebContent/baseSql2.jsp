<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<html>
<head>

<title>d</title>
</head>
<body>
	<sql:setDataSource var="mydatesource"
		url="jdbc:mysql://127.0.0.1:3306/test" driver="com.mysql.jdbc.Driver"
		user="root" password="rite58731688" />
	<table>
		<c:out value="${mydatesource }"></c:out>
	</table>
</body>
</html>
