<!DOCTYPE html>
<html lang="en">
<head>
  <title>Results</title>
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
   .yes{text-align: center; font-size: 20px;}
  </style>
</head>
<body>

<div class="container">
  
  <div class="page-header"><hr style="height:10px"><b>GASOLINE eSTORE</b></div>
  
  <div class="row">
	
    <div class="col-lg-12 yes" style="background-color:#F47940;"><br>
      <ul class="list-group">
		<li class="list-group-item list-group-item-warning" style="color:F47940;"><label >FUEL TYPE:  ${PayAmount.fuelType}</label></li>
		<li class="list-group-item list-group-item-default" style="color:FB4516;"><label >PRICEPERLITER: ${PayAmount.ppLit}</label></li>
		<li class="list-group-item list-group-item-warning" style="color:F47940;"><label >VAT: ${PayAmount.vat}</label></li>
		<li class="list-group-item list-group-item-default" style="color:FB4516;"><label>PURCHASE AMOUNT: ${PayAmount.purAm}</label></li>
		<li class="list-group-item list-group-item-warning" style="color:F47940;"><label>TOTAL AMOUNT: ${PayAmount.total} ${PayAmount.reg}</label></li>
		<li class="list-group-item list-group-item-default" style="color:FB4516;"><label>CREDIT CARD TYPE: 	${PayAmount.ccType}</label></li>
		<li class="list-group-item list-group-item-warning" style="color:F47940;"><label >CREDIT CARD NUMBER: ${PayAmount.credit}</label></li>
		</ul>
    </div>
    
	
	<div class="col-lg-6"><br>
		<form action="listrecord.html" method="post">
			<button type="submit" class= "btn btn-warning btn-block" style="font-size: 20px;">See previous records</button>
		</form>
				</div>
	</form>
  </div>
</div>
    
</body>
</html>

