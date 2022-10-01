<?php 
 include_once('koneksi.php');

 $nim = $_POST['nim']; 

 $sql = "DELETE FROM mahasiswa WHERE nim='$nim'";

 $result = mysqli_query($koneksi,$sql);

 if($result){
 	echo "Data Deleted";
 }
 else {
 	echo "Failed";
 }
 mysqli_close($koneksi);

 ?>