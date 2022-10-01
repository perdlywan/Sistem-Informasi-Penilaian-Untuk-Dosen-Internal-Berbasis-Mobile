<?php 
 include_once('koneksi.php');

 $KodeDosen = $_POST['KodeDosen']; 

 $sql = "DELETE FROM dosen WHERE KodeDosen='$KodeDosen'";

 $result = mysqli_query($koneksi,$sql);

 if($result){
 	echo "Data Deleted";
 }
 else {
 	echo "Failed";
 }
 mysqli_close($koneksi);

 ?>