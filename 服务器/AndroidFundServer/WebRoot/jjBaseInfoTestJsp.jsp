<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>基金基本信息Json数据请求测试页面</title>
	</head>
	<body>
		<h2>
		基金基本信息Json数据请求测试页面
		</h2>
		<html:form action="jjBaseInfo" method="post">
			<table border="0">
				<tr>
					<td>
						代码:
					</td>
					<td>
						<html:text property="dms" />
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<html:submit />
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>

