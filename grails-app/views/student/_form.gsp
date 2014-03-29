<%@ page import="com.test.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="student.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${studentInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'rollNo', 'error')} required">
	<label for="rollNo">
		<g:message code="student.rollNo.label" default="Roll No" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rollNo" required="" value="${studentInstance?.rollNo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="student.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" required="" value="${studentInstance?.address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="student.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${studentInstance?.email}"/>
</div>

