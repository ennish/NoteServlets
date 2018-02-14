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
	<sql:query var="myquery" dataSource="${mydatesource}">
 		select id,countrycode,countryname from country
	</sql:query>

	<!-- raed query result -->
	<table>
		<tr>
			<th>id</th>
			<th>code</th>
			<th>name</th>
		</tr>
		<c:forEach items="${myquery.rows}" var="row">
			<tr>
				<td>${(row.id)}</td>
				<td>${(row.countrycode)}</td>
				<td>${(row.countryname)}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
