package com.example.uv_carerobot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Tela_Missoes extends AppCompatActivity {

    private DrawerLayout drawerLayoutMissoes;

    private ImageButton btnMenuMissoes;

    private TextView menuPainelMissoes;
    private TextView menuMissoesAtual;
    private TextView menuConfiguracoesMissoes;

    private Button btnNovaMissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_missoes);

        // =====================================================
        // LIGA JAVA COM XML
        // =====================================================

        drawerLayoutMissoes =
                findViewById(R.id.drawerLayoutMissoes);

        btnMenuMissoes =
                findViewById(R.id.btnMenuMissoes);

        menuPainelMissoes =
                findViewById(R.id.menuPainelMissoes);

        menuMissoesAtual =
                findViewById(R.id.menuMissoesAtual);

        menuConfiguracoesMissoes =
                findViewById(R.id.menuConfiguracoesMissoes);

        btnNovaMissao =
                findViewById(R.id.btnNovaMissao);


        // =====================================================
        // BOTÃO DOS 3 RISCOS
        // =====================================================

        btnMenuMissoes.setOnClickListener(v -> {

            if (drawerLayoutMissoes.isDrawerOpen(GravityCompat.START)) {

                drawerLayoutMissoes.closeDrawer(GravityCompat.START);

            } else {

                drawerLayoutMissoes.openDrawer(GravityCompat.START);
            }
        });


        // =====================================================
        // PAINEL DE CONTROLE
        // =====================================================

        menuPainelMissoes.setOnClickListener(v -> {

            drawerLayoutMissoes.closeDrawer(GravityCompat.START);

            Intent intent = new Intent(
                    Tela_Missoes.this,
                    MainActivity.class
            );

            startActivity(intent);

            finish();
        });


        // =====================================================
        // MISSÕES
        // =====================================================

        menuMissoesAtual.setOnClickListener(v -> {

            drawerLayoutMissoes.closeDrawer(GravityCompat.START);

        });


        // =====================================================
        // CONFIGURAÇÕES
        // =====================================================

        menuConfiguracoesMissoes.setOnClickListener(v -> {

            drawerLayoutMissoes.closeDrawer(GravityCompat.START);

            Intent intent = new Intent(
                    Tela_Missoes.this,
                    Tela_Configuracoes.class
            );

            startActivity(intent);

            finish();
        });


        // =====================================================
        // NOVA MISSÃO
        // =====================================================

        btnNovaMissao.setOnClickListener(v -> {

            // Vamos criar a tela de nova missão depois.

        });


        // =====================================================
        // BOTÃO VOLTAR
        // =====================================================

        getOnBackPressedDispatcher().addCallback(
                this,
                new OnBackPressedCallback(true) {

                    @Override
                    public void handleOnBackPressed() {

                        if (drawerLayoutMissoes.isDrawerOpen(
                                GravityCompat.START)) {

                            drawerLayoutMissoes.closeDrawer(
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