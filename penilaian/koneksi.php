<?php 
 define('HOSTNAME', 'localhost');
 define('USERNAME', 'root');
 define('PASSWORD', '');
 define('DB_SELECT', 'uas');

 $koneksi = new mysqli(HOSTNAME,USERNAME,PASSWORD,DB_SELECT) or die (mysqli_errno());

 if(!$koneksi){
  die("Koneksi ke MySQL gagal dilakukan!<br>");
 }
 ?>