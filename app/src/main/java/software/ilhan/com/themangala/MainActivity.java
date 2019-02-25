package software.ilhan.com.themangala;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    ImageButton b6;
    ImageButton a1;
    ImageButton a2;
    ImageButton a3;
    ImageButton a4;
    ImageButton a5;
    ImageButton a6;
    Button h1;
    Button h2;
    Button btnOK;
    ImageButton reset;
    TextView txtTurn;
    TextView textView;

    TextView txt_a1;
    TextView txt_a2;
    TextView txt_a3;
    TextView txt_a4;
    TextView txt_a5;
    TextView txt_a6;

    TextView txt_b1;
    TextView txt_b2;
    TextView txt_b3;
    TextView txt_b4;
    TextView txt_b5;
    TextView txt_b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 27.01.2019 Firebase ile 2 kişilik yap

        h1 = (Button) findViewById(R.id.h1);
        h2 = (Button) findViewById(R.id.h2);
        btnOK = (Button) findViewById(R.id.btnOK);

        b1 = (ImageButton) findViewById(R.id.b1);
        b2 = (ImageButton) findViewById(R.id.b2);
        b3 = (ImageButton) findViewById(R.id.b3);
        b4 = (ImageButton) findViewById(R.id.b4);
        b5 = (ImageButton) findViewById(R.id.b5);
        b6 = (ImageButton) findViewById(R.id.b6);
        a1 = (ImageButton) findViewById(R.id.a1);
        a2 = (ImageButton) findViewById(R.id.a2);
        a3 = (ImageButton) findViewById(R.id.a3);
        a4 = (ImageButton) findViewById(R.id.a4);
        a5 = (ImageButton) findViewById(R.id.a5);
        a6 = (ImageButton) findViewById(R.id.a6);
        reset = (ImageButton) findViewById(R.id.reset);
        txtTurn = (TextView) findViewById(R.id.txtTurn);
        textView = (TextView) findViewById(R.id.textView);

        txt_a1 = (TextView) findViewById(R.id.txt_a1);
        txt_a2 = (TextView) findViewById(R.id.txt_a2);
        txt_a3 = (TextView) findViewById(R.id.txt_a3);
        txt_a4 = (TextView) findViewById(R.id.txt_a4);
        txt_a5 = (TextView) findViewById(R.id.txt_a5);
        txt_a6 = (TextView) findViewById(R.id.txt_a6);

        txt_b1 = (TextView) findViewById(R.id.txt_b1);
        txt_b2 = (TextView) findViewById(R.id.txt_b2);
        txt_b3 = (TextView) findViewById(R.id.txt_b3);
        txt_b4 = (TextView) findViewById(R.id.txt_b4);
        txt_b5 = (TextView) findViewById(R.id.txt_b5);
        txt_b6 = (TextView) findViewById(R.id.txt_b6);

        int A1 = 4;
        int A2 = 4;
        int A3 = 4;
        int A4 = 4;
        int A5 = 4;
        int A6 = 4;
        int H1 = 0;
        int B1 = 4;
        int B2 = 4;
        int B3 = 4;
        int B4 = 4;
        int B5 = 4;
        int B6 = 4;
        int H2 = 0;

        final int Kuyular[] = {A1, A2, A3, A4, A5, A6, H1, B1, B2, B3, B4, B5, B6, H2};

        final String[] oyuncu_a = {""};
        final String[] oyuncu_b = {""};

        final boolean[] oyuncu_a_nin_sirasi = {true};
        final boolean[] oyuncu_b_nin_sirasi = {false};

////////////////////////////////////////////////////////////////////////////////////////////////////

        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText txtOyuncu1 = (EditText) promptView.findViewById(R.id.txtOyuncu1);
        final EditText txtOyuncu2 = (EditText) promptView.findViewById(R.id.txtOyuncu2);


        // setup a dialog window
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                oyuncu_a[0] = txtOyuncu1.getText().toString();
                oyuncu_b[0] = txtOyuncu2.getText().toString();
                txtTurn.setText("Hamle Sırası: " + oyuncu_a[0] + " başlıyor...");
//                        Toast.makeText(getApplicationContext(),"Oyuncu1: "+oyuncu_a+" / Oyuncu2: "+oyuncu_b, Toast.LENGTH_LONG).show();
                Log.i("input_control", "Oyuncu1: "+oyuncu_a+" / Oyuncu2: "+oyuncu_b);
            }
        });
// buraya taş saklama diyaloğu ekle oyuncu_a bilemezse oyuncu a ve byi değiştir.
        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();


////////////////////////////////////////////////////////////////////////////////////////////////////

        h1.setEnabled(false);
        h2.setEnabled(false);

        btnOK.setEnabled(false);

        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        txtTurn.setText("Hamle Sırası: " + oyuncu_a[0] + " başlıyor...");

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Uyarı");
                builder.setMessage("Oyunu yeniden başlatmak istiyor musunuz?");
//                builder.setCancelable(false);
                builder.setNegativeButton("Hayır", null);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Kuyular[0] = 4;
                        Kuyular[1] = 4;
                        Kuyular[2] = 4;
                        Kuyular[3] = 4;
                        Kuyular[4] = 4;
                        Kuyular[5] = 4;
                        Kuyular[6] = 0;

                        Kuyular[7] = 4;
                        Kuyular[8] = 4;
                        Kuyular[9] = 4;
                        Kuyular[10] = 4;
                        Kuyular[11] = 4;
                        Kuyular[12] = 4;
                        Kuyular[13] = 0;
                        txtTurn.setText("Hamle Sırası: " + oyuncu_a[0] + " başlıyor...");
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        b5.setEnabled(false);
                        b6.setEnabled(false);

                        a1.setEnabled(true);
                        a2.setEnabled(true);
                        a3.setEnabled(true);
                        a4.setEnabled(true);
                        a5.setEnabled(true);
                        a6.setEnabled(true);
                        set_boardImage(Kuyular,b1,b2, b3, b4, b5, b6, a1, a2, a3, a4, a5, a6);
                        set_boardText(Kuyular, txt_b1,txt_b2,txt_b3,txt_b4,txt_b5,txt_b6,txt_a1,txt_a2,txt_a3,txt_a4,txt_a5,txt_a6, h1, h2);
                        change_textColor("#00FF7F", txt_a1, txt_a2, txt_a3, txt_a4, txt_a5, txt_a6);
                        change_textColor("#000000", txt_b1, txt_b2, txt_b3, txt_b4, txt_b5, txt_b6);
                        Toast.makeText(getApplicationContext(),"Oyun Sıfırlandı", Toast.LENGTH_LONG).show();

                    }
                });
                builder.show();
            }
        });

//        reset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Kuyular[0] = 4;
//                Kuyular[1] = 4;
//                Kuyular[2] = 4;
//                Kuyular[3] = 4;
//                Kuyular[4] = 4;
//                Kuyular[5] = 4;
//                Kuyular[6] = 0;
//                Kuyular[7] = 4;
//                Kuyular[8] = 4;
//                Kuyular[9] = 4;
//                Kuyular[10] = 4;
//                Kuyular[11] = 4;
//                Kuyular[12] = 4;
//                Kuyular[13] = 0;
//                txtTurn.setText("Hamle Sırası:  oyuncu a başlıyor...");
//                set_board(Kuyular,b1,b2, b3, b4, b5, b6, a1, a2, a3, a4, a5, a6, h1, h2);            }
//        });

//        Scanner input = new Scanner(System.in);
//        System.out.println("Oyuncu1 adını gir:");
//        String oyuncu1 = input.nextLine();
//        System.out.println("Oyuncu2 adını gir:");
//        String oyuncu2 = input.nextLine();
//
//        System.out.println(oyuncu1 + " taş hangi elimde? (right veya left girin.)");
//        String tas = input.nextLine();
//        String Right = "right";
//        String Left = "left";
//        if (tas.equals(Right)) {
//            System.out.println(oyuncu1 + " başlıyor...");
//            oyuncu_a = oyuncu1;
//            oyuncu_b = oyuncu2;
//        }
//        if (tas.equals(Left)) {
//            System.out.println(oyuncu2 + " başlıyor...");
//            oyuncu_b = oyuncu1;
//            oyuncu_a = oyuncu2;
//        }
//        if (!tas.equals(Left) && !tas.equals(Right)) {
//            System.out.println("Yanlış giriş; " + oyuncu2 + " başlıyor...");
//        }
//        String oyuncu1 = oyuncu_a;
//        String oyuncu2 = oyuncu_b;

        //int hamle = Integer.parseInt(txtHamle.getText().toString());

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(0));
                btnOK.setEnabled(true);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(1));
                btnOK.setEnabled(true);
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(2));
                btnOK.setEnabled(true);
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(3));
                btnOK.setEnabled(true);
            }
        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(4));
                btnOK.setEnabled(true);
            }
        });
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(5));
                btnOK.setEnabled(true);
            }
        });
//        h1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(String.valueOf(6));
//            }
//        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(7));
                btnOK.setEnabled(true);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(8));
                btnOK.setEnabled(true);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(9));
                btnOK.setEnabled(true);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(10));
                btnOK.setEnabled(true);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(11));
                btnOK.setEnabled(true);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(12));
                btnOK.setEnabled(true);
            }
        });
//        h2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(String.valueOf(13));
//            }
//        });

        //TODO "https://www.youtube.com/watch?v=GtxVILjLcw8"(multiple click listener) hint: for inside switch use just default colon
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                Log.d("method_hamle","Hamle bloğu başlangıcı" );
//                try{
                int hamle = Integer.parseInt(textView.getText().toString());
//                }
//                catch (java.lang.NumberFormatException)
//                }
                int hazinem = -1;
                int dusman_hazinesi = -1;
                int A_max = -1;
                int A_min = -1;
                int B_max = -1;
                int B_min = -1;
                String winner = " ";

                int eldeki_tas_sayisi = Kuyular[hamle];
                if (oyuncu_a_nin_sirasi[0]) {
                    Log.d("method_hamle","Sıra Oyuncu A'da" );
                    hazinem = 6;
                    dusman_hazinesi = 13;
                    A_max = 5;
                    A_min = 0;
                    B_max = 12;
                    B_min = 7;
                }
                if (oyuncu_b_nin_sirasi[0]) {
                    Log.d("method_hamle","Sıra Oyuncu B'de" );
                    hazinem = 13;
                    dusman_hazinesi = 6;
                    A_max = 12;
                    A_min = 7;
                    B_max = 5;
                    B_min = 0;
                }
                if (hamle != hazinem && Kuyular[hamle] != 0) { //TODO hamle != hazinem gerekli değil

                    if (Kuyular[hamle] == 1) {
                        Log.d("method_hamle",",kuyuda bir taş var" );
                        Kuyular[hamle] = 0;
                        hamle++;
                        if (hamle == dusman_hazinesi){ hamle++;}  //taşlar dağıtırlırken düşman hazinesi atlanır
                        Kuyular[hamle] += 1;
                        set_boardImage(Kuyular,b1,b2, b3, b4, b5, b6, a1, a2, a3, a4, a5, a6);
                        set_boardText(Kuyular, txt_b1,txt_b2,txt_b3,txt_b4,txt_b5,txt_b6,txt_a1,txt_a2,txt_a3,txt_a4,txt_a5,txt_a6, h1, h2);

//                        Toast.makeText(getApplicationContext(),"Kuyudaki tek taş bir sonraki kuyuya atıldı.", Toast.LENGTH_LONG).show();
                    } else {
                        Log.d("method_hamle","normal hamle başlangıcı" );
                        Kuyular[hamle] = 0;
                        while (eldeki_tas_sayisi > 0) {
                            if (hamle == dusman_hazinesi){ hamle++;}  //taşlar dağıtırlırken düşman hazinesi atlanır
                            if (hamle > 13) {
                                hamle = 0;
                            }
                            Kuyular[hamle] += 1;
                            eldeki_tas_sayisi -= 1;
                            hamle++;
                            set_boardImage(Kuyular,b1,b2, b3, b4, b5, b6, a1, a2, a3, a4, a5, a6);
                            set_boardText(Kuyular, txt_b1,txt_b2,txt_b3,txt_b4,txt_b5,txt_b6,txt_a1,txt_a2,txt_a3,txt_a4,txt_a5,txt_a6, h1, h2);

                            //delay
                            //Thread.sleep(5);
                        }
                        hamle--; // döngüde son artırmayı telafi etmek için
//                        Toast.makeText(getApplicationContext(),"normal hamle", Toast.LENGTH_LONG).show();
                    }
                    int kuyu_of_son_tas = hamle;
                    oyuncu_a_nin_sirasi[0] = !oyuncu_a_nin_sirasi[0];
                    oyuncu_b_nin_sirasi[0] = !oyuncu_b_nin_sirasi[0];

                    if (B_max >= kuyu_of_son_tas && kuyu_of_son_tas >= B_min && (Kuyular[kuyu_of_son_tas]) % 2 == 0) {
//                    System.out.println("***Düşman kuyusu çiftlendi.");
                        Log.d("method_hamle","Düşman kuyusu çiftlendi.");
                        Toast.makeText(getApplicationContext(),"Düşman kuyusu çiftlendi.", Toast.LENGTH_LONG).show();
                        Kuyular[hazinem] = Kuyular[hazinem] + Kuyular[kuyu_of_son_tas];
                        Kuyular[kuyu_of_son_tas] = 0;
                    }

                    if (kuyu_of_son_tas != hazinem && Kuyular[(12 - kuyu_of_son_tas)] != 0 && Kuyular[kuyu_of_son_tas] == 1 && A_max >= kuyu_of_son_tas && kuyu_of_son_tas >= A_min) {  // Kuyu sıfırdaki bir taşı oynayınca:"Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1"
//                    System.out.println("boş dost kuyu dolduruldu");
                        Log.d("method_hamle","Boş kuyu dolduruldu.");
                        Toast.makeText(getApplicationContext(),"Boş kuyu dolduruldu.", Toast.LENGTH_LONG).show();
                        Kuyular[hazinem] += Kuyular[kuyu_of_son_tas];
                        Kuyular[kuyu_of_son_tas] = 0;
                        Kuyular[hazinem] += Kuyular[(12 - kuyu_of_son_tas)];
                        Kuyular[(12 - kuyu_of_son_tas)] = 0;   //12 sayısı yerine bişey koy onu da oyuncu sırasına göre değiştir
                    }
                    if (kuyu_of_son_tas == hazinem) {
//                    System.out.println("tebrikler bir hamle hakkı daha kazandınız, sıra hala sizde");
                        Log.d("method_hamle","Bir hamle hakkı daha kazandınız.");
                        Toast.makeText(getApplicationContext(),"Bir hamle hakkı daha kazandınız.", Toast.LENGTH_LONG).show();
                        oyuncu_a_nin_sirasi[0] = !oyuncu_a_nin_sirasi[0];
                        oyuncu_b_nin_sirasi[0] = !oyuncu_b_nin_sirasi[0];
                    }

                    if (((Kuyular[0] + Kuyular[1] + Kuyular[2] + Kuyular[3] + Kuyular[4] + Kuyular[5]) == 0) || ((Kuyular[7] + Kuyular[8] + Kuyular[9] + Kuyular[10] + Kuyular[11] + Kuyular[12]) == 0)){
//                    Toast.makeText(getApplicationContext(),"Tüm kuyular 0.", Toast.LENGTH_LONG).show();
                        Log.d("method_hamle","Oyun bitti" );

                        if (oyuncu_a_nin_sirasi[0]){ // so the turn already changed.
                            Log.d("method_hamle","A tarafında tüm kuyular 0." );
//                            Toast.makeText(getApplicationContext(),"A tarafında tüm kuyular 0.", Toast.LENGTH_LONG).show();
                            //TODO hazineye atma fonksiyonu ekle, zaten bir taraf sıfır olduğu için tümünü de atabilir tek tarafı da
                            Kuyular[6]+= Kuyular[7];
                            Kuyular[6]+= Kuyular[8];
                            Kuyular[6]+= Kuyular[9];
                            Kuyular[6]+= Kuyular[10];
                            Kuyular[6]+= Kuyular[11];
                            Kuyular[6]+= Kuyular[12];

                            Kuyular[7] = 0;
                            Kuyular[8] = 0;
                            Kuyular[9] = 0;
                            Kuyular[10] = 0;
                            Kuyular[11] = 0;
                            Kuyular[12] = 0;

//                            winner = oyuncu_b;

//                        System.out.println(oyuncu_a+" oyunu kazandı. Çıkmak için çıkışa tekrar oynamak için tekrar oynaya basın");
                        }
                        if (oyuncu_b_nin_sirasi[0]){ // so the turn already changed.
                            Log.d("method_hamle","B tarafında tüm kuyular 0." );
//                            Toast.makeText(getApplicationContext(),"B tarafında tüm kuyular 0.", Toast.LENGTH_LONG).show();
                            //TODO hazineye atma fonksiyonu ekle,
                            Kuyular[13]+= Kuyular[0];
                            Kuyular[13]+= Kuyular[1];
                            Kuyular[13]+= Kuyular[2];
                            Kuyular[13]+= Kuyular[3];
                            Kuyular[13]+= Kuyular[4];
                            Kuyular[13]+= Kuyular[5];

                            Kuyular[0] = 0;
                            Kuyular[1] = 0;
                            Kuyular[2] = 0;
                            Kuyular[3] = 0;
                            Kuyular[4] = 0;
                            Kuyular[5] = 0;

//                            winner = oyuncu_a;
//                        System.out.println(oyuncu_b+" oyunu kazandı. Çıkmak için çıkışa tekrar oynamak için tekrar oynaya basın");
                        }
                        Log.d("method_hamle","Tüm taşlar kazanan kuyuya atıldı, \nA:"+Kuyular[0]+","+Kuyular[1]+","+Kuyular[2]+","+Kuyular[3]+","+Kuyular[4]+","+Kuyular[5]+","+Kuyular[6]+ " ; \nB:"+Kuyular[7]+","+Kuyular[8]+","+Kuyular[9]+","+Kuyular[10]+","+Kuyular[11]+","+Kuyular[12]+","+Kuyular[13]);
                        if(Kuyular[6] > Kuyular[13]){winner = oyuncu_a[0];}
                        if (Kuyular[13] > Kuyular[6]){winner = oyuncu_b[0];}
                        if(Kuyular[6] == Kuyular[13]){winner = "Beraberlik";}

                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                        builder1.setTitle("Oyun Bitti");
                        builder1.setMessage("Tebrikler " + winner + " kazandı, " +Kuyular[13] +":"+Kuyular[6] );
                        builder1.setCancelable(false);
                        builder1.setNegativeButton("Çıkış", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //oyundan çıkılır
                                finish();
                                moveTaskToBack(true); // uygulama arka planda çalışmaya devam ediyor
//                                System.exit(0); uygulamayı kapatır
                                //Toast.makeText(getApplicationContext(),"Bu oyun bi harika dostum!", Toast.LENGTH_LONG).show();
                            }
                        });
                        builder1.setPositiveButton("Yeni Oyun", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // oyun sıfırlanır.
                                Kuyular[0] = 4;
                                Kuyular[1] = 4;
                                Kuyular[2] = 4;
                                Kuyular[3] = 4;
                                Kuyular[4] = 4;
                                Kuyular[5] = 4;
                                Kuyular[6] = 0;
                                Kuyular[7] = 4;
                                Kuyular[8] = 4;
                                Kuyular[9] = 4;
                                Kuyular[10] = 4;
                                Kuyular[11] = 4;
                                Kuyular[12] = 4;
                                Kuyular[13] = 0;
                                txtTurn.setText("Hamle Sırası: " + oyuncu_a[0] + " başlıyor...");
                                b1.setEnabled(false);
                                b2.setEnabled(false);
                                b3.setEnabled(false);
                                b4.setEnabled(false);
                                b5.setEnabled(false);
                                b6.setEnabled(false);

                                a1.setEnabled(true);
                                a2.setEnabled(true);
                                a3.setEnabled(true);
                                a4.setEnabled(true);
                                a5.setEnabled(true);
                                a6.setEnabled(true);
                                set_boardImage(Kuyular,b1,b2, b3, b4, b5, b6, a1, a2, a3, a4, a5, a6);
                                set_boardText(Kuyular, txt_b1,txt_b2,txt_b3,txt_b4,txt_b5,txt_b6,txt_a1,txt_a2,txt_a3,txt_a4,txt_a5,txt_a6, h1, h2);

                                Toast.makeText(getApplicationContext(),"Yeni Oyun Hazırlandı...", Toast.LENGTH_LONG).show();
                            }
                        });
                        builder1.show();
                    }

                } else {
//                System.out.println("Geçersiz kuyu seçimi!!!");
//                    txtTurn.setText("Geçersiz kuyu seçimi!!!");
                    Log.d("method_hamle","Geçersiz kuyu seçimi!!!");
                    Toast.makeText(getApplicationContext(),"Geçersiz kuyu seçimi!!!", Toast.LENGTH_LONG).show();
                }

                textView.setText(" "); // hamle yapılınca bir önceki hamle verisi silinir


//            System.out.format("╔════════════════════════════════╗\n");
                if (oyuncu_a_nin_sirasi[0]) {
//                System.out.println("   Oyuncu sırası: " + oyuncu_a);
                    txtTurn.setText("Hamle Sırası: " + oyuncu_a[0]);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);

                    a1.setEnabled(true);
                    a2.setEnabled(true);
                    a3.setEnabled(true);
                    a4.setEnabled(true);
                    a5.setEnabled(true);
                    a6.setEnabled(true);
                    change_textColor("#00FF7F", txt_a1, txt_a2, txt_a3, txt_a4, txt_a5, txt_a6);
                    change_textColor("#000000", txt_b1, txt_b2, txt_b3, txt_b4, txt_b5, txt_b6);
                    Log.d("method_hamle","Hamle sırası oyuncu A'ya geçirildi.");
                }
                if (oyuncu_b_nin_sirasi[0]) {
//                System.out.println("   Oyuncu sırası: " + oyuncu_b);
                    txtTurn.setText("Hamle Sırası: " + oyuncu_b[0]);
                    a1.setEnabled(false);
                    a2.setEnabled(false);
                    a3.setEnabled(false);
                    a4.setEnabled(false);
                    a5.setEnabled(false);
                    a6.setEnabled(false);

                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    change_textColor("#000000", txt_a1, txt_a2, txt_a3, txt_a4, txt_a5, txt_a6);
                    change_textColor("#00FF7F", txt_b1, txt_b2, txt_b3, txt_b4, txt_b5, txt_b6);
                    Log.d("method_hamle","Hamle sırası oyuncu B'ye geçirildi.");
                }
//            System.out.format("╚════════════════════════════════╝\n");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                set_boardImage(Kuyular,b1,b2, b3, b4, b5, b6, a1, a2, a3, a4, a5, a6);
                set_boardText(Kuyular, txt_b1,txt_b2,txt_b3,txt_b4,txt_b5,txt_b6,txt_a1,txt_a2,txt_a3,txt_a4,txt_a5,txt_a6, h1, h2);

                btnOK.setEnabled(false);
                Log.d("method_hamle","Hamle bloğu bitişi.");
            }
        });
//        print_board(Kuyular,b1,b2, b3, b4, b5, b6, a1, a2, a3, a4, a5, a6, h1, h2);
     }

    public static void set_buttonImage(ImageButton btn,int array[],int kuyu){
        if(array[kuyu] == 0){btn.setImageResource(R.drawable.zero);}
        if(array[kuyu] == 1){btn.setImageResource(R.drawable.one);}
        if(array[kuyu] == 2){btn.setImageResource(R.drawable.two);}
        if(array[kuyu] == 3){btn.setImageResource(R.drawable.three);}
        if(array[kuyu] == 4){btn.setImageResource(R.drawable.four);}
        if(array[kuyu] == 5){btn.setImageResource(R.drawable.five);}
        if(array[kuyu] == 6){btn.setImageResource(R.drawable.six);}
        if(array[kuyu] == 7){btn.setImageResource(R.drawable.seven);}
        if(array[kuyu] == 8){btn.setImageResource(R.drawable.eight);}
        if(array[kuyu] == 9){btn.setImageResource(R.drawable.nine);}
        if(array[kuyu] == 10){btn.setImageResource(R.drawable.ten);}
//        if(array[kuyu] == 11){btn.setImageResource(R.drawable.eleven);}
//        if(array[kuyu] == 12){btn.setImageResource(R.drawable.twelve);}
//        if(array[kuyu] == 13){btn.setImageResource(R.drawable.thirteen);}
//        if(array[kuyu] == 14){btn.setImageResource(R.drawable.fourteen);}
//        if(array[kuyu] == 15){btn.setImageResource(R.drawable.fiveteen);}
//        if(array[kuyu] == 16){btn.setImageResource(R.drawable.sixteen);}
//        if(array[kuyu] == 17){btn.setImageResource(R.drawable.seventeen);}
//        if(array[kuyu] == 18){btn.setImageResource(R.drawable.eightteen);}
//        if(array[kuyu] == 19){btn.setImageResource(R.drawable.nineteen);}
//        if(array[kuyu] == 20){btn.setImageResource(R.drawable.twenty);}
//        if(array[kuyu] == 21){btn.setImageResource(R.drawable.twenty_one);}
//        if(array[kuyu] == 22){btn.setImageResource(R.drawable.twenty_two);}
//        if(array[kuyu] == 23){btn.setImageResource(R.drawable.twenty_three);}
//        if(array[kuyu] == 24){btn.setImageResource(R.drawable.twenty_four);}
//        if(array[kuyu] == 25){btn.setImageResource(R.drawable.twenty_five);}
//        if(array[kuyu] == 26){btn.setImageResource(R.drawable.twenty_six);}
//        if(array[kuyu] == 27){btn.setImageResource(R.drawable.twenty_seven);}
//        if(array[kuyu] == 28){btn.setImageResource(R.drawable.twenty_eight);}
//        if(array[kuyu] == 29){btn.setImageResource(R.drawable.twenty_nine);}
//        if(array[kuyu] == 30){btn.setImageResource(R.drawable.thirty);}
//        if(array[kuyu] == 31){btn.setImageResource(R.drawable.thirty_one);}
//        if(array[kuyu] == 32){btn.setImageResource(R.drawable.thirty_two);}
//        if(array[kuyu] == 33){btn.setImageResource(R.drawable.thirty_three);}
//        if(array[kuyu] == 34){btn.setImageResource(R.drawable.thirty_four);}
//        if(array[kuyu] == 35){btn.setImageResource(R.drawable.thirty_five);}
//        if(array[kuyu] == 36){btn.setImageResource(R.drawable.thirty_six);}
//        if(array[kuyu] == 37){btn.setImageResource(R.drawable.thirty_seven);}
//        if(array[kuyu] == 38){btn.setImageResource(R.drawable.thirty_eight);}
//        if(array[kuyu] == 39){btn.setImageResource(R.drawable.thirty_nine);}
//        if(array[kuyu] == 40){btn.setImageResource(R.drawable.fourty);}
//        if(array[kuyu] == 41){btn.setImageResource(R.drawable.fourty_one);}
//        if(array[kuyu] == 42){btn.setImageResource(R.drawable.fourty_two);}
//        if(array[kuyu] == 43){btn.setImageResource(R.drawable.fourty_three);}
//        if(array[kuyu] == 44){btn.setImageResource(R.drawable.fourty_four);}
//        if(array[kuyu] == 45){btn.setImageResource(R.drawable.fourty_five);}
//        if(array[kuyu] == 46){btn.setImageResource(R.drawable.fourty_six);}
//        if(array[kuyu] == 47){btn.setImageResource(R.drawable.fourty_seven);}
//        if(array[kuyu] == 48){btn.setImageResource(R.drawable.fourty_eight);}




    }
    public static void set_boardImage(int array[],ImageButton b1,ImageButton b2,ImageButton b3,ImageButton b4,ImageButton b5,ImageButton b6,ImageButton a1,ImageButton a2,ImageButton a3,ImageButton a4,ImageButton a5,ImageButton a6/*,TextView textView*/) {
        // TODO: 28.01.2019 kuyularda 20den fazla taş biriktirmeyi engelle veya 40a kadar resim yap
//        h1.setText(String.valueOf(array[6]));
//        h2.setText(String.valueOf(array[13]));

        set_buttonImage(a1,array,0);
        set_buttonImage(a2,array,1);
        set_buttonImage(a3,array,2);
        set_buttonImage(a4,array,3);
        set_buttonImage(a5,array,4);
        set_buttonImage(a6,array,5);

        set_buttonImage(b1,array,7);
        set_buttonImage(b2,array,8);
        set_buttonImage(b3,array,9);
        set_buttonImage(b4,array,10);
        set_buttonImage(b5,array,11);
        set_buttonImage(b6,array,12);
//        if(array[0] == 0){a1.setImageResource(R.drawable.zero);}
//        if(array[0] == 1){a1.setImageResource(R.drawable.one);}
//        if(array[0] == 2){a1.setImageResource(R.drawable.two);}
//        if(array[0] == 3){a1.setImageResource(R.drawable.three);}
//        if(array[0] == 4){a1.setImageResource(R.drawable.four);}
//        if(array[0] == 5){a1.setImageResource(R.drawable.five);}
//        if(array[0] == 6){a1.setImageResource(R.drawable.six);}
//        if(array[0] == 7){a1.setImageResource(R.drawable.seven);}
//        if(array[0] == 8){a1.setImageResource(R.drawable.eight);}
//        if(array[0] == 9){a1.setImageResource(R.drawable.nine);}
//        if(array[0] == 10){a1.setImageResource(R.drawable.ten);}
//        if(array[0] == 11){a1.setImageResource(R.drawable.eleven);}
//        if(array[0] == 12){a1.setImageResource(R.drawable.twelve);}
//        if(array[0] == 13){a1.setImageResource(R.drawable.thirteen);}
//        if(array[0] == 14){a1.setImageResource(R.drawable.fourteen);}
//        if(array[0] == 15){a1.setImageResource(R.drawable.fiveteen);}
//        if(array[0] == 16){a1.setImageResource(R.drawable.sixteen);}
//        if(array[0] == 17){a1.setImageResource(R.drawable.seventeen);}
//        if(array[0] == 18){a1.setImageResource(R.drawable.eightteen);}
//        if(array[0] == 19){a1.setImageResource(R.drawable.nineteen);}
//        if(array[0] == 20){a1.setImageResource(R.drawable.twenty);}

//        if(array[1] == 0){a2.setImageResource(R.drawable.zero);}
//        if(array[1] == 1){a2.setImageResource(R.drawable.one);}
//        if(array[1] == 2){a2.setImageResource(R.drawable.two);}
//        if(array[1] == 3){a2.setImageResource(R.drawable.three);}
//        if(array[1] == 4){a2.setImageResource(R.drawable.four);}
//        if(array[1] == 5){a2.setImageResource(R.drawable.five);}
//        if(array[1] == 6){a2.setImageResource(R.drawable.six);}
//        if(array[1] == 7){a2.setImageResource(R.drawable.seven);}
//        if(array[1] == 8){a2.setImageResource(R.drawable.eight);}
//        if(array[1] == 9){a2.setImageResource(R.drawable.nine);}
//        if(array[1] == 10){a2.setImageResource(R.drawable.ten);}
//        if(array[1] == 11){a2.setImageResource(R.drawable.eleven);}
//        if(array[1] == 12){a2.setImageResource(R.drawable.twelve);}
//        if(array[1] == 13){a2.setImageResource(R.drawable.thirteen);}
//        if(array[1] == 14){a2.setImageResource(R.drawable.fourteen);}
//        if(array[1] == 15){a2.setImageResource(R.drawable.fiveteen);}
//        if(array[1] == 16){a2.setImageResource(R.drawable.sixteen);}
//        if(array[1] == 17){a2.setImageResource(R.drawable.seventeen);}
//        if(array[1] == 18){a2.setImageResource(R.drawable.eightteen);}
//        if(array[1] == 19){a2.setImageResource(R.drawable.nineteen);}
//        if(array[1] == 20){a2.setImageResource(R.drawable.twenty);}

//        if(array[2] == 0){a3.setImageResource(R.drawable.zero);}
//        if(array[2] == 1){a3.setImageResource(R.drawable.one);}
//        if(array[2] == 2){a3.setImageResource(R.drawable.two);}
//        if(array[2] == 3){a3.setImageResource(R.drawable.three);}
//        if(array[2] == 4){a3.setImageResource(R.drawable.four);}
//        if(array[2] == 5){a3.setImageResource(R.drawable.five);}
//        if(array[2] == 6){a3.setImageResource(R.drawable.six);}
//        if(array[2] == 7){a3.setImageResource(R.drawable.seven);}
//        if(array[2] == 8){a3.setImageResource(R.drawable.eight);}
//        if(array[2] == 9){a3.setImageResource(R.drawable.nine);}
//        if(array[2] == 10){a3.setImageResource(R.drawable.ten);}
//        if(array[2] == 11){a3.setImageResource(R.drawable.eleven);}
//        if(array[2] == 12){a3.setImageResource(R.drawable.twelve);}
//        if(array[2] == 13){a3.setImageResource(R.drawable.thirteen);}
//        if(array[2] == 14){a3.setImageResource(R.drawable.fourteen);}
//        if(array[2] == 15){a3.setImageResource(R.drawable.fiveteen);}
//        if(array[2] == 16){a3.setImageResource(R.drawable.sixteen);}
//        if(array[2] == 17){a3.setImageResource(R.drawable.seventeen);}
//        if(array[2] == 18){a3.setImageResource(R.drawable.eightteen);}
//        if(array[2] == 19){a3.setImageResource(R.drawable.nineteen);}
//        if(array[2] == 20){a3.setImageResource(R.drawable.twenty);}


//        if(array[3] == 0){a4.setImageResource(R.drawable.zero);}
//        if(array[3] == 1){a4.setImageResource(R.drawable.one);}
//        if(array[3] == 2){a4.setImageResource(R.drawable.two);}
//        if(array[3] == 3){a4.setImageResource(R.drawable.three);}
//        if(array[3] == 4){a4.setImageResource(R.drawable.four);}
//        if(array[3] == 5){a4.setImageResource(R.drawable.five);}
//        if(array[3] == 6){a4.setImageResource(R.drawable.six);}
//        if(array[3] == 7){a4.setImageResource(R.drawable.seven);}
//        if(array[3] == 8){a4.setImageResource(R.drawable.eight);}
//        if(array[3] == 9){a4.setImageResource(R.drawable.nine);}
//        if(array[3] == 10){a4.setImageResource(R.drawable.ten);}
//        if(array[3] == 11){a4.setImageResource(R.drawable.eleven);}
//        if(array[3] == 12){a4.setImageResource(R.drawable.twelve);}
//        if(array[3] == 13){a4.setImageResource(R.drawable.thirteen);}
//        if(array[3] == 14){a4.setImageResource(R.drawable.fourteen);}
//        if(array[3] == 15){a4.setImageResource(R.drawable.fiveteen);}
//        if(array[3] == 16){a4.setImageResource(R.drawable.sixteen);}
//        if(array[3] == 17){a4.setImageResource(R.drawable.seventeen);}
//        if(array[3] == 18){a4.setImageResource(R.drawable.eightteen);}
//        if(array[3] == 19){a4.setImageResource(R.drawable.nineteen);}
//        if(array[3] == 20){a4.setImageResource(R.drawable.twenty);}

//        if(array[4] == 0){a5.setImageResource(R.drawable.zero);}
//        if(array[4] == 1){a5.setImageResource(R.drawable.one);}
//        if(array[4] == 2){a5.setImageResource(R.drawable.two);}
//        if(array[4] == 3){a5.setImageResource(R.drawable.three);}
//        if(array[4] == 4){a5.setImageResource(R.drawable.four);}
//        if(array[4] == 5){a5.setImageResource(R.drawable.five);}
//        if(array[4] == 6){a5.setImageResource(R.drawable.six);}
//        if(array[4] == 7){a5.setImageResource(R.drawable.seven);}
//        if(array[4] == 8){a5.setImageResource(R.drawable.eight);}
//        if(array[4] == 9){a5.setImageResource(R.drawable.nine);}
//        if(array[4] == 10){a5.setImageResource(R.drawable.ten);}
//        if(array[4] == 11){a5.setImageResource(R.drawable.eleven);}
//        if(array[4] == 12){a5.setImageResource(R.drawable.twelve);}
//        if(array[4] == 13){a5.setImageResource(R.drawable.thirteen);}
//        if(array[4] == 14){a5.setImageResource(R.drawable.fourteen);}
//        if(array[4] == 15){a5.setImageResource(R.drawable.fiveteen);}
//        if(array[4] == 16){a5.setImageResource(R.drawable.sixteen);}
//        if(array[4] == 17){a5.setImageResource(R.drawable.seventeen);}
//        if(array[4] == 18){a5.setImageResource(R.drawable.eightteen);}
//        if(array[4] == 19){a5.setImageResource(R.drawable.nineteen);}
//        if(array[4] == 20){a5.setImageResource(R.drawable.twenty);}

//        if(array[5] == 0){a6.setImageResource(R.drawable.zero);}
//        if(array[5] == 1){a6.setImageResource(R.drawable.one);}
//        if(array[5] == 2){a6.setImageResource(R.drawable.two);}
//        if(array[5] == 3){a6.setImageResource(R.drawable.three);}
//        if(array[5] == 4){a6.setImageResource(R.drawable.four);}
//        if(array[5] == 5){a6.setImageResource(R.drawable.five);}
//        if(array[5] == 6){a6.setImageResource(R.drawable.six);}
//        if(array[5] == 7){a6.setImageResource(R.drawable.seven);}
//        if(array[5] == 8){a6.setImageResource(R.drawable.eight);}
//        if(array[5] == 9){a6.setImageResource(R.drawable.nine);}
//        if(array[5] == 10){a6.setImageResource(R.drawable.ten);}
//        if(array[5] == 11){a6.setImageResource(R.drawable.eleven);}
//        if(array[5] == 12){a6.setImageResource(R.drawable.twelve);}
//        if(array[5] == 13){a6.setImageResource(R.drawable.thirteen);}
//        if(array[5] == 14){a6.setImageResource(R.drawable.fourteen);}
//        if(array[5] == 15){a6.setImageResource(R.drawable.fiveteen);}
//        if(array[5] == 16){a6.setImageResource(R.drawable.sixteen);}
//        if(array[5] == 17){a6.setImageResource(R.drawable.seventeen);}
//        if(array[5] == 18){a6.setImageResource(R.drawable.eightteen);}
//        if(array[5] == 19){a6.setImageResource(R.drawable.nineteen);}
//        if(array[5] == 20){a6.setImageResource(R.drawable.twenty);}

//        if(array[7] == 0){b1.setImageResource(R.drawable.zero);}
//        if(array[7] == 1){b1.setImageResource(R.drawable.one);}
//        if(array[7] == 2){b1.setImageResource(R.drawable.two);}
//        if(array[7] == 3){b1.setImageResource(R.drawable.three);}
//        if(array[7] == 4){b1.setImageResource(R.drawable.four);}
//        if(array[7] == 5){b1.setImageResource(R.drawable.five);}
//        if(array[7] == 6){b1.setImageResource(R.drawable.six);}
//        if(array[7] == 7){b1.setImageResource(R.drawable.seven);}
//        if(array[7] == 8){b1.setImageResource(R.drawable.eight);}
//        if(array[7] == 9){b1.setImageResource(R.drawable.nine);}
//        if(array[7] == 10){b1.setImageResource(R.drawable.ten);}
//        if(array[7] == 11){b1.setImageResource(R.drawable.eleven);}
//        if(array[7] == 12){b1.setImageResource(R.drawable.twelve);}
//        if(array[7] == 13){b1.setImageResource(R.drawable.thirteen);}
//        if(array[7] == 14){b1.setImageResource(R.drawable.fourteen);}
//        if(array[7] == 15){b1.setImageResource(R.drawable.fiveteen);}
//        if(array[7] == 16){b1.setImageResource(R.drawable.sixteen);}
//        if(array[7] == 17){b1.setImageResource(R.drawable.seventeen);}
//        if(array[7] == 18){b1.setImageResource(R.drawable.eightteen);}
//        if(array[7] == 19){b1.setImageResource(R.drawable.nineteen);}
//        if(array[7] == 20){b1.setImageResource(R.drawable.twenty);}

//        if(array[8] == 0){b2.setImageResource(R.drawable.zero);}
//        if(array[8] == 1){b2.setImageResource(R.drawable.one);}
//        if(array[8] == 2){b2.setImageResource(R.drawable.two);}
//        if(array[8] == 3){b2.setImageResource(R.drawable.three);}
//        if(array[8] == 4){b2.setImageResource(R.drawable.four);}
//        if(array[8] == 5){b2.setImageResource(R.drawable.five);}
//        if(array[8] == 6){b2.setImageResource(R.drawable.six);}
//        if(array[8] == 7){b2.setImageResource(R.drawable.seven);}
//        if(array[8] == 8){b2.setImageResource(R.drawable.eight);}
//        if(array[8] == 9){b2.setImageResource(R.drawable.nine);}
//        if(array[8] == 10){b2.setImageResource(R.drawable.ten);}
//        if(array[8] == 11){b2.setImageResource(R.drawable.eleven);}
//        if(array[8] == 12){b2.setImageResource(R.drawable.twelve);}
//        if(array[8] == 13){b2.setImageResource(R.drawable.thirteen);}
//        if(array[8] == 14){b2.setImageResource(R.drawable.fourteen);}
//        if(array[8] == 15){b2.setImageResource(R.drawable.fiveteen);}
//        if(array[8] == 16){b2.setImageResource(R.drawable.sixteen);}
//        if(array[8] == 17){b2.setImageResource(R.drawable.seventeen);}
//        if(array[8] == 18){b2.setImageResource(R.drawable.eightteen);}
//        if(array[8] == 19){b2.setImageResource(R.drawable.nineteen);}
//        if(array[8] == 20){b2.setImageResource(R.drawable.twenty);}

//        if(array[9] == 0){b3.setImageResource(R.drawable.zero);}
//        if(array[9] == 1){b3.setImageResource(R.drawable.one);}
//        if(array[9] == 2){b3.setImageResource(R.drawable.two);}
//        if(array[9] == 3){b3.setImageResource(R.drawable.three);}
//        if(array[9] == 4){b3.setImageResource(R.drawable.four);}
//        if(array[9] == 5){b3.setImageResource(R.drawable.five);}
//        if(array[9] == 6){b3.setImageResource(R.drawable.six);}
//        if(array[9] == 7){b3.setImageResource(R.drawable.seven);}
//        if(array[9] == 8){b3.setImageResource(R.drawable.eight);}
//        if(array[9] == 9){b3.setImageResource(R.drawable.nine);}
//        if(array[9] == 10){b3.setImageResource(R.drawable.ten);}
//        if(array[9] == 11){b3.setImageResource(R.drawable.eleven);}
//        if(array[9] == 12){b3.setImageResource(R.drawable.twelve);}
//        if(array[9] == 13){b3.setImageResource(R.drawable.thirteen);}
//        if(array[9] == 14){b3.setImageResource(R.drawable.fourteen);}
//        if(array[9] == 15){b3.setImageResource(R.drawable.fiveteen);}
//        if(array[9] == 16){b3.setImageResource(R.drawable.sixteen);}
//        if(array[9] == 17){b3.setImageResource(R.drawable.seventeen);}
//        if(array[9] == 18){b3.setImageResource(R.drawable.eightteen);}
//        if(array[9] == 19){b3.setImageResource(R.drawable.nineteen);}
//        if(array[9] == 20){b3.setImageResource(R.drawable.twenty);}

//        if(array[10] == 0){b4.setImageResource(R.drawable.zero);}
//        if(array[10] == 1){b4.setImageResource(R.drawable.one);}
//        if(array[10] == 2){b4.setImageResource(R.drawable.two);}
//        if(array[10] == 3){b4.setImageResource(R.drawable.three);}
//        if(array[10] == 4){b4.setImageResource(R.drawable.four);}
//        if(array[10] == 5){b4.setImageResource(R.drawable.five);}
//        if(array[10] == 6){b4.setImageResource(R.drawable.six);}
//        if(array[10] == 7){b4.setImageResource(R.drawable.seven);}
//        if(array[10] == 8){b4.setImageResource(R.drawable.eight);}
//        if(array[10] == 9){b4.setImageResource(R.drawable.nine);}
//        if(array[10] == 10){b4.setImageResource(R.drawable.ten);}
//        if(array[10] == 11){b4.setImageResource(R.drawable.eleven);}
//        if(array[10] == 12){b4.setImageResource(R.drawable.twelve);}
//        if(array[10] == 13){b4.setImageResource(R.drawable.thirteen);}
//        if(array[10] == 14){b4.setImageResource(R.drawable.fourteen);}
//        if(array[10] == 15){b4.setImageResource(R.drawable.fiveteen);}
//        if(array[10] == 16){b4.setImageResource(R.drawable.sixteen);}
//        if(array[10] == 17){b4.setImageResource(R.drawable.seventeen);}
//        if(array[10] == 18){b4.setImageResource(R.drawable.eightteen);}
//        if(array[10] == 19){b4.setImageResource(R.drawable.nineteen);}
//        if(array[10] == 20){b4.setImageResource(R.drawable.twenty);}

//        if(array[11] == 0){b5.setImageResource(R.drawable.zero);}
//        if(array[11] == 1){b5.setImageResource(R.drawable.one);}
//        if(array[11] == 2){b5.setImageResource(R.drawable.two);}
//        if(array[11] == 3){b5.setImageResource(R.drawable.three);}
//        if(array[11] == 4){b5.setImageResource(R.drawable.four);}
//        if(array[11] == 5){b5.setImageResource(R.drawable.five);}
//        if(array[11] == 6){b5.setImageResource(R.drawable.six);}
//        if(array[11] == 7){b5.setImageResource(R.drawable.seven);}
//        if(array[11] == 8){b5.setImageResource(R.drawable.eight);}
//        if(array[11] == 9){b5.setImageResource(R.drawable.nine);}
//        if(array[11] == 10){b5.setImageResource(R.drawable.ten);}
//        if(array[11] == 11){b5.setImageResource(R.drawable.eleven);}
//        if(array[11] == 12){b5.setImageResource(R.drawable.twelve);}
//        if(array[11] == 13){b5.setImageResource(R.drawable.thirteen);}
//        if(array[11] == 14){b5.setImageResource(R.drawable.fourteen);}
//        if(array[11] == 15){b5.setImageResource(R.drawable.fiveteen);}
//        if(array[11] == 16){b5.setImageResource(R.drawable.sixteen);}
//        if(array[11] == 17){b5.setImageResource(R.drawable.seventeen);}
//        if(array[11] == 18){b5.setImageResource(R.drawable.eightteen);}
//        if(array[11] == 19){b5.setImageResource(R.drawable.nineteen);}
//        if(array[11] == 20){b5.setImageResource(R.drawable.twenty);}

//        if(array[12] == 0){b6.setImageResource(R.drawable.zero);}
//        if(array[12] == 1){b6.setImageResource(R.drawable.one);}
//        if(array[12] == 2){b6.setImageResource(R.drawable.two);}
//        if(array[12] == 3){b6.setImageResource(R.drawable.three);}
//        if(array[12] == 4){b6.setImageResource(R.drawable.four);}
//        if(array[12] == 5){b6.setImageResource(R.drawable.five);}
//        if(array[12] == 6){b6.setImageResource(R.drawable.six);}
//        if(array[12] == 7){b6.setImageResource(R.drawable.seven);}
//        if(array[12] == 8){b6.setImageResource(R.drawable.eight);}
//        if(array[12] == 9){b6.setImageResource(R.drawable.nine);}
//        if(array[12] == 10){b6.setImageResource(R.drawable.ten);}
//        if(array[12] == 11){b6.setImageResource(R.drawable.eleven);}
//        if(array[12] == 12){b6.setImageResource(R.drawable.twelve);}
//        if(array[12] == 13){b6.setImageResource(R.drawable.thirteen);}
//        if(array[12] == 14){b6.setImageResource(R.drawable.fourteen);}
//        if(array[12] == 15){b6.setImageResource(R.drawable.fiveteen);}
//        if(array[12] == 16){b6.setImageResource(R.drawable.sixteen);}
//        if(array[12] == 17){b6.setImageResource(R.drawable.seventeen);}
//        if(array[12] == 18){b6.setImageResource(R.drawable.eightteen);}
//        if(array[12] == 19){b6.setImageResource(R.drawable.nineteen);}
//        if(array[12] == 20){b6.setImageResource(R.drawable.twenty);}

//////////////////////////////////////////////////////////////////////////////////////////////////////

//        String image;
//        int hamle = 0;
//        if(hamle == 0){image = zero;}
//        if(hamle == 1){image = one;}
//        if(hamle == 2){image = two;}
//        if(hamle == 3){image = three;}
//        if(hamle == 4){image = four;}
//        if(hamle == 5){image = five;}
//        if(hamle == 6){image = six;}
//        if(hamle == 7){image = seven;}
//        if(hamle == 8){image = eight;}
//        if(hamle == 9){image = nine;}
//        if(hamle == 10){image = ten;}
//        if(hamle == 11){image = eleven;}
//        if(hamle == 12){image = twelve;}
//        if(hamle == 13){image = thirteen;}
//        a1.setImageResource(R.drawable.image);
//        a2.setImageResource(R.drawable.image);
//        a3.setImageResource(R.drawable.image);
//        a4.setImageResource(R.drawable.image);
//        a5.setImageResource(R.drawable.image);
//        a6.setImageResource(R.drawable.image);
//        h1.setImageResource(R.drawable.image);
//
//        b1.setImageResource(R.drawable.image);
//        b2.setImageResource(R.drawable.image);
//        b3.setImageResource(R.drawable.image);
//        b4.setImageResource(R.drawable.image);
//        b5.setImageResource(R.drawable.image);
//        b6.setImageResource(R.drawable.image);
//        h2.setImageResource(R.drawable.image);
    }
    public static void set_boardText(int array[],TextView txt_b1,TextView txt_b2,TextView txt_b3,TextView txt_b4,TextView txt_b5,TextView txt_b6,TextView txt_a1,TextView txt_a2,TextView txt_a3,TextView txt_a4,TextView txt_a5,TextView txt_a6,Button btn_h1,Button btn_h2) {
        txt_a1.setText(String.valueOf(array[0]));
        txt_a2.setText(String.valueOf(array[1]));
        txt_a3.setText(String.valueOf(array[2]));
        txt_a4.setText(String.valueOf(array[3]));
        txt_a5.setText(String.valueOf(array[4]));
        txt_a6.setText(String.valueOf(array[5]));
        btn_h1.setText(String.valueOf(array[6]));

        txt_b1.setText(String.valueOf(array[7]));
        txt_b2.setText(String.valueOf(array[8]));
        txt_b3.setText(String.valueOf(array[9]));
        txt_b4.setText(String.valueOf(array[10]));
        txt_b5.setText(String.valueOf(array[11]));
        txt_b6.setText(String.valueOf(array[12]));
        btn_h2.setText(String.valueOf(array[13]));
    }
    public static void change_textColor(String color, TextView txt_b1,TextView txt_b2,TextView txt_b3,TextView txt_b4,TextView txt_b5,TextView txt_b6){
//        if (name_color.equals(green)){color}
        // yeşil = "#00FF7F", siyah = "#000000"
        txt_b1.setTextColor(Color.parseColor(color));
        txt_b2.setTextColor(Color.parseColor(color));
        txt_b3.setTextColor(Color.parseColor(color));
        txt_b4.setTextColor(Color.parseColor(color));
        txt_b5.setTextColor(Color.parseColor(color));
        txt_b6.setTextColor(Color.parseColor(color));

    }
    /*public static void change_textColorA(String color,TextView txt_a1,TextView txt_a2,TextView txt_a3,TextView txt_a4,TextView txt_a5,TextView txt_a6){
        txt_a1.setTextColor(Color.parseColor(color));
        txt_a2.setTextColor(Color.parseColor(color));
        txt_a3.setTextColor(Color.parseColor(color));
        txt_a4.setTextColor(Color.parseColor(color));
        txt_a5.setTextColor(Color.parseColor(color));
        txt_a6.setTextColor(Color.parseColor(color));
    }*/
//    protected void showNameInputs() { //fonksiyon olarak denendi oyuncu_ ve b'ye değer atnamadı
//
//        // get prompts.xml view
//        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
//        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
//        alertDialogBuilder.setView(promptView);
//
////        alertDialogBuilder.setTitle("Uyarı");
////        alertDialogBuilder.setMessage("Oyunu yeniden başlatmak istiyor musunuz?");
//
////        final TextView txtTitle = (TextView) promptView.findViewById(R.id.txtTitle);
////        final TextView txtOyuncu = (TextView) promptView.findViewById(R.id.txtOyuncu);
//        final EditText txtOyuncu1 = (EditText) promptView.findViewById(R.id.txtOyuncu1);
//        final EditText txtOyuncu2 = (EditText) promptView.findViewById(R.id.txtOyuncu2);
//
//
//        // setup a dialog window
//        alertDialogBuilder.setCancelable(false);
//        alertDialogBuilder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        String oyuncu_1 = txtOyuncu1.getText().toString();
//                        String oyuncu_2 = txtOyuncu2.getText().toString();
//                        txtGamerOne.setText(oyuncu_1);
//                        txtGamerTwo.setText(oyuncu_2);
////                        Toast.makeText(getApplicationContext(),"Oyuncu1: "+oyuncu_a+" / Oyuncu2: "+oyuncu_b, Toast.LENGTH_LONG).show();
//                    }
//                });
////        oyuncu = editText.getText().toString();
////        alertDialogBuilder.setPositiveButton(positive_buttton, null);
////        Toast.makeText(getApplicationContext(),"Oyuncu1: "+txtOyuncu1.getText().toString()+" / Oyuncu2: "+txtOyuncu2.getText().toString(), Toast.LENGTH_LONG).show();
//        // create an alert dialog
//        AlertDialog alert = alertDialogBuilder.create();
//        alert.show();
//    }
}

    //TODO butonları false true yapan fonksiyon ekle
    //TODO oyunu sıfırlayan fonksiyon ekle


    /*public static void set_board(int array[],Button b1,Button b2,Button b3,Button b4,Button b5,Button b6,Button a1,Button a2,Button a3,Button a4,Button a5,Button a6,Button h1,Button h2) {
        a1.setText(String.valueOf(array[0]));
        a2.setText(String.valueOf(array[1]));
        a3.setText(String.valueOf(array[2]));
        a4.setText(String.valueOf(array[3]));
        a5.setText(String.valueOf(array[4]));
        a6.setText(String.valueOf(array[5]));
        h1.setText(String.valueOf(array[6]));

        b1.setText(String.valueOf(array[7]));
        b2.setText(String.valueOf(array[8]));
        b3.setText(String.valueOf(array[9]));
        b4.setText(String.valueOf(array[10]));
        b5.setText(String.valueOf(array[11]));
        b6.setText(String.valueOf(array[12]));
        h2.setText(String.valueOf(array[13]));
        }*/


//    public static void winner_kontrol(int array[]){
//    for (int kuyu: array) {
//        if (kuyu == 0){continue;}
//        else{break;}
//        Toast.makeText(getApplicationContext(),"Geçersiz kuyu seçimi!!!", Toast.LENGTH_LONG).show();
//    }
//}

