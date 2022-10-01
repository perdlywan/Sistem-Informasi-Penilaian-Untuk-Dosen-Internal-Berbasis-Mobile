<?php 
 include_once('koneksi.php'); 

 $nama_dosen=$_POST['nama_dosen'];
 $pertanyaan1=$_POST['pertanyaan1'];
 $pertanyaan2=$_POST['pertanyaan2'];
 $pertanyaan3=$_POST['pertanyaan3'];
 $pertanyaan4=$_POST['pertanyaan4'];
 $pertanyaan5=$_POST['pertanyaan5'];
 $pertanyaan6=$_POST['pertanyaan6'];
 $pertanyaan7=$_POST['pertanyaan7'];
 $pertanyaan8=$_POST['pertanyaan8'];

 $sql = "INSERT INTO penilaian (nama_dosen,pertanyaan1,pertanyaan2,pertanyaan3,pertanyaan4,pertanyaan5,pertanyaan6,pertanyaan7,pertanyaan8) VALUES ('$nama_dosen','$pertanyaan1','$pertanyaan2','$pertanyaan3','$pertanyaan4','$pertanyaan5','$pertanyaan6','$pertanyaan7','$pertanyaan8')";

 $result = mysqli_query($koneksi,$sql);

 if($result){
 	echo "success";
 }else {
 	echo "Failed";
 }

 mysqli_close($koneksi);

 ?>