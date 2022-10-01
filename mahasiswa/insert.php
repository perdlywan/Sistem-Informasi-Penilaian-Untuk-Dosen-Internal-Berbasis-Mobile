<?php 
 include_once('koneksi.php'); 

 $nim=$_POST['nim'];
 $nama_mahasiswa=$_POST['nama_mahasiswa'];
 $tempat_lahir=$_POST['tempat_lahir'];
 $tanggal_lahir=date('Y-d-m', strtotime($_POST['tanggal_lahir']));
 $status=$_POST['status'];
 $alamat=$_POST['alamat'];
 $kecamatan=$_POST['kecamatan'];
 $kota_kab=$_POST['kota_kab'];
 $provinsi=$_POST['provinsi'];
 $kode_pos=$_POST['kode_pos'];
 $no_hp=$_POST['no_hp'];
 $pendidikan_terakhir=$_POST['pendidikan_terakhir'];
 $prodi=$_POST['prodi']; 

 $sql = "INSERT INTO mahasiswa (nim,nama_mahasiswa,tempat_lahir,tanggal_lahir,status,alamat,kecamatan,kota_kab,provinsi,kode_pos,no_hp,pendidikan_terakhir,prodi) VALUES ('$nim','$nama_mahasiswa','$tempat_lahir','$tanggal_lahir','$status','$alamat','$kecamatan','$kota_kab','$provinsi','$kode_pos','$no_hp','$pendidikan_terakhir','$prodi')";

 $result = mysqli_query($koneksi,$sql);

 if($result){
 	echo "Data Inserted";
 }else {
 	echo "Failed";
 }

 mysqli_close($koneksi);

 ?>