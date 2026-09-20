package com.example.uv_carerobot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.auth.FirebaseAuth;

public class Tela_Configuracoes extends AppCompatActivity {

    // =====================================================
    // MENU LATERAL
    // =====================================================

    private DrawerLayout drawerLayoutConfiguracoes;
    private ImageButton btnMenuConfiguracoes;

    private TextView menuPainelConfiguracoes;
    private TextView menuMissoesConfiguracoes;
    private TextView menuConfiguracoesAtual;


    // =====================================================
    // BOTÕES
    // =====================================================

    private Button btnSairConta;


    // =====================================================
    // PREFERÊNCIAS
    // =====================================================

    private static final String PREFS = "uvcare_prefs";
    private static final String LEMBRAR_LOGIN = "lembrar_login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_configuracoes);


        // =====================================================
        // MENU
        // =====================================================

        drawerLayoutConfiguracoes =
                findViewById(R.id.drawerLayoutConfiguracoes);

        btnMenuConfiguracoes =
                findViewById(R.id.btnMenuConfiguracoes);

        menuPainelConfiguracoes =
                findViewById(R.id.menuPainelConfiguracoes);

        menuMissoesConfiguracoes =
                findViewById(R.id.menuMissoesConfiguracoes);

        menuConfiguracoesAtual =
                findViewById(R.id.menuConfiguracoesAtual);


        // =====================================================
        // BOTÃO SAIR
        // =====================================================

        btnSairConta = findViewById(R.id.btnSairConta);


        // =====================================================
        // BOTÃO DOS 3 RISCOS
        // =====================================================

        btnMenuConfiguracoes.setOnClickListener(v -> {

            if (drawerLayoutConfiguracoes.isDrawerOpen(GravityCompat.START)) {

                drawerLayoutConfiguracoes.closeDrawer(GravityCompat.START);

            } else {

                drawerLayoutConfiguracoes.openDrawer(GravityCompat.START);
            }

        });


        // =====================================================
        // PAINEL DE CONTROLE
        // =====================================================

        menuPainelConfiguracoes.setOnClickListener(v -> {

            drawerLayoutConfiguracoes.closeDrawer(GravityCompat.START);

            Intent intent = new Intent(
                    Tela_Configuracoes.this,
                    MainActivity.class
            );

            startActivity(intent);

            finish();

        });


        // =====================================================
        // MISSÕES
        // =====================================================

        menuMissoesConfiguracoes.setOnClickListener(v -> {

            drawerLayoutConfiguracoes.closeDrawer(GravityCompat.START);

            Intent intent = new Intent(
                    Tela_Configuracoes.this,
                    Tela_Missoes.class
            );

            startActivity(intent);

            finish();

        });


        // =====================================================
        // CONFIGURAÇÕES
        // =====================================================

        menuConfiguracoesAtual.setOnClickListener(v -> {

            drawerLayoutConfiguracoes.closeDrawer(GravityCompat.START);

        });


        // =====================================================
        // SAIR DA CONTA
        // =====================================================

        btnSairConta.setOnClickListener(v -> {

            // Desconecta a conta do Firebase
            FirebaseAuth.getInstance().signOut();


            // Desativa o "Lembrar login"
            SharedPreferences preferences =
                    getSharedPreferences(
                            PREFS,
                            MODE_PRIVATE
                    );

            preferences.edit()
                    .putBoolean(LEMBRAR_LOGIN, false)
                    .apply();


            // Volta para a tela de login
            Intent intent = new Intent(
                    Tela_Configuracoes.this,
                    Tela_Login.class
            );


            // Apaga as telas anteriores da pilha
            // Assim não é possível apertar "voltar"
            // e entrar novamente no aplicativo.
            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
            );

            startActivity(intent);

            finish();

        });


        // =====================================================
        // BOTÃO VOLTAR DO ANDROID
        // =====================================================

        getOnBackPressedDispatcher().addCallback(
                this,
                new OnBackPressedCallback(true) {

                    @Override
                    public void handleOnBackPressed() {

                        if (drawerLayoutConfiguracoes.isDrawerOpen(
                                GravityCompat.START)) {

                            drawerLayoutConfiguracoes.closeDrawer(
                                    GravityCompat.START
                            );

                        } else {

                            finish();
                        }

                    }
                }
        );

    }
}