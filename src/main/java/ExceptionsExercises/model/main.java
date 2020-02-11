package ExceptionsExercises.model;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        /*ExceptionsExercises.model.entities.Pessoa funcionario = new ExceptionsExercises.model.entities.Funcionario("Daniel Melo", 20);
        ExceptionsExercises.model.entities.Pessoa cliente = new ExceptionsExercises.model.entities.Cliente("Salomão Souza", 20);
        funcionario.calculaIdadeEm10Anos();
        cliente.calculaIdadeEm10Anos();
        StringBuffer messageToPrint = new StringBuffer("Idade do ");
        System.out.println(messageToPrint.append("funcionário: ")
                                          .append(funcionario.getIdade()));
        messageToPrint.delete(0, messageToPrint.length());
        System.out.println(messageToPrint.append("cliente: ")
                                          .append(cliente.getIdade()));

        Integer tstInteger = Integer.valueOf("10");

        int tstInt = Integer. parseInt("10");
        if(tstInteger.equals(tstInt)){
            System.out.println("Iguais");
        }
        System.out.println(tstInteger);
        System.out.println(tstInt);*/
        //method1();
        methodFile();
        System.out.println("The ExceptionsExercises.model.main execution is ended");
    }

    public static void method2(){
        System.out.println("***Method 2 has been started***");
        Scanner scanner = new Scanner(System.in);
        try {
            String[] vect = scanner.nextLine().split(" ");
            int position = scanner.nextInt();
            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Posição não existe no vetor");
            e.printStackTrace();
        }
        catch(InputMismatchException e){
            System.out.println("Valor digitado é inválido");
        }
        scanner.close();
        System.out.println("***Method 2 has been ended***");
    }

    public static void method1(){
        System.out.println("***Method 1 has been started***");
        method2();
        System.out.println("***Method 1 has been ended***");
    }

    public static void  methodFile(){
        File file = new File("C:\\temp\\in.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                System.out.println(sc.nextLine());
            }
        }
        catch ( IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }


}
