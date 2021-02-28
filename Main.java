package Package;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;






public class Main {

    public static int[][] altinlar ;
    public static JFrame frame;
    static int screen_x;
    static int screen_y;
    static int x=20;
    static int y=20;
    static int adim_sayisi=3;
    static int oyuncu_altin_sayisi=200;
    static int gizli_altin_orani=10;
    static int altin_orani=20;




    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable(){

            public void run() {


                for(int i=0;i<=3;i++) {

                    File file=new File(i+".oyuncu.txt");
                    try {
                        file.createNewFile();
                        FileWriter fw=new FileWriter(file,false);

                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }

                Main baslat=new Main();
                baslat.Giris_ekrani();

            }});




    }
    public void Giris_ekrani() {


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen_x=screenSize.width;
        screen_y=screenSize.height;


        frame = new JFrame("Altin_oyunu");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        JButton baslat=new JButton("baslat");
        JButton x_arttir=new JButton("+");
        JButton y_arttir=new JButton("+");
        JButton x_azalt=new JButton("-");
        JButton y_azalt=new JButton("-");
        JButton gizli_altin_arttir=new JButton("+");
        JButton gizli_altin_azalt=new JButton("-");
        JButton altin_arttir=new JButton("+");
        JButton altin_azalt=new JButton("-");
        JButton varsayilan_adim_sayisi_arttir=new JButton("+");
        JButton varsayilan_adim_sayisi_azalt=new JButton("-");
        JButton varsayilan_oyuncu_altin_sayisi_arttir=new JButton("+");
        JButton varsayilan_oyuncu_altin_sayisi_azalt=new JButton("-");

        JLabel y_sayisi = new JLabel("satir sayisi: 20");
        JLabel x_sayisi = new JLabel("sutun sayisi: 20");
        JLabel gizli_altin = new JLabel("gizli altin orani: %10");
        JLabel altin =new JLabel("altin orani: %20");
        JLabel varsayilan_adim_sayisi=new JLabel("varsayilan oyuncu adim sayisi: 3");
        JLabel varsayilan_oyuncu_altin_sayisi=new JLabel("varsayilan oyuncu altin sayisi: 200");

        y_sayisi.setFont(new Font("Gerogia", Font.PLAIN, 20));
        x_sayisi.setFont(new Font("Gerogia", Font.PLAIN, 20));
        gizli_altin.setFont(new Font("Gerogia",Font.PLAIN,20));
        altin.setFont(new Font("Gerogia",Font.PLAIN,20));
        varsayilan_adim_sayisi.setFont(new Font("Gerogia", Font.PLAIN, 20));
        varsayilan_oyuncu_altin_sayisi.setFont(new Font("Gerogia", Font.PLAIN, 20));
        y_sayisi.setForeground(Color.RED);
        x_sayisi.setForeground(Color.RED);
        x_sayisi.setForeground(Color.RED);
        gizli_altin.setForeground(Color.RED);
        altin.setForeground(Color.RED);
        varsayilan_adim_sayisi.setForeground(Color.RED);
        varsayilan_oyuncu_altin_sayisi.setForeground(Color.RED);


        x_sayisi.setBounds(screen_x/2-75,screen_y/2+100, 200, 50);
        y_sayisi.setBounds(screen_x/2-75,screen_y/2+140, 200, 50);
        x_arttir.setBounds(screen_x/2+100,screen_y/2+105,50,40);
        y_arttir.setBounds(screen_x/2+100,screen_y/2+140,50,40);
        x_azalt.setBounds(screen_x/2-160,screen_y/2+105,50,40);
        y_azalt.setBounds(screen_x/2-160 ,screen_y/2+140,50,40);

        gizli_altin.setBounds(screen_x/2-80,screen_y/2-200,400,50);
        gizli_altin_arttir.setBounds(screen_x/2+170,screen_y/2-200,50,40);
        gizli_altin_azalt.setBounds(screen_x/2-210,screen_y/2-200,50,40);

        altin.setBounds(screen_x/2-60,screen_y/2-250,400,50);
        altin_arttir.setBounds(screen_x/2+170,screen_y/2-250,50,40);
        altin_azalt.setBounds(screen_x/2-210,screen_y/2-250,50,40);

        varsayilan_adim_sayisi.setBounds(screen_x/2-150,screen_y/2-150, 400, 50);
        varsayilan_oyuncu_altin_sayisi.setBounds(screen_x/2-150,screen_y/2-100, 400, 50);
        varsayilan_adim_sayisi_arttir.setBounds(screen_x/2+170,screen_y/2-150,50,40);
        varsayilan_oyuncu_altin_sayisi_arttir.setBounds(screen_x/2+170,screen_y/2-100,50,40);
        varsayilan_adim_sayisi_azalt.setBounds(screen_x/2-210,screen_y/2-150,50,40);
        varsayilan_oyuncu_altin_sayisi_azalt.setBounds(screen_x/2-210,screen_y/2-100,50,40);



        panel.add(baslat);
        panel.add(x_arttir);
        panel.add(y_arttir);
        panel.add(x_azalt);
        panel.add(y_azalt);
        panel.add(x_sayisi);
        panel.add(y_sayisi);
        panel.add(gizli_altin);
        panel.add(gizli_altin_arttir);
        panel.add(gizli_altin_azalt);
        panel.add(altin);
        panel.add(altin_arttir);
        panel.add(altin_azalt);
        panel.add(varsayilan_adim_sayisi);
        panel.add(varsayilan_oyuncu_altin_sayisi);
        panel.add(varsayilan_oyuncu_altin_sayisi_arttir);
        panel.add(varsayilan_adim_sayisi_arttir);
        panel.add(varsayilan_oyuncu_altin_sayisi_azalt);
        panel.add(varsayilan_adim_sayisi_azalt);

        baslat.setBounds(screen_x/2-200, screen_y/2, 400, 60);
        baslat.setBackground(Color.BLACK);
        baslat.setForeground(Color.WHITE);
        x_arttir.setBackground(Color.BLACK);
        x_arttir.setForeground(Color.WHITE);
        y_arttir.setBackground(Color.BLACK);
        y_arttir.setForeground(Color.WHITE);
        x_azalt.setBackground(Color.BLACK);
        x_azalt.setForeground(Color.WHITE);
        y_azalt.setBackground(Color.BLACK);
        y_azalt.setForeground(Color.WHITE);
        gizli_altin_arttir.setBackground(Color.BLACK);
        gizli_altin_arttir.setForeground(Color.WHITE);
        gizli_altin_azalt.setBackground(Color.BLACK);
        gizli_altin_azalt.setForeground(Color.WHITE);
        altin_arttir.setBackground(Color.BLACK);
        altin_arttir.setForeground(Color.WHITE);
        altin_azalt.setBackground(Color.BLACK);
        altin_azalt.setForeground(Color.WHITE);
        varsayilan_adim_sayisi_arttir.setBackground(Color.BLACK);
        varsayilan_adim_sayisi_arttir.setForeground(Color.WHITE);
        varsayilan_oyuncu_altin_sayisi_arttir.setBackground(Color.BLACK);
        varsayilan_oyuncu_altin_sayisi_arttir.setForeground(Color.WHITE);
        varsayilan_adim_sayisi_azalt.setBackground(Color.BLACK);
        varsayilan_adim_sayisi_azalt.setForeground(Color.WHITE);
        varsayilan_oyuncu_altin_sayisi_azalt.setBackground(Color.BLACK);
        varsayilan_oyuncu_altin_sayisi_azalt.setForeground(Color.WHITE);

        panel.setBackground(Color.BLACK);
        frame.add(panel);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(0,0,screen_x,screen_y);

        x_arttir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                x++;
                x_sayisi.setText("sutun sayisi: "+x);



            }});

        y_arttir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                y++;
                y_sayisi.setText("satir sayisi: "+y);



            }});

        x_azalt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                x--;
                x_sayisi.setText("sutun sayisi: "+x);



            }});

        y_azalt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                y--;
                y_sayisi.setText("satir sayisi: "+y);



            }});

        altin_arttir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altin_orani++;
                altin.setText("altin orani % "+altin_orani);
            }});

        altin_azalt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altin_orani--;
                altin.setText("altin orani % "+ altin_orani);
            }});

        gizli_altin_arttir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gizli_altin_orani++;
                gizli_altin.setText("gizli altin orani % "+ gizli_altin_orani);


            }});


        gizli_altin_azalt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gizli_altin_orani--;
                gizli_altin.setText("gizli altin orani: % "+ gizli_altin_orani);

            }});


        varsayilan_adim_sayisi_arttir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                adim_sayisi++;
                varsayilan_adim_sayisi.setText("varsayilan oyuncu adim sayisi: "+adim_sayisi);



            }});

        varsayilan_adim_sayisi_azalt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                adim_sayisi--;
                varsayilan_adim_sayisi.setText("varsayilan oyuncu adim sayisi: "+adim_sayisi);



            }});

        varsayilan_oyuncu_altin_sayisi_arttir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                oyuncu_altin_sayisi+=10;
                varsayilan_oyuncu_altin_sayisi.setText("varsayilan oyuncu altin sayisi: "+oyuncu_altin_sayisi);



            }});

        varsayilan_oyuncu_altin_sayisi_azalt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                oyuncu_altin_sayisi-=10;
                varsayilan_oyuncu_altin_sayisi.setText("varsayilan oyuncu altin sayisi: "+oyuncu_altin_sayisi);



            }});


        baslat.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                ArrayList <Altin>altinlar =new ArrayList<>();

                ArrayList <Integer> sayilar=new ArrayList<Integer>();
                //altinlar=new int[y][x];

                sayilar=sayiAta(sayilar);
                Collections.sort(sayilar);
                System.out.println(sayilar);

                for(int i=0;i<sayilar.size();i++) {

                    int sutun=sayilar.get(i)%x;
                    int satir=(int)sayilar.get(i)/x;
                    // altinlar[satir][sutun]=1;
                    altinlar.add(new Altin());
                    altinlar.get(i).konum_x=sutun;
                    altinlar.get(i).konum_y=satir;
                    altinlar.get(i).altin_miktari=altin_Ata();
                    //System.out.println(altinlar.get(i).altin_miktari);

                }

                ArrayList <Integer> gizli_sayilar=new ArrayList<Integer>();
                gizli_sayilar=gizli_Yap(gizli_sayilar,altinlar);
                System.out.println(gizli_sayilar);
                for(int i=0;i<gizli_sayilar.size();i++)
                    altinlar.get(gizli_sayilar.get(i)).gizli=true;


                frame.setVisible(false);
                frame.setContentPane(new oyun(screen_x,screen_y,altinlar,x,y,oyuncu_altin_sayisi,adim_sayisi));
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setVisible(true);

            }});
    }


    public ArrayList sayiAta(ArrayList <Integer> sayilar) {

        boolean hata_var=false;
        int sayi=0;
        int random_sayi;
        random_sayi=(int)(Math.random() *(x*y-1)) + 1;
        while(sayi<sayilar.size()) {

            if(sayilar.get(sayi)==random_sayi)
                hata_var=true;

            sayi++;
        }

        if(hata_var==false&&random_sayi!=x*y-x&&random_sayi!=x*y-1&&random_sayi!=x-1)
            sayilar.add(random_sayi);

        if(sayilar.size()!=(x*y)*altin_orani/100)
            sayiAta(sayilar);

        return sayilar;

    }

    public int altin_Ata() {



        int  random_sayi=(int)(Math.random() *(20)) +1;

        if(random_sayi%5!=0) {
            return altin_Ata();
        }
        return random_sayi;




    }


    public ArrayList gizli_Yap(ArrayList <Integer> gizli_sayilar,ArrayList <Altin>altinlar) {

        int  random_sayi=(int)(Math.random() *(altinlar.size()));
        int sayi=0;
        boolean hata_var=false;


        while(sayi<gizli_sayilar.size()) {

            if(gizli_sayilar.get(sayi)==random_sayi)
                hata_var=true;

            sayi++;
        }

        if(hata_var==false)
            gizli_sayilar.add(random_sayi);


        if(gizli_sayilar.size()!=(int)Math.ceil(altinlar.size()*gizli_altin_orani/100.0)) {

            gizli_Yap(gizli_sayilar,altinlar);

        }


        return gizli_sayilar;

    }

}