import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;


public class KartuKontrol {
    private List<Asistensi> riwayatAsistensi;
    private Praktikan praktikan;

    public KartuKontrol(Praktikan praktikan){
        this.praktikan = praktikan;
        this.riwayatAsistensi = new ArrayList<>();

    }
    public void tampilkanRiwayat(){
        if(riwayatAsistensi.Empty()){
            System.out.println("Belum ada riwayat asistensi untuk "+ praktikan.getNama());
            return;
        }
        System.out.println("Riwayat Asistensi untuk " + praktikan.getNama() + ":");
        for (Asistensi asistensi: riwayatAsistensi){
            asistensi.showInfo();
        }
    }
    //Getter
    public List<Asistensi> getRiwayAsistensi(){
        return riwayatAsistensi;
    }
    public Praktikan getPraktikan(){
        return praktikan;
    }

    //Setter
    public void setPraktikan(Praktikan praktikan){
        if(praktikan != null){
            this.praktikan = praktikan;
        }
    }

}



