<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="my"%>
<nav class="text-center">
	<ul class="pagination">

		<c:if test="${pager.pageNum==1 }">
			<li class="disabled"><a href="#">上页</a></li>
			<li class="active"><a href="#">1</a></li>
		</c:if>
		
		<c:if test="${pager.pageNum!=1 }">
			<li><a href="?pageNum=${pager.pageNum-1}&keyword=<my:encode value="${keyword}"/>">上页</a></li>
			<li><a href="?pageNum=1&keyword=<my:encode value="${keyword}"/>">1</a></li>
		</c:if>
		
		<!-- 总页数在10页以内 -->
		<c:if test="${pager.pageCount<=10 }">
		
			<c:if test="${pager.pageCount>1 }">
			
				<c:forEach var="i" begin="2" end="${pager.pageCount}">
					<c:if test="${pager.pageNum==i }">
						<li class="active"><a href="#">${i}</a></li>
					</c:if>
					<c:if test="${pager.pageNum!=i }">
						<li><a href="?pageNum=${i}&keyword=<my:encode value="${keyword}"/>">${i}</a></li>
					</c:if>
				</c:forEach>
			</c:if>
			
			<c:if test="${pager.pageNum<pager.pageCount}">
				<li><a href="?pageNum=${pager.pageNum+1}&keyword=<my:encode value="${keyword}"/>">下页</a></li>
			</c:if>
			
			<c:if test="${pager.pageNum>=pager.pageCount}">
				<li class="disabled"><a href="#">下页</a></li>
			</c:if>
			
		</c:if>
		
		
		<!-- 总页数大于10页以 -->
		<c:if test="${pager.pageCount>10 }">
		
			<!-- 两侧均省略 -->
			<c:if test="${pager.pageNum>5 && pager.pageNum<pager.pageCount-4 }">
				<li><a href="#">...</a></li>
			
				<c:forEach var="i" begin="${pager.pageNum-2 }" end="${pager.pageNum+2 }">
					<c:if test="${pager.pageNum==i }">
						<li class="active"><a href="#">${i}</a></li>
					</c:if>
					<c:if test="${pager.pageNum!=i }">
						<li><a href="?pageNum=${i}&keyword=<my:encode value="${keyword}"/>">${i}</a></li>
					</c:if>
				</c:forEach>
				
				<li><a href="#">...</a></li>								
			</c:if>
			
			<!-- 省略右侧 -->
			<c:if test="${pager.pageNum<=5}">
				<c:forEach var="i" begin="2" end="7">
					<c:if test="${pager.pageNum==i }">
						<li class="active"><a href="#">${i}</a></li>
					</c:if>
					<c:if test="${pager.pageNum!=i }">
						<li><a href="?pageNum=${i}&keyword=<my:encode value="${keyword}"/>">${i}</a></li>
					</c:if>
				</c:forEach>
				
				<li><a href="#">...</a></li>								
			</c:if>
			
			<!-- 省略左侧 -->
			<c:if test="${pager.pageNum>=pager.pageCount-4}">
			
				<li><a href="#">...</a></li>								
			
				<c:forEach var="i" begin="${pager.pageCount-7 }" end="${pager.pageCount-1 }">
					<c:if test="${pager.pageNum==i }">
						<li class="active"><a href="#">${i}</a></li>
					</c:if>
					<c:if test="${pager.pageNum!=i }">
						<li><a href="?pageNum=${i}&keyword=<my:encode value="${keyword}"/>">${i}</a></li>
					</c:if>
				</c:forEach>
				
			</c:if>
			
			<c:if test="${pager.pageNum<pager.pageCount}">
				<li><a href="?pageNum=${pager.pageCount }&keyword=<my:encode value="${keyword}"/>">${pager.pageCount }</a></li>
				<li><a href="?pageNum=${pager.pageNum+1}&keyword=<my:encode value="${keyword}"/>">下页</a></li>
			</c:if>
			<c:if test="${pager.pageNum>=pager.pageCount}">
				<li class="active"><a href="#">${pager.pageCount }</a></li>
				<li class="disabled"><a href="#">下页</a></li>
			</c:if>
		</c:if>
	</ul>
</nav>
