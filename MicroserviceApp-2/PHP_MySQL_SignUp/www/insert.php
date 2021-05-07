<html>
<body>
<?php

if(!empty($_ENV['MYSQL_HOST']))
   $host = $_ENV['MYSQL_HOST'];
else
   $host = 'mysql-app';

if(!empty($_ENV['MYSQL_USER']))
   $user = $_ENV['MYSQL_USER'];
else
   $user = 'user';

if(!empty($_ENV['MYSQL_PASSWORD']))
   $pass = $_ENV['MYSQL_PASSWORD'];
else
   $pass = 'password';

if(!empty($_ENV['MYSQL_DB']))
   $db_name = $_ENV['MYSQL_DB'];
else
   $db_name = 'database';



$conn = new mysqli($host, $user, $pass, $db_name);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 


$sql="INSERT INTO login_data (email, password) VALUES ('$_POST[email]','$_POST[password]')";


if (!mysqli_query($conn,$sql))

  {

  die('Error: ' . mysqli_error());

  }
echo "1 record added";

mysqli_close($conn)

?>
</body>
</html>