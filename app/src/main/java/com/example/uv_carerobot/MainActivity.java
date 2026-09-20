package com.example.uv_carerobot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    // =====================================================
    // MENU LATERAL
    // =====================================================

    private DrawerLayout drawerLayout;
    private ImageButton btnMenu;

    private TextView menuPainel;
    private TextView menuMissoes;
    private TextView menuConfiguracoes;


    // =====================================================
    // BOTÕES
    // =====================================================

    private Button btnPower;
    private Button btnParadaSegura;
    private Button btnRetornarBase;


    // =====================================================
    // INFORMAÇÕES
    // =====================================================

    private TextView textStatus;
    private TextView textBateria;
    private TextView textLocal;
    private TextView textUvStatus;
    private TextView textConexao;


    // =====================================================
    // ESTADO DO ROBÔ
    // =====================================================

    private boolean roboLigado = false;


    // =====================================================
    // PREFERÊNCIAS
    // =====================================================

    private static final String PREFS = "uvcare_prefs";
    private static final String LEMBRAR_LOGIN = "lembrar_login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // =====================================================
        // MENU
        // =====================================================

        drawerLayout = findViewById(R.id.drawerLayout);
        btnMenu = findViewById(R.id.btnMenu);

        menuPainel = findViewById(R.id.menuPainel);
        menuMissoes = findViewById(R.id.menuMissoes);
        menuConfiguracoes = findViewById(R.id.menuConfiguracoes);


        // =====================================================
        // BOTÃO DOS 3 RISCOS
        // =====================================================

        btnMenu.setOnClickListener(v -> {

            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

                drawerLayout.closeDrawer(GravityCompat.START);

            } else {

                drawerLayout.openDrawer(GravityCompat.START);
            }

        });


        // =====================================================
        // PAINEL DE CONTROLE
        // =====================================================

        menuPainel.setOnClickListener(v -> {

            drawerLayout.closeDrawer(GravityCompat.START);

        });


        // =====================================================
        // MISSÕES
        // =====================================================

        menuMissoes.setOnClickListener(v -> {

            drawerLayout.closeDrawer(GravityCompat.START);

            Intent intent = new Intent(
                    MainActivity.this,
                    Tela_Missoes.class
            );

            startActivity(intent);

        });


        // =====================================================
        // CONFIGURAÇÕES
        // =====================================================

        menuConfiguracoes.setOnClickListener(v -> {

            drawerLayout.closeDrawer(GravityCompat.START);

            Intent intent = new Intent(
                    MainActivity.this,
                    Tela_Configuracoes.class
            );

            startActivity(intent);

        });


        // =====================================================
        // ELEMENTOS DO PAINEL
        // =====================================================

        btnPower = findViewById(R.id.btnPower);
        btnParadaSegura = findViewById(R.id.btnParadaSegura);
        btnRetornarBase = findViewById(R.id.btnRetornarBase);

        textStatus = findViewById(R.id.textStatus);
        textBateria = findViewById(R.id.textBateria);
        textLocal = findViewById(R.id.textLocal);
        textUvStatus = findViewById(R.id.textUvStatus);
        textConexao = findViewById(R.id.textConexao);


        // =====================================================
        // INFORMAÇÕES INICIAIS
        // =====================================================

        textBateria.setText("--%");
        textLocal.setText("Ala A · Leito 01");
        textUvStatus.setText("Desligada");
        textConexao.setText("● Robô conectado");


        // =====================================================
        // BOTÃO LIGAR / DESLIGAR
        // =====================================================

        btnPower.setOnClickListener(v -> {

            roboLigado = !roboLigado;

            atualizarInterface();

        });


        // =====================================================
        // PARADA SEGURA
        // =====================================================

        btnParadaSegura.setOnClickListener(v -> {

            roboLigado = false;

            textStatus.setText("Parada de emergência");

            textUvStatus.setText("Desligada");

            btnPower.setText("Ligar robô");

            btnPower.setBackgroundTintList(
                    ColorStateList.valueOf(
                            Color.parseColor("#2196F3")
                    )
            );

        });


        // =====================================================
        // RETORNAR À BASE
        // =====================================================

        btnRetornarBase.setOnClickListener(v -> {

            roboLigado = false;

            textStatus.setText("Retornando à base");

            textUvStatus.setText("Desligada");

            btnPower.setText("Ligar robô");

            btnPower.setBackgroundTintList(
                    ColorStateList.valueOf(
                            Color.parseColor("#2196F3")
                    )
            );

        });


        // =====================================================
        // BOTÃO VOLTAR DO ANDROID
        // =====================================================

        getOnBackPressedDispatcher().addCallback(
                this,
                new OnBackPressedCallback(true) {

                    @Override
                    public void handleOnBackPressed() {

                        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

                            drawerLayout.closeDrawer(GravityCompat.START);

                        } else {

                            setEnabled(false);

                            getOnBackPressedDispatcher()
                                    .onBackPressed();
                        }
                    }
                }
        );


        // =====================================================
        // ESTADO INICIAL
        // =====================================================

        atualizarInterface();
    }


    // =========================================================
    // ATUALIZA INTERFACE
    // =========================================================

    private void atualizarInterface() {

        if (roboLigado) {

            textStatus.setText("Ligado");

            textUvStatus.setText("Desligada");

            btnPower.setText("Desligar robô");

            btnPower.setBackgroundTintList(
                    ColorStateList.valueOf(
                            Color.parseColor("#F44336")
                    )
            );

        } else {

            textStatus.setText("Em espera");

            textUvStatus.setText("Desligada");

            btnPower.setText("Ligar robô");

            btnPower.setBackgroundTintList(
                    ColorStateList.valueOf(
                            Color.parseColor("#2196F3")
                    )
            );
        }
    }


    // =========================================================
    // CONTROLE DO LEMBRAR LOGIN
    // =========================================================

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences preferences =
                getSharedPreferences(
                        PREFS,
                        MODE_PRIVATE
                );

        boolean lembrarLogin =
                preferences.getBoolean(
                        LEMBRAR_LOGIN,
                        false
                );

        if (!lembrarLogin) {

            FirebaseAuth
                    .getInstance()
                    .signOut();
        }
    }
}