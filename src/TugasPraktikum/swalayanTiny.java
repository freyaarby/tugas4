package TugasPraktikum;
import java.util.Scanner;

public class swalayanTiny {

    Scanner sc = new Scanner(System.in);
    //untuk data umum
    private double noPilihan, pinATM; private int jumlahTopUp, saldo;
    private String namaPelanggan, daftarBarang, noPelanggan;

    //untuk data pembelian
    private boolean dispenser = false; private boolean bener = true; private boolean galon = false; private boolean oven = false; private boolean ricecooker = false;
    private int hargaBarang = 0; private int dispenserh = 450000; private int galonh= 35000; private int ovenh = 2000000; private int ricecookerh = 750000; 
    private int kedua = 0; private int hargaDispenser = 0; private int hargaGalon = 0; private int hargaOven  = 0; private int hargaRicecooker = 0;
    private int totalhargaDispenser = 0; private int totalhargaGalon = 0; private int totalhargaOven  = 0; private int totalhargaRicecooker = 0;

    //untuk data PIN
    private int kesalahanAutentikasi = 0;
    private boolean diblokir = false;

    //untuk data pelanggan
    public String namaAtm, noREK;
    public int saldoATM;
    

    public int getSaldo(){
        return saldo;
    }

    public String getNoPelanggan(){
        return noPelanggan;
    }

    public String getNamaPelanggan(){
        return namaPelanggan;
    }

    public void setSaldo(int saldoPel){
        this.saldo = saldoPel;
    }

    public void setNoPel(String noPel){
        this.noPelanggan = noPel;
    }

    public void setNamaPel(String namaPel){
        this.namaPelanggan = namaPel;
    }

    public void displayPilihan() {
        System.out.println("===================================");
        System.out.println("||SELAMAT DATANG DI SWALAYAN TINY||");
        System.out.println("===================================");
        System.out.println("Pilih layanan kami:");
        System.out.println("1. Pembelian ");
        System.out.println("2. TOP UP");
        System.out.println("3. Kedua Layanan");
        System.out.println("4. Keluar dari layanan");
        System.out.println("Pilihan Anda : ");

    }

    public void setChoiceNumber(int pilihNomor) {
        this.noPilihan = pilihNomor;
    }

    public void getChoiceNumber() {
        boolean out = true;
        do {
            if (noPilihan == 1) {
                pembelian();
                pinATM_awal();
                diskonTotalPembayaranPembelian();
                cobaAutentikasi();
                break;
            } else if (noPilihan == 2) {
                topUp();
                pinATM_awal();
                diskonTotalPembayaranTOPUP();
                cobaAutentikasi();
                break;
            } else if (noPilihan == 3) {
                memilihDua();
                pinATM_awal();
                diskonTotalPembayaranKeduanya();
                cobaAutentikasi();
                break;
            } else if (noPilihan == 4) {
                out = false;
                System.out.println("Terima kasih sudah mengunjungi Swalayan Tiny! Silakan berkunjung kembali ^^");
                System.exit(1);
            } else {
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        } while (out);
    }
    //nanti buat penggabungannya

    public void pembelian(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Daftar Barang");
        System.out.println("---------------------------------");
        System.out.printf("|| %5s || %10s || \n", "Nama Produk", "Harga Produk");
        System.out.println("---------------------------------");
        System.out.printf("|| %5s   || %12s || \n", "Dispenser", "Rp. 450.000");
        System.out.println("---------------------------------");
        System.out.printf("|| %5s       || %12s || \n", "Galon", "Rp. 35.000");
        System.out.println("---------------------------------");
        System.out.printf("|| %5s       || %12s|| \n", "Oven", "Rp. 2.000.000");
        System.out.println("---------------------------------");
        System.out.printf("|| %5s || %12s || \n", "Rice Cooker", "Rp. 750.000");
        System.out.println("---------------------------------");
        System.out.println();

        while (bener) {
            System.out.print("Masukkan nama barang ('selesai' untuk keluar): ");
            daftarBarang = sc.nextLine();

           if (daftarBarang.equalsIgnoreCase("selesai")) {
                break;
            }
        switch (daftarBarang.toLowerCase()) {
            case "dispenser":
                hargaDispenser = dispenserh;
                dispenser = true;
                kedua = 1;
                break;
            case "galon":
                hargaGalon = galonh;
                galon = true;
                kedua = 2;
                break;
            case "oven":
                hargaOven = ovenh;
                oven = true;
                kedua = 3;
                break;
            case "rice cooker":
                hargaRicecooker = ricecookerh;
                ricecooker = true;
                kedua = 4;
                break;
            default:
            System.out.println("Barang tidak ditemukan");
            break;
        }
        System.out.print("Masukkan jumlah: ");
        int jumlah = sc.nextInt();
        sc.nextLine();
            switch (kedua) {
            case 1:
                totalhargaDispenser += hargaDispenser * jumlah;
                break;
            case 2:
                totalhargaGalon += hargaGalon * jumlah;
                break;
            case 3:
                totalhargaOven += hargaOven * jumlah;
                break;
            case 4:
                totalhargaRicecooker += hargaRicecooker * jumlah;
                break;
        }
    }
        hargaBarang = totalhargaDispenser + totalhargaGalon + totalhargaOven + totalhargaRicecooker;
        System.out.println("Total belanjaan anda senilai: Rp. " + hargaBarang + ",-");

}

    public void topUp(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingin top up apa? ");
        String topUp = sc.nextLine();

        System.out.println("Masukkan jumlah TOP UP " + topUp + ": ");
        jumlahTopUp = sc.nextInt();
        sc.nextLine();

        System.out.println("Total TOP UP " + topUp + " anda senilai: Rp. " + jumlahTopUp + ",-");

    }

    public void memilihDua(){
        pembelian();
        topUp();
       int hargaKeduanya = hargaBarang + jumlahTopUp;
       System.out.println("Total harga keduanya adalah: Rp. " + hargaKeduanya + ",-");
    }  

    public void dataPelanggan(){
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan nama anda: ");
        namaAtm = input.nextLine();
        setNamaPel(namaAtm);
        getNamaPelanggan();

        System.out.println("!! PASTIKAN DIGIT AWAL SESUAI DENGAN JENIS KARTU ANDA, YAITU: SILVER (38), GOLD (56), DAN PLATINUM (74) !!");
        System.out.println("Masukkan nomor pelanggan anda: ");
        noREK = input.nextLine();
        
        setNoPel(noREK);
        getNoPelanggan();

        System.out.println("Masukkan saldo anda: ");
        saldoATM = input.nextInt();
        input.nextLine();
        setSaldo(saldoATM);
        getSaldo();

    }

    public void pinATM_awal(){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan PIN ATM anda: ");
        pinATM = input.nextInt();
        input.nextLine();

    }

    public void diskonTotalPembayaranPembelian(){
        Scanner input = new Scanner(System.in);

        setNoPel(noREK);
        getNoPelanggan();

        String norek = String.valueOf(noREK);
        String ambilbagian = norek.substring(0, 2);

        if(saldoATM < 10000){
            System.out.println("Transaksi anda gagal dikarenakan saldo anda kurang dari Rp. 10.000,-");
         }else{
            switch (ambilbagian) {
                case "38":
                if(hargaBarang > 1000000){
                    if(saldoATM < hargaBarang){
                        System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                        System.exit(1);
                    }else{
                        int totalDiskon = (int)(hargaBarang - (0.05 * hargaBarang));
                        System.out.println("Total Pembayaran Anda Senilai: Rp. " + totalDiskon + ",-");
                        System.out.println("Anda berhak mendapatkan cashback pembelian sebesar 5% karena telah berbelanja lebih dari Rp. 1.000.000,-");
                    }
                }else{
                    if(saldoATM < hargaBarang){
                        System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                        System.exit(1);
                    }else{
                        System.out.println("Total belanjaan anda senilai: Rp. " + hargaBarang + ",-");
                    }
                    }
                break;

                case "56":
                if(hargaBarang > 1000000){
                    if(saldoATM < hargaBarang){
                        System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                        System.exit(1);
                    }else{
                    int totalDiskon = (int)(hargaBarang - (0.07 * hargaBarang));
                    int fixTotal1 = (int)(totalDiskon + (0.02 * jumlahTopUp));
                    System.out.println("Total Pembayaran Anda Senilai: Rp. " + fixTotal1 + ",-");
                    System.out.println("Anda berhak mendapatkan cashback pembelian sebesar 7% dan kembali 2% karena telah berbelanja lebih dari Rp. 1.000.000,-");
                    }
                }else{
                    if(saldoATM < hargaBarang){
                        System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                        System.exit(1);
                    }else{
                        System.out.println("Total belanjaan anda senilai: Rp. " + hargaBarang + ",-");
                    }
                }
                break;

                case "74":
                if(hargaBarang > 1000000){
                    if(saldoATM < hargaBarang){
                        System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                        System.exit(1);
                    }else{
                        int totalDiskon = (int)(hargaBarang - (0.1 * hargaBarang));
                        int fixTotal1 = (int)(totalDiskon + (0.05 * jumlahTopUp));
                        System.out.println("Total Pembayaran Anda Senilai: Rp. " + fixTotal1 + ",-");
                        System.out.println("Anda berhak mendapatkan cashback pembelian sebesar 10% dan kembali 5% karena telah berbelanja lebih dari Rp. 1.000.000,-");
                    }  
                }else{
                    if(saldoATM < hargaBarang){
                        System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                        System.exit(1);
                    }else{
                        System.out.println("Total belanjaan anda senilai: Rp. " + hargaBarang + ",-");
                    }
                    }
                    break;
            }
         } 
    }

    //khusus diskon top up
    public void diskonTotalPembayaranTOPUP(){
        Scanner input = new Scanner(System.in);

        setNoPel(noREK);
        getNoPelanggan();

        String norek = String.valueOf(noREK);
        String ambilbagian = norek.substring(0, 2);

        switch (ambilbagian){
            case "38":
            if(jumlahTopUp > 1000000){
                if(saldoATM < jumlahTopUp){
                    System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                    System.exit(1);
                }else{
                    int totalDiskon = (int)(jumlahTopUp - (0.05 * jumlahTopUp));
                    System.out.println("Total Pembayaran Anda Senilai: Rp. " + totalDiskon + ",-");
                    System.out.println("Anda berhak mendapatkan cashback pembelian sebesar 5% karena telah berbelanja lebih dari Rp. 1.000.000,-");
                }
            }else{
                if(saldoATM < jumlahTopUp){
                    System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                    System.exit(1);
                }else{
                    System.out.println("Total belanjaan anda senilai: Rp. " + jumlahTopUp + ",-");
                }
                    }
                
            break;

            case "56":
            if(jumlahTopUp > 1000000){
                if(saldoATM < jumlahTopUp){
                    System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                    System.exit(1);
                }else{
                    int totalDiskon = (int)(jumlahTopUp - (0.07 * jumlahTopUp));
                    int fixTotal1 = (int)(totalDiskon + (0.02 * jumlahTopUp));
                    System.out.println("Total Pembayaran Anda Senilai: Rp. " + fixTotal1 + ",-");
                    System.out.println("Anda berhak mendapatkan cashback pembelian sebesar 7% dan kembali 2% karena telah berbelanja lebih dari Rp. 1.000.000,-");
                }
                }else{
                    if(saldoATM < jumlahTopUp){
                        System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                        System.exit(1);
                    }else{
                        System.out.println("Total belanjaan anda senilai: Rp. " + jumlahTopUp + ",-");
                    }
                    }
                
            break;

            case "74":
            if(jumlahTopUp > 1000000){
                if(saldoATM < jumlahTopUp){
                    System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                    System.exit(1);
                }else{
                int totalDiskon = (int)(jumlahTopUp - (0.1 * jumlahTopUp));
                int fixTotal1 = (int)(totalDiskon + (0.05 * jumlahTopUp));
                System.out.println("Total Pembayaran Anda Senilai: Rp. " + fixTotal1 + ",-");
                System.out.println("Anda berhak mendapatkan cashback pembelian sebesar 10% dan kembali 5% karena telah berbelanja lebih dari Rp. 1.000.000,-");
                }
            }else{
                if(saldoATM < jumlahTopUp){
                    System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                    System.exit(1);
                }else{
                    System.out.println("Total belanjaan anda senilai: Rp. " + jumlahTopUp + ",-");
                }
                    }
            break;
        }
    }

    public void diskonTotalPembayaranKeduanya(){
        Scanner input = new Scanner(System.in);

        setNoPel(noREK);
        getNoPelanggan();

        String norek = String.valueOf(noREK);
        String ambilbagian = norek.substring(0, 2);

        int totalKeduanya = hargaBarang + jumlahTopUp;

        switch (ambilbagian){
            case "38":
            if(totalKeduanya > 1000000){
                if(saldoATM < totalKeduanya){
                    System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                    System.exit(1);
                }else{
                    int totalDiskon = (int)(totalKeduanya - (0.05 * totalKeduanya));
                    System.out.println("Total Pembayaran Anda Senilai: Rp. " + totalDiskon + ",-");
                    System.out.println("Anda berhak mendapatkan cashback pembelian sebesar 5% karena telah berbelanja lebih dari Rp. 1.000.000,-");
                }
                    }else{
                        if(saldoATM < totalKeduanya){
                            System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                            System.exit(1);
                        }else{
                            System.out.println("Total belanjaan anda senilai: Rp. " + totalKeduanya + ",-");
                        }
                    }
            break;

            case "56":
            if(totalKeduanya > 1000000){
                if(saldoATM < totalKeduanya){
                    System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                    System.exit(1);
                }else{
                    int totalDiskon = (int)(totalKeduanya - (0.05 * totalKeduanya));
                int fixTotal1 = (int)(totalDiskon + (0.02 * totalKeduanya));
                System.out.println("Total Pembayaran Anda Senilai: Rp. " + fixTotal1 + ",-");
                System.out.println("Anda berhak mendapatkan cashback pembelian sebesar 7% dan kembali 2% karena telah berbelanja lebih dari Rp. 1.000.000,-");
                }
                    }else{
                        if(saldoATM < totalKeduanya){
                            System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                            System.exit(1);
                        }else{
                            System.out.println("Total belanjaan anda senilai: Rp. " + totalKeduanya + ",-");
                        }
                    }
            break;

            case "74":
            if(totalKeduanya > 1000000){
                if(saldoATM < totalKeduanya){
                    System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                    System.exit(1);
                }else{
                    int totalDiskon = (int)(totalKeduanya - (0.1 * totalKeduanya));
                int fixTotal1 = (int)(totalDiskon + (0.05 * totalKeduanya));
                System.out.println("Total Pembayaran Anda Senilai: Rp. " + fixTotal1 + ",-");
                System.out.println("Anda berhak mendapatkan cashback pembelian sebesar 10% dan kembali 5% karena telah berbelanja lebih dari Rp. 1.000.000,-");
                }
                    }else{
                        if(saldoATM < totalKeduanya){
                            System.out.println("Saldo anda tidak cukup untuk. Silakan diisi ulang!");
                            System.exit(1);
                        }else{
                            System.out.println("Total belanjaan anda senilai: Rp. " + totalKeduanya + ",-");
                        }
                    }
            break;
                }
        }
    

    public void cobaAutentikasi() {

        Scanner input = new Scanner(System.in);
        int counter = 0; 
        int maxAttempts = 3; 
        
        do {
            System.out.println("Masukkan ulang PIN ATM anda: ");
            int pin = input.nextInt();
    
            if (!diblokir && pin != pinATM) {
                kesalahanAutentikasi++; // Increment kesalahanAutentikasi jika PIN salah
                System.out.println("Kesalahan autentifikasi, ulangi lagi. Kesalahan ke-" + kesalahanAutentikasi);
                if (kesalahanAutentikasi == 3) {
                    diblokir = true;
                    System.out.println("Akun telah diblokir karena kesalahan autentifikasi yang berulang.");
                }
            } else if (!diblokir && pin == pinATM) {
                System.out.println("Autentifikasi berhasil, transaksi anda berhasil dilakukan ^^");
                System.out.println("Terima kasih, silakan berbelanja kembali di Swalayan Tiny!");
                break; // Keluar dari loop jika autentikasi berhasil
            } else {
                System.out.println("Akun telah diblokir. Tidak dapat melakukan autentifikasi.");
                break; 
            }
            counter++; 
        } while (counter < maxAttempts && !diblokir);
        
    }

    
}


