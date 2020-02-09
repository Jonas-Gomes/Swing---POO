package com.ifpb.interfacegrafica.visao;

import com.ifpb.interfacegrafica.dao.UsuarioDaoArquivo;
import com.ifpb.interfacegrafica.modelo.Usuario;
import com.ifpb.interfacegrafica.telas.TelaLogin;

import java.io.IOException;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

//        PrimeiraJanela janela = new PrimeiraJanela();
//        janela.setVisible(true);

        TelaLogin login = new TelaLogin();
        login.setVisible(true);

    }

}
