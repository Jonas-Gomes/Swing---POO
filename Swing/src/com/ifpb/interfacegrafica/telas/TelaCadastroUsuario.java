package com.ifpb.interfacegrafica.telas;

import com.ifpb.interfacegrafica.dao.UsuarioDaoArquivo;
import com.ifpb.interfacegrafica.dao.UsuarioDaoSet;
import com.ifpb.interfacegrafica.modelo.Usuario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class TelaCadastroUsuario extends JFrame {
    private JTextField campoEmail;
    private JTextField campoNome;
    private JFormattedTextField campoNascimento;
    private JPasswordField campoSenha1;
    private JPasswordField campoSenha2;
    private JButton salvarButton;
    private JPanel painel;
    private UsuarioDaoArquivo usuarioDao;
    private DateTimeFormatter formatter;

    public TelaCadastroUsuario(){
        super("Cadastro de usuário");

        try {
            usuarioDao = new UsuarioDaoArquivo();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Falha na conexão com o arquivo",
                    "Mensagem de erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        setContentPane(painel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();

        salvarButton.addActionListener(e -> {

            //TODO validar os campos
            if(!Arrays.equals(campoSenha1.getPassword(),
                    campoSenha2.getPassword())){
                JOptionPane.showMessageDialog(this,
                        "As senhas devem ser iguais");
            }else if(campoEmail.getText().equals("") ||
                    campoNascimento.getText().equals("")||
                    campoNome.getText().equals("") ||
                    campoSenha1.getPassword().equals("") || campoSenha1.getPassword().equals("")){
                JOptionPane.showMessageDialog(this,"Preencha todos os campos",
                        "Campos Obrigatórios",JOptionPane.ERROR_MESSAGE);
            }else{
                String email = campoEmail.getText();
                String nome = campoNome.getText();

                //TODO Tratar as exceções
                LocalDate nascimento = LocalDate
                        .parse(campoNascimento.getText(), formatter);
                String senha = new String(campoSenha1.getPassword());
                Usuario usuario = new Usuario(email, nome, nascimento, senha);
                if(nascimento.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(this, "Insira uma data válida",
                            "Data invalida", JOptionPane.ERROR_MESSAGE);
                    campoNascimento.setText("");
                }else{
                    try {
                        if(usuarioDao.salvar(usuario)){
                            JOptionPane.showMessageDialog(this,
                                    "Salvo com sucesso");
                        }else{
                            JOptionPane.showMessageDialog(this,
                                    "Usuário já cadastrado",
                                    "Mensagem de erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(this,
                                "Falha na conexão com o arquivo",
                                "Mensagem de erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        MaskFormatter formatter = null;
        try {
             formatter = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        campoNascimento = new JFormattedTextField();
        if(formatter!= null) formatter.install(campoNascimento);

    }

    private void validarCampos(){
        try{

        }catch (DateTimeParseException e){
            JOptionPane.showMessageDialog(this,"vazio");
        }
    }
}
