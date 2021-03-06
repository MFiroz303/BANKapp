<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.input-group {
	margin-bottom: 10px;
}

.separator {
	border-right: 1px solid #dfdfe0;
}

.facebook, .google {
	min-width: 170px;
}

.facebook {
	background-color: #354E84;
	color: #fff;
}

.google {
	background-color: black;
	color: #fff;
}

.facebook:hover, .google:hover {
	color: #fff;
}

.row {
	margin-right: 15px;
}

#pid {
	float: none;
	margin: 0 auto;
	margin-top: 50px;
}

.center {
	text-align: center;
	border-radius: 5px;
}
</style>
<title>Login page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/libs/bootstarp/3.2.0/bootstrap.min.js">
	
</script>

<script type="text/javascript">
function validate() {
	var email = document.submit.email.value;
	var password = document.submit.password.value;

	if (email == null || email == "") {
		alert("Please enter a valid e-mail.");
		return false;
	}
	if  (password.length < 4) {
		alert("Password must be less than 8 characters.");
		return false;
	}
}
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-6" id="pid">
				<div class="panel-heading">

					<h3>Sign In.</h3>
					<hr color="green">
				</div>

				<div class="col-xs-6 col-sm-6 col-md-6 separator social-login-box">
					<h4>use other account</h4>
					<p>
						You can also sing in using facbook account and google account<br>
						<br> <a href="" class="btn facebook btn-block">Log in
							using Facebook</a> <br /> <a href="" class="btn google btn-block">Log
							in using google</a>
				</div>
				<h4 class="text-center">Using your account</h4>
				<br>
				<div class="col-xs-6 col-sm-6 col-md-6 login-box">
					<form action="UserLogin" name="submit"
						onsubmit="return validate()" method="post" class="form-horizontal">
						<div class="form-group">
							<div class="col-sm-12">
								<input type="email" class="form-control"
									placeholder="Enter your Email" name="email">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<input type="password" class="form-control"
									placeholder="Enter your password" name="password">

							</div>
						</div>


						<div class="form-group">
							<div class="col-sm-12">
								<div class="btn-group btn-group-justified">
									<div class="btn-group">
										<button type="submit" class="btn btn-success">Login</button>
									</div>
								</div>
							</div>
						</div>
						<div class="center">
							<a href="index.jsp" class="regis"><u>New User
									Registration..?</u></a>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript" src="Validate.js"></script>
</body>
</html>