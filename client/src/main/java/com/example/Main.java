package com.example;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader tastiera = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println("Connessione effettuata. Digita ESCI per uscire");
            String rispostaServer;
            String lista = "";
            String elenco = "";
            do{
                System.out.println("Inserisci la nota da memorizzare o digita la LISTA per visualizzare le note salvate");
                String st = in.readLine();
                out. writeBytes(st + "\n");
                rispostaServer = tastiera.readLine();
                if(rispostaServer.equals("1"))
                {
                    System.out.println("LISTA:");
                    elenco = ReadList(lista);
                    out.writeBytes(elenco + "\n");
                }
                else if(rispostaServer.equals("2"))
                {
                    addList(tastiera, lista);
                    System.out.println("Nota salvata");
                }
            }while(Integer.parseInt(rispostaServer) != 3);
            System.out.println("ESCI");
            System.out.println("Disconnessione effettuta");
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore");
            System.exit(1);
        }
    }

    public static void addList(BufferedReader tastiera, String lista)
    {
        lista += "- "  + tastiera;
        
    }

    public static String ReadList(String lista)
    {
        if(lista.isEmpty())
        {
            System.out.println("La lista è ancora vuota, aggiungi un nota");
        }
        else
        {
            System.out.println(lista);
        }
        return lista;
    }
}