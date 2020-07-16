import conexao.HibernateUtil;
import dao.DaoGerenic;
import model.UsuarioPessoa;
import org.junit.Test;

import java.util.List;

public class TesteHibernate {

    @Test
    public void teste(){

        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();


        UsuarioPessoa usuarioPessoa = new UsuarioPessoa();


        usuarioPessoa.setEmail("J2ose@gmail.com");
        usuarioPessoa.setLogin("admin");
        usuarioPessoa.setNome("Robso2n");
        usuarioPessoa.setSenha("1234");
        usuarioPessoa.setSobreNome("Murilo2");

        daoGerenic.salvar(usuarioPessoa);

    }

    @Test
    public  void testePequisa(){
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();
        UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
        usuarioPessoa.setId(1);

        usuarioPessoa  = daoGerenic.pesquisar(usuarioPessoa);
        System.out.println(usuarioPessoa.toString());


    }
    @Test
    public  void testePequisaComID(){
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();

        UsuarioPessoa usuarioPessoa = daoGerenic.pesquisarComId(3L,UsuarioPessoa.class);
        System.out.println(usuarioPessoa.toString());
    }

    @Test
    public  void testeUpdate(){
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();

        UsuarioPessoa usuarioPessoa = daoGerenic.pesquisarComId(3L,UsuarioPessoa.class);

        usuarioPessoa.setSobreNome("casa");
        daoGerenic.updateMerge(usuarioPessoa);

        System.out.println(usuarioPessoa.toString());
    }

    @Test
    public  void testeDeletar(){
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();

        UsuarioPessoa usuarioPessoa = daoGerenic.pesquisarComId(3L,UsuarioPessoa.class);
       daoGerenic.deleteID(usuarioPessoa);
    }
    @Test
    public void listarTeste(){
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();
        List<UsuarioPessoa> usuarioPessoaList = daoGerenic.listar(UsuarioPessoa.class);

        for (UsuarioPessoa a: usuarioPessoaList) {

            System.out.println(a);
            System.out.println("_______________");

        }

    }


}
