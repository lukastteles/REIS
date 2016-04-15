<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>

<body bgcolor="grey">


	<table border="1"align="center">
    	<tr>
        	<td height="30" colspan="2">
          		<header>
					<tiles:insertAttribute name="header" />
				</header>
       		</td>
		</tr>
		<tr>
        	<td width="650">
        		<section>
					<tiles:insertAttribute name="body" />
				</section>
        	</td>
		</tr>
		<tr>
        	<td height="30" colspan="2">
        		<footer>
					<tiles:insertAttribute name="footer" />
				</footer>
        	</td>
        </tr>
	</table>

</body>
</html>