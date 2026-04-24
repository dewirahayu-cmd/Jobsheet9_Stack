import java.util.Scanner;

public class SuratDemo08 {
    public static void main(String[] args) {
        StackSurat08 stack = new StackSurat08(10);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n===== Menu Surat Izin =====");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat: ");
                    String id = scan.nextLine();
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S=Sakit / I=Izin): ");
                    char jenis = scan.nextLine().toUpperCase().charAt(0);
                    System.out.print("Durasi (hari): ");
                    int durasi = scan.nextInt();
                    scan.nextLine();

                    Surat08 surat = new Surat08(id, nama, kelas, jenis, durasi);
                    stack.push(surat);
                    System.out.println("Surat dari " + nama + " berhasil diterima.");
                    break;

                case 2:
                    Surat08 diproses = stack.pop();
                    if (diproses != null) {
                        System.out.println("\n== Surat Diproses ==");
                        System.out.println("ID Surat: " + diproses.idSurat);
                        System.out.println("Nama: " + diproses.namaMahasiswa);
                        System.out.println("Kelas: " + diproses.kelas);
                        System.out.println("Jenis Izin: " + (diproses.jenisIzin == 'S' ? "Sakit" : "Izin Keperluan Lain"));
                        System.out.println("Durasi: " + diproses.durasi + " hari");
                        System.out.println("Status: Surat berhasil diverifikasi.");
                    }
                    break;

                case 3:
                    Surat08 terakhir = stack.peek();
                    if (terakhir != null) {
                        System.out.println("\n== Surat Izin Terakhir ==");
                        System.out.println("ID Surat: " + terakhir.idSurat);
                        System.out.println("Nama: " + terakhir.namaMahasiswa);
                        System.out.println("Kelas: " + terakhir.kelas);
                        System.out.println("Jenis Izin: " + (terakhir.jenisIzin == 'S' ? "Sakit" : "Izin Keperluan Lain"));
                        System.out.println("Durasi: " + terakhir.durasi + " hari");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String cari = scan.nextLine();
                    Surat08 hasil = stack.cariSurat(cari);
                    if (hasil != null) {
                        System.out.println("\n== Surat Ditemukan ==");
                        System.out.println("ID Surat: " + hasil.idSurat);
                        System.out.println("Nama: " + hasil.namaMahasiswa);
                        System.out.println("Kelas: " + hasil.kelas);
                        System.out.println("Jenis Izin: " + (hasil.jenisIzin == 'S' ? "Sakit" : "Izin Keperluan Lain"));
                        System.out.println("Durasi: " + hasil.durasi + " hari");
                    } else {
                        System.out.println("Surat atas nama \"" + cari + "\" tidak ditemukan.");
                    }
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);

        scan.close();
    }
}