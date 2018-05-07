package io.innofang.flyweight.example;

/**
 * Created by Inno Fang on 2017/7/9.
 */
public class Client {

    public static void main(String[] args) {

        MovieTicket movieTicket1 = (MovieTicket) TicketFactory.getTicket("Transformers 5");
        movieTicket1.printTicket("14:00-16:30", "Seat  D-5");
        MovieTicket movieTicket2 = (MovieTicket) TicketFactory.getTicket("Transformers 5");
        movieTicket2.printTicket("14:00-16:30", "Seat  F-6");
        MovieTicket movieTicket3 = (MovieTicket) TicketFactory.getTicket("Transformers 5");
        movieTicket3.printTicket("18:00-22:30", "Seat  A-2");

    }

}
