<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .page-header{
				background-color: F47940;
				color: white;
				font-size: 55px;
				text-align: center;
				letter-spacing: 5px;}
   body{background-color: #231F20;}
   .yes{ color: white; font-size: 23px;}
   .no{color: #FB4516; font-size: 22px;}
  </style>
</head>
<body>

<div class="container">
  
  <div class="page-header"><hr style="height:10px"><b>GASOLINE eSTORE</b></div>
  
  <div class="row">
	<form action="gasolinestore.html" method="post">
    <div class="col-lg-6 yes" style="background-color:#F47940;"><br>
      <br><label class="control-label" for="fuelType">FUELTYPE:</label> 
						<div class="radio">
							<label><input type="radio" name="fuelType" id="fuelType"
								value="Unleaded">Unleaded</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="fuelType" id="fuelType"
								value="Diesel">Diesel</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="fuelType" id="fuelType"
								value="Premium">Premium</label>
						</div><br>
	  <label class="control-label " for="lNum">NUMBER
							OF LITERS:</label>
	  <input class="form-control" type="text" name="lNum"
							id="lNum" class="form-control"><br><br>
    </div>
    <div class="col-lg-6 no" style="background-color:#FFFEFB;"><br>
      <label class="control-label" for="ccType">CREDIT
							CARD TYPE: </label>
	 
						<div class="radio">
							<label><input type="radio" name="ccType" id="ccType"
								value="VISA">VISA</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="ccType" id="ccType"
								value="MASTERCARD">MASTERCARD</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="ccType" id="ccType"
								value="JCB">JCB</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="ccType" id="ccType"
								value="AMEX">AMEX</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="ccType" id="ccType"
								value="DINERS">DINERS</label>
						</div>
				<label class="control-label" for="ccType">CREDIT
							CARD NUMBER:</label>
							<input class="form-control" type="text" name="cNum"
							id="cNUm"><br><br>
    </div>
	
	<div class="col-xs-12"><br>
					<button type="submit" class="btn btn-warning btn-block" style="font-size:20px;"><b>Submit<b></button>
				</div>
	</form>
  </div>
</div>
    
</body>
</html>

