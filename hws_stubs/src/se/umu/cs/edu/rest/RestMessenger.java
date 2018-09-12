package se.umu.cs.edu.rest;

import se.umu.cs.edu.messenger.IMessengerImpl;

public class RestMessenger {

    public static IMessengerImpl iMessenger;

    public static IMessengerImpl getInstance(){

            if(iMessenger == null){
                iMessenger = new IMessengerImpl();
            }
            return iMessenger;
        }
    }


