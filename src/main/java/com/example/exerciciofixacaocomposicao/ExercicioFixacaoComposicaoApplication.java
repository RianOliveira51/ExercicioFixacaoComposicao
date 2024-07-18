package com.example.exerciciofixacaocomposicao;

import com.example.exerciciofixacaocomposicao.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


//Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um sumário do pedido conforme exemplo.
///Nota: o instante do pedido deve ser o instatnte do sistem: new Date.

@SpringBootApplication
public class ExercicioFixacaoComposicaoApplication {

   public static void main(String[] args) throws ParseException {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

      //Dados do client
      String name;
      String email;
      System.out.println("Name: ");
      name = sc.nextLine();
      System.out.println("Email");
      email = sc.nextLine();
      System.out.println("Birth date  DD/MM/YYYY");
      Date birthdate = sdf.parse(sc.next());
      Client client = new Client(name, email, birthdate);

      //Dados do pedido
      System.out.println("Enter order data: ");
      System.out.println("Status");
     OrderStatus status = OrderStatus.valueOf(sc.next());

      Order order = new Order(new Date(), status, client);

      System.out.println("Howm many items to this order? ");
      int items = sc.nextInt();
       sc.nextLine();
      for(int i=0; i < items; i++){
         System.out.println("Enter #" + i + " item data");
         System.out.print("Product name: ");
          sc.nextLine();
         String nameproduct = sc.nextLine();
         System.out.print("Product price: ");
         double price = sc.nextDouble();
         System.out.print("Quantity: ");
         int quantity = sc.nextInt();
         Product product = new Product(nameproduct, price);
         OrderItem orderitem = new OrderItem(quantity,price, product);
         order.addItem(orderitem);

      }

      System.out.println();
      System.out.println(order);

      sc.close();



   }


}
