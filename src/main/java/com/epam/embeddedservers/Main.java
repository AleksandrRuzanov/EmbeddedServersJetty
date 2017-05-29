package com.epam.embeddedservers;

import com.epam.embeddedservers.server.ServerJetty;

/**
 * Created by Aleksandr_Ruzanov on 24.05.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        new ServerJetty(true);
    }
}
