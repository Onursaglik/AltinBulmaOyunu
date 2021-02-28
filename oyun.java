package Package;
import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class oyun extends JPanel implements ActiveEvent,ActionListener {

    public static ArrayList <Altin> altinlar;
    static int screen_x;
    static int screen_y;
    static int x;
    static int y;
    static int boyut_x,boyut_y;
    static oyuncu oyuncu_1;
    static ArrayList <oyuncu> oyuncu;
    static int altin_sayisi;
    static int oyuncu_sira=0;
    static int adim_sayisi;
    Timer zamanlama=new Timer(500,this);


    public oyun(int screen_x,int screen_y,ArrayList <Altin>altinlar,int x,int y,int oyuncu_altin_sayisi,int adim_sayisi) {

        this.adim_sayisi=adim_sayisi;
        this.x=x;
        this.y=y;
        this.altinlar=altinlar;
        this.screen_x=screen_x;
        this.screen_y=screen_y;
        oyuncu=new ArrayList();


        oyuncu.add(new oyuncu());
        oyuncu.add(new oyuncu());
        oyuncu.add(new oyuncu());
        oyuncu.add(new oyuncu());

        oyuncu.get(0).altin_sayisi=oyuncu_altin_sayisi;
        oyuncu.get(1).altin_sayisi=oyuncu_altin_sayisi;
        oyuncu.get(2).altin_sayisi=oyuncu_altin_sayisi;
        oyuncu.get(3).altin_sayisi=oyuncu_altin_sayisi;


        oyuncu.get(1).setKonum_x(x-1);
        oyuncu.get(1).setKonum_y(0);

        oyuncu.get(2).setKonum_x(0);
        oyuncu.get(2).setKonum_y(y-1);

        oyuncu.get(3).setKonum_x(x-1);
        oyuncu.get(3).setKonum_y(y-1);

        boyut_x=screen_x/x;
        boyut_y=screen_y/y;


        oyuncu_1=new oyuncu();


        setFocusable(true);
        requestFocusInWindow();
        zamanlama.start();

    }




    protected void paintComponent(Graphics g){

        super.paintComponent(g);




        g.setColor(Color.YELLOW);
        for(int i=0;i<altinlar.size();i++) {

            if(altinlar.get(i).gizli==false) {

                g.fillRect(altinlar.get(i).konum_x*boyut_x,altinlar.get(i).konum_y*boyut_y,boyut_x,boyut_y);
                JLabel altin_miktari=new JLabel();
                altin_miktari.setText(Integer.toString(altinlar.get(i).altin_miktari));
                altin_miktari.setBounds(altinlar.get(i).konum_x*boyut_x,altinlar.get(i).konum_y*boyut_y, 20,20);
                add(altin_miktari);
                altin_sayisi++;
            }
        }

        g.setColor(Color.GRAY);
        for(int i=0;i<altinlar.size();i++) {

            if(altinlar.get(i).gizli==true)
                g.fillRect(altinlar.get(i).konum_x*boyut_x,altinlar.get(i).konum_y*boyut_y,boyut_x,boyut_y);
            //altin_sayisi++;

        }

        g.setColor(Color.RED);
        if(oyuncu.get(0).elendi==false)
            g.fillRect( oyuncu.get(0).getKonum_x()*boyut_x,  oyuncu.get(0).getKonum_y()*boyut_y,boyut_x,boyut_y);
        g.setColor(Color.BLUE);
        if(oyuncu.get(1).elendi==false)
            g.fillRect( oyuncu.get(1).getKonum_x()*boyut_x,  oyuncu.get(1).getKonum_y()*boyut_y,boyut_x,boyut_y);
        g.setColor(Color.ORANGE);
        if(oyuncu.get(2).elendi==false)
            g.fillRect( oyuncu.get(2).getKonum_x()*boyut_x,  oyuncu.get(2).getKonum_y()*boyut_y,boyut_x,boyut_y);
        g.setColor(Color.MAGENTA);
        if(oyuncu.get(3).elendi==false)
            g.fillRect( oyuncu.get(3).getKonum_x()*boyut_x,  oyuncu.get(3).getKonum_y()*boyut_y,boyut_x,boyut_y);

        g.setColor(Color.WHITE);

        for(int i=0;i<=x;i++)
            g.drawLine(boyut_x*i, 0,boyut_x*i,boyut_y*y);
        for(int i=0;i<=y;i++)
            g.drawLine(0,i*boyut_y,boyut_x*x,boyut_y*i);

    }



    @Override
    public void dispatch() {
        // TODO Auto-generated method stub

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==zamanlama) {



            if(oyuncu.get(oyuncu_sira).altin_sayisi<=0) {
                oyuncu.get(oyuncu_sira).hedef_var=false;
                oyuncu.get(oyuncu_sira).elendi=true;
                oyuncu_sira++;
                if(oyuncu_sira==4)
                    oyuncu_sira=0;
            }

            if(oyuncu.get(oyuncu_sira).altin_sayisi<=0) {
                oyuncu.get(oyuncu_sira).hedef_var=false;
                oyuncu.get(oyuncu_sira).elendi=true;
                oyuncu_sira++;
                if(oyuncu_sira==4)
                    oyuncu_sira=0;
            }

            if(oyuncu.get(oyuncu_sira).altin_sayisi<=0) {
                oyuncu.get(oyuncu_sira).hedef_var=false;
                oyuncu.get(oyuncu_sira).elendi=true;
                oyuncu_sira++;
                if(oyuncu_sira==4)
                    oyuncu_sira=0;
            }

            if(oyuncu.get(oyuncu_sira).altin_sayisi<=0) {
                oyuncu.get(oyuncu_sira).hedef_var=false;
                oyuncu.get(oyuncu_sira).elendi=true;
                oyuncu_sira++;
                if(oyuncu_sira==4)
                    oyuncu_sira=0;
            }

            if(oyuncu_sira==4)
                oyuncu_sira=0;

            if(oyuncu.get(0).elendi==true&&oyuncu.get(1).elendi==true&&oyuncu.get(2).elendi==true&&oyuncu.get(3).elendi==true) {

                String mesaj=new String();
                //mesaj="0.oyuncunun kalan altin miktari="+oyuncu.get(0).altin_sayisi+"\n"+"1.oyuncunun kalan altin miktari="+oyuncu.get(1).altin_sayisi+"\n"+"2.oyuncunun kalan altin miktari="+oyuncu.get(2).altin_sayisi+"\n"+"3.oyuncunun kalan altin miktari="+oyuncu.get(3).altin_sayisi;
                for(int i=0;i<=3;i++)
                    mesaj+=i+".oyuncunun kalan altin miktari="+oyuncu.get(i).altin_sayisi+"\n "+i+".oyuncunun toplam adım sayısı="+oyuncu.get(i).toplam_adim_sayisi+"\n "+i+".oyuncunun toplanan altin sayisi="+oyuncu.get(i).toplanan_altin+"\n"+i+".oyuncunun harcanan altin sayisi="+oyuncu.get(i).harcanan_altin+"\n";
                JOptionPane.showMessageDialog (null, mesaj, "Title", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);


            }

            if(oyuncu.get(oyuncu_sira).adim_sayisi==adim_sayisi) {
                oyuncu.get(oyuncu_sira).altin_sayisi-=5;
                oyuncu.get(oyuncu_sira).harcanan_altin-=5;
                oyuncu.get(oyuncu_sira).adim_sayisi=0;
                oyuncu_sira++;
            }

            if(oyuncu_sira==4)
                oyuncu_sira=0;

            if(altinlar.indexOf(oyuncu.get(oyuncu_sira).hedef_altin)==-1)
                oyuncu.get(oyuncu_sira).hedef_var=false;

            if(oyuncu.get(oyuncu_sira).hedef_var==true) {

                boolean hareket_edildi=false;

                if(oyuncu.get(oyuncu_sira).getKonum_x()>oyuncu.get(oyuncu_sira).hedef_altin.konum_x) {

                    File file=new File(oyuncu_sira+".oyuncu.txt");
                    try {
                        FileWriter fw=new FileWriter(file,true);
                        PrintWriter pw=new PrintWriter(fw);
                        pw.println("konum_x="+oyuncu.get(oyuncu_sira).getKonum_x()+",konum_y="+oyuncu.get(oyuncu_sira).getKonum_y()+"---->"+"konum_x="+Integer.toString(oyuncu.get(oyuncu_sira).getKonum_x()-1)+",konum_y="+oyuncu.get(oyuncu_sira).getKonum_y());
                        pw.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }


                    oyuncu.get(oyuncu_sira).setKonum_x(oyuncu.get(oyuncu_sira).getKonum_x()-1);
                    hareket_edildi=true;
                    oyuncu.get(oyuncu_sira).adim_sayisi++;
                    oyuncu.get(oyuncu_sira).toplam_adim_sayisi++;

                    for(int i=0;i<altinlar.size();i++) {

                        if(altinlar.get(i).gizli==false&&oyuncu.get(oyuncu_sira).getKonum_x()==altinlar.get(i).konum_x&&oyuncu.get(oyuncu_sira).getKonum_y()==altinlar.get(i).konum_y&&!altinlar.get(i).equals(oyuncu.get(oyuncu_sira).hedef_altin)) {
                            oyuncu.get(oyuncu_sira).altin_sayisi+=altinlar.get(i).altin_miktari;
                            oyuncu.get(oyuncu_sira).toplanan_altin+=altinlar.get(i).altin_miktari;
                            altinlar.remove(i);
                        }
                    }




                    for(int i=0;i<altinlar.size();i++) {

                        if(altinlar.get(i).gizli==true&&oyuncu.get(oyuncu_sira).getKonum_x()==altinlar.get(i).konum_x&&oyuncu.get(oyuncu_sira).getKonum_y()==altinlar.get(i).konum_y)
                            altinlar.get(i).gizli=false;
                    }
                    repaint();

                }
                if(oyuncu.get(oyuncu_sira).getKonum_x()<oyuncu.get(oyuncu_sira).hedef_altin.konum_x&&hareket_edildi==false) {

                    File file=new File(oyuncu_sira+".oyuncu.txt");
                    try {
                        FileWriter fw=new FileWriter(file,true);
                        PrintWriter pw=new PrintWriter(fw);
                        pw.println("konum_x="+oyuncu.get(oyuncu_sira).getKonum_x()+",konum_y="+oyuncu.get(oyuncu_sira).getKonum_y()+"---->"+"konum_x="+Integer.toString(oyuncu.get(oyuncu_sira).getKonum_x()+1)+",konum_y="+oyuncu.get(oyuncu_sira).getKonum_y());
                        pw.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }


                    oyuncu.get(oyuncu_sira).setKonum_x(oyuncu.get(oyuncu_sira).getKonum_x()+1);
                    hareket_edildi=true;
                    oyuncu.get(oyuncu_sira).adim_sayisi++;
                    oyuncu.get(oyuncu_sira).toplam_adim_sayisi++;

                    for(int i=0;i<altinlar.size();i++) {

                        if(altinlar.get(i).gizli==false&&oyuncu.get(oyuncu_sira).getKonum_x()==altinlar.get(i).konum_x&&oyuncu.get(oyuncu_sira).getKonum_y()==altinlar.get(i).konum_y&&!altinlar.get(i).equals(oyuncu.get(oyuncu_sira).hedef_altin)) {
                            oyuncu.get(oyuncu_sira).altin_sayisi+=altinlar.get(i).altin_miktari;
                            oyuncu.get(oyuncu_sira).toplanan_altin+=altinlar.get(i).altin_miktari;
                            altinlar.remove(i);
                        }
                    }


                    for(int i=0;i<altinlar.size();i++) {

                        if(altinlar.get(i).gizli==true&&oyuncu.get(oyuncu_sira).getKonum_x()==altinlar.get(i).konum_x&&oyuncu.get(oyuncu_sira).getKonum_y()==altinlar.get(i).konum_y)
                            altinlar.get(i).gizli=false;
                    }
                    repaint();

                }
                if(oyuncu.get(oyuncu_sira).getKonum_y()<oyuncu.get(oyuncu_sira).hedef_altin.konum_y&&hareket_edildi==false) {

                    File file=new File(oyuncu_sira+".oyuncu.txt");
                    try {
                        FileWriter fw=new FileWriter(file,true);
                        PrintWriter pw=new PrintWriter(fw);
                        pw.println("konum_x="+oyuncu.get(oyuncu_sira).getKonum_x()+",konum_y="+oyuncu.get(oyuncu_sira).getKonum_y()+"---->"+"konum_x="+oyuncu.get(oyuncu_sira).getKonum_x()+",konum_y="+Integer.toString(oyuncu.get(oyuncu_sira).getKonum_y()+1));
                        pw.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }


                    oyuncu.get(oyuncu_sira).setKonum_y(oyuncu.get(oyuncu_sira).getKonum_y()+1);
                    hareket_edildi=true;
                    oyuncu.get(oyuncu_sira).adim_sayisi++;
                    oyuncu.get(oyuncu_sira).toplam_adim_sayisi++;

                    for(int i=0;i<altinlar.size();i++) {

                        if(altinlar.get(i).gizli==false&&oyuncu.get(oyuncu_sira).getKonum_x()==altinlar.get(i).konum_x&&oyuncu.get(oyuncu_sira).getKonum_y()==altinlar.get(i).konum_y&&!altinlar.get(i).equals(oyuncu.get(oyuncu_sira).hedef_altin)) {
                            oyuncu.get(oyuncu_sira).altin_sayisi+=altinlar.get(i).altin_miktari;
                            oyuncu.get(oyuncu_sira).toplanan_altin+=altinlar.get(i).altin_miktari;
                            altinlar.remove(i);
                        }
                    }

                    for(int i=0;i<altinlar.size();i++) {

                        if(altinlar.get(i).gizli==true&&oyuncu.get(oyuncu_sira).getKonum_x()==altinlar.get(i).konum_x&&oyuncu.get(oyuncu_sira).getKonum_y()==altinlar.get(i).konum_y)
                            altinlar.get(i).gizli=false;
                    }
                    repaint();

                }
                if(oyuncu.get(oyuncu_sira).getKonum_y()>oyuncu.get(oyuncu_sira).hedef_altin.konum_y&&hareket_edildi==false) {

                    File file=new File(oyuncu_sira+".oyuncu.txt");
                    try {
                        FileWriter fw=new FileWriter(file,true);
                        PrintWriter pw=new PrintWriter(fw);
                        pw.println("konum_x="+oyuncu.get(oyuncu_sira).getKonum_x()+",konum_y="+oyuncu.get(oyuncu_sira).getKonum_y()+"---->"+"konum_x="+oyuncu.get(oyuncu_sira).getKonum_x()+",konum_y="+Integer.toString(oyuncu.get(oyuncu_sira).getKonum_y()-1));
                        pw.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }


                    oyuncu.get(oyuncu_sira).setKonum_y(oyuncu.get(oyuncu_sira).getKonum_y()-1);
                    hareket_edildi=true;
                    oyuncu.get(oyuncu_sira).adim_sayisi++;
                    oyuncu.get(oyuncu_sira).toplam_adim_sayisi++;

                    for(int i=0;i<altinlar.size();i++) {

                        if(altinlar.get(i).gizli==false&&oyuncu.get(oyuncu_sira).getKonum_x()==altinlar.get(i).konum_x&&oyuncu.get(oyuncu_sira).getKonum_y()==altinlar.get(i).konum_y&&!altinlar.get(i).equals(oyuncu.get(oyuncu_sira).hedef_altin)) {
                            oyuncu.get(oyuncu_sira).altin_sayisi+=altinlar.get(i).altin_miktari;
                            oyuncu.get(oyuncu_sira).toplanan_altin+=altinlar.get(i).altin_miktari;
                            altinlar.remove(i);
                        }
                    }

                    for(int i=0;i<altinlar.size();i++) {

                        if(altinlar.get(i).gizli==true&&oyuncu.get(oyuncu_sira).getKonum_x()==altinlar.get(i).konum_x&&oyuncu.get(oyuncu_sira).getKonum_y()==altinlar.get(i).konum_y)
                            altinlar.get(i).gizli=false;
                    }
                    repaint();

                }

                if(oyuncu.get(oyuncu_sira).getKonum_x()==oyuncu.get(oyuncu_sira).hedef_altin.konum_x&&oyuncu.get(oyuncu_sira).getKonum_y()==oyuncu.get(oyuncu_sira).hedef_altin.konum_y) {
                    //oyuncu.get(oyuncu_sira).setToplanan_altin(oyuncu.get(oyuncu_sira).getToplanan_altin()+oyuncu.get(oyuncu_sira).hedef_altin.altin_miktari);
                    System.out.println(oyuncu_sira+".tarafindan toplanmis altin:"+oyuncu.get(oyuncu_sira).hedef_altin.altin_miktari);
                    oyuncu.get(oyuncu_sira).altin_sayisi=oyuncu.get(oyuncu_sira).hedef_altin.altin_miktari+oyuncu.get(oyuncu_sira).altin_sayisi;
                    oyuncu.get(oyuncu_sira).toplanan_altin+=oyuncu.get(oyuncu_sira).hedef_altin.altin_miktari;
                    oyuncu.get(oyuncu_sira).altin_sayisi=oyuncu.get(oyuncu_sira).altin_sayisi-5;
                    oyuncu.get(oyuncu_sira).harcanan_altin-=5;
                    altinlar.remove(altinlar.indexOf(oyuncu.get(oyuncu_sira).hedef_altin));
                    oyuncu.get(oyuncu_sira).hedef_var=false;
                    oyuncu.get(oyuncu_sira).adim_sayisi=0;
                    oyuncu_sira++;
                    repaint();
                }



            }

            if(oyuncu_sira==4)
                oyuncu_sira=0;


            if(altinlar.size()==0) {
                String mesaj=new String();
                //mesaj="0.oyuncunun kalan altin miktari="+oyuncu.get(0).altin_sayisi+"\n"+"1.oyuncunun kalan altin miktari="+oyuncu.get(1).altin_sayisi+"\n"+"2.oyuncunun kalan altin miktari="+oyuncu.get(2).altin_sayisi+"\n"+"3.oyuncunun kalan altin miktari="+oyuncu.get(3).altin_sayisi;
                for(int i=0;i<=3;i++)
                    mesaj+=i+".oyuncunun kalan altin miktari="+oyuncu.get(i).altin_sayisi+"\n "+i+".oyuncunun toplam adım sayısı="+oyuncu.get(i).toplam_adim_sayisi+"\n "+i+".oyuncunun toplanan altin sayisi="+oyuncu.get(i).toplanan_altin+"\n"+i+".oyuncunun harcanan altin sayisi="+oyuncu.get(i).harcanan_altin+"\n";
                JOptionPane.showMessageDialog (null, mesaj, "Title", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            if(oyuncu.get(0).elendi==false&&oyuncu.get(0).hedef_var==false) {

                ArrayList <Integer> uzaklik_index=new ArrayList<>();
                int i=0;
                while(i<altinlar.size()) {

                    if(altinlar.get(i).gizli==false)
                        uzaklik_index.add(Math.abs((oyuncu.get(0).getKonum_x()-altinlar.get(i).konum_x))+Math.abs((oyuncu.get(0).getKonum_y()-altinlar.get(i).konum_y)));
                    if(altinlar.get(i).gizli==true)
                        uzaklik_index.add(Integer.MAX_VALUE);
                    i++;
                }
                oyuncu.get(0).hedef_altin=altinlar.get(uzaklik_index.indexOf(Collections.min(uzaklik_index)));
                //System.out.println(oyuncu.get(0).hedef_altin.konum_x+" "+oyuncu.get(0).hedef_altin.konum_y);
                System.out.println("0.oyuncunun kalan altini="+oyuncu.get(0).altin_sayisi);
                oyuncu.get(0).hedef_var=true;
                oyuncu.get(0).altin_sayisi=oyuncu.get(0).altin_sayisi-5;
                oyuncu.get(0).harcanan_altin-=5;
                oyuncu.get(0).adim_sayisi=0;


            }

            if(oyuncu.get(1).elendi==false&&oyuncu.get(1).hedef_var==false) {

                ArrayList <Double> karlı_index=new ArrayList<>();
                int i=0;
                while(i<altinlar.size()) {

                    if(altinlar.get(i).gizli==false) {

                        double a=Math.ceil((Math.abs(oyuncu.get(1).getKonum_x()-altinlar.get(i).konum_x)+Math.abs(oyuncu.get(1).getKonum_y()-altinlar.get(i).konum_y))/(double)adim_sayisi);
                        karlı_index.add((double)altinlar.get(i).altin_miktari/a);

                    }if(altinlar.get(i).gizli==true)
                        karlı_index.add(Double.MIN_VALUE);
                    //System.out.println(karlı_index.get(i)+"--"+i);
                    i++;
                }

                System.out.println("hedef:"+karlı_index.indexOf(Collections.max(karlı_index)));
                oyuncu.get(1).hedef_altin=altinlar.get(karlı_index.indexOf(Collections.max(karlı_index)));
                //System.out.println(oyuncu.get(1).hedef_altin.konum_x+" "+oyuncu.get(1).hedef_altin.konum_y);
                System.out.println("1.oyuncunun kalan altini="+oyuncu.get(1).altin_sayisi);
                oyuncu.get(1).hedef_var=true;
                oyuncu.get(1).altin_sayisi=oyuncu.get(1).altin_sayisi-10;
                oyuncu.get(1).harcanan_altin-=10;
                oyuncu.get(1).adim_sayisi=0;


            }

            if(oyuncu.get(2).elendi==false&&oyuncu.get(2).hedef_var==false) {

                ArrayList <Double> karlı_index=new ArrayList<>();
                int i=0;
                int sayac=0;
                ArrayList <Integer> gizli_uzaklik=new ArrayList<>();
                ArrayList <Altin> gizli_altin=new ArrayList<>();
                int a=0;
                for(i=0;i<altinlar.size();i++) {

                    if(altinlar.get(i).gizli==true) {
                        gizli_uzaklik.add(Math.abs(oyuncu.get(2).getKonum_x()-altinlar.get(i).konum_x)+Math.abs(oyuncu.get(2).getKonum_y()-altinlar.get(i).konum_y));
                        gizli_altin.add(altinlar.get(i));
                        gizli_altin.get(a).uzaklik=Math.abs(oyuncu.get(2).getKonum_x()-altinlar.get(i).konum_x)+Math.abs(oyuncu.get(2).getKonum_y()-altinlar.get(i).konum_y);
                        a++;
                    }

                }

                Altin temp;

                for(i=1;i<gizli_altin.size();i++) {

                    for (int j=i;j>0;j--) {

                        if(gizli_altin.get(j).uzaklik<gizli_altin.get(j-1).uzaklik) {

                            Collections.swap(gizli_altin, j, j-1);

                        }

                    }


                }
                for(i=0;i<gizli_altin.size();i++)
                    System.out.println("uzaklık:  "+gizli_altin.get(i).uzaklik);

                for(i=0;i<altinlar.size();i++) {


                    if(gizli_altin.size()>0&&altinlar.get(i).equals(gizli_altin.get(0))&&sayac<2) {
                        altinlar.get(i).gizli=false;
                        gizli_altin.remove(0);
                        i=0;
                        sayac++;
                    }

                    if(sayac==2)
                        break;
                }



                repaint();

                i=0;
                while(i<altinlar.size()) {

                    if(altinlar.get(i).gizli==false)
                        karlı_index.add((double)altinlar.get(i).altin_miktari/Math.ceil((Math.abs(oyuncu.get(2).getKonum_x()-altinlar.get(i).konum_x)+Math.abs(oyuncu.get(2).getKonum_y()-altinlar.get(i).konum_y))/(double)adim_sayisi));
                    if(altinlar.get(i).gizli==true)
                        karlı_index.add((double)Integer.MIN_VALUE);
                    i++;
                }
                oyuncu.get(2).hedef_altin=altinlar.get(karlı_index.indexOf(Collections.max(karlı_index)));
                //System.out.println(oyuncu.get(2).hedef_altin.konum_x+" "+oyuncu.get(2).hedef_altin.konum_y);
                System.out.println("2.oyuncunun kalan altini="+oyuncu.get(2).altin_sayisi);
                oyuncu.get(2).hedef_var=true;
                oyuncu.get(2).altin_sayisi=oyuncu.get(2).altin_sayisi-15;
                oyuncu.get(2).harcanan_altin-=15;
                oyuncu.get(2).adim_sayisi=0;


            }

            if(oyuncu.get(3).elendi==false&&oyuncu.get(3).hedef_var==false) {

                ArrayList <Double> karlı_index=new ArrayList<>();
                int i=0;
                while(i<altinlar.size()) {

                    if(altinlar.get(i).gizli==false)
                        karlı_index.add((double)altinlar.get(i).altin_miktari/Math.ceil((Math.abs(oyuncu.get(3).getKonum_x()-altinlar.get(i).konum_x)+Math.abs(oyuncu.get(3).getKonum_y()-altinlar.get(i).konum_y))/(double)adim_sayisi));
                    if(altinlar.get(i).gizli==true)
                        karlı_index.add((double)Integer.MIN_VALUE);
                    i++;
                }
                oyuncu.get(3).hedef_altin=altinlar.get(karlı_index.indexOf(Collections.max(karlı_index)));
                //System.out.println(oyuncu.get(3).hedef_altin.konum_x+" "+oyuncu.get(3).hedef_altin.konum_y);
                //bu kisim yeni ekleniyor print kismina kadar yeni eklenmektedir..

                boolean problem_var=true;
                while(altinlar.size()>3&&problem_var==true) {

                    if(oyuncu.get(3).hedef_altin.equals(oyuncu.get(0).hedef_altin)) {

                        if(Math.ceil((Math.abs(oyuncu.get(3).getKonum_x()-oyuncu.get(3).hedef_altin.konum_x)+Math.abs(oyuncu.get(3).getKonum_y()-oyuncu.get(3).hedef_altin.konum_y))/(double)adim_sayisi)>=Math.ceil((Math.abs(oyuncu.get(0).getKonum_x()-oyuncu.get(0).hedef_altin.konum_x)+Math.abs(oyuncu.get(0).getKonum_y()-oyuncu.get(0).hedef_altin.konum_y)/(double)adim_sayisi))){

                            karlı_index.set(karlı_index.indexOf(Collections.max(karlı_index)),Double.MIN_VALUE);
                            oyuncu.get(3).hedef_altin=altinlar.get(karlı_index.indexOf(Collections.max(karlı_index)));

                        }else
                            problem_var=false;


                    }

                    if(oyuncu.get(3).hedef_altin.equals(oyuncu.get(1).hedef_altin)) {

                        if(Math.ceil((Math.abs(oyuncu.get(3).getKonum_x()-oyuncu.get(3).hedef_altin.konum_x)+Math.abs(oyuncu.get(3).getKonum_y()-oyuncu.get(3).hedef_altin.konum_y))/(double)adim_sayisi)>=Math.ceil((Math.abs(oyuncu.get(1).getKonum_x()-oyuncu.get(1).hedef_altin.konum_x)+Math.abs(oyuncu.get(1).getKonum_y()-oyuncu.get(1).hedef_altin.konum_y)/(double)adim_sayisi))){

                            karlı_index.set(karlı_index.indexOf(Collections.max(karlı_index)),Double.MIN_VALUE);
                            oyuncu.get(3).hedef_altin=altinlar.get(karlı_index.indexOf(Collections.max(karlı_index)));

                        }else
                            problem_var=false;


                    }

                    if(oyuncu.get(3).hedef_altin.equals(oyuncu.get(2).hedef_altin)) {

                        if(Math.ceil((Math.abs(oyuncu.get(3).getKonum_x()-oyuncu.get(3).hedef_altin.konum_x)+Math.abs(oyuncu.get(3).getKonum_y()-oyuncu.get(3).hedef_altin.konum_y))/(double)adim_sayisi)>=Math.ceil((Math.abs(oyuncu.get(2).getKonum_x()-oyuncu.get(2).hedef_altin.konum_x)+Math.abs(oyuncu.get(2).getKonum_y()-oyuncu.get(2).hedef_altin.konum_y)/(double)adim_sayisi))){

                            karlı_index.set(karlı_index.indexOf(Collections.max(karlı_index)),Double.MIN_VALUE);
                            oyuncu.get(3).hedef_altin=altinlar.get(karlı_index.indexOf(Collections.max(karlı_index)));

                        }else
                            problem_var=false;


                    }

                    if(!oyuncu.get(3).hedef_altin.equals(oyuncu.get(0).hedef_altin)&&!oyuncu.get(3).hedef_altin.equals(oyuncu.get(1).hedef_altin)&&!oyuncu.get(3).hedef_altin.equals(oyuncu.get(2).hedef_altin))
                        problem_var=false;



                }


                System.out.println("3.oyuncunun kalan altini="+oyuncu.get(3).altin_sayisi);
                oyuncu.get(3).hedef_var=true;
                oyuncu.get(3).altin_sayisi=oyuncu.get(3).altin_sayisi-20;
                oyuncu.get(3).harcanan_altin-=20;
                oyuncu.get(3).adim_sayisi=0;

            }






        }


    }


}