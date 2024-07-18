package com.example.exerciciofixacaocomposicao.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem>  itens = new ArrayList();
    public Order(){

    }

    public Order(Date moment, OrderStatus status, Client client ){
        this.moment = moment;
        this.status = status;

    }

    public Date getMoment(){
        return moment;
    }

    public void setMoment(Date moment){
        this.moment = moment;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public List<OrderItem> getItens(){
        return itens;
    }

    public Client getClient(){
        return client;
    }

    public void setClient(Client client){
        this.client = client;
    }
    public void addItem(OrderItem item){
        itens.add(item);
    }
    public void removeItem(OrderItem item){
        itens.remove(item);
    }
    public double total(){
        double sum = 0.0;
        for(OrderItem it : itens){
            sum += it.subTotal();
        }
        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status:");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(client + "\n");
        sb.append("Order items: \n");
        for(OrderItem item : itens){
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }

}
