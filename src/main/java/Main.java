import entity.Category;
import entity.Response;
import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;
import repository.CategoryRepository;
import utils.DbConfig;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

//        System.out.println(CategoryRepository.addCategory());

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Id ni kirit: ");
//        int id = scanner.nextInt();
//        scanner = new Scanner(System.in);
//        System.out.println("Nomini kirit: ");
//        String name = scanner.nextLine();
//        CategoryRepository.addCategory(id,name);

//        System.out.println("Hammasi yaxshi boladi");
//        System.out.println(CategoryRepository.getCategories());


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nomini ni kiriting: ");
//        String name = scanner.nextLine();
//        scanner = new Scanner(System.in);
//        System.out.println("Type ini kirit: ");
//        String type = scanner.nextLine();
//        System.out.println("Yangi nomini kirit: ");
//        String newname = scanner.nextLine();
//
//        Response response = CategoryRepository.callFunction(name, type,newname);
//        System.out.println(response);


        Scanner scanner = new Scanner(System.in);
        System.out.println("ID ni kiriting: ");
        int id = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Name ni kirit: ");
        String name = scanner.nextLine();

        CategoryRepository.addcurrency(id,name);

    }

}
