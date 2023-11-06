package com.example;

import java.io.*;
import java.net.*;

public class ServerThread {
    Socket s;

    public ServerThread(Socket s)
    {
        this.s = s;
    }

    public void run()
    {
        try {
            System.out.println("SERVER PARTITO IN ESECUZIONE...");
            System.out.println("Un client si è connesso");


            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String richiesta;
            do {
                richiesta = in.readLine();
                System.out.println("");
                if(richiesta.equals("@"))
                {
                    System.out.println("1");
                    out.writeBytes("1" + "\n");
                }
                else {
                    System.out.println("2");
                    out.writeBytes("2" + "\n");
                }
            }
            while(!richiesta.equals("Uscita") || !richiesta.equals("ESCI"));
            System.out.println("3");
            out.writeBytes("3" + "\n");
            s.close();
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore");
            System.exit(1);
        }
    }

}

