<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<table>
			<tr>
				<th>departamento</th>
				<th>nombre</th>
				<th>localidad</th>
			</tr>
			<xsl:apply-templates select="Empleado-array"/>
		</table>
	</xsl:template>

	<xsl:template match="Empleado-array">
		<xsl:apply-templates select="Empleado"/>
	</xsl:template>
	<xsl:template match="Empleado">
		<tr>
			<td>
				<xsl:value-of select="departamento"></xsl:value-of>
			</td>
			<td>
				<xsl:value-of select="nombre"></xsl:value-of>
			</td>
			<td>
				<xsl:value-of select="localidad"></xsl:value-of>
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>