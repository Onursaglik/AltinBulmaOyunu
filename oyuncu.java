package Package;


public class oyuncu {

    int altin_sayisi=200;
    int toplanan_altin=0;
    int harcanan_altin=0;
    private int konum_x=0,konum_y=0;
    Altin hedef_altin;
    boolean hedef_var=false;
    boolean elendi=false;
    int adim_sayisi;
    int toplam_adim_sayisi;

    public int getKonum_x() {
        return konum_x;
    }




    public void setKonum_x(int konum_x) {
        this.konum_x = konum_x;
    }




    public int getKonum_y() {
        return konum_y;
    }




    public void setKonum_y(int konum_y) {
        this.konum_y = konum_y;
    }




    public oyuncu() {






    }





    public int getToplanan_altin() {
        return toplanan_altin;
    }
    public void setToplanan_altin(int toplanan_altin) {
        this.toplanan_altin = toplanan_altin;
    }
    public int getHarcanan_altin() {
        return harcanan_altin;
    }
    public void setHarcanan_altin(int harcanan_altin) {
        this.harcanan_altin = harcanan_altin;
    }





}