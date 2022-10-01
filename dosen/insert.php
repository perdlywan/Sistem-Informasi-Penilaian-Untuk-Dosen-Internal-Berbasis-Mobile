<?php 
 include_once('koneksi.php'); 

 $KodeDosen=$_POST['KodeDosen'];
 $Nidn=$_POST['Nidn'];
 $NamaDosen=$_POST['NamaDosen'];
 $TmptLahir=$_POST['TmptLahir'];
 $TglLahir=date('Y-d-m', strtotime($_POST['TglLahir']));
 $Status=$_POST['Status'];
 $Alamat=$_POST['Alamat'];
 $Kelurahan=$_POST['Kelurahan'];
 $Kecamatan=$_POST['Kecamatan'];
 $Kota_Kab=$_POST['Kota_Kab'];
 $Provinsi=$_POST['Provinsi'];
 $KodePos=$_POST['KodePos'];
 $NoHp=$_POST['NoHp'];
 $Pendidikan=$_POST['Pendidikan'];
 $JabatanAkademik=$_POST['JabatanAkademik']; 
 $Golongan=$_POST['Golongan'];
 $Prodi=$_POST['Prodi'];
 $BidangKeahlian=$_POST['BidangKeahlian'];

 $sql = "INSERT INTO dosen (KodeDosen,Nidn,NamaDosen,TmptLahir,TglLahir,Status,Alamat,Kelurahan,Kecamatan,Kota_Kab,Provinsi,KodePos,NoHp,Pendidikan,JabatanAkademik,Golongan,Prodi,BidangKeahlian) VALUES ('$KodeDosen','$Nidn','$NamaDosen','$TmptLahir','$TglLahir','$Status','$Alamat','$Kelurahan','$Kecamatan','$Kota_Kab','$Provinsi','$KodePos','$NoHp','$Pendidikan','$JabatanAkademik','$Golongan','$Prodi','$BidangKeahlian')";

 $result = mysqli_query($koneksi,$sql);

 if($result){
 	echo "Data Inserted";
 }else {
 	echo "Failed";
 }

 mysqli_close($koneksi);

 ?>