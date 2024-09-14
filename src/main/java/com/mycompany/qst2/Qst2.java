/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.qst2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Siqueira
 */
public class Qst2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            HashMap<String, String> contatos = new HashMap<>();
            
            // Ler quantidade de contatos
            int qtd = 0;
            while (true) {
                try {
                    System.out.print("Informe quantos contatos você quer cadastrar: ");
                    qtd = scanner.nextInt();
                    scanner.nextLine(); 
                    if (qtd <= 0) {
                        System.out.println("Só é possivel prosseguir se a quantidade inserida for um número positivo.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Inválido. Digite um número inteiro.");
                    scanner.nextLine(); 
                }
            }
            
            // Ler contatos
            for (int i = 0; i < qtd; i++) {
                System.out.print("Insira o nome da pessoa " + (i + 1) + ": ");
                String nome = scanner.nextLine();
                
                String tel = "";
                while (true) {
                    System.out.print("Digite o telefone/celular de " + nome + " (apenas números): ");
                    tel = scanner.nextLine();
                    
                    if (tel.matches("\\d+")) {  // Verificaçao se são apenas digitos
                        break;
                    } else {
                        System.out.println("Numero de telefone inválido. Digite apenas números.");
                    }
                }
                
                contatos.put(nome, tel);
            }
            
            // Verificação telefone
            while (true) {
                System.out.print("Insira o nome da pessoa que você gostaria de verificar o telefone: ");
                String nomeParaVerificar = scanner.nextLine();
                
                if (contatos.containsKey(nomeParaVerificar)) {
                    System.out.println("Telefone de " + nomeParaVerificar + ": " + contatos.get(nomeParaVerificar));
                    break;
                } else {
                    System.out.println("Nome inválido. Tente novamente.");
                }
            }
        }
    }
}
