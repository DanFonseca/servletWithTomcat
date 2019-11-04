package br.com.webApp.servletpt1.modelo;
import br.com.webApp.servletpt1.controler.Nome;
import br.com.webApp.servletpt1.controler.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BD {

    public static ArrayList<Nome> listNomes = new ArrayList<Nome>();
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    private Date dataCadastro;


    public BD (){
        Usuario daniel = new Usuario("daniel", "123");
        usuarios.add(daniel);
    }


    public void adicionarNaLista (Nome nome){

        BD.listNomes.add(nome);
    }

    public List<Nome> getListNomes (){

        return BD.listNomes;
    }

    public Nome getListNomeByID(int index){
        return BD.listNomes.get(index);
    }

    public int getIndex (int id) throws RuntimeException{
        int i = 0;
        for (Nome nome: listNomes) {
            if (listNomes.get(i).getId() == id){
                return i;
            }
            i++;
        }
        return -1;
    }

    public void deletaNome (int index){
        BD.listNomes.remove(index);
    }

    public void editarNome (int index,  String nome, Date data){
            BD.listNomes.set(index, new Nome(nome, data));
    }

    public void adicionarUsuario (String nome, String password){
        Usuario usuario = new Usuario(nome, password);
        usuarios.add(usuario);
    }

    public Usuario verificaLogin (String nome, String passowrd){
        for (Usuario user: usuarios) {
            if (user.getNome().equals(nome) & user.getPassword().equals(passowrd)){
                return user;
            }
        }
        return null;
    }
}
