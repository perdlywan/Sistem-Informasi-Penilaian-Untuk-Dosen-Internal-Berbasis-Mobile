<?php 
 include_once('koneksi.php');

 $id = $_POST['id']; 

 $sql = "DELETE FROM penilaian WHERE id='$id'";

 $result = mysqli_query($koneksi,$sql);

 if($result){
 	echo "Data Deleted";
 }
 else {
 	echo "Failed";
 }
 mysqli_close($koneksi);

 ?>