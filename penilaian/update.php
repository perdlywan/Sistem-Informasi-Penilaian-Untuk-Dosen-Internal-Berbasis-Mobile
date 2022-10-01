<?php  
 include_once('koneksi.php'); 

 $id=$_POST['id'];
 $nama_dosen=$_POST['nama_dosen'];
 $pertanyaan1=$_POST['pertanyaan1'];
 $pertanyaan2=$_POST['pertanyaan2'];
 $pertanyaan3=$_POST['pertanyaan3'];
 $pertanyaan4=$_POST['pertanyaan4'];
 $pertanyaan5=$_POST['pertanyaan5'];
 $pertanyaan6=$_POST['pertanyaan6'];
 $pertanyaan7=$_POST['pertanyaan7'];
 $pertanyaan8=$_POST['pertanyaan8'];

 $sql = "UPDATE penilaian SET nama_dosen='$nama_dosen', pertanyaan1='$pertanyaan1', pertanyaan2='$pertanyaan2', pertanyaan3='$pertanyaan3', pertanyaan4='$pertanyaan4', pertanyaan5='$pertanyaan5', pertanyaan6='$pertanyaan6', pertanyaan7='$pertanyaan7', pertanyaan8='$pertanyaan8' WHERE id = '$id'";

 $result = mysqli_query($koneksi,$sql);

 if($result){
  echo "Data kuisoner berhasil diupdate";
 }
 else{
  echo "Failed";
  mysqli_close($koneksi);
 }
?>