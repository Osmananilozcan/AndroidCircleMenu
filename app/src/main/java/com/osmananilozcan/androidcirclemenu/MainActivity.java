package com.osmananilozcan.androidcirclemenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity {

    /*İkonların isimleri için dizi oluşturalım.*/
    String arrayName[] = {"Facebook",
            "İnstagram",
            "Twitter",
            "Whatsapp",
            "Google+"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Java bağlantısını oluşturalım.*/
        CircleMenu circleMenu = findViewById(R.id.circle_menu);

        /*setMainMenu, ilk görünecek ikonu ve kapatma ikonunu gösteriyor.*/
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.ic_ekle, R.drawable.ic_sil) /*; yok dikkat edin!*/

                /*Tıklandığında gözükecek ikonları belirleyelim.*/
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.ic_facebook)
                .addSubMenu(Color.parseColor("#FF0000"), R.drawable.ic_instagram)
                .addSubMenu(Color.parseColor("#6d4c41"), R.drawable.ic_twitter)
                .addSubMenu(Color.parseColor("#FF0000"), R.drawable.ic_whatsapp)
                .addSubMenu(Color.parseColor("#FF0000"), R.drawable.ic_google_plus) /*; yok dikkat edin!*/


                /*Tıklandığında oluşacak olayları belirlemek için bir listener(dinleyici) ekleyelim.*/
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        /*Bu şekilde hangisine tıklanırsa yapılacak işlemleri ayarlayabilirsiniz.*/
                        switch (index) {
                            case 0:
                                Toast.makeText(MainActivity.this, "Facebook", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this, "İnstagram", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                    /*Menünün açılıp kapanmasında oluşacak olayları kontrol etmek için.*/
                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {
            @Override
            /*Menü açılırken yapılacak işlemler.*/
            public void onMenuOpened() {

            }

            @Override
            /*Menü kapanırken yapılacak işlemler.*/
            public void onMenuClosed() {

            }
        });
    }
}
