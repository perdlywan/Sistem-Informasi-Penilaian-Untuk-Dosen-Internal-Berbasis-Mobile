package com.example.kelompok3_uas;

public class Dosen {
    private String KodeDosen,Nidn,NamaDosen,TmptLahir,TglLahir,Status,Alamat,Kelurahan,Kecamatan,Kota_Kab,
            Provinsi,KodePos,NoHp,Pendidikan,JabatanAkademik,Golongan,Prodi,BidangKeahlian;

    public Dosen() {
    }

    public Dosen(String kodeDosen, String nidn, String namaDosen, String tmptLahir, String tglLahir, String status, String alamat, String kelurahan, String kecamatan, String kota_Kab, String provinsi, String kodePos, String noHp, String pendidikan, String jabatanAkademik, String golongan, String prodi, String bidangKeahlian) {
        this.KodeDosen = kodeDosen;
        this.Nidn = nidn;
        this.NamaDosen = namaDosen;
        this.TmptLahir = tmptLahir;
        this.TglLahir = tglLahir;
        this.Status = status;
        this.Alamat = alamat;
        this.Kelurahan = kelurahan;
        this.Kecamatan = kecamatan;
        this.Kota_Kab = kota_Kab;
        this.Provinsi = provinsi;
        this.KodePos = kodePos;
        this.NoHp = noHp;
        this.Pendidikan = pendidikan;
        this.JabatanAkademik = jabatanAkademik;
        this.Golongan = golongan;
        this.Prodi = prodi;
        this.BidangKeahlian = bidangKeahlian;
    }

    public String getKodeDosen() {
        return KodeDosen;
    }

    public void setKodeDosen(String kodeDosen) {
        KodeDosen = kodeDosen;
    }

    public String getNidn() {
        return Nidn;
    }

    public void setNidn(String nidn) {
        Nidn = nidn;
    }

    public String getNamaDosen() {
        return NamaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        NamaDosen = namaDosen;
    }

    public String getTmptLahir() {
        return TmptLahir;
    }

    public void setTmptLahir(String tmptLahir) {
        TmptLahir = tmptLahir;
    }

    public String getTglLahir() {
        return TglLahir;
    }

    public void setTglLahir(String tglLahir) {
        TglLahir = tglLahir;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getKelurahan() {
        return Kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        Kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return Kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        Kecamatan = kecamatan;
    }

    public String getKota_Kab() {
        return Kota_Kab;
    }

    public void setKota_Kab(String kota_Kab) {
        Kota_Kab = kota_Kab;
    }

    public String getProvinsi() {
        return Provinsi;
    }

    public void setProvinsi(String provinsi) {
        Provinsi = provinsi;
    }

    public String getKodePos() {
        return KodePos;
    }

    public void setKodePos(String kodePos) {
        KodePos = kodePos;
    }

    public String getNoHp() {
        return NoHp;
    }

    public void setNoHp(String noHp) {
        NoHp = noHp;
    }

    public String getPendidikan() {
        return Pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        Pendidikan = pendidikan;
    }

    public String getJabatanAkademik() {
        return JabatanAkademik;
    }

    public void setJabatanAkademik(String jabatanAkademik) {
        JabatanAkademik = jabatanAkademik;
    }

    public String getGolongan() {
        return Golongan;
    }

    public void setGolongan(String golongan) {
        Golongan = golongan;
    }

    public String getProdi() {
        return Prodi;
    }

    public void setProdi(String prodi) {
        Prodi = prodi;
    }

    public String getBidangKeahlian() {
        return BidangKeahlian;
    }

    public void setBidangKeahlian(String bidangKeahlian) {
        BidangKeahlian = bidangKeahlian;
    }
}
