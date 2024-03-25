package TugasPraktikum;
import java.util.Scanner;

public class tugas4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        swalayanTiny object = new swalayanTiny();
        
        int pilihan;

        int pelanggan = 0;

        do{
            object.dataPelanggan();
    
            pelanggan++;
            System.out.println("Pelanggan ke- " + pelanggan);
            System.out.println("=======================================");
            System.out.println("||    DATA PELANGGAN SWALAYAN TINY   ||");
            System.out.println("||===================================||");
           
            object.setNamaPel(object.namaAtm);
            System.out.printf("|| %s%15s || \n", "Nama Pelanggan  : ", object.getNamaPelanggan());

            object.setNoPel(object.noREK);
            System.out.printf("|| %s%15s || \n", "Nomor Pelanggan : ", object.getNoPelanggan());

            object.setSaldo(object.saldoATM);
            System.out.printf("|| %s%15s|| \n", "Jumlah Saldo    :  ", "Rp. " + object.getSaldo());

            System.out.println("=======================================");
        
            System.out.println();

            object.displayPilihan();
            pilihan = input.nextInt();
            input.nextLine();

            object.setChoiceNumber(pilihan);
            object.getChoiceNumber();
          
        } while (pilihan < 4);
        input.close();
    }
}


