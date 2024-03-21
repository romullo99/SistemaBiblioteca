import java.util.ArrayList;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int i = 0;

    Scanner entrada = new Scanner(System.in);

    ArrayList<Livro> Livros = new ArrayList<Livro>();
    ArrayList<Emprestimo> Emprestimos = new ArrayList<Emprestimo>();
    ArrayList<Aluno> Alunos = new ArrayList<Aluno>();

    while (i != 5) {
      System.out.println("Aperte 1 para cadastro de livros");
      System.out.println("Aperte 2 para emprestimo de livros");
      System.out.println("Aperte 3 para cadastro de alunos");
      System.out.println("Aperte 4 para devolver livro");
      System.out.println("Aperte 5 para sair");
      i = entrada.nextInt();
      entrada.nextLine();

      if (i == 1) {

        Livro novo = new Livro();

        System.out.println("Qual o nome do livro? ");
        novo.nome = entrada.nextLine();
        System.out.println("Qual o autor do livro? ");
        novo.autor = entrada.nextLine();
        System.out.println("Qual o código do livro? ");
        novo.codigolivro = entrada.nextInt();
        Livros.add(novo);
        System.out.println(("O livro foi cadastrado com sucesso!"));

      } else if (i == 2) {
        System.out.println("Qual o código do livro? ");
        int codigolivro = entrada.nextInt();
        boolean livrocadastrado = false;
        for (int z = 0; z < Livros.size(); z++) {
          Livro cadastrado = Livros.get(z);
          if (cadastrado.codigolivro == codigolivro) {
            livrocadastrado = true;
            break;
          }
        }
        if (livrocadastrado == true) {
          boolean livroemprestado = false;
          for (int j = 0; j < Emprestimos.size(); j++) {
            Emprestimo emprestado = Emprestimos.get(j);
            if (emprestado.codigolivro == codigolivro && emprestado.livroemprestado == true) {
              livroemprestado = true;
              System.out.println("O livro está emprestado");
              break;
            }
          }
          if (livroemprestado == false) {
            System.out.println("Qual é seu código de aluno? ");
            int codigoaluno = entrada.nextInt();
            boolean alunocadastrado = false;

            for (int j = 0; j < Alunos.size(); j++) {
              Aluno cadastro = Alunos.get(j);
              if (cadastro.codigoaluno == codigoaluno) {
                alunocadastrado = true;
                break;
              }
            }
            if (alunocadastrado == true) {
              Emprestimo novo = new Emprestimo();
              novo.codigolivro = codigolivro;
              novo.codigoaluno = codigoaluno;
              novo.livroemprestado = true;
              Emprestimos.add(novo);
              System.out.println("O livro foi emprestado com sucesso!!!");
            } else {
              System.out.println("Aluno não cadastrado");
            }

          }
        } else {
          System.out.println("Livro não cadastrado");
        }
      } else if (i == 3) {
        Aluno novo = new Aluno();
        novo.matriculaaluno = Alunos.size();
        System.out.println("Qual o seu nome? ");
        novo.nome = entrada.nextLine();
        System.out.println("Qual o seu curso? ");
        novo.curso = entrada.nextLine();
        System.out.println("Qual o seu código do aluno? ");
        novo.codigoaluno = entrada.nextInt();
        Alunos.add(novo);
        System.out.println("Aluno foi cadastrado com sucesso!!!");

      } else if (i == 4) {

        System.out.println("Digite o código do livro");
        int codigolivro = entrada.nextInt();
        System.out.println("Qual é seu código de aluno? ");
            int codigoaluno = entrada.nextInt();
            

            for (int j = 0; j < Alunos.size(); j++) {
              Aluno cadastro = Alunos.get(j);
              if (cadastro.codigoaluno == codigoaluno) {
                
                
            for (int g = 0; g < Emprestimos.size(); g++) {
            Emprestimo novo1 = Emprestimos.get(g);
          
          
          if (novo1.codigolivro == codigolivro && novo1.codigoaluno == codigoaluno) {
            if (novo1.livroemprestado == true) {
              novo1.livroemprestado = false;
              Emprestimos.set(g, novo1);
              System.out.println("O livro foi devolvido!");
              break;

            } else {
              System.out.println("O livro não está emprestado");
              break;
            }  
            
          }
        }

      }else System.out.println("Aluno não cadastrado");

    }
  }

}
  }
}