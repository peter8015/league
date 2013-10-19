<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<%@ include file="/commons/commonJS.jsp"%>

<!doctype html>
<head>
<base href="${ctx}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo-Index</title>
<script type="text/javascript">

	$(function() {
		var availableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC",
				"C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang",
				"Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp",
				"Perl", "PHP", "Python", "Ruby", "Scala", "Scheme" ];
		$("#tags").autocomplete({
			source : availableTags
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h1 class="page-header">BEYOND!</h1>
		<h3>
			${message}, Leaguer, I am Demo! <a href="${ctx}/helloWorld">Try
				me!</a>
		</h3>

		<div class="row">
			<div class="span4">&nbsp;</div>
			<div class="span4">
			</div>
			<div class="span4">&nbsp;</div>
		</div>

		<div class="row">
			<div class="span4">&nbsp;</div>
			<div class="navbar span4">
				<a class="brand" href="#"></a>
				<form class="navbar-search">
					<input id="tags" type="text" class="search-query">
				</form>
				<ul class="nav">
					<li><a href="#">Search</a></li>
				</ul>
			</div>
			<div class="span4"></div>
		</div>

		<div class="row">
			<div class="span4"></div>
			<div class="navbar span6">
				<div id="myCarousel" class="carousel">
					<!-- Carousel items -->
					<div class="carousel-inner">
						<div class="active item">
							<img alt="" src="${ctx}/images/demo/bootstrap-mdo-sfmoma-01.jpg">
						</div>
						<div class="item">
							<img alt="" src="${ctx}/images/demo/bootstrap-mdo-sfmoma-03.jpg">
						</div>
					</div>
					<!-- Carousel nav -->
					<a class="carousel-control left" href="#myCarousel"
						data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
						href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div>
			</div>
			<div class="span2"></div>
		</div>
	</div>
</body>
</html>