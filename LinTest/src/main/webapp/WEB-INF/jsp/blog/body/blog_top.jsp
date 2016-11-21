<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
	<div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item " href="${ctx}/index">主页</a>
			<%
				if(request.getParameter("hotwechat") != null) {
			%>
			<a class="blog-nav-item active" href="${ctx}/blog">微信热门文章</a>
			<%
				} else {
			%>
			<a class="blog-nav-item " href="${ctx}/blog">微信热门文章</a>
			<%
				}
			%>
			
			<%
				if(request.getParameter("brainteasers") != null) {
			%>
			<a class="blog-nav-item active" href="${ctx}/blog/brain_teasers">脑筋急转弯</a>
			<%
				} else {
			%>
			<a class="blog-nav-item " href="${ctx}/blog/brain_teasers">脑筋急转弯</a>
			<%
				}
			%>
          
          <a class="blog-nav-item" href="#">New hires</a>
          <a class="blog-nav-item" href="#">About</a>
        </nav>
      </div>
    </div>