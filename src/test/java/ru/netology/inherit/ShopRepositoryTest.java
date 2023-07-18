package ru.netology.inherit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Картошка", 50);
        Product product2 = new Product(2, "Помидоры", 80);
        Product product3 = new Product(3, "Лук", 70);
        Product product4 = new Product(4, "Молоко", 100);
        Product product5 = new Product(5, "Книга", 500);
        Product product6 = new Product(6, "Обувь", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.add(product6);

        repo.removeById(5);

        Product[] expected = {product1, product2, product3, product4, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenRemoveProductWhichNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Картошка", 50);
        Product product2 = new Product(2, "Помидоры", 80);
        Product product3 = new Product(3, "Лук", 70);
        Product product4 = new Product(4, "Молоко", 100);
        Product product5 = new Product(5, "Книга", 500);
        Product product6 = new Product(6, "Обувь", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.add(product6);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(7)
        );
    }
}
